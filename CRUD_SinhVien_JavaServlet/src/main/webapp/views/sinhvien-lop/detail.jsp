<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%!int stt = 0;%>
 	<br>
	<form action="/BaiTap/sv-lop/search" method="post">
		<div class="row">
			<div class="col-4">
			<div class="mb-3">
		        
				<select id="inputState" class="form-select" name="lop" required="required">
					<option value="" disabled="disabled" selected>Chọn lớp</option>
    				 <c:forEach var="l" items="${dsl }">
					 <option value="${ l.id }" >${l.ten }</option>
					 	</c:forEach>
				</select>
			</div>
	 		</div>
	 		<div class="col-3">
	 		<button class="btn btn-danger" type="submit">Search</button>
		 	</div>
		 </div>
	</form>
<div class="row">
<div class="col-6">

	<div class="mb-3">
		
		<label for="" class="form-label">Tên lớp : </label> 
		<input type="text"
			class="form-control"  name="tenLop" value="${lop.ten }" disabled="disabled"/>
	</div>


	<div class="mb-3">
		<label for="" class="form-label">Môn : </label> 
			<input type="text"
			class="form-control"  name="tenLop" value="${lop.mon.ten }" disabled="disabled"/>
	</div>
	</div>
	<div class="col-6">
		<div class="mb-3">
		<label for="" class="form-label">Chuyên ngành : </label> <input type="text"
			class="form-control"  name="tenLop" disabled="disabled" value="${lop.chuyenNganh.ten }"/>
	</div>
		<div class="mb-3">
		<label for="" class="form-label">Khóa: </label> 
		<input type="text"
			class="form-control"  name ="khoa" disabled="disabled" value="${lop.khoa }"/>
	</div>
		</div>
</div>
	<div class="row">
	 
	<div class="col-1">
	<a type="button" class="btn btn-info" href="/sv-lop/import" data-toggle="modal" data-target="#myModal">Import</a>
		 
		  <!-- Modal -->
		  <div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog modal-lg">
		      <div class="modal-content">
		        <div class="modal-header">
		         
		          <h4 class="modal-title">Import</h4>
		           <button type="button" class="close" data-dismiss="modal">&times;</button>
		        </div>
		        <form action="/BaiTap/sv-lop/import" method="post" enctype="multipart/form-data" id="myForm">
		        <div class="modal-body">
		          <div class="input-group">
				  <input type="file" class="form-control" aria-describedby="inputGroupFileAddon04" aria-label="Upload" name="file" id="file" required="required" accept=".xlsx">
				  <a class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04" href="/BaiTap/sv-lop/taimau">Mẫu Import</a>
</div>
		        </div>
		        <div class="modal-footer">
		          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		           <button type="submit" class="btn btn-success" >Import</button>
		        </div>
		        </form>
		      </div>
		    </div>
		  </div>
		
		<!-- Kết thúc modal -->
	</div>
	<div class="col-1"> 
	 <a class="btn btn-primary" href="/BaiTap/sv-lop/export" role="button">Export</a>
	</div>
	<span style="color: red">${error }</span>
	</div>
<div class="row">
	<div class="col-6" >
		<table class="table table-striped">
			<thead>
				<td>STT</td>
				<td>Họ tên</td>
				<td>Email</td>
				<td>Đ/c</td>
				<td>SĐT</td>
				<td>GT</td>
				<td>CN</td>
				<td>Function</td>
			</thead>
			<tbody>
				<c:forEach var="sv" items="${ dssv }">
					<tr>
						<td class="stt"></td>
						<td>${ sv.hoTen }</td>
						<td><p style="overflow: hidden;text-overflow : ellipsis;width: 100px;white-space: nowrap;">${ sv.email }</p></td>
						<td>${ sv.diaChi }</td>
						<td>${ sv.sdt }</td>
						<td>${ sv.gioiTinh == 1 ? "Nam" : "Nữ" }</td>
						<td>${ sv.chuyenNganh.ten }</td>
						<td>
						<a
							class="btn btn-danger"
							href="/BaiTap/sv-lop/them?idsv=${sv.id }&idlop=${lop.id}"> Thêm</a></td>
					</tr>
				</c:forEach> 
			</tbody>
		</table>
	</div>
	<div class="col-6">
	<table class="table table-striped">
			<thead>
				<td>STT</td>
				<td>Họ tên</td>
				<td>Email</td>
				<td>GT</td>
				<td>ĐTB</td>
				<td>Trạng thái</td>
				<td>Function</td>
			</thead>
			<tbody>
			 	<c:forEach var="svlop" items="${ dssvlop }">
					<tr>
						<td class="personid"></td>
						<td>${ svlop.sinhVien.hoTen }</td>
						<td><p style="overflow: hidden;text-overflow : ellipsis;width: 100px;white-space: nowrap;">${ svlop.sinhVien.email } </p></td>
						<td>${ svlop.sinhVien.gioiTinh == 1 ? "Nam" : "Nữ" }</td>
						<td>${ svlop.diemTb }</td>
						<td>${ svlop.trangThai == 0 ? "Học" :"không" }</td>
						<td><button class="btn btn-success" data-toggle="modal" data-target="#myModal1"
							> Sửa</button> 
							<a 
							class="btn btn-danger"
							href="/BaiTap/sv-lop/delete?idsvl=${svlop.id }"> Xóa</a></td>
					</tr>
					   <!-- The Modal -->
					      <div class="modal fade" id="myModal1">
					        <div class="modal-dialog modal-dialog-centered">
					          <div class="modal-content">
					            <!-- Modal Header -->
					            <div class="modal-header">
					              <h4 class="modal-title">Sửa ĐTB</h4>
					              <button type="button" class="close" data-dismiss="modal">
					                &times;
					              </button>
					            </div>
					
					            <!-- Modal body -->
					             <form action="/BaiTap/sv-lop/update?idsvl=${svlop.id }" method="post">
					            <div class="modal-body">
					           
					            <label for="" class="form-label">Điểm TB: </label> 
							<input type="text"
								class="form-control"  name="diemTb" value="${svlop.diemTb}" />
								<span style="color: red">${error }</span>
					            </div>
					
					            <!-- Modal footer -->
					            <div class="modal-footer">
					              <button
					                type="submit"
					                class="btn btn-success"  
					              >
					                Sửa
					              </button>
					                    <button
					                type="button"
					                class="btn btn-success"  
					                data-dismiss="modal"
					              >
					                Đóng
					              </button>
					            </div>
					            </form>
					          </div>
					        </div>
					      </div>
					      <!-- Kết thúc modal -->
				</c:forEach> 
			</tbody>
		</table></div>
</div>


<script>
	var count = 1;
	var list = document.getElementsByClassName("personid");
	for (var i = 0; i <= list.length; i++) {
		list[i].innerHTML = count;
		count++;
	}
</script>
<script>
	var count = 1;
	var list = document.getElementsByClassName("stt");
	for (var i = 0; i <= list.length; i++) {
		list[i].innerHTML = count;
		count++;
	}
</script>

<script type="text/javascript">
  $('#myForm').on('submit', function(e) {
   // var file = $('#file');
    // Check if there is an entered value
 // if(!file.endsWith(".xls") || !file.endsWith(".xlsx")) {
      // Remove the errors highlight
    	 alert("Không trống ");
    
  });
</script>