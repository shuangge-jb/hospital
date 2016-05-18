<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<title>医生出诊查询</title>

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<form id="form" action="login" method="post">
	<div class="Main">
		<ul>
			<li class="topB"><span> <img src="images/login/logo.png"
					alt="" style="" />
			</span></li>
			<li class="topC"></li>
			<li class="topD">
				<ul class="login">
					<li><span class="left">就医医院：</span> <span style="left">
							<input type="text" value="${user.userName }"
							name="doctor.userName" id="userName" class="input" />
					</span></li>
					<li><span class="left">就诊科室：</span> <span style="left">
							<input type="text" value="${user.userName }"
							name="doctor.userName" id="userName" class="input" />
					</span></li>
					<li><span class="left">就诊日期：</span> <span style="left">
							<input type="date" value="${user.userName }"
							name="doctor.userName" id="date" class="input" />
					</span></li>
				</ul>
			</li>
		</ul>
	</div>
</form>
<body>

</body>
</html>
