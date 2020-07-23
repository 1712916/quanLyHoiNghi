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
import pojos.Taikhoan;

/**
 *
 * @author DELL
 */
public class QuanLyTaiKhoan {
   public static String EnableAccount ="OKE";
   public static String DisableAccount ="BLOCK";
   public static int update(Taikhoan taikhoan){
        Session session=hbn_connection.Controller.getSessionFactory().openSession();
        int condition;
        try {
        Transaction transaction=session.beginTransaction();
        session.update(taikhoan);
        transaction.commit();
        transaction=null;
            
              condition=  1;
        } catch (Exception e) {
             condition=  -1;
        }
        session.close();
        return condition;
   }
    
   
    public static int signup(Taikhoan taikhoan){
         
        Session session=hbn_connection.Controller.getSessionFactory().openSession();
        try {
            Transaction transaction=session.beginTransaction();
            session.save(taikhoan);
            transaction.commit();
            session.close();
            transaction=null;
              return  1;
        } catch (Exception e) {
             return  -1;
        }
      
       
       

 
 
 
   }  
      public static int block(Taikhoan taikhoan,Session s){
         
        
        try {
            Transaction transaction=s.beginTransaction();
            taikhoan.setCaptruycap(DisableAccount);
            s.save(taikhoan);
            transaction.commit();
            transaction=null;
              return  1;
        } catch (Exception e) {
             return  -1;
        }
   }  
      
      public static int unBlock(Taikhoan taikhoan,Session s){
         
        
        try {
            Transaction transaction=s.beginTransaction();
            taikhoan.setCaptruycap(EnableAccount);
            s.save(taikhoan);
            transaction.commit();
            transaction=null;
              return  1;
        } catch (Exception e) {
             return  -1;
        }
      
       
       

 
 
 
   }  
}