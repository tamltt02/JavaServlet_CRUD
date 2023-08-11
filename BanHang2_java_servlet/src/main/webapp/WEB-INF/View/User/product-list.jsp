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

<body>
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
        <div class="bottom-bar">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-md-3">
                        <div class="logo">
                            <a href="index.html">
                                <img src="img/logo.png" alt="Logo">
                            </a>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="search">
                             <form action="/heo-list">
                                                <input type="text" name="name"  placeholder="Search">
                                                <button><i class="fa fa-search"></i></button>
                                                </form>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="user">
                            <a href="/wishlist" class="btn wishlist">
                                <i class="fa fa-heart"></i>
                               
                            </a>
                            <a href="cart.html" class="btn cart">
                                <i class="fa fa-shopping-cart"></i>
                                
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bottom Bar End -->  
        
        <!-- Breadcrumb Start -->
        <div class="breadcrumb-wrap">
            <div class="container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                    <li class="breadcrumb-item"><a href="#">Heo</a></li>
                    <li class="breadcrumb-item active">Heo List</li>
                </ul>
            </div>
        </div>
        <!-- Breadcrumb End -->
        
        <!-- Product List Start -->
        <div class="product-view">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="product-view-top">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="product-search">
                                                <form action="/heo-list">
                                                <input type="text" name="name" value="${param.name }" placeholder="Search">
                                                <button><i class="fa fa-search"></i></button>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="product-short">
                                                <div class="dropdown">
                                                    <div class="dropdown-toggle" data-toggle="dropdown">Heo short by</div>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="/heo-list?fiel=price" class="dropdown-item">price</a>
                                                        <a href="/heo-list?fiel=name" class="dropdown-item">Name</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="product-price-range">
                                                <div class="dropdown">
                                                    <div class="dropdown-toggle" data-toggle="dropdown">Product price range</div>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="/heo-list?min=0&max=50" class="dropdown-item">$0 to $50</a>
                                                        <a href="/heo-list?min=51&max=100" class="dropdown-item">$51 to $100</a>
                                                        <a href="/heo-list?min=101&max=150" class="dropdown-item">$101 to $150</a>
                                                        <a href="/heo-list?min=151&max=200" class="dropdown-item">$151 to $200</a>
                                                        <a href="/heo-list?min=201&max=250" class="dropdown-item">$201 to $250</a>
                                                        <a href="/heo-list?min=251&max=500" class="dropdown-item">$251 to $500</a>
                                                  
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            
                         
                            <c:forEach var="heo" items="${heos.getContent() }">
                            <c:if test="${heo.quantity != 0 }">
                            <div class="col-md-4">
                                <div class="product-item">
                                    <div class="product-title">
                                        <a href="#">${heo.name } ${ heo.quantity == 0 ?'(Da het hang)' : ''}</a>
                                        <div class="ratting">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="product-image">
                                        <a href="product-detail.html">
                                            <img src="/storage/${heo.image }" height="300px" alt="Product Image">
                                        </a>
                                        <div class="product-action">
                                            <a href="/cart/${heo.id }"><i class="fa fa-cart-plus"></i></a>
                                            <a href="/wishlist/${heo.id }"><i class="fa fa-heart"></i></a>
                                            
                                            <a class="btn" href="/heo-detail/${heo.id }"><i class="fa fa-search"></i></a>
                                         
                                            
                                        </div>
                                    </div>
                                    <div class="product-price">
                                        <h3><span>$</span>${heo.price }</h3>
                                        <a class="btn" href="/cart/${heo.id }"><i class="fa fa-shopping-cart"></i>ADD TO CART</a>
                                    </div>
                                </div>
                            </div>
                            </c:if>
                           </c:forEach>
                        </div>
                        
                        <!-- Pagination Start -->
                        <div class="col-md-12">
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-center">
                                    <c:if test="${ heos.getNumber()>0 }">
                                    <li class="page-item ">
                                        <a class="page-link" href="/heo-list?name=${param.name }&page=${ heos.getNumber() }" tabindex="-1">Previous</a>
                                    </li>
                                    </c:if>
                                  <c:forEach var="page" begin="1" end="${heos.getTotalPages() }">
                                    <li class="page-item ${page == heos.getNumber() +1 ? 'active' :'' }">
                                    <a class="page-link" href="/heo-list?name=${param.name }&page=${page}">${page }</a></li>
                                  </c:forEach>
                                   <c:if test="${ heos.getNumber()+1< heos.getTotalPages() }">
                                    <li class="page-item">
                                        <a class="page-link" href="/heo-list?name=${param.name }&page=${ heos.getNumber()+2 }">Next</a>
                                    </li>
                                     </c:if>
                                </ul>
                            </nav>
                        </div>
                        <!-- Pagination Start -->
                    </div>           
                    
                    <!-- Side Bar Start -->
                    <div class="col-lg-4 sidebar">
                        <div class="sidebar-widget category">
                            <h2 class="title">Category</h2>
                            <nav class="navbar bg-light">
                                <ul class="navbar-nav">
                                  <c:forEach var="c" items="${categories }">
                                    <li class="nav-item">
                                        <a class="nav-link" href="/heo-list?name=${param.name }&category=${c.name}"><i class="fa fa-female"></i>${c.name }</a>
                                    </li>
                                  </c:forEach>
                                  
                                </ul>
                            </nav>
                        
                        <div class="sidebar-widget widget-slider">
                            <div class="sidebar-slider normal-slider">
                            <c:forEach var="heo" items="${heoC }">
                               <c:if test="${heo.quantity != 0 }">
                                <div class="product-item">
                                    <div class="product-title">
                                        <a href="#">${heo.name }  ${ heo.quantity == 0 ?'(Da het hang)' : ''}</a>
                                        <div class="ratting">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="product-image">
                                        <a href="product-detail.html">
                                            <img src="/storage/${heo.image }" height="300px" alt="Product Image">
                                        </a>
                                        <div class="product-action">
                                            <a href="/cart/${heo.id }"><i class="fa fa-cart-plus"></i></a>
                                            <a href="/wishlist/${heo.id }"><i class="fa fa-heart"></i></a>
                                            <a href="/heo-detail/${heo.id }"><i class="fa fa-search"></i></a>
                                        </div>
                                    </div>
                                    <div class="product-price">
                                        <h3><span>$</span>${heo.price }</h3>
                                       
                                        <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy Now</a>
                                    </div>
                                </div>
                               </c:if>
                          </c:forEach>
                            </div>
                        </div>
                      
                        
                
                    </div>
                    <!-- Side Bar End -->
                </div>
            </div>
        </div>
        <!-- Product List End -->  
        
        <!-- Brand Start -->
        <div class="brand">
            <div class="container-fluid">
                <div class="brand-slider">
                    <div class="brand-item"><img src="img/brand-1.png" alt=""></div>
                    <div class="brand-item"><img src="img/brand-2.png" alt=""></div>
                    <div class="brand-item"><img src="img/brand-3.png" alt=""></div>
                    <div class="brand-item"><img src="img/brand-4.png" alt=""></div>
                    <div class="brand-item"><img src="img/brand-5.png" alt=""></div>
                    <div class="brand-item"><img src="img/brand-6.png" alt=""></div>
                </div>
            </div>
        </div>
        <!-- Brand End -->
        
        <!-- Footer Start -->
        <div class="footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Get in Touch</h2>
                            <div class="contact-info">
                                <p><i class="fa fa-map-marker"></i>123 E Store, Los Angeles, USA</p>
                                <p><i class="fa fa-envelope"></i>email@example.com</p>
                                <p><i class="fa fa-phone"></i>+123-456-7890</p>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Follow Us</h2>
                            <div class="contact-info">
                                <div class="social">
                                    <a href=""><i class="fab fa-twitter"></i></a>
                                    <a href=""><i class="fab fa-facebook-f"></i></a>
                                    <a href=""><i class="fab fa-linkedin-in"></i></a>
                                    <a href=""><i class="fab fa-instagram"></i></a>
                                    <a href=""><i class="fab fa-youtube"></i></a>
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
                            <img src="img/payment-method.png" alt="Payment Method" />
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="payment-security">
                            <h2>Secured By:</h2>
                            <img src="img/godaddy.svg" alt="Payment Security" />
                            <img src="img/norton.svg" alt="Payment Security" />
                            <img src="img/ssl.svg" alt="Payment Security" />
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
                        <p>Copyright &copy; <a href="#">Your Site Name</a>. All Rights Reserved</p>
                    </div>

                    <div class="col-md-6 template-by">
						<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->					
                        <p>Designed By <a href="https://htmlcodex.com">HTML Codex</a></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer Bottom End -->       
        
        <!-- Back to Top -->
        <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="/lib/easing/easing.min.js"></script>
        <script src="/lib/slick/slick.min.js"></script>
        
        <!-- Template Javascript -->
        <script src="/js/main.js"></script>
    </body>
</html>
