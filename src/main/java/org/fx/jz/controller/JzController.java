package org.fx.jz.controller;

import org.fx.urils.AlertUtil;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class JzController {

    private AlertUtil alert = new AlertUtil();

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
