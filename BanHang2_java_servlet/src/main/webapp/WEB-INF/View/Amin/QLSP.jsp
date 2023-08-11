<%@ page language="java" session="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main>

	<div class="container-fluid">
		<div class="row">
			<h1>Danh sách sản phẩm</h1>
			<div class="col-12" style="background-color: rgb(233, 233, 232);">
				<h5 class="mt-3 mb-3">Trang chủ / Quản lý Sản phẩm</h5>
			</div>
			<form action="/heo/index" method="get">
				<div class="col-10 mt-4">

					<div class="row">
						<div class="form-group-input col-2">
							<label class="label" for="">Sắp xếp</label> <select
								class="form-select" name="fiel" id="">
								<option value="id" ${fiel == 'id' ? 'selected' : '' }>ID</option>
								<option value="name" ${fiel == 'name' ? 'selected' : '' }>Name</option>
								<option value="quantity"
									${fiel == 'quantity' ? 'selected' : '' }>Số lượng</option>
								<option value="price" ${fiel == 'price' ? 'selected' : '' }>Đơn
									giá</option>

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
										value="${name }" placeholder="Tên Sản Phẩm">
								</div>
								<div class="col-4">
									<button class="btn btn-outline-secondary">Tìm kiếm</button>
								</div>
							</div>

						</div>
					</div>


				</div>
				<div class="col-12 mt-3 text-center">
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

			</form>
			<!-- Button trigger modal -->
			<!-- Modal -->
			<div class="row mt-5">
				<div class="col-2">
					<a class="btn btn-success" href="/heo/create"> <i
						class="bi bi-phone"></i>
					</a>
				</div>
				<table class="table table-light">
					<thead class="thead-light">
						<tr>
							<th>ID</th>
							<th>Tên Sản phẩm</th>
							<th>Thể loại</th>
							<th>Ngày Tạo</th>
							<th>Số lượng</th>
							<th>Đơn giá</th>
							<th>Màu Sắc</th>
							<th>Cân Nặng</th>
							<th>Hình ảnh</th>
							<th colspan="2">Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${items.getContent() }">
							<tr>
								<td>${p.id }</td>
								<td>${p.name }</td>
								<td>${p.category.name }</td>
								<td>${p.createDate }</td>

								<td>${p.quantity }</td>
								<td>$${p.price }</td>
								
								<td>${p.color }</td>
								<td>${p.weight }Kg</td>
								<td><img alt="" class="img-fluid"
									src="/storage/${p.image }" height="200px" width="200px">

								</td>

								<td><a class="btn btn-warning" href="/heo/edit/${p.id }">Edit</a>

								</td>
								<td>
									<button class="btn btn-danger" data-bs-toggle="modal"
										data-bs-target="#delete${p.id }">Delete</button>
									<div class="modal fade" id="delete${p.id }" tabindex="-1"
										aria-labelledby="exampleModalLabel" aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="delete${p.id }">Xác nhận</h5>
													<button type="button" class="btn-close"
														data-bs-dismiss="modal" aria-label="Close"></button>
												</div>
												<div class="modal-body">
													<h5>Bạn có muốn xóa ?</h5>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-bs-dismiss="modal">Đóng</button>
													<a type="button" class="btn btn-primary"
														href="/heo/delete/${p.id }">Xác nhận</a>
												</div>
											</div>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="row">
					<div class="col-6 offset-5">

						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<c:if test="${ items.getNumber()>0 }">
									<li class="page-item "><a class="page-link"
										href="/heo/index?direction=${direction == null ?'asc' : direction }&
									fiel=${fiel == null ?  'id' : fiel }&name=${name }&page=${items.getNumber()}"
										tabindex="-1">Previous</a></li>
								</c:if>
								<c:forEach var="page" begin="1" end="${items.getTotalPages() }">
									<li
										class="page-item ${page == items.getNumber() + 1 ?'active' :'' }"><a
										class="page-link"
										href="/heo/index?fiel=${param.fiel == null ? 'id' : param.fiel  }
					&direction=${param.direction == null ? 'asc' : param.direction  }
					&page=${page}&name=${name}">${page }
									</a></li>

								</c:forEach>
								<c:if test="${ items.getNumber()+1< items.getTotalPages() }">
									<li class="page-item"><a class="page-link"
										href="/heo/index?direction=${direction == null ?'asc' : direction }&
									fiel=${fiel == null ?  'id' : fiel }&name=${name }&page=${items.getNumber() + 2} ">Next</a>
									</li>
								</c:if>

							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>