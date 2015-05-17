<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改广告</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<!-- Widget -->
				<div class="widget">
					<!-- Widget head -->
					<div class="widget-head">
						<div class="pull-left">修改广告</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">
						<div class="padd">

							<form action="${ctx }/admin/saveAdv" enctype="multipart/form-data" method="post" role="form" class="form-horizontal">
								
								<input type="hidden" name="id" value="${adv.id }"> 

								<div class="form-group">
									<label class="col-lg-4 control-label">标题</label>
									<div class="col-lg-8">
										<input type="text" name="title" class="form-control" value="${adv.title }">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-lg-4 control-label">图片</label>
									<div class="col-lg-8">
										<img width="50px" alt="" src="${ctx }/static/upload/adv/${adv.picture}">
										<input type="file" name="resFile" class="form-control" >
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-lg-4 control-label">链接</label>
									<div class="col-lg-8">
										<input type="text" name="url" class="form-control"  value="${adv.url }">
									</div>
								</div>

								<div class="form-group">
									<label class="col-lg-4 control-label">内容</label>
									<div class="col-lg-8">
										<textarea class="form-control" name="content">${adv.content }</textarea>
									</div>
								</div>
								
								<hr />
                                <div class="form-group">
                                  <div class="col-lg-offset-2 col-lg-6">
                                    <input type="submit" class="btn btn-primary" value="提交">
                                    <a href="${ctx }/admin/findAdvs" class="btn btn-warning">返回</a>
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