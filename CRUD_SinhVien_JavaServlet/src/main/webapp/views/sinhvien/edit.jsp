<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
	<h4>UPDATE</h4>
	<form id="form_create_product" action="/BaiTap/sinh-vien/update?id=${sv.id }" method="post">
	 <span style="color:red;">${error }</span>
        <div class="mb-3">
          <label for="" class="form-label"> Họ tên : </label>
          <input
            type="text"
            class="form-control"
           name="tenSV"  required="required"
           value="${sv.hoTen }"
          />
           
        </div>
        <div class="mb-3">
          <label for="" class="form-label">Email : </label>
          <input
            type="email"
            class="form-control"
            name="email"  required="required"
         value=" ${sv.email }"  
          />
          
        </div>
        <div class="mb-3">
          <label for="" class="form-label">Số điện thoại : </label>
          <input
            type="text"
            class="form-control"
           name="sdt"  required="required"
          value="${sv.sdt }" 
          />
       </div>
        <div class="mb-3">
          <label for="" class="form-label">Địa chỉ  : </label>
          <input
            type="text"
            class="form-control"
           name ="diaChi"  required="required"
           value="${sv.diaChi }"
          />
       </div>
      <label for="" class="form-label">Giới tính  : </label>
     <div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio1" value="1" ${sv.gioiTinh ==1 ?"checked":""}>
  <label class="form-check-label" for="inlineRadio1">Nam</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio2" value="0" ${sv.gioiTinh ==0 ?"checked":""}>
  <label class="form-check-label" for="inlineRadio2">Nữ</label>
</div>
        <div class="mb-3">
          <label for="" class="form-label">Chuyên Ngành : </label>
          <select id="inputState" class="form-select" name="chuyenNganh" required="required">
       <option value="" disabled="disabled" selected>Choose...</option>
    	
				 <c:forEach var="cn" items="${dscn }">
				 <option value="${ cn.id }" ${ sv.chuyenNganh.id == cn.id ? "selected" : "" }
				 >${cn.ten }</option>
				 </c:forEach>
    </select>
       </div>
        
        <br />

        <button class="btn btn-danger" type="submit">Sửa</button>
       
      </form>
      
