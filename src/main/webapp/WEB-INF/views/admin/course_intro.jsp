<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						<div class="pull-left">所有课程信息</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">

						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>标题</th>
									<th>内容</th>
									<th colspan="2">操作</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach items="${courseIntros }" var="courseIntro">
									<tr>
										<td>${courseIntro.courseId }</td>
										<td>${courseIntro.courseTitle }</td>
										<td>${courseIntro.courseContent }</td>
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