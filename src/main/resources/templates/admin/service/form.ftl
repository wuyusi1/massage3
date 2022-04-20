<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 表单验证 jQuery Validation</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${ctx!}/assets/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx!}/assets/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${ctx!}/assets/css/animate.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>服务信息</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="frm" method="post" action="${ctx!}/admin/service/edit">
                            <input type="hidden" id="id" name="id" value="${sservice.id}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">服务名称：</label>
                                <div class="col-sm-8">
                                    <input id="servicename" name="servicename" class="form-control" type="text" value="${sservice.servicename}" <#if user?exists> readonly="readonly"</#if> >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">服务简介：</label>
                                <div class="col-sm-8">
                                    <textarea id="serviceinfo" name="serviceinfo" class="form-control" value="${sservice.serviceinfo}">${sservice.serviceinfo}</textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">服务价格：</label>
                                <div class="col-sm-8">
                                    <input id="serviceprice" name="serviceprice" class="form-control" value="${sservice.serviceprice}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">服务功效：</label>
                                <div class="col-sm-8">
                                    <textarea id="servicefunc" name="servicefunc" class="form-control" value="${sservice.servicefunc}">${sservice.servicefunc}</textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">服务标签：</label>
                                <div class="col-sm-8">
                                    <input id="servicetag" name="servcietag" class="form-control" value="${sservice.servicetag}">
                                </div>
                            </div>
                            <input type="hidden" id="servicetag" name="servicetag" value="${sservice.servicetag}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">已售：</label>
                                <div class="col-sm-8">
                                    <input id="servicehavesaved" name="servicehavesaved" class="form-control" value="${sservice.servicehavesaved}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">状态：</label>
                                <div class="col-sm-8">
                                    <select name="servicedeletestatus" class="form-control">
                                        <option value="0" <#if sservice.servicedeletestatus == 0>selected="selected"</#if>>未删除</option>
                                        <option value="1" <#if sservice.servicedeletestatus == 1>selected="selected"</#if>>已删除</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-3">
                                    <button class="btn btn-primary" type="submit">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>


    <!-- 全局js -->
    <script src="${ctx!}/assets/js/jquery.min.js?v=2.1.4"></script>
    <script src="${ctx!}/assets/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="${ctx!}/assets/js/content.js?v=1.0.0"></script>

    <!-- jQuery Validation plugin javascript-->
    <script src="${ctx!}/assets/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="${ctx!}/assets/js/plugins/validate/messages_zh.min.js"></script>
    <script src="${ctx!}/assets/js/plugins/layer/layer.min.js"></script>
    <script src="${ctx!}/assets/js/plugins/layer/laydate/laydate.js"></script>
    <script type="text/javascript">
    $(document).ready(function () {
	    $("#frm").validate({
    	    rules: {
    	    	id: {
    	        required: false,
    	      },
    	      	serviceinfo: {
    	        required: true,
    	      },
    	      	serviceprice: {
    	        required: true
    	      },
                servicefunc: {
                    required: true
                },
                servicetag: {
                    required: true
                },
                servicedeletestatus: {
                    required: true
                }
    	    },
    	    messages: {},
    	    submitHandler:function(form){
    	    	$.ajax({
   	    		   type: "POST",
   	    		   dataType: "json",
   	    		   url: "${ctx!}/admin/service/edit",
   	    		   data: $(form).serialize(),
   	    		   success: function(msg){
	   	    			layer.msg(msg.message, {time: 2000},function(){
	   						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	   						parent.layer.close(index);
	   					});
   	    		   }
   	    		});
            }
    	});
    });
    </script>

</body>

</html>
