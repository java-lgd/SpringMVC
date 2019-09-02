<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>编辑</title>

<base href="../">
<link href="layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="layui/layui.all.js"></script>
<script src="js/jquery-2.2.4.min.js" ></script>
<script type="text/javascript" src="js/my.js"></script>
</head>
<body>
<style>
.layui-input{width:200px;}
</style>

<c:if test="${param.id==null}">
<form class="layui-form" lay-filter="myform" method="POST" action="Address">
<input type="hidden" name="_method" value="POST">
</c:if>
<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" method="POST" action="Address">
<input type="hidden" name="_method" value="PUT">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">cityID</label>
    <div class="layui-input-block">
      <input type="text" name="cityID"  autocomplete="off" placeholder="请输入cityID" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">city</label>
    <div class="layui-input-block">
    <input type="text" name="city"  autocomplete="off" placeholder="请输入city" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">所属省</label>
    <div class="layui-input-block">
      <select name="father" >
      </select>
    </div>
  </div>
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>

<script type="text/javascript">

var id="${param.id}";

layui.use(['form',], function(){
	  var form = layui.form;
	  form.on('submit(demo1)', function(data){
		 $.post($("form").attr("action"), data.field, function(json) {
			  closeFrame();
			  parent.fresh('demo');
			}, "json");
		    return false;
		  });
});

function init(){
	$.post("Address/"+id, {_method : "get"}, function(json) {
		render('myform', json);
		getlist("Address/getPros", {_method : "get"},"[name=father]",json.father);
	},"json");
}
if(id.length>0){
	init();
}else{
	getlist("Address/getPros", {_method : "get"},"[name=father]",0);
}

</script>
</body>
</html>