<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="/BaiTap/boostrap/css/bootstrap.min.css"></link>
<title>Insert title here</title>
<style type="text/css">
.divider:after,
.divider:before {
content: "";
flex: 1;
height: 1px;
background: #eee;
}
</style>
</head>
<body>
<section class="vh-100">
  <div class="container py-5 h-100" style="width: 1250px">
    <div class="row d-flex align-items-center justify-content-center h-100">
      <div class="col-md-8 col-lg-7 col-xl-6">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
          class="img-fluid" alt="Phone image">
      </div>
      <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
        <form action="/BaiTap/login" method="post">
          <!-- Email input -->
          <div class="form-outline mb-4">
            <input type="email" class="form-control form-control-lg" name="email" placeholder="Email" required="required"/>
            
          </div>

          <!-- Password input -->
          <div class="form-outline mb-4">
            <input type="password"  class="form-control form-control-lg" name="password"  placeholder="Passwword" required="required"/>
          
          </div>
			<span style="color: red">${error }</span>
          <!-- Submit button -->
          <button type="submit" class="btn btn-primary btn-lg btn-block" style="margin-left: 100px;width: 300px">Đăng nhập</button>

          <div class="divider d-flex align-items-center my-4">
            <p class="text-center fw-bold mx-3 mb-0 text-muted" >OR</p>
          </div>

          <a class="btn btn-primary btn-lg btn-block" style="background-color: #3b5998" href="#!"
            role="button">
            <i class="fab fa-facebook-f me-2"></i>Continue with Facebook
          </a>
          <a class="btn btn-primary btn-lg btn-block" style="background-color: #55acee;"  
          href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/BaiTap/LoginGG&response_type=code
		   &client_id=783102032569-pq5lh3c8kkve7hvr3pu06jsnpn1a5u2v.apps.googleusercontent.com&approval_prompt=force"
            role="button">
       
            <i class="fab fa-twitter me-2"></i>Continue with Google</a>

        </form>
      </div>
    </div>
  </div>
</section>
<script src="/BaiTap/boostrap/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>