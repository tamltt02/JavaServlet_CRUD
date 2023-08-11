<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<table class="table table-striped">
	<thead>
	<td>STT</td>
		<td>Tên Chuyên Ngành</td>
		<td>Function</td>
	</thead>
	<tbody>
			<c:forEach var="cn" items="${dscn }">
			<tr>
			<td class="personid"></td>
				<td>${ cn.ten }</td>
			<td>
				<a class="btn btn-success" type="button" href="/BaiTap/chuyen-nganh/edit?id=${cn.id }"  >
					Sửa</a>
				<a class="btn btn-danger" type="button" href="/BaiTap/chuyen-nganh/delete?id=${cn.id }"  >
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