package cs112.ud3;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;

public class TaskController {
    @FXML
    TextField titleInput;

    @FXML
    TextField dateInput;

    @FXML
    ComboBox<String> priorityChooser;

    @FXML
    Label error;

    @FXML
    Button create;

    public void initialize(ListView<ListItem> taskList) {
        error.setTextFill(Color.RED);

        // Run when the "Create Task" button is clicked
        create.setOnMouseClicked(ev -> {
            // Check if all fields are filled out
            if (titleInput.getText().isEmpty() || dateInput.getText().isEmpty() || priorityChooser.getValue() == null) {
                error.setText("Must provide all fields");
            } else {
                try {
                    // Add the task to the task list
                    taskList.getItems().add(new Task(titleInput.getText(), dateInput.getText(), priorityChooser.getValue()));

                    // Close the popup
                    Stage stage = (Stage) titleInput.getScene().getWindow();
                    stage.close();
                } catch (Exception e) {
                    // Only throws an error when date cannot be parsed, since the priority must be valid
                    error.setText("Unable to parse date.");
                }
            }
        });
    }
}
