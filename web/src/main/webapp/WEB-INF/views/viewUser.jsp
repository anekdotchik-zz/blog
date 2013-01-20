<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>View user</title>
</head>
<body>
	<h1>View user!</h1>
	<table>
		<tr>
			<td>Id</td>
			<td>${id}</td>
		</tr>
		<tr>
			<td>Login</td>
			<td>${login}</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>${password}</td>
		</tr>
	</table>
</body>
</html>
