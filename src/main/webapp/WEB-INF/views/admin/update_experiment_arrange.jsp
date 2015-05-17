<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改实验安排</title>
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
						<div class="pull-left">修改实验安排</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">
						<div class="padd">

							<form action="${ctx }/admin/saveExperimentArrange" method="post" role="form" class="form-horizontal">
								<input type="hidden" value="${experimentArrange.id }" name="id">
								
								<div class="form-group">
									<label class="col-lg-4 control-label">标题</label>
									<div class="col-lg-8">
										<input type="text" name="title" value="${experimentArrange.title }" class="form-control" placeholder="请输入标题">
									</div>
								</div>

								<div class="form-group">
									<label class="col-lg-4 control-label">内容</label>
									<div class="col-lg-8">
										<textarea id="editor" style="height: 350px;display: none;" name="content">${experimentArrange.content }</textarea>
									</div>
								</div>
								
								<hr />
                                <div class="form-group">
                                  <div class="col-lg-offset-2 col-lg-6">
                                    <input type="submit" class="btn btn-primary" value="提交">
                                    <a href="${ctx }/admin/findExperimentArranges" class="btn btn-warning">返回</a>
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
	$(function(){
		var ue = UE.getEditor('editor');
		$("#editor").show();
	});
</script>

</body>
</html>