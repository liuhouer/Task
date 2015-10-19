<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../../common/common.jsp"%>
</head>
<body>
	<form id="f1" action="SchoolAction/addSchool.action" method="post" >
	<input type="hidden" name="token" value="${sessionScope.token}">
		<table>
			<tr>
			<td>学校编码</td>
			<td>
			<input type="text" style="width: 300px;" name="schoolCode" class="validate[required]"
				id="schoolCode" value="" />
			<span class="star">*</span>
			</td>
			</tr>

			<tr>
			<td>学校名称</td>
			<td>
			<input type="text" style="width: 300px;" name="schoolName" class="validate[required]"
				id="schoolName" value="" />
			<span class="star">*</span>
			</td>
			</tr>

			<tr>
			<td>应用系统URL</td>
			<td>
			<input type="text" style="width: 300px;" name="url" id="url" class="validate[required]" value="" />
			<span class="star">*</span>
			</td>
			</tr>

			<tr>
			<td>联系人</td>
			<td>
			<input type="text" style="width: 300px;" name="lxr" id="lxr" value=""   />
			<span>&nbsp;&nbsp;&nbsp;</span>
			</td>
			</tr>

			<tr>
			<td>电话</td>
			<td>
			<input type="text" style="width: 300px;" name="tel" id="tel" value=""  />
			<span>&nbsp;&nbsp;&nbsp;</span>
			</td>
			</tr>


			<tr>
			<td>email</td>
			<td>
			<input type="text" style="width: 300px;" name="email" id="email"  
				value="" />
				<span>&nbsp;&nbsp;&nbsp;</span>
				</td>
			</tr>


			<tr>
			<td>联系地址</td>
			<td>
			<input type="text" style="width: 300px;" name="address" id="address" 
				value="" />
				<span>&nbsp;&nbsp;&nbsp;</span>
				</td>
			</tr>


			<tr>
			<td>学校说明 </td>
			</td>
			<td>
			<textarea cols="20" style="width: 300px;" name="comment" id="comment" ></textarea>
			<span>&nbsp;&nbsp;&nbsp;</span>
			</td>
			</tr>

			<input type="submit" style="display: none"  id="btnsave"  onclick="openIt()" /> 
		</table>


	</form>
	<script type="text/javascript">
	  function openIt(){
		  $("[class^=validate]").validationEngine({
			  success : function() {
		  $.ajax({
			            cache: true,
		  				type: "POST",
		  				url:"SchoolAction/addSchool.action",
		  				data:$('#f1').serialize(),// 你的formid
		  				async: false,
		  			    success: function() {
		  			    	window.parent.showtip2("成功！");
		  			    }
		  });
			  },
			  failure : function() {return false;}
			 });
		 // $("#f1").attr("action","MenuAction/addMenu.action").submit();
		  //art.dialog.close();
	  }
	  
	</script>

</body>
</html>