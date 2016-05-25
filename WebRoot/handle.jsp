<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>处理就诊单</title>

</head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/handle.js"></script>

<style type="text/css">
.onecenter {
	text-align: center;
	width: 200px;
	height: 5px;
	background-color: #006699;
	padding: 20px;
	color: #FFF;
}
</style>
<body>
	<div>
		<font>请选择出诊时间段：</font>
		<p></p>
		<select id="period"   class="form-inline"  onchange="loadInfo()"></select>
	</div>

	<table id="handlePatient"  class="table table-striped table table-bordered">
		<tr id="title">
			<td><font>就诊单号</font></td>
			<td><font>姓名</font></td>
			<td><font>时间段</font></td>
			<td><font>操作</font></td>
		</tr>

	</table>
</body>
</html>
