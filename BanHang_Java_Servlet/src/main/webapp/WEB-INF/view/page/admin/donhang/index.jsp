<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/30/2023
  Time: 1:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light px-5">
    <a class="navbar-brand" href="#">Navbar</a>

    <div class="collapse navbar-collapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/admin/sanpham/hienthi">Sản Phẩm</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/donhang/hienthi">Đơn hàng</a>
            </li>
        </ul>
    </div>
</nav>
<div class="mt-5 col-10 offset-1">
    <form
            method="POST"
            action="${ pageContext.request.contextPath }/admin/donhang/search">
        <input type="hidden" name="_method" value="put"/>
        <div class="row">
            <div class="col-6">

                <div class="form-group mt-3">
                    <label >Tên , Mã</label>
                    <input type="text"  class="form-control" id="ten" name="name" />
                </div>
            </div>
            <div class="col-6">

                <div class="form-group mt-3">
                    <label >Trạng thái:</label>
                    <select  name="status" class="form-control">
                            <option value="1">Chưa thanh toán</option>
                            <option value="0">Đã thanh toán</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-group mt-3">
            <button class="btn btn-primary">Add</button>
            <button type="reset" class="btn btn-danger">Clear</button>
        </div>
    </form>
</div>

<div class="mt-5 col-10 offset-1 border border-primary p-2">

    <table class="table table-strip table-hover mt-3">
        <thead>
        <tr>

            <td>Tên NV</td>
            <td>Tên KH</td>
            <td>Ngày tạo</td>
            <td>Ngày TT</td>
            <td>Ngày ship</td>
            <td>Ngày nhận</td>
            <td>Tình trạng</td>
            <td>Tên nhận </td>
            <td>Địa chỉ</td>
            <td>SĐT</td>
            <td colspan="2">Thao tác</td>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${listhd}" var="hd">
            <tr>
                <td>${hd.nhanVien.hoTen}</td>
                <td>${hd.khachHang.hoTen}</td>
                <td>${hd.ngayTao}</td>
                <td>${hd.ngayThanhToan}</td>
                <td>${hd.ngayShip}</td>
                <td>${hd.ngayNhan}</td>
                <td>${hd.tinhTrang == 0 ? "Đã thanh toán" : "Chưa thanh toán"}</td>
                <td>${hd.tenNguoiNhan}</td>
                <td>${hd.diaChi}</td>
                <td>${hd.sdt}</td>
                <td>
                    <a type="button" class="btn btn-primary"
                        href="/admin/donhang/${hd.id}">Detail
                    </a>
                </td>

            </tr>
<%--            <div class="modal fade" id="exampleModalLong">--%>
<%--                <div class="modal-dialog modal-dialog-centered" role="document">--%>
<%--                    <div class="modal-content">--%>
<%--                        <div class="modal-header">--%>
<%--                            <h5 class="modal-title" >HDCT</h5>--%>
<%--                            <button type="button" class="close" data-bs-dismiss="modal"--%>
<%--                                    aria-label="Close">--%>
<%--                                <span aria-hidden="true">&times;</span>--%>
<%--                            </button>--%>
<%--                        </div>--%>
<%--                        <div class="modal-body">--%>

<%--                            <input type="text"--%>
<%--                                   class="form-control"  name="id" value="${hd.id}" />--%>
<%--                            Số lượng : ${hd.soLuong} <br>--%>
<%--                            Đơn giá : ${hd.donGia} <br>--%>

<%--                        </div>--%>
<%--                        <div class="modal-footer">--%>
<%--                            <button type="button" class="btn btn-secondary"--%>
<%--                                    data-bs-dismiss="modal">Close</button>--%>

<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </c:forEach>
        </tbody>
    </table>

    <div>
    </div>
</div>
