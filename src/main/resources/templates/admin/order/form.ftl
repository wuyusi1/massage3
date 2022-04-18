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
                        <h5>订单信息</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="frm" method="post" action="${ctx!}/admin/order/edit">
                        	<!-- <input type="hidden" id="id" name="id" value="${customer.id}"> -->
                            <div class="form-group">
                                <label class="col-sm-3 control-label">订单编号：</label>
                                <div class="col-sm-8">
                                    <input id="id" name="id" class="form-control" type="text" value="${order.id}" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">顾客用户名：</label>
                                <div class="col-sm-8">
                                    <input id="customername" name="customername" class="form-control" type="text" value="${order.customername}" <#if order?exists> readonly="readonly"</#if> >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">顾客电话</label>
                                <div class="col-sm-8">
                                    <input id="customertel" name="customertel" class="form-control" value="${order.customertel}" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否会员</label>
                                <div class="col-sm-8">
                                	<select name="customervip" class="form-control" readonly="readonly" >
                                		<option value="0" <#if order.customervip == 0>selected="selected"</#if>>非会员</option>
                                		<option value="1" <#if order.customervip == 1>selected="selected"</#if>>会员</option>
                                	</select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">服务项目：</label>
                                <div class="col-sm-8">
                                    <input id="servicename" name="servicename" class="form-control" type="text" value="${order.servicename}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">服务价格：</label>
                                <div class="col-sm-8">
                                    <input id="serviceprice" name="serviceprice" class="form-control" type="text" value="${order.serviceprice}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">按摩师：</label>
                                <div class="col-sm-8">
                                    <input id="massagername" name="massagername" class="form-control" type="text" value="${order.massagername}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">订单状态：</label>
                                <div class="col-sm-8">
                                    <select name="orderstatus" class="form-control" >
                                        <option value="0" <#if order.orderstatus == 0>selected="selected"</#if>>未支付</option>
                                        <option value="1" <#if order.orderstatus == 1>selected="selected"</#if>>未完成</option>
                                        <option value="2" <#if order.orderstatus == 2>selected="selected"</#if>>已完成</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">删除状态：</label>
                                <div class="col-sm-8">
                                	<select name="orderdeletestatus" class="form-control" readonly="readonly">
                                		<option value="0" <#if order.orderdeletestatus == 0>selected="selected"</#if>>未删除</option>
                                		<option value="1" <#if order.orderdeletestatus == 1>selected="selected"</#if>>已删除</option>
                                	</select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">创建时间：</label>
                                <div class="col-sm-8">
                                    <input id="createdate" name="createdate"  class="laydate-icon form-control layer-date" value="${order.createdate}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">更新时间：</label>
                                <div class="col-sm-8">
                                    <input id="updatedate" name="updatedate" class="laydate-icon form-control layer-date"   value="${order.updatedate}">
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
	        elem: '#createdate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
	        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
	    });
        laydate({
            elem: '#updatedate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });

	    $("#frm").validate({
    	    rules: {
    	    	id: {
    	        required: false,
    	      },
    	      	customername: {
    	        required: true,
    	      },
    	      	customertel: {
    	        required: true
    	      },
                customervip: {
                    required: true
                },
                servicename: {
                    required: true
                },
                massagername: {
                    required: true
                },
                serviceprice: {
                    required: true
                },
    	      	createdate: {
    	      	date:true,

    	      },
                updatedate: {
                    date:true,

                },
    	      	orderstatus: {
    	        required: true
    	      },
    	      	orderdeletestatus: {
    	        required: true
    	      }
    	    },
    	    messages: {},
    	    submitHandler:function(form){
    	    	$.ajax({
   	    		   type: "POST",
   	    		   dataType: "json",
   	    		   url: "${ctx!}/admin/order/edit",
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
