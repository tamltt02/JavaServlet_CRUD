<%@ page language="java" session="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<main>
	<div class="container-fluid mb-5" style="background-color:  rgb(233, 233, 232);">
		<div class="row" >
			<h1> Quản lý Thể loại </h1>
			<div class="col-12" style="background-color:lightgray;">
				<h5 class="mt-3 mb-3">Trang chủ / Quản lý Thể loại</h5>
			</div>
		    <div class="col-8 offset-4 mt-5 fw-bold">
		    <h1> Form Quản lý Thể loại</h1>
		         <form:form action="/category/${ sessionScope.save }" modelAttribute="categoryDTO" method="POST">
		            <div class="col-6 form-group-input">
		            
		             <form:input path="id" disabled="${sessionScope.save == 'store' ? 'true' :'false' }" type="hidden" class="form-control"/>
		             
		            </div>
		            <br>
		             <div class="col-6 form-group-input">
		             <label>Tên thể loại</label>
		              <form:input path="name" class="form-control"/>
		              <form:errors path="name" element="small" class="text-danger"/>
		            </div>
		             <br>
		             <div class="col-6 form-group-input">
		             <label>Ghi chú</label>
		             <form:input path="note" class="form-control"/>
		            </div>
		             <br>
		              <div class="col-6 form-group-input mt-4 mb-5 mx-5">
		            <a href="/category/create" class="btn btn-secondary">Reset</a>
		             <a href="/category/index" class="btn btn-success">Quản lý thể loại</a>
		             <button type="button" class="btn btn-primary"
										data-bs-toggle="modal" data-bs-target="#exampleModalLong">${sessionScope.save == 'store' ? 'Save':'Update' }
									</button>
		             
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
												Bạn có muốn ${sessionScope.save == 'store' ? 'Thêm':'Cap nhat' } không ?
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
		         </form:form>
		    </div>
		</div>
	    
	     </div>
	      

		
</main>