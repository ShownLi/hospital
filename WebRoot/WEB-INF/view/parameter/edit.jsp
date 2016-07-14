<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
					<i class="glyphicon glyphicon-cog"></i> 系统参数管理 <span>编辑系统参数</span>
				</h2>
				<!-- <div class="breadcrumb-wrapper">
					<span class="label">你在这里:</span>
					<ol class="breadcrumb">
						<li><a href="＃">CRM</a></li>
						<li><a href="${rootPath }parameter/list.html">系统参数管理</a></li>
						<li class="active">编辑系统参数</li>
					</ol>
				</div> -->
			</div>

			<div class="contentpanel">
				<!-- content goes here... -->

		<div class="panel panel-default">
        <div class="panel-heading">
          <div class="panel-btns">
            <a href="" class="minimize">&minus;</a>
          </div>
          <h4 class="panel-title">系统参数基本信息</h4>
          <p>填写下表，完成系统参数信息修改。</p>
        </div>
        <form class="form-horizontal" id="form">
        <div class="panel-body panel-body-nopadding">
          
          
            <div class="section-block">
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">作用域</label>
	              <div class="col-sm-8">
	                <input type="text" name="domain" placeholder="作用域" class="form-control" value="${parameter.domain }" />
	              </div>
	            </div>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">值</label>
	              <div class="col-sm-8">
	                <input type="text" name="value" placeholder="值" class="form-control" value="${parameter.value }" />
	              </div>
	            </div>              
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">中文</label>
	              <div class="col-sm-8">
	                <input type="text" name="chinese" placeholder="中文" class="form-control" value="${parameter.chinese }" />
	              </div>
	            </div>              
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">英文</label>
	              <div class="col-sm-8">
	                <input type="text" name="english" placeholder="英文" class="form-control" value="${parameter.english }" />
	              </div>
	            </div>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">描述</label>
	              <div class="col-sm-8">
	                <input type="text" name="depict" placeholder="描述" class="form-control" value="${parameter.depict }" />
	              </div>
	            </div>       
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">排序标记</label>
	              <div class="col-sm-8">
	                <input type="text" name="sort" placeholder="排序标记" class="form-control" value="${parameter.sort }" />
	              </div>
	            </div>  
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label" >是否显示 <span class="asterisk">&nbsp;</span></label>
                  <div class="col-sm-8">
                    <div class="rdio rdio-primary rdio-inline">
                      <input type="radio" id="yes" value="1" name="isdisplay">
                      <label for="yes">是</label>
                    </div><!-- rdio -->
                    <div class="rdio rdio-primary rdio-inline">
                      <input type="radio" id="no" value="0" name="isdisplay" >
                      <label for="no">否</label>
                    </div><!-- rdio -->
                    <label class="error" for="language"></label>
                  </div>
                </div><!-- form-group -->   
            </div>            
        </div><!-- panel-body -->
        
        <div class="panel-footer align-center">
			<button class="btn btn-primary">保存</button>&nbsp;
			<button class="btn btn-default" id="btn-back">返回</button>&nbsp;
			<input type="hidden" name="parameterid" value="${parameter.parameterid }" />
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
	
	if("${parameter.isdisplay}"==1){
		$('#yes').attr('checked','true');
	}
	else{
		$('#no').attr('checked','true');
	}
	
	jQuery(document).ready(function() {

		$(".nav-parent").eq(5).addClass("nav-active");
      	$(".nav-parent").eq(5).find(".children").show();

		jQuery("#form").validate({
			
			rules: {
				domain: "required",
				value: "required",
				chinese: "required",
				sort: "required",
			},
			messages: {
				domain: "请输入作用域",
				value: "请输入值",
				chinese: "请输入中文",
				sort: "请输入排序标识",

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
			$.post('${rootPath}parameter/edit.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}parameter/list.html";
				} else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
	</script>


</body>
</html>
