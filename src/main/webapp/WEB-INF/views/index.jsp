<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>首页</title>
<style>
	.dialog-title {
		width: 130px; 
		float: left; 
		height: 36px;
		background-color: #073990;
		text-align: center;
		
	}
	
	.dialog-title span {
		font-size: 16px;
		font-weight: bold;
		text-align: center;
		line-height: 36px;
		color: white;
	}
	
	
</style>
</head>
<body>

	<div class="content">
		<!-- 焦点图开始 -->
		<div class="main_visual">
			<div class="flicking_con">
				<c:forEach items="${advs.content }" var="adv">
						<a href="#">1</a>
					</c:forEach>
			</div>
			<div class="main_image">
				<ul>
					<c:forEach items="${advs.content }" var="adv">
						<li><a href="${adv.url }"><img src="${ctx }/static/upload/adv/${adv.picture }"></a></li>
					</c:forEach>
				</ul>
				<a href="javascript:;" id="btn_prev"></a> <a href="javascript:;"
					id="btn_next"></a>
			</div>
		</div>
		<!-- 焦点图结束 -->

		<!-- 信息展示框 -->
		<div class="message">
			<div class="left">
				<div class="left_m">
					<div class="one_left">
						<div class="dialog-title">
							<span>教学新闻</span>
						</div>
						<a href="${ctx }/toTeachNews?typeId=0"><img src="${ctx }/static/images/more_b.jpg" class="float_right" /></a>
						<div class="clear"></div>
					</div>
					<ul class="left_ul">
						<c:forEach items="${teachNews.content }" var="teachNew">
							<li><a href="${ctx }/toTeachNewsDetail?id=${teachNew.id }">${teachNew.title }</a>
								<span class="right_time">[<fmt:formatDate pattern="yyyy-MM-dd" value="${teachNew.datetime }"/>]</span>
							</li>
						</c:forEach>
					</ul>
					<div class="clear: both"></div>
				</div>
				<div class="shadow">
					<img src="${ctx }/static/images/shadow.jpg" />
				</div>
			</div>
			<div class="right">
				<div class="right_m">
					<div class="one_left">
						<div class="dialog-title">
							<span>公告牌</span>
						</div>
						<a href="${ctx }/toTeachNews?typeId=1"><img src="${ctx }/static/images/more_b.jpg" class="float_right" /></a>
						<div class="clear"></div>
					</div>
					<ul class="left_ul">
						<c:forEach items="${infos.content }" var="info">
							<li><a href="${ctx }/toTeachNewsDetail?id=${info.id }">${info.title }</a>
								<span class="right_time">[<fmt:formatDate pattern="yyyy-MM-dd" value="${info.datetime }"/>]</span>
							</li>
						</c:forEach>
					</ul>
					<div class="clear: both"></div>
				</div>
				<div class="shadow">
					<img src="${ctx }/static/images/shadow.jpg" />
				</div>
			</div>
			<div class="clear"></div>
			<div class="left">
				<div class="left_m">
					<div class="one_left">
						<div class="dialog-title">
							<span>师生交流</span>
						</div>
						 <a href="${ctx }/toMessage"><img src="${ctx }/static/images/more_b.jpg" class="float_right" /></a>
						<div class="clear"></div>
					</div>
					
					<ul class="left_ul">
						<c:forEach items="${messages.content }" var="message">
							<li><a href="${ctx }/toMessage">${message.title }</a>
								<span class="right_time">[<fmt:formatDate pattern="yyyy-MM-dd" value="${message.datetime }"/>]</span>
							</li>							
						</c:forEach>
					</ul>
					
					<div class="clear: both"></div>
				</div>
				<div class="shadow">
					<img src="${ctx }/static/images/shadow.jpg" />
				</div>
			</div>
			<div class="right">
				<div class="right_m">
					<div class="one_left">
						<div class="dialog-title">
							<span>资源下载</span>
						</div>
						 <a href="${ctx }/toDownloadResource"><img src="${ctx }/static/images/more_b.jpg" class="float_right" /></a>
						<div class="clear"></div>
					</div>
					<ul class="left_ul">
						<c:forEach items="${downloadResources.content }" var="downloadResource">
							<li><a href="${ctx }/toDownloadResourceDetail?id=${downloadResource.id}">${downloadResource.title }</a>
								<span class="right_time">[<fmt:formatDate pattern="yyyy-MM-dd" value="${downloadResource.datetime }"/>]</span>
							</li>							
						</c:forEach>
					</ul>
					<div class="clear: both"></div>
				</div>
				<div class="shadow">
					<img src="${ctx }/static/images/shadow.jpg" />
				</div>
			</div>
			<div class="clear"></div>
		</div>



		<!-- 下面滚动图片代码 -->
		<div class="apply">
			<div class="img_l">
				<img src="${ctx }/static/images/left.gif" />
			</div>
			<div class="apply_nav">
				<div class="apply_w">
					
					<c:forEach items="${outstandStudents }" var="outstandStudent">
						<div class="apply_array">
						<div class="apply_img">
							<a href="${ctx }/toOutstandStudentDetail?id=${outstandStudent.id }">
							<img src="${ctx }/static/upload/photo/${outstandStudent.fileName }" width="100%" height="100%"/></a>
						</div>
						<div class="apply_info">
							<a href="${ctx }/toOutstandStudentDetail?id=${outstandStudent.id }" target="_blank">${outstandStudent.title }</a>
						</div>
					</div>
					</c:forEach>
					
				</div>
			</div>
			<div class="img_r">
				<img src="${ctx }/static/images/right.gif" />
			</div>
		</div>
		<div class="clear"></div>
	</div>
</body>
</html>