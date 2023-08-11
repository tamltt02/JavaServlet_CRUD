<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- Bottom Bar Start -->
<div class="bottom-bar">
	<div class="container-fluid">
		<div class="row align-items-center">
			<div class="col-md-3">
				<div class="logo">
					<a href="/trangchu"> <img src="/img/logo.png" alt="Logo">
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
					<a href="wishlist.html" class="btn wishlist"> <i
						class="fa fa-heart"></i> 
					</a> <a href="cart.html" class="btn cart"> <i
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
			<li class="breadcrumb-item active">My Account</li>
		</ul>
	</div>
</div>
<!-- Breadcrumb End -->

<!-- My Account Start -->
<div class="my-account">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3">
				<div class="nav flex-column nav-pills" role="tablist"
					aria-orientation="vertical">
					 <a class="nav-link active"
						id="orders-nav" data-toggle="pill" href="#orders-tab" role="tab"><i
						class="fa fa-shopping-bag"></i>Orders</a>   <a class="nav-link "
						id="account-nav" data-toggle="pill" href="#account-tab" role="tab"><i
						class="fa fa-user "></i>Account Details</a> <a class="nav-link"
						href="/logout"><i class="fa fa-sign-out-alt"></i>Logout</a>
				</div>
			</div>
			<div class="col-md-9">
				<div class="tab-content">
					
					<div class="tab-pane fade show active" id="orders-tab" role="tabpanel"
						aria-labelledby="orders-nav">
						<div class="table-responsive">
							<table class="table table-bordered">
								<thead class="thead-dark">
									<tr>
										<th>No</th>
										<th>Name</th>
										<th>Date</th>
										<th>Total</th>
										<th>Status</th>
										<th colspan="2">Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="o" items="${orders.getContent() }">
										<tr>
											<td>${o.id }</td>
											<td>${o.user.username }</td>
											<td><fmt:formatDate value="${o.createDate }"
													pattern="dd-MM-yyyy" /></td>
											<td>$${o.total }</td>
											<td><c:choose>
													<c:when test="${o.status == 0}">Dang xu ly</c:when>
													<c:when test="${o.status == 1}">Dang giao hang</c:when>
													<c:when test="${o.status == 2}">Da giao</c:when>
													<c:when test="${o.status == 3}">Da huy</c:when>

												</c:choose></td>
											<c:if test="${o.status == 0 }">
												<td><button class="btn" data-bs-toggle="modal" data-bs-target="#delete${o.id }">Delete</button>
													<!-- Modal -->
													<div class="modal fade" id="delete${o.id }" tabindex="-1"
														aria-labelledby="exampleModalLabel" aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<h3 class="modal-title" id="exampleModalLabel">
																		Delete Order</h3>
																	<button type="button" class="btn-close"
																		data-bs-dismiss="modal" aria-label="Close"></button>
																</div>
																<div class="modal-body">
																
																<h5>Do you want to delete this order?</h5> </div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-secondary"
																		data-bs-dismiss="modal">Close</button>
																	<a href="/deleteOrder/${o.id }" type="button" class="btn btn-primary">Save
																		changes</a>
																</div>
															</div>
														</div>
													</div></td>
											</c:if>
											<td><button class="btn" data-bs-toggle="modal"
													data-bs-target="#exampleModal${o.id }">View</button> <!-- Button trigger modal -->


												<div class="modal fade" id="exampleModal${o.id }"
													tabindex="-1" aria-labelledby="exampleModalLabel"
													aria-hidden="true">
													<div class="modal-dialog model-lg">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLabel">Order
																	Detail</h5>
																<button type="button" class="btn-close"
																	data-bs-dismiss="modal" aria-label="Close"></button>
															</div>
															<div class="modal-body">
																<table class="table table-bordered">
																	<thead class="thead-dark">
																		<tr>
																			<th>No</th>
																			<th>Product Name</th>
																			<th>Quantity</th>
																			<th>Price</th>
																			<th>Total</th>

																		</tr>
																	</thead>
																	<tbody>
																		<c:forEach var="detail" items="${o.orderDetails }">
																			<tr>
																				<td>${detail.id }</td>
																				<td>${detail.heo.name }</td>
																				<td>${detail.quantity }con</td>
																				<td>$${detail.price }</td>
																				<td>$${detail.quantity * detail.price }</td>
																			</tr>

																		</c:forEach>
																	</tbody>
																</table>
																<br>
																<h3>Total :$${o.total }</h3>

															</div>
															<div class="modal-footer">
																<a type="button" class="btn btn-secondary"
																	data-bs-dismiss="modal" >Close</a>
																<button type="button" class="btn btn-primary">Save
																	changes</button>
															</div>
														</div>
													</div>
												</div></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							  <div class="col-md-12">
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-center">
                                 
                                  <c:forEach var="page" begin="1" end="${orders.getTotalPages() }">
                                    <li class="page-item ${page == orders.getNumber() +1 ? 'active' :'' }">
                                    <a class="page-link" href="/myAccount?page=${page}">${page }</a></li>
                                  </c:forEach>
                                 
                                </ul>
                            </nav>
                        </div>
							
						</div>
					</div>
					
					<div class="tab-pane fade" id="address-tab" role="tabpanel"
						aria-labelledby="address-nav">
						<h4>Address</h4>
						<div class="row">
							<div class="col-md-6">
								<h5>Payment Address</h5>
								<p>123 Payment Street, Los Angeles, CA</p>
								<p>Mobile: 012-345-6789</p>
								<button class="btn">Edit Address</button>
							</div>
							<div class="col-md-6">
								<h5>Shipping Address</h5>
								<p>123 Shipping Street, Los Angeles, CA</p>
								<p>Mobile: 012-345-6789</p>
								<button class="btn">Edit Address</button>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="account-tab" role="tabpanel"
						aria-labelledby="account-nav">
						<h4>Account Details</h4>
						<form:form action="/changeInfor" method="post" modelAttribute="userInfor">
						<div class="row">
							<div class="col-md-12">
								<form:input path="username" class="form-control" type="text" placeholder="UserName"/>
								<form:errors path="username" element="small"  class="text-danger"/>
							</div>
						
							<div class="col-md-6">
								<form:input path="sdt" class="form-control" type="text" placeholder="Phone"/>
								<form:errors path="sdt" element="small" class="text-danger"/>
							</div>
							<div class="col-md-6">
								<form:input path="email" class="form-control" type="email" placeholder="Email"/>
								<form:errors path="email" element="small" class="text-danger"/>
								<c:if test="${! empty email }">
								<small class="text-danger">${email }</small>
								</c:if>
							</div>
							<div class="col-md-12">
								<form:input path="address" class="form-control" type="text" placeholder="Address"/>
								<form:errors path="address" element="small" class="text-danger" />
							</div>
							<div class="col-md-12">
								<button class="btn">Update Account</button>
								<br> <br>
							</div>
						</div>
						</form:form>
						<h4>Password change</h4>
						<form action="/doi-mat-khau" method="post">
						<div class="row">
							<div class="col-md-12">
								<input class="form-control" required="required" name="password" type="password"
									placeholder="Current Password">
									<c:if test="${! empty password }">
									   <small class="text-danger">${password }</small>
									</c:if>
							</div>
							<div class="col-md-6">
								<input class="form-control" required="required" name="newPassword" type="password"
									placeholder="New Password">
									<c:if test="${! empty newPassword }">
									   <small class="text-danger">${newPassword }</small>
									</c:if>
							</div>
							<div class="col-md-6">
								<input class="form-control" required="required" name="passwordConfirm" type="password"
									placeholder="Confirm Password">
									<c:if test="${! empty passwordConfirm }">
									   <small class="text-danger">${passwordConfirm }</small>
									</c:if>
							</div>
							<div class="col-md-12">
								<button class="btn">Save Changes</button>
							</div>
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- My Account End -->

