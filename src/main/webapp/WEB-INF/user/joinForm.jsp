<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<link rel="stylesheet" type="text/css" href="css/joinForm.css">

<style>
.input-form {
	max-width: 680px;
	margin-top: 10px;
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
}

.btn:hover {
	background-color: #6f263d;
	border: solid 1px #6f263d;
	opacity: 0.8;
}
</style>
<title>joinForm</title>
</head>

<!-- Custom styles for this template -->
<link href="form-validation.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="../header.jsp"></jsp:include>


	<div class="container">
		<div class="row">
			<h1 class="h2 mb-3 color-point">LEcommend 회원가입</h1>
			<div class="input-form col-md-12 mx-auto">

				<form name="joinform" method="POST"
					action="<c:url value='/user/join'/>">

					<div class="form-group mb-3">
						<label for="userId">ID (학번)</label> <input type="text"
							class="form-control" name="userId" id="userId" required>
						<font id="checkId" size="2"></font>

					</div>


					<div class="form-group mb-3">
						<label for="password">비밀번호</label> <input type="password"
							class="form-control" name="password" id="password" required>
						<font id="checkPw" size="2"></font>
					</div>

					<div class="form-group mb-3">
						<label for="password2">비밀번호 재확인</label> <input type="password"
							class="form-control" name="password2" id="password2" required>
						<font id="missMatchPw" size="2"></font>
					</div>

					<div class="form-group mb-3">
						<label for="major" class="form-label">학과</label> <select
							class="form-select" name="major" id="major" required>
							<option value="">선택하기</option>
							<option>컴퓨터학과</option>
							<option>정보통계학과</option>
							<option>화장품학과</option>
							<option>경제학과</option>
							<option>경영학과</option>
						</select>

					</div>

					<hr class="mb-4">
					<div class="form-group custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input" id="aggrement"
							required> <label class="custom-control-label"
							for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
					</div>
					<br>
					<div class="mb-2 form-group "></div>
					<input type="button" value="제출하기"
						class="btn-block w-100 btn btn-lg btn-primary"
						onclick="userCreate()">
				</form>
			</div>
		</div>

	</div>

	<script>
		function userCreate() {
			var idExp = /^2\d{7}$/;
			if (idExp.test(joinform.userId.value) == false) {
				document.getElementById("checkId").innerHTML = "ID(학번) 형식이 올바르지 않습니다.";
				document.getElementById("checkId").style.color = "red";
				joinform.userId.focus();
				return false;
			} else {
				document.getElementById("checkId").innerHTML = "";
			}

			var pwExp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,10}$/;
			//최소 8자 및 최대 10자 & 하나 이상의 대문자, 하나의 소문자, 하나의 숫자 및 하나의 특수 문자
			if (pwExp.test(joinform.password.value) == false) {
				document.getElementById("checkPw").innerHTML = "비밀번호 형식이 올바르지 않습니다.";
				document.getElementById("checkPw").style.color = "red";
				joinform.password.focus();
				return false;
			} else {
				document.getElementById("checkPw").innerHTML = "";
			}

			if (joinform.password.value != joinform.password2.value) {
				document.getElementById("missMatchPw").innerHTML = "비밀번호가 일치하지 않습니다.";
				document.getElementById("missMatchPw").style.color = "red";
				joinform.password2.focus();
				return false;
			} else {
				document.getElementById("missMatchPw").innerHTML = "";
			}

			if (joinform.major.value == "") {
				joinform.major.focus();
				return false;
			}

			joinform.submit();
		}
	</script>

	<script src="/docs/5.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>

	<script src="form-validation.js"></script>
</body>


</html>