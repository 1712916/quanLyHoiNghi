/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import event_controller.QuanLyTaiKhoan;
import event_controller.QuanLyTaiKhoanController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx1.Main;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojos.Hoinghi;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class LoginScreenController implements Initializable {

    private Stage stage;
    private Hoinghi hoinghi;
    @FXML
    private Button btn_skip_login;
    @FXML
    private Button btn_go_to_register;
    @FXML
    private Pane pane_register;
    @FXML
    private Pane pane_login;
    @FXML
    private Button btn_back_to_login;
    @FXML
    private Button btn_login;
    @FXML
    private PasswordField pasf_password;
    @FXML
    private TextField txtf_username;
    @FXML
    private Label lb_message;
    @FXML
    private Button btn_register;
    @FXML
    private TextField txtf_rg_username;
    @FXML
    private Label lb_rg_message;
    @FXML
    private PasswordField passf_rg_password1;
    @FXML
    private PasswordField passf_rg_password2;
    
    
    public void setUp(Stage stage,Hoinghi hoinghi){
        
         this.stage=stage;
         this.hoinghi=hoinghi;
         
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void skipLogin(ActionEvent event) throws IOException {
 
        Parent root;  
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/GuestScreen.fxml"));
      
        
        root = loader.load();  
        
          
        GuestScreenController guestScreenController= loader.getController();
        guestScreenController.setUp(this.stage);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToRegister(ActionEvent event) {
        pane_register.toFront();
        
    }
    @FXML
    private void goToLogin(ActionEvent event) {
        pane_login.toFront();
        
    }

    @FXML
    private void onLogin(ActionEvent event) throws IOException {
        String strUsername;
        String strPassword;
        QuanLyTaiKhoanController qltkc=new QuanLyTaiKhoanController();
        int condition;
        strUsername=txtf_username.getText().toString();
        strPassword=pasf_password.getText().toString();
 
        try {
             condition=qltkc.signin(strUsername, strPassword);
            if(condition<0){
         lb_message.setText("*Sai mật khẩu hoặc tài khoản");
        }else{
            try {
                 checkPermission(condition);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Lỗi ở phân quyền");
            }
           
        }
            
        } catch (Exception e) {
               lb_message.setText("*Không thể kết nối tới Database");
        }
       
    
        
    }
    
     private void checkPermission(int id ) throws IOException{
      
 
        Session session=hbn_connection.Controller.getSessionFactory().openSession();
     
        Criteria criteria=session.createCriteria(pojos.Taikhoan.class);
        criteria.add(Restrictions.eq("id", id));
        
        pojos.Taikhoan  taikhoan=(pojos.Taikhoan)criteria.uniqueResult();
        session.close();
        Parent root;  
        Scene scene;
        if(taikhoan.getLoai().equals("ADMIN")){
        
          
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/AdminScreen.fxml"));
            
            root = loader.load();  
            
           
              scene = new Scene(root);
           
           
        }else{
            // Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/UserScreen.fxml"));

            root = loader.load();  
            
            UserScreenController userScreenController= loader.getController();
            userScreenController.setUp(taikhoan,hoinghi,this.stage);
            
              scene = new Scene(root);
              scene.getStylesheets().add(getClass().getResource("/css/fullpackstyling.css").toExternalForm());
               
            
            //stage.setScene(scene);
            //stage.show();
        }
 
        this.stage.setScene(scene);
        this.stage.show();
        
      
 
    }  

    

  

    @FXML
    private void onRegister(ActionEvent event) {
       
         
        String strUsername;
        String strPassword1;
        String strPassword2;
        QuanLyTaiKhoanController qltkc=new QuanLyTaiKhoanController();
        
        strUsername=txtf_rg_username.getText().toString();
        strPassword1=passf_rg_password1.getText().toString();
        strPassword2=passf_rg_password2.getText().toString();
        
        //Thêm điều kiện độ dài và thành phần của tài khoản/mật khẩu
        
        int condition=qltkc.signup(strUsername, strPassword1, strPassword2);
        
        if(condition>0){
             lb_rg_message.setText("* Oke ngon rồi bạn ơi");
        }else if(condition==-1){
             lb_rg_message.setText("*Vui lòng sử dụng tên tài khoản khác");
        }
        else if(condition==-2){
             lb_rg_message.setText("*Mật khẩu không khớp");
        }
    }

    @FXML
    private void onRegister(MouseEvent event) {
    }

   
    
}
