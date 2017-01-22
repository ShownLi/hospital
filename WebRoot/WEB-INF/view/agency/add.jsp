<%@ page language="java" pageEncoding="utf-8"%>
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
             			<label class="col-sm-4 control-label">英文名称 <span class="asterisk"></span></label>
             			<div class="col-sm-8">
             				<input type="text" id="nameEn" name="nameEn" placeholder="地接社英文名称" class="form-control" />
             			</div>
             		</div>         
           		<div class="form-group col-sm-4">
             			<label class="col-sm-4 control-label">服务类型<span class="asterisk"></span></label>
             			<div class="col-sm-8">
					<input name="service" class="service-select fullwidth">
             			</div>
             		</div>         
           		<div class="form-group col-sm-4">
             			<label class="col-sm-4 control-label">语言</label>
              			<div class="col-sm-8">
              				<input type="text" id="language" name="language" class="language-select fullwidth"/>
              			</div>
           		</div> 
           		<div class="form-group col-sm-4">
             			<label class="col-sm-4 control-label">旅行社来源<span class="asterisk"></span></label>
             			<div class="col-sm-8">
						<input name="source" class="source-select fullwidth">
             			</div>
             		</div>  
             		<div class="form-group col-sm-4">
             			<label class="col-sm-4 control-label">公司网址 <span class="asterisk"></span></label>
             			<div class="col-sm-8">
             				<input type="text" id="website" name="website" placeholder="公司网址" class="form-control" />
             			</div>
             		</div>  
             		<div class="form-group col-sm-4">
             			<label class="col-sm-4 control-label">所在地 <span class="asterisk"></span></label>
             			<div class="col-sm-8">
             				<input type="text" id="location" name="location" placeholder="所在地" class="form-control" />
             			</div>
             		</div>  
             		<div class="form-group col-sm-4">
             			<label class="col-sm-4 control-label">成立时间</label>
             			<div class="col-sm-8 input-group input-datepicker">
					<input type="text" id="foundTime" name="foundTime"
						class="form-control datepicker" placeholder="yyyy/mm/dd"
						autocomplete="off"> <span
						class="input-group-addon"><i
						class="glyphicon glyphicon-calendar"></i></span>
					</div>
             		</div>  
             		<div class="form-group col-sm-4">
             			<label class="col-sm-4 control-label">银行账号 <span class="asterisk"></span></label>
             			<div class="col-sm-8">
             				<input type="text" id="account" name="account" placeholder="银行账号" class="form-control" />
             			</div>
             		</div>  
             		<div class="form-group col-sm-4">
             			<label class="col-sm-4 control-label">币种<span class="asterisk"></span></label>
             			<div class="col-sm-8">
						<input name="currency" class="currency-select fullwidth">
             			</div>
             		</div>
             		 <div class="form-group col-sm-4">
             			<label class="col-sm-4 control-label">开户行 <span class="asterisk"></span></label>
             			<div class="col-sm-8">
             				<input type="text" id="bank" name="bank" placeholder="开户行" class="form-control" />
             			</div>
             		</div> 
             		 <div class="form-group col-sm-4">
             			<label class="col-sm-4 control-label">付款方式<span class="asterisk"></span></label>
             			<div class="col-sm-8">
						<input name="payment" class="payment-select fullwidth">
             			</div>
             		</div>
             		<div class="form-group col-sm-4">
             			<label class="col-sm-4 control-label">公司执照 <span class="asterisk"></span></label>
             			<div class="col-sm-8">
             				<input type="text" id="license" name="license" placeholder="公司执照" class="form-control" />
             			</div>
             		</div>
             		<div class="form-group col-sm-4">
             			<label class="col-sm-4 control-label">评定总分 <span class="asterisk"></span></label>
             			<div class="col-sm-8">
             				<input type="text" id="score" name="score" placeholder="评定总分" class="form-control" />
             			</div>
             		</div>
             		<div class="form-group col-sm-4">
             			<label class="col-sm-4 control-label">状态 <span class="asterisk"></span></label>
             			<div class="col-sm-8">
             				<input name="status" class="status-select fullwidth">
             			</div>
             		</div>
             		<div class="form-group col-sm-4">
             			<label class="col-sm-4 control-label">公司介绍 <span class="asterisk"></span></label>
             			<div class="col-sm-8">
             				<input type="text" id="introduction" name="introduction" placeholder="公司介绍" class="form-control"/>
             			</div>
             		</div>
           		<div class="form-group col-sm-4">
             			<label class="col-sm-4 control-label">国家</label>
             			<div class="col-sm-8">
             				<input type="text" id="country" name="country" class="country-select fullwidth" />
             			</div>
           		</div>
           		<div class="form-group col-sm-4">
	              <label  class="col-sm-4 control-label">目的地</label>
	              <div class="col-sm-8">
	                <select name="destination" class="destination-select fullwidth" multiple="multiple" >
					</select>
	              </div>
	            </div>
           		<div class="form-group col-sm-4">
	              <label  class="col-sm-4 control-label">是否发邮件</label>
	              <div class="col-sm-8">
	                   <input type="radio" id="yes" name="isSendmail" value="1" />是
      				   <input type="radio" id="no" name="isSendmail" value="0"/>否
	              </div>
	            </div>            
       		</div>
        </div><!-- panel-body -->
        <div class="panel-footer align-center">
			<input id="addAgency" class="btn btn-primary" type="submit" value="保存"/>&nbsp;
			<input class="btn btn-default" type="button" id="btn-back" value="取消"/>
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
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/datepicker-zh-CN.js"></script>
	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript">
	var country = ${country};
	var language= ${language};
	var service= ${agencyService};
	var source= ${source};
	var currency= ${currency};
	var payment= ${payment};
	var statusA= ${status};
	//var agency= ${agency};
	
	//返回到list.html记录数
	var backNum = -1;
	$(".country-select").select2({
	  	data: country
	})
	$(".language-select").select2({
	  	data: language
	})
	$(".destination-select").select2({
    	placeholder: '可多选',
    	minimumResultsForSearch: Infinity,
    	data: country
     });
	$(".service-select").select2({
		minimumResultsForSearch: Infinity,
		placeholder:'选择服务类型',
    	data: service
     });
	$(".source-select").select2({
		minimumResultsForSearch: Infinity,
		placeholder:'选择来源',
    	data: source
     });
	$(".currency-select").select2({
		minimumResultsForSearch: Infinity,
		placeholder:'选择币种',
    	data: currency
     });
	$(".payment-select").select2({
		minimumResultsForSearch: Infinity,
		placeholder:'选择付款方式',
    	data: payment
     });
	$(".status-select").select2({
		minimumResultsForSearch: Infinity,
		placeholder:'选择状态',
    	data: statusA
     });
	jQuery("#foundTime").datepicker({
        dateFormat: "yy-mm-dd",
        changeYear: true,
        changeMonth: true,
      });
	
	//成立时间格式转换
    var date = $("#foundTime").val();  
    if(date !== ""){
      var dateformat = new Date(date).toISOString("yyyy-MM-dd hh:mm:ss.S").substring(0,10);
      $("#foundTime").val(dateformat);
    }
    //$(".destination-select").val('${crmcase.destination}'.split(",")).trigger("change");
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
		      $("#addAgency").attr("disabled","disabled");
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
