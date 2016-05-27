<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>My JSP 'timetable.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/timetable.js"></script>
<body>
	<div id="timetable">
		<button id="select"  class="selected btn btn-default navbar-btn" onclick="showTable()">查看排班表</button>
		<table id="table"  class="table table-striped table table-bordered">
			<tr>
				<td></td>
				<td id="one"></td>
				<td id="two"></td>
				<td id="three"></td>
				<td id="four"></td>
				<td id="five"></td>
				<td id="six"></td>
				<td id="seven"></td>
			</tr>
			<tr>
				<td id="morning"><label>上午</label></td>
				<td id="oneMorn"></td>
				<td id="twoMorn"></td>
				<td id="threeMorn"></td>
				<td id="fourMorn"></td>
				<td id="fiveMorn"></td>
				<td id="sixMorn"></td>
				<td id="sevenMorn"></td>
			</tr>
			<tr>
				<td id="afternoon"><label>下午</label></td>
				<td id="oneAfter"></td>
				<td id="twoAfter"></td>
				<td id="threeAfter"></td>
				<td id="fourAfter"></td>
				<td id="fiveAfter"></td>
				<td id="sixAfter"></td>
				<td id="sevenAfter"></td>
			</tr>
		</table>
	</div>
</body>
</html>
