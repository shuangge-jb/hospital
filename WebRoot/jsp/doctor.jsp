<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>医生登录页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<script type="text/javascript">
	function resetValue() {
		document.getElementById("userName").value = "";
		document.getElementById("password").value = "";
	}

	function loadimage() {
		document.getElementById("randImage").src = "image.jsp?" + Math.random();
	}
</script>
<script src="../js/doctor.js"></script>
<body>
	<form id="form" action="login" method="post">
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
								name="doctor.userName" id="userName" class="input"/>

						</span></li>
						<li><span class="left">性别：</span> <span style="left">
								<select name="sex" id="sex" class="select">
									<option value="男">男</option>
									<option value="女">女</option>
							</select>

						</span></li>
						<li><span class="left">年龄：</span> <span style="left">
								<input type="text" value="${user.age }" name="user.age" id="age" class="input"/>
						</span></li>
						<li><span class="left">科室：</span> <span style="left">
								<input type="text" value="${user.apartment }"
								name="user.department" id="department" class="input"/>
						</span></li>
						<li><span class="left">电话：</span> <span style="left">
								<input type="text" value="${user.tel }" name="user.tel" id="tel" class="input"/>
						</span></li>
						<li><span class="left">医院：</span> <span style="left">
								<input type="text" value="${user.hospital }"
								name="user.hospital" id="hospital" class="input"/>
						</span></li>
						<li><span class="left">验证码:</span> <span style="left">
								<input type="text" value="${imageCode }" name="imageCode"
								id="imageCode" size="10" />
						</span> <span style="left"> <img onclick="javascript:loadimage();"
								title="换一张试试" name="randImage" id="randImage" src="image.jsp"
								width="60" height="20" border="1" align="absmiddle">
						</span></li>

					</ul>
				</li>


				<li class="middle_C"><span style="margin:15px"><input
						type="submit" value="登录" /></span> <span style="margin:10px"><input
						type="button" value="重置" onclick="resetValue()" /></span></li>
				<li class="middle_D"></li>
				<li class="bottom_A"></li>

			</ul>
		</div>
	</form>
</body>
</html>
