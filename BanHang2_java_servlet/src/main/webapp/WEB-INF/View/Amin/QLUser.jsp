<%@ page language="java" session="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<main>
	<div class="container-fluid">

		<div class="row">
			<h1>Danh sách người dùng</h1>
			<div class="col-12" style="background-color: rgb(233, 233, 232);">
				<h5 class="mt-3 mb-3">Trang chủ / Quản lý User</h5>
			</div>

			<form action="/user/index">
				<div class="col-10 mt-4">

					<div class="row">
						<div class="form-group-input col-2">
							<label class="label" for="">Sắp xếp</label> <select
								class="form-select" name="fiel" id="">
								<option value="id" ${fiel == 'id' ? 'selected' : '' }>ID</option>
								<option value="username"
									${fiel == 'username' ? 'selected' : '' }>Name</option>
								<option value="sdt" ${fiel == 'sdt' ? 'selected' : '' }>SĐT</option>
								<option value="email" ${fiel == 'email' ? 'selected' : '' }>Email</option>
								<option value="address" ${fiel == 'address' ? 'selected' : '' }>Địa
									chỉ</option>

							</select>
						</div>
						<div class="form-group-input col-4">
							<label class="label" for="">Tăng Giảm</label> <select
								class="form-select" name="direction" id="">
								<option value="asc" ${direction == 'asc' ? 'selected' : '' }>Tăng
									dần</option>
								<option value="desc" ${direction == 'desc' ? 'selected' : '' }>Giảm
									dần</option>
							</select>
						</div>
						<div class="col-4 mt-4">

							<div class="row">
								<div class="col-8">
									<input type="text" class="form-control" name="name" id=""
										value="${name }" placeholder="Name">
								</div>
								<div class="col-4">
									<button class="btn btn-outline-secondary">Tìm kiếm</button>
								</div>
							</div>

						</div>
					</div>


				</div>
			</form>
			<div class="col-12 text-center mt-3">
				<div>
					<c:if test="${!empty sessionScope.message }">
						<label class="alert alert-success">${sessionScope.message }</label>
						<c:remove var="message" scope="session" />
					</c:if>

				</div>
				<div>
					<c:if test="${!empty sessionScope.error }">
						<label class="alert alert-danger">${sessionScope.error }</label>
						<c:remove var="error" scope="session" />
					</c:if>

				</div>

			</div>

		</div>
		<div class="row">
			<div class="col-2">
				<a type="button" class="btn btn-success" href="/user/create"> <i
					class="bi bi-phone"></i>
				</a>
			</div>
			<table class="table table-light">
				<thead class="thead-light">
					<tr>
						<th>ID</th>
						<th>Họ tên</th>
						<th>SDT</th>
						<th>Email</th>
						<th>Địa chỉ</th>
						<th>Phân quyền</th>
						<th colspan="2">Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${ items.getContent()}">
						<tr>
							<td>${user.id }</td>
							<td>${user.username }</td>
							<td>${user.sdt }</td>
							<td>${user.email }</td>
							<td>${user.address }</td>
							<td>${user.admin == 1 ? 'Admin' : 'User'}</td>
							<td><a class="btn btn-warning" href="/user/edit/${user.id }">Edit</a></td>

							<td>
								<button class="btn btn-danger" data-bs-toggle="modal"
									data-bs-target="#exampleModal${user.id }">Delete</button> <!-- Button trigger modal -->
								<!-- Modal -->
								<form action="/user/delete/${user.id }" method="post">
									<div class="modal fade" id="exampleModal${user.id }"
										tabindex="-1" aria-labelledby="exampleModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Xác
														nhận</h5>
													<button type="button" class="btn-close"
														data-bs-dismiss="modal" aria-label="Close"></button>
												</div>
												<div class="modal-body">
													<h5>Bạn có muốn xóa ?</h5>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-bs-dismiss="modal">Đóng</button>
													<button class="btn btn-primary">Xác nhận</button>
												</div>
											</div>
										</div>
									</div>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="row justify-content-center">
				<div class="col-3"></div>
				<div class="col-6">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<c:if test="${ items.getNumber()>0 }">
								<li class="page-item "><a class="page-link"
									href="/user/index?direction=${direction == null ?'asc' : direction }&
									fiel=${fiel == null ?  'id' : fiel }&name=${name }&page=${items.getNumber()}"
									tabindex="-1">Previous</a></li>
							</c:if>
							<c:forEach var="p" begin="1" end="${items.getTotalPages() }">
								<li
									class="page-item ${p == items.getNumber()+1 ? 'active' :'' }"><a
									class="page-link"
									href="/user/index?direction=${direction == null ?'asc' : direction }&
									fiel=${fiel == null ?  'id' : fiel }&name=${name }&page=${p}">${p }</a></li>
							</c:forEach>
							<c:if test="${ items.getNumber()+1< items.getTotalPages() }">
								<li class="page-item"><a class="page-link"
									href="/user/index?direction=${direction == null ?'asc' : direction }&
									fiel=${fiel == null ?  'id' : fiel }&name=${name }&page=${items.getNumber() + 2} ">Next</a>
								</li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
		</div>

	</div>
</main>