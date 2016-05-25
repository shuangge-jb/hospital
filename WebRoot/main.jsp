<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<link href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="main nav navbar-nav">
			<div id="tab">
				<ul class="tab_menu ">
					<button class="selected btn btn-default navbar-btn" onclick="clickSelectTime()">选择出诊时间</button>
					<button class="btn btn-default navbar-btn" onclick="clickHandle()">处理就诊单</button>
				</ul>
			</div>
	</nav>
	<div class="tab_box">
		<div id="selectTime"><%@ include file="selectTime.jsp"%></div>
		<div id="handle"><%@ include file="handle.jsp"%></div>
	</div>
	</table>
	</div>

</body>
</html>
