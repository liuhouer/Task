<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../../common/common.jsp"%>
<title>Insert title here</title>
</head>
<body>


	 <input type="button" value="新增" name="add" id="add" onclick="adds();" style="text-align: center;left: 30%;top: 10%;position: absolute;">
	 <a href="/Demos/qqAction/login">请使用你的QQ账号登陆</a>
<script type="text/javascript">
	
	function adds(){ 
		
		art.dialog.open('SchoolAction/toAdd.action', {
	        id: 'pg123',
	        title: '添加',width:'600px',height:'450px',lock:true,
	        ok: function () {
	            var iframe = this.iframe.contentWindow;
	            iframe.document.getElementById("btnsave").click();
	            return false;
	        },
	        cancel: true
	    });

		
    }
	function showtip2(str) {
	    art.dialog.tips(str, 1.5);
	    setTimeout('originreload()', 1000);
	}
	function originreload()
	{
	    var win = art.dialog.open.origin;//来源页面
	    win.location.reload();
	}
	
	</script>

</body>
</html>