<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源下载</title>
<link rel="stylesheet" type="text/css"
	href="${ctx }/static/css/kkpager_blue.css" />
<script type="text/javascript" src="${ctx }/static/js/jquery.js"></script>
<script type="text/javascript" src="${ctx }/static/js/kkpager.js"></script>
</head>
<body>
	<div class="content">
		<div class="details">
			<div class="d_left">
				<div class="left_nav">
				<div class="left_m_nav">
					<div class="one_left_nav">
						<h3 class="title">资源下载</h3> 
						<div class="clear"></div>
					</div>
					<ul class="left_ul">
						<c:forEach items="${types }" var="type">
							<li><a href="${ctx }/toDownloadResource?typeId=${type.id}">${type.name }</a></li>
						</c:forEach>
					</ul>
					<div class="clear: both"></div>
				</div>
			</div>
			</div>
			<div class="d_right">
				<div class="d_right_top">
					
					<div class="title">
						<div class="position">当前位置：<a href="index.html">首页</a> &gt; <a href="${ctx }/toDownloadResource">资源下载</a></div>
					</div>
				
					<ul class="left_ul">
						<c:forEach items="${page.content }" var="downloadResource">
							<li><a href="${ctx }/toDownloadResourceDetail?id=${downloadResource.id}">${downloadResource.title }</a>
							<span class="right_time"> 发布时间：<fmt:formatDate pattern="yyyy-MM-dd" value="${downloadResource.datetime }"/> 下载次数：${downloadResource.count }</span></li>
						</c:forEach>
					</ul>
					
					<div id="kkpager"></div>
					
					<script type="text/javascript">
						$(function() {
							var totalPage = "${page.totalPages}";
							var totalRecords = "${page.totalElements}";
							var pageNumber = "${pageNumber}";
							var typeId = "${typeId}";
							
							//生成分页
							//有些参数是可选的，比如lang，若不传有默认值
							kkpager.generPageHtml({
								pno : pageNumber,
								//总页码
								total : totalPage,
								//总数据条数
								totalRecords : totalRecords,
								//链接前部
								hrefFormer : 'toDownloadResource',
								//链接尾部
								hrefLatter : '',
								getLink : function(n) {
									return this.hrefFormer + this.hrefLatter + "?pageNumber=" + n + "&&typeId=" + typeId;
								}
							});
						});
					</script>
				</div>
				<div class="d_right_bottom">
					<img src="${ctx }/static/images/j_right.jpg" />
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>