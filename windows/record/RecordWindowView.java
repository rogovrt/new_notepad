package windows.record;

import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class RecordWindowView extends BorderPane {
    private Text t;
    private TextField path;
    private ToolBar tb;
    private RecordWindowViewModel recordWindowViewModel;

    public RecordWindowView(RecordWindowViewModel recordWindowViewModel) {
        this.t = new Text();
        this.path = new TextField();
        this.tb = new ToolBar();
        this.recordWindowViewModel = recordWindowViewModel;

        initText();
        initToolBar();

        setTop(t);
        setCenter(path);
        setBottom(tb);
    }

    void initText() {
        t.setText("Type full path to file:");
        t.setFont(new Font(20));
    }

    void initToolBar() {
        tb.getItems().addAll(
                recordWindowViewModel.initRecordButton(path),
                recordWindowViewModel.initCancelButton()
        );
    }
}
