<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="en">

<jsp:include page="header.jsp">
	<jsp:param value="Login" name="title" />
</jsp:include>

<body>
	<h1>Đăng Nhập</h1>
	<div class="w3ls-login box box--big">
		<!-- form starts here -->
		<form action="ProcessLogin" method="get">
			<div class="agile-field-txt">
				<label>
					<i class="fa fa-user" aria-hidden="true"></i>Email:</label>
				<input type="text" name="mail" placeholder="Nhập Email" required="" />
			</div>
			<div class="agile-field-txt">
				<label>
					<i class="fa fa-envelope" aria-hidden="true"></i>Mật Khẩu:</label>
				<input type="password" name="password" placeholder="Nhập Mật Khẩu" required="" id="myInput" />
				<div class="agile_label">
					<input id="check3" name="check3" type="checkbox" value="show password" onclick="myFunction()">
					<label class="check" for="check3">Duy Trì Đăng Nhập</label>
				</div>
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
			<div class="w3ls-bot row">
				<div class="switch-agileits col-md-6 col-lg-6">
					<a>
						<label class="switch">
							Quên Mật Khẩu
						</label>
					</a>
				</div>
				<div class="switch-agileits col-md-6 col-lg-6">
					<a href="Register.jsp">
						<label class="switch">
							Đăng Kí
						</label>
					</a>
				</div>
				<div class="form-end">
					<input type="submit" value="Đăng Nhập">
				</div>
				<div style="width: 100%; "><label style="padding-left: 44%; padding-top: 1%">Hoặc</label></div>
				<div class="form-end test">
					<input type="submit" style="background: #3b5998;border: #3b5998 " value="Đăng Nhập Bằng FaceBook">
				</div>
				<div style="width: 100%"><label style="padding-left: 44%; padding-top: 1%">Hoặc</label></div>
				<div class="form-end test">
					<input type="submit"  style="background: #df4a32; border:#c63923;" value="Đăng Nhập Bằng Google">
				</div>
				<div class="clearfix"></div>
			</div>
	
		</form>
	</div>
	<!-- //form ends here -->
	<!--copyright-->
	<div class="copy-wthree">
		<p>Â© 2018 Clear Login Form. All Rights Reserved | Design by
			<a href="http://w3layouts.com/" target="_blank">W3layouts</a>
		</p>
	</div>
	<!--//copyright-->
</body>

</html>