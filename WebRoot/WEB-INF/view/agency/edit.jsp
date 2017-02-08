<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../assets/pages/head.jsp"%>
<link href="${rootPath }assets/css/jquery.datatables.css" rel="stylesheet">
</head>

<body class="leftpanel-collapsed">
	<%@ include file="../assets/pages/preloader.jsp"%>
	<section>
		<%@ include file="../assets/pages/leftpanel.jsp"%>
		<div class="mainpanel">
			<%@ include file="../assets/pages/headerbar.jsp"%>
			<div class="pageheader">
				<h2>
					<i class="glyphicon glyphicon-briefcase"></i> 地接社管理 <span>编辑地接社</span>
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
          				<p>填写下表，完成地接社信息修改。</p>
        			</div>
       		
		       	 	<form class="form-horizontal" id="form-agency">
		       	 	
		       			<div class="panel-body panel-body-nopadding">
		          			<div class="section-block">
			            		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">地接社名称 <span class="asterisk">*</span></label>
			              			<div class="col-sm-8">
			              				<input type="text" id="agencyName" name="name" placeholder="地接社名称" class="form-control" value="${agency.name}" />
			              			</div>
			              		</div>         
			            		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">英文名称 <span class="asterisk"></span></label>
			              			<div class="col-sm-8">
			              				<input type="text" id="nameEn" name="nameEn" placeholder="地接社英文名称" class="form-control" value="${agency.nameEn}" />
			              			</div>
			              		</div>         
			            		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">服务类型<span class="asterisk"></span></label>
			              			<div class="col-sm-8">
									<input name="service" class="service-select fullwidth" value="${agency.service}">
			              			</div>
			              		</div>         
			            		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">语言</label>
			               			<div class="col-sm-8">
			               				<input type="text" id="language" name="language" class="language-select fullwidth" value="${agency.language }"/>
			               			</div>
			            		</div> 
			            		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">旅行社来源<span class="asterisk"></span></label>
			              			<div class="col-sm-8">
										<input name="source" class="source-select fullwidth"  value="${agency.source}">
			              			</div>
			              		</div>  
			              		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">公司网址 <span class="asterisk"></span></label>
			              			<div class="col-sm-8">
			              				<input type="text" id="website" name="website" placeholder="公司网址" class="form-control" value="${agency.website }" />
			              			</div>
			              		</div>  
			              		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">所在地 <span class="asterisk"></span></label>
			              			<div class="col-sm-8">
			              				<input type="text" id="location" name="location" placeholder="所在地" class="form-control" value="${agency.location }" />
			              			</div>
			              		</div>  
			              		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">成立时间</label>
			              			<div class="col-sm-8 input-group input-datepicker">
									<input type="text" id="foundTime" name="foundTime"
										class="form-control datepicker" placeholder="yyyy/mm/dd"
										value="${agency.foundTime}" autocomplete="off"> <span
										class="input-group-addon"><i
										class="glyphicon glyphicon-calendar"></i></span>
									</div>
			              		</div>  
			              		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">银行账号 <span class="asterisk"></span></label>
			              			<div class="col-sm-8">
			              				<input type="text" id="account" name="account" placeholder="银行账号" class="form-control" value="${agency.account }" />
			              			</div>
			              		</div>  
			              		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">币种<span class="asterisk"></span></label>
			              			<div class="col-sm-8">
										<input name="currency" class="currency-select fullwidth" value="${agency.currency}">
			              			</div>
			              		</div>
			              		 <div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">开户行 <span class="asterisk"></span></label>
			              			<div class="col-sm-8">
			              				<input type="text" id="bank" name="bank" placeholder="开户行" class="form-control" value="${agency.bank}" />
			              			</div>
			              		</div> 
			              		 <div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">付款方式<span class="asterisk"></span></label>
			              			<div class="col-sm-8">
										<input name="payment" class="payment-select fullwidth" value="${agency.payment}">
			              			</div>
			              		</div>
			              		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">公司执照 <span class="asterisk"></span></label>
			              			<div class="col-sm-8">
			              				<input type="text" id="license" name="license" placeholder="公司执照" class="form-control" value="${agency.license}" />
			              			</div>
			              		</div>
			              		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">评定总分 <span class="asterisk"></span></label>
			              			<div class="col-sm-8">
			              				<input type="text" id="score" name="score" placeholder="评定总分" class="form-control" value="${agency.score}" />
			              			</div>
			              		</div>
			              		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">状态 <span class="asterisk"></span></label>
			              			<div class="col-sm-8">
			              				<input name="status" class="status-select fullwidth" value="${agency.status}">
			              			</div>
			              		</div>
			              		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">公司介绍 <span class="asterisk"></span></label>
			              			<div class="col-sm-8">
			              				<input type="text" id="introduction" name="introduction" placeholder="公司介绍" class="form-control" value="${agency.introduction}" />
			              			</div>
			              		</div>
			            		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">国家</label>
			              			<div class="col-sm-8">
			              				<input type="text" id="country" name="country" class="country-select fullwidth" value="${agency.country }"/>
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
							<input id="editAgency" class="btn btn-primary" type="submit" value="保存"/>&nbsp;
							<input class="btn btn-default" type="button" id="btn-back" value="取消"/>&nbsp;
							<input type="hidden" name="agencyId" value="${agency.agencyId}" />
						</div><!-- panel-footer -->
		     		</form>   
      			</div><!-- panel -->

 		<!-- panel 销售列表 -->
      			<div class="panel panel-default">
          		<div class="panel-heading">
          		<div class="panel-btns">
              		<a href="" class="minimize">&minus;</a>
          		</div>
          			<h4 class="panel-title">销售列表 </h4>
          		</div>
          		<div class="panel-body">
	              	<table id="dataTable" class="table">
						<thead>
							<tr>
								<th>ID</th>
								<th>Portal  ID</th>
								<th>姓名</th>
								<th>邮箱</th>
								<th>编辑</th>
							</tr>
						</thead>
					</table>
          		</div>
          		<div class="panel-footer align-center">
					<a class="btn btn-primary" href="${rootPath}sale/add.html?agencyId=${agency.agencyId}">新增销售</a>
      			</div>
				</div>
				<!-- end of panel 沟通列表 -->
			</div>
		</div>
		<!-- mainpanel -->
		<%@ include file="../assets/pages/rightpanel.jsp"%>
	</section>


		<!-- Modal 保存数据出错-->
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

		<!-- Modal 删除确认-->
		<div class="modal fade" id="confirmDelModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
		  <div class="modal-dialog modal-sm">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title" id="myModalLabel"><span class="fa fa-warning"></span> 提示</h4>
		      </div>
		      <div class="modal-body">
		        确定删除么？
		      </div>
		      <div class="modal-footer">
		      	<input type="hidden" class="hiddenId" value="" />
		        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		        <button type="button" class="btn btn-danger">删除</button>
		      </div>
		    </div><!-- modal-content -->
		  </div><!-- modal-dialog -->
		</div><!-- modal -->

		<!-- Modal -->
		<div class="modal fade" id="notDelModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
		  <div class="modal-dialog modal-sm">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title" id="myModalLabel"><span class="fa fa-warning"></span> 提示</h4>
		      </div>
		      <div class="modal-body">
		       		 当前地接社存在订单，不能删除！
		      </div>
		      <div class="modal-footer">
		      	<input type="hidden" class="hiddenId" value="" />
		        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
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
	var isSendmail= ${sendmail};
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
    
    $(".destination-select").val('${agency.destination}'.split(",")).trigger("change");
	if("${agency.isSendmail}"==1){
    	$('#yes').attr('checked','true');
    }else{
    	$('#no').attr('checked','true');
    }

	jQuery(document).ready(function() {
		
		$(".nav-parent").eq(3).addClass("nav-active");
      	$(".nav-parent").eq(3).find(".children").show();
      	
		jQuery("#form-agency").validate({
			rules: {
				name: {  
		         	required:true,  
		            remote:{                           
		            	url:"${rootPath}validate.do",
		            	type:"post",
		            	data: {
	                         table: function () { return "tm_agency"},
	                         field: function () { return "agency_name"},
	                         name: function () {
	                        	 
	                        	  if($("#agencyName").val()=="${agency.name}"){
		                        	 	return "";
		                        	 }
		                        	 else{return $("#agencyName").val();} 
	                        	
	                         	}
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
		      $("#editAgency").attr("disabled","disabled");
		      form_submit();
		      return false;
		    }
		  });
		
		
		$("#btn-back").click( function () {
			window.location = "${rootPath}agency/list.html?flag=old";
	    } ); 
		
	});
			      
	function form_submit() {
		var agencyInfo= $("#form-agency").serialize();
		$.post('${rootPath}agency/edit.do', agencyInfo, function(result) {
			var rmsg = result.msg;
			if (result.success) {
				window.parent.location =  "${rootPath}agency/edit.html?id=${agency.agencyId}";
				} 
			else {
				$("#msgModal").modal('show');
				}
			}, "JSON");
		}
		
	var t = jQuery('#dataTable').DataTable({
		searching:false,
		paging: false,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		bInfo:false,
		ajax: {
			url: '${rootPath}sale/list.do?agencyId=${agency.agencyId}',
			dataFilter: function(data){
			    var json = jQuery.parseJSON( data );
			    json.recordsTotal = json.countTotal;
			    json.recordsFiltered = json.countFiltered;
			    json.data = json.data;
			    return JSON.stringify( json );
		    	}
			},
		columnDefs: [
			{
	            data: "salesId",
	            orderable: false,
	            render: function ( data, type, full, meta ) {
	            	return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>&nbsp;<a class="btn btn-danger btn-xs" id="'+data+'"><span class="fa fa-minus-circle"></span> 删除</a>';
	            	},
	            targets: 4
			},
			],
		columns: [
			{ data: "salesId" },
		    { data: "salesPortalId" },
		    { data: "salesName" },
		    { data: "salesEmail" }
	    ]
		});
	$('#dataTable tbody').on( 'click', 'a.btn-success', function () {
		var data = t.row($(this).parents('tr')).data();
	    edit($(this).attr('id'));
	    });

	$('#dataTable tbody').on( 'click', 'a.btn-danger', function () {
	    var data = t.row($(this).parents('tr')).data();
	    del($(this).attr('id'));
	    });
		
	$('#confirmDelModal').on( 'click', 'button.btn-danger', function () {
	    var id = $("#confirmDelModal .hiddenId").val();
	    doDel(id);
	}); 
	    
		// Select2
	jQuery('select').select2({
		minimumResultsForSearch: -1
		});
	    
	jQuery('select').removeClass('form-control');
	
	function edit(id) {
		window.parent.location = "${rootPath}sale/edit.html?id="+id;
	}
	
	function del(id) {
		$("#confirmDelModal .hiddenId").val("");
		$("#confirmDelModal .hiddenId").val(id);
		$("#confirmDelModal").modal('show');
	}
	
	function doDel(id){
		$.ajax({
			url: "${rootPath}sale/del.do?id=" + id, 
			async: true,
			success: function() {
				window.location.reload();
			},
			error: function() {
				alert(2);
			}
		});
	}
</script>

</body>
</html>
