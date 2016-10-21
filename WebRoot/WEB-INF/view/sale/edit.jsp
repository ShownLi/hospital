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
					<i class="fa fa-group"></i> 销售管理 <span>编辑销售</span>
				</h2>
			</div>

			<div class="contentpanel">
				<!-- content goes here... -->

		<div class="panel panel-default">
        <div class="panel-heading">
          <div class="panel-btns">
            <a href="" class="minimize">&minus;</a>
          </div>
          <h4 class="panel-title">销售基本信息</h4>
          <p>填写下表，完成销售信息修改。</p>
        </div>
        <form class="form-horizontal form-bordered" id="form">
        <div class="panel-body panel-body-nopadding">
          
          
            
            <div class="form-group">
              <label class="col-sm-4 control-label">销售名称 <span class="asterisk">*</span></label>
              <div class="col-sm-4">
                <input type="text" name="salesName" placeholder="销售名" class="form-control" value="${sales.salesName }" />
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">PortalID <span class="asterisk">*</span></label>
              <div class="col-sm-4">
                <input type="text" id="salesPortalId" name="salesPortalId" placeholder="官网ID" class="form-control" value="${sales.salesPortalId }"/>
              </div>
            </div>       
            <div class="form-group">
              <label class="col-sm-4 control-label">所属地接社 <span class="asterisk">*</span></label>
              <input type="text" name="agencyId" class="agency-select col-sm-4" value="${sales.agencyId }" readonly/>
            </div>               
            <div class="form-group">
              <label class="col-sm-4 control-label">邮件地址 <span class="asterisk">*</span></label>
              <div class="col-sm-4">
                <input type="text" name="salesEmail" placeholder="邮件地址" class="form-control" value="${sales.salesEmail }" />
              </div>
            </div>      
          
          
        </div><!-- panel-body -->
        
        <div class="panel-footer align-center">
			<button class="btn btn-primary">保存</button>&nbsp;
			<button class="btn btn-default" id="btn-back">返回</button>&nbsp;
			<input type="hidden" name="salesid" value="${sales.salesId }" />
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
	var p = ${agency};
	
	$(".agency-select").select2({
	  	data: p
	})
	jQuery(document).ready(function() {

		$(".nav-parent").eq(3).addClass("nav-active");
      	$(".nav-parent").eq(3).find(".children").show();
      	
		jQuery("#form").validate({
			rules: {
				salesName: "required",
				salesEmail: "email",
				salesPortalId: {
					remote:{                           
		            	url:"${rootPath}validate.do",
		            	type:"post",
		            	data: {
	                        table: function () { return "tm_sales"},
	                        field: function () { return "sales_portal_id"},
	                        name: function () { 
	                        	 if($("#salesPortalId").val()=="${sales.salesPortalId}"){
		                        	 	return "";
		                        	 }
		                        	 else{return $("#salesPortalId").val();}
	                        	 },
	                    }
		            }
				}
			},
			messages: {
				salesName: "请输入销售名称",
				salesPortalId: {
					remote:"销售编号已存在"
				},
				salesEmail: "请输入有效的邮箱地址",

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
			$.post('${rootPath}sale/edit.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}agency/edit.html?id=${sales.agencyId}";
				} else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}	
	</script>


</body>
</html>
