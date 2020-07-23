/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import view_controller.LoginScreenController;

/**
 *
 * @author DELL
 */
public class Main extends Application {
 
    @Override
    public void start(Stage stage) throws Exception {
   
        
        //check co luu tai khoan ko
        //Neu co thi kiem tra tai khoan
            //Neu mat khau oke thi vao man hinh
            
        //Neu khong thi mo login
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/LoginScreen.fxml"));
        Parent root =loader.load();
        LoginScreenController loginScreenController=loader.getController();
        loginScreenController.setUp(stage,null);
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                    hbn_connection.Controller.getSessionFactory().close();
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
