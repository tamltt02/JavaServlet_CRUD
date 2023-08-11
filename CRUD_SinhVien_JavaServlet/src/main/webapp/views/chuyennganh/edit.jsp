<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<h4>UPDATE</h4>
	<form id="form_create_product" action="/BaiTap/chuyen-nganh/update?id=${cn.id }" method="post">
	 <span style="color:red;">${error }</span>
        <div class="mb-3">
          <label for="" class="form-label"> Tên Chuyên Ngành : </label>
          <input
            type="text"
            class="form-control"
           name="tenChuyenNganh"
           value="${cn.ten }" required="required"
          />
         
        </div>
        
          
        <button class="btn btn-danger" type="submit">Sửa</button>
       
      </form>
      
