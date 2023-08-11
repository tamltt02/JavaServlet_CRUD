<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/30/2023
  Time: 1:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<article >

    <div class="container">
        <section class="gioihang" >
            <div class="row">
                <div class="col-8">
                    <div class="title-h2"><h2>GIỎ HÀNG ( <span>${length}</span> sản phẩm )</h2> </div>
                    <div class="progress" style="height: 1px;">
                        <div class="progress-bar bg-danger" role="progressbar" aria-label="Example 1px high" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <br>
                    <c:forEach var="ghct" items="${dtolist}">
                    <div class="card mb-12" >
                        <div class="row g-0">
                            <div class="col-md-2">
                                <a href="/sanpham/detail/${ghct.chiTietSanPham.id}"> <img src="${ pageContext.request.contextPath }/img/${ghct.chiTietSanPham.moTa}" class="img-fluid rounded-start" alt="..." width="100%"></a>
                            </div>
                            <div class="col-md-10">
                                <div class="card-body">
                                    <form method="post">
                                    <h5 class="card-title">${ghct.chiTietSanPham.sanPham.ten}</h5>
                                    <p class="card-text">Số lượng : <button formaction="/giohang/giam/${ghct.chiTietSanPham.id}">-</button >
                                        <input type="number" name="soluong" id="" max="100" min="1" value="${ghct.soLuong}" >
                                        <button formaction="/giohang/tang/${ghct.chiTietSanPham.id}">+</button>  </p>
                                    <p>Giá tiền : ${ghct.donGia}đ</p>
                                    <a class="btn btn-danger" style="width:100px ;"  href="/giohang/delete/${ghct.id}">Xóa</a>
                                    </p>
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>

                <div class="col-4">
                    <div class="thongtin">
                        <h6>Tổng tiền </h6>
                        <p>Tạm tính : <span class="tien" >${sum}</span></p>
                        <hr>
                        <p>Vận chuyển :  <span class="tien">Miễn phí vận chuyển</span></p>
                        <hr>
                        <p>Thành tiền :  <span class="tien">${sum}</span></p>
                        <hr>
                        <form action="/thanhtoan" method="post">
                        <button type="submit" class="btn btn-danger" style="width: 100%;" >Tiến hàng đặt hàng</button>
                        </form>

                    </div>
                </div>
            </div>
            <a href="#lichsu" class="btn btn-outline-secondary">Lịch sử mua hàng</a>
        </section>
    </div>

</article>


