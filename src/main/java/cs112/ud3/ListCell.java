package cs112.ud3;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.time.format.DateTimeFormatter;

public class ListCell extends javafx.scene.control.ListCell<ListItem> {
    private final Label title = new Label();
    private final Label date = new Label();
    private final VBox layout = new VBox(title, date);

    public ListCell() {
        super();
        title.setStyle("-fx-font-size: 20px;");
    }

    @Override
    protected void updateItem(ListItem task, boolean empty) {
        super.updateItem(task, empty);

        if (empty || task == null || task.title == null || task.date == null) {
            title.setText(null);
            date.setText(null);
            setGraphic(null);
        } else {
            title.setText(task.title);

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            String dateFmt = task.date.format(fmt);
            date.setText(dateFmt);

            setGraphic(layout);
        }
    }
}
