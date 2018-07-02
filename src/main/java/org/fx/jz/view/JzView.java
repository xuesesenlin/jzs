package org.fx.jz.view;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.fx.jz.controller.JzController;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class JzView {

    public void init() throws Exception {
        Parent root = FXRobotHelper.getStages().get(0).getScene().getRoot();
        Parent root2 = FXMLLoader.load(getClass().getResource("/jz/fxml/index.fxml"));
        AnchorPane lookup = (AnchorPane) root.lookup("#bodys");
        AnchorPane node = (AnchorPane) root2.lookup("#jz_index");
        node.setPrefWidth(lookup.getWidth());
        node.setPrefHeight(lookup.getHeight());
        node.getStylesheets().add(getClass().getResource("/jz/css/index.css").toExternalForm());
        node.getChildren().add(index());
        lookup.getChildren().clear();
        lookup.getChildren().addAll(root2);
    }

    //    初始化项目
    private VBox index() {
        VBox vBox = new VBox();
//        第一行
        HBox hBox1 = new HBox();
        hBox1.getStyleClass().add("hbox");
        Label label1_1 = new Label("测试:");
        label1_1.getStyleClass().add("font");
        TextField textField1_2 = new TextField();
        textField1_2.getStyleClass().add("font");
        textField1_2.setPrefWidth(700);
        hBox1.getChildren().addAll(label1_1, textField1_2);
        vBox.getChildren().addAll(hBox1);
        //        第二行
        HBox hBox2 = new HBox();
        hBox2.getStyleClass().add("hbox");
        Label label2_1 = new Label("测试:");
        label2_1.getStyleClass().add("font");
        TextField textField2_2 = new TextField();
        textField2_2.getStyleClass().add("font");
        textField2_2.setPrefWidth(700);
        hBox2.getChildren().addAll(label2_1, textField2_2);
        vBox.getChildren().addAll(hBox2);

//        按钮
        HBox hBoxBottom = new HBox();
        hBoxBottom.setPadding(new Insets(5));
        Button save = new Button("保存");
        save.getStyleClass().add("font");
        Insets insets = new Insets(0, 10, 0, 0);
        save.setPadding(insets);
        save.setOnMouseClicked(o -> {
            new JzController().save(o);
        });
        Button reset = new Button("重置");
        reset.getStyleClass().add("font");
        Insets insets2 = new Insets(0, 10, 0, 0);
        reset.setPadding(insets2);
        reset.setOnMouseClicked(o -> {
            new JzController().reset(o);
        });
        hBoxBottom.getChildren().addAll(save, reset);
        vBox.getChildren().add(hBoxBottom);
        return vBox;
    }
}
