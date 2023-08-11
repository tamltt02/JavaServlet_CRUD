 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<table class="table table-striped">
<%! int stt = 0; %>
	<thead>
	<td>STT</td>
		<td>Tên lớp</td>
		<td>Môn</td>
		<td>Chuyên ngành</td>
		<td>Khóa</td>
		<td>Function</td>
	</thead>
	<tbody>
		<c:forEach var="l" items="${ dsl }">
		<tr>
		<td class="personid"></td>
			<td>${l.ten }</td>
			<td>${l.mon.ten }</td>
			<td>${l.chuyenNganh.ten }</td>
			<td>${l.khoa }</td>
			<td>
				<a class="btn btn-success" type="button" href="/BaiTap/lop/edit?id=${l.id }"  >
					Sửa</a>
				<a class="btn btn-danger" type="button" href="/BaiTap/lop/delete?id=${l.id }"  >
					Xóa</a>
					
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<script>
var count =1;
var list = document.getElementsByClassName("personid");
for (var i = 0; i <= list.length; i++) {
    list[i].innerHTML = count;
    count++;
}
</script>