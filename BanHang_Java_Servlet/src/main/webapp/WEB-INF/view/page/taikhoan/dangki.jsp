<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/30/2023
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container" style="width: 800px">
    <h2 style="text-align: center">TẠO TÀI KHOẢN</h2>
    <form:form
            modelAttribute="userDTO"
            method="POST"
            action="${ pageContext.request.contextPath }/dangki/store">
        <div class="form-group mt-3">
            <div class="form-group mb-3">
                <label for="hoTen">Họ tên</label>
                <form:input path="hoTen" class="form-control" id="email" name="email" autocomplete="off"/>
                <form:errors path="hoTen" element="span" cssClass="text-danger"/>
            </div>
            <div class="form-group mb-3">
                <label for="username">UserName</label>
                <form:input path="username" class="form-control" id="email" name="email" autocomplete="off"/>
                <form:errors path="username" element="span" cssClass="text-danger"/>
            </div>
            <div class="form-group mb-3">
                <label for="email">Email</label>
                <form:input path="email" class="form-control" autocomplete="off"/>
                <form:errors path="email" element="span" cssClass="text-danger"/>
            </div>
            <div class="form-group mb-3">
                <label for="diaChi">Địa chỉ</label>
                <form:input path="diaChi" class="form-control" autocomplete="off"/>
                <form:errors path="diaChi" element="span" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group mb-3">
            <label for="matKhau">Password</label>
            <form:password path="matKhau" name="password" class="form-control"/>
            <form:errors path="matKhau" element="span" cssClass="text-danger"/>
        </div>
        <div class="form-group mb-3">
            <label for="sdt">SĐT</label>
            <form:input path="sdt" name="sdt" class="form-control"/>
            <form:errors path="sdt" element="span" cssClass="text-danger"/>
        </div>
        <div class="form-group mb-3">
            <label for="ngaySinh">Ngày sinh</label>
            <form:input type="date" path="ngaySinh" name="ngaySinh" class="form-control" required="true" />
            <form:errors path="ngaySinh" element="span" cssClass="text-danger"/>

        </div>

        <div class="form-group mb-3">
            <button class="btn btn-danger">Đăng kí</button>
            <button type="reset" class="btn btn-danger">Clear</button>
        </div>
    </form:form>
</div>

<br/>

