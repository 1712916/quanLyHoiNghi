/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class LoginDialogController implements Initializable {

   
    @FXML
    private Button btn_back_to_login;
    @FXML
    private Pane pane_sign_up;
    @FXML
    private Pane pane_sign_in;
    @FXML
    private Button btn_go_to_sign_up;
    @FXML
    private Button btn_login;
    @FXML
    private TextField txtf_username;
 
    @FXML
    private PasswordField passf_password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

 

    @FXML
    private void backToSignin(ActionEvent event) {
        pane_sign_in.toFront();
    }

    @FXML
    private void goToSignUp(ActionEvent event) {
        pane_sign_up.toFront();
    }

    @FXML
    private void login(ActionEvent event) {
        String userName=txtf_username.getText().toString();
        String passWord=passf_password.getText().toString();
        System.out.println("Tài khoản: "+userName);
        System.out.println("Mật khẩu: "+passWord);
        
        
    }
    
}
