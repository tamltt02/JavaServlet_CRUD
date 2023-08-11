<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/30/2023
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Lab1_3</title>
    <link
            href="${ pageContext.request.contextPath }/css/bootstrap.min.css"
            rel="stylesheet"
    />
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/style.css">
    <link href="${ pageContext.request.contextPath }/css/fontawesome.min.css" rel="stylesheet" />

<body >
<header>
    <div class="header">
        <div class="container-fluid">
            <div class="hd-right">
                <div class="login">
                    <ul class="nav justify-content-end">
                        <div class="dropdown">

                            <button class="btn  dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <c:if test="${! empty sessionScope.user }">
                            ${sessionScope.user.username }
                        </c:if>
                                <c:if test="${! empty sessionScope.admin }">
                                    ${sessionScope.admin.hoTen }
                                </c:if>
                                <c:if test="${ empty sessionScope.user && empty sessionScope.admin}">
                                    Tài khoản
                                </c:if>
                            </button>

                            <ul class="dropdown-menu" >
                                <c:if test="${ empty sessionScope.user && empty sessionScope.admin }">
                                    <div>
                                        <li><a class="dropdown-item" href="/dangki"> <img src="${ pageContext.request.contextPath }/img/ic-account.png" alt="" /> Đăng kí</a></li>
                                        <li><a class="dropdown-item" href="/dangnhap"> <img src="${ pageContext.request.contextPath }/img/ic-account.png" alt="" /> Đăng nhập</a></li>
                                        <li><a class="dropdown-item" href="/dangnhap/admin"> <img src="${ pageContext.request.contextPath }/img/ic-account.png" alt="" /> Admin</a></li>
                                    </div>
                                </c:if>
                                <c:if test="${! empty sessionScope.admin }">
                                        <li><a class="dropdown-item" href="/admin/sanpham/hienthi"> <img src="img/ic-account.png" alt="" /> Admin</a></li>
                                        <li><a class="dropdown-item" href="/quenmk"> <img src="img/ic-account.png" alt="" /> Đổi mật khẩu</a></li>
                                    <li><a class="dropdown-item" href="/logout"> <img src="../img/loginaccix.png" alt="" /> Logout</a></li>
                                </c:if>
                                <c:if test="${! empty sessionScope.user }">
                                <li><a class="dropdown-item" href="/doimk"> <img src="../img/newaccid-red.png" alt="" /> Đổi mật khẩu</a></li>
                                    <li><a class="dropdown-item" href="/logout"> <img src="../img/loginaccix.png" alt="" /> Logout</a></li>
                                </c:if>>

                            </ul>
                        </div>
                        <article >
                            <li class="nav-item">
                                <a class="nav-link"  href="/giohang" > <img src="${ pageContext.request.contextPath }/img/ic-gh.png" alt=""  />  Giỏ hàng (${length}) </a>
                            </li>
                        </article>
                    </ul>
                </div>
            </div>
            <div class="logo">
                <img src="${ pageContext.request.contextPath }/img/logo-t.png" alt="" width="213" height="78">
                <img src="${ pageContext.request.contextPath }/img/border-mnt.png" alt="">
            </div>

            <div class="hd-bottom">
                <ul class="nav justify-content-center">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/trangchu">Trang chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/gioithieu">Giới thiệu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/sanpham">Sản phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/tintuc">Tin tức</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/lienhe">Liên hệ</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    </div>
</header>
<div class="col-12">

    <jsp:include page="${ view }"></jsp:include>
</div>
<br>
<footer>
    <div class="ft-top">
        <div class="logo">
            <br>
            <img src="${ pageContext.request.contextPath }/img/logo-t.png" alt="" width="213" height="78">
            <hr>
        </div>
        <section class="ft-body">
            <div class="container">
                <div class="row">
                    <div class="col-3">
                        <div class=""><h5> LIÊN HỆ</h5></div>
                        <div class="progress" style="height: 3px;">
                            <div class="progress-bar bg-danger" role="progressbar" aria-label="Example 1px high" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                        <br>
                        Tập đoàn VBĐQ DOJI <br>
                        Địa chỉ: Tòa nhà DOJI Tower, Số 5 Lê Duẩn, Ba Đình, Hà Nội <br>
                        Điện thoại:1800 1168 <br>
                        Email:info@doji.vn <br>
                        Mã số doanh nghiệp: 0100365621 <br>

                    </div>

                    <div class="col-2">
                        <div class=""><h5>VỀ CHÚNG TÔI</h5></div>
                        <div class="progress" style="height: 3px;">
                            <div class="progress-bar bg-danger" role="progressbar" aria-label="Example 1px high" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                        <br>
                        <a href="" class="ft">Về trang sức DOJI</a> <br>
                        <a href="" class="ft">Dịch vụ khách hàng</a><br>
                        <a href="" class="ft">Kinh doanh bán sỉ</a> <br>
                        <a href="" class="ft">DOJI Elite Club</a><br>
                    </div>

                    <div class="col-3">
                        <div class=""><h5> DỊCH VỤ KHÁCH HÀNG</h5></div>
                        <div class="progress" style="height: 3px;">
                            <div class="progress-bar bg-danger" role="progressbar" aria-label="Example 1px high" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                        <br>
                        <a href="" class="ft">Hướng dẫn đặt hàng</a> <br>
                        <a href="" class="ft">Phương thức thanh toán</a><br>
                        <a href="" class="ft">Chính sách & bảo hành</a> <br>
                        <a href="" class="ft">Cam kết chất lượng</a><br>
                        <a href="" class="ft">Điều khoản mua bán</a><br>
                    </div>

                    <div class="col-2">
                        <div class=""><h5> TIN TỨC</h5></div>
                        <div class="progress" style="height: 3px;">
                            <div class="progress-bar bg-danger" role="progressbar" aria-label="Example 1px high" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                        <br>
                        <a href="" class="ft">Tin khuyến mãi</a> <br>
                        <a href="" class="ft">Tin trang sức</a><br>
                        <a href="" class="ft">Video</a> <br>
                        <a href="" class="ft">Blog</a><br>
                    </div>

                    <div class="col-2">
                        <div class=""><h5>ĐĂNG KÝ NHẬN BẢN TIN</h5></div>
                        <div class="progress" style="height: 3px;">
                            <div class="progress-bar bg-danger" role="progressbar" aria-label="Example 1px high" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                        <p>Nhập email...</p>
                        <input type="text">
                        <p>Nhận ngay thông tin ưu đãi mới nhất từ trang sức DOJI</p>
                        <br>

                    </div>
                </div>
            </div>
        </section>
        <hr>
        <section class="lh">
            <button style="border-radius: 20px; background-color: red; color: aliceblue; border: none; padding: 10px;margin:auto;
        display:block;">Kết nối với chúng tôi</button>
            <br>
            <div class="container" style="margin-top: 0;">
                <div class="row">
                    <div class="col-2">
                        <a href="" class="ft"> <img src="${ pageContext.request.contextPath }/img/fb.png" alt="" width="30px" height="30px">
                            Trang sức DOJI	</a>

                    </div>

                    <div class="col-3">
                        <a href="" class="ft"> <img src="${ pageContext.request.contextPath }/img/fb.png" alt="" width="30px" height="30px">
                            Trang sức cưới Wedding Land	</a>

                    </div>
                    <div class="col-3">
                        <a href="" class="ft"> <img src="${ pageContext.request.contextPath }/img/fb.png" alt="" width="30px" height="30px">
                            Trang sức và Quà tặng DOJI	</a>
                    </div>

                    <div class="col-2">
                        <a href="" class="ft"> <img src="${ pageContext.request.contextPath }/img/insta.png" alt="" width="30px" height="30px">
                            INSTARGRAM	</a>
                    </div>
                    <div class="col-2">
                        <a href="" class="ft"> <img src="${ pageContext.request.contextPath }/img/yout.png" alt="" width="30px" height="30px">
                            YOUTUBE	</a>
                    </div>
                </div>
            </div>
        </section>

        <section class="ft-bottom">
            <div class="container" style="margin-top: 0;">
                <img src="img/ic-cpr.png" alt="">
                Copyright 2020 © DOJI Gold & Gems Group
            </div>
        </section>
    </div>
</footer>
<script
        src="${ pageContext.request.contextPath }/js/bootstrap.bundle.min.js"
></script>
<script src="${ pageContext.request.contextPath }/angular/angular.js"></script>
<script src="${ pageContext.request.contextPath }/js/ui-bootstrap-tpls-2.5.0.min.js"></script>
</body>
</html>

