<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${teachNews.title }-新闻与公告</title>
</head>
<body>
	<div class="content">
		<div class="details">
			<div class="d_left">
				<div class="left_nav">
				<div class="left_m_nav">
					<div class="one_left_nav">
						<h3 class="title">新闻与公告</h3> 
						<div class="clear"></div>
					</div>
					<ul class="left_ul">
						<li><a href="${ctx }/toTeachNews?typeId=0">新闻</a></li>
						<li><a href="${ctx }/toTeachNews?typeId=1">公告</a></li>
					</ul>
					<div class="clear: both"></div>
				</div>
			</div>
			</div>
			<div class="d_right">
				<div class="d_right_top">
					
					<div class="title">
					<div class="position">当前位置：<a href="index.html" title="首页">首页</a> &gt; 
						<a href="${ctx }/toTeachNews">新闻与公告</a> &gt; 
						<a href="javascript:void(0)">${teachNews.title }</a>
					</div>
					</div>

					<div class="res-title">${teachNews.title }</div>

					<div class="res-info">
						<span>来源:${teachNews.resourceSrc.name }</span> 
						<span>点击次数:${teachNews.count }次</span> 
						<span>更新时间:<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${teachNews.datetime}"/> </span>
					</div>
				${teachNews.content }
					
					<div class="res-footer"> 
						<span>上一篇: 
						 	<c:choose>
						 		<c:when test="${empty last }">
						 			<a href="javascript:void(0)">没有了</a>
						 		</c:when>
						 		<c:otherwise>
						 			<a href="${ctx }/toTeachNewsDetail?id=${last.id}">${last.title}</a>
						 		</c:otherwise>
						 	</c:choose>	
					 	</span>
						<span>下一篇: 
							<c:choose>
						 		<c:when test="${empty next }">
						 			<a href="javascript:void(0)">没有了</a>
						 		</c:when>
						 		<c:otherwise>
						 			<a href="${ctx }/toTeachNewsDetail?id=${next.id}">${next.title}</a>
						 		</c:otherwise>
						 	</c:choose>	
						</span>
					</div>

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