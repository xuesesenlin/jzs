package org.fx.jz.service;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.fx.urils.GetUuid;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class JzService {

    public void doc(Map<String, String> params) {
        // 获取模板文件
        File templateFile = new File(params.get("demo"));
        ByteArrayOutputStream ostream = null;
        try {
            FileInputStream in = new FileInputStream(templateFile);
            HWPFDocument hwpfDocument = new HWPFDocument(in);
//            替换内容
            Range range = hwpfDocument.getRange();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                range.replaceText(entry.getKey(), entry.getValue());
            }
            ostream = new ByteArrayOutputStream();
            hwpfDocument.write(ostream);

            OutputStream os = new FileOutputStream(params.get("outfile") + params.get("name") + GetUuid.getUUID() + ".doc");
            //把doc输出到输出流中
            hwpfDocument.write(os);
            this.closeStream(os);
            this.closeStream(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭输入流
     *
     * @param is
     */
    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭输出流
     *
     * @param os
     */
    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 打印
     */
    public String print(String path) {
        File file = new File(path);
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
//设置打印格式，因为未确定文件类型，这里选择AUTOSENSE
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
//查找所有的可用打印服务
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
//定位默认的打印服务
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        if (defaultService != null) {
//显示打印对话框
            PrintService service = ServiceUI.printDialog(null, 200, 200, printService, defaultService, flavor, pras);

//        if (service != null) {
//            try {
//                DocPrintJob job = service.createPrintJob(); //创建打印作业
//                FileInputStream fis = new FileInputStream(file); //构造待打印的文件流
//                DocAttributeSet das = new HashDocAttributeSet();
//                Doc doc = new SimpleDoc(fis, flavor, das); //建立打印文件格式
//                job.print(doc, pras); //进行文件的打印
            return "打印完成";
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        } else
            return "请先设置默认的打印机!";
    }

    /**
     * 获取指定路径下的所有doc文件
     *
     * @param path
     * @return
     */
    public List<String> findDoc(String path) {
        List<String> list = new ArrayList<>();
        find(new File(path), list);
        return list;
    }

    /**
     * 获取指定路径下的所有doc文件
     */
    private static void find(File file, List<String> list) {
        File flist[] = file.listFiles();
        for (File f : flist) {
            if (f.isDirectory()) {
                //这里将列出所有的文件夹
                find(f, list);
            } else {
                //这里将列出所有的文件
                String fileName = f.getName();
                String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                if (suffix.equals("doc"))
                    list.add(f.getAbsolutePath());
            }

        }
    }
}
