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
                        <h5>请输入顾客信息</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="frm" method="post" action="${ctx!}/admin/customer/edit">
                        	<input type="hidden" id="id" name="id" value="${customer.id}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">账户名：</label>
                                <div class="col-sm-8">
                                    <input id="customername" name="customername" class="form-control" type="text" value="${customer.customername}" <#if customer?exists> readonly="readonly"</#if> >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">昵称：</label>
                                <div class="col-sm-8">
                                    <input id="customernickname" name="customernickname" class="form-control" type="text" value="${customer.customernickname}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">性别：</label>
                                <div class="col-sm-8">
                                	<select name="customersex" class="form-control">
                                		<option value="0" <#if customer.customersex == 0>selected="selected"</#if>>女</option>
                                		<option value="1" <#if customer.customersex == 1>selected="selected"</#if>>男</option>
                                	</select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">出生日期：</label>
                                <div class="col-sm-8">
                                    <input id="customerbirth" name="customerbirth" readonly="readonly" class="laydate-icon form-control layer-date" type="date"  value="${customer.customerbirth}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">电话：</label>
                                <div class="col-sm-8">
                                    <input id="customertel" name="customertel" class="form-control" value="${customer.customertel}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">E-mail：</label>
                                <div class="col-sm-8">
                                    <input id="customeremail" name="customeremail" class="form-control" value="${customer.customeremail}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">地址：</label>
                                <div class="col-sm-8">
                                    <input id="customeraddress" name="customeraddress" class="form-control" value="${customer.customeraddress}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">会员：</label>
                                <div class="col-sm-8">
                                    <select name="customervip" class="form-control">
                                        <option value="0" <#if customer.customervip == 0>selected="selected"</#if>>非会员</option>
                                        <option value="1" <#if customer.customervip == 1>selected="selected"</#if>>会员</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">状态：</label>
                                <div class="col-sm-8">
                                	<select name="customerdeletestatus" class="form-control">
                                		<option value="0" <#if customer.customerdeletestatus == 0>selected="selected"</#if>>未删除</option>
                                		<option value="1" <#if customer.customerdeletestatus == 1>selected="selected"</#if>>已删除</option>
                                	</select>
                                </div>
                            </div>
                            <!--<div class="form-group">
                                <label class="col-sm-3 control-label">描述：</label>
                                <div class="col-sm-8">
                                    <input id="description" name="description" class="form-control" value="${user.description}">
                                </div>
                            </div>-->
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
	  	//外部js调用
	    laydate({
	        elem: '#customerbirth', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
	        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
	    });

	    $("#frm").validate({
    	    rules: {
    	    	customername: {
    	        required: true,
    	        minlength: 4,
    	    	maxlength: 10
    	      },
    	      	customernickname: {
    	        required: true,
    	        minlength: 4,
    	    	maxlength: 10
    	      },
    	      	customersex: {
    	        required: true
    	      },
    	      	customerbirth: {
    	      	date:true,
    	        required: true
    	      },
    	      	customertel: {
    	        required: true
    	      },
    	      	customeremail: {
    	      	email:true,
    	        required: true
    	      },
    	      	customeraddress: {
    	        required: true,
    	        maxlength: 40
    	      },
    	      	customerdeletestatus: {
    	        required: true
    	      }
    	    },
    	    messages: {},
    	    submitHandler:function(form){
    	    	$.ajax({
   	    		   type: "POST",
   	    		   dataType: "json",
   	    		   url: "${ctx!}/admin/customer/edit",
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
