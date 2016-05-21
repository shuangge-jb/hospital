<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>医生注册页面</title>

</head>
<script src="js/jquery.min.js"></script>
<script src="js/doctorInfo.js"></script>
<body>
	<form id="doctorRegistration" action="/doctorAction!save.action" method="post">
		<div class="Main">
			<ul>
				<li class="topB"><span> <img src="images/login/logo.png"
						alt="" style="" />
				</span></li>
				<li class="topC"></li>
				<li class="topD">
					<ul class="login">
						<li><span class="left">用户名:</span> <span style="left">
								<input type="text" value="${user.userName }"
								name="doctor.doctorName" id="doctorName" class="input" />
						</span></li>
						<li><span class="left">性别：</span> <span style="left">
								<select name="sex" id="sex" class="select">
									<option value="男">男</option>
									<option value="女">女</option>
							</select>

						</span></li>
						<li><span class="left">年龄：</span> <span style="left">
								<input type="text" value="${user.age }" name="user.age" id="age"
								class="input" />
						</span></li>
						<li><span class="left">医院：</span> <span style="left">
								<select name="user.hospital" id="hospital" class="input">

							</select>
						</span></li>
						<li><span class="left">科室：</span> <span style="left">
								<select name="user.department" id="department" class="input">
							</select>
						</span></li>
						<li><span class="left">电话：</span> <span style="left">
								<input type="text" value="${user.tel }" name="user.tel" id="tel"
								class="input" />
						</span></li>

					</ul>
				</li>


				<li class="middle_C"><span style="margin:15px"><input
						type="submit" value="注册"  /></span> <span
					style="margin:10px"><input type="button" value="重置"
						onclick="resetValue()" /></span></li>
				<li class="middle_D"></li>
				<li class="bottom_A"></li>

			</ul>
		</div>
	</form>
</body>
</html>
