<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/10/13
  Time: 上午9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="upload.jsp"><h3>单文件上传</h3></a><br>
  <a href="/download.action?fileName=a.jpg"><h3>文件下载</h3></a><br>
  <a href="login.jsp"><h3>去登录哟</h3></a><br>
  <%--显示当前的错误信息--%>
  <s:actionerror></s:actionerror>
  <s:fielderror></s:fielderror>
  </body>
</html>
