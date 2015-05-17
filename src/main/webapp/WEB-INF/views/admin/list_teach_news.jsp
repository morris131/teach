<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有新闻与公告</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<!-- Widget -->
				<div class="widget">
					<!-- Widget head -->
					<div class="widget-head">
						<div class="pull-left">所有新闻与公告</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">

						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>标题</th>
									<th>类型</th>
									<th>来源</th>
									<th>点击次数</th>
									<th>发布时间</th>
									<th>操作</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${page.content }" var="teachNews">
									<tr>
										<td>${teachNews.id }</td>
										<td>${teachNews.title }</td>
										<td>
											<c:choose>
												<c:when test="${teachNews.type == 0 }">
													新闻
												</c:when>
												<c:otherwise>
													公告
												</c:otherwise>
											</c:choose>
										</td>
										<td>
											${teachNews.resourceSrc.name }
										</td>
										<td>${teachNews.count }</td>
										<td><fmt:formatDate value="${teachNews.datetime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td><a
											href="${ctx }/admin/updateTeachNews?id=${teachNews.id }"
											class="btn btn-sm btn-warning"> <i class="icon-pencil"></i>修改
										</a> <a
											href="${ctx }/admin/deleteTeachNews?id=${teachNews.id }"
											class="btn btn-sm btn-danger"> <i class="icon-remove"></i>删除
										</a></td>
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
										 <li><a href="${ctx }/admin/findTeachNews?pageNumber=${pageNumber-1 }">Prev</a></li>
									</c:otherwise>
								</c:choose>	
								<c:forEach begin="1" end="${page.totalPages }" step="1" var="p">
									<c:choose>
										<c:when test="${p == pageNumber }">
											 <li class="active"><a href="javascript:void(0)">${p }</a></li>
										</c:when>
										<c:otherwise>
											 <li><a href="${ctx }/admin/findTeachNews?pageNumber=${p }">${p }</a></li>
										</c:otherwise>
									</c:choose>	
								</c:forEach>
								<c:choose>
									<c:when test="${page.totalPages == pageNumber }">
										 <li class="disabled"><a href="javascript:void(0)">Next</a></li>
									</c:when>
									<c:otherwise>
										 <li><a href="${ctx }/admin/findTeachNews?pageNumber=${pageNumber+1 }">Next</a></li>
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