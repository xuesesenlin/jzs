package org.fx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.fx.home.view.HomeView;

/**
 * Hello world!
 */
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new HomeView().init(primaryStage);
    }
}
