<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="generator" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="">
<title><sitemesh:write property='title' />-Android程序设计教学网站</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="favicon.ico" rel="shortcut icon" />
<link rel="stylesheet" type="text/css"
	href="${ctx }/static/css/initi.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx }/static/css/index.css" />
<!-- 下面滚动图插件开始 -->
<link rel="stylesheet" type="text/css"
	href="${ctx }/static/css/plus1.css" />
<!-- 下面滚动图插件结束 -->
<!-- 焦点图插件开始 -->
<link type="text/css" href="${ctx }/static/css/style.css"
	rel="stylesheet" />
<!-- 焦点图插件结束 -->
<script type="text/javascript" src="${ctx }/static/js/jquery.js"></script>
<!-- 焦点图插件开始 -->
<script type="text/javascript"
	src="${ctx }/static/js/jquery.event.drag-1.5.min.js"></script>
<script type="text/javascript"
	src="${ctx }/static/js/jquery.touchSlider.js"></script>
<!-- 焦点图插件结束 -->
<script type="text/javascript">
	$(function() {
		//焦点图插件代码开始
		$(".main_visual").hover(function() {
			$("#btn_prev,#btn_next").fadeIn()
		}, function() {
			$("#btn_prev,#btn_next").fadeOut()
		});
		$dragBln = false;
		$(".main_image").touchSlider(
				{
					flexible : true,
					speed : 200,
					btn_prev : $("#btn_prev"),
					btn_next : $("#btn_next"),
					paging : $(".flicking_con a"),
					counter : function(e) {
						$(".flicking_con a").removeClass("on")
								.eq(e.current - 1).addClass("on");
					}
				});
		$(".main_image").bind("mousedown", function() {
			$dragBln = false;
		});

		$(".main_image").bind("dragstart", function() {
			$dragBln = true;
		});

		$(".main_image a").click(function() {
			if ($dragBln) {
				return false;
			}
		});
		timer = setInterval(function() {
			$("#btn_next").click();
		}, 5000);
		$(".main_visual").hover(function() {
			clearInterval(timer);
		}, function() {
			timer = setInterval(function() {
				$("#btn_next").click();
			}, 5000);
		});

		$(".main_image").bind("touchstart", function() {
			clearInterval(timer);
		}).bind("touchend", function() {
			timer = setInterval(function() {
				$("#btn_next").click();
			}, 5000);
		});
		//焦点图插件代码结束

		//topbar 单击样式
		$(".topbar li a").click(function() {
			$(this).css("color", "#0153a5");
			$(this).parent().siblings().find("a").css("color", "#666");
		});

		//鼠标经过列表样式
		$(".left_ul li").hover(function() {
			$(this).addClass("li_click_b");
		}, function() {
			$(this).removeClass("li_click_b");
		});

		$li1 = $(".apply_nav .apply_array");
		$window1 = $(".apply .apply_w");
		$left1 = $(".apply .img_l");
		$right1 = $(".apply .img_r");
		$window1.css("width", $li1.length * 176);
		var lc1 = 0;
		var rc1 = $li1.length - 5;
		$left1.click(function() {
			if (lc1 < 1) {

				return;
			}
			lc1--;
			rc1++;
			$window1.animate({
				left : '+=176px'
			}, 1000);
		});
		$right1.click(function() {
			if (rc1 < 1) {

				return;
			}
			lc1++;
			rc1--;
			$window1.animate({
				left : '-=176px'
			}, 1000);
		});

	});
</script>
</head>

<!-- HTML5 Support for IE -->
<!--[if lt IE 9]>
  <script src="${ctx}/static/js/html5shim.js"></script>
  <![endif]-->


<sitemesh:write property='head' />
</head>

<body>
	<div class="main">
		<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
		<sitemesh:write property='body' />
	</div>

	<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>
</body>
</html>