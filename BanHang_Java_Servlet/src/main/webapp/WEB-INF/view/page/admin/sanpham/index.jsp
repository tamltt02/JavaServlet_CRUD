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

<div class="mt-5 col-10 offset-1 border border-primary p-2">
    <a
        class="btn btn-success"
        href="${ pageContext.request.contextPath }/admin/sanpham/create">Create</a>

    <table class="table table-strip table-dark mt-3">
        <thead>
        <tr>
            <td>Mã SP</td>
            <td>Tên SP</td>
            <td>NSX</td>
            <td>Màu sắc</td>
            <td>Dòng SP</td>
            <td>Năm BH</td>
            <td>SL tồn</td>
            <td>Giá nhập</td>
            <td>Giá bán</td>
            <td colspan="2">Thao tác</td>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${pageData.content}" var="spham">
            <tr>
                <td>${spham.sanPham.ma}</td>
                <td>${spham.sanPham.ten}</td>
                <td>${spham.nsx.ten}</td>
                <td>${spham.mauSac.ten}</td>
                <td>${spham.dongSanPham.ten}</td>
                <td>${spham.namBaoHanh}</td>
                <td>${spham.soLuongTon}</td>
                <td>${spham.giaNhap}</td>
                <td>${spham.giaBan}</td>
                <td>
                    <a
                            class="btn btn-primary"
                            href="${ pageContext.request.contextPath }/admin/sanpham/edit/${spham.id}">Update</a>
                </td>
                <td>
                    <form action="${ pageContext.request.contextPath }/admin/sanpham/delete/${spham.id}" method="POST">
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-danger"
                                data-bs-toggle="modal" data-bs-target="#exampleModalLong">Delete
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModalLong" tabindex="-1"
                             role="dialog" aria-labelledby="exampleModalLongTitle"
                             aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Xác nhận</h5>
                                        <button type="button" class="close" data-bs-dismiss="modal"
                                                aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        Bạn có muốn xóa không ?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary"
                                                data-bs-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-danger">Save
                                            changes</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <ul class="pagination">
            <c:forEach begin="0" end="${ pageData.totalPages - 1 }" varStatus="page">
                <li class="page-item">
                    <a class="page-link" href="/admin/sanpham/hienthi?page=${ page.index }" > ${ page.index + 1 }</a>
                </li>
            </c:forEach>
        </ul>
    </div>

</div>
