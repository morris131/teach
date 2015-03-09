<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<!-- Title and other stuffs -->
<title> <sitemesh:write property='title' /></title>
<meta name="keywords"
	content="Bootstrap模版,Bootstrap模版下载,Bootstrap教程,Bootstrap中文,后台管理系统模版,后台模版下载,后台管理系统,后台管理模版" />
<meta name="description"
	content="代码家园-www.daimajiayuan.com提供Bootstrap模版,后台管理系统模版,后台管理界面,Bootstrap教程,Bootstrap中文翻译等相关Bootstrap插件下载" />
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
<!-- Main stylesheet -->
<link href="${ctx}/static/style/style.css" rel="stylesheet">
<!-- Widgets stylesheet -->
<link href="${ctx}/static/style/widgets.css" rel="stylesheet">

<!-- HTML5 Support for IE -->
<!--[if lt IE 9]>
  <script src="js/html5shim.js"></script>
  <![endif]-->


 <sitemesh:write property='head' />
</head>

<body>
	<%@ include file="/WEB-INF/layouts/header.jsp"%>
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
						课程简介管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul>
						<li><a href="${ctx }/admin/addCourseIntro">添加信息</a></li>
						<li><a href="${ctx }/admin/findCourseIntros">查询所有</a></li>
					</ul></li>
				<li class="has_sub"><a href="#"><i class="icon-list-alt"></i>
						师资介绍管理 <span class="pull-right"><i
							class="icon-chevron-right"></i></span></a>
					<ul>
						<li><a href="${ctx }/admin/addCourseIntro">添加信息</a></li>
						<li><a href="${ctx }/admin/findCourseIntros">查询所有</a></li>
						<li><a href="${ctx }/admin/findTeacherIntroTypes">管理分类</a></li>
					</ul>
				</li>
				<li class="has_sub"><a href="#"><i class="icon-file-alt"></i>
						页面模块1 <span class="pull-right"><i
							class="icon-chevron-right"></i></span></a>
					<ul>
						<li><a href="post.html">表单Post</a></li>
						<li><a href="login.html">登录页</a></li>
						<li><a href="register.html">注册页面</a></li>
						<li><a href="support.html">帮助页</a></li>
						<li><a href="invoice.html">购物清单</a></li>
						<li><a href="profile.html">个人资料</a></li>
						<li><a href="gallery.html">相册页面</a></li>
					</ul></li>
				<li class="has_sub"><a href="#"><i class="icon-file-alt"></i>
						页面模块2 <span class="pull-right"><i
							class="icon-chevron-right"></i></span></a>
					<ul>
						<li><a href="media.html">媒体</a></li>
						<li><a href="statement.html">描述</a></li>
						<li><a href="error.html">错误</a></li>
						<li><a href="error-log.html">错误日志</a></li>
						<li><a href="calendar.html">日历</a></li>
						<li><a href="grid.html">网格</a></li>
					</ul></li>
				<li><a href="charts.html"><i class="icon-bar-chart"></i>图表</a></li>
				<li><a href="tables.html"><i class="icon-table"></i>表格</a></li>
				<li><a href="forms.html"><i class="icon-tasks"></i>表单</a></li>
				<li><a href="ui.html"><i class="icon-magic"></i>UI图标</a></li>
				<li><a href="calendar.html"><i class="icon-calendar"></i>日历</a></li>
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
	<%@ include file="/WEB-INF/layouts/footer.jsp"%>

	<script src="${ctx}/static/bootstrap/2.3.2/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>