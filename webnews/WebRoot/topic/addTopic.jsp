<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>添加主题</title>
</head>
<body>
	<form name="form1" method="post" action="TopicServlet?&pro=add">
		<table>
			<tr>
				<td>主题名称:</td>
				<td><input type="text" name="tname">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
<body>
</html>
