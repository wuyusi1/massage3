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
                        <h5>技师信息</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="frm" method="post" action="${ctx!}/admin/massager/edit">
                            <input type="hidden" id="id" name="id" value="${massager.id}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">技师名：</label>
                                <div class="col-sm-8">
                                    <input id="massagername" name="massagername" class="form-control" type="text" value="${massager.massagername}" <#if user?exists> readonly="readonly"</#if> >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">性别：</label>
                                <div class="col-sm-8">
                                    <select name="massagersex" class="form-control">
                                        <option value="0" <#if massager.massagersex == 0>selected="selected"</#if>>女</option>
                                        <option value="1" <#if massager.massagersex == 1>selected="selected"</#if>>男</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">年龄：</label>
                                <div class="col-sm-8">
                                    <input id="massagerage" name="massagerage" class="form-control" value="${massager.massagerage}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">电话：</label>
                                <div class="col-sm-8">
                                    <input id="massagertel" name="massagertel" class="form-control" value="${massager.massagertel}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">职位：</label>
                                <div class="col-sm-8">
                                    <input id="massagerjob" name="massagerjob" class="form-control" value="${massager.massagerjob}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">简介：</label>
                                <div class="col-sm-8">
                                    <textarea id="massagerinfo" name="massagerinfo" class="form-control" value="${massager.massagerinfo}">${massager.massagerinfo}</textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">状态：</label>
                                <div class="col-sm-8">
                                    <select name="massagerdeletestatus" class="form-control">
                                        <option value="0" <#if massager.massagerdeletestatus == 0>selected="selected"</#if>>未删除</option>
                                        <option value="1" <#if massager.massagerdeletestatus == 1>selected="selected"</#if>>已删除</option>
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
    	      	massagername: {
    	        required: true,
    	      },
    	      	massagertel: {
    	        required: true
    	      },
                massagersex: {
                    required: true
                },
                massagerjob: {
                    required: true
                },
                massagerdeletestatus: {
                    required: true
                }
    	    },
    	    messages: {},
    	    submitHandler:function(form){
    	    	$.ajax({
   	    		   type: "POST",
   	    		   dataType: "json",
   	    		   url: "${ctx!}/admin/massager/edit",
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
