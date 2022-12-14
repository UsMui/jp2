package multipageBook.member.edit;

import multipageBook.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField txtName;
    public TextField txtCode;
    public TextField txtEmail;
    public Text errors;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtName.setText(multipageBook.member.list.Controller.editMember.getName());
        txtCode.setText(String.valueOf(multipageBook.member.list.Controller.editMember.getCode()));
        txtEmail.setText(multipageBook.member.list.Controller.editMember.getEmail());
        txtCode.setEditable(false);
    }

    public void goToList(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("List Member");
        Main.bookStage.setScene(listScene);
    }

    public void editMember(ActionEvent actionEvent) {
        try{
            errors.setVisible(false);
            if(txtName.getText().isEmpty()){
                throw new Exception("Vui lòng nhập tên member");
            }
            if(!txtEmail.getText().contains("@")||txtEmail.getText().startsWith("@")||txtEmail.getText().endsWith("@")){
                throw new Exception("Vui lòng nhập 1 email");
            }
            multipageBook.member.list.Controller.editMember.setName(txtName.getText());
            multipageBook.member.list.Controller.editMember.setEmail(txtEmail.getText());
            goToList(null);

        }catch (Exception e){
            errors.setVisible(true);
            errors.setText(e.getMessage());

        }
    }
    public void goToMain(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../../main.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("Main");
        Main.bookStage.setScene(listScene);
    }
}
