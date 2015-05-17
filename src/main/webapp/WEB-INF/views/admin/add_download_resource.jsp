<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加下载资源</title>

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<!-- Widget -->
				<div class="widget">
					<!-- Widget head -->
					<div class="widget-head">
						<div class="pull-left">添加下载资源</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">
						<div class="padd">

							<form action="${ctx }/admin/saveDownloadResource" enctype="multipart/form-data" method="post" role="form" class="form-horizontal">

								<div class="form-group">
									<label class="col-lg-4 control-label">资源名</label>
									<div class="col-lg-8">
										<input type="text" name="title" class="form-control">
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">类型</label>
									<div class="col-lg-4">
										<select class="form-control" name="downloadResourceType.id">
											<c:forEach items="${types }" var="type" >
												<option value="${type.id }">${type.name }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">来源</label>
									<div class="col-lg-4">
										<select class="form-control" name="resourceSrc.id">
											<c:forEach items="${resourceSrcs }" var="resourceSrc" >
												<option value="${resourceSrc.id }">${resourceSrc.name }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">上传文件</label>
									<div class="col-lg-8">
										<input type="file" name="resFile" class="form-control">
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">内容</label>
									<div class="col-lg-8">
										<textarea class="form-control" name="content"></textarea>
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