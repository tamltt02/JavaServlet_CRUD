<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h4>CREATE</h4>
	<form id="form_create_product" action="/BaiTap/mon/store" method="post">
	 <span style="color:red;">${error }</span>
        <div class="mb-3">
          <label for="" class="form-label"> Tên môn : </label>
          <input
            type="text"
            class="form-control"
           name ="tenMon" required="required"
          />
          
        </div>
        <div class="mb-3">
          <label for="" class="form-label">Học kỳ : </label>
          <input
            type="number"
            class="form-control"
            name ="hocKy" required="required"
          />
        </div>
        <div class="mb-3">
          <label for="" class="form-label">Số tín chỉ : </label>
          <input
            type="number"
            class="form-control"
           name="soTinChi" required="required"
          />
       </div>
       
        <br />

        <button class="btn btn-danger" type="submit">Thêm</button>
       
      </form>
      
