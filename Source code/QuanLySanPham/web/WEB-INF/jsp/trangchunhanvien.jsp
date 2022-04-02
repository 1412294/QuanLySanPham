<%-- 
    Document   : trangchunhanvien
    Created on : Jun 5, 2017, 2:24:41 AM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta charset="utf-8">
            <title>Trang chủ nhân viên</title>
            <link href="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />" rel="stylesheet"  type="text/css" />
            <link href="<c:url value="https://fonts.googleapis.com/css?family=Dancing+Script" />" rel="stylesheet" />
            <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        </head>
        <body style="background-color: #D2D6DE">
            
            <div class="container" style="background-color: whitesmoke">
                <div class="col-md-12">
                    
                    <div class="col-md-2">
                        <h3><b>${ltk}</b></h3>
                    </div>
                    
                    <div class="col-md-2 col-md-offset-5" style="margin-top: 20px">
                        <a href="<%= request.getContextPath() %>/thongtincanhan.html"><i class="fa fa-user"></i> Thông tin cá nhân</a>
                    </div>
                    
                    
                    
                    <div class="col-md-1" style="margin-top: 20px">|</div>
                    
                    <div class="col-md-2" style="margin-top: 20px">
                        <a href="<%= request.getContextPath() %>/dangnhap.html"><i class="fa fa-mail-reply"></i>Đăng xuất</a>
                    </div>
                    <hr width="10px"/><br>
                </div>
                
                <div class="col-md-12">
                    <div class="col-md-6">
                        <h2 style="color: #3C8DBC">Danh sách sản phẩm:</h2>
                    </div>
                </div>
                
                <div class="col-md-12">
                    <table class="table table-striped table-bordered table-hover" style="margin-right: 15px; margin-bottom: 15px; margin-top: 20px">
                        <thead style="color: #00C0EF">
                            <tr style="color: ">
                                <th>Mã sản phẩm</th>
                                <th>Tên sản phẩm</th>
                                <th>Loại sản phẩm</th>
                                <th>Giá (VNĐ)</th>
                                <th>Số lượng tồn kho</th>
                            </tr>
                        </thead>
                        
                        <tbody style=" background-color: #ECF0F5">

                            <c:forEach var="sp" items="${dssp}">
                                <tr>
                                    <td>${sp.maSanPham}</td>
                                    <td>${sp.tenSanPham}</td>
                                    <td>${sp.loaisanpham.loaiSanPham}</td>
                                    <td>${sp.gia}</td>
                                    <td>${sp.soLuongTonKho}</td>
                                </tr>
                            </c:forEach>
                                                        
                        </tbody>
                    </table>
                </div>
            </div>
                    
                       
            <script type="text/javascript" src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" />"></script>
            <script type="text/javascript" src="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js" />"></script>
        </body>
    </html>
</f:view>
