<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>用户注册</title>
</head>
<body>
	<form name="form1" method="post" action="TopicServlet?id=${topic.tid}&pro=update">
		<table>
			<tr>
				<td>主题名:</td>
				<td><input type="text" name="tname" value="${topic.tname}">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="修改"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
<body>
</html>
