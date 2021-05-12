<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/commons/taglib.jsp"%>
<html>

<head>
<title><dec:title default="Trang chủ" /></title>

<!--css-->
<link
	href="<c:url value='/templates/web/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet">
<link href="<c:url value='/templates/web/css/shop-homepage.css' />"
	rel="stylesheet">
</head>

<body>
	<!--header-->
	<%@ include file="/commons/web/header.jsp"%>
	<!--header-->

	<dec:body />

	<!--footer-->
	<%@ include file="/commons/web/footer.jsp"%>
	<!--footer-->

	<script src="<c:url value='/templates/web/jquery/jquery.min.js' />"></script>
	<script
		src="<c:url value='/templates/web/bootstrap/js/bootstrap.bundle.min.js' />"></script>

</body>

</html>