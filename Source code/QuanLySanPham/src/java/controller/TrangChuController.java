/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import entities.*;
import java.util.*;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Long
 */
@Controller
public class TrangChuController {
    
    static Taikhoan taikhoan;
    static List<Loaisanpham> dslsp;
    static List<Sanpham> dssp;
    
    
    @RequestMapping(value = "/trangchu",method = RequestMethod.POST)
    public String XuLyDangNhap(@ModelAttribute(value = "tk") Taikhoan tk, ModelMap mm,HttpSession session)
    {
        //kiểm tra và phân loại tài khoản
        XuLyTaiKhoan xltk= new XuLyTaiKhoan();
        
        Integer test = xltk.KiemTraDangNhap(tk);
           
        taikhoan = tk;
        
        if(test == 0)
        {
            mm.put("message", "Tài khoản không hợp lệ!");
            return "trangdangnhap";
        }
        else
        {
            //lấy danh sách sản phẩm
            XuLyDanhSachSanPham xldssp=new XuLyDanhSachSanPham();   
            dssp = xldssp.LayDanhSachSanPham();
            
            mm.put("dssp", dssp);
            
            if(test == 1)
            {
                //lấy danh sách loại sản phẩm hiện có
                XuLyDanhSachLoaiSanPham xldslsp = new XuLyDanhSachLoaiSanPham();
                dslsp = xldslsp.LayDanhSachLoaiSanPham();
                
                mm.put("tk", tk);
                mm.put("ltk","Quản lý");
                return "trangchuquanly";
            }
            else
            {
                if(test == 2)
                {
                    mm.put("tk", tk);
                    mm.put("ltk","Nhân viên");
                    
                    return "trangchunhanvien";
                }
                else
                {
                    return "";
                }
            }
        }
    }
    
    @RequestMapping(value = "/xoamotsanpham/{masp}",method = RequestMethod.GET)
    public String XoaMotSanPham(@PathVariable(value = "masp") String masp,ModelMap mm)
    {
        XuLyDanhSachSanPham xldssp = new XuLyDanhSachSanPham();
        XuLyDanhSachLoaiSanPham xldslsp = new XuLyDanhSachLoaiSanPham();
        
        Sanpham sp =xldssp.LayThongTinSanPham(masp);
        
        sp=LayRaSPTuongUng(sp);
                
        xldssp.XoaSanPham(sp);
        dssp.remove(sp);
        
        mm.put("dssp", dssp);
        mm.put("tk", taikhoan);
        mm.put("ltk","Quản lý");
        return "trangchuquanly"; 
    }
    
    @RequestMapping(value="/xoanhieusanpham", method = RequestMethod.POST)
    public String XoaNhieuSanPham(@RequestParam(value = "idsp", required = false) String[] idsp,ModelMap mm)
    {
        
        XuLyDanhSachSanPham xldssp = new XuLyDanhSachSanPham();
        XuLyDanhSachLoaiSanPham xldslsp = new XuLyDanhSachLoaiSanPham();
        
        if(idsp!=null && idsp.length>0) 
        {
            for(int i=0;i<idsp.length;i++)
            {
                Sanpham sp =xldssp.LayThongTinSanPham(idsp[i]);
                
//                List<Loaisanpham> dslsp = xldslsp.LayDanhSachLoaiSanPham();
//                
//                Loaisanpham lsp = LayRaLoaiSanPhamTuongUng(dslsp, sp);
//                
//                sp.setLoaisanpham(lsp);

                sp=LayRaSPTuongUng(sp);
                
                xldssp.XoaSanPham(sp);
                dssp.remove(sp);
            }
            mm.put("message", "Đã xóa các sản phẩm được chọn");
        }
        
        
        mm.put("dssp", dssp);
        mm.put("tk", taikhoan);
        mm.put("ltk","Quản lý");
        return "trangchuquanly";
    }
    
    private Sanpham LayRaSPTuongUng(Sanpham sp)
    {
        for(Sanpham spt: dssp)
        {
            if(spt.getMaSanPham().equals(sp.getMaSanPham()))
            {
                return spt;
            }
        }
        return null;
    }
    
    
    
}
