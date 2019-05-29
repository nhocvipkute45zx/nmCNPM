<%@page import="Util.StringUtil"%>
<%@page import="Util.Validate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Util.StringUtil"%>
<%@page import="Util.Validate"%>

	<!DOCTYPE HTML>
<html lang="en">

<head>
<title>Lấy Mật Khẩu</title>
<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords"
	content="Clear login Form a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
<!-- //Meta-Tags -->
<!-- Stylesheets -->
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="css/jquery-ui1.css" rel='stylesheet' type='text/css' />
<!--// Stylesheets -->
<!--fonts-->
<!-- title -->
<!-- body -->
<link
	href="//fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=devanagari,latin-ext"
	rel="stylesheet">
<!--//fonts-->
</head>

<body>
	<h1>Lấy lại mật khẩu</h1>
	<div class="w3ls-login box box--big">
		<!-- form starts here -->
		<form action="ProcessForgotPass" method="get">
			<div>
				<span style="color: white; padding-top: 5px">
					<%=StringUtil.getString(request.getAttribute("error") )%> </span>
			</div>
			<div class="agile-field-txt">
				<label> <i class="fa fa fa-envelope" aria-hidden="true"></i>Gmail:
				</label> <input type="text" name="email" placeholder="Nhập gmail" required
					style="width: 400px">
			</div>
			<!-- script for show password -->
			<!-- //script ends here -->
			<div class="form-end">
				<input type="submit" value="Gửi">
			</div>
			<div class="clearfix"></div>

		</form>
	</div>
	<!-- //form ends here -->
	<!--copyright-->
	<div class="copy-wthree">
		<p>
			ÃÂ© 2018 Clear Login Form. All Rights Reserved | Design by <a
				href="http://w3layouts.com/" target="_blank">W3layouts</a>
		</p>
	</div>
	<!--//copyright-->
</body>

</html>