<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/categories_styles.css'/>">
</head>
<body>
	<div class="sidebar" style="margin-left:50px;margin-top:200px">
		<div class="sidebar_section">
			<div class="sidebar_title">
				<h5>고객 센터</h5>
			</div>
			<ul class="sidebar_categories">
				<li><a href="<c:url value='/cs/notice'/>">공지 사항</a></li>
				<li><a href="<c:url value='/cs/faq'/>">FAQ</a></li>
				<li><a href="<c:url value='/cs/cenquery'/>">문의 사항</a></li>
			</ul>
		</div>
	</div>
</body>
</html>
<jsp:include page="../include/footer.jsp" />