package org.fx.jzgl.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.fx.jz.service.JzService;
import org.fx.urils.AlertUtil;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class JzglController {

    private AlertUtil alert = new AlertUtil();

    @FXML
    TextField path;
    @FXML
    TableView table;

    @FXML
    private void query(MouseEvent event) throws Exception {
        Platform.runLater(() -> {
            String text = path.getText();
            if (text == null || text.trim().equals("")) {
                alert.f_alert_informationDialog("警告", "请输入路径");
            } else {
                List<String> list = new JzService().findDoc(text);

            }
        });
    }
}
