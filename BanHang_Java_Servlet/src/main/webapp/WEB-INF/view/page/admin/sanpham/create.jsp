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
    <form:form
            modelAttribute="spDTO"
            method="POST"
            action="${ pageContext.request.contextPath }/admin/sanpham/store" enctype="multipart/form-data">
        <input type="hidden" name="_method" value="put"/>
        <div class="row">
            <div class="col-6">
                <div class="form-group mt-3">
                    <label for="sanPham">Tên Sp</label>
                    <form:select path="sanPham.id" id="sanPham" class="form-control">
                            <form:options  items="${dssp}" itemLabel="ten" itemValue="id"></form:options>
                    </form:select>
                    <form:errors path="sanPham.id" element="span" cssClass="text-danger"/>
                </div>
                <div class="form-group mt-3">
                    <label for="nsx">Nsx</label>
                    <form:select path="nsx.id" id="nsx" class="form-control">
                            <form:options  items="${nsxs}" itemLabel="ten" itemValue="id"></form:options>
                    </form:select>
                    <form:errors path="nsx.id" element="span" cssClass="text-danger"/>
                </div>
                <div class="form-group mt-3">
                    <label for="mauSac">Màu Sắc</label>
                    <form:select path="mauSac.id" id="mauSac" class="form-control">
                            <form:options  items="${mauSacs}" itemLabel="ten" itemValue="id"></form:options>
                    </form:select>
                    <form:errors path="mauSac.id" element="span" cssClass="text-danger"/>
                </div>
                <div class="form-group mt-3">
                    <label for="dongSanPham">Dòng sản phẩm</label>
                    <form:select path="dongSanPham.id" id="dongSanPham" class="form-control">
                            <form:options items="${dongSanPhams}" itemLabel="ten" itemValue="id"></form:options>
                    </form:select>
                    <form:errors path="dongSanPham" element="span" cssClass="text-danger"/>
                </div>

            </div>
            <div class="col-6">
                <div class="form-group mt-3">
                    <label for="namBaoHanh">Năm Bảo hành</label>
                    <form:input path="namBaoHanh" class="form-control" id="email" name="email" autocomplete="off"/>
                    <form:errors path="namBaoHanh" element="span" cssClass="text-danger"/>
                </div>
                <div class="form-group mt-3">
                    <label for="soLuongTon">Sô lượng tồn</label>
                    <form:input path="soLuongTon" name="soLuongTon" class="form-control"/>
                    <form:errors path="soLuongTon" element="span" cssClass="text-danger"/>
                </div>
                <div class="form-group mt-3">
                    <label for="giaNhap">Giá nhập</label>
                    <form:input path="giaNhap" name="giaNhap" class="form-control"/>
                    <form:errors path="giaNhap" element="span" cssClass="text-danger"/>
                </div>
                <div class="form-group mt-3">
                    <label for="giaBan">Giá bán</label>
                    <form:input path="giaBan" name="giaBan" class="form-control"/>
                    <form:errors path="giaBan" element="span" cssClass="text-danger"/>
                </div>
                <div class="form-group mt-3">
                    <label for="moTa">Image</label>
                    <form:input path="moTa" type="file"  name="moTa" class="form-control"/>
                    <form:errors path="moTa" element="span" cssClass="text-danger"/>
                </div>

            </div>
        </div>
        <div class="form-group mt-3">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary"
                    data-bs-toggle="modal" data-bs-target="#exampleModalLong">Save
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
                            Bạn có muốn save không ?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary"
                                    data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Save
                                changes</button>
                        </div>
                    </div>
                </div>
            </div>
            <button type="reset" class="btn btn-secondary">Clear</button>
        </div>
    </form:form>
</div>

