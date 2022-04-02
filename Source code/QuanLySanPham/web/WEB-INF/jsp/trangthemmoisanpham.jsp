<%-- 
    Document   : trangchuquanly
    Created on : Jun 5, 2017, 2:25:06 AM
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
            <title>Trang thêm mới sản phẩm</title>
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
                    
                <div>    
                    <div class="col-md-12">
                        <div class="col-md-6">
                            <h2 style="color: #3C8DBC">Thêm mới sản phẩm:</h2>
                        </div>
                    </div>
                    
                    <div class="col-md-12" style="border: solid">
                        <div class="col-md-2">
                            <b>Mã sản phẩm:</b>
                        </div>
                        
                        <div class="col-md-4">
                            <b>Tên sản phẩm:</b>
                        </div>
                        
                        <div class="col-md-2">
                            <b>Loại sản phẩm:</b>
                        </div>
                        
                        <div class="col-md-2">
                            <b>Giá(VNĐ)</b>
                        </div>
                        
                        <div class="col-md-2">
                            <b>Số lượng:</b>
                        </div>
                        
                        <form:form method="post" commandName="sptm" action="themmoisanpham.html">
                            <div class="col-md-1 ">
                                <form:input path="maSanPham"/>
                            </div>
                            
                            <div class="col-md-4 col-md-offset-1">
                                <form:input path="tenSanPham"/>
                            </div>
                            
                            <div class="col-md-2">
                                <select name="dsloaisanpham">
                                    <c:forEach var="lsp" items="${dslsp}">
                                    
                                        <option value=${lsp.id} >${lsp.loaiSanPham}</option>
                                    </c:forEach>
                                </select>
                                
                            </div>
                            
                            <div class="col-md-2">
                                <form:input path="gia"/>
                            </div>
                            
                            <div class="col-md-2">
                                <form:input path="soLuongTonKho"/>
                            </div>
                            
                            <div class="col-md-3 col-md-offset-8" style="margin-top: 10px">
                                <h5 style="color: red">${message}</h5>
                            </div>
                            
                            <div class="col-md-1" style="margin-top: 10px; margin-bottom: 5px">
                                <input type="submit" value="Thêm"><br>
                            </div>
                        </form:form>
                        
                    </div>
                </div>
                
            </div>
                    
                       
            <script type="text/javascript" src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" />"></script>
            <script type="text/javascript" src="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js" />"></script>
        </body>
    </html>
</f:view>
