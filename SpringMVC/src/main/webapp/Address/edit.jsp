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

	<c:if test="${city==null}">
		<form action="insert.do" method="post">
			<input name="cityID" value="ID">
			<input name="city" value="city">
				<select name="father">
					<c:forEach items="${prolist}"  var="s" >
						<option value="${s.provinceID }" >${s.province}</option>
					</c:forEach>
				</select>
			<input type="submit" value="提交">
	</form>
	</c:if>
		
	
	<c:if test="${city!=null}">
	<form action="update.do" method="post">
			<input name="id"  type="hidden" value="${city.id }">
			<input name="cityID" value="${city.cityID}">
			<input name="city" value="${city.city}">
				<select name="father">
					<c:forEach items="${prolist}"  var="s" >
						<c:if test="${(city.father).equals(s.provinceID)}">
							<option value="${s.provinceID }" selected="selected">${s.province}</option>
						</c:if>
						<c:if test="${!(city.father).equals(s.provinceID)}">
							<option value="${s.provinceID }" >${s.province}</option>
						</c:if>
					</c:forEach>
				</select>
			<input type="submit" value="提交">
	</form>
	</c:if>
	
	
</body>
</html>