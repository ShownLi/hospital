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
					<i class="fa fa-user"></i> 权限管理 <span>编辑角色</span>
				</h2>
			</div>
			<div class="contentpanel">
				<!-- content goes here... -->

		<div class="panel panel-default">
        <div class="panel-heading">
          <div class="panel-btns">
            <a href="" class="minimize">&minus;</a>
          </div>
          <h4 class="panel-title">编辑角色</h4>
          <p>填写下表，完成角色信息修改。</p>
        </div>
        <form class="form-horizontal" id="form">
        <div class="panel-body panel-body-nopadding">
          
	        <div class="section-block"> 
	           <div class="form-group col-sm-6">
	              <label class="col-sm-3 control-label">角色名称</label>
	              <div class="col-sm-4">
					<input type="text" name="role_id" id="role_id" placeholder="请输入角色名称" class="form-control" value="${role.role_name}" />   
                  </div>
	            </div>
	            <div>
	           		<div class="container">
		           		<div class="row">
							<h4 class="col-md-12" style="margin-top: 20px; color: #000;">主菜单</h4>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input id="selectall1" class="selectall" type="checkbox" value="" />
									<label for="selectall1">全选 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="1" />
									<label>系统登录界面 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="2" />
									<label>系统主界面 </label>
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="40" />
									<label>系统退出页面 </label> 
								</div>
							</div>
						</div>
						<div class="row">
							<h4 class="col-md-12" style="margin-top: 20px; color: #000;">询单栏列表</h4><div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input id="selectall2" class="selectall" type="checkbox" value="" />
									<label for="selectall2">全选 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="3" />
									<label>询单展示列表界面 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="4" />
									<label>新增询单界面 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="5" />
									<label>编辑询单页面 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="18" />
									<label>用户列表新增询单界面 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="19" />
									<label>询单处理界面 </label>
								</div>
							</div>
						</div>
						<div class="row">
							<h4 class="col-md-12" style="margin-top: 20px; color: #000;">订单栏列表</h4><div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input id="selectall3" class="selectall" type="checkbox" value="" />
									<label for="selectall3">全选 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="6" />
									<label>订单展示列表界面 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="7" />
									<label>新增询订单界面 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="8" />
									<label>编辑订单页面 </label> 
								</div>
							</div>
						</div>
						<div class="row">
							<h4 class="col-md-12" style="margin-top: 20px; color: #000;">客人栏列表</h4><div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input id="selectall4" class="selectall" type="checkbox" value="" />
									<label for="selectall4">全选 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="9" />
									<label>客人展示列表界面 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="10" />
									<label>新增客人界面 </label>
								</div>
							</div> 
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="11" />
									<label>编辑客人页面 </label> 
								</div>
							</div>
						</div>
						<div class="row">
							<h4 class="col-md-12" style="margin-top: 20px; color: #000;">地接社栏列表</h4>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input id="selectall5" class="selectall" type="checkbox" value="" />
									<label for="selectall5">全选 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="12" />
									<label>地接社展示列表界面 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="13" />
									<label>新增地接社界面 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="14" />
									<label>编辑地接社页面 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="45" />
									<label>新增销售界面 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="46" />
									<label>编辑销售界面 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="47" />
									<label>销售列表界面 </label> 
								</div>
							</div>
						</div>
						<div class="row">
							<h4 class="col-md-12" style="margin-top: 20px; color: #000;">用户栏列表</h4><div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input id="selectall0" class="selectall" type="checkbox" value="" />
									<label for="selectall0">全选 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="15" />
									<label>用户展示列表界面 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="16" />
									<label>新增用户界面 </label>
								</div>
							</div> 
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="17" />
									<label>编辑用户页面 </label> 
								</div>
							</div>
						</div>
						<div class="row">
							<h4 class="col-md-12" style="margin-top: 20px; color: #000;">统计栏列表</h4><div class="col-md-3">
								<div class="ckbox ckbox-primary">
									<input id="selectall6" class="selectall" type="checkbox" value="" />
									<label for="selectall6">全选 </label> 
								</div>
							</div>
							<div class="col-md-3">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="20" />
									<label>询单来源状态统计界面 </label> 
								</div>
							</div>
							<div class="col-md-3">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="21" />
									<label>沟通方式统计界面 </label> 
								</div>
							</div>
							<div class="col-md-3">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="22" />
									<label>询单分配统计界面</label> 
								</div>
							</div>
							<div class="col-md-3">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="23" />
									<label>流失原因统计界面 </label> 
								</div>
							</div>
							<div class="col-md-3">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="24" />
									<label>地接社业绩统计界面 </label> 
								</div>
							</div>
							<div class="col-md-3">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="25" />
									<label>跟单员询单状态统计界面 </label> 
								</div>
							</div>
							<div class="col-md-3">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="26" />
									<label>跟单员业绩统计 </label> 
								</div>
							</div>
							<div class="col-md-3">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="27" />
									<label>目的地询单状态统计界面 </label> 
								</div>
							</div>
							<div class="col-md-3">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="28" />
									<label>目的地咨询、成交统计界面 </label> 
								</div>
							</div>
							<div class="col-md-3">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="29" />
									<label>客人来源统计界面 </label> 
								</div>
							</div>
							<div class="col-md-3">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="30" />
									<label>客人来源级别统计界面 </label> 
								</div>
							</div>
							<div class="col-md-3">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="31" />
									<label>商家覆盖统计界面 </label> 
								</div>
							</div>
							<div class="col-md-3">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="32" />
									<label>商家未询统计界面 </label> 
								</div>
							</div>
							<div class="col-md-3">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="33" />
									<label>地接社订单状态统计界面 </label> 
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
									<input name="menu_id" type="checkbox" value="35" />
									<label>系统参数列表界面 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="35" />
									<label>新增系统参数界面 </label>
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary"> 
									<input name="menu_id" type="checkbox" value="36" />
									<label>编辑系统参数界面 </label>
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
									<input name="menu_id" type="checkbox" value="37" />
									<label>权限列表界面 </label>
								</div>
							</div> 
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="38" />
									<label>新增权限界面 </label> 
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="39" />
									<label>编辑权限界面 </label>
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="42" />
									<label>角色列表界面</label>
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="43" />
									<label>新增角色界面</label>
								</div>
							</div>
							<div class="col-md-2">
								<div class="ckbox ckbox-primary">
									<input name="menu_id" type="checkbox" value="44" />
									<label>编辑角色界面 </label>
								</div>
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
	var menuList = ${menuList};
    //判断权限是否已被分配
	for(var i=0; i<menuList.length; i++){
		var a = menuList[i];
		var b = $("input[name='menu_id']");
		$("input[name='menu_id'][value='"+a+"']").attr("checked","true");
	}
    
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
	    var f="";
	    var casemenu = document.getElementsByName('menu_id');
	    var rolename = document.getElementById('role_id').value;
	    for (var i=0;i<casemenu.length;i++ ){
	       if(casemenu[i].checked){ //判断复选框是否选中
	       var f = f + ${role.role_id} +" "+casemenu[i].value+" "+rolename+",";
	     }
	 }
	 f = f.substr(0,f.length-1);
	 $.post('${rootPath}menu/roleedit.do?f='+f, function(result) {
	  	 var rmsg = result.msg;
	     if (result.success) {
		  	//window.parent.location = "${rootPath}menu/list.html";
		  	alert("保存成功");
		  } else {
			$("#msgModal").modal('show');
		  }
	  }, "JSON");
	}
	</script>
</body>
</html>
