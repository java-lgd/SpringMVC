<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<form action="insert.action" method="post">
			<input name="cityID" value="ID">
			<input name="city" value="city">
				<select name="father">
					<c:forEach items="${prolist}"  var="s" >
						<option value="${s.provinceID }" >${s.province}</option>
					</c:forEach>
				</select>
			<input type="submit" value="提交">
	</form>
	
</body>
</html>