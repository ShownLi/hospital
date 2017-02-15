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
					<i class="fa fa-group"></i> 销售管理 <span>新增销售</span>
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
          <p>填写下表，完成销售创建。</p>
        </div>
         <form class="form-horizontal form-bordered" action="${rootPath}sale/add.do" id="form" method="post" enctype="multipart/form-data">
        <div class="panel-body panel-body-nopadding">
            <div class="form-group col-sm-4">
              <label class="col-sm-4 control-label">销售名称 <span class="asterisk">*</span></label>
              <div class="col-sm-8">
                <input type="text" name="salesName" placeholder="销售名" class="form-control" value="${sales.salesName }" />
                <input type="text" name="salesId" placeholder="销售名" class="form-control" value="${sales.salesId}" style="display:none" />
              </div>
            </div>
            <div class="form-group col-sm-4">
              <label class="col-sm-4 control-label">职称</label>
              <div class="col-sm-8">
                <input type="text" name="title" placeholder="职称" class="form-control" value="${sales.title}" />
              </div>
            </div>
            <div class="form-group col-sm-4">
              <label class="col-sm-4 control-label">PortalID <span class="asterisk">*</span></label>
              <div class="col-sm-8">
                <input type="text" id="salesPortalId" name="salesPortalId" placeholder="官网ID" class="form-control" value="${sales.salesPortalId }"/>
              </div>
            </div>       
            <div class="form-group col-sm-4">
              <label class="col-sm-4 control-label">所属地接社 <span class="asterisk">*</span></label>
              <div class="col-sm-8">
                <input type="text" name="agencyId" class="agency-select col-sm-12" value="${sales.agencyId }" readonly/>
              </div>
            </div>               
            <div class="form-group col-sm-4">
              <label class="col-sm-4 control-label">邮件地址 <span class="asterisk">*</span></label>
              <div class="col-sm-8">
                <input type="text" name="salesEmail" placeholder="邮件地址" class="form-control" value="${sales.salesEmail }" />
              </div>
            </div>      
            <div class="form-group col-sm-4">
              <label class="col-sm-4 control-label">电话</label>
              <div class="col-sm-8">
                <input type="text" name="telephone" placeholder="电话" class="form-control" value="${sales.telephone }" />
              </div>
            </div>      
            <div class="form-group col-sm-4" style="clear: both;">
              <label class="col-sm-4 control-label">手机</label>
              <div class="col-sm-8">
                <input type="text" name="mobilephone" placeholder="手机" class="form-control" value="${sales.mobilephone }" />
              </div>
            </div>      
            <div class="form-group col-sm-4">
              <label class="col-sm-4 control-label">传真</label>
              <div class="col-sm-8">
                <input type="text" name="fax" placeholder="邮件地址" class="form-control" value="${sales.fax }" />
              </div>
            </div>      
            <div class="form-group col-sm-4">
              <label class="col-sm-4 control-label">QQ</label>
              <div class="col-sm-8">
                <input type="text" name="qq" placeholder=QQ class="form-control" value="${sales.qq }" />
              </div>
            </div>      
            <div class="form-group col-sm-4">
              <label class="col-sm-4 control-label">skype</label>
              <div class="col-sm-8">
                <input type="text" name="skype" placeholder="skype" class="form-control" value="${sales.skype }" />
              </div>
            </div>      
            <div class="form-group col-sm-4">
              <label class="col-sm-4 control-label">微信 </label>
              <div class="col-sm-8">
                <input type="text" name="wechat" placeholder="微信" class="form-control" value="${sales.wechat}" />
              </div>
            </div>      
            <div class="form-group col-sm-4">
              <label class="col-sm-4 control-label">销售专长</label>
              <div class="col-sm-8">
                <input type="text" name="skill" placeholder="销售专长" class="form-control" value="${sales.skill }" />
              </div>
            </div>      
            <div class="form-group col-sm-4">
              <label class="col-sm-4 control-label">销售介绍</label>
              <div class="col-sm-8">
                <input type="text" name="introduction" placeholder="销售介绍" class="form-control" value="${sales.introduction }" />
              </div>
            </div> 
            <div class="form-group col-sm-4">
              <label class="col-sm-4 control-label">销售照片</label>
              <div class="col-sm-2">
					       <input type="file" name="upphoto" title="请选择照片" />
              </div>
            </div>
            <div class="form-group col-sm-4">
              <label class="col-sm-4 control-label">销售名片</label>
              <div class="col-sm-2">
					<input type="file"  name="upnamecard" title="请选择照片" />
              </div>
            </div>
            <div class="form-group col-sm-4" style="clear: both;">
              <label class="col-sm-4 control-label">地址</label>
              <div class="col-sm-8">
                <input type="text" name="address" placeholder="地址" class="form-control" value="${sales.address }" />
              </div>
            </div>      
        </div><!-- panel-body -->
        <div class="panel-footer align-center">
        	<input class="btn btn-primary" type="submit" value="保存"/>&nbsp;
			<input class="btn btn-default" type="button" id="btn-back" value="返回"/>&nbsp;
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
	var a = ${agency};
	
	$(".agency-select").select2({
		placeholder: '选择一个地接社',
	  	data: a
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
	                        name: function () { return $("#salesPortalId").val();},
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
		/* function form_submit() {
			var f = $("#form").serialize();
			$.post('${rootPath}sale/add.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}agency/edit.html?id=${agencyId}";
				} else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		} */
	
		
	</script>

</body>
</html>
