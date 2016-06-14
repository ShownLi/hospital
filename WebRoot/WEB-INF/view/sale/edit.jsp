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
					<i class="fa fa-user"></i> 销售管理 <span>编辑销售</span>
				</h2>
				<div class="breadcrumb-wrapper">
					<span class="label">你在这里:</span>
					<ol class="breadcrumb">
						<li><a href="＃">CRM</a></li>
						<li><a href="${rootPath }sale/list.html">销售管理</a></li>
						<li class="active">编辑销售</li>
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
          <h4 class="panel-title">销售基本信息</h4>
          <p>填写下表，完成销售信息修改。</p>
        </div>
        <form class="form-horizontal form-bordered" id="form">
        <div class="panel-body panel-body-nopadding">
          
          
            
            <div class="form-group">
              <label class="col-sm-3 control-label">销售名</label>
              <div class="col-sm-6">
                <input type="text" name="name" placeholder="销售名" class="form-control" value="${sale.name }" />
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">所属地接社</label>
              <div class="col-sm-6">
                <input type="text" name="agency" placeholder="地接社编号" class="form-control" value="${sale.agency }" />
              </div>
            </div>            
            <div class="form-group">
              <label class="col-sm-3 control-label">销售编码</label>
              <div class="col-sm-6">
                <input type="text" name="code" placeholder="销售编码" class="form-control" value="${sale.code }" />
              </div>
            </div>   
            <div class="form-group">
              <label class="col-sm-3 control-label">邮件地址</label>
              <div class="col-sm-6">
                <input type="text" name="email" placeholder="邮件地址" class="form-control" value="${sale.email }" />
              </div>
            </div>      
          
          
        </div><!-- panel-body -->
        
        <div class="panel-footer">
			 <div class="row">
				<div class="col-sm-6 col-sm-offset-3">
				  <button class="btn btn-primary">提交</button>&nbsp;
				  <button class="btn btn-default" id="btn-back">取消</button>
				  <input type="hidden" name="saleid" value="${sale.saleid }" />
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
			$.post('${rootPath}sale/edit.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}sale/list.html";
				} else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
	</script>


</body>
</html>
