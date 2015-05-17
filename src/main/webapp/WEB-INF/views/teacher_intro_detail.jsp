<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${teacherIntro.title }-师资介绍</title>
</head>
<body>
	<div class="content">
		<div class="details">
			<div class="d_left">
				<div class="left_nav">
					<div class="left_m_nav">
						<div class="one_left_nav">
							<h3 class="title">师资介绍</h3>
							<div class="clear"></div>
						</div>
						<ul class="left_ul">
							<c:forEach items="${types }" var="type">
								<li><a href="${ctx }/toTeacherIntro?typeId=${type.id }">${type.name }</a></li>
							</c:forEach>
						</ul>
						<div class="clear: both"></div>
					</div>
				</div>
			</div>
			<div class="d_right">
				<div class="d_right_top">
				
				 <div class="title">
					<div class="position">当前位置：<a href="index.html" title="网站首页">首页</a> &gt; 
					<a href="${ctx }/toTeacherIntro">师资介绍</a> &gt; <a href="javascript:void(0)">${teacherIntro.title }</a></div>
				</div>

				<div class="res-title">${teacherIntro.title }</div>

					<div class="res-info">
						<span>点击次数:${teacherIntro.count }次</span> 
						<span>更新时间:${teacherIntro.datetime} </span>
					</div>
				
					${ teacherIntro.content}
					
				
					<div class="res-footer"> 
						<span>上一篇: 
						 	<c:choose>
						 		<c:when test="${empty last }">
						 			<a href="javascript:void(0)">没有了</a>
						 		</c:when>
						 		<c:otherwise>
						 			<a href="${ctx }/toTeacherIntroDetail?id=${last.id}">${last.title}</a>
						 		</c:otherwise>
						 	</c:choose>	
					 	</span>
						<span>下一篇: 
							<c:choose>
						 		<c:when test="${empty next }">
						 			<a href="javascript:void(0)">没有了</a>
						 		</c:when>
						 		<c:otherwise>
						 			<a href="${ctx }/toTeacherIntroDetail?id=${next.id}">${next.title}</a>
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