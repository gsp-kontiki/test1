<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分享</title>
</head>
<body>

<!-- <div class="-mob-share-ui-button -mob-share-open">分享</div> -->
<!-- <div class="-mob-share-ui" style="display: none"> -->
<!--     <ul class="-mob-share-list"> -->
<!--      	<li class="-mob-share-weixin"><p>微信</p></li> -->
<!--         <li class="-mob-share-weibo"><p>新浪微博</p></li> -->
<!--         <li class="-mob-share-tencentweibo"><p>腾讯微博</p></li> -->
<!--         <li class="-mob-share-qzone"><p>QQ空间</p></li> -->
<!--         <li class="-mob-share-qq"><p>QQ好友</p></li> -->
<!--         <li class="-mob-share-renren"><p>人人网</p></li> -->
<!--         <li class="-mob-share-kaixin"><p>开心网</p></li> -->
<!--         <li class="-mob-share-douban"><p>豆瓣</p></li> -->
<!--         <li class="-mob-share-facebook"><p>Facebook</p></li> -->
<!--         <li class="-mob-share-twitter"><p>Twitter</p></li> -->
<!--     </ul> -->
<!--     <div class="-mob-share-close">取消</div> -->
<!-- </div> -->
<!-- <div class="-mob-share-ui-bg"></div> -->
<!-- <script id="-mob-share" src="http://f1.webshare.mob.com/code/mob-share.js?appkey=17dbae3fb22b8"></script> -->

<div class="-mob-share-open">分享</div>
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
    	alert(params);
    }

} );

</script>

</body>
</html>