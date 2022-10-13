package library;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HomeController {
    public void goToBookList(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("book/list/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void goToStudentList(ActionEvent actionEvent) throws Exception {
        Parent listStudent = FXMLLoader.load(getClass().getResource("students/list/list.fxml"));
        Main.rootStage.setTitle("Students");
        Main.rootStage.setScene(new Scene(listStudent,800,600));
    }
}