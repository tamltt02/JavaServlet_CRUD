<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/30/2023
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<article>
    <section class="ctsp">
        <div class="container">
            <div class="row">
                <div class="col-6" style="border: 1px solid gray;">
                    <img src="${ pageContext.request.contextPath }/img/${sp.moTa}" alt="" width="100%">
                </div>

                <div class="col-6">
                    <div class="txt-detailkcv">
                        <h1 class="name-itemdt">${sp.sanPham.ten}</h1>
                        <p class="id-itemdt">Mã sản phẩm: ${sp.sanPham.ma}</p>
                        <p class="gt-rbld" id="change-pr">${sp.giaBan}đ</p>
                        <p>*Giá có thể thay đổi tùy thuộc vào kích thước và trọng lượng thực tế của sản phẩm.<br>
                            Vui lòng gọi&nbsp;<a href="tel:18001168">1800 1168</a>&nbsp;để được hỗ trợ.</p>
                    </div>
                    <hr>
                    <form  method="post">
                    <div class="pick-diamond">
                        <div class="pick-am">
                            <p></p>

                            <div class="pickamct count-cart">
                                <p >Số lượng: <button>-</button><input type="number" value="1" name="soluong" required style="width:30px ;"><button formaction="/sanpham/detail/tang">+</button></p>

                            </div>

                        </div>
                    </div>
                    <hr>
                    <div class="gt-fix">
                        <span>Ưu đãi</span>
                    </div>
                    <div class="bt-dtdiamond">

                        <div class="row">
                            <div class="col-6">
                                <div class="d-grid gap-2">
                                    <button class="btn btn-danger" type="submit" formaction="/giohang/${sp.id}"> <img src="${ pageContext.request.contextPath }/img/ic-ghw.png" alt="">  Mua ngay</button>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="d-grid gap-2">
                                    <button class="btn btn-danger" type="submit" formaction="/giohang/them/${sp.id}"> <img src="${ pageContext.request.contextPath }/img/ic-ghw.png" alt="">  Thêm vào giỏ hàng</button>
                                </div>
                            </div>
                        </div>
                        <form  method="post">
                        <br>
                        <div class="d-grid gap-2">
                            <button class="btn btn-secondary" type="button" style="background-color: gainsboro ; border: none;"> <img src="${ pageContext.request.contextPath }/img/ic-callr.png" alt=""> HOTLINE : 1800 1168</button>
                        </div>
                    </div>
                </div>
            </div>
            </div>
    </section>

    <section class="morett">
        <div class="container">
            <div class="row">
            <div class="title-h2"><h2>CHI TIẾT SẢN PHẨM</h2> </div>
            <div class="progress" style="height: 1px;">
                <div class="progress-bar bg-danger" role="progressbar" aria-label="Example 1px high" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
            <br>
            <div class="row">
                <div class="col-3">
                    <h6>Loại sản phẩm :</h6>
                </div>
                <div class="col-3">
                <c:choose>
                    <c:when test="${sp.dongSanPham.id == 1}">
                        <div>
                            Trang sức kim cương
                        </div>
                    </c:when>
                    <c:when test="${sp.dongSanPham.id == 2}">
                        <div>
                            Trang sức đá màu
                        </div>
                    </c:when>
                    <c:when test="${sp.dongSanPham.id ==3 }">
                        <div >
                            <p> Trang sức cưới</p>
                        </div>
                    </c:when>
                        <c:when test="${sp.dongSanPham.id == 4}">
                        <div >
                            Đồng hồ
                        </div>
                        </c:when>
                            <c:when test="${sp.dongSanPham.id == 5}">
                        <div >
                            Trang sức vàng 24K
                        </div>
                            </c:when>
                    </c:choose>

                    </div>


                <div class="col-3">
                    <h6>Nam BH:</h6>
                </div>
                <div class="col-3">
                    <p>${sp.namBaoHanh}</p>
                </div>
                </div>




            <div class="row" >
                <div class="col-3">
                    <h6>Nha sx: </h6>
                </div>
                <div class="col-3">
                    <p class="loaisp">
                        ${sp.nsx.ten}
                </div>
                <div class="col-3">
                    <h6>Màu:</h6>
                </div>
                <div class="col-3">
                    <p>${sp.mauSac.ten}</p>
                </div>
            </div>

            <div class="row" >
                <div class="col-3">
                    <h6>Kiểm định: </h6>
                </div>
                <div class="col-3">
                    <p class="loaisp">

                        IGI</p>
                </div>
                <div class="col-3">
                    <h6>Chất liệu:</h6>
                </div>
                <div class="col-3">
                    <p>Kim cương </p>
                </div>
            </div>
            <hr>

            <div class="detail">
                <h3>${sp.sanPham.ten}</h3>
                <p>Trà my vốn sở hữu sức hút mạnh mẽ bởi những cánh hoa xếp tầng lớp lên nhau, bung nở cân đối. Đây chính là nét độc đáo và mới lạ được thể hiện xuyên suốt trong tạo hình của tất cả các thiết kế thuộc BST.</p>
            </div>
            <hr>
            <section class="baohanh">
                <div class="row">
                    <div class="col-6">
                        <h3><img src="${ pageContext.request.contextPath }/img/ic-titleh3.png" alt=""> CAM KẾT CHẤT LƯỢNG
                        </h3>

                        <div class="txtcamket">
                            <p><img src="${ pageContext.request.contextPath }/img/check-dtkc.png" alt="">
                                0% chuẩn xác về hàm lượng vàng. Tất cả các sản phẩm trang sức của DOJI được kiểm định chặt chẽ với máy quang phổ, cam kết chuẩn xác hàm lượng vàng.</p>
                            <p><img src="${ pageContext.request.contextPath }/img/check-dtkc.png" alt="">
                                100% chuẩn xác về trọng lượng vàng.</p>
                            <p><img src="${ pageContext.request.contextPath }/img/check-dtkc.png" alt="">
                                100% sản phẩm trang sức kim cương đều có đầy đủ kiểm định uy tín.</p>
                            <p><img src="${ pageContext.request.contextPath }/img/check-dtkc.png" alt="">
                                Mọi sản phẩm trang sức do DOJI bán ra đều có hóa đơn (đã bao gồm các loại thuế), ghi đầy đủ thông tin về hàm lượng, trọng lượng vàng cũng
                                như và điều kiện bảo hành trang sức và chính sách thu đổi.</p>
                        </div>
                    </div>

                    <div class="col-6">
                        <h3><img src="${ pageContext.request.contextPath }/img/ic-titleh3.png" alt=""> HƯỚNG DẪN MUA HÀNG ONLINE
                        </h3>

                        <div class="txthd">
                            <p><img src="${ pageContext.request.contextPath }/img/check-dtkc.png" alt="">
                                Lựa chọn sản phẩm tại các chuyên mục trên website.</p>
                            <p><img src="${ pageContext.request.contextPath }/img/check-dtkc.png" alt="">
                                Thêm vào giỏ hàng.</p>
                            <p><img src="${ pageContext.request.contextPath }/img/check-dtkc.png" alt="">
                                Kiểm tra thông tin đơn hàng và đặt hàng</p>
                            <p><img src="${ pageContext.request.contextPath }/img/check-dtkc.png" alt="">
                                Kiểm tra và xác nhận đơn hàng</p>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        </div>
    </section>
</article>