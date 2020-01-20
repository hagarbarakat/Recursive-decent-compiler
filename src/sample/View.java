package sample;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.jfoenix.controls.JFXDrawer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class View implements Initializable {
    @FXML
    TextArea textArea;
    @FXML
    TextArea textArea1;
    File selectedFile;
    @FXML
    JFXDrawer drawer;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textArea1.setVisible(false);
    }
    @FXML
    public void Open(){
        FileChooser fileChooser = new FileChooser();
        selectedFile = fileChooser.showOpenDialog(new Stage());
        fileChooser.setTitle("Open");
        if (selectedFile != null) {
            try {
                textArea.setText(Files.lines(Paths.get(String.valueOf(selectedFile)))
                        .collect(Collectors.joining("\n")));
            } catch (IOException e) {
                e.printStackTrace();
                e.getCause();
            }
        }
    }
    @FXML
    public void Run(){
        textArea1.setText("");

        parser parser= new parser();

        for (String line : textArea.getText().split("\\n")) {
        parser.inputBuffer=line;
        parser.A();
        if (parser.LA=='$'){
            parser.accept();
        }
        textArea1.setVisible(true);
        textArea1.setText(parser.getString().toString());
    }
    }
    @FXML
    public void Close(){
        System.exit(1);
    }


}
