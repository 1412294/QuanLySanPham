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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


/**
 *
 * @author Long
 */
@Controller
//@RequestMapping(value = "/taikhoan")
public class DangNhapController {
    
    @RequestMapping(value = "/dangnhap",method = RequestMethod.GET)
    public String KhoiDongTrangDangNhap(ModelMap mm)
    {
        mm.addAttribute("tk", new Taikhoan());
        return "trangdangnhap";
    }
    
    
}
