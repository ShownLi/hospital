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
					<i class="fa fa-user"></i> 科室管理 <span>编辑科室</span>
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
          <p>填写下表，完成科室信息修改。</p>
        </div>
        <form class="form-horizontal" id="form">
		<div class="panel-body panel-body-nopadding">
          
          	<div class="section-block">
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">患者编号<span class="asterisk"></span></label>
	              <div class="col-sm-8">
	                <input type="text" id="patientId" name="patientId" readonly="readonly" value="${patient.patientId}" placeholder="患者编号" class="form-control" />
	              </div>
	            </div>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">患者姓名<span class="asterisk">*</span></label>
	              <div class="col-sm-8">
	                <input type="text" id="name" name="name" value="${patient.name}" placeholder="患者姓名" class="form-control" />
	              </div>
	            </div>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">年龄<span class="asterisk">*</span></label>
	              <div class="col-sm-8">
	                <input type="text" name="birthday" value="${patient.birthday}" placeholder="年龄" class="form-control" />
	              </div>
	            </div>  
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">性别<span class="asterisk">*</span></label>
	              <div class="col-sm-8">
	               <!--  <input type="text" name="sex" placeholder="性别" class="form-control" /> -->
	               <select name="sex" class="form-control">
	               		<option value="0">男</option> 
						<option value="1">女</option> 
	               </select>
	              </div>
	            </div>  
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">联系电话</label>
	              <div class="col-sm-8">
	                <input type="text" name="phone" value="${patient.phone}" placeholder="联系电话" class="form-control" />
	              </div>
	            </div>  
	        </div>
	        <div class="section-block">
	             <div class="form-group col-sm-4">
          			<label class="col-sm-4 control-label">紧急联系人电话</label>
           			<div class="col-sm-8">
           				<input type="text" id="urgentPhone" value="${patient.urgentPhone}" name="urgentPhone" class="form-control"/>
           			</div>
           		</div>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">地址</label>
	              <div class="col-sm-8">
	                <input type="text" id="address" value="${patient.address}" name="address" class="form-control" />
	              </div>
	            </div>            
	            <%-- <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">挂号日期</label>
	              <div class="col-sm-8">
	                <input type="text" id="date" readonly="readonly" value="${patient.date}.Format("yyyy-MM-dd HH:mm:ss")" name="date" class="form-control" />
	              </div>
	            </div> --%>            
	        </div>
        </div><!-- panel-body -->
        
        <div class="panel-footer align-center">
			<input id="editDoctor" onclick="form_submit()" class="btn btn-primary" type="submit" value="保存"/>&nbsp;
			<input class="btn btn-default" type="button" id="btn-back" value="取消"/>
			<input type="hidden" name="patientId" value="${patient.patientId }" />
		</div><!-- panel-footer -->
     </form> 
     
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
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	
<script type="text/javascript">
	$("#btn-back").click( function () {
		history.go(-1);
    }); 
	function form_submit() {
		var f = $("#form").serialize();
		$.post('${rootPath}patient/edit.do', f, function(result) {
			var rmsg = result.msg;
			if (result.success) {
				window.parent.location = "${rootPath}patient/list.html";
			} else {
				$("#msgModal").modal('show');
			}
		}, "JSON");
	}
</script>
</body>
</html>
