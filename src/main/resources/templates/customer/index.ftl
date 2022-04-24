<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--这个lang="zh-CN"是转化为html5的版本  -->
<html lang="zh-CN">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>学习bootstrap案例</title>
    <!-- 这个是自适应各种分辨率的屏幕 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet"  href="${ctx!}/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${ctx!}/assets/css/style.css"/>
    <script src="${ctx!}/assets/js/jquery.min.js"></script>
    <script src="${ctx!}/assets/js/bootstrap.min.js"></script>

</head>
<body>
<!-- 导航 -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <h1 class="nav-tabs"> 天空按摩店</h1>
        <ul class="nav navbar-nav">
            <li class="active"><a href="">天空按摩店</a></li>
            <li><a href="">首页</a></li>
            <li><a href="">关于</a></li>
            <li><a href="">登录</a></li>
        </ul>

    </div>
</nav>
<!--轮播图  -->
<!-- 最主要的是三部分indicators(指标)、inner(内容)、carousel-control（导航） -->
<div class="carousel slide" id="lf" data-ride="carousel">
    <ol class="carousel-indicators">
        <!-- •data-target 属性：
        取值 lf 定义的 ID 名或者其他样式识别符，
        并且将其定义在轮播图计数器的每个 li 上。
        data-slide-to 属性：
        用来传递某个帧的下标，比如 data-slide-to="2"，
        可以直接跳转到这个指定的帧（下标从0开始计），
        同样定义在轮播图计数器的每个 li 上。 -->
        <li data-target="#lf" data-slide-to="0" class="active"></li>
        <li data-target="#lf" data-slide-to="1"></li>
        <li data-target="#lf" data-slide-to="2"></li>
        <li data-target="#lf" data-slide-to="3"></li>
    </ol>
    <div class="carousel-inner" role="listbox" align="center" >
        <div class="item active">
            <img src="${ctx!}/assets/imgs/one.png" width="900" height="4500"/>
        </div>
        <div class="item">
            <img src="${ctx!}/assets/imgs/two.png" width="900" height="4500"/>
        </div>
        <div class="item">
            <img src="${ctx!}/assets/imgs/three.png" width="900" height="4500"/>
        </div>
        <div class="item">
            <img src="${ctx!}/assets/imgs/four.png" width="900" height="4500"/>
        </div>


        <a class="left carousel-control" href="#lf"  role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#lf"  role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
</body>