<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Bottom Bar Start -->
<div class="bottom-bar">

	<div class="container-fluid">
		<div class="row align-items-center">
			<div class="col-md-3">
				<div class="logo">
					<a href="index.html"> <img src="/img/logo.png" alt="Logo">
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
					<a href="/wishlist" class="btn wishlist"> <i
						class="fa fa-heart"></i> 
					</a> <a href="/cart" class="btn cart"> <i
						class="fa fa-shopping-cart"></i> 
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
			<li class="breadcrumb-item active">Login & Register</li>
		</ul>
	</div>
</div>
<!-- Breadcrumb End -->

<!-- Login Start -->
<div class="login">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-6">
				<div class="register-form">
					<form:form action="/register" method="post" modelAttribute="user">
						<div class="row">
							<div class="col-md-6">
								<label>UserName</label>
								<form:input class="form-control" path="username" type="text"
									placeholder="Username" />
								<form:errors path="username" element="small" class="text-danger" />
							</div>
							<div class="col-md-6">
								<label>Address</label>
								<form:input class="form-control" path="address" type="text"
									placeholder="Address" />
								<form:errors path="address" element="small" class="text-danger" />
							</div>
							<div class="col-md-6">
								<label>E-mail</label>
								<form:input class="form-control" path="email" type="email"
									placeholder="Email" />
								<form:errors path="email" element="small" class="text-danger" />
								<c:if test="${! empty email }">
									<small class="text-danger">${email }</small>
								</c:if>
							</div>
							<div class="col-md-6">
								<label>Phone</label>
								<form:input class="form-control" path="sdt" type="text"
									placeholder="Phone" />
								<form:errors path="sdt" element="small" class="text-danger" />
							</div>
							<div class="col-md-6">
								<label>Password</label>
								<form:input class="form-control" path="password" type="password"
									placeholder="Password" />
								<form:errors path="password" element="small" class="text-danger" />
							</div>
							<div class="col-md-6">
								<label>Retype Password</label>
								<form:input class="form-control" path="confirmPassword"
									type="password" placeholder="Confirm Password" />
								<form:errors path="confirmPassword" element="small"
									class="text-danger" />
								<c:if test="${! empty confirmPassword }">
									<small class="text-danger">${confirmPassword }</small>
								</c:if>
							</div>
							<div class="col-md-12">
								<button class="btn">Submit</button>
							</div>
						</div>
					</form:form>
				</div>

			</div>
			<div class="col-lg-6">
				<div class="login-form">
					<form action="/login" method="post">
						<div class="row">
							<div class="col-md-6">
								<label>E-mail </label> <input class="form-control"
									required="required" name="email" value="${param.email}"
									type="email" placeholder="E-mail">
								<c:if test="${ ! empty sessionScope.message}">
									<small class="text-danger"> ${sessionScope.message}</small>
									<c:remove var="message" scope="session" />
								</c:if>
							</div>
							<div class="col-md-6">
								<label>Password</label> <input class="form-control"
									required="required" name="password" value="${param.password}"
									type="password" placeholder="Password">


							</div>
							<div class="col-md-12">
								<div class="custom-control custom-checkbox">
									<input type="checkbox" name="remember"
										class="custom-control-input" id="newaccount"> <label
										class="custom-control-label" for="newaccount">Keep me
										signed in</label>
								</div>
							</div>
							<div class="col-md-12">
								<button class="btn">Submit</button>
							</div>
						</div>
					</form>
				</div>
				<div class="col-lg-12">
					<div class="login-form">
						<form action="/forgot-password" method="post">
							<div class="row">
								<div class="col-md-6">
									<label>E-mail</label> <input class="form-control"
										required="required" name="emailforgot" value="${param.emailforgot}"
										type="email" placeholder="E-mail">
										<c:if test="${! empty forgotmail }">
										<small class="text-danger">${forgotmail }</small>
										</c:if>
									
								</div>
								<div class="col-md-6 " style="margin-top: 30px">
										<button class="btn">Forgot password</button>
									</div>
							</div>
						</form>
					</div>

				</div>

			</div>

		</div>
	</div>
</div>
<!-- Login End -->

