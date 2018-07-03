package org.fx.jzgl.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.fx.jz.service.JzService;
import org.fx.jzgl.model.JzglModel;
import org.fx.urils.AlertUtil;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class JzglController implements Initializable {

    private AlertUtil alert = new AlertUtil();

    @FXML
    TextField path;
    @FXML
    TableView table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList columns = table.getColumns();
        TableColumn<JzglModel, String> column = (TableColumn<JzglModel, String>) columns.get(0);
        column.setCellValueFactory(new PropertyValueFactory("path"));
        TableColumn<JzglModel, String> column1 = (TableColumn) columns.get(1);
        column1.setCellFactory((col) -> {
            TableCell<JzglModel, String> cell = new TableCell<JzglModel, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        Button button = new Button("打开");
                        button.setOnMouseClicked(o -> {
                            dk(this.getTableView().getItems().get(this.getIndex()).getPath());
                        });
                        Button button2 = new Button("打印");
                        button2.setOnMouseClicked(o -> {
                            dy(this.getTableView().getItems().get(this.getIndex()).getPath());
                        });
                        HBox hBox = new HBox();
                        hBox.setSpacing(5);
                        hBox.getChildren().addAll(button, button2);
                        this.setGraphic(hBox);
                    }
                }
            };
            return cell;
        });
        ObservableList<JzglModel> list = FXCollections.observableArrayList();
        table.setItems(list);
    }

    @FXML
    private void query(MouseEvent event) throws Exception {
        table.setPlaceholder(new Label("正在查询"));
        String text = path.getText();
        if (text == null || text.trim().equals("")) {
            Platform.runLater(() -> {
                alert.f_alert_informationDialog("警告", "请输入路径");
                table.setPlaceholder(new Label("无结果"));
            });
        }
        Task task = new Task<Void>() {
            @Override
            public Void call() {
                if (!isCancelled()) {
                    jg(text);
                }
                return null;
            }
        };
        new Thread(task).start();
    }

    private void jg(String text) {
        List<String> doc = new JzService().findDoc(text);
        List<JzglModel> list = new ArrayList<>();
        doc.forEach(k -> {
            list.add(new JzglModel(k));
        });
        Platform.runLater(() -> {
            table.getItems().addAll(list);
            table.setPlaceholder(new Label("未查询到数据"));
        });
    }

    private void dk(String path) {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start " + path);
        } catch (Exception e) {
            Platform.runLater(() -> {
                alert.f_alert_informationDialog("警告", "文件打开出错");
            });
        }
    }

    private void dy(String path) {
        new JzService().print(path);
    }
}
