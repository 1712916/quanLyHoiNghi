/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import event_controller.QuanLyHoiNghi;
import event_controller.QuanLyHoiNghiController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojos.Hoinghi;
import pojos.Taikhoan;
import pojos.Thamgiahoinghi;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class DialogRegisterConferenceController implements Initializable {
    
    private Hoinghi hoinghi;
    private Taikhoan taikhoan;  

    @FXML
    private Label lb_date_conference;
    @FXML
    private Label lb_name_conference;
    @FXML
    private Label lb_address_conference;
    @FXML
    private TextField txtf_name_register;
    @FXML
    private TextField txtf_phone_register;
    @FXML
    private TextField txtf_email_register;
    @FXML
    private Button btn_register;
    @FXML
    private Button btn_camcel;
    

    @FXML
    private Label lb_message;

    
    /**
     * Initializes the controller class.
     */
      public void setUp(Hoinghi hoinghi,Taikhoan taikhoan){
          this.hoinghi=hoinghi;
          this.taikhoan=taikhoan;
          setView();
    }
    
    private void setView(){
        if(hoinghi!=null){
            lb_name_conference.setText(hoinghi.getTen());
            //lb_date_conference.
            lb_address_conference.setText(hoinghi.getDiadiem().getDiachi());
        }
        if(taikhoan!=null){
            txtf_name_register.setText(taikhoan.getTen());
            txtf_phone_register.setText(taikhoan.getSdt());
            txtf_email_register.setText(taikhoan.getEmail());
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
         
    }

    public DialogRegisterConferenceController() {
    }

  
    
    @FXML
    private void onRegister(ActionEvent event) {
       String strName;
       String strPhone;
       String strEmail;
       
       strName=txtf_name_register.getText();
       strPhone=txtf_phone_register.getText();
       strEmail=txtf_email_register.getText();
       
       if(strPhone.equals("")){
       lb_message.setText("*Vui lòng nhập sdt của bạn");
           return;
       }
        if(strName.equals("")){
         lb_message.setText("*Vui lòng nhập tên của bạn");
          return;
       } 
        Thamgiahoinghi thamgiahoinghi=new Thamgiahoinghi(hoinghi,taikhoan,QuanLyHoiNghi.requestJoinConference,strName,strPhone,strEmail);
        QuanLyHoiNghiController qlhnctl=new QuanLyHoiNghiController();
        qlhnctl.addNewRequestToJoinConference(thamgiahoinghi);
        
        Dialog dialog=new Dialog();
        
        dialog.setTitle("Thông báo");
        dialog.setHeaderText("Đã gửi đăng ký");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
        dialog.show();
        
        onCancel(event);
        
        
  }
    @FXML
    private void onCancel(ActionEvent event) {
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
                
    }

    private Object getScene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
