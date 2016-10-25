

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link href="resources/css/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet"></link>
<link href="resources/css/login.css" rel="stylesheet"></link>
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet"></link>
</head>

<body>
	<!-- 		<div id="mainWrapper"> -->
	<!-- 			<div class="login-container"> -->
	<!-- 				<div class="login-card"> -->
	<%-- 					<div style="font-size:18;font-weight:bold;text-align:center; margin-top:10px;"><spring:message code="login_page_qdbrowser_management_login"/> </div> --%>
	<!-- 					<div class="login-form"> -->
	<%-- 						<c:url var="loginUrl" value="/login" /> --%>
	<%-- 						<form:form action="${loginUrl}" method="post" cssClass="form-horizontal"> --%>
	<%-- 							<c:if test="${error != null}"> --%>
	<!-- 								<div class="alert alert-danger"> -->
	<%-- 								${error} --%>
	<%-- <%-- 									<p><spring:message code="login_page_wrong_username_or_password"></spring:message></p> --%>
	--%>
	<!-- 								</div> -->
	<%-- 							</c:if> --%>
	<%-- 							<c:if test="${logout != null}"> --%>
	<!-- 								<div class="alert alert-success"> -->
	<%-- 									<p><spring:message code="login_page_login_out_success"></spring:message></p> --%>
	<!-- 								</div> -->
	<%-- 							</c:if> --%>
	<!-- 							<div class="input-group input-sm"> -->
	<!-- 								<label class="input-group-addon" for="username"><i class="fa fa-user"></i></label> -->
	<%-- 								<input type="text" class="form-control" id="username" name="username" placeholder="<spring:message code='login_page_ipput_user_name'/>" required> --%>
	<!-- 							</div> -->
	<!-- 							<div class="input-group input-sm"> -->
	<!-- 								<label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>  -->
	<%-- 								<input type="password" class="form-control" id="password" name="password" placeholder="<spring:message code='login_page_input_password'/>" required> --%>
	<!-- 							</div> -->
	<!-- 							<div class="input-group input-sm"> -->
	<!-- 								<div class="checkbox"> -->
	<%--                                  <label><input type="checkbox" name="rememberMe" value="true"> <spring:message code="login_page_remember-me"/></label>   --%>
	<!--                                 </div> -->
	<!-- 							 </div> -->

	<!-- 							<div class="form-actions"> -->
	<!-- 								<input type="submit" -->
	<%-- 									class="btn btn-block btn-primary btn-default" value="<spring:message code="login_page_login"/>"> --%>
	<!-- 							</div> -->
	<%-- 						</form:form> --%>
	<!-- 					</div> -->
	<!-- 				</div> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
<!-- 	<div class="-mob-share-ui-button -mob-share-open">分享</div> -->
<!-- 	<div class="-mob-share-ui" style="display: none"> -->
<!-- 		<ul class="-mob-share-list"> -->
<!-- 			<li class="-mob-share-weixin"><p>微信</p></li> -->
<!-- 			<li class="-mob-share-weibo"><p>新浪微博</p></li> -->
<!-- 			<li class="-mob-share-tencentweibo"><p>腾讯微博</p></li> -->
<!-- 			<li class="-mob-share-qzone"><p>QQ空间</p></li> -->
<!-- 			<li class="-mob-share-qq"><p>QQ好友</p></li> -->
<!-- 			<li class="-mob-share-renren"><p>人人网</p></li> -->
<!-- 			<li class="-mob-share-kaixin"><p>开心网</p></li> -->
<!-- 			<li class="-mob-share-douban"><p>豆瓣</p></li> -->
<!-- 			<li class="-mob-share-facebook"><p>Facebook</p></li> -->
<!-- 			<li class="-mob-share-twitter"><p>Twitter</p></li> -->
<!-- 		</ul> -->
<!-- 		<div class="-mob-share-close">取消</div> -->
<!-- 	</div> -->
<!-- 	<div class="-mob-share-ui-bg"></div> -->
<!-- 	<script id="-mob-share" src="http://f1.webshare.mob.com/code/mob-share.js?appkey=17dbae3fb22b8"></script> -->

<div class="-mob-share-ui-button -mob-share-open">分享</div>
<div class="-mob-share-ui" style="display: none">
    <ul class="-mob-share-list">
        <li class="-mob-share-qq"><p>QQ好友</p></li>
    </ul>
    <div class="-mob-share-close">取消</div>
</div>
<div class="-mob-share-ui-bg"></div>
<script id="-mob-share" src="http://f1.webshare.mob.com/code/mob-share.js?appkey=17dbae3fb22b8"></script>

<script>
mobShare.config( {

    debug: true, // 开启调试，将在浏览器的控制台输出调试信息

    appkey: '17dbae3fb22b8', // appkey

    params: {
        url: 'http://www.qdnav.cn/', // 分享链接
        title: '猎鹰导航', // 分享标题
        description: '猎鹰导航', // 分享内容
        pic: '', // 分享图片，使用逗号,隔开
        reason:'',//只应用与QZone与朋友网
    },

    /**
     * 分享时触发的回调函数
     * 分享是否成功，目前第三方平台并没有相关接口，因此无法知道分享结果
     * 所以此函数只会提供分享时的相关信息
     * 
     * @param {String} plat 平台名称
     * @param {Object} params 实际分享的参数 { url: 链接, title: 标题, description: 内容, pic: 图片连接 }
     */
    callback: function( plat, params ) {
    	alert("url"+params.url+"\n"+
    			"pic"+params.pic);
    }

} );

</script>
</body>
</html>
