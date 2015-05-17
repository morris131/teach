<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言管理</title>

<link rel="stylesheet" href="${ctx }/static/css/book.css"
	type="text/css">
<link rel="stylesheet" type="text/css"
	href="${ctx }/static/css/kkpager_blue.css" />

<script type="text/javascript" src="${ctx }/static/js/jquery.js"></script>
<script type="text/javascript" src="${ctx }/static/js/kkpager.js"></script>

<style type="text/css">
.STYLE1 {
	color: #FF0000
}
</style>

</head>
<body topmargin="0" leftmargin="0">
	<table class="grayline" align="center" bgcolor="#FFFFFF" border="0"
		cellpadding="0" cellspacing="0" width="880">
		<tbody>
			<tr>
				<td width="808"><img src="${ctx }/static/images/TOPS.gif"
					border="0" height="89" width="880"></td>
			</tr>
		</tbody>
	</table>
	<center>
		<table class="grayline" align="center" bgcolor="#FFFFFF" border="0"
			cellpadding="0" cellspacing="0" width="880">
			<tbody>
				<tr>
					<td colspan="2" align="center" height="25" width="805"><a
						href="${ctx }/toPublishMessage"> <img
							src="${ctx }/static/images/write.gif" alt="发表留言" border="0"
							height="37" width="89">
					</a> <a href="javascript:void(0)"><img
							src="${ctx }/static/images/read.gif" alt="浏览留言" border="0"
							height="37" width="89"> </a><a href="${ctx }/"><img
							src="${ctx }/static/images/LOGINOUT.GIF" alt="退出留言" border="0"
							height="37" width="89"></a></td>
				</tr>
				<tr>
					<td>
						<c:forEach items="${messages.content }" var="message">
							<table align="center" bgcolor="#000000" border="0" cellpadding="3"
							cellspacing="1" width="800px">
							<tbody>
								<tr>
									<td rowspan="2" align="center" bgcolor="#f7f7f7" valign="top"
										width="25%">
										<table border="0" width="80%">
											<tbody>
												<tr>
													<td align="center"></td>
												</tr>
												<tr>
													<td height="135">姓 名：${message.name }<br> 来 自：${message.grade } <br>
														联系方式：${message.tel }<br> 邮件：<a
														href="mailto:${message.email }"><img
															src="${ctx }/static/images/mail.gif" border="0"
															height="16" width="16"></a><br> ${message.datetime }
													</td>
												</tr>
											</tbody>
										</table>
									</td>
									<td bgcolor="#ffffff" height="20" width="75%">主题：<font
										color="blue">${message.title }</font>
									</td>
								</tr>
									<tr>
										<td onmouseover="bgColor='#FFffff'"
											onmouseout="bgColor='#ebebeb'" bgcolor="#ebebeb" height="123"
											valign="top" width="75%">${message.content } <br>
										<br> <c:if test="${not empty message.reply }">

												<table cellSpacing="1" cellPadding="3" width="90%"
													align="center" bgColor="darkgray" border="0">
													<tr>
														<td vAlign="top" bgColor="#f7f7f7">管理员回复：<br> <font
															color="red">&nbsp;&nbsp;${message.reply }</font></td>
													</tr>
												</table>
											</c:if>
										</td>
									</tr>
								</tbody>
						</table>
						</c:forEach>	
					</td>
				</tr>
				<tr>
					<td>
						<div style="width: 800px; margin: 0 auto;">
							<div id="kkpager"></div>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</center>

	<script type="text/javascript">
		function getParameter(name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
			var r = window.location.search.substr(1).match(reg);
			if (r != null)
				return unescape(r[2]);
			return null;
		}

		//init
		$(function() {
			var totalPage = "${messages.totalPages}";
			var totalRecords = "${messages.totalElements}";
			var pageNumber = "${pageNumber}";
			
			//生成分页
			//有些参数是可选的，比如lang，若不传有默认值
			kkpager.generPageHtml({
				pno : pageNumber,
				//总页码
				total : totalPage,
				//总数据条数
				totalRecords : totalRecords,
				//链接前部
				hrefFormer : 'toMessage',
				//链接尾部
				hrefLatter : '',
				getLink : function(n) {
					return this.hrefFormer + this.hrefLatter + "?pageNumber=" + n;
				}
			});
		});
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
</body>
</html>