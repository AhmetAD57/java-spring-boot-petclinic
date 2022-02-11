<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" url="htt://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>First name</td>
				<td>Last name</td>
			</tr>
		</thead>
		<c:forEach items="${owners}" var="owner">
			<tr>
				<td>${owner.id}</td>
				<td>${owner.firsName}</td>
				<td>${owner.lastName}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>