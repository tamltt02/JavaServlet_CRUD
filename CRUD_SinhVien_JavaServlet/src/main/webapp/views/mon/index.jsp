<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<table class="table table-striped">
<%! int stt = 0; %>
	<thead>
	<td> STT </td>
		<td>Tên môn</td>
		<td>Học kỳ</td>
		<td>Số tín chỉ</td>
		<td>Function</td>
	</thead>
	<tbody>
	<c:forEach var="m" items="${ dsm }">
		<tr>
			<td class="personid"></td>
			<td>${m.ten }</td>
			<td>${m.hocKy }</td>
			<td>${m.soTinChi }</td>
			<td>
				<a class="btn btn-success" type="button" href="/BaiTap/mon/edit?id=${m.id }"  >
					Sửa</a>
				<a class="btn btn-danger" type="button" href="/BaiTap/mon/delete?id=${m.id }"  >
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