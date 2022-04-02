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
public class LoaiSanPhamDAO {
    public List<Loaisanpham> layDanhSachLoaiSanPham() {
        List<Loaisanpham> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
        String hql = "from Loaisanpham";
        Query query = session.createQuery(hql);
        ds = query.list();
        } catch (HibernateException ex) {
        //Log the exception
        System.err.println(ex);
        } 
        return ds;
    }
    
}
