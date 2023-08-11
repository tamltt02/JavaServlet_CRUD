<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file ="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <%@ include file ="/common/head.jsp" %>
<!--
    
TemplateMo 556 Catalog-Z

https://templatemo.com/tm-556-catalog-z

-->
</head>
<body>
    <%@ include file ="/common/header.jsp" %>
    
    <div class="container-fluid tm-mt-60">
        <div class="row tm-mb-50">
            <div class="col-lg-12 col-12 mb-5">
                <center><h2 class="tm-text-primary mb-5">Forgot Password</h2></center>
                <form id="login-form" action="forgot" method="POST" class="tm-contact-form mx-auto">
                    <div class="form-group">
                        <input type="email" name="email" class="form-control rounded-0" placeholder="Email" required />
                    </div>
                    <div class="form-group tm-text-right">
                       <center><button type="submit" class="btn btn-primary">Send</button></center> 
                    </div>
                </form>  
         
            </div>
        </div>
           <div class="row">
			<div class="col">
				<c:if test="${not empty message }">
					<div class="alert alert-success">${ message }</div>
				</c:if>
				<c:if test="${not empty error }">
					<div class="alert alert-success">${ error }</div>
				</c:if>
			</div>
		</div>
          
    </div> <!-- container-fluid, tm-container-content -->

   <%@ include file ="/common/foooter.jsp" %>
</body>
</html>