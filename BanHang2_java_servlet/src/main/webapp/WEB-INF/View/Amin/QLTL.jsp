<%@ page language="java" session="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<main>
	<div class="container-fluid">
		<div class="row">
			<h1>Danh sách Thể loại</h1>
			<div class="col-12" style="background-color: rgb(233, 233, 232);">
				<h5 class="mt-3 mb-3">Trang chủ / Quản lý Thể loại</h5>
			</div>
			<form action="/category/index" method="get">
				<div class="col-10">

					<div class="row">
						<div class="form-group-input col-4">
							<label class="label" for="">Sắp xếp</label> <select
								class="form-select" name="fiel" id="">
								<option value="id" ${fiel == 'id' ? 'selected' :'' }>Id</option>
								<option value="name" ${fiel == 'name' ? 'selected' :'' }>Name</option>
							</select>
						</div>
						<div class="form-group-input col-4">
							<label class="label" for="">Tăng Giảm</label> <select
								class="form-select" name="direction" id="">
								<option value="asc" ${direction == 'asc' ? 'selected' :'' }>Tăng
									dần</option>
								<option value="desc" ${direction == 'desc' ? 'selected' : '' }>Giảm
									dần</option>
							</select>
						</div>
						<div class="col-4 mt-4">
							<div class="row">
								<div class="col-8">
									<input type="text" class="form-control" name="name" id=""
										value="${name }" placeholder="Họ tên">
								</div>
								<div class="col-4">
									<button class="btn btn-outline-secondary">Tìm kiếm</button>
								</div>
							</div>

						</div>
					</div>

				</div>

			</form>
			<div class="col-12 text-center">
			<c:if test="${! empty sessionScope.message }">${ sessionScope.message }</c:if>
			<c:remove var="message" scope="session"/>
			</div>
		</div>
		<div class="row mt-5">
			<div class="col-2">
				<a href="/category/create" class="btn btn-success"> <i
					class="bi bi-phone"></i>
				</a>
			</div>
			<table class="table table-light">
				<thead class="thead-light">
					<tr>
						<th>ID</th>
						<th>Tên Thể loại</th>
						<th>Ghi chú</th>
						<th colspan="2">Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ca" items="${categories.getContent() }">
						<tr>
							<td>${ca.id }</td>
							<td>${ca.name }</td>
							<td>${ca.note }</td>
							<td><a href="/category/edit/${ca.id }"
								class="btn btn-warning">Edit</a></td>
							<td>
								<button class="btn btn-danger" data-bs-toggle="modal"
									data-bs-target="#exampleModal${ca.id }">Delete</button> <!-- Button trigger modal -->
								<!-- Modal -->
								<div class="modal fade" id="exampleModal${ca.id }" tabindex="-1"
									aria-labelledby="exampleModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">Xác nhận</h5>
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
													href="/category/delete/${ca.id }">Xác nhận</a>
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

							<c:forEach var="page" begin="1" end="${pagecount }">
								<li
									class="page-item ${page == categories.getNumber()+1 ? 'active' : '' }"><a
									class="page-link"
									href="/category/index?
					fiel=${param.fiel == null ? 'id' : param.fiel  }
					&direction=${param.direction == null ? 'asc' : param.direction  }
					&page=${page}&name=${name }">${page }
								</a></li>

							</c:forEach>

						</ul>
					</nav>
				</div>
			</div>

		</div>
	</div>
</main>