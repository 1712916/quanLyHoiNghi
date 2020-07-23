/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import event_controller.QuanLyTaiKhoanController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;
import pojos.Hoinghi;
import pojos.Taikhoan;




/**
 * FXML Controller class
 *
 * @author DELL
 */
public class UserScreenController implements Initializable {

    private Taikhoan taikhoan;
    private Stage stage;
    private Hoinghi hoinghi_1;
    
    @FXML
    private Label lb_username;
    @FXML
    private Button btn_logout;
    @FXML
    private Label lb_hello;
    @FXML
    private TextField txtf_phone;
    @FXML
    private TextField txtf_email;
    @FXML
    private TextField txtf_sex;
    @FXML
    private TextField txtf_name;
    @FXML
    private Button btn_update_profile;
    @FXML
    private Label lb_change_avatar;
    @FXML
    private Button btn_profile;
    private TextField txtf_change_password;
    @FXML
    private Button btn_change_password;
    @FXML
    private PasswordField passf_change_new_password1;
    @FXML
    private PasswordField passf_change_new_password2;
    @FXML
    private Label lb_change_passw_message;
    @FXML
    private PasswordField passf_password;
    @FXML
    private Button btn_conference;
    @FXML
    private TabPane tabp_profile;
    @FXML
    private AnchorPane anchorpn_conference;
    @FXML
    private ListView<Hoinghi> lv_conference;
    private ObservableList<Hoinghi> conferenceObservableList;
    @FXML
    private Label lb_conf_name;
    @FXML
    private Label lb_conf_date;
    @FXML
    private Label lb_conf_number;
    @FXML
    private Label lb_conf_address;
    @FXML
    private Label lb_conf_short_description;
    @FXML
    private Label lb_conf_address1;
    @FXML
    private ImageView imgv_cover_image;
    @FXML
    private Button btn_conf_register;
    @FXML
    private Label lb_conf_joined;
    @FXML
    private Label lb_conf_number1;

    /**
     * Initializes the controller class.
     */
  
    public void setUp(Taikhoan taikhoan,Hoinghi hoinghi_1,Stage stage){
        this.taikhoan=taikhoan;
        this.stage=stage;
        this.hoinghi_1=hoinghi_1;
        lb_hello.setText("Hello "+taikhoan.getTen());
        
        lb_username.setText(taikhoan.getUsername());
        txtf_email.setText(taikhoan.getEmail());
        txtf_name.setText(taikhoan.getTen());
        txtf_phone.setText(taikhoan.getSdt());
        txtf_sex.setText(taikhoan.getGioitinh());
        if(this.hoinghi_1==null){
            System.out.println("NULLLLLLLLLLLLLLLL HOI nghi");
        }else{
             System.out.println("Không nULLLL Rồi");
             Dialog dialog=new Dialog();
            dialog.setTitle("Thông báo");
            dialog.setHeaderText("Bạn cần đăng nhập để thực hiện chức năng này\nChuyển sang trang đăng nhập");

             ButtonType okebButtonType=new ButtonType("Oke",ButtonBar.ButtonData.OK_DONE);

            dialog.getDialogPane().getButtonTypes().addAll(okebButtonType,ButtonType.CANCEL);
            dialog.show();
        
        }
 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     tabp_profile.setVisible(false);
       conferenceObservableList=FXCollections.observableArrayList();
        Session session=hbn_connection.Controller.getSessionFactory().openSession();
        
        Criteria criteria=session.createCriteria(pojos.Hoinghi.class);
        
        List<pojos.Hoinghi> hoinghis=criteria.list();
        
        
        hoinghis.forEach((element) -> {
//                Criteria criteria1=session.createCriteria(pojos.Hoinghi.class);
//                criteria.add(Restrictions.eq("id", element.getDiadiem()));
//                Diadiem diadiem=(Diadiem)criteria1.uniqueResult();
//                    
//                if(diadiem==null){
//                
//                    System.out.println("Không lấy được địa điểm");
//                }else{
//                    
//                    element.setDiadiem(diadiem);
//                }

           System.out.println("Không lấy được địa điểm "+element.getDiadiem().getTen());
                     
                     
        });
        
        System.out.println("This is số lượng: "+hoinghis.size());
        
        conferenceObservableList.addAll(hoinghis);
        lv_conference.setItems(conferenceObservableList);
        
        lv_conference.getSelectionModel().select(1);
      //  lv_conference.getFocusModel().focus(1);
        lv_conference.scrollTo(1);
       //lv_conference.setOn;
        
         updateView(hoinghis.get(1));
        session.close();
        
    } 
    @FXML
    private void onItemClickListener(MouseEvent event) throws FileNotFoundException {
        System.out.println("Đã click");
        Hoinghi hoinghi=lv_conference.getSelectionModel().getSelectedItem();
        if(hoinghi==null){
           //
            System.out.println("Đang ở trạng thái ko có người click LV");
        }else{
                  // ImageView imgv_cover_image;
                
                 updateView(  hoinghi);
                 
              //lb_conf_joined.setText( );  
        }
        
    }
    void updateView(Hoinghi hoinghi){
         
         lb_conf_name.setText(hoinghi.getTen());
                    //Date lb_conf_date;
                lb_conf_number.setText(hoinghi.getSoluongyeucau().toString());
                lb_conf_short_description.setText(hoinghi.getMotangangon());
                 lb_conf_address.setText(hoinghi.getDiadiem().getTen());
                 lb_conf_address1.setText(hoinghi.getDiadiem().getDiachi());
                 
                 //Đường dẫn tuyệt đối
                //FileInputStream input = new FileInputStream(""); 
                //Image image = new Image(input);
              
                //đường dẫn URL
                //Image image = new Image("C:\\Users\\DELL\\Desktop\\103198999_1565687426967360_538555124228417227_o.jpg"); 
               String pathString=hoinghi.getHinhanh();
               if(pathString==null){
               }else{
                   Image image = new Image(getClass().getResourceAsStream(pathString));
                  imgv_cover_image.setImage(image);
 
               }
                
    }

    @FXML
    private void onLogout(ActionEvent event) throws IOException {
   
   
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/LoginScreen.fxml"));
        Parent root =loader.load();
        LoginScreenController loginScreenController=loader.getController();
        loginScreenController.setUp(stage,null);
     
  
 
        Scene scene = new Scene(root);
          stage.setScene(scene);
         stage.show();
        
    }

    @FXML
    private void onUpdateProfile(ActionEvent event) {
        String strName=txtf_name.getText().toString();
        String strSex=txtf_sex.getText().toString();
        String strEmail=txtf_email.getText().toString();
        String strPhone=txtf_phone.getText().toString();
        
        
        taikhoan.setTen(strName);
        taikhoan.setGioitinh(strSex);
        taikhoan.setEmail(strEmail);
        taikhoan.setSdt(strPhone);
        
        QuanLyTaiKhoanController qltkc=new QuanLyTaiKhoanController();
        int condition=qltkc.update(taikhoan);
        if(condition==1){
            //thành công
            System.out.println("Thành công");
        }else{
            //Thất bại
            System.out.println("Toang");
        }
        
       
        
        
        
        
    }

  
 

    @FXML
    private void onChangeAvatar(MouseEvent event) {
            System.out.println("AVATAR BOY");
    }

 
    @FXML
    private void onChangePassword(ActionEvent event) {
        String strPassword=passf_password.getText().toString();
        String strNewPassword1=passf_change_new_password1.getText().toString();
        String strNewPassword2=passf_change_new_password2.getText().toString();
        
         boolean valuate = BCrypt.checkpw(strPassword, taikhoan.getPassword());
         if(valuate){
         
             if(strNewPassword1.equals(strNewPassword2)){
                 QuanLyTaiKhoanController qltkc=new QuanLyTaiKhoanController();
                 qltkc.changePassword(strNewPassword1, taikhoan);
                 lb_change_passw_message.setText("*Thay đổi thành công");
                passf_password.setText("");
                passf_change_new_password1.setText("");
                passf_change_new_password2.setText("");
             }else{
                 lb_change_passw_message.setText("*Mật khẩu mới không khớp");
             
             }
         }else{
                 lb_change_passw_message.setText("*Bạn nhập sai MK hiện tại");
             
         }
        
    }

 


    @FXML
    private void onGoToProfile(ActionEvent event) {
        tabp_profile.setVisible(true);
        tabp_profile.toFront();
        
    }

    @FXML
    private void onGoToConference(ActionEvent event) {
        anchorpn_conference.toFront();
      //  btn_conference.setBackground();
        tabp_profile.setVisible(false);
    }

    @FXML
    private void registerConference(ActionEvent event) throws IOException {
        Dialog dialog=new Dialog();
       FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/DialogRegisterConference.fxml"));
      
        Parent root =loader.load();
        Scene scene = new Scene(root);
         DialogRegisterConferenceController dialogRegisterConferenceController=loader.getController();
         dialogRegisterConferenceController.setUp(lv_conference.getSelectionModel().getSelectedItem(), taikhoan);
        dialog.getDialogPane().setContent(root);
        dialog.show();
         
        
 
    }
    
}
