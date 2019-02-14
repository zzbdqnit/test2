<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>主题列表</title>
    
  </head>
  
  <body>
  <a href="<%=basePath%>topic/addTopic.jsp">添加</a>
   <div style="width:600px;">
	   <table border="1" width="80%">
	   		<!-- 标题信息 -->
	   		<tr>
	   			<th>主题ID</th>
	   			<th>主题名称</th>
	   			<th>操作</th>
	   		</tr>
	   		<!-- 循环输出用户信息 -->
	   		<c:forEach var="topic" items="${topicList}" varStatus="status">
	   			<!-- 如果是偶数行，为该行换背景颜色 -->
		   		<tr <c:if test="${status.index % 2 == 1 }"> style="background-color:rgb(219,241,212);"</c:if>>
		   			<td>
		   				
		   				<a href="<%=basePath%>topic/TopicServlet?id=${topic.tid}&pro=get">${topic.tid}</a>
		   			</td>
		   			<td>
		   				${topic.tname}
		   			</td>
		   			<td>
		   			<a href="<%=basePath%>topic/TopicServlet?id=${topic.tid}&pro=toupdate">修改</a>
		   			<a href="<%=basePath%>topic/TopicServlet?id=${topic.tid}&pro=delete">删除</a>
		   			</td>
		   		</tr>
	   		</c:forEach>
	   </table>
   </div>
  </body>
</html>
