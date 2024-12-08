package cs112.ud3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("todo-gui.fxml"));
        primaryStage.setTitle("Todo List");
        primaryStage.setScene(new Scene(loader.load(), 900, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {

    }

    @Override
    public void init() throws Exception {

    }
}
