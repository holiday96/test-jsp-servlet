<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>
<!DOCTYPE html>
<html>

<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<c:if test="${not empty message}">
				<div class="alert alert-${alert}">
					<strong>${message}</strong>
				</div>
			</c:if>
			<!-- Tabs Titles -->

			<!-- Icon -->
			<div class="fadeIn first">
				<img
					src="https://i.pinimg.com/564x/00/f5/b7/00f5b78fd6f153476510deb931641e74.jpg"
					id="icon" alt="User Icon" />
			</div>

			<!-- Login Form -->
			<form action="<c:url value='/login'/>" id="formLogin" method="post">
				<input type="text" id="userName" class="fadeIn second"
					name="userName" placeholder="ID"> <input type="text"
					id="password" class="fadeIn third" name="password"
					placeholder="Password"> <input type="submit"
					class="fadeIn fourth" value="Login"> <input type="hidden"
					name="action" value="login">
			</form>

			<!-- Remind Passowrd -->
			<div id="formFooter">
				<a class="underlineHover" href="#">Forgot Password?</a>
			</div>

		</div>
	</div>
</body>

</html>