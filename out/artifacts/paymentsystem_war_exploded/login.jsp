<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="assets/js/jquery-1.8.3.js"></script>
<html>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>财务支付管理系统</title>
	<meta name="description" content="这是一个 index 页面">
	<meta name="keywords" content="index">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<meta name="apple-mobile-web-app-title" content="Amaze UI" />
	<link rel="stylesheet" href="assets/css/amazeui.min.css" />
	<link rel="stylesheet" href="assets/css/admin.css">
	<link rel="stylesheet" href="assets/css/app.css">
	<style>
		.loginBtn {
			margin-top: 20px;
			color: #fff;
			font-size: 18px
		}

		.loginBtn>div {
			width: 100%;
			height: 40px;
			text-align: center;
			border-radius: 6px;
			background: #53d192;
			border: none;
			color: #fff;
			font-size: 18px;
			line-height: 40px;
			margin-top: 20px;
		}
		#input1{
			width: 100%;
			height: 40px;
			text-align: center;
			border-radius: 6px;
			background: #53d192;
			border: none;
			color: #fff;
			font-size: 18px;
			line-height: 40px;
			margin-top: 20px;
		}
	</style>

</head>

<body data-type="login">
	<div class="am-g myapp-login">
		<div class="myapp-login-logo-block  tpl-login-max">
			<div class="myapp-login-logo-text">
				<div class="myapp-login-logo-text">
					财务支付管理系统
				</div>
			</div>
			<div class="am-u-sm-10 login-am-center">
				<form class="am-form" action="asd" method="post">
					<fieldset>
						<div class="am-form-group">
							<input type="text" class="" id="doc-ipt-email-1" placeholder="请输入账号" name="account">
						</div>
						<div class="am-form-group">
							<input type="password" class="" id="doc-ipt-pwd-1" placeholder="请输入密码" name="password">
						</div>
						<%--<a  class="loginBtn" >
							<div>登入</div>
						</a>--%>
						<input type="submit" id="input1" value="登录">
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/app.js"></script>
</body>

</html>