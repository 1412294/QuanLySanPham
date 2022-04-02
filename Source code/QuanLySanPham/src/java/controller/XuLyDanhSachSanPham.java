/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SanPhamDAO;
import java.util.List;
import entities.*;

/**
 *
 * @author Long
 */
public class XuLyDanhSachSanPham {
    
    private SanPhamDAO spd = new SanPhamDAO();
    
    public List<Sanpham> LayDanhSachSanPham()
    {
        List<Sanpham> ds = spd.layDanhSachSanPham();
        return ds;
    }
    
    public void CapNhatThongTinSanPham(Sanpham sp)
    {
        spd.CapNhatThongTinSanPham(sp);
    }
    
    public void ThemSanPham(Sanpham sp)
    {
        spd.ThemSanPham(sp);
    }
    
    public void XoaSanPham(Sanpham sp)
    {
        spd.XoaSanPham(sp);
    }
    
    public Sanpham LayThongTinSanPham(String masp)
    {
        return spd.LayThongTinCuaSanPham(masp);
    }
    
}
