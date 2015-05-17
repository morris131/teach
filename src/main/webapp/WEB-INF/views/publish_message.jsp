<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<TITLE>发表留言</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${ctx }/static/css/book.css"
	type="text/css">
<style type="text/css">
.STYLE1 {
	color: #000000
}

.STYLE2 {
	color: #FF0000
}
</style>
</head>

<body background="${ctx }/static/images/bg.gif" topmargin="0"
	leftmargin="0">
	<table width="880" border=0 cellspacing=0 cellpadding=0
		bgcolor="#FFFFFF" align=center class="grayline">
		<tr>
			<td><img border="0" src="${ctx }/static/images/TOPS.gif"
				width=880></td>
		</tr>
	</table>
	<center>

		<table width="880" border=0 cellspacing=0 cellpadding=0 align=center
			bgcolor="#FFFFFF" class="grayline">
			<tr>
				<td align=center height=50><img border=0
					src="${ctx }/static/images/write.gif">
					&nbsp;&nbsp;&nbsp;&nbsp; <a href="${ctx }/toMessage"><img border=0
						src="${ctx }/static/images/read.gif" title="我要看留言"></a></td>
			</tr>

			<tr>
				<td>

					<form action="${ctx }/publishMessage" method="post" onsubmit="return validateForm()">
						<table cellSpacing="1" borderColorDark="#ffffff" cellPadding="4"
							width="840" align="center" bgColor="#000000"
							borderColorLight="#000000" border="0">
							<tr bgColor="#ebebeb">
								<td width="20%" align=right>您的姓名：</td>

								<td><input type="text" id="name" name="name" size="30" maxlength=16
									value=""> <font color="#FF0000"> </font><span
									class="STYLE1">（请如实填写，否则审核不会通过</span><span class="STYLE1">）</span></td>
							</tr>
							<tr bgColor="#ebebeb">
								<td width="20%" align=right>您的邮箱：</td>
								<td><input type="text" id="email" name="email" size="30" maxlength=50
									value=""> <font color="#FF0000"></font></td>
							</tr>
							<tr bgColor="#ebebeb">
								<td width="20%" align=right>您的班级：</td>
								<td><input type=text name="grade" id="grade" size="30" maxlength=100
									value=""> <span class="STYLE1">（请如实填写，否则审核不会通过）</span></td>
							</tr>

							<tr bgColor="#ebebeb">
								<td width="20%" align=right>联系方式：</td>
								<td><input type=text id="tel" name="tel"
									size="30" maxlength=100> （如TEL、QQ、MSN等）</td>
							</tr>
							<tr bgColor="#ebebeb">
								<td width="20%" align=right>留言主题：</td>
								<td><input type=text id="title" name="title" size="30" maxlength=50>
									<font color="#FF0000">*必须填写（20字以内）</font></td>
							</tr>
							<tr bgColor="#ebebeb">
								<td width="20%" align=right>留言内容：<br> <font color=red>（250字以内）</font></td>
								<td><textarea name="content" id="content" rows="7" cols="66"
										style="overflow: auto;"></textarea></td>
							<tr bgColor="#ebebeb">
								<td colSpan="2"><input type="submit" value="提交留言" onclick="return validateForm()"> 
												<input type="reset" value="重新填写">
									<span class="STYLE2">注意：留言内容不会马上显示，要经过后台的审核才可以显示，所以请大家注意言论！！</span></td>
							</tr>
						</table>
					</form>
		</table>
		<script src="${ctx}/static/js/jquery.js"></script> <!-- jQuery -->
		<script type="text/javascript">
			
			function validateForm(){
				
				var name = $("#name").val();
				if("" == name){
					alert("姓名不能为空");
					return false;
				}
				
				var email = $("#email").val();
				if("" == email){
					alert("邮箱不能为空");
					return false;
				}
				
				var grade = $("#grade").val();
				if("" == grade){
					alert("班级不能为空");
					return false;
				}
				
				var tel = $("#tel").val();
				if("" == tel){
					alert("联系方式不能为空");
					return false;
				}
				
				var title = $("#title").val();
				if("" == title){
					alert("主题不能为空");
					return false;
				}
				
				var content = $("#content").val();
				if("" == content){
					alert("内容不能为空");
					return false;
				}
			}
		
		
		</script>

		<table class="grayline" align="center" bgcolor="#FFFFFF" border="0"
			cellpadding="0" cellspacing="0" width="880">
			<tbody>
				<tr>
					<td width="30">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="3" background="${ctx }/static/images/DOWN1.GIF"
						height="37"><a href="#top"></a>&nbsp;&nbsp;
						<div align="center">
							版权所有@ 湖南理工学院 · 信息与通信工程学院 2009年9月 <br>
						</div> <a href="" title="管理留言本"></a></td>
				</tr>
			</tbody>
		</table>

	</center>
</body>
</html>
