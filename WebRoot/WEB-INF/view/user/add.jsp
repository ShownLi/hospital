<%@ page language="java" pageEncoding="utf-8"%>
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
					<i class="fa fa-user"></i> 用户管理 <span>新增用户</span>
				</h2>
				<div class="breadcrumb-wrapper">
					<span class="label">你在这里:</span>
					<ol class="breadcrumb">
						<li><a href="＃">Demo</a></li>
						<li><a href="${rootPath }user/list.html">用户管理</a></li>
						<li class="active">新增用户</li>
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
          <h4 class="panel-title">用户基本信息</h4>
          <p>填写下表，完成用户创建。</p>
        </div>
        <form class="form-horizontal form-bordered" id="form">
        <div class="panel-body panel-body-nopadding">
          
          
            
            <div class="form-group">
              <label class="col-sm-3 control-label">登录名</label>
              <div class="col-sm-6">
                <input type="text" name="loginname" placeholder="登录名" class="form-control" />
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">姓名</label>
              <div class="col-sm-6">
                <input type="text" name="name" placeholder="姓名" class="form-control" />
              </div>
            </div>            
            <div class="form-group">
              <label class="col-sm-3 control-label">密码</label>
              <div class="col-sm-6">
                <input type="password" class="form-control pword" placeholder="密码" name="pwd" />
              </div>
            </div>            
            <div class="form-group">
              <label class="col-sm-3 control-label">密码确认</label>
              <div class="col-sm-6">
                <input type="password" class="form-control pword" placeholder="密码确认" name="repwd" />
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">用户描述</label>
              <div class="col-sm-6">
                <textarea class="form-control" name="userdesc" rows="5"></textarea>
              </div>
            </div>
            
            
            
          
          
        </div><!-- panel-body -->
        
        <div class="panel-footer">
			 <div class="row">
				<div class="col-sm-6 col-sm-offset-3">
				  <button class="btn btn-primary">提交</button>&nbsp;
				  <button class="btn btn-default" id="btn-back">取消</button>
				</div>
			 </div>
		  </div><!-- panel-footer -->
     </form>   
      </div><!-- panel -->





			</div>

		</div>
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



	<%@ include file="../assets/pages/foot.jsp"%>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript">
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
//			      
		function form_submit() {
			var f = $("#form").serialize();
			$.post('${rootPath}user/add.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}user/list.html";
				} else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
	
		
	</script>


</body>
</html>
