<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改新闻与公告</title>
<script type="text/javascript" charset="utf-8"
	src="${ctx}/static/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${ctx}/static/ueditor/ueditor.all.min.js">
	
</script>
<script type="text/javascript" charset="utf-8"
	src="${ctx}/static/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<!-- Widget -->
				<div class="widget">
					<!-- Widget head -->
					<div class="widget-head">
						<div class="pull-left">修改新闻与公告</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">
						<div class="padd">

							<form action="${ctx }/admin/saveTeachNews" method="post"
								role="form" class="form-horizontal">
								
								<input type="hidden" value="${teachNews.id }" name="id">
								
								<div class="form-group">
									<label class="col-lg-4 control-label" for="title">标题</label>
									<div class="col-lg-8">
										<input type="text" id="title" name="title" class="form-control"
											value="${teachNews.title }">
									</div>
								</div>

								<div class="form-group">
									<label class="col-lg-4 control-label" for="type">类型</label>
									<div class="col-lg-4">
										<select class="form-control" name="type" id="type">
											<c:choose>
												<c:when test="${teachNews.type == 0 }">
													<option value="0" selected="selected">新闻</option>
													<option value="1">公告</option>
												</c:when>
												<c:otherwise>
													<option value="0">新闻</option>
													<option value="1" selected="selected">公告</option>
												</c:otherwise>
											</c:choose>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label" for="src">来源</label>
									<div class="col-lg-4">
										<select class="form-control" name="resourceSrc.id" id="src">
											<c:forEach items="${resourceSrcs }" var="resourceSrc">
												<c:choose>
													<c:when test="${teachNews.resourceSrc.id == resourceSrc.id }">
														<option value="${resourceSrc.id }" selected="selected">${resourceSrc.name }</option>
													</c:when>
													<c:otherwise>
														<option value="${resourceSrc.id }">${resourceSrc.name }</option>
													</c:otherwise>
												</c:choose>
											
											</c:forEach>
											
										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-lg-4 control-label" for="editor">内容</label>
									<div class="col-lg-8">
										<textarea id="editor" style="height: 350px;" name="content">${teachNews.content }</textarea>
									</div>
								</div>


								<hr />
								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-6">
										<input type="submit" class="btn btn-primary" value="提交">
										<a href="${ctx }/admin/findTeachNews"
											class="btn btn-warning">返回</a>
									</div>
								</div>

							</form>

						</div>
					</div>
					<!-- Widget ends -->

				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		var ue = UE.getEditor('editor').setHeight(600);
	</script>
</body>
</html>