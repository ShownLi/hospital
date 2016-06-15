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
					<i class="fa fa-user"></i> 地接社管理 <span>新增地接社</span>
				</h2>
				<div class="breadcrumb-wrapper">
					<span class="label">你在这里:</span>
					<ol class="breadcrumb">
						<li><a href="＃">CRM</a></li>
						<li><a href="${rootPath }agency/list.html">地接社管理</a></li>
						<li class="active">新增地接社</li>
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
          <h4 class="panel-title">地接社基本信息</h4>
          <p>填写下表，完成地接社创建。</p>
        </div>
        <form class="form-horizontal form-bordered" id="form">
        <div class="panel-body panel-body-nopadding">
          
          
            
            <div class="form-group">
              <label class="col-sm-3 control-label">地接社名 <span class="asterisk">*</span></label>
              <div class="col-sm-5">
                <input type="text" name="name" placeholder="地接社名" class="form-control" />
              </div>
            </div>			  
                <div class="form-group">
                  <label class="col-sm-3 control-label">语言 <span class="asterisk">*</span></label>
                  <div class="col-sm-5">
                    <div class="rdio rdio-primary">
                      <input type="radio" id="chinese" value="chinese" name="language" checked />
                      <label for="chinese">可以中文</label>
                    </div><!-- rdio -->
                    <div class="rdio rdio-primary">
                      <input type="radio" value="english" id="english" name="language">
                      <label for="english">只会英文</label>
                    </div><!-- rdio -->
                    <label class="error" for="language"></label>
                  </div>
                </div><!-- form-group -->                     
            <div class="form-group">
              <label  class="col-sm-3 control-label">所在国家 <span class="asterisk">*</span></label>

                <input type="text" name="country" class="js-example-data-array col-sm-5"/>

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
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript">
	var p = ${parameter};
	
	$(".js-example-data-array").select2({
		placeholder: '选择一个国家',
	  	data: p
	})
	
	jQuery(document).ready(function() {		  
		jQuery("#form").validate({
			rules: {
				name: "required",
				language: "required",
				country: "required",
			},
			messages: {
				name: "This field is required.",
				language: "This field is required.",
				country: "This field is required.",
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
		var str = $('#country').select2("val").text;
	      
		function form_submit() {
			var f = $("#form").serialize();
			$.post('${rootPath}agency/add.do',f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}agency/list.html";
				} else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
	</script>

</body>
</html>
