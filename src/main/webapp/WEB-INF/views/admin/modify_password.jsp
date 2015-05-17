<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<!-- Widget -->
				<div class="widget">
					<!-- Widget head -->
					<div class="widget-head">
						<div class="pull-left">修改密码</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">
						<div class="padd">

							<form action="${ctx }/admin/savePassword"  method="post" role="form" class="form-horizontal">

								<div class="form-group">
									<label class="col-lg-5 control-label">原密码</label>
									<div class="col-lg-7">
										<input type="password" name="oldPassword" class="form-control" placeholder="请输入原密码">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-lg-5 control-label">新密码</label>
									<div class="col-lg-7">
										<input type="password" name="newPassword" class="form-control" placeholder="请输入新密码">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-lg-5 control-label">确认密码</label>
									<div class="col-lg-7">
										<input type="password" name="newPassword2" class="form-control"  placeholder="请再次输入新密码">
									</div>
								</div>

								<hr />
                                <div class="form-group">
                                  <div class="col-lg-offset-2 col-lg-6">
                                    <input type="submit" class="btn btn-primary" value="修改">
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