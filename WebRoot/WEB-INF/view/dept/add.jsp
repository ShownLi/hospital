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
					<i class="fa fa-user"></i> 科室管理 <span>新增科室</span>
				</h2>
			</div>

			<div class="contentpanel">
				<!-- content goes here... -->

		<div class="panel panel-default">
        <div class="panel-heading">
          <div class="panel-btns">
            <a href="" class="minimize">&minus;</a>
          </div>
          <h4 class="panel-title">科室基本信息</h4>
          <p>填写下表，完成科室创建。</p>
        </div>
        <form class="form-horizontal" id="form">
        <div class="panel-body panel-body-nopadding">
          
          	<div class="section-block">
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">科室名称<span class="asterisk">*</span></label>
	              <div class="col-sm-8">
	                <input type="text" id="name" name="name" placeholder="科室名称" class="form-control" />
	              </div>
	            </div>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">联系电话</label>
	              <div class="col-sm-8">
	                <input type="text" name="phone" placeholder="联系电话" class="form-control" />
	              </div>
	            </div>  
	        </div>
	        <div class="section-block">
	             <div class="form-group col-sm-4">
          			<label class="col-sm-4 control-label">所属区域</label>
           			<div class="col-sm-8">
           				<input type="text" id="area" name="area" class="area-select fullwidth"/>
           			</div>
           		</div>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">科室类别</label>
	              <div class="col-sm-8">
	                <input type="text" id="classify" name="classify" class="classify-select fullwidth" />
	              </div>
	            </div>            
	        </div>
        </div><!-- panel-body -->
        
        <div class="panel-footer align-center">
			<input id="addDept" onclick="form_submit()" class="btn btn-primary" type="submit" value="保存"/>&nbsp;
			<input class="btn btn-default" type="button" id="btn-back" value="取消"/>
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
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	
	<script type="text/javascript">
 		var area = ${area}
		var classify = ${classify};
		$(".area-select").select2({
			minimumResultsForSearch: Infinity,
			placeholder:'选择所属医院区域',
	    	data: area
	     });
		$(".classify-select").select2({
			minimumResultsForSearch: Infinity,
			placeholder:'选择所属科室',
	    	data: classify
	     });
		
		/* jQuery("#form").validate({
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
		      $("#addAgency").attr("disabled","disabled");
		      form_submit();
		      return false;
		    }
		  }); */

			
			$("#btn-back").click( function () {
				history.go(-1);
		    }); 
//			      
		function form_submit() {
			var f = $("#form").serialize();
			$.post('${rootPath}dept/add.do', f, function(result) {
				
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}dept/list.html";
				} else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
	</script>
</body>
</html>
