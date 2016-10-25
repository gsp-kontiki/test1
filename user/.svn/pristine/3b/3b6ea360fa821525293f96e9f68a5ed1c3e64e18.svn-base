<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page session="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<link rel="icon" href="resources/images/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="resources/images/favicon.ico"
	type="image/x-icon" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="renderer" content="webkit" />
<title>猎鹰浏览器后台管理系统</title>

<link href="resources/css/index.css" rel="stylesheet" />
<link href="resources/css/themes/bootstrap/easyui.css" rel="stylesheet" />
<link href="resources/css/themes/icon.css" rel="stylesheet" />
<link href="resources/css/demo.css" rel="stylesheet" />


<link href="resources/css/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/css/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">
<link href="resources/css/dist/css/sb-admin-2.css" rel="stylesheet">
<link href="resources/css/vendor/morrisjs/morris.css" rel="stylesheet">
<link href="resources/css/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
	
<script src="resources/script/jquery.min.js"></script>

<script src="resources/css/vendor/jquery/jquery.min.js"></script>
<script src="resources/script/jquery.easyui.min.js"></script>
<script src="resources/css/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/css/vendor/metisMenu/metisMenu.min.js"></script>
<script src="resources/css/vendor/raphael/raphael.min.js"></script>
<script src="resources/css/dist/js/sb-admin-2.js"></script>
</head>
<body>
	<div id="wrapper" style="height:100%;width:100%;min-height:800px;">
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index"> 猎鹰浏览器后台管理系统</a>
			</div>
			<ul class="nav navbar-top-links navbar-right">
				<li>
					欢迎！<shiro:principal/>
				</li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<c:url var="logoutUrl" value="/logout" />
						<li><a href="${logoutUrl}" ><i class="fa fa-sign-out fa-fw"></i>注销</a></li>
						<li><a href="javascript:;" url="toChangPasswordPage" class="btn_menu"><i class="fa fa-gear fa-fw"></i>修改密码</a>
					</ul></li>
			</ul>
			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>安卓客户端<span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<shiro:hasPermission name="banner:manage">
   								 	<li><a href="javascript:;" url="android/bannerList?clientType=0" class="btn_menu">BANNER</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="searchEngine:manage">
   								 	<li><a href="javascript:;" url="searchEngine/searchEngineList?clientType=0" class="btn_menu">搜索引擎</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="startPageAD:manage">
   								 	<li><a href="javascript:;" url="android/startPageAdList?clientType=0" class="btn_menu">启动页广告</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="hotSite:manage">
   								 	<li><a href="javascript:;" url="android/businessSiteList?clientType=0&type=1" class="btn_menu">热门站点</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="recommendSite:manage">
   								 	<li><a href="javascript:;" url="android/businessSiteList?clientType=0&type=2" class="btn_menu">推荐网址</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="androidAppUpgrade:manage">
   								 	<li><a href="javascript:;" url="android/appUpgradeRecordList" class="btn_menu">自升级</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="apiVersion:manage">
   								 	<li><a href="javascript:;" url="apiDataVersion/apiDataVersionList?clientType=0" class="btn_menu">接口数据版本</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="appVersion:manage">
   								 	<li><a href="javascript:;" url="appVersion/appVersionList?clientType=0" class="btn_menu">Android 版本</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="screenBookMark:manage">
   								 	<li><a href="javascript:;" url="screenBookMark/screenBookMarkList?clientType=0" class="btn_menu">右屏书签</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="netFlowSwitch:manage">
   								 	<li><a href="javascript:;" url="switch/switchList?clientType=0" class="btn_menu">省流量开关</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="messagePush:manage">
   								 	<li><a href="javascript:;" url="push/pushList" class="btn_menu">消息推送</a></li>
								</shiro:hasPermission>
							</ul>
						</li>
						<li><a href="#"><i class="fa fa-mobile fa-fw"></i>IOS客户端<span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<shiro:hasPermission name="banner:manage">
   								 	<li><a href="javascript:;" url="android/bannerList?clientType=2" class="btn_menu">BANNER_IOS</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="searchEngine:manage">
   								 	<li><a href="javascript:;" url="searchEngine/searchEngineList?clientType=2" class="btn_menu">搜索引擎_IOS</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="startPageAD:manage">
   								 	<li><a href="javascript:;" url="android/startPageAdList?clientType=2" class="btn_menu">启动页广告_IOS</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="hotSite:manage">
   								 	<li><a href="javascript:;" url="android/businessSiteList?clientType=2&type=1" class="btn_menu">热门站点_IOS</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="recommendSite:manage">
   								 	<li><a href="javascript:;" url="android/businessSiteList?clientType=2&type=2" class="btn_menu">推荐网址_IOS</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="apiVersion:manage">
   								 	<li><a href="javascript:;" url="apiDataVersion/apiDataVersionList?clientType=2" class="btn_menu">接口数据版本_IOS</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="appVersion:manage">
   								 	<li><a href="javascript:;" url="appVersion/appVersionList?clientType=2" class="btn_menu">IOS 版本</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="screenBookMark:manage">
   								 	<li><a href="javascript:;" url="screenBookMark/screenBookMarkList?clientType=2" class="btn_menu">右屏书签_IOS</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="netFlowSwitch:manage">
   								 	<li><a href="javascript:;" url="switch/switchList?clientType=2" class="btn_menu">省流量开关_IOS</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="messagePush:manage">
   								 	<li><a href="javascript:;" url="push/pushIOSList" class="btn_menu">消息推送_IOS</a></li>
								</shiro:hasPermission>
							</ul>
						</li>
						<li><a href="#"><i class="fa fa-dashboard fa-fw"></i>导航网站<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<shiro:hasPermission name="banner:manage">
   								 	<li><a href="javascript:;" url="android/bannerList?clientType=1" class="btn_menu">BANNER_H5</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="searchEngine:manage">
   								 	<li><a href="javascript:;" url="searchEngine/searchEngineList?clientType=1" class="btn_menu">搜索引擎_H5</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="hotSite:manage">
   								 	<li><a href="javascript:;" url="android/businessSiteList?clientType=1&type=1" class="btn_menu">热门站点_H5</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="categorySite:manage">
   								 	<li><a href="javascript:;" url="#"><i class="fa fa-sitemap fa-fw"></i>分类网址<span class="fa arrow"></span></a>
										<ul class="nav nav-third-level">
											<li><a href="javascript:;" url="firstCategory/firstCategoryList" class="btn_menu">一级分类</a></li>
											<li><a href="javascript:;" url="secondCategory/secondCategoryList" class="btn_menu">二级分类</a></li>
											<li><a href="javascript:;" url="thirdCategory/thirdCategoryList" class="btn_menu">三级分类</a></li>
										</ul>
									</li>
								</shiro:hasPermission>
								<shiro:hasPermission name="shortVideo:manage">
									<li><a href="javascript:;" url="shortVideo/shortVideoList" class="btn_menu">短视频</a></li>
								</shiro:hasPermission>
							</ul></li>
						<li><a href="#"><i class="fa fa-wrench fa-fw"></i>公共管理<span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<shiro:hasPermission name="hotWord:manage">
   								 	<li><a href="javascript:;" url="hotWord/hotWordList" class="btn_menu">热词</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="associateWord:manage">
   								 	<li><a href="javascript:;" url="associateWord/associateWordList" class="btn_menu">关键词联想</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="channel:manage">
   								 	<li><a href="javascript:;" url="channel/channelList" class="btn_menu">渠道</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="newsChannel:manage">
   								 	<li><a href="javascript:;" url="newsChannel/appNewsChannelList" class="btn_menu">资讯频道</a></li>
								</shiro:hasPermission>
							</ul>
						</li>
							<shiro:hasRole name="SUPER_ADMIN">
								<li><a href="#"><i class="fa fa-user fa-fw"></i>用户管理<span
									class="fa arrow"></span></a>
									<ul class="nav nav-second-level">
										<shiro:hasPermission name="user:manage">
		   								 	<li><a href="javascript:;" url="user/userList" class="btn_menu">用户管理</a></li>
										</shiro:hasPermission>
										<shiro:hasPermission name="role:manage">
		   								 	<li><a href="javascript:;" url="role/roleList" class="btn_menu">角色管理</a></li>
										</shiro:hasPermission>
										<shiro:hasPermission name="permission:manage">
		   								 	<li><a href="javascript:;" url="resource/resourceList" class="btn_menu">权限管理</a></li>
										</shiro:hasPermission>
									</ul>
								</li>
							</shiro:hasRole>
					</ul>
				</div>
			</div>
		</nav>

		<div id="page-wrapper" style="height:100%;min-height:950px;">
			<div class="easyui-tabs" fit="true" id="container" style="height:100%;min-height:950px;">
				<div title="主页">欢迎使用猎鹰浏览器后台管理系统</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
	 $(function () {
         bindEvent();
     });
     function bindEvent() {
         $(".btn_menu").click(function () {
             var title = $(this).text();
             var url = $(this).attr("url");
             var isSelect = $("#container").tabs('exists', title);
             if (isSelect) {
                 $("#container").tabs('select', title);
                 return;
             }
             $("#container").tabs('add', {
                 title: title,
                 content: CreateContent(url),
                 closable: true
             });
         });
     }

     function CreateContent(url) {
         var strHtml = '<iframe src="' + url + '" scrolling="auto" frameborder="0" fit="true" style="height:100%;width:100%;min-height:700px;"></iframe>';
         return strHtml;
     }
	</script>
</body>

</html>
