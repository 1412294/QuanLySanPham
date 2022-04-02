/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TaiKhoanDAO;
import entities.Taikhoan;

/**
 *
 * @author Long
 */
public class XuLyTaiKhoan {
    
    private TaiKhoanDAO tkd = new TaiKhoanDAO();
    
    public Integer KiemTraDangNhap(Taikhoan tk)
    {
        Taikhoan tkt;
        tkt=tkd.LayThongTinTaiKhoan(tk.getTenTaiKhoan());
        if(tkt == null)
        {
            return 0;
        }
        else
        {
            if(!tkt.getMatKhau().equals(tk.getMatKhau()))
            {
                return 0;
            }
            else
            {
                SaoChepTaiKhoan(tkt, tk);
                
                if(tkt.getLoaiTaiKhoan().equals("QL"))
                {
                    return 1;
                }
                if(tkt.getLoaiTaiKhoan().equals("NV"))
                {
                    return 2;
                }
                return 0;
            }
        }
    }
    
    private void SaoChepTaiKhoan(Taikhoan tkt,Taikhoan tk)
    {
        tk.setHoTen(tkt.getHoTen());
        tk.setNamSinh(tkt.getNamSinh());
        tk.setDiachi(tkt.getDiachi());
        tk.setGioiTinh(tkt.getGioiTinh());
        tk.setLoaiTaiKhoan(tkt.getLoaiTaiKhoan());
    }
    
}
