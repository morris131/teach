<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>所有师资介绍</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<!-- Widget -->
				<div class="widget">
					<!-- Widget head -->
					<div class="widget-head">
						<div class="pull-left">所有师资介绍</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">

						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>教师名</th>
									<th>类型</th>
									<th>发布时间</th>
									<th>点击次数</th>
									<th>操作</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach items="${page.content }" var="teacherIntro">
									<tr>
										<td>${teacherIntro.id }</td>
										<td>${teacherIntro.title }</td>
										<td>${teacherIntro.teacherIntroType.name }</td>
										<td>
											<fmt:formatDate type="both" value="${teacherIntro.datetime }" pattern="yyyy-MM-dd HH:mm:ss"/>
											
										</td>
										<td>${teacherIntro.count }</td>
										<td>
											<a href="${ctx }/admin/updateTeacherIntro?id=${teacherIntro.id }" class="btn btn-sm btn-warning">
												<i class="icon-pencil"></i>修改
											</a>
											<a href="${ctx }/admin/deleteTeacherIntro?id=${teacherIntro.id }" class="btn btn-sm btn-danger">
												<i class="icon-remove"></i>删除
											</a>
										</td>
									</tr>
								</c:forEach>	
							</tbody>
							
						</table>
						
						<div class="pull-left">
							 <ul class="pagination">
								<c:choose>
									<c:when test="${1 == pageNumber }">
										 <li class="disabled"><a href="javascript:void(0)">Prev</a></li>
									</c:when>
									<c:otherwise>
										 <li><a href="${ctx }/admin/findTeacherIntros?pageNumber=${pageNumber-1 }">Prev</a></li>
									</c:otherwise>
								</c:choose>	
								<c:forEach begin="1" end="${page.totalPages }" step="1" var="p">
									<c:choose>
										<c:when test="${p == pageNumber }">
											 <li class="active"><a href="javascript:void(0)">${p }</a></li>
										</c:when>
										<c:otherwise>
											 <li><a href="${ctx }/admin/findTeacherIntros?pageNumber=${p }">${p }</a></li>
										</c:otherwise>
									</c:choose>	
								</c:forEach>
								<c:choose>
									<c:when test="${page.totalPages == pageNumber }">
										 <li class="disabled"><a href="javascript:void(0)">Next</a></li>
									</c:when>
									<c:otherwise>
										 <li><a href="${ctx }/admin/findTeacherIntros?pageNumber=${pageNumber+1 }">Next</a></li>
									</c:otherwise>
								</c:choose>					 
		                     </ul>
	                     </div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>