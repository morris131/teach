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
						<div class="pull-left">所有师资信息</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">

						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>教师名</th>
									<th>基本介绍</th>
									<th>发布时间</th>
									<th>点击次数</th>
									<th colspan="2">操作</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach items="${teacherIntros }" var="teacherIntro">
									<tr>
										<td>${teacherIntro.teacherId }</td>
										<td>${teacherIntro.teacherTitle }</td>
										<td>${teacherIntro.teacherContent }</td>
										<td>${teacherIntro.teacherDate }</td>
										<td>${teacherIntro.teacherCount }</td>
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