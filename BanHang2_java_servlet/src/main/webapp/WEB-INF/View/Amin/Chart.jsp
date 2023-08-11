<%@ page language="java" session="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<main >
	<div class="container-fluid">
		<div class="row">
			<h1>Biểu đồ</h1>
			<div class="col-12" style="background-color: rgb(233, 233, 232);">
				<h5 class="mt-3 mb-3">Trang chủ / Biểu đồ năm 2022</h5>
			</div>
			 <div class="col-9 offset-2 mt-5">
            <canvas id="myChart"></canvas>
        </div>
		</div>
	</div>
	
</main>
<script >
const labels = [
  ];
const dataC = [
	  ];
  const dataChart = [];
  const index = 0;
   <c:forEach items="${chart}" var="ch"> 
   labels.push('Tháng ' + ${ch[0]});
   dataC.push(${ch[1]})
   
   </c:forEach>
 
  
  const data = {
    labels: labels,
    datasets: [{
      label: 'Doanh thu Thang',
      backgroundColor: 'rgb(255, 99, 132)',
      borderColor: 'rgb(255, 99, 132)',
      data: dataC,
    }]
  };

  const config = {
    type: 'line',
    data: data,
    options: {}
  };
 
const myChart = new Chart(
document.getElementById('myChart'),
config
);
</script>
