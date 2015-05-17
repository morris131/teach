<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改教学安排</title>
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
						<div class="pull-left">修改教学安排</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">
						<div class="padd">

							<form action="${ctx }/admin/saveTeachArrange" method="post" role="form" class="form-horizontal">

								<input type="hidden" name="id" value="${teachArrange.id }">
								
								<div class="form-group">
									<label class="col-lg-4 control-label">教师名</label>
									<div class="col-lg-8">
										<input type="text" name="title" class="form-control" value="${teachArrange.title }">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-lg-4 control-label">教师类型</label>
									<div class="col-lg-4">
										<select class="form-control" name="teachArrangeType.id">
											<c:forEach items="${types }" var="type" >
												<option value="${type.id }">${type.name }</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-lg-4 control-label">基本介绍</label>
									<div class="col-lg-8">
										<textarea id="editor" style="height: 350px;display: none;" name="content">${teachArrange.content }</textarea>
									</div>
								</div>
								
								
								<hr />
                                <div class="form-group">
                                  <div class="col-lg-offset-2 col-lg-6">
                                    <input type="submit" class="btn btn-primary" value="提交">
                                    <a href="${ctx }/admin/findTeachArranges" class="btn btn-warning">返回</a>
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