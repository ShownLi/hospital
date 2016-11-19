﻿<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../assets/pages/head.jsp"%>
</head>

<body class="leftpanel-collapsed">
	<%@ include file="../assets/pages/preloader.jsp"%>
	<section>
		<%@ include file="../assets/pages/leftpanel.jsp"%>
		<div class="mainpanel">
			<%@ include file="../assets/pages/headerbar.jsp"%>
			<div class="pageheader">
				<h2>
					<i class="glyphicon glyphicon-briefcase"></i> 地接社管理 <span>新增地接社</span>
				</h2>

			</div>

			<div class="contentpanel">
				<!-- content goes here... -->

		<div class="panel panel-default">
        <div class="panel-heading">
          <div class="panel-btns">
            <a href="" class="minimize">&minus;</a>
          </div>
          <h4 class="panel-title">地接社基本信息</h4>
          <p>填写下表，完成地接社创建。</p>
        </div>
        <form class="form-horizontal" id="form">
        <div class="panel-body panel-body-nopadding">
          
          
            <div class="section-block">
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">地接社名称 <span class="asterisk">*</span></label>
	              <div class="col-sm-8">
	                <input type="text" id="agencyName" name="name" placeholder="地接社名称" class="form-control" />
	              </div>
	            </div>			   
	            <div class="form-group col-sm-4">
	              <label  class="col-sm-4 control-label">语言</label>
	              <div class="col-sm-8">
	              	<input type="text" name="language" class="language-select fullwidth"/>
	              </div>
	            </div>                                 
	            <div class="form-group col-sm-4">
	              <label  class="col-sm-4 control-label">所在国家</label>
	              <div class="col-sm-8">
	                <input type="text" name="country" class="country-select fullwidth"/>
	              </div>
	            </div>
 	            <div class="form-group col-sm-4">
	              <label  class="col-sm-4 control-label">是否发邮件</label>
	              <div class="col-sm-8">
	                   <input type="radio" name="isSendmail" value="1" />是
      				   <input type="radio" name="isSendmail" value="0" checked/>否
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

<div class="nextModal modal fade" id="nextModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">您可以继续添销售，或返回到地接社列表页面</div>
      </div>
      <div class="modal-body align-center">
        	<a id="addsale" class="btn btn-primary" href="${rootPath}sale/add.html?agencyId=">添加销售</a>
        	<a class="btn btn-primary" href="${rootPath}agency/list.html">返回列表</a>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->

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
	var c = ${country};
	var l = ${language};
	$(".country-select").select2({
		placeholder: '选择一个国家',
	  	data: c
	})

	$(".language-select").select2({
	    placeholder: '选择一个语言选项',
     	data: l
	})
	jQuery(document).ready(function() {	

		$(".nav-parent").eq(3).addClass("nav-active");
      	$(".nav-parent").eq(3).find(".children").show();


		jQuery("#form").validate({
			rules: {
				name: {  
		         	required:true,  
		            remote:{                           
		            	url:"${rootPath}validate.do",
		            	type:"post",
		            	data: {
	                         table: function () { return "tm_agency"},
	                         field: function () { return "agency_name"},
	                         name: function () { return $("#agencyName").val();},
	                         }
		            }
		        }
			},
			messages: {
				name: {
					required:"请输入地接社名",
					remote:"地接社已存在，请重新输入"
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
			$.post('${rootPath}agency/add.do',f, function(result) {
				var agencyId = result.obj.agencyId;
				var rmsg = result.msg;
				
				//弹出Modal询问直接添加销售还是跳到list页面
				/* if (result.success) {
					//window.parent.location = "${rootPath}agency/list.html";
					$("#nextModal").modal('show');

					// 添加销售的url需要该地接社的id
			      	var href = $("#addsale").attr("href");
			      	$("#addsale").attr("href",href+agencyId);
				} else {
					$("#msgModal").modal('show');
				} */
				
				if (result.success) {
					window.parent.location = "${rootPath}sale/add.html?agencyId="+agencyId;
				} else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
	</script>

</body>
</html>
