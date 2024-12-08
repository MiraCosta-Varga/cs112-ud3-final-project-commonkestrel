package cs112.ud3;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ReminderController {
    @FXML
    TextArea description;

    @FXML
    TextField titleInput;

    @FXML
    TextField dateInput;

    @FXML
    Label error;

    @FXML
    Button create;

    public void initialize(ListView<ListItem> taskList) {
        error.setTextFill(Color.RED);

        // Run when the "Create Reminder" button is clicked
        create.setOnMouseClicked(ev -> {
            // Check if all fields are filled out
            if (titleInput.getText().isEmpty() || dateInput.getText().isEmpty() || description.getText().isEmpty()) {
                error.setText("Must provide all fields");
            } else {
                try {
                    LocalDate date = LocalDate.parse(dateInput.getText());

                    // Add the reminder to the task list
                    taskList.getItems().add(new Reminder(titleInput.getText(), date, description.getText()));

                    // Close the popup
                    Stage stage = (Stage) titleInput.getScene().getWindow();
                    stage.close();
                } catch (Exception e) {
                    error.setText("Unable to parse date.");
                }
            }
        });
    }
}
