<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改用户角色</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<!-- Widget -->
				<div class="widget">
					<!-- Widget head -->
					<div class="widget-head">
						<div class="pull-left">修改用户角色</div>
						<div class="clearfix"></div>
					</div>
					
					<!-- Widget content -->
					<div class="widget-content">
						<div class="padd">

							<form action="${ctx }/admin/saveUserRole" method="get" role="form" class="form-horizontal">
								<input type="hidden" name="id" value="${user.id }">
								<div class="form-group">
									<label class="col-lg-4 control-label">角色</label>
									<div class="col-lg-8">

										<select class="form-control" multiple="multiple" name="roles">
											<c:choose>
												<c:when test="${fn:length(user.roles ) == 0 }">
													<option value="1">admin</option>
													<option value="2">user</option>
												</c:when>
												<c:when test="${fn:length(user.roles ) == 1 }">
													<c:forEach items="${user.roles }" var="r">
														<c:choose>
															<c:when test="${r.id == 1 }">
																<option value="1" selected="selected">admin</option>
																<option value="2">user</option>
															</c:when>
															<c:when test="${r.id == 2 }">
																<option value="1">admin</option>
																<option value="2" selected="selected">user</option>
															</c:when>
														</c:choose>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<option value="1" selected="selected">admin</option>
													<option value="2" selected="selected">user</option>
												</c:otherwise>
											</c:choose>
										</select>
									</div>
								</div>
								
								<hr />
                                <div class="form-group">
                                  <div class="col-lg-offset-2 col-lg-6">
                                    <input type="submit" class="btn btn-primary" value="修改">
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
	
<script type="text/javascript">
	$(function(){
		var ue = UE.getEditor('editor');
		$("#editor").show();
	});
</script>

</body>
</html>