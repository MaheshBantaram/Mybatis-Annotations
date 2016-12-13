<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	
	<form action="./submit">
		<table>
			<tr>
				<td>ID</td>
				<td>:</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td>:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
				<td></td>
			</tr>
		</table>
		
		${id}, ${name}
	</form>
</body>
</html>
