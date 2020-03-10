package windows.base;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import windows.open.OpenWindowView;
import windows.open.OpenWindowViewModel;
import windows.record.RecordWindowView;
import windows.record.RecordWindowViewModel;

import java.util.List;

public class NotePadViewModel {
    private Stage stage;

    public NotePadViewModel(Stage stage) {
        this.stage = stage;
    }

    public void onCreateAndSave(List lines, String nameForButtonAndStage) {
        Stage stage = new Stage();
        RecordWindowView recordWindowView =
                new RecordWindowView(new RecordWindowViewModel(stage, nameForButtonAndStage, lines));
        Scene scene = new Scene(recordWindowView, 300, 200);
        stage.setTitle(nameForButtonAndStage);
        stage.setScene(scene);
        stage.show();
    }

    public void onOpen(TextArea ta, String nameForButtonAndStage) {
        Stage stage = new Stage();
        OpenWindowView openWindowView =
                new OpenWindowView(new OpenWindowViewModel(stage, ta, nameForButtonAndStage));
        Scene scene = new Scene(openWindowView, 300, 200);
        stage.setTitle(nameForButtonAndStage);
        stage.setScene(scene);
        stage.show();
    }
}
