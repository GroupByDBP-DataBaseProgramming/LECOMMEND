<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<style>
.input-form {
	max-width: 680px;
	margin-top: 5px;
	padding: 180px;
	padding-top: 5px;
}

.color-point {
	color: #6f263d;
	text-align: center;
	font-weight: bold;
	margin-top: 30px;
}

.btn-primary {
	background-color: #6f263d;
	border-color: #6f263d;
	text-align: center;
	width: 40%;
	margin-left: 20px;
}

.submitBtn:hover, .resetBtn:hover {
	background-color: #6f263d;
	border: solid 1px #6f263d;
	opacity: 0.8;
}
</style>
</head>

<!-- Custom styles for this template -->
<link href="form-validation.css" rel="stylesheet">
<body>
	
	<%
		String lecId = request.getParameter("lecId");
	
	%>
	<!-- 회원 정보 수정하기 -->
	<div class="container">
		<div class="row">
			<h1 class="h2 mb-3 color-point">강의 정보 수정</h1>
			<div class="input-form col-md-12 mx-auto">

				<form name="updateForm" method="POST" action="">
					<div class="form-group mb-3">
						<label for="userId">강의 이름</label> <input type="text"
							class="form-control" name="userId" id="userId" placeholder="${lec.title }"
						disabled/>
					</div>


					<div class="form-group mb-3">
						<label for="password">강의 시간</label> <input type="text"
							class="form-control" name="" id="password" required>
						<font id="checkPw" size="2"></font>

					</div>

					<div class="form-group mb-3">
						<label for="password2">강의실</label> <input type="text"
							class="form-control" name="loc" id="loc" required>
						<font id="missMatchPw" size="2"></font>
					</div>
					
					<div class="form-group mb-3">
						<label for="password2">강의 형식</label> <input type="text"
							class="form-control" name="lecType" id="lecType" required>
						<font id="missMatchPw" size="2"></font>
					</div>
					<div class="form-group mb-3">
						<label for="password2">시험 형식</label> <input type="text"
							class="form-control" name="examType" id="examType" required>
						<font id="missMatchPw" size="2"></font>
					</div>
					<div class="form-group mb-3">
						<label for="password2">수강인원</label> <input type="text"
							class="form-control" name="occupancy" id="occupancy" required>
						<font id="missMatchPw" size="2"></font>
					</div>

					<div class="form-group mb-3">
						<label for="major" class="form-label">on/off</label> <select
							class="form-select" name="onOff" id="onOff" required>
							<option value="">선택</option>
							<option>on</option>
							<option>off</option>
						</select>

					</div>
				
				
					<div class="form-group mb-3">
						<input value="수정" class="btn-block btn btn-primary submitBtn"
							type="button" onClick=""> <input
							value="취소" class="btn-block btn btn-primary resetBtn"
							type="reset">
					</div>

				</form>
			</div>
		</div>
	</div>

	<script>

	</script>

	<script src="/docs/5.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>

	<script src="form-validation.js"></script>
</body>
</html>