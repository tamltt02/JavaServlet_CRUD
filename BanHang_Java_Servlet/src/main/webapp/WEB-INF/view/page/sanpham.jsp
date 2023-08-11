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
<div class="banner">
    <div
            id="carouselExampleControls"
            class="carousel slide"
            data-bs-ride="carousel"
    >
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img
                        src="${ pageContext.request.contextPath }/img/banner-trang-chu-khuc-giao-mua-1920x703.jpg"
                        class="d-block w-100"
                        alt="..."
                />
            </div>
            <div class="carousel-item">
                <img
                        src="${ pageContext.request.contextPath }/img/banner-web-1920x703.jpg"
                        class="d-block w-100"
                        alt="..."
                />
            </div>
            <div class="carousel-item">
                <img
                        src="${ pageContext.request.contextPath }/img/wedding-land-1920x703.jpg"
                        class="d-block w-100"
                        alt="..."
                />
            </div>
        </div>
        <button
                class="carousel-control-prev"
                type="button"
                data-bs-target="#carouselExampleControls"
                data-bs-slide="prev"
        >
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button
                class="carousel-control-next"
                type="button"
                data-bs-target="#carouselExampleControls"
                data-bs-slide="next"
        >
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>

<article>
    <div class="container" >
        <div class="row">
            <div class="col-3">
                <aside>
                    <br /><br />
                    <br />
                    <c:forEach var="dsp" items="${dongSanPhams}">
                    <div class="list-group" >
                        <a class="list-group-item list-group-item-action"
                           href="/sanpham/${dsp.ten}" > ${dsp.ten}
                        </a>

                        </c:forEach>
                    </div>
                </aside>
            </div>

            <div class="col-9">
                <c:if test="${ not empty sessionScope.hethang }">
                    <div class="text-danger">${ sessionScope.hethang }</div>
                    <c:remove var="hethang" scope="session"/>
                </c:if>
                <section>
                    <div class="title-h2"><h2>SẢN PHẨM</h2></div>
                    <div class="progress" style="height: 1px">
                        <div
                                class="progress-bar bg-danger"
                                role="progressbar"
                                aria-label="Example 1px high"
                                style="width: 25%"
                                aria-valuenow="25"
                                aria-valuemin="0"
                                aria-valuemax="100"
                        ></div>
                    </div>
                    <br />
                    <div class="row">
                        <c:forEach var="sp" items="${pageData.content}">
                        <div class="col-4">
                            <div class="card text-center" style="width: 17rem">
                                <div class="card-body">
                                    <img src="${ pageContext.request.contextPath }/img/${sp.moTa}" alt="" height="200px" />
                                    <p class="card-text">
                                        ${sp.sanPham.ten} <br />
                                                ${sp.sanPham.ma}
                                    </p>
                                    <p class="gia"> ${sp.giaBan} đ</p>
                                    <a href="/sanpham/detail/${sp.id}" class="btn btn-danger"
                                    >Chi tiết <img src="${ pageContext.request.contextPath }/img/ic-arrb.png" alt=""
                                    /></a>
                                </div>
                                <c:choose>
                                    <c:when test="${sp.dongSanPham.id == 1}">
                                        <div class="icon-sale">
                                            <div class="item">
                                                <img src="${ pageContext.request.contextPath }/img/img-fix.png" alt="Giảm giá" /><span
                                            >-25%</span>
                                            </div>
                                        </div>
                                    </c:when>
                                    <c:when test="${sp.dongSanPham.id == 5}">
                                        <div class="icon-sale">
                                            <div class="item">
                                                <img src="${ pageContext.request.contextPath }/img/img-fix.png" alt="Giảm giá" /><span
                                            >-12%</span>
                                            </div>
                                        </div>
                                    </c:when>
                                    <c:when test="${sp.dongSanPham.id == 4}">
                                        <div class="icon-sale">
                                            <div class="item">
                                                <img src="${ pageContext.request.contextPath }/img/img-fix.png" alt="Giảm giá" /><span
                                            >-15%</span>
                                            </div>
                                        </div>
                                    </c:when>
                                    <c:when test="${sp.dongSanPham.id == 3}">
                                        <div class="icon-sale">
                                            <div class="item">
                                                <img src="${ pageContext.request.contextPath }/img/img-fixpp.png" alt="Giảm giá" /><span
                                            >-15%</span
                                            >
                                            </div>
                                        </div>
                                    </c:when>
                                </c:choose>
                            </div>
                            <br />
                        </div>
                        </c:forEach>
                    </div>
                    <br />
                </section>
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                        <c:forEach begin="0" end="${ pageData.totalPages - 1 }" varStatus="page">
                            <li class="page-item">
                                <a class="page-link" href="/sanpham/${ten}?page=${ page.index }" > ${ page.index + 1 }</a>
                            </li>
                        </c:forEach>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
    <br />
</article>
<br />

