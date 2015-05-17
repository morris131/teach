<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改留言</title>
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
						<div class="pull-left">修改留言</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">
						<div class="padd">

							<form action="${ctx }/admin/saveMessage" method="post" role="form" class="form-horizontal">
								<input type="hidden" value="${message.id }" name="id">
								<div class="form-group">
									<label class="col-lg-4 control-label">姓名</label>
									<div class="col-lg-8">
										${message.name }
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">班级</label>
									<div class="col-lg-8">
										${message.grade }
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">电子邮箱</label>
									<div class="col-lg-8">
										${message.email }
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">联系方式</label>
									<div class="col-lg-8">
										${message.tel }
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">主题</label>
									<div class="col-lg-8">
										${message.title }
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">内容</label>
									<div class="col-lg-8">
										${message.content }
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">审核状态</label>
									<div class="col-lg-8">
										<select class="form-control" name="isValid">
											<c:choose>
												<c:when test="${message.isValid == 0 }">
													<option value="0" selected="selected">未审核</option>
													<option value="1">审核通过</option>
													<option value="2">审核未通过</option>
												</c:when>
												<c:when test="${message.isValid == 1 }">
													<option value="0">未审核</option>
													<option value="1" selected="selected">审核通过</option>
													<option value="2">审核未通过</option>
												</c:when>
												<c:otherwise>
													<option value="0">未审核</option>
													<option value="1">审核通过</option>
													<option value="2" selected="selected">审核未通过</option>
												</c:otherwise>
											</c:choose>
											
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">回复内容</label>
									<div class="col-lg-8">
										<textarea class="form-control" name="reply">${message.reply }</textarea>
									</div>
								</div>
								
								<hr />
                                <div class="form-group">
                                  <div class="col-lg-offset-2 col-lg-6">
                                    <input type="submit" class="btn btn-primary" value="提交">
                                    <a href="${ctx }/admin/findMessages" class="btn btn-warning">返回</a>
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