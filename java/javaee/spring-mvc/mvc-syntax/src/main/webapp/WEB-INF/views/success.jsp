<%--
  Created by IntelliJ IDEA.
  User: zack
  Date: 5/3/2020
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
success page

<br/>
<!--  pageScope  requestScope sessionScope  applicationScope -->
username: ${requestScope.username}
<br/>
password: ${requestScope.password}
<br/>
loginMsg: ${requestScope.loginMsg }
</body>
</html>
