/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_controller;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.mindrot.jbcrypt.BCrypt;
import pojos.Taikhoan;

/**
 *
 * @author DELL
 */
public class QuanLyTaiKhoanController {
    public int update(Taikhoan taikhoan ){
         
         //Kiểm tra các thuộc tính
         
          return   QuanLyTaiKhoan.update(taikhoan);
   }
    public int changePassword(String newPassword,Taikhoan taikhoan){
       
        newPassword=BCrypt.hashpw(newPassword, BCrypt.gensalt(12));
         taikhoan.setPassword(newPassword); 
       
         return   QuanLyTaiKhoan.update(taikhoan);
        
    }
    
    public int signup(String username,String password,String passwordConfirm){
         
         //Kiểm tra các thuộc tính
        Session session=hbn_connection.Controller.getSessionFactory().openSession();
        int condition;
        
        Criteria criteria=session.createCriteria(pojos.Taikhoan.class);
        criteria.add(Restrictions.eq("username", username));
 

          pojos.Taikhoan  taikhoan=(pojos.Taikhoan)criteria.uniqueResult();
          
          if(taikhoan==null){
              System.out.println("Tên tài khoản OKE đấy");
              if(password.equals(passwordConfirm)){
                  
                  
                  
                  taikhoan=new Taikhoan();
                  String bcryptPassword;
             
                  bcryptPassword=BCrypt.hashpw(password, BCrypt.gensalt(12));
                  taikhoan.setUsername(username);
                  taikhoan.setPassword(bcryptPassword);
                  taikhoan.setLoai("USER");
                  taikhoan.setCaptruycap(QuanLyTaiKhoan.EnableAccount);
                  condition= QuanLyTaiKhoan.signup(taikhoan);
                  
              }else{
              System.out.println("Nhập password 2 lần sai rồi");
                condition= -2;
              }
              
          }else{
              System.out.println("Bạn không thể sử dụng tên tài khoản này/ Vui lòng nhập tên khác!");
                condition= -1;
          }
      
         session.close();
         return condition;

 
 
 
   }   
    public int signin(String username,String password){
        int conditon;
         
         //Kiểm tra các thuộc tính
   
            Session session=hbn_connection.Controller.getSessionFactory().openSession();
             Criteria criteria=session.createCriteria(pojos.Taikhoan.class);
        criteria.add(Restrictions.eq("username", username));
 

          pojos.Taikhoan  taikhoan=(pojos.Taikhoan)criteria.uniqueResult();
          
          if(taikhoan==null){
               System.out.println("Sai tài khoản rồi ông ơi~");
               conditon= -1;
          }else{
              //System.out.println("Bạn không thể sử dụng tên tài khoản này/ Vui lòng nhập tên khác!");
                System.out.println("Tên tài khoản OKE đấy");
                String password2=taikhoan.getPassword();
                System.out.println(password2);
                
                boolean valuate ;
                try {
                   valuate = BCrypt.checkpw(password, password2);
                if(valuate){

                    if(taikhoan.getCaptruycap().toString().equals(QuanLyTaiKhoan.EnableAccount)){

                       conditon= taikhoan.getMa();

                    }else{
                          System.out.println("Tài khoản đã bị vô hiệu cmn hóa~~");
                          conditon= -2;
                    }

                }else{
                    System.out.println("Mật khẩu toang rồi ông ơi");
                    conditon= -1;
                }
              } catch (Exception e) {
                   System.out.println("Lỗi hệ thống");
                    conditon= -3;
              }
                

          }
      //   pojos.Taikhoan  taikhoan=pojos.Taikhoan(1,"Vịnh","bossxomlut","1conchocon","kieuphong2840@gmail.com","1712916","0123123132","admin","oke",null,null,null)
            session.close();
  
        
      
        
       
 
            return conditon;
 
   }  
    public int block(String username,Session s){
         
        Criteria criteria=s.createCriteria(pojos.Taikhoan.class);
        criteria.add(Restrictions.eq("username", username));
        pojos.Taikhoan  taikhoan=(pojos.Taikhoan)criteria.uniqueResult();
        return QuanLyTaiKhoan.block(taikhoan, s);
 
   }  
    public int unBlock(String username,Session s){
         
        Criteria criteria=s.createCriteria(pojos.Taikhoan.class);
        criteria.add(Restrictions.eq("username", username));
        pojos.Taikhoan  taikhoan=(pojos.Taikhoan)criteria.uniqueResult();
        return QuanLyTaiKhoan.unBlock(taikhoan, s);
 
   }  
     
}
