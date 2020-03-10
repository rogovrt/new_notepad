package windows.record;

import buttons.CancelButton;
import buttons.RecordButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class RecordWindowViewModel {
    private Stage stage;
    private String nameForButton;
    private List lines;

    public RecordWindowViewModel(Stage stage, String name, List lines) {
        this.stage = stage;
        this.nameForButton = name;
        this.lines = lines;
    }

    public Button initRecordButton(TextField path) {
        return new RecordButton(nameForButton, path, lines, stage);
    }

    public Button initCancelButton() {
        return new CancelButton("Cancel", stage);
    }
}
