package org.fx.home.controller;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import org.fx.jz.view.JzView;
import org.fx.jzgl.view.JzglView;
import org.fx.urils.AlertUtil;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class HomeController {

    private AlertUtil alert = new AlertUtil();

    //    关闭程序
    @FXML
    private void close(MouseEvent event) {
        boolean b = alert.f_alert_confirmDialog("警告", "是否确定退出");
        if (b) {
            //            停止所有线程
            System.exit(0);
        }
    }

    //    最小化程序
    @FXML
    private void hide(MouseEvent event) {
        FXRobotHelper.getStages().get(0).setIconified(true);
    }

    @FXML
    private void jz(MouseEvent event) throws Exception {
        new JzView().init();
    }

    @FXML
    private void jzgl(MouseEvent event) throws Exception {
        new JzglView().init();
    }


//    private void ss_data() {
//        try {
//            Parent root = FXRobotHelper.getStages().get(0).getScene().getRoot();
//            TableView tableView = (TableView) root.lookup("#order_table");
//            Label label = (Label) root.lookup("#pageNow");
//            if (tableView != null) {
//                if (DdglController.ddlx == 0) {
//                    ResponseResult<String> result = orderInterface.page(0, 15, 0, StaticToken.getToken());
//                    if (result.isSuccess()) {
//                        String json = result.getData().substring(0, result.getData().lastIndexOf("]") + 1);
//                        try {
//                            List<OrderModel> beanList = objectMapper.readValue(json, new TypeReference<List<OrderModel>>() {
//                            });
//                            String s = result.getData().substring(result.getData().lastIndexOf("]") + 1, result.getData().length());
//                            StaticToken.setToken(s);
//                            tableView.getItems().clear();
//                            tableView.getItems().addAll(beanList);
//                            label.setText("1");
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
