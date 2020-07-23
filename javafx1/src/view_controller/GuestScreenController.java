/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojos.Diadiem;
import pojos.Hoinghi;
import pojos.Taikhoan;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class GuestScreenController implements Initializable {
    private Stage stage;
    
    

 private Label label;
    @FXML
    private ListView<Hoinghi> lv_conference;
    private ObservableList<Hoinghi> conferenceObservableList;
    @FXML
    private ImageView imgv_cover_image;
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
    private Button btn_conf_register;
    @FXML
    private Label lb_conf_joined;
    @FXML
    private Label lb_conf_address1;
    @FXML
    private Label lb_conf_number1;
 
 
 
 public void setUp(Stage stage){
    this.stage=stage;
 }
    @FXML
    private Button btn_dang_nhap;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
        
        
        
        
        
        // TODO
    }    

    private void showDialogLogin(ActionEvent event) throws IOException {
        
//        Dialog loginDialog=new Dialog();
//        
//      
//      
//        ButtonType loButtonType=new ButtonType("Login",ButtonBar.ButtonData.OK_DONE);
//        loginDialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
//   
//        Parent root = FXMLLoader.load(getClass().getResource("LoginDialog.fxml"));
//        
//        Scene scene = new Scene(root);
//        loginDialog.getDialogPane().setContent(root);
//        loginDialog.show();
//        
//        Button  btnDangNhap;
//        btnDangNhap= (Button) scene.lookup("#btn_login");
//        btnDangNhap.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event1) {
//                TextField txtf_username=(TextField)scene.lookup("#txtf_username");
//                
//                PasswordField passf_password=(PasswordField)scene.lookup("#passf_password");
//                 String userName=txtf_username.getText().toString();
//                String passWord=passf_password.getText().toString();
//                System.out.println("Tài khoản: "+userName);
//                System.out.println("Mật khẩu: "+passWord);
//                
//                if(true){
//                        loginDialog.close();
//                        changeStage(event,"UserScreen.fxml",userName);
//                }else{
//                    Label lb_message_1=(Label)scene.lookup("#lb_message_1");
//                    lb_message_1.setText("***Tài khoản hoặc mật khẩu sai");
//                }
//           
//      
//    
//
//
//            }
//        });
 
        
        
    }
    
    private void changeStage(ActionEvent event,String fileFXML,Taikhoan taikhoan){
//       Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
//        Parent root;        
//       try {
//           FXMLLoader loader=new FXMLLoader();
//           loader.setLocation(getClass().getResource(fileFXML)); 
//           root = loader.load();
//            Scene scene = new Scene(root);
//            UserScreenController userScreenController=loader.getController();
//            userScreenController.setUp(taikhoan);
//           stage.setScene(scene);
//           stage.show();
//           //Chuyen data o day
//
//       } catch (IOException ex) {
//          // Logger.getLogger(Windown1Controller.class.getName()).log(Level.SEVERE, null, ex);
//       }
//                
    }

    @FXML
    private void toLoginScreen(ActionEvent event) throws IOException {

        Parent root;  
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/LoginScreen.fxml"));
      

        root = loader.load();  
        LoginScreenController loginScreenController=loader.getController();
        loginScreenController.setUp(stage,null);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
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
    double getScaleXRatio()
{ 
  return imgv_cover_image.getBoundsInParent().getWidth()/imgv_cover_image.getImage().getWidth();
}

double getScaleYRatio()
{ 
  return imgv_cover_image.getBoundsInParent().getHeight()/imgv_cover_image.getImage().getHeight();
}

    @FXML
    private void requestLogin(ActionEvent event) {
        Dialog dialog=new Dialog();
        dialog.setTitle("Thông báo");
        dialog.setHeaderText("Bạn cần đăng nhập để thực hiện chức năng này\nChuyển sang trang đăng nhập");
        
         ButtonType okebButtonType=new ButtonType("Oke",ButtonBar.ButtonData.OK_DONE);
       
        dialog.getDialogPane().getButtonTypes().addAll(okebButtonType,ButtonType.CANCEL);
        
        dialog.setResultConverter(dialogButton ->{
        
            if(dialogButton==okebButtonType){
                 Parent root;  
                FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/LoginScreen.fxml"));

                try {  
                    root = loader.load();
                     LoginScreenController loginScreenController=loader.getController();
                    loginScreenController.setUp(stage,lv_conference.getSelectionModel().getSelectedItem());
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(GuestScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                
            }
            return null;
           
        });
        
        dialog.show();
    }
    
    
}
