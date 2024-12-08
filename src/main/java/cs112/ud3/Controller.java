package cs112.ud3;

import javafx.application.Platform;
// import javafx.beans.property.BooleanProperty;
// import javafx.beans.property.SimpleBooleanProperty;
// import javafx.beans.property.SimpleStringProperty;
// import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Controller {
    @FXML
    ListView<ListItem> taskList;

    @FXML
    VBox selectedTask;

    @FXML
    public void reminderPopup(ActionEvent ev) throws IOException {
        // Load "reminder-gui.fxml"
        FXMLLoader loader = new FXMLLoader(getClass().getResource("reminder-gui.fxml"));
        Parent root = loader.load();

        // Give the task list to the popup
        ReminderController controller = loader.getController();
        controller.initialize(taskList);

        // Create the modal
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Create Reminder");
        stage.show();
    }

    @FXML
    public void taskPopup(ActionEvent ev) throws IOException {
        // Load "task-gui.fxml"
        FXMLLoader loader = new FXMLLoader(getClass().getResource("task-gui.fxml"));
        Parent root = loader.load();

        // Give the task list to the popup
        TaskController controller = loader.getController();
        controller.initialize(taskList);

        // Create the modal
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Create Task");
        stage.show();

    }

    public void initialize() {
        // Initialize the task list with the proper display callback
        taskList.setCellFactory(param -> new ListCell());

        taskList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ListItem>() {
            @Override
            public void changed(ObservableValue<? extends ListItem> observable, ListItem oldValue, ListItem newValue) {
                Label title = new Label(newValue.getTitle());
                title.setStyle("-fx-font-size: 40px;");

                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                String dateFmt = newValue.date.format(fmt);
                Label date = new Label(dateFmt);

                if (newValue instanceof Task newTask) {
                    Label priority = new Label(newTask.getPriority());
                    switch (newTask.getPriority()) {
                        case "High":
                            priority.setTextFill(Color.RED);
                            break;
                        case "Medium":
                            priority.setTextFill(Color.ORANGE);
                            break;
                        default:
                        case "Low":
                            priority.setTextFill(Color.YELLOW);
                            break;
                    }

                    selectedTask.getChildren().setAll(title, date, priority);
                } else if (newValue instanceof Reminder newReminder) {
                    TextArea description = new TextArea(newReminder.getDescription());
                    description.setEditable(false);

                    selectedTask.getChildren().setAll(title, date, description);
                }
            }
        });
    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }
}
