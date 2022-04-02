/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoaiSanPhamDAO;
import entities.Loaisanpham;
import java.util.List;

/**
 *
 * @author Long
 */
public class XuLyDanhSachLoaiSanPham {
    
    private LoaiSanPhamDAO lspd = new LoaiSanPhamDAO();
    
    public List<Loaisanpham> LayDanhSachLoaiSanPham()
    {
        return lspd.layDanhSachLoaiSanPham();
    }
    
    
    
}
