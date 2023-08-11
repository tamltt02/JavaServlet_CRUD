<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main>
	<div class="container-fluid">
		<div class="row">
			<h1>Danh sách sản phẩm</h1>
			<div class="col-12" style="background-color: rgb(233, 233, 232);">
				<h5 class="mt-3 mb-3">Trang chủ / Quản lý đơn hàng</h5>
			</div>
		
			<table class="table table-light  mt-3">
				<thead class="thead-light">
					<tr>
						<th>ID</th>
						<th>Tên Khác hàng</th>
						<th>SĐT</th>
						<th>Địa chỉ</th>

						<th>Tình trạng</th>
						<th>Tổng giá</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${list }">
						<tr>
							<td>${item.id }</td>
							<td>${item.user.username }</td>
							<td>${item.user.sdt }</td>
							<td>${item.user.address }</td>
							<td><c:choose>
									<c:when test="${item.status == 0 }">Chờ xác nhận</c:when>
									<c:when test="${item.status == 1 }">Đang giao hàng</c:when>
									<c:when test="${item.status == 2 }">Đã giao hàng </c:when>
									<c:when test="${item.status == 3 }">Đã hủy</c:when>
								</c:choose></td>

							<td>$${item.total }</td>

							<td><button class="btn btn-warning" data-bs-toggle="modal"
									data-bs-target="#exampleModal${item.id }">Chi tiết</button> <!-- Button trigger modal -->

								<!-- Modal -->
								<div class="modal fade" id="exampleModal${item.id }"
									tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
									aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">Hóa đơn
													chi tiết</h5>
												<button type="button" class="close" data-bs-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">
												<table class="table table-light  mt-3">
													<thead class="thead-light">
														<tr>
															<th>ID</th>
															<th>Sản phẩm</th>
															<th>Mã Hóa đơn</th>
															<th>Số lượng</th>

															<th>Giá</th>
															<th>Thành tiền</th>

														</tr>
													</thead>
													<tbody>
														<c:forEach var="o" items="${item.orderDetails }">
															<tr>
																<td>${o.id }</td>
																<td>${o.heo.name }</td>
																<td>${o.order.id }</td>
																<td>${o.quantity }</td>
																<td>${o.price }</td>
																<td>${o.quantity * o.price }</td>

															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
											<div class="modal-footer">
												<a type="button" class="btn btn-danger"
													href="/delete-order/${item.id }">Hủy</a> <a type="button"
													class="btn btn-primary" href="/order/${item.id }">Xác
													nhận</a>
											</div>
										</div>
									</div>
								</div></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</main>