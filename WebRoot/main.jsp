<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<style type="text/css">
body {
	background-color: #758fde;
}
a { color: #000000; font-size: 12pt; text-decoration: none}
</style>
<body>
<p><s:property value="%{getText('mainpage')}" /></p>

<center>
<table width="60%" border="0">
 
  <tr>
    <td height="98" >
    <a href="worktime.jsp">选择出诊时间</a>
    </td>
    </tr>
    <tr>
    <td height="98" >
    <a href="handle.jsp">处理就诊单</a>
      </td>
  </tr>
</table>
</center>
</body>
</html>
