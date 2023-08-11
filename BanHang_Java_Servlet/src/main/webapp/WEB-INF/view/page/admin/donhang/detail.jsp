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


<div class="mt-5 col-10 offset-1 p-2">
    <table class="table table-strip table-hover mt-3">
        <thead>
        <tr>
            <td>Ảnh</td>
            <td>Mã SP</td>
            <td>Tên SP</td>
            <td>NSX</td>
            <td>Màu sắc</td>
            <td>Dòng SP</td>
            <td>Năm BH</td>
            <td>SL </td>
            <td>Dơn giá </td>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${listhdct}" var="hd">

            <tr>
                <td><img src="${ pageContext.request.contextPath }/img/${hd.chiTietSanPham.moTa}" alt="" width="50px"></td>
                <td>${hd.chiTietSanPham.sanPham.ma}</td>
                <td>${hd.chiTietSanPham.sanPham.ten}</td>
                <td>${hd.chiTietSanPham.nsx.ten}</td>
                <td>${hd.chiTietSanPham.mauSac.ten}</td>
                <td>${hd.chiTietSanPham.dongSanPham.ten}</td>
                <td>${hd.chiTietSanPham.namBaoHanh}</td>
                <td>${hd.soLuong}</td>
                <td>${hd.donGia}</td>


            </tr>
        </c:forEach>
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
        </tbody>
    </table>
    <a
            class="btn btn-primary"
            href="${ pageContext.request.contextPath }/admin/donhang/hienthi">Quay lại</a>
    </div>
</div>
