<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypage</title>

<style>
.structure {
	width: 90%;
	margin: 10px auto;
	color: #6f263d;
}

.info {
	float: left;
	width: 20%;
}

.dList {
	float: left;
	width: 55%;
}

.rlist {
	float: right;
	width: 15%;
}
</style>


</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<jsp:include page="../nav.jsp"></jsp:include>
	<div class="structure">

		<div class="info"><jsp:include page="userInfo.jsp">
				<jsp:param name="userId" value="userId" />
				<jsp:param name="major" value="major" /></jsp:include></div>
		<div class="dList"><jsp:include page="dibList.jsp"></jsp:include></div>
		<div class="rList"><jsp:include page="recommendList.jsp"></jsp:include></div>
	</div>



</body>
</html>