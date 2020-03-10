package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.FileUtils;

import java.util.List;

public class RecordButton extends Button {
    private String title;
    private TextField path;
    private List lines;
    private Stage stage;

    public RecordButton(String title, TextField path, List lines, Stage stage) {
        this.title = title;
        this.path = path;
        this.lines = lines;
        this.stage = stage;

        initTitle();
        initAction();
    }

    private void initTitle() {
        setText(title);
    }

    private void initAction() {
        setOnAction(new EventHandler<ActionEvent>( ) {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileUtils.writeAll(path.getText(), lines);
                stage.close();
            }
        });
    }
}