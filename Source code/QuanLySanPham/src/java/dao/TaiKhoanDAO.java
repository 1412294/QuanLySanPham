/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.*;
import org.hibernate.*;
import entities.*;

/**
 *
 * @author Long
 */
public class TaiKhoanDAO {
    
    public Taikhoan LayThongTinTaiKhoan(String TenTaiKhoan) 
    {
        Taikhoan tk = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
        tk = (Taikhoan) session.get(Taikhoan.class, TenTaiKhoan);
        } catch (HibernateException ex) {
        //Log the exception
        System.err.println(ex);
        } finally {
        session.close();
        }
        return tk;
    }
}
