<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<table class="table table-striped">
<%! int stt = 0; %>
	<thead>
	<td> STT </td>
		<td>Họ tên</td>
		<td>Email</td>
		<td>Địa chỉ</td>
		<td>Số điện thoại</td>
		<td>Giới tính</td>
		<td>Chuyên ngành</td>
		<td>Function</td>
	</thead>
	<tbody>
	<c:forEach var="sv" items="${ dssv }">
			<tr>
			<td class="personid"></td>
				<td>${ sv.hoTen }</td>
				<td>${ sv.email }</td>
				<td>${ sv.diaChi }</td>
				<td>${ sv.sdt }</td>
				<td>${ sv.gioiTinh == 1 ? "Nam" : "Nữ" }</td>
				<td>${ sv.chuyenNganh.ten }</td>
				<td>
				<a class="btn btn-success" href="/BaiTap/sinh-vien/edit?id=${sv.id }"  >
					Sửa</a>
				<a class="btn btn-danger" href="/BaiTap/sinh-vien/delete?id=${sv.id }"  >
					Xóa</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
	 <span style="color:red;">${loi }</span> 
 <br>
<script>
var count =1;
var list = document.getElementsByClassName("personid");
for (var i = 0; i <= list.length; i++) {
    list[i].innerHTML = count;
    count++;
}
</script>