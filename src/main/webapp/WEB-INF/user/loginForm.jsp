<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Login Form</title>

<style>
.login-custom {
	margin-top: 70px;
	font-weight: bold;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
}

.form-signin .form-floating:focus-within {
	z-index: 2;
}

.form-signin input[type="text"] {
	margin-bottom: 10px;
	margin-top: 10px;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}

.color-point {
	color: #6f263d;
	text-align: center;
	font-weight: bold;
}

.form-floating {
	color: #bcbcbc;
}

.signup {
	text-decoration: none;
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

label {
	color: #bcbcbc;
}

.center_loc {
	margin-top: 15px;
	text-align: center;
}

.errormsg {
	text-align: center;
	font-weight: bold;
}

</style>

<script>
	function login() {
		if (form.userId.value == "") {
			alert("사용자 ID를 입력하십시오.");
			form.userId.focus();
			return false;
		}
		if (form.password.value == "") {
			alert("비밀번호를 입력하십시오.");
			form.password.focus();
			return false;
		}
		form.submit();
	}
</script>
</head>

<jsp:include page="../header.jsp"></jsp:include>


<body>


	<div class="login-custom">
		<main class="form-signin w-100 m-auto">
			<form name="form" method="POST"
				action="<c:url value='/user/login' />">

				<h1 class="h2 mb-3 color-point">LEcommend</h1>

				<!-- 로그인이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
				<div class="col-lg-12 ">
					<c:if test="${loginFailed}">
						<h6 class="text-danger errormsg">
							<c:out value="${exception.getMessage()}" />
						</h6>
					</c:if>
				</div>

				<div class="form-floating">
					<input type="text" name="stuId" class="form-control"
						id="floatingInput" placeholder="ID"> <label
						for="floatingInput">ID</label>
				</div>
				<div class="form-floating">
					<input type="password" name="stuPw" class="form-control"
						id="floatingPassword" placeholder="Password"> <label
						for="floatingPassword">Password</label>
				</div>
				<button class="w-100 btn btn-lg btn-primary" onClick="login()">Log
					in</button>

				<div class="center_loc">
					<label>LEcommend 처음이신가요?</label> <br> <a
						href="<c:url value='/user/join' />" class="signup">회원가입</a>
				</div>
			</form>
		</main>


	</div>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</body>
</html>

