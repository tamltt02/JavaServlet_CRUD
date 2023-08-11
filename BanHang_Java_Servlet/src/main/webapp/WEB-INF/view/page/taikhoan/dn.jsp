
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<br>
<section class="">
    <div class="container-fluid" style="width: 800px; height: 100%">
        <div class="row">
            <div class="col-sm-8 text-black">
                    <c:if test="${ not empty sessionScope.error }">
                    <div class="alert alert-danger">${ sessionScope.error }</div>
                    <c:remove var="error" scope="session"/>
                </c:if>
                <form style="width: 23rem" method="post" action="/dangnhap/admin/store">
                    <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px">ĐĂNG NHẬP</h3>
                    <div class="form-outline mb-4">
                        <label class="form-label" for="form2Example18">Email:</label>
                        <input type="text" name="email" id="form2Example18" class="form-control form-control-lg"
                               required/>
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label" for="form2Example28">Password</label>
                        <input type="password" name="password" id="form2Example28" class="form-control form-control-lg"
                               required
                        />
                    </div>
                    <div class="pt-1 mb-4">
                        <button class="btn btn-info btn-lg btn-block" type="submit">Đăng nhập </button>
                    </div>
                </form>
            </div>
            <div class="col-sm-4 px-0 d-none d-sm-block">
                <img src="${ pageContext.request.contextPath }/img/draw2.svg" alt="Login image" style="width: 500px" />
            </div>
        </div>
    </div>
</section>


