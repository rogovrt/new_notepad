package windows.open;

import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class OpenWindowView extends BorderPane {
    private Text t;
    private TextField path;
    private ToolBar tb;
    private OpenWindowViewModel openWindowViewModel;

    public OpenWindowView(OpenWindowViewModel openWindowViewModel) {
        this.t = new Text();
        this.path = new TextField();
        this.tb = new ToolBar();
        this.openWindowViewModel = openWindowViewModel;

        initText();
        initToolbar();

        setTop(t);
        setCenter(path);
        setBottom(tb);
    }

    private void initText() {
        t.setText("Type full path to file:");
        t.setFont(new Font(20));
    }

    private void initToolbar() {
        tb.getItems().addAll(
                openWindowViewModel.initOpenButton(path),
                openWindowViewModel.initCancelButton()
        );
    }
}
