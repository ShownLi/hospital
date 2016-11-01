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
					<i class="fa fa-user"></i> 客人管理 <span>新增客人</span>
				</h2>
			</div>

			<div class="contentpanel">
				<!-- content goes here... -->

		<div class="panel panel-default">
        <div class="panel-heading">
          <div class="panel-btns">
            <a href="" class="minimize">&minus;</a>
          </div>
          <h4 class="panel-title">客人信息</h4>
          <p>填写下表，完成客人创建。</p>
        </div>
        <form class="form-horizontal" id="form">
        <div class="panel-body panel-body-nopadding">
        	<div class="section-block">
        		<h5 class="section-title">客人基本信息</h5>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">中文名<span class="asterisk">*</span></label>
	              <div class="col-sm-9">
	                <input type="text" name="chineseName" placeholder="中文名" class="form-control" />
	              </div>
	            </div>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">英文名</label>
	              <div class="col-sm-9">
	                <input type="text" name="englishName" placeholder="英文名" class="form-control" />
	              </div>
	            </div> 
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label" >性别 <span class="asterisk">&nbsp;</span></label>
	              <div class="col-sm-9">
	                <div class="rdio rdio-primary rdio-inline">
	                  <input type="radio" id="male" value="male" name="gender">
	                  <label for="male">男</label>
	                </div><!-- rdio -->
	                <div class="rdio rdio-primary rdio-inline">
	                  <input type="radio" id="female" value="female" name="gender" >
	                  <label for="female">女</label>
	                </div><!-- rdio -->
	              </div>
	            </div>
	            <div class="form-group col-sm-4">
	            	<label class="col-sm-3 control-label">生日</label>
	            	<div class="col-sm-9 input-group input-datepicker">
		                <input type="text" name="birthday" class="datepicker form-control" placeholder="yyyy/mm/dd" id="birthday" autocomplete="off">
		                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
	                </div>
	            </div> 
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label" >年龄段</label>
	              <div class="col-sm-9">
	                <input type="text" name="ageGroup" placeholder="请选择一个年龄段" class="agegroup-select fullwidth" />
	              </div>
	            </div>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">客人级别</label>
	              <div class="col-sm-9">
	                <input type="text" name="level" placeholder="客人级别" class="level-select fullwidth" value="0" />
	              </div>
	            </div> 
	        </div>
	        <div class="section-block">
	        	<h5 class="section-title">客人联系方式  <span class="contact-note">(手机、微信、QQ、邮箱至少填写一个)</span></h5>
	            <div class="form-group col-sm-4 contact-field">
	              <label class="col-sm-3 control-label">固定电话</label>
	              <div class="col-sm-9">
	                <input type="text" name="telephone" placeholder="固定电话" class="form-control" />
	              </div>
	            </div>
	            <div class="form-group col-sm-4 contact-field">
	              <label class="col-sm-3 control-label">手机</label>
	              <div class="col-sm-9">
	                <input type="text" name="mobilephone" placeholder="手机" class="form-control" />
	              </div>
	            </div>    
	            <div class="form-group col-sm-4 contact-field">
	              <label class="col-sm-3 control-label">微信</label>
	              <div class="col-sm-9">
	                <input type="text" name="wechat" placeholder="微信" class="form-control" />
	              </div>
	            </div>       
	            <div class="form-group col-sm-4 contact-field">
	              <label class="col-sm-3 control-label">QQ</label>
	              <div class="col-sm-9">
	                <input type="text" name="qq" placeholder="QQ" class="form-control" />
	              </div>
	            </div>            
	            <div class="form-group col-sm-4 contact-field">
	              <label class="col-sm-3 control-label">邮箱</label>
	              <div class="col-sm-9">
	                <input type="text" name="email" placeholder="邮箱" class="form-control"  />
	              </div>
	            </div>  
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">所在地</label>
	              <div class="col-sm-9">
	                <input type="text" name="location" placeholder="所在地" class="form-control" />
	              </div>
	            </div> 
	        </div>
	        <div class="section-block"> 
	        	<h5 class="section-title">其他</h5>   
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label" >客人来源 </label>
	              <div class="col-sm-9">
	                <input type="text" name="source" class="promote-select fullwidth" />
	              </div>
	            </div>
	        </div>   
        </div><!-- panel-body -->
        
        <div class="panel-footer align-center">
			<button class="btn btn-primary">保存</button>&nbsp;
			<button class="btn btn-default" id="btn-back">取消</button>
		</div><!-- panel-footer -->
     </form>   
      </div><!-- panel -->

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

<div class="nextModal modal fade" id="nextModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">您可以继续添加询单，或返回到客人列表页面</div>
      </div>
      <div class="modal-body align-center">
        	<a id="addCase" class="btn btn-primary" href="${rootPath}case/addCase.html?customerId=">添加询单</a>
        	<a class="btn btn-primary" href="${rootPath}customer/list.html">返回列表</a>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->


	<%@ include file="../assets/pages/foot.jsp"%>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/datepicker-zh-CN.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript">
		var level = ${level};
		var source = ${source};
		var ageGroup = ${ageGroup};
		$(".promote-select").select2({
			placeholder: '选择一个推广渠道',
		  	data: source
		});
		$(".agegroup-select").select2({
			placeholder: '选择一个年龄段',
		  	data: ageGroup
		});
		$(".level-select").select2({
		  	data: level
		});	
		
		jQuery(document).ready(function() {		
			// left menu expose  
			$(".nav-parent").eq(2).addClass("nav-active");
      		$(".nav-parent").eq(2).find(".children").show();

			// Date Picker
			jQuery(".datepicker").datepicker({
				dateFormat: "yy-mm-dd",
				changeYear: true,
				changeMonth: true,
				maxDate: 0,
			});
			
			jQuery("#form").validate({
				rules: {
					chineseName: "required",
					qq: "number",
					email: "email",
					birthday: "date",
					source: "required",
					mobilephone:{
						isMobile:true,
					}					
				},
				messages: {
					chineseName: "请输入中文名",
					qq: "请输入有效的QQ账号",
					email: "请输入有效的邮箱",
					birthday: "请输入正确的日期",
					source: "请选择一个客人来源"
				},
				
			    highlight: function(element) {
			      jQuery(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			    },
			    success: function(element) {
			      jQuery(element).closest('.form-group').removeClass('has-error');
			    },
			    invalidHandler : function(){
			        var qq = $.trim($("input[name=qq]").val()),
			    		wechat = $.trim($("input[name=wechat]").val()),
			    		mobilephone = $.trim($("input[name=mobilephone]").val()),
			    		email = $.trim($("input[name=email]").val()),
			    		telephone = $.trim($("input[name=telephone]").val());

			    	// 手机，邮箱，微信，QQ，至少输入一个
			      	if(qq==""&&wechat==""&&mobilephone==""&&email==""&&telephone==""){
			      		$(".contact-note").addClass("noted");
			      		$(".contact-field").addClass("has-error");
			      	}else{
			      		$(".contact-note").removeClass("noted");
			      		$(".contact-field").removeClass("has-error");
				    }
			      return false;
			    },
			    submitHandler : function(){
			    	var qq = $.trim($("input[name=qq]").val()),
		    			wechat = $.trim($("input[name=wechat]").val()),
		    			mobilephone = $.trim($("input[name=mobilephone]").val()),
		    			email = $.trim($("input[name=email]").val()),
		    			telephone = $.trim($("input[name=telephone]").val());

			    	// 手机，邮箱，微信，QQ，至少输入一个
			      	if(qq==""&&wechat==""&&mobilephone==""&&email==""&&telephone==""){
			      		$(".contact-note").addClass("noted");
			      		$(".contact-field").addClass("has-error");
			      		return false;
			      	}else{
			      		$(".contact-note").removeClass("noted");
			      		$(".contact-field").removeClass("has-error");
				      	form_submit();
				      	return false;
				    }
				}
			});
			
			//验证手机号码
			jQuery.validator.addMethod("isMobile", function(value, element) {  
    			var length = value.length;  
    			var regPhone = /^1([3578]\d|4[57])\d{8}$/;  
    			return this.optional(element) || ( length == 11 && regPhone.test( value ) );    
			}, "请正确填写您的手机号码");

			// 手机，邮箱，微信，QQ，输入一个以后移除错误提示
			$(".contact-field").find("input").blur(function(){
				if($.trim($(this).val()) !== ""){
					$(".contact-field").removeClass("has-error");
				}
			});

			$("#btn-back").click( function () {
				history.go(-1);
		    }); 
		});
			      
		function form_submit() {
			var f = $("#form").serialize();
			$.post('${rootPath}customer/add.do', f, function(result) {
				var customerId = result.obj.customerId;
				var rmsg = result.msg;
				
				//弹出modal询问直接添加询单还是跳转到list页面
				/* if (result.success) {
					$("#nextModal").modal('show');
					//添加询单的url需要该客人的id
			      	var href = $("#addCase").attr("href");
			      	$("#addCase").attr("href",href+customerId);
				} else {
					$("#msgModal").modal('show');
				} */
				
				if (result.success) {
					window.parent.location = "${rootPath}customer/list.html";
			      	
				} else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
	</script>


</body>
</html>
