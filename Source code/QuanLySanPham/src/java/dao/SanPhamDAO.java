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
public class SanPhamDAO {
    
    public List<Sanpham> layDanhSachSanPham() {
        List<Sanpham> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
        String hql = "from Sanpham";
        Query query = session.createQuery(hql);
        ds = query.list();
        } catch (HibernateException ex) {
        //Log the exception
        System.err.println(ex);
        } 
        return ds;
    }
    
    public static Sanpham LayThongTinSanPham(String MaSP) 
    {
        Sanpham sp = null;
        Session session = HibernateUtil.getSessionFactory()
        .openSession();
        try {
        sp = (Sanpham) session.get(Sanpham.class, MaSP);
        } catch (HibernateException ex) {
        //Log the exception
        System.err.println(ex);
        } 
        return sp;
    }
    
    public Sanpham LayThongTinCuaSanPham(String MaSP) 
    {
        Sanpham sp = null;
        Session session = HibernateUtil.getSessionFactory()
        .openSession();
        try {
        sp = (Sanpham) session.get(Sanpham.class, MaSP);
        } catch (HibernateException ex) {
        //Log the exception
        System.err.println(ex);
        } 
        return sp;
    }
    
    public boolean CapNhatThongTinSanPham(Sanpham sp) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SanPhamDAO.LayThongTinSanPham(sp.getMaSanPham()) == null) {
        return false;
        }
        Transaction transaction = null;
        try {
        transaction = session.beginTransaction();
        session.update(sp);
        transaction.commit();
        } catch (HibernateException ex) {
        //Log the exception
        transaction.rollback();
        System.err.println(ex);
        } 
        return true;
    }
    
     public boolean ThemSanPham(Sanpham sp) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SanPhamDAO.LayThongTinSanPham(sp.getMaSanPham())!=null) {
            return false;
        }
        
        Transaction transaction = null;
        try {
        transaction = session.beginTransaction();
        session.save(sp);
        transaction.commit();
        } catch (HibernateException ex) {
        //Log the exception
        transaction.rollback();
        System.err.println(ex);
        }
        return true;
    }
     
     public boolean XoaSanPham(Sanpham sp) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SanPhamDAO.LayThongTinSanPham(sp.getMaSanPham())==null) {
            return false;
        }
        
        Transaction transaction = null;
        try {
        transaction = session.beginTransaction();
        session.delete(sp);
        transaction.commit();
        } catch (HibernateException ex) {
        //Log the exception
        transaction.rollback();
        System.err.println(ex);
        }
        return true;
    }
}
