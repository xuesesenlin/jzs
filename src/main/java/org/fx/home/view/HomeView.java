package org.fx.home.view;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import static javafx.stage.StageStyle.TRANSPARENT;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class HomeView {

    public void init(Stage primaryStage) throws Exception {
        //设置窗口的图标.
//        primaryStage.getIcons().add(new Image(getClass().getResource("/image/ico.jpg").toExternalForm()));
//        禁止窗口缩放
//        primaryStage.setResizable(false);
//        设置窗口风格
//        1) DECORATED——白色背景，带有最小化/最大化/关闭等有操作系统平台装饰（ 默认设置）
//        2) UNDECORATED——白色背景，没有操作系统平台装饰
//        3) TRANSPARENT——透明背景，没有操作系统平台装饰
//        4) UTILITY——白色背景，只有关闭操作系统平台装饰
//        5) UNIFIED——有操作系统平台装饰，消除装饰和内容之间的边框，内容背景和边框背景一致，（但要视平台支持），可以通过javafx.application.Platform.isSupported(javafx.application.ConditionalFeature)判断
        primaryStage.initStyle(TRANSPARENT);
//        最小化，任务栏可见图标
//        primaryStage.setIconified(true);
//        始终显示在其他窗口之上
//        stage.setAlwaysOnTop(true);
        //添加系统托盘图标.
//        SystemTray tray = SystemTray.getSystemTray();
//        BufferedImage image = ImageIO.read(LoginView.class
//                .getResourceAsStream("orange-ball.png"));
//        TrayIcon trayIcon = new TrayIcon(image, "自动备份工具");
//        trayIcon.setToolTip("自动备份工具");
//        tray.add(trayIcon);

        primaryStage.setTitle("");
//        欢迎语
//        MP3Util mp3Util = new MP3Util();
//        mp3Util.mp3("/mp3/welcome.mp3");
        //        窗口最大化
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        Parent root = FXMLLoader.load(getClass().getResource("/home/fxml/index.fxml"));
//        加载外部css
        Scene scene = primaryStage.getScene();
        scene.setRoot(root);
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("/home/css/index.css").toExternalForm());
        primaryStage.setScene(scene);
//        显示
        primaryStage.show();
    }
}
