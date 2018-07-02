package org.fx.jz.service;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.fx.urils.GetUuid;

import java.io.*;
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

}
