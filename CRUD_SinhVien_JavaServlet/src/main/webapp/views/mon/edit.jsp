<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h4>UPDATE</h4>
	<form id="form_create_product" action="/BaiTap/mon/update?id=${ m.id } " method="post">
	 <span style="color:red;">${error }</span>
        <div class="mb-3">
          <label for="" class="form-label"> Tên môn : </label>
          <input
            type="text"
            class="form-control"
           name ="tenMon" required="required"
           value="${m.ten }"
           
          />
          
        </div>
        <div class="mb-3">
          <label for="" class="form-label">Học kỳ : </label>
          <input
            type="number"
            class="form-control"
            name ="hocKy" required="required"
               value="${m.hocKy }"
          />
        </div>
        <div class="mb-3">
          <label for="" class="form-label">Số tín chỉ : </label>
          <input
            type="number"
            class="form-control"
           name="soTinChi" required="required"
              value="${m.soTinChi }"
          />
       </div>
       
        <br />

        <button class="btn btn-danger" type="submit">Sửa</button>
       
      </form>
      
