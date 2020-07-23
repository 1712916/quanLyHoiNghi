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
public class QuanLyHoiNghiController {
    
    public  int addNewRequestToJoinConference(Thamgiahoinghi thamgiahoinghi){
        return QuanLyHoiNghi.addNewRequestToJoinConference(thamgiahoinghi);
    
    }
    
}
