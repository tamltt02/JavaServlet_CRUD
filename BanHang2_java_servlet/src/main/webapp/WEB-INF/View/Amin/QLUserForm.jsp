<%@ page language="java" session="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<main >

	<div class="container-fluid">
		<div class="row" >
			<h1>Danh sách User</h1>
			<div class="col-12" style="background-color: rgb(233, 233, 232);">
				<h5 class="mt-3 mb-3">Trang chủ / Quản lý User</h5>
			</div>
			<div class="col-8 offset-2 me-5 mt-5 " >
				<form:form action="/user/${save }" modelAttribute="user"
					method="post" enctype="multipart/form-data">
					<div class="row">
					<div class="col-12 text-center"> <h3>Form Quản lý User</h3> </div>
						<div class="col-3">
						
						</div>
						<div class="col-7 mt-4">
							<div class="row">
								<c:if test="${save == 'store' }">
								<div class="row">

									<div class="form-input-group">
										
											<label for="">Email</label>  <form:input type="email"
										class="form-control" path="email" name="hoTen"  />
										<form:errors path="email" element="small" class="text-danger"></form:errors>
										<c:if test="${!empty email }">
										<small class="text-danger">${email }</small>
										</c:if>
									</div>
								</div>
								</c:if>
								<div class="row">
									<div class="col-6 form-input-group mt-4">
										<label for="">Họ Tên</label>
										<form:input type="text" class="form-control" path="username"
											name="hoTen" />
											<form:errors path="username" element="small" class="text-danger"></form:errors>
									</div>
									<div class="col-6 form-input-group mt-4">
										<label for="">Password</label>  <form:input type="password"
										class="form-control" path="password" name="password" />
										<form:errors path="password" element="small" class="text-danger"></form:errors>
									</div>
								</div>
							<div class="row">
								<div class=" form-input-group mt-4">
									<label for="">Địa chỉ</label> <form:input type="text"
										class="form-control" path="address" name="hoTen"/>
										<form:errors path="address" element="small" class="text-danger"></form:errors>
								</div>
							</div>
								<div class="row">
								<div class="form-input-group mt-4 mb-3">
									<label for="">SĐT</label> <form:input type="text"
										class="form-control" path="sdt" name="hoTen"/>
										<form:errors path="sdt" element="small" class="text-danger"></form:errors>
								</div>
								</div>
								<div class="row">
								<div class="form-input-group mt-4 mb-3">
									<label class="me-4">Phần quyền</label> <form:radiobutton 
										class="form-check-input mx-2" path="admin" value="1" label="Admin"/>
									<form:radiobutton 
										class="form-check-input mx-2" path="admin" value="0" label="User"/>
								</div>
								</div>

								</div>
								<div class="col-12  mx-5 mt-3">
								<button type="reset" class="btn btn-secondary">Reset</button>
								<a href="/user/index" class="btn btn-success">Quản lý User</a>
										<button type="button" class="btn btn-primary"
										data-bs-toggle="modal" data-bs-target="#exampleModalLong">${save == 'store' ? 'Thêm mới' : 'Cập nhật' }
									</button>

									<!-- Modal -->
									<div class="modal fade" id="exampleModalLong" tabindex="-1"
										role="dialog" aria-labelledby="exampleModalLongTitle"
										aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLongTitle">Xác nhận</h5>
													<button type="button" class="close" data-bs-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">
												Bạn có muốn ${save == 'store' ? 'Thêm' : 'Cập nhật'} không ?
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-bs-dismiss="modal">Close</button>
													<button type="submit" class="btn btn-primary">Save
														changes</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

						</div>
					<form:input path="id" type="hidden"/>






				</form:form>
			</div>

		</div>
	</div>

</main>