package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CancelButton extends Button {
    private String title;
    private Stage stage;

    public CancelButton(String title, Stage stage) {
        this.title = title;
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
                stage.close();
            }
        });
    }
}
