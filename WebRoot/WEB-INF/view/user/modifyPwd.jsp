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
					<i class="fa fa-user"></i> 个人中心 <span>密码修改</span>
				</h2>
				
			</div>

			<div class="contentpanel">
				<!-- content goes here... -->

		<div class="panel panel-default">
        <div class="panel-heading">
          <div class="panel-btns">
            <a href="" class="minimize">&minus;</a>
          </div>
          <h4 class="panel-title">用户密码</h4>
        </div>
        <form class="form-horizontal" id="form">
        <div class="panel-body panel-body-nopadding">
          
	        <div class="section-block"> 
	            <div class="form-group col-sm-6">
	              <label class="col-sm-3 control-label">原始密码</label>
	              <div class="col-sm-6">
	                <input type="text" name="oldPwd" placeholder="原密码" class="form-control"    />
	              </div>
	            </div>
	            <div class="form-group col-sm-6">
	              <label class="col-sm-3 control-label">新密码</label>
	              <div class="col-sm-6">
	                <input type="text" name="newPwd" placeholder="新密码" class="form-control"  />
	              </div>
	            </div>              
	            <div class="form-group col-sm-6">
	              <label class="col-sm-3 control-label">再次输入新密码</label>
	              <div class="col-sm-6">
	                <input type="text" name="repeatPwd" placeholder="重复密码" class="form-control"   />
	              </div>
	            </div>            
	            
	        </div>
          
        </div><!-- panel-body -->
        
        <div class="panel-footer align-center">
			<button class="btn btn-primary">修改密码</button>&nbsp;
			</div><!-- panel-footer -->
     </form>   
      </div><!-- panel -->





			</div>

		</div>
		<!-- mainpanel -->
		<%@ include file="../assets/pages/rightpanel.jsp"%>
	</section>


<!-- Modal 失败 -->
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

<!-- Modal 成功 -->
<div class="modal fade" id="msgModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">信息</h4>
      </div>
      <div class="modal-body">
        密码修改成功
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->
<!-- Modal 原始密码输入错误 -->
<div class="modal fade" id="msgModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">信息</h4>
      </div>
      <div class="modal-body">
        原始密码输入错误
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
        
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->



	<%@ include file="../assets/pages/foot.jsp"%>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript">
		jQuery(document).ready(function() {

		/* 	$(".nav-parent").eq(4).addClass("nav-active");
      		$(".nav-parent").eq(4).find(".children").show(); */
      		
			jQuery("#form").validate({
				rules: {
					oldPwd: "required",
					newPwd: {
						required: true,
						minlength: 6,
					},repeatPwd: {
						required: true,
						equalTo: "[name='newPwd']"
					},
				},
				messages: {
					oldPwd: "请填写原始密码",
					newPwd:   {
						required: "请填写新密码",
						minlength: "密码长度至少为6位",
					},
					repeatPwd: {
						required: "请填写确认密码",
						equalTo: "两次输入的密码不一致"
					},
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
		});
//			      
		function form_submit() {
			var f = $("#form").serialize();
			$.post('${rootPath}user/modifyPwd.do', f, function(result) {
				var rmsg = result.msg;
				if (result.msg=="1") {
					window.parent.location = "#";
					$("#msgModal3").modal('show');
				} else if(result.msg=="2") {
					 window.location="signin.html";
				}else{
					alert(result.msg);
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
	</script>


</body>
</html>
