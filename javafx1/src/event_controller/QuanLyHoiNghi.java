/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Thamgiahoinghi;

/**
 *
 * @author DELL
 */
public class QuanLyHoiNghi {
    public static String requestJoinConference ="REQUEST";
    public static String acceptJoinConference ="ACCEPT";
    
    public static int addNewRequestToJoinConference(Thamgiahoinghi thamgiahoinghi){
    Session session=hbn_connection.Controller.getSessionFactory().openSession();
        int condition;
        try {
        Transaction transaction=session.beginTransaction();
        session.save(thamgiahoinghi);
        transaction.commit();
        transaction=null;
            
              condition=  1;
        } catch (Exception e) {
             condition=  -1;
        }
        session.close();
        return condition;
    
    }
    
     public static int acceptRequestToJoinConference(Thamgiahoinghi thamgiahoinghi){
    Session session=hbn_connection.Controller.getSessionFactory().openSession();
        int condition;
        try {
        Transaction transaction=session.beginTransaction();
        session.update(thamgiahoinghi);
        transaction.commit();
        transaction=null;
            
              condition=  1;
        } catch (Exception e) {
             condition=  -1;
        }
        session.close();
        return condition;
    
    }
}
