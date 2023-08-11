<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<h4>UPDATE</h4>
<form id="form_create_product" action="/BaiTap/lop/update?id=${ l.id }" method="post">
 <span style="color:red;">${error }</span>
	<div class="mb-3">
		<label for="" class="form-label">Tên lớp : </label> 
		<input type="text" 
			class="form-control"  name="tenLop" required="required" value="${l.ten }"/>
			
	</div>


	<div class="mb-3">
		<label for="" class="form-label">Môn : </label> <select
			id="inputState" class="form-select" name="mon" required="required">
			<option value="" disabled="disabled" selected>Choose...</option>
				 <c:forEach var="m" items="${dsm }">
				 <option value="${ m.id }" ${ l.mon.id == m.id ? "selected" : "" }
				 >${m.ten }</option>
				 </c:forEach>
		</select>
	</div>
		<div class="mb-3">
		<label for="" class="form-label">Chuyên ngành : </label> <select
			id="inputState" class="form-select" name="chuyenNganh" required="required">
			<option value="" disabled="disabled" selected>Choose...</option>
				 <c:forEach var="cn" items="${dscn }">
				 <option value="${ cn.id }" ${ l.chuyenNganh.id == cn.id ? "selected" : "" }
				 >${cn.ten }</option>
				 </c:forEach>
		</select>
	</div>
		<div class="mb-3">
		<label for="" class="form-label">Khóa: </label> 
		<input type="number"
			class="form-control"  name ="khoa" required="required" value="${ l.khoa}"/>
	</div>
	
	<br />

	<button class="btn btn-danger" type="submit">Sửa</button>

</form>

