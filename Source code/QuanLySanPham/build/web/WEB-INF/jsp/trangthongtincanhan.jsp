<%-- 
    Document   : thongtincanhan
    Created on : Jun 6, 2017, 2:27:20 PM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang thông tin cá nhân</title>
        <link href="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />" rel="stylesheet"  type="text/css" />
            <link href="<c:url value="https://fonts.googleapis.com/css?family=Dancing+Script" />" rel="stylesheet" />
            <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
    </head>
    <body style="background-color: #D2D6DE">
        
        <div class="container" style="background-color: whitesmoke">
                <div class="col-md-12">
                    
                    <div class="col-md-3">
                        <h1><b style="color: blue">XIN CHÀO</b></h1>
                    </div>
                                        
                    <div class="col-md-2 col-md-offset-7" style="margin-top: 30px">
                        <a href="<%= request.getContextPath() %>/dangnhap.html"><i class="fa fa-mail-reply"></i>Đăng xuất</a>
                    </div>
                    <hr width="1px"/><br>
                </div>
                     
        </div>
        
        <div class="col-md-4 col-md-offset-4" style="background-color: whitesmoke; margin-top: 5px">
            <div class="col-md-12">
                <div class="col-md-12" style="background-color: #ECF0F5">
                    <div class="panel panel-info" style="margin-top: 20px">
                        <div class="panel-heading" style="background-color: ">
                            <h4><b>Thông tin cá nhân</b></h4>
                        </div>
                        
                        <div class="panel-body">
                            
                            <div class="col-md-4">
                                <b>Tên tài khoản:</b>
                            </div>
                            
                            <div class="col-md-8">
                                ${tk.tenTaiKhoan}
                            </div>
                            
                            <div class="col-md-4">
                                <b>Họ tên:</b>
                            </div>
                            
                            <div class="col-md-8">
                                ${tk.hoTen}
                            </div>
                            
                            <div class="col-md-4">
                                <b>Chức vụ:</b>
                            </div>
                            
                            <div class="col-md-8">
                                ${ltk}
                            </div>
                            
                            <div class="col-md-4">
                                <b>Năm sinh:</b>
                            </div>
                            
                            <div class="col-md-8">
                                ${tk.namSinh}
                            </div>
                            
                            <div class="col-md-4">
                                <b>Giới tính:</b>
                            </div>
                            
                            <div class="col-md-8">
                                ${tk.gioiTinh}
                            </div>
                            
                            <div class="col-md-4">
                                <b> Địa chỉ:</b>
                            </div>
                            
                            <div class="col-md-8">
                                ${tk.diachi}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                     
        </div>        
        
        <script type="text/javascript" src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" />"></script>
            <script type="text/javascript" src="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js" />"></script>
    </body>
</html>
