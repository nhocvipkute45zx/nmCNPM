<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="en">

<jsp:include page="header.jsp">
	<jsp:param value="Register" name="title" />
</jsp:include>

<body>
	<h1>Đăng Kí</h1>
	<div class="w3ls-login box box--big">
		<!-- form starts here -->
		<form action="ProcessRegister" method="get">
			<div class="agile-field-txt">
				<label> <i class="fa fa-user" aria-hidden="true"></i>Họ Và Tên:
				</label> <input type="text" name="name" placeholder="Nhập Tên Tài Khoản"
					required="" />
			</div>
			<div class="agile-field-txt">
				<label> <i class="fa fa-envelope" aria-hidden="true"></i>Email:
				</label> <input type="text" name="email" placeholder="Nhập Tên Tài Khoản"
					required="" />
			</div>
			<div class="agile-field-txt">
				<label> <i class="fa fa-phone" aria-hidden="true"></i>Sđt:
				</label> <input type="text" name="sđt" placeholder="Nhập Số Điện Thoại"
					required="" />
			</div>
			<div class="agile-field-txt">
				<label> <i class="fa fa-key" aria-hidden="true"></i>Mật
					Khẩu:
				</label> <input type="password" name="password" placeholder="Nhập Mật Khẩu"
					required="" id="myInput" /> 
				<label style="padding-top: 20px">
					<i class="fa fa-key" aria-hidden="true"></i>Nhập lại Mật Khẩu:
				</label> <input type="password" name="Repassword"
					placeholder="Nhập Lại Mật Khẩu" required="" id="myInput" />
			</div>
			<!-- script for show password -->
			<script>
				function myFunction() {
					var x = document.getElementById("myInput");
					if (x.type === "password") {
						x.type = "text";
					} else {
						x.type = "password";
					}
				}
			</script>
			<!-- //script ends here -->
			<div class="w3ls-bot">
				<div class="switch-agileits">
					<label class="switch"> Đã có tài khoản:</label> <a
						href="login2.jsp" style="margin-left: 3px"> Đăng Nhập</a>
				</div>
				<div class="form-end">
					<input type="submit" value="Đăng Kí">
				</div>
				<div class="clearfix"></div>
			</div>

		</form>
	</div>
	<!-- //form ends here -->
	<!--copyright-->
	<div class="copy-wthree">
		<p>
			Â© 2018 Clear Login Form. All Rights Reserved | Design by <a
				href="http://w3layouts.com/" target="_blank">W3layouts</a>
		</p>
	</div>
	<!--//copyright-->
</body>

</html>