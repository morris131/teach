<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>所有留言信息</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8">

				<!-- Widget -->
				<div class="widget">
					<!-- Widget head -->
					<div class="widget-head">
						<div class="pull-left">所有留言信息</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">

						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>标题</th>
									<th>审核状态</th>
									<th>状态</th>
									<th>留言时间</th>
									<th>操作</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach items="${page.content }" var="message">
									<tr>
										<td>${message.id }</td>
										<td>${message.title }</td>
										<td>
											<c:choose>
												<c:when test="${message.isValid == 1 }">审核通过</c:when>
												<c:when test="${message.isValid == 0 }">未审核</c:when>
												<c:otherwise>审核未通过</c:otherwise>
											</c:choose>
										</td>
										<td>
											<c:choose>
												<c:when test="${not empty message.reply }">已回复</c:when>
												<c:otherwise>未回复</c:otherwise>
											</c:choose>
										</td>
										<td>${message.datetime }</td>
										<td>
											<a href="${ctx }/admin/updateMessage?id=${message.id }" class="btn btn-sm btn-warning">
												<i class="icon-pencil"></i>修改
											</a>
											<a href="${ctx }/admin/deleteMessage?id=${message.id }" class="btn btn-sm btn-danger">
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
										 <li><a href="${ctx }/admin/findMessages?pageNumber=${pageNumber-1 }">Prev</a></li>
									</c:otherwise>
								</c:choose>	
								<c:forEach begin="1" end="${page.totalPages }" step="1" var="p">
									<c:choose>
										<c:when test="${p == pageNumber }">
											 <li class="active"><a href="javascript:void(0)">${p }</a></li>
										</c:when>
										<c:otherwise>
											 <li><a href="${ctx }/admin/findMessages?pageNumber=${p }">${p }</a></li>
										</c:otherwise>
									</c:choose>	
								</c:forEach>
								<c:choose>
									<c:when test="${page.totalPages == pageNumber }">
										 <li class="disabled"><a href="javascript:void(0)">Next</a></li>
									</c:when>
									<c:otherwise>
										 <li><a href="${ctx }/admin/findMessages?pageNumber=${pageNumber+1 }">Next</a></li>
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