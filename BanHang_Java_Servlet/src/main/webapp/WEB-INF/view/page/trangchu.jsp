<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/30/2023
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="banner">
    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="${ pageContext.request.contextPath }/img/banner-trang-chu-khuc-giao-mua-1920x703.jpg"
                     class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="${ pageContext.request.contextPath }/img/banner-web-1920x703.jpg" class="d-block w-100"
                     alt="...">
            </div>
            <div class="carousel-item">
                <img src="${ pageContext.request.contextPath }/img/wedding-land-1920x703.jpg" class="d-block w-100"
                     alt="...">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls"
                data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls"
                data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>
<article>
    <section>
        <div class="container">
            <div class="title-h2"><h2>SẢN PHẨM MỚI NHẤT</h2></div>
            <div class="progress" style="height: 1px;">
                <div class="progress-bar bg-danger" role="progressbar" aria-label="Example 1px high" style="width: 25%;"
                     aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
            <br>

            <div class="row">
                <c:forEach var="sp" items="${listspnew}">
                    <div class="col-3">
                        <div class="card text-center" style="width: 19rem; ">
                            <div class="card-body">
                                <img src="${ pageContext.request.contextPath }/img/${sp.moTa}" alt="" height="200px">
                                <p class="card-text">
                                        ${sp.sanPham.ten    }
                                    <br>
                                </p>
                                <p class="gia">${sp.giaBan} đ</p>
                                <a href="/sanpham/detail/${sp.id}" class="btn btn-danger">Chi tiết <img
                                        src="${ pageContext.request.contextPath }/img/ic-arrb.png" alt=""></a>
                            </div>
                        </div>
                    </div>


                </c:forEach>
                <div class="col-6">
                    <iframe src="https://www.youtube.com/embed/6jrf6JuXf7U?autoplay=1&amp;loop=1&amp;rel=0&amp;controls=1&amp;mute=1" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen="" width="105%" style="height:-webkit-fill-available"></iframe>
                </div>
            </div>
        </div>
    </section>

    <section class="sp-most" style="background-color: rgba(226, 226, 226, 0.18); margin-top: 10px;padding-top: 1px;">
        <div class="container">
            <div class="title-h2"><h2>SẢN PHẨM CHẠY NHẤT</h2></div>
            <div class="progress" style="height: 1px;">
                <div class="progress-bar bg-danger" role="progressbar" aria-label="Example 1px high" style="width: 25%;"
                     aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
            <br>

            <div class="row">

                <c:forEach var="sp" items="${listspchay}">
                    <div class="col-3">
                        <div class="card text-center" style="width: 19rem; ">
                            <div class="card-body">
                                <img src="${ pageContext.request.contextPath }/img/${sp.moTa}" alt="" height="200px">
                                <p class="card-text">${sp.sanPham.ten}
                                    <br>${sp.sanPham.ma}
                                </p>
                                <p class="gia">${sp.giaBan}</p>
                                <a href="/sanpham/detail/${sp.id}" class="btn btn-danger">Chi tiết <img
                                        src="${ pageContext.request.contextPath }/img/ic-arrb.png" alt=""></a>
                            </div>


                            <c:choose>
                                <c:when test="${sp.dongSanPham.id == 1}">
                                    <div class="icon-sale">
                                        <div class="item">
                                            <img src="${ pageContext.request.contextPath }/img/img-fix.png"
                                                 alt="Giảm giá"/><span
                                        >-25%</span>
                                        </div>
                                    </div>
                                </c:when>
                                <c:when test="${sp.dongSanPham.id == 5}">
                                    <div class="icon-sale">
                                        <div class="item">
                                            <img src="${ pageContext.request.contextPath }/img/img-fix.png"
                                                 alt="Giảm giá"/><span
                                        >-12%</span>
                                        </div>
                                    </div>
                                </c:when>
                                <c:when test="${sp.dongSanPham.id == 4}">
                                    <div class="icon-sale">
                                        <div class="item">
                                            <img src="${ pageContext.request.contextPath }/img/img-fix.png"
                                                 alt="Giảm giá"/><span
                                        >-15%</span>
                                        </div>
                                    </div>
                                </c:when>
                                <c:when test="${sp.dongSanPham.id == 3}">
                                    <div class="icon-sale">
                                        <div class="item">
                                            <img src="${ pageContext.request.contextPath }/img/img-fixpp.png"
                                                 alt="Giảm giá"/><span
                                        >-15%</span
                                        >
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>

                        </div>
                    </div>
                </c:forEach>
            </div>
            <br>
        </div>
    </section>
    <br> <br>
    <section class="vovan">
        <div class="de">
            <div class="container">
                <a class="title-h2ct" href="" title="Về trang sức DOJI"><h2>Về trang sức DOJI</h2></a>
                <img src="img/bf-h2b.png" alt="">
                <p class="txt-vct">Mỗi một người phụ nữ đều mang trong mình nét đẹp riêng &amp; xứng đáng được ngưỡng
                    mộ, được tôn vinh và được tự tin với chính con người mình. Phụ nữ luôn xứng đáng với những điều trọn
                    vẹn nhất cho cuộc sống của mình: Hạnh phúc trọn vẹn, vẻ đẹp trọn vẹn và còn nhiều hơn thế. DOJI hơn
                    cả một thương hiệu trang sức, mà còn là đại diện cho một phong cách sống của những giá trị hoàn mỹ
                    xứng đáng nhất dành cho phụ nữ.<br>
                    "TRANG SỨC DOJI – CHO PHỤ NỮ LUÔN TRỌN VẸN"</p>  <br>

                <button type="button" class="btn btn-outline-secondary" style="width:150px ; border-radius: 0%;">Chi
                    tiết <img src="${ pageContext.request.contextPath }/img/ic-arrb.png" alt=""></button>
            </div>
        </div>
        <img src="${ pageContext.request.contextPath }/img/banner-vct.jpg" alt="" width="100%">
    </section>

    <section class="bst">
        <div class="container">
            <div class="title-h2"><h2>BỘ SƯU TẬP </h2></div>
            <div class="progress" style="height: 1px;">
                <div class="progress-bar bg-danger" role="progressbar" aria-label="Example 1px high" style="width: 25%;"
                     aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
            <br>
            <div class="row">
                <div class="col-6">
                    <img src="${ pageContext.request.contextPath }/img/578x321-moonlight.jpg" alt="">
                    <BR></BR>
                    <h6 style="text-align:center ;">BST TRANG SỨC NGỌC TRAI THE MOONLIGHT </h6>
                </div>

                <div class="col-6">
                    <img src="${ pageContext.request.contextPath }/img/ocean-life-578x321.jpg" alt="">
                    <BR></BR>
                    <h6 style="text-align:center ;">BST TRANG SỨC OCEAN LIFE </h6>
                </div>
            </div>
        </div>
    </section>
</article>
<br>


