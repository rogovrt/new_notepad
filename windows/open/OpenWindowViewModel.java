package windows.open;

import buttons.CancelButton;
import buttons.OpenButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class OpenWindowViewModel {
    private Stage stage;
    private TextArea ta;
    private String name;

    public OpenWindowViewModel(Stage stage, TextArea ta, String name) {
        this.stage = stage;
        this.ta = ta;
        this.name = name;
    }

    public Button initOpenButton(TextField path) {
        return new OpenButton(name, ta, path, stage);
    }

    public Button initCancelButton() {
        return new CancelButton("Cancel", stage);
    }
}
