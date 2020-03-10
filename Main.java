import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import windows.base.NotePadView;
import windows.base.NotePadViewModel;

public class Main extends Application {


    public void start(Stage primaryStage) throws Exception{
        NotePadView notePadView = new NotePadView(new NotePadViewModel(primaryStage));
        Scene scene = new Scene(notePadView, 640, 480);
        primaryStage.setTitle("Notepad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
