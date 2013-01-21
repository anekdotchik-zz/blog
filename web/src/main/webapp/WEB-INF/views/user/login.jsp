<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="login" method="post">
		<table>
			<tr>
				<td>Login</td>
				<td><input type="text" name="login" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="login" /></td>
				<td />
			</tr>
		</table>
	</form>
</body>
</html>
