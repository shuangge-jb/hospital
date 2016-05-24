<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>选择出诊时间</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/selectTime.js"></script>
<body>
	<form id="selectTime" class="form-inline" role="form">
		<div class="form-group">
			<p></p>
			<font  class="col-sm-2 control-label">请选择出诊时间段：</font> <input id="periods" type="date" />
		
			<select id="mornOrAfter" class="form-control">
				<option value="上午">上午</option>
				<option value="下午">下午</option>
			</select>
			<input id="submit" class="btn btn-default" type="submit" value="提交"
				onclick="submit()" />
		</div>
	</form>
</body>
</html>
