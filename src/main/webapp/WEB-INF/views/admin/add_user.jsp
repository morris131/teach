<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加用户</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<!-- Widget -->
				<div class="widget">
					<!-- Widget head -->
					<div class="widget-head">
						<div class="pull-left">添加用户</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">
						<div class="padd">

							<form action="${ctx }/admin/saveUser" method="post" role="form" class="form-horizontal">

								<div class="form-group">
									<label class="col-lg-4 control-label">用户名</label>
									<div class="col-lg-8">
										<input type="text" name="username" class="form-control" placeholder="请输入用户名">
										<span style="color: red;">${message }</span>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-lg-4 control-label">密码</label>
									<div class="col-lg-8">
										<input type="password" name="password" class="form-control" placeholder="请输入密码">
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">确认密码</label>
									<div class="col-lg-8">
										<input type="password" name="password2" class="form-control" placeholder="请输入密码">
									</div>
								</div>
								<hr />
                                <div class="form-group">
                                  <div class="col-lg-offset-2 col-lg-6">
                                    <input type="submit" class="btn btn-primary" value="提交">
                                    <a href="${ctx }/admin/findUsers" class="btn btn-warning">返回</a>
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