<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<!-- Widget -->
				<div class="widget">
					<!-- Widget head -->
					<div class="widget-head">
						<div class="pull-left">所有教师分类信息</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">
						
						<div class="well">
							<form role="form" >
								<div class="form-group">
								 	<label for="teaTypeName" class="col-sm-2 control-label">名字</label>
									<input type="text" class="form-control" name="teaTypeName" >
								</div>
								<div class="form-group">
									<input type="submit" class="btn btn-primary" value="添加分类">
								</div>
							</form>
						</div>

						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>类型名</th>
									<th>教师数量</th>
									<th colspan="2">操作</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach items="${teacherIntroTypes }" var="teacherIntroType">
									<tr>
										<td>${teacherIntroType.teaTypeId }</td>
										<td>${teacherIntroType.teaTypeName }</td>
										<td>${fn:length(teacherIntroType.teacherIntros) }</td>
										<td>
											<a href="${ctx }/admin/updateCourseIntro?courseId=${courseIntro.courseId }" class="btn btn-xs btn-warning">
												<i class="icon-pencil"></i>修改
											</a>
											<a href="${ctx }/admin/deleteCourseIntro?courseId=${courseIntro.courseId }" class="btn btn-xs btn-danger">
												<i class="icon-remove"></i>删除
											</a>
										</td>
									</tr>
								</c:forEach>	
							</tbody>
							
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>