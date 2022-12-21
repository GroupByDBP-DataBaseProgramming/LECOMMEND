<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>

<style>
.structure {
	margin: 50px;
	width: 100%;
}

.info {
	float: left;
	width:20%;
}

.dList {
	float: left;
	width:60%;
}


</style>


</head>
<body>

	<%
	HttpSession loginSession = request.getSession();
	System.out.println(loginSession.getAttribute("userId"));
	
	%>

	<!--로그인이 안 됐으면-->
	<c:if test="${userId eq null}">
		<%response.sendRedirect("login/form"); %>
	</c:if>
	
	<!--  로그인이 됐으면-->
	<c:if test="${userId ne null}">	
	
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../nav.jsp"></jsp:include>
	
		<div class="structure">
			<div class="info"><jsp:include page="userInfo.jsp"></jsp:include></div>
			<div class="dList"><jsp:include page="dibList.jsp"></jsp:include></div>
		</div>
	</c:if>

</body>
</html>