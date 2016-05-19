<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>处理就诊单</title>

</head>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/handle.js"></script>
<body>
	<div>
		<font>请选择出诊时间段：</font>
		<p></p>
		<select id="period"></select>
	</div>

	<table id="handlePatient">
		<tr id="title">
			<td><font>就诊单号</font></td>
			<td><font>姓名</font></td>
			<td><font>操作</font></td>
		</tr>
		
	</table>
</body>
</html>
