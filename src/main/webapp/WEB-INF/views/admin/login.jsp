<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <!-- Title and other stuffs -->
  <title>后台登陆页面</title> 
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="author" content="">
  <!-- Stylesheets -->
  <link href="${ctx}/static/style/bootstrap.css" rel="stylesheet">
  <link rel="stylesheet" href="${ctx}/static/style/font-awesome.css">
  <link href="${ctx}/static/style/style.css" rel="stylesheet">
  <link href="${ctx}/static/style/bootstrap-responsive.css" rel="stylesheet">
  
  <!-- HTML5 Support for IE -->
  <!--[if lt IE 9]>
  <script src="${ctx}/static/js/html5shim.js"></script>
  <![endif]--> 
</head>

<body>
<shiro:user>
<script type="text/javascript">
	window.location.href="${ctx}/"
</script>
</shiro:user>
<!-- Form area -->
<div class="admin-form">
  <div class="container">
 
    <div class="row">
      <div class="col-md-12">
        <!-- Widget starts -->
            <div class="widget worange">
              <!-- Widget head -->
              <div class="widget-head">
                <i class="icon-lock"></i> 教学网站后台管理系统
              </div>

              <div class="widget-content">
                <div class="padd">
                  <!-- Login form -->
                  <form class="form-horizontal" action="${ctx}/admin/login" method="post" class="form-horizontal">
                    <!-- Email -->
                    <div style="color: red;text-align: center;margin-bottom: 15px;">
						 ${message }
					</div>
                    <div class="form-group">
                      <label class="control-label col-lg-3" for="inputEmail">用户名:</label>
                      <div class="col-lg-9">
                      	<input type="text" id="username" name=userName  value="${username}" class="form-control required"  placeholder="用户名"/>
                      </div>
                    </div>
                    <!-- Password -->
                    <div class="form-group">
                      <label class="control-label col-lg-3" for="inputPassword">密码:</label>
                      <div class="col-lg-9">
                        <input type="password" class="form-control required"     id="password" name="userPassword"   placeholder="密码">
                      </div>
                    </div>
                    
                     <div class="form-group">
                      <label class="control-label col-lg-3" for="inputEmail">验证码:</label>
                      <div class="col-lg-9">
                      	<input type="text" id="checkCode" name="checkCode" class="form-control required"/>
                      	<img style="cursor: pointer;" onclick="this.src='${ctx }/static/images/jcaptcha.jpg?t='+Math.random()" src="${ctx }/static/images/jcaptcha.jpg" />
                      	<a href="document.getElementById('checkCode').src='${ctx }/static/images/jcaptcha.jpg?t='+Math.random()'">看不清楚，换一张</a>
                      </div>
                    </div>
                        <div class="col-lg-9 col-lg-offset-2">
							<button type="submit" class="btn btn-danger">登录</button>
							<button type="reset" class="btn btn-default">重置</button>
						</div>
                    <br />
                  </form>
				  
				</div>
                </div>
              
                <div class="widget-foot">
                   
                </div>
            </div>  
      </div>
    </div>
  </div> 
</div>
	
		

<!-- JS -->
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/bootstrap.js"></script>
</body>
</html>