<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>城市</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
		<button type="submit">查找</button>
	</form>
	
	<a href="add.do">新增</a>
	
	<table>
		<tr style="text-align: center;">
			<td style="text-align: center;">城市编号</td>
			<td style="text-align: center;">城市名称</td>
			<td style="text-align: center;">所属省</td>
			<td style="text-align: center;">操作</td>
		</tr>
	<c:forEach items="${citylist}" var="c">
	<tr>
				<td style="text-align: center;">${c.cityID}</td>
				<td style="text-align: center;">${c.city}</td>
				<td style="text-align: center;">${c.province}</td>
				<td>
					<button >
							<a href="javascript:del(${c.id })">删除</a>
					</button>
					<button >
							<a href="edit.do?id=${c.id }">修改</a>
					</button>
				</td>
	</tr>
	</c:forEach>
	</table>
	
</body>
</html>