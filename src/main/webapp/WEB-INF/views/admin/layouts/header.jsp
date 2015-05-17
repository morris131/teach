<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<style>
	.logo-title {
		line-height: 50px;
		font-size: 20px;
		font-weight: bold;
	}
</style>
<div class="navbar navbar-fixed-top bs-docs-nav" role="banner">
  
    <div class="conjtainer">
     
      <!-- Navigation starts -->
      <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">         

       	<span class="logo-title">Android程序设计教学网站后台管理系统</span>
       	
      <a href="" style="padding-left: 770px;font-size: 14px;">网站首页</a>
       
        <!-- Links -->
        <ul class="nav navbar-nav pull-right">
          <li class="dropdown pull-right">            
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
              <i class="icon-user"></i> 管理员 <b class="caret"></b>              
            </a>
            
            <!-- Dropdown menu -->
            <ul class="dropdown-menu">
              <li><a href="${ctx}/admin/modifyPassword"><i class="icon-cogs"></i> 修改密码</a></li>
              <li><a href="${ctx}/admin/logout"><i class="icon-off"></i> 退出</a></li>
            </ul>
          </li>
          
        </ul>
      </nav>

    </div>
  </div>

<!-- header -->
