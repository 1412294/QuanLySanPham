/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import static controller.TrangChuController.dslsp;
import static controller.TrangChuController.dssp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import entities.*;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Long
 */
@Controller
public class CapNhatThongTinSanPhamConTroller {
    
    private Sanpham spscn;
    
    @RequestMapping(value = "/capnhatsanpham/{masp}",method = RequestMethod.GET)
    public String HienThiTrangCapNhat(@PathVariable(value = "masp") String masp,ModelMap mm)
    {
        
        //tìm ra sản phẩm
        XuLyDanhSachSanPham xl = new XuLyDanhSachSanPham();
        Sanpham sp = xl.LayThongTinSanPham(masp);
        
        mm.put("sp", sp);
        mm.put("dslsp", dslsp);
        return "trangcapnhatthongtinsanpham";
    }
    
//    @RequestMapping(value = "/capnhatsanpham/capnhatsanpham",method = RequestMethod.GET)
//    public String HienThiTrangCapNhatSauKhaiCapNhat(ModelMap mm)
//    {
//
//        mm.put("sp", spscn);
//        mm.put("dslsp", dslsp);
//        return "trangcapnhatthongtinsanpham";
//    }
    
    @RequestMapping(value = "/capnhatsanpham/{masp}",method = RequestMethod.POST)
    public String ThemMoiSanPham(@ModelAttribute(value = "sp") Sanpham sp,@PathVariable(value = "masp") String masp ,ModelMap mm,HttpSession session,HttpServletRequest request,HttpServletResponse response)
    {
        response.setContentType("text/html");
        String ChuoiID= request.getParameter("dsloaisanpham");
        Integer idlsp = Integer.parseInt(ChuoiID);
        
        //gán cho sptm
        sp.setLoaisanpham(TimLoaiSanPham(idlsp));
        
        XuLyDanhSachSanPham xl = new XuLyDanhSachSanPham();
        xl.CapNhatThongTinSanPham(sp);
        
        spscn = sp;
        
        mm.put("sp", sp);
        mm.put("message", "Đã cập nhật thông tin sản phẩm");
        mm.put("dslsp", dslsp);
        return "trangcapnhatthongtinsanpham";
    }
    
    private Loaisanpham TimLoaiSanPham(Integer id)
    {
        for(Loaisanpham lsp: dslsp)
        {
            if(lsp.getId() == id)
            {
                return lsp;
            }
        }
        return null;
    }
}
