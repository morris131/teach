<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>所有登录信息</title>
</head>
<body>
<div class="container">
		<div class="row">
			<div class="col-md-12">

				<!-- Widget -->
				<div class="widget">
					<!-- Widget head -->
					<div class="widget-head">
						<div class="pull-left">所有登录信息</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">
						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>用户名</th>
									<th>IP地址</th>
									<th>浏览器</th>
									<th>登陆时间</th>
									<th>操作</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach items="${page.content }" var="loginLog">
									<tr>
										<td>${loginLog.id }</td>
										<td>${loginLog.name }</td>
										<td>${loginLog.ip }</td>
										<td>${loginLog.browser }</td>
										<td>${loginLog.datetime }</td>
										<td><a href="${ctx }/admin/deleteLoginLog?id=${loginLog.id }" class="btn btn-sm btn-danger"> <i class="icon-remove"></i> 删除</a></td>
									</tr>
								</c:forEach>	
							</tbody>
						</table>
						
						<!-- 分页 begin-->
						<div class="pull-left">
							 <ul class="pagination">
								<c:choose>
									<c:when test="${1 == pageNumber }">
										 <li class="disabled"><a href="javascript:void(0)">Prev</a></li>
									</c:when>
									<c:otherwise>
										 <li><a href="${ctx }/admin/findLoginLogs?pageNumber=${pageNumber-1 }">Prev</a></li>
									</c:otherwise>
								</c:choose>	
								<c:forEach begin="1" end="${page.totalPages }" step="1" var="p">
									<c:choose>
										<c:when test="${p == pageNumber }">
											 <li class="active"><a href="javascript:void(0)">${p }</a></li>
										</c:when>
										<c:otherwise>
											 <li><a href="${ctx }/admin/findLoginLogs?pageNumber=${p }">${p }</a></li>
										</c:otherwise>
									</c:choose>	
								</c:forEach>
								<c:choose>
									<c:when test="${page.totalPages == pageNumber }">
										 <li class="disabled"><a href="javascript:void(0)">Next</a></li>
									</c:when>
									<c:otherwise>
										 <li><a href="${ctx }/admin/findLoginLogs?pageNumber=${pageNumber+1 }">Next</a></li>
									</c:otherwise>
								</c:choose>					 
		                     </ul>
	                     </div>
						<!-- 分页 end-->	
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
