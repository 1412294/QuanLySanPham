<%-- 
    Document   : trangdangnhap
    Created on : Jun 5, 2017, 1:30:58 AM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
            <meta charset="utf-8">
            <title>Trang đăng nhập</title>
            <link href="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />" rel="stylesheet"  type="text/css" />
            <link href="<c:url value="https://fonts.googleapis.com/css?family=Dancing+Script" />" rel="stylesheet" />

    </head>
    <body style="background-color: #D2D6DE">
        <div class="container">
            <div class="col-md-6 col-md-offset-3" style="background-color: white; margin-top: 50px">
                
                <div class="col-md-12" style="font-style: initial; margin-top: 20px; margin-bottom: 20px;background-color: #D2D6DE;color: blue;text-align: center">
                    <h1><i><u><b>QL SẢN PHẨM</b></u></i></h1>
                </div>
                
                <div class="col-md-12" style="border: solid;margin-bottom: 10px">
                    <form:form method="post" commandName="tk" action="trangchu.html">
                        
                            <div class="col-md-11 col-md-offset-1" style="margin-top: 10px">
                                <b class="col-md-3 col-md-offset-1">Tài khoản:</b>
                                <div class="col-md-8">
                                    <form:input path="TenTaiKhoan"/><br>
                                </div>
                            </div>

                            <div class="col-md-11 col-md-offset-1" style="margin-top: 10px">
                                <b class="col-md-3 col-md-offset-1">Mật khẩu:</b>
                                <div class="col-md-8">
                                    <form:password path="MatKhau" /><br>
                                </div>
                            </div>
                                
                                <div class="col-md-6 col-md-offset-5" style="margin-top: 15px">
                                    <input type="submit" value="Đăng nhập"><br>  
                                </div>
                                
                                <div class="col-md-8 col-md-offset-4" style="color: red; margin-top: 5px">
                                    ${message}
                                </div>
                                    
                    </form:form>
                </div> 
            </div>           
        </div>

        <script type="text/javascript" src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js" />"></script>
    </body>
</html>

