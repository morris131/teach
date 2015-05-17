<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>所有优秀学生分类</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<!-- Widget -->
				<div class="widget">
					<!-- Widget head -->
					<div class="widget-head">
						<div class="pull-left">所有优秀学生分类</div>
						<div class="clearfix"></div>
					</div>

					<!-- Widget content -->
					<div class="widget-content">

						<div class="well">
							<form role="form" action="${ctx }/admin/saveOutstandStudentType" class="form-inline">
								<div class="input-group" style="width: 300px">
									<span class="input-group-addon">类型名</span> <input name="name" type="text"
										class="form-control" placeholder="请输入类型名"> <span
										class="input-group-btn">
										<button class="btn btn-primary"> <span class="glyphicon glyphicon-ok"></span> 添加分类</button>
									</span>
								</div>
							</form>
						</div>
						
						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>类型名</th>
									<th>数量</th>
									<th>操作</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${page.content }" var="outstandStudentType">
									<tr>
										<td>${outstandStudentType.id }</td>
										<td>${outstandStudentType.name }</td>
										<td>${fn:length(outstandStudentType.outstandStudents) }</td>
										<td><button	class="btn btn-warning" onclick="modifyType(this)"><span class="glyphicon glyphicon-pencil"></span> 修改
											</button> 
											<a
												href="${ctx }/admin/deleteOutstandStudentType?id=${outstandStudentType.id }"
												class="btn btn-danger"> <i class="icon-remove"></i> 删除
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
										 <li><a href="${ctx }/admin/findOutstandStudentTypes?pageNumber=${pageNumber-1 }">Prev</a></li>
									</c:otherwise>
								</c:choose>	
								<c:forEach begin="1" end="${page.totalPages }" step="1" var="p">
									<c:choose>
										<c:when test="${p == pageNumber }">
											 <li class="active"><a href="javascript:void(0)">${p }</a></li>
										</c:when>
										<c:otherwise>
											 <li><a href="${ctx }/admin/findOutstandStudentTypes?pageNumber=${p }">${p }</a></li>
										</c:otherwise>
									</c:choose>	
								</c:forEach>
								<c:choose>
									<c:when test="${page.totalPages == pageNumber }">
										 <li class="disabled"><a href="javascript:void(0)">Next</a></li>
									</c:when>
									<c:otherwise>
										 <li><a href="${ctx }/admin/findOutstandStudentTypes?pageNumber=${pageNumber+1 }">Next</a></li>
									</c:otherwise>
								</c:choose>					 
		                     </ul>
	                     </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	
		var value;
		function cancelType(obj){
			$input = $(obj).parent().prev();
			$td = $input.parent().parent().parent();
			$td.empty().append(value);
		}
		
		function modifyType(obj){
			var $typeTd = $(obj).parent("td").prev().prev();
			value = $typeTd.html();
			var id = $typeTd.prev().html();
			var $input = $typeTd.find("input");
			
			if(0 == $input.size()){
				
				var ss = "<form action=\"${ctx }/admin/saveOutstandStudentType\"><div class=\"input-group\">"
						+ "<input type=\"hidden\" class=\"form-control\" name=\"id\" value=\""+id+"\">"
						+ "<input type=\"text\" class=\"form-control\" name=\"name\" value=\""+value+"\">"
						+ "<span class=\"input-group-btn\">"
						+ "<button class=\"btn btn-primary\"><span class=\"glyphicon glyphicon-ok\"></span> 保存</button>"
						+ "<a class=\"btn btn-danger\" onclick=\"cancelType(this)\"><span class=\"glyphicon glyphicon-remove\"></span> 取消</a></span></div></form>";
	
				$typeTd.empty().append(ss);
			}
		}
	</script>
	
</body>
</html>