<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>处理就诊单</title>

</head>
<script type="text/javascript" src="js/jquery.min.js"></script>
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
		<select id="period" onchange="loadInfo()"></select>
	</div>

	<table id="handlePatient">
		<tr id="title">
			<td class='onecenter'><font>就诊单号</font></td>
			<td class='onecenter'><font>姓名</font></td>
			<td class='onecenter'><font>时间段</font></td>
			<td class='onecenter'><font>操作</font></td>
		</tr>

	</table>
</body>
</html>
