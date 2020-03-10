package windows.base;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class NotePadView extends BorderPane {
    private TextArea ta;
    private MenuBar mb;
    private NotePadViewModel notePadViewModel;

    public NotePadView(NotePadViewModel notePadViewModel) {
        this.ta = new TextArea();
        this.mb = new MenuBar();
        this.notePadViewModel = notePadViewModel;

        initTextArea();
        initMenuBar();

        setTop(mb);
        setCenter(ta);
    }

    private void initMenuBar() {
        Menu file = new Menu("File");

        MenuItem create = new MenuItem("Create");
        create.setOnAction(new EventHandler<ActionEvent>( ) {
            @Override
            public void handle(ActionEvent actionEvent) {
                ArrayList<String> lines = new ArrayList<String>();
                lines.add(ta.getText());
                notePadViewModel.onCreateAndSave(lines, "Create");
            }
        });

        MenuItem open = new MenuItem("Open");
        open.setOnAction(new EventHandler<ActionEvent>( ) {
            @Override
            public void handle(ActionEvent actionEvent) {
                notePadViewModel.onOpen(ta, "Open");
            }
        });

        MenuItem save = new MenuItem("Save");
        save.setOnAction(new EventHandler<ActionEvent>( ) {
            @Override
            public void handle(ActionEvent actionEvent) {
                ArrayList<String> lines = new ArrayList<String>();
                lines.add(ta.getText());
                notePadViewModel.onCreateAndSave(lines, "Save");
            }
        });

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>( ) {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });

        file.getItems().addAll(create, open, save, exit);

        Menu edit = new Menu("Edit");

        MenuItem undo = new MenuItem("Undo");
        undo.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                ta.undo();
            }
        });

        MenuItem cut = new MenuItem("Cut");
        cut.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                ta.cut();
            }
        });

        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                ta.paste();
            }
        });

        MenuItem clear = new MenuItem("Clear");
        clear.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                ta.clear();
            }
        });

        edit.getItems().addAll(undo, cut, paste, clear);

        mb.getMenus().addAll(file, edit);
    }

    private void initTextArea() {
        ta.setPrefRowCount(10);
        ta.setWrapText(true);
        ta.setEditable(true);
    }
}
