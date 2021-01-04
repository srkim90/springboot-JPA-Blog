<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form action="/action_page.php">
		<div class="form-group">
			<label for="Username">Username</label> <input type="text"
				class="form-control" placeholder="Enter Username" id="Username">
		</div>
		<div class="form-group">
			<label for="email">Email address</label> <input type="email"
				class="form-control" placeholder="Enter email" id="email">
		</div>
		<div class="form-group">
			<label for="password">password</label> <input type="password"
				class="form-control" placeholder="Enter password" id="password">
		</div>			
	</form>
	<button id="btn-save" class="btn btn-primary">회원가입완료</button>
</div>
<script src="/blog/js/user.js"></script>

<%@ include file="../layout/footer.jsp" %>
