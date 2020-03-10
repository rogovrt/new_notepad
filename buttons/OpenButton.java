package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.FileUtils;

import java.util.List;

public class OpenButton extends Button {
    private String title;
    private TextArea ta;
    private TextField path;
    private Stage stage;

    public OpenButton(String title, TextArea ta, TextField path, Stage stage) {
        this.title = title;
        this.ta = ta;
        this.path = path;
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
                List<String> lines = FileUtils.readAll(path.getText());
                ta.setText(lines.get(0) + '\n');
                int index = lines.get(0).length() + 1;
                for (int i = 1; i < lines.size(); ++i) {
                    ta.insertText(index, lines.get(i) + '\n');
                    index += lines.get(i).length() + 1;
                }
                stage.close();
            }
        });
    }
}
