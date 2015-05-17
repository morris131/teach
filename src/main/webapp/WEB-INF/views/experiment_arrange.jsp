<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${experimentArrange.title }-实验安排</title>
</head>
<body>
	<div class="content">
		<div class="details">
			<div class="d_left">
				<div class="left_nav">
				<div class="left_m_nav">
					<div class="one_left_nav">
						<h3 class="title">实验安排</h3> 
						<div class="clear"></div>
					</div>
					<ul class="left_ul">
						<c:forEach items="${experimentArranges }" var="c">
							<li><a href="${ctx }/toExperimentArrange?id=${c.id}">${c.title }</a></li>
						</c:forEach>
					</ul>
					<div class="clear: both"></div>
				</div>
			</div>
			</div>
			<div class="d_right">
					<div class="d_right_top">
						<div class="title">
							<div class="position">当前位置：<a href="index.html">首页</a> &gt; 
								<a href="${ctx }/toExperimentArrange">实验安排</a> &gt; 
								<a href="javascript:void(0)">${experimentArrange.title }</a>
							</div>
						</div>
						
						<div class="res-title">${experimentArrange.title }</div>
						${experimentArrange.content }
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