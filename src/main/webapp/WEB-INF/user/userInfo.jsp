<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>


<style>
.input-form {
	max-width: 500px;
	padding: 180px;
	padding-top: 5px;
}

.color-point {
	color: #6f263d;
	text-align: center;
	font-weight: bold;
	margin-top: 5px;
}

.btn-primary {
	background-color: #6f263d;
	border-color: #6f263d;
	text-align: center;
}

.editbtn:hover {
	background-color: #6f263d;
	border: solid 1px #6f263d;
	opacity: 0.8;
}
</style>
</head>

<!-- Custom styles for this template -->
<link href="form-validation.css" rel="stylesheet">
<body>



	<div class="container">
		<div class="row userInfo" id="first">
			<h4 class="color-point">🎓 회원 정보 🎓</h4>
			<div class="input-form col-md-12 mx-auto">
				<form method="GET" action="<c:url value='/user/mypage/edit' />">
					<div class="form-group mb-3">
						<label for="userId">ID (학번)</label> <input type="text"
							class="form-control" name="userId" id="userId" value="${userId}"
							disabled />
					</div>

					<div class="form-group mb-3">
						<label for="major">학과</label> <input type="text"
							class="form-control" value="${major}" name="${major}"
							id="${major}" disabled />
					</div>
					<div class="mb-3 form-group">
						<input type="submit" value="수정하기"
							class="btn-block w-100 btn btn-primary editbtn">
					</div>
				</form>
			</div>
		</div>
	</div>


	<!-- 
	<div class="container">
		<div class="row userInfo">
			<h3 class="color-point">🎓 회원 정보 🎓</h3>
			<div class="input-form col-md-12 mx-auto">

				<form method="POST" action="<c:url value='/user/mypage/edit' />">
					<div class="form-group mb-3">
						<label for="userId">ID (학번)</label> <input type="text"
							class="form-control" name="userId" id="userId" disabled />

					</div>

					<div class="form-group mb-3">
						<label for="major">학과</label> <input type="text"
							class="form-control" name="major" id="major" disabled />
					</div>
					<div class="mb-3 form-group">
						<input type="submit"
							class="btn-block w-100 btn btn-primary editbtn">
					</div>
				</form>
			</div>
		</div>
	</div>
	-->
	
	<script>
		var major = ${major};
		request.setAttribute("major", major);
	</script>


</body>
</html>