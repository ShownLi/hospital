﻿<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../assets/pages/head.jsp"%>
</head>

<body>
	<%@ include file="../assets/pages/preloader.jsp"%>
	<section>
		<%@ include file="../assets/pages/leftpanel.jsp"%>
		<div class="mainpanel">
			<%@ include file="../assets/pages/headerbar.jsp"%>
			<div class="pageheader">
				<h2>
					<i class="fa fa-user"></i> 邮件管理 <span>新增邮件</span>
				</h2>
				<div class="breadcrumb-wrapper">
					<span class="label">你在这里:</span>
					<ol class="breadcrumb">
						<li><a href="＃">CRM</a></li>
						<li><a href="${rootPath }user/list.html">邮件管理</a></li>
						<li class="active">新增邮件</li>
					</ol>
				</div>
			</div>

			<div class="contentpanel">
				<!-- content goes here... -->

		<div class="panel panel-default">
        <div class="panel-heading">
          <div class="panel-btns">
            <a href="" class="panel-close">&times;</a>
            <a href="" class="minimize">&minus;</a>
          </div>
          <h4 class="panel-title">邮件信息</h4>
          <p>填写下表，完成邮件创建。</p>
        </div>
        <form class="form-horizontal" id="form">
        <div class="panel-body panel-body-nopadding">
        	<div class="section-block">
        		<h5 class="section-title">邮件基本信息</h5>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">订单ID<span class="asterisk">*</span></label>
	              <div class="col-sm-9">
	                <input type="text" name="order_id" placeholder="订单ID" class="form-control" />
	              </div>
	            </div>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">邮件类型</label>
	              <div class="col-sm-9">
	                <input type="text" name="mail_type" placeholder="邮件类型" class="form-control" />
	              </div>
	            </div> 
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label" >发件人</label>
	              <div class="col-sm-9">
	                <input type="text" name="sender" placeholder="发件人" class="form-control" />
	              </div>
	            </div>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">收件人</label>
	              <div class="col-sm-9">
	                <input type="text" name="reciever" placeholder="收件人" class="form-control" disabled />
	              </div>
	            </div> 
	        </div>
	        <div class="section-block">
	        	<h5 class="section-title">客人联系方式  <span style="font-size:12px;">(手机、微信、QQ、邮箱至少填写一个)</span></h5>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">固定电话</label>
	              <div class="col-sm-9">
	                <input type="text" name="telephone" placeholder="固定电话" class="form-control" />
	              </div>
	            </div>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">手机</label>
	              <div class="col-sm-9">
	                <input type="text" name="mobilephone" placeholder="手机" class="form-control" />
	              </div>
	            </div>    
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">微信</label>
	              <div class="col-sm-9">
	                <input type="text" name="wechat" placeholder="微信" class="form-control" />
	              </div>
	            </div>       
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">QQ</label>
	              <div class="col-sm-9">
	                <input type="text" name="qq" placeholder="QQ" class="form-control" />
	              </div>
	            </div>            
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">邮箱</label>
	              <div class="col-sm-9">
	                <input type="text" name="email" placeholder="邮箱" class="form-control"  />
	              </div>
	            </div>  
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">所在地</label>
	              <div class="col-sm-9">
	                <input type="text" name="location" placeholder="所在地" class="form-control" />
	              </div>
	            </div> 
	        </div>
	        <div class="section-block"> 
	        	<h5 class="section-title">其他</h5>   
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label" >推广渠道 </label>
	              <div class="col-sm-9">
	                <input type="text" name="promote" placeholder="推广渠道" class="promote-select form-control" />
	              </div>
	            </div>
	        </div>   
        </div><!-- panel-body -->
        
        <div class="panel-footer align-center">
			<button class="btn btn-primary">提交</button>&nbsp;
			<button class="btn btn-default" id="btn-back">取消</button>
		</div><!-- panel-footer -->
     </form>   
      </div><!-- panel -->

		<!-- mainpanel -->
		<%@ include file="../assets/pages/rightpanel.jsp"%>
	</section>


<!-- Modal -->
<div class="modal fade" id="msgModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">信息</h4>
      </div>
      <div class="modal-body">
        保存数据时出错了
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->

<div class="nextModal modal fade" id="nextModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">您可以继续添加询单，或返回到客人列表页面</div>
      </div>
      <div class="modal-body align-center">
        	<a class="btn btn-primary" href="${rootPath}case/add.html">添加询单</a>
        	<a class="btn btn-primary" href="${rootPath}customer/list.html">返回列表</a>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->


	<%@ include file="../assets/pages/foot.jsp"%>
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript">
		//var p = ${promote};
		//var a = ${agegroup};
		//$(".promote-select").select2({
			//placeholder: '选择一个推广渠道',
		  	//data: p
		//});
		//$(".agegroup-select").select2({
			//placeholder: '选择一个推广渠道',
		  	//data: a
		//});
	
		
		jQuery(document).ready(function() {
					 
			jQuery("#form").validate({
				
				rules: {
					loginname: "required",
					name: "required",
					pwd: {
						required: true,
					},
					repwd: {
						required: true,
						equalTo: "[name='pwd']"
					}
				},
				messages: {
					loginname: "请输入登录名",
					name: "请输入姓名",
					pwd: {
						required: "请输入密码"
					},
					repwd: {
						required: "请输入密码确认",
						equalTo: "两次输入的密码不一致"
					}
				},
				
			    highlight: function(element) {
			      jQuery(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			    },
			    success: function(element) {
			      jQuery(element).closest('.form-group').removeClass('has-error');
			    },
			    invalidHandler : function(){
			      return false;
			    },
			    submitHandler : function(){
			      form_submit();
			      return false;
			    }
			  });
			
			$("#btn-back").click( function () {
				history.go(-1);
		    } ); 
		});
			      
		function form_submit() {
			var f = $("#form").serialize();
			$.post('${rootPath}customer/add.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					//window.parent.location = "${rootPath}customer/list.html";
					$("#nextModal").modal('show');
				} else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
	</script>


</body>
</html>
