<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<!-- Title and other stuffs -->
<title> <sitemesh:write property='title' />-Android程序设计教学网站后台管理</title>
<meta name="keywords"
	content="" />
<meta name="description"
	content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="">
<!-- Stylesheets -->
<link href="${ctx}/static/style/bootstrap.css" rel="stylesheet">
<!-- Font awesome icon -->
<link rel="stylesheet" href="${ctx}/static/style/font-awesome.css">
<!-- jQuery UI -->
<link rel="stylesheet" href="${ctx}/static/style/jquery-ui.css">
<!-- Calendar -->
<link rel="stylesheet" href="${ctx}/static/style/fullcalendar.css">
<!-- prettyPhoto -->
<link rel="stylesheet" href="${ctx}/static/style/prettyPhoto.css">
<!-- Star rating -->
<link rel="stylesheet" href="${ctx}/static/style/rateit.css">
<!-- Date picker -->
<link rel="stylesheet"
	href="${ctx}/static/style/bootstrap-datetimepicker.min.css">
<!-- CLEditor -->
<link rel="stylesheet" href="${ctx}/static/style/jquery.cleditor.css">
<!-- Uniform -->
<link rel="stylesheet" href="${ctx}/static/style/uniform.default.css">
<!-- Bootstrap toggle -->
<link rel="stylesheet" href="${ctx}/static/style/bootstrap-switch.css">
<link rel="stylesheet" href="${ctx}/static/style/ui.fancytree.css">
<!-- Main stylesheet -->
<link href="${ctx}/static/style/style.css" rel="stylesheet">
<!-- Widgets stylesheet -->
<link href="${ctx}/static/style/widgets.css" rel="stylesheet">
<!-- JS -->
<script src="${ctx}/static/js/jquery.js"></script> <!-- jQuery -->
<script src="${ctx}/static/js/bootstrap.js"></script> <!-- Bootstrap -->
<script src="${ctx}/static/js/jquery-ui-1.9.2.custom.min.js"></script> <!-- jQuery UI -->
<script src="${ctx}/static/js/fullcalendar.min.js"></script> <!-- Full Google Calendar - Calendar -->
<script src="${ctx}/static/js/jquery.rateit.min.js"></script> <!-- RateIt - Star rating -->
<script src="${ctx}/static/js/jquery.prettyPhoto.js"></script> <!-- prettyPhoto -->

<!-- jQuery Flot -->
<script src="${ctx}/static/js/excanvas.min.js"></script>
<script src="${ctx}/static/js/jquery.flot.js"></script>
<script src="${ctx}/static/js/jquery.flot.resize.js"></script>
<script src="${ctx}/static/js/jquery.flot.pie.js"></script>
<script src="${ctx}/static/js/jquery.flot.stack.js"></script>

<!-- jQuery Notification - Noty -->
<script src="${ctx}/static/js/jquery.noty.js"></script> <!-- jQuery Notify -->
<script src="${ctx}/static/js/themes/default.js"></script> <!-- jQuery Notify -->
<script src="${ctx}/static/js/layouts/bottom.js"></script> <!-- jQuery Notify -->
<script src="${ctx}/static/js/layouts/topRight.js"></script> <!-- jQuery Notify -->
<script src="${ctx}/static/js/layouts/top.js"></script> <!-- jQuery Notify -->
<!-- jQuery Notification ends -->

<script src="${ctx}/static/js/sparklines.js"></script> <!-- Sparklines -->
<script src="${ctx}/static/js/jquery.cleditor.min.js"></script> <!-- CLEditor -->
<script src="${ctx}/static/js/bootstrap-datetimepicker.min.js"></script> <!-- Date picker -->
<script src="${ctx}/static/js/jquery.uniform.min.js"></script> <!-- jQuery Uniform -->
<script src="${ctx}/static/js/bootstrap-switch.min.js"></script> <!-- Bootstrap Toggle -->
<script src="${ctx}/static/js/filter.js"></script> <!-- Filter for support page -->
<script src="${ctx}/static/js/custom.js"></script> <!-- Custom codes -->
<script src="${ctx}/static/js/charts.js"></script> <!-- Charts & Graphs -->

<!-- HTML5 Support for IE -->
<!--[if lt IE 9]>
  <script src="js/html5shim.js"></script>
  <![endif]-->
<script>
$(function() {

	//得到当前请求的url地址
	var uri = window.location.href;
	
	//alert(uri);

	//获得具体的请求
	var request = uri.substr(uri.lastIndexOf('/') + 1);
	
	$('#nav a').each(function(i) {
		var ss = $(this).attr('href');
		ss = ss.substr(ss.lastIndexOf('/') + 1)
		//alert(ss);
		//alert(request);
		if (ss == request) {
			//alert();
			$(this).addClass('open');
			var $hasSub = $(this).parent().parent().parent();
			
			//alert($hasSub);
			if($hasSub.hasClass("has_sub")){
				
				//alert();
				$hasSub.children("a:first").addClass("subdrop");
				$(this).css("background","#eee")
				//style="display: block;"
				$hasSub.children("ul").show();
			}
		}
	});
	 

});
</script>


 <sitemesh:write property='head' />
</head>

<body>
	<%@ include file="/WEB-INF/views/admin/layouts/header.jsp"%>
	<!-- Main content starts -->

	<div class="content">
		<!-- Sidebar -->
		<div class="sidebar">
			<div class="sidebar-dropdown">
				<a href="#">导航</a>
			</div>

			<!--- Sidebar navigation -->
			<!-- If the main navigation has sub navigation, then add the class "has_sub" to "li" of main navigation. -->
			<ul id="nav">
				<!-- Main menu with font awesome icon -->
				<li><a href="index.html" class="open"><i class="icon-home"></i>
						首页</a>
				</li>
				<li class="has_sub"><a href="#"><i class="icon-list-alt"></i>
						新闻与公告管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul>
						<li><a href="${ctx }/admin/addTeachNews">添加信息</a></li>
						<li><a href="${ctx }/admin/findTeachNews">查询所有</a></li>
					</ul></li>
				<li class="has_sub"><a href="#"><i class="icon-list-alt"></i>
						课程简介管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul>
						<li><a href="${ctx }/admin/addCourseIntro">添加信息</a></li>
						<li><a href="${ctx }/admin/findCourseIntros">查询所有</a></li>
					</ul></li>
				<li class="has_sub"><a href="#"><i class="icon-list-alt"></i>
						师资介绍管理 <span class="pull-right"><i
							class="icon-chevron-right"></i></span></a>
					<ul>
						<li><a href="${ctx }/admin/addTeacherIntro">添加信息</a></li>
						<li><a href="${ctx }/admin/findTeacherIntros">查询所有</a></li>
						<li><a href="${ctx }/admin/findTeacherIntroTypes">管理分类</a></li>
					</ul>
				</li>
				<li class="has_sub"><a href="#"><i class="icon-list-alt"></i>
						教学安排管理 <span class="pull-right"><i
							class="icon-chevron-right"></i></span></a>
					<ul>
						<li><a href="${ctx }/admin/addTeachArrange">添加信息</a></li>
						<li><a href="${ctx }/admin/findTeachArranges">查询所有</a></li>
						<li><a href="${ctx }/admin/findTeachArrangeTypes">管理分类</a></li>
					</ul>
				</li>
				<li class="has_sub"><a href="#"><i class="icon-list-alt"></i>
						实验安排管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul>
						<li><a href="${ctx }/admin/addExperimentArrange">添加信息</a></li>
						<li><a href="${ctx }/admin/findExperimentArranges">查询所有</a></li>
					</ul>
				</li>
				<li class="has_sub"><a href="#"><i class="icon-list-alt"></i>
						优秀学生管理 <span class="pull-right"><i
							class="icon-chevron-right"></i></span></a>
					<ul>
						<li><a href="${ctx }/admin/addOutstandStudent">添加信息</a></li>
						<li><a href="${ctx }/admin/findOutstandStudents">查询所有</a></li>
						<li><a href="${ctx }/admin/findOutstandStudentTypes">管理分类</a></li>
					</ul>
				</li>
				<li class="has_sub"><a href="#"><i class="icon-list-alt"></i>
						资源下载管理 <span class="pull-right"><i
							class="icon-chevron-right"></i></span></a>
					<ul>
						<li><a href="${ctx }/admin/addDownloadResource">添加信息</a></li>
						<li><a href="${ctx }/admin/findDownloadResources">查询所有</a></li>
						<li><a href="${ctx }/admin/findDownloadResourceTypes">管理分类</a></li>
					</ul>
				</li>
				<li><a href="${ctx }/admin/findMessages"><i class="icon-bar-chart"></i>留言管理</a></li> 
				<li class="has_sub"><a href="#"><i class="icon-file-alt"></i>
						系统菜单 <span class="pull-right"><i
							class="icon-chevron-right"></i></span></a>
					<ul>
						<li><a href="${ctx }/admin/findAdvs">广告轮播</a></li>
						<li><a href="${ctx }/admin/findLoginLogs">登录日志</a></li>
						<li><a href="${ctx }/admin/findUsers">用户管理</a></li>
						<li><a href="${ctx }/admin/modifyPassword">修改密码</a></li>
					</ul>
				</li>
			</ul>
		</div>

		<!-- Sidebar ends -->

		<!-- Main bar -->
		<div class="mainbar">


			<!-- Page heading -->
			<div class="page-head">
				<h2 class="pull-left">
					<i class="icon-home"></i> 首页
				</h2>

				<!-- Breadcrumb -->
				<div class="bread-crumb pull-right">
					<a href="index.html"><i class="icon-home"></i> 首页</a>
					<!-- Divider -->
					<span class="divider">/</span> <a href="#" class="bread-current">控制台</a>
				</div>

				<div class="clearfix"></div>

			</div>
			<!-- Page heading ends -->

			<sitemesh:write property='body' />
		</div>

		<!-- Mainbar ends -->
		<div class="clearfix"></div>
	</div>
	<!-- Content ends -->
	<%@ include file="/WEB-INF/views/admin/layouts/footer.jsp"%>
</body>
</html>