package org.fx.jz.controller;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.fx.jz.service.JzService;
import org.fx.urils.AlertUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class JzController {

    private AlertUtil alert = new AlertUtil();

    //保存并生成doc文件
    public void save(MouseEvent event) {
        Map<String, String> map = new HashMap<>();
        map.put("${1}", "标题");
        map.put("${2}", "内容");
        new JzService().doc(map);
    }

    public void reset(MouseEvent event) {
        Parent root = FXRobotHelper.getStages().get(0).getScene().getRoot();
        AnchorPane node = (AnchorPane) root.lookup("#jz_index");
        ObservableList<Node> nodes = node.getChildren();
        nodes.forEach(k -> {
            VBox vBox = (VBox) k;
            ObservableList<Node> nodes1 = vBox.getChildren();
            nodes1.forEach(j -> {
                HBox hBox = (HBox) j;
                ObservableList<Node> nodes2 = hBox.getChildren();
                nodes2.forEach(m -> {
                    String s = m.getTypeSelector();
                    if (s.equals("TextField")) {
                        TextField textField = (TextField) m;
                        textField.setText("");
                    }
                });
            });
        });

    }
}
