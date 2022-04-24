<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link href="${ctx!}/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${ctx!}/assets/css/animate.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/style.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/login.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">h</h1>

            </div>
            <h3>欢迎使用 天空按摩店线上预约系统</h3>

            <form class="m-t" action="${ctx!}/customer/login" method="post">

                    <input type="text" class="form-control" placeholder="用户名"  id="username" name="username">

                    <input type="password" class="form-control" placeholder="密码"  id="password" name="password">

                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


                <p class="text-muted text-center"> <a href="/customer/login"><small>忘记密码了？</small></a> | <a href="/customer/register">注册一个新账号</a>
                </p>

            </form>
        </div>
    </div>

    <!-- 全局js -->
    <script src="${ctx!}/assets/js/jquery.min.js?v=2.1.4"></script>
    <script src="${ctx!}/assets/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- jQuery Validation plugin javascript-->
    <script src="${ctx!}/assets/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="${ctx!}/assets/js/plugins/validate/messages_zh.min.js"></script>
    <script type="text/javascript">
        $().ready(function() {
            // 在键盘按下并释放及提交后验证提交表单
            $("#frm").validate({
                rules: {
                    username: {
                        required: true,
                        minlength: 2
                    },
                    password: {
                        required: true,
                        minlength: 5
                    }
                },
                messages: {
                    username: {
                        required: "请输入用户名",
                        minlength: "用户名必需由两个字母组成"
                    },
                    password: {
                        required: "请输入密码",
                        minlength: "密码长度不能小于 6 个字母"
                    }
                },
                submitHandler:function(form){
                    form.submit();
                }
            });
        });

    </script>
    

</body>

</html>
