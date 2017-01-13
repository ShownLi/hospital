<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<i class="fa fa-user"></i> 权限管理 <span>新增角色</span>
				</h2>
			</div>
			<div class="contentpanel">
				<!-- content goes here... -->

		<div class="panel panel-default">
	        <div class="panel-heading">
	          <div class="panel-btns">
	            <a href="" class="minimize">&minus;</a>
	          </div>
	          <h4 class="panel-title">新增角色</h4>
	          <p>填写下表，完成角色信息创建。</p>
	        </div>
	        <form class="form-horizontal" id="form">
	        <div class="panel-body panel-body-nopadding">          
	            <div class="form-group col-sm-6">
	              <label class="col-sm-3 control-label">角色名称</label>
	              <div class="col-sm-4">
					<input type="text" name="role_id" id="role_id" placeholder="请输入角色名称" class="form-control" />   
                  </div>
	            </div>
	            <div>

           		<div class="container">
					<div class="row">
						<h4 class="col-md-12" style="margin-top: 20px; color: #000;">询单栏列表</h4>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="selectall1" class="selectall" type="checkbox" value="" />
								<label for="selectall1">全选 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_4" class="check" name="casemenu" type="checkbox" value="3" />
								<label for="menu_id_4">询单展示列表界面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_5" class="check" name="casemenu" type="checkbox" value="4" />
								<label for="menu_id_5">新增询单界面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_6" class="check" name="casemenu" type="checkbox" value="5" />
								<label for="menu_id_6">编辑询单页面 </label>
							</div>
						</div> 
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_7" class="check" name="casemenu" type="checkbox" value="18" />
								<label for="menu_id_7">用户列表新增询单界面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_8" class="check" name="casemenu" type="checkbox" value="19" />
								<label for="menu_id_8">询单处理界面 </label>
							</div>
						</div>
					</div>
					<div class="row">
						<h4 class="col-md-12" style="margin-top: 20px; color: #000;">订单栏列表</h4>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="selectall2" class="selectall" type="checkbox" value="" />
								<label for="selectall2">全选 </label> 
							</div>
						</div> 
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_9" class="check" name="ordermenu" type="checkbox" value="6" />
								<label for="menu_id_9">订单展示列表界面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_10" class="check" name="ordermenu" type="checkbox" value="7" />
								<label for="menu_id_10">新增询订单界面 </label>
							</div>
						</div> 
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_11" class="check" name="ordermenu" type="checkbox" value="8" />
								<label for="menu_id_11">编辑订单页面 </label>
							</div>
						</div> 
					</div>
					<div class="row">
						<h4 class="col-md-12" style="margin-top: 20px; color: #000;">客人栏列表</h4>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="selectall3" class="selectall" type="checkbox" value="" />
								<label for="selectall3">全选 </label> 
							</div>
						</div> 
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_12" class="check" name="customermenu" type="checkbox" value="9" />
								<label for="menu_id_12">客人展示列表界面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_13" class="check" name="customermenu" type="checkbox" value="10" />
								<label for="menu_id_13">新增客人界面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_14" class="check" name="customermenu" type="checkbox" value="11" />
								<label for="menu_id_14">编辑客人页面 </label>
							</div>
						</div> 
					</div>
					<div class="row">
						<h4 class="col-md-12" style="margin-top: 20px; color: #000;">地接社栏列表</h4>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="selectall4" class="selectall" type="checkbox" value="" />
								<label for="selectall4">全选 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_15" class="check" name="agencymenu" type="checkbox" value="12" />
								<label for="menu_id_15">地接社展示列表界面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_16" class="check" name="agencymenu" type="checkbox" value="13" />
								<label for="menu_id_16">新增地接社界面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_17" class="check" name="agencymenu" type="checkbox" value="14" />
								<label for="menu_id_17">编辑地接社页面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_18" class="check" name="agencymenu" type="checkbox" value="45" />
								<label for="menu_id_18">新增销售界面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_19" class="check" name="agencymenu" type="checkbox" value="46" />
								<label for="menu_id_19">编辑销售界面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_20" class="check" name="agencymenu" type="checkbox" value="47" />
								<label for="menu_id_20">销售列表界面 </label> 
							</div>
						</div>
					</div>
					<div class="row">
						<h4 class="col-md-12" style="margin-top: 20px; color: #000;">用户栏列表</h4>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="selectall5" class="selectall" type="checkbox" value="" />
								<label for="selectall5">全选 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_21" class="check" name="usermenu" type="checkbox" value="15" />
								<label for="menu_id_21">用户展示列表界面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_22" class="check" name="usermenu" type="checkbox" value="16" />
								<label for="menu_id_22">新增用户界面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_23" class="check" name="usermenu" type="checkbox" value="17" />
								<label for="menu_id_23">编辑用户页面 </label> 
							</div>
						</div>
					</div>
					<div class="row">
						<h4 class="col-md-12" style="margin-top: 20px; color: #000;">统计栏列表</h4>
						<div class="col-md-3">
							<div class="ckbox ckbox-primary">
								<input id="selectall6" class="selectall" type="checkbox" value="" />
								<label for="selectall6">全选 </label> 
							</div>
						</div>
						<div class="col-md-3">
							<div class="ckbox ckbox-primary">
								<input name="menu_id_24" class="check" type="checkbox" value="20" />
								<label for="menu_id_24">询单来源状态统计界面 </label>
							</div>
						</div> 
						<div class="col-md-3">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_25" class="check" name="statsmenu" type="checkbox" value="21" />
								<label for="menu_id_25">沟通方式统计界面 </label> 
							</div>
						</div> 
						<div class="col-md-3">
							<div class="ckbox ckbox-primary">
								<input name="menu_id_26" class="check" type="checkbox" value="22" />
								<label for="menu_id_26">询单分配统计界面</label> 
							</div>
						</div> 
						<div class="col-md-3">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_27" class="check" name="statsmenu" type="checkbox" value="23" />
								<label for="menu_id_27">流失原因统计界面 </label> 
							</div>
						</div> 
						<div class="col-md-3">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_28" class="check" name="statsmenu" type="checkbox" value="24" />
								<label for="menu_id_28">地接社业绩统计界面 </label> 
							</div>
						</div> 
						<div class="col-md-3">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_29" class="check" name="statsmenu" type="checkbox" value="25" />
								<label for="menu_id_29">跟单员询单状态统计界面 </label> 
							</div>
						</div> 
						<div class="col-md-3">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_30" class="check" name="statsmenu" type="checkbox" value="26" />
								<label for="menu_id_30">跟单员业绩统计 </label> 
							</div>
						</div> 
						<div class="col-md-3">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_31" class="check" name="statsmenu" type="checkbox" value="27" />
								<label for="menu_id_31">目的地询单状态统计界面 </label> 
							</div>
						</div> 
						<div class="col-md-3">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_32" class="check" name="statsmenu" type="checkbox" value="28" />
								<label for="menu_id_32">目的地咨询、成交统计界面 </label> 
							</div>
						</div> 
						<div class="col-md-3">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_33" class="check" name="statsmenu" type="checkbox" value="29" />
								<label for="menu_id_33">客人来源统计界面 </label> 
							</div>
						</div> 
						<div class="col-md-3">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_34" class="check" name="statsmenu" type="checkbox" value="30" />
								<label for="menu_id_34">客人来源级别统计界面 </label> 
							</div>
						</div> 
						<div class="col-md-3">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_35" class="check" name="statsmenu" type="checkbox" value="31" />
								<label for="menu_id_35">商家覆盖统计界面 </label> 
							</div>
						</div> 
						<div class="col-md-3">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_36" class="check" name="statsmenu" type="checkbox" value="32" />
								<label for="menu_id_36">商家未询统计界面 </label> 
							</div>
						</div> 
						<div class="col-md-3">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_37" class="check" name="statsmenu" type="checkbox" value="33" />
								<label for="menu_id_37">地接社订单状态统计界面 </label> 
							</div>
						</div>
					</div>
					<div class="row">
						<h4 class="col-md-12" style="margin-top: 20px; color: #000;">系统参数栏列表</h4>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="selectall7" class="selectall" type="checkbox" value="" />
								<label for="selectall7">全选 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_38" class="check" name="parametermenu" type="checkbox" value="34" />
								<label for="menu_id_38">系统参数列表界面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_39" class="check" name="parametermenu" type="checkbox" value="35" />
								<label for="menu_id_39">新增系统参数界面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_40" class="check" name="parametermenu" type="checkbox" value="36" />
								<label for="menu_id_40">编辑系统参数界面 </label>
							</div>
						</div>
					</div>
					<div class="row">
						<h4 class="col-md-12" style="margin-top: 20px; color: #000;">权限管理栏列表</h4>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="selectall8" class="selectall" type="checkbox" value="" />
								<label for="selectall8">全选 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_41" class="check" name="powermenu" type="checkbox" value="37" />
								<label for="menu_id_41">权限列表界面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_42" class="check" name="powermenu" type="checkbox" value="38" />
								<label for="menu_id_42">新增权限界面 </label> 
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_43" class="check" name="powermenu" type="checkbox" value="39" />
								<label for="menu_id_43">编辑权限界面 </label>
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_44" class="check" name="powermenu" type="checkbox" value="42" />
								<label for="menu_id_44">角色列表界面</label>
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_45" class="check" name="powermenu" type="checkbox" value="43" />
								<label for="menu_id_45">新增角色界面</label>
							</div>
						</div>
						<div class="col-md-2">
							<div class="ckbox ckbox-primary">
								<input id="menu_id_46" class="check" name="powermenu" type="checkbox" value="44" />
								<label for="menu_id_46">编辑角色界面 </label>
							</div>
						</div>
					</div>
	            </div>
	        </div>
	    </div>
    </div><!-- panel-body -->
        
        <div class="panel-footer align-center">
        	<input id="editMenu" class="btn btn-primary" type="submit" value="保存"/>&nbsp;
			<input class="btn btn-default" type="button" id="btn-back" value="返回"/>&nbsp;
			<input type="hidden" name="menuID" value="" />
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
	jQuery(document).ready(function() {

		$(".nav-parent").eq(7).addClass("nav-active");
  		$(".nav-parent").eq(7).find(".children").show();

  		$(".selectall").change(function () {
  			if($(this).is(':checked')){
  				$(this).parents(".row").find("input[type='checkbox']").attr("checked",true);
  			}else{
  				$(this).parents(".row").find("input[type='checkbox']").attr("checked",false);
  			}
  		})
  		
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
		      $("#saveForm").attr("disabled","disabled");
		      form_submit();
		      return false;
		    }
		});

		$("#btn-back").click( function () {
			history.go(-1);
	    } ); 
		
	});
	
	function form_submit() {
		var name = document.getElementById("role_id").value;
		$.post('${rootPath}menu/addroleonly.do?name='+name, function(result) {
		     if (result.role_id!=null) {
			  	var f="";
			    var casemenu = $("[:checkbox][calss="check"]"); 
			    for (var i=0;i<casemenu.length;i++ ){
			       if(casemenu[i].checked){ //判断复选框是否选中
			       	  var f = f +result.role_id+" "+casemenu[i].value+",";
			       } 
			    } 
			    
			    f = f.substr(0,f.length-1);
				 $.post('${rootPath}menu/addrole.do',{"f":f}, function(result) {
				  	 var rmsg = result.msg;
				     if (result.success) {
					  	 window.parent.location = "${rootPath}menu/rolelist.html";
					  } else {
						  alert("角色分配权限出错");
						$("#msgModal").modal('show');
					  }
				  }, "JSON"); 
			  } else {
				alert("保存角色出错");
				$("#msgModal").modal('show');
			  }
		  }, "JSON");
	} 
	</script>
</body>
</html>
