<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改下载资源</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<!-- Widget -->
				<div class="widget">
					<!-- Widget head -->
					<div class="widget-head">
						<div class="pull-left">修改下载资源</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">
						<div class="padd">

							<form action="${ctx }/admin/saveDownloadResource" enctype="multipart/form-data" method="post" role="form" class="form-horizontal">
								<input type="hidden" name="id" value="${downloadResource.id}">
								<div class="form-group">
									<label class="col-lg-4 control-label">资源名</label>
									<div class="col-lg-8">
										<input type="text" name="title" class="form-control" value="${downloadResource.title}">
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">类型</label>
									<div class="col-lg-4">
										<select class="form-control" name="downloadResourceType.id">
											<c:forEach items="${types }" var="type" >
												<c:choose>
													<c:when test="${downloadResource.downloadResourceType.id == type.id}">
														<option value="${type.id }" selected="selected">${type.name }</option>
													</c:when>
													<c:otherwise>
														<option value="${type.id }">${type.name }</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">来源</label>
									<div class="col-lg-4">
										<select class="form-control" name="resourceSrc.id">
											<c:forEach items="${resourceSrcs }" var="resourceSrc" >
												<c:choose>
													<c:when test="${downloadResource.resourceSrc.id == resourceSrc.id}">
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
									<label class="col-lg-4 control-label">上传文件</label>
									<div class="col-lg-8">
										${downloadResource.realName }<input type="file" name="resFile" class="form-control">
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">内容</label>
									<div class="col-lg-8">
										<textarea class="form-control" name="content">${downloadResource.content}</textarea>
									</div>
								</div>
								
								
								<hr />
                                <div class="form-group">
                                  <div class="col-lg-offset-2 col-lg-6">
                                    <input type="submit" class="btn btn-primary" value="提交">
                                    <a href="${ctx }/admin/findDownloadResources" class="btn btn-warning">返回</a>
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
</body>
</html>