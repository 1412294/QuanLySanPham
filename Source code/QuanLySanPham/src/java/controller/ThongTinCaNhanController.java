/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import static controller.TrangChuController.taikhoan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import entities.*;
import java.util.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Long
 */
@Controller
public class ThongTinCaNhanController {
    
//    @RequestMapping(value = "/trangchu",method = RequestMethod.GET)
//    public String LayThongTinTaiKhoan(ModelMap mm)
//    {
//        mm.addAttribute("tk", new Taikhoan());
//        return "/trangchu";
//    }
    
    @RequestMapping(value = "/thongtincanhan",method = RequestMethod.GET)
    public String HienThiThongTinCaNhan(ModelMap mm)
    {
        Taikhoan tk = taikhoan;
        if(tk.getLoaiTaiKhoan().equals("NV"))
        {
            mm.put("ltk", "Nhân viên");
        }
        else
        {
            if(tk.getLoaiTaiKhoan().equals("QL"))
            {
                mm.put("ltk", "Quản lý");
            }
            else
            {
                
            }
        }
        mm.put("tk", tk);
        return "trangthongtincanhan";
    }
    
}
