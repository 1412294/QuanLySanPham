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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Long
 */
@Controller
public class ThemMoiSanPhamController {
    
    @RequestMapping(value = "/themmoisanpham",method = RequestMethod.GET)
    public String HienThiTrangThemMoi(ModelMap mm)
    {
        mm.addAttribute("sptm", new Sanpham());
        mm.put("dslsp", dslsp);
        return "trangthemmoisanpham";
    }
    
    @RequestMapping(value = "/themmoisanpham",method = RequestMethod.POST)
    public String ThemMoiSanPham(@ModelAttribute(value = "sptm") Sanpham sptm, ModelMap mm,HttpSession session,HttpServletRequest request,HttpServletResponse response)
    {
        response.setContentType("text/html");
        String ChuoiID= request.getParameter("dsloaisanpham");
        Integer idlsp = Integer.parseInt(ChuoiID);
        
        //gán cho sptm
        sptm.setLoaisanpham(TimLoaiSanPham(idlsp));
        
        //lưu sp lại
        if(KiemTraSanPhamDaTonTai(sptm)) //tồn tại 
        {
            mm.put("message", "Sản phẩm có mã này đã tồn tại");
        }
        else //chưa tồn tại
        {
            XuLyDanhSachSanPham xl= new XuLyDanhSachSanPham();
            xl.ThemSanPham(sptm);
            dssp.add(sptm);
            mm.put("message", "Thêm sản phẩm thành công");
        }
        
        mm.put("dslsp", dslsp);
        return "trangthemmoisanpham";
    }
    
    
    private Boolean KiemTraSanPhamDaTonTai(Sanpham sptm)
    {
        for(Sanpham sp: dssp)
        {
            if(sp.getMaSanPham().equals(sptm.getMaSanPham()))
            {
                return true; //nếu tồn tại
            }
        }
        return false; //nếu không tồn tại
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
