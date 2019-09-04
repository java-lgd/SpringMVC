<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>城市</title>
<script type="text/javascript">
	function del(id) {
		if(confirm("是否删除？")){
			open("delete.do?id="+id,"_self");
		}
	}
</script>
</head>
<body>
	<form action="index.do" method="post">
		<input name="txt" value="${cur}">
		<input type="submit" value="查找">
	</form>
	<a href="add.do">新增</a>
	
	<table>
		<tr>
			<td>ID</td>
			<td>城市编号</td>
			<td>城市名称</td>
			<td>所属省号</td>
			<td>操作</td>
		</tr>
	<c:forEach items="${list}" var="c">
	<tr>
				<td>${c.id}</td>
				<td>${c.cityID}</td>
				<td>${c.city}</td>
				<td>${c.province}</td>
				<td>
					<a href="javascript:del(${c.id })">删除</a>
					<a href="edit.do?id=${c.id }">修改</a>
				</td>
	</tr>
	</c:forEach>
	</table>
	
</body>
</html>