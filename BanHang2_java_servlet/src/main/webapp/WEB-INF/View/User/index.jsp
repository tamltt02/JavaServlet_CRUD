<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>E Store - eCommerce HTML Template</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="eCommerce HTML Template Free Download" name="keywords">
<meta content="eCommerce HTML Template Free Download" name="description">

<!-- Favicon -->
<link href="/img/favicon.ico" rel="icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap"
	rel="stylesheet">

<!-- CSS Libraries -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link href="lib/slick/slick.css" rel="stylesheet">
<link href="/lib/slick/slick-theme.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="/css1/style.css" rel="stylesheet">
</head>

<body ng-app="myapp">
	<!-- Top bar Start -->
	<div class="top-bar">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-6">
					<i class="fa fa-envelope"></i> support@email.com
				</div>
				<div class="col-sm-6">
					<i class="fa fa-phone-alt"></i> +012-345-6789
				</div>
			</div>
		</div>
	</div>
	<!-- Top bar End -->

	<!-- Nav Bar Start -->
	<div class="nav">
		<div class="container-fluid">
			<nav class="navbar navbar-expand-md bg-dark navbar-dark">
				<a href="#" class="navbar-brand">MENU</a>
				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto">
						<a href="/trangchu" class="nav-item nav-link active">Home</a> <a
							href="/heo-list" class="nav-item nav-link">Heo</a> <a
							href="/heo-detail/2" class="nav-item nav-link">Heo Detail</a>
						<a href="/cart" class="nav-item nav-link">Cart</a>  <a
							href="/myAccount" class="nav-item nav-link">My Account</a>
						<div class="nav-item dropdown">
							<a href="#" class="nav-link dropdown-toggle"
								data-toggle="dropdown">More Pages</a>
							<div class="dropdown-menu">
								<a href="wishlist.html" class="dropdown-item">Wishlist</a> <a
									href="/login" class="dropdown-item">Login & Register</a> 
									<c:if test="${! empty sessionScope.user }">
										<c:if test="${ sessionScope.user.admin == 1 }">
									<a
									href="/home" class="dropdown-item">Manager</a>
									</c:if>
									</c:if>
							</div>
						</div>
					</div>
					<div class="navbar-nav ml-auto">
						<div class="nav-item dropdown">
							<a href="#" class="nav-link dropdown-toggle"
								data-toggle="dropdown">${sessionScope.user == null ? 'USER ACCOUNT' : sessionScope.user.username  }</a>
							<div class="dropdown-menu">
								<a href="#" class="dropdown-item">Login</a> <a href="#"
									class="dropdown-item">Register</a>
							</div>
						</div>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<!-- Nav Bar End -->

	<!-- Bottom Bar Start -->
	<jsp:include page="${view }"></jsp:include>

	<!-- Footer Start -->
	<div class="footer">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h2>Get in Touch</h2>
						<div class="contact-info">
							<p>
								<i class="fa fa-map-marker"></i>123 E Store, Los Angeles, USA
							</p>
							<p>
								<i class="fa fa-envelope"></i>email@example.com
							</p>
							<p>
								<i class="fa fa-phone"></i>+123-456-7890
							</p>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h2>Follow Us</h2>
						<div class="contact-info">
							<div class="social">
								<a href=""><i class="fab fa-twitter"></i></a> <a href=""><i
									class="fab fa-facebook-f"></i></a> <a href=""><i
									class="fab fa-linkedin-in"></i></a> <a href=""><i
									class="fab fa-instagram"></i></a> <a href=""><i
									class="fab fa-youtube"></i></a>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h2>Company Info</h2>
						<ul>
							<li><a href="#">About Us</a></li>
							<li><a href="#">Privacy Policy</a></li>
							<li><a href="#">Terms & Condition</a></li>
						</ul>
					</div>
				</div>

				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h2>Purchase Info</h2>
						<ul>
							<li><a href="#">Pyament Policy</a></li>
							<li><a href="#">Shipping Policy</a></li>
							<li><a href="#">Return Policy</a></li>
						</ul>
					</div>
				</div>
			</div>

			<div class="row payment align-items-center">
				<div class="col-md-6">
					<div class="payment-method">
						<h2>We Accept:</h2>
						<img src="/img/payment-method.png" alt="Payment Method" />
					</div>
				</div>
				<div class="col-md-6">
					<div class="payment-security">
						<h2>Secured By:</h2>
						<img src="/img/godaddy.svg" alt="Payment Security" /> <img
							src="/img/norton.svg" alt="Payment Security" /> <img
							src="/img/ssl.svg" alt="Payment Security" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer End -->

	<!-- Footer Bottom Start -->
	<div class="footer-bottom">
		<div class="container">
			<div class="row">
				<div class="col-md-6 copyright">
					<p>
						Copyright &copy; <a href="#">Your Site Name</a>. All Rights
						Reserved
					</p>
				</div>

				<div class="col-md-6 template-by">
					<!--/*** This template is free as long as you keep the footer authorâs credit link/attribution link/backlink. If you'd like to use the template without the footer authorâs credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
					<p>
						Designed By <a href="https://htmlcodex.com">HTML Codex</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer Bottom End -->

	<!-- Back to Top -->
	<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
	<script src="/lib/easing/easing.min.js"></script>
	<script src="/lib/slick/slick.min.js"></script>

	<!-- Template Javascript -->
	<script src="/js/main.js"></script>
	<c:if test="${! empty alert}">
		<script>
  
         alert("${alert}");
         
    
    </script>
     <c:remove var="alert" scope="session"/>
    
	</c:if>
	
</body>
</html>
