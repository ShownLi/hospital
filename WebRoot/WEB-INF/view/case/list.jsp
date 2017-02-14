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
					<i class="fa fa-user"></i> 询单管理 <span>询单列表</span>
				</h2>				 
			</div>
			
			<div class="contentpanel">
				<!-- content goes here... -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-btns">
							<a href="" class="minimize">&minus;</a>
						</div>
						<!-- panel-btns -->
						<h3 class="panel-title">询单列表</h3>
						<div class="row" style="margin-top: 20px">
							<div class="form-group col-sm-10">
								<div class="col-sm-2">
									<input type="text" name="caseId" id="searchCaseId" class="form-control" placeholder="询单id"  value="${searchCase.caseId }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchCustomerName" class="form-control" placeholder="客人" value="${searchCase.chineseName }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchMobile" class="form-control" placeholder="手机" value="${searchCase.mobile }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchMail" class="form-control" placeholder="邮箱" value="${searchCase.email }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchDestination" class="destination-select fullwidth" value="${searchCase.destination }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchSource" class="source-select fullwidth" value="${searchCase.source }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchOperator" class="operator-select fullwidth" value="${searchCase.operator }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchRequirment" class="form-control" placeholder="客人要求" value="${searchCase.requirement }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchComment" class="form-control" placeholder="注释" value="${searchCase.comment }" />
								</div>
								<div class="col-sm-2">
									<div class="input-group input-datepicker" style="padding: 0;">
				                        <input readonly="readonly" id="searchStartDateTime" type="text" name="searchStartDateTime" class="form-control datepicker" placeholder="请点击输入查询开始日期" value="${searchCase.searchStartTime}" autocomplete="on">
				                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                    </div>
				                </div>
			                    <div class="col-sm-2">
				                    <div class="input-group input-datepicker" style="padding: 0;">
				                        <input readonly="readonly" id="searchEndDateTime" type="text" name="searchEndDateTime" class="form-control datepicker" placeholder="请点击输入查询截止日期" value="${searchCase.searchEndTime}" autocomplete="on">
				                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                    </div>
			                    </div>
								</div>	
								<div class="col-sm-2">					 		                        		
									<input class="btn btn-primary" type="button" id="searchBtn" value="搜索"/>
									<input type="hidden" id="searchCaseFlag"  value="${flag}" />
								</div> 	
							</div>
							</div>	
						</div>
					</div>
					<div class="panel-body">
						<div class="form-group col-sm-12 case-filter">
		        	                <div class="rdio rdio-primary rdio-inline">
		        	                  <input type="radio" id="statusAll" value="" name="status" checked="checked"/>
		        	                  <label id="statusAllCount" for="statusAll">全部</label>    	                  
		        	                </div><!-- rdio -->
		        	                <div class="rdio rdio-primary rdio-inline">
		        	                  <input type="radio" id="status0" value="0" name="status"/>
		        	                  <label id="status0Count" for="status0">待处理</label>    	                  
		        	                </div><!-- rdio -->
		        	                <div class="rdio rdio-primary rdio-inline">
		        	                  <input type="radio" id="status1" value="1" name="status"/>
		        	                  <label id="status1Count" for="status1">客服沟通中</label>
		        	                </div><!-- rdio -->
		        	                <div class="rdio rdio-primary rdio-inline">
		        	                  <input type="radio" id="status2" value="2" name="status"/>
		        	                  <label id="status2Count" for="status2">地接设计中</label>
		        	                </div><!-- rdio -->
		        	                <div class="rdio rdio-primary rdio-inline">
		        	                  <input type="radio" id="status3" value="3" name="status"/>
		        	                  <label id="status3Count" for="status3">成行</label>
		        	                </div><!-- rdio -->
		        	                <div class="rdio rdio-primary rdio-inline">
		        	                  <input type="radio" id="status4" value="4" name="status"/>
		        	                  <label id="status4Count" for="status4">未成行</label>
		        	                </div><!-- rdio -->
		        	                <div class="rdio rdio-primary rdio-inline">
		        	                  <input type="radio" id="status5" value="5" name="status"/>
		        	                  <label id="status5Count" for="status5">无效</label>
		        	                </div><!-- rdio -->
		        	                <div class="rdio rdio-primary rdio-inline">
		        	                  <input type="radio" id="status6" value="6" name="status"/>
		        	                  <label id="status6Count" for="status6">已付款</label>
		        	                </div><!-- rdio -->
							</div>
						<div class="table-responsive">

							<table id="dataTable" class="table">
								<thead>
									<tr>
										<th>客人<br>ID</th>
										<th>手机 <br>邮箱<br>QQ</th>
										<th>目的地<br>出发时间 </th>									
										<th>客人要求</th>
										<th>无效原因<br>未成行原因 </th>
										<th>备注</th>
										<th>询单来源 <br>状态</th>
										<th>跟单员 <br>沟通方式</th>
										<th>更新时间 <br>创建时间</th>
										<th>编辑</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
				</div>
		<%@ include file="../assets/pages/rightpanel.jsp"%>
	</section>

	<%@ include file="../assets/pages/foot.jsp"%>
<!-- Modal 添加订单没有地址 -->
	<div class="modal fade" id="msgDestination" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">信息</h4>
				</div>
				<div class="modal-body">请选择目的地，再添加订单</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- modal-content -->
		</div>
		<!-- modal-dialog -->
	</div>
	<!-- modal -->
	<!-- 分配地接社Modal -->
	<div class="nextModal modal fade" id="nextModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body align-center">
					<div class="section-block">
						<form id="form-order">
							<div class="section-title">选择目的地及地接社,添加订单</div>
							<div class="form-group col-sm-8 col-sm-offset-2">
								<label class="col-sm-3 control-label">目的地</label>
								<div class="col-sm-9">
									<input type="text" id="orderDestinationText" readonly="readonly" class="form-control" value="" /> 
									<input type="hidden" id="orderDestination" name="destination" value="" />
								</div>
							</div>
							<div class="form-group col-sm-8 col-sm-offset-2">
								<label class="col-sm-3 control-label">服务类型</label>
								<div class="col-sm-9">
									<input type="text" id="serviceID" name="service"
										placeholder="选择服务类型" class="service-select fullwidth" value="" />
								</div>
							</div>
							<div class="form-group col-sm-8 col-sm-offset-2">
								<label class="col-sm-3 control-label">所属销售</label>
								<div class="col-sm-9">
									<input type="text" id="salesId" name="salesId"
										placeholder="选择一个销售" class="sales-select fullwidth" value="" />
								</div>
							</div>
							<div class="col-sm-12">
								<a class="submit btn btn-primary" >保存</a> 
								<input type="hidden" name="caseId" value="${crmcase.caseId}" /> 
								<input type="hidden" name="customerId" value="${crmcase.customerId}" />
								<input type="hidden" name="operator" value="${crmcase.operator}" />
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- modal-content -->
		</div>
		<!-- modal-dialog -->
	</div> 
<div class="updateUserModal modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">更改跟单员</div>
      </div>
      <form class="form-horizontal" id="form-updateUser">
          <div class="modal-body">     
              <div class="section-block noline">
                  <div class="form-group col-sm-12">
                    <label class="col-sm-4 control-label">跟单员</label>
                    <div class="col-sm-8">
                      <input class="updateUser-select fullwidth" name="operator" />
                    </div>
                  </div>
                  <input type="hidden" id="updateUser-caseId" name="caseId"  />
              </div>
          </div><!-- noDealModal-body -->
         
          <div class="modal-footer align-center">
            <button class="btn btn-primary" >保存</button> 
            <a class="cancel btn btn-primary" >取消</a>
          </div>
      </form>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- bmodal -->
	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	<script src="${rootPath}assets/js/datepicker-zh-CN.js"></script>
	<script src="${rootPath}assets/js/datetimepicker-cn.js"></script>

	<script type="text/javascript">
 	var source = ${source}; 
	var caseStatus = ${caseStatus};
	var destination = ${destination};
	var customer = ${customer};
	var user = ${user};
    var sales = ${sales};
	var reason = ${reason};
	var reasonNodeal =${reasonNodeal};
	var contactReal =${contactReal};
	
	$(".destination-select").select2({
        placeholder: '国家',
        data: destination,
        allowClear: true
    });
	
   	$(".customer-select").select2({
        placeholder: '客人',
        data: customer,
        allowClear: true
    }); 
   	
	$(".source-select").select2({
        placeholder: '来源',
        data: source,
        allowClear: true
    });
	
	$(".operator-select").select2({
        placeholder: '跟单员',
        data: user,
        allowClear: true
    });
	
	$(".status-select").select2({
        placeholder: '状态',
        data: caseStatus,
        allowClear: true
    });
	
    $(".sales-select").select2({
        placeholder: '销售',
        data: sales,
        allowClear: true
    });
    
    $(".reason-select").select2({
    	placeholder:"无效原因",
    	data:reason,
        allowClear: true
    });
    
    jQuery("#searchStartDateTime").datepicker({
        dateFormat: "yy-mm-dd",
        changeYear: true,
        changeMonth: true,
     });
    
    jQuery("#searchEndDateTime").datepicker({
        dateFormat: "yy-mm-dd",
        changeYear: true,
        changeMonth: true,
     });
    $(".updateUser-select").select2({
    	placeholder:"选择跟单员",
    	data:user,
        allowClear: true
	 });
    if($('#searchCaseFlag').val()=="old"){
	    if("${searchCase.status}" == ""){
	    	$("#statusAll").attr("checked",true);
	    }else if("${searchCase.status}" == "0"){
	    	$("#status0").attr("checked",true);
	    }else if("${searchCase.status}" == "1"){
	    	$("#status1").attr("checked",true);
	    }else if("${searchCase.status}" == "2"){
	    	$("#status2").attr("checked",true);
	    }else if("${searchCase.status}" == "3"){
	    	$("#status3").attr("checked",true);
	    }else if("${searchCase.status}" == "4"){
	    	$("#status4").attr("checked",true);
	    }else if("${searchCase.status}" == "5"){
	    	$("#status5").attr("checked",true);
	    }else if("${searchCase.status}" == "6"){
	    	$("#status6").attr("checked",true);
	    }
	}
   
			var t = jQuery('#dataTable').DataTable({
				searching:false,
				pageLength: 10,
				processing: true,
				language: datatable_local_language, // my.js
				serverSide: true, 
				stateSave: true,
				ajax: {
					url: '${rootPath}case/list.do',
					data: function(data){
			 			var searchCustomerId=$('#searchCustomerId').val();
			 			var searchCustomerName=$('#searchCustomerName').val();
			 			var searchCaseId=$('#searchCaseId').val();
			 			var searchBudget=$('#searchBudget').val();
			 			var searchDestination=$('#searchDestination').val();
			 			var searchSource=$('#searchSource').val();
			 			var searchOperator=$('#searchOperator').val();
			 			var searchComment=$('#searchComment').val();
			 			var searchRequirment=$('#searchRequirment').val();
			 			var searchMail=$('#searchMail').val();
			 			var searchMobile=$('#searchMobile').val();
			 			var searchStartDateTime=$("#searchStartDateTime").val();
			 			var searchEndDateTime=$("#searchEndDateTime").val();
			 			var searchStatus = $("input[name='status']:checked").val();
			 			var searchCaseFlag=$('#searchCaseFlag').val();
			 			data.flag = searchCaseFlag;
			 			
			 			if(searchCustomerId !=null && searchCustomerId !="" ){
							data.customerId = searchCustomerId;
			 			}
			 			if(searchCustomerName !=null && searchCustomerName !="" ){
							data.chineseName = searchCustomerName;
			 			}
			 			if(searchCaseId !=null && searchCaseId !="" ){
							data.caseId = searchCaseId;
			 			}
			 			if(searchBudget !=null && searchBudget !="" ){
							data.budget = searchBudget;
			 			}
			 			if(searchDestination !=null && searchDestination !="" ){
							data.destination = searchDestination;
			 			}
			 			if(searchSource !=null && searchSource !="" ){
							data.source = searchSource;
			 			}
			 			if(searchOperator !=null && searchOperator !="" ){
							data.operator = searchOperator;
			 			}
			 			if(searchStatus !=null && searchStatus !="" ){
							data.status = searchStatus;
			 			}
			 			if(searchComment !=null && searchComment !=""){
			 				data.comment = searchComment;
			 			}
			 			if(searchRequirment !=null && searchRequirment !=""){
			 				data.requirement = searchRequirment;
			 			}
			 			if(searchMail !=null && searchMail !=""){
			 				data.email = searchMail;
			 			}
			 			if(searchMobile !=null && searchMobile !=""){
			 				data.mobile = searchMobile;
			 			}
			 			if(searchStartDateTime !=null && searchStartDateTime !=""){
			 				data.searchStartTime = searchStartDateTime;
			 			}
			 			if(searchEndDateTime !=null && searchEndDateTime !=""){
			 				data.searchEndTime = searchEndDateTime;
			 			}
					},
					
					dataFilter: function(data){
						var json = jQuery.parseJSON( data );
						json.recordsTotal = json.countTotal;
						json.recordsFiltered = json.countFiltered;
						json.data = json.data;
						$('#statusAllCount').html("全部"+json.statusAll);

						$('#status0Count').html("待处理"+json.status0);

						$('#status1Count').html("客服沟通中"+json.status1);
				
						$('#status2Count').html("地接设计中"+json.status2);						
						
						$('#status3Count').html("成行"+json.status3);						
						
						$('#status4Count').html("未成行"+json.status4);						
						
						$('#status5Count').html("无效"+json.status5);												
						
						$('#status6Count').html("已付款"+json.status6);
						return JSON.stringify( json );
					}
				},
				columnDefs: [		  
 					   {
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div class='minw50'>" + full.chineseName + "</div>" + "<div class='minw50'>" + full.caseId + "</div>"
			                },
			                targets: 0
						},
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.mobile + "</div>" + "<div>" + full.email + "</div>"+ "<div>" + full.qq + "</div>"
			                },
			                targets: 1
						},
	 					{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	var destinations="";
			                	
			                	if(full.destination){
			                	var des=full.destination.split(",");
				                	for(var j = 0;j<des.length;j++){
				                		for(var i=0;i <destination.length;i++){
					                		if(des[j]==destination[i].id){
					                			destinations+=destination[i].text+",";
					                		}				                	
					                	}
				                	}
				                }
			                	
			                	destinations=destinations.substring(0,destinations.length-1);
			              	//出发日期
		                	var start_date = full.startDate;
		                	//大约出发日期
		                	var start_month =full.startMonth;
		                	
			                if(start_date!=null){
			                	var time=new Date(start_date.time).format("yyyy-MM-dd");
			                	return "<div class='caselist-7'>" + destinations + "</div>" + "<div class='caselist-7'>" + time + "</div>";
		                		
		                	}
		                	if(start_month!=null){
		                		var time=new Date(start_month.time).format("yyyy-MM-dd");
		                		 return "<div class='caselist-7'>" + destinations + "</div>" + "<div class='caselist-7'>" + time + "</div>";
		                	}
		                	
			                return "<div class='width85'>" + destinations + "</div>" ;
			                },
			                targets: 2
						},	  
						{
							data:"requirement",
							orderable: false,
							render:function(data) {
								if(data.length > 24){
									return "<div class='width150' data-toggle='tooltip' data-placement='bottom' title='" + data + "'>" + data.substring(0,28) + "...</div>"
								}else{
									return "<div class='width150'>" + data + "</div>"
								}	
							},
							targets: 3
						},
						 {	
							orderable: false,
			                render: function ( data, type, full, meta ) {
			                	var dataReason = full.reason;
			                	var dataReasonNodeal= full.reasonNodeal;
			                	var m = "";
			                	var n = "";
				                	for(var i=0;i < reason.length;i++){
				                		
				                		if(dataReason==reason[i].id){
				                			m = reason[i].text;
				                		}	
				                	}
				                	for(var i=0;i < reasonNodeal.length;i++){
				                		if(dataReasonNodeal==reasonNodeal[i].id){
				                			n=reasonNodeal[i].text;
				                		}
				                	}
				                	return "<div class='width85'>" + m + "</div>" + "<div class='width85'>" + n + "</div>";
			                },
			                  targets: 4
						},
						{
							data:"comment",
							orderable: false,
							render:function ( data ) {
								if(data.length > 24){
									return "<div class='width150' data-toggle='tooltip' data-placement='bottom' title='" + data + "'>" + data.substring(0,28) + "...</div>"
								}else{
									return "<div class='width150'>" + data + "</div>"
								}
							},
							  targets: 5
						},
						{
			                  orderable: false,
				                render:  function ( data, type, full, meta ) {
				                	var dataSource = full.source;
				                	var dataCaseStatus = full.status;
				                	var m = "";
				                	var n = "";
				                	for(var i=0;i < source.length;i++){
				                		
				                		if(dataSource==source[i].id){
				                			m = source[i].text;
				                			break;
				                		}	
				                	}
				                	
				                	for(var i=0;i<caseStatus.length;i++){
				                		if(dataCaseStatus==caseStatus[i].id){
				                			n=caseStatus[i].text;
				                			break;
				                		}
				                	}
				                	
				                	return "<div class='width85'>" + m + "</div>" + "<div class='width85'>" + n + "</div>";
				                },
				                targets: 6
						},
						{
							orderable: false,
							render:function ( data, type, full, meta ) {
								var oper = full.operator;
								var contReal = full.contactReal;
								var operator = "";
								var contRealText = "";
								for(var i=0;i < user.length;i++){
			                		if(oper==user[i].id){
			                			operator=user[i].text;
			                			break;
			                		}
			                	}
								
								for(var i=0;i < contactReal.length;i++){
			                		if(full.contactReal==contactReal[i].id){
			                			
			                			contRealText=contactReal[i].text;
			                			break;
			                		}
			                	}
								return "<div class='width85'>" + operator + "</div>" + "<div class='width85'>" +contRealText+ "</div>";
							},
							  targets: 7
						
						},{
			                  
			                  orderable: false,
			                  render: function ( data, type, full, meta ) {
			                	  
			                	  	var m = full.updateTime.time;
				                	if(full.updateTime){
				                		m=new Date(m).format("yyyy-MM-dd hh:mm:ss");
				                	}else{
				                		m="";
				                	}
				                	
				                	var n = full.creatTime.time;
				                	if(full.creatTime){
				                		n=new Date(n).format("yyyy-MM-dd hh:mm:ss");
				                	}else{
				                		n="";
				                	}
				                	return "<div class='caselist-7'>" + m + "</div>"+"<div class='caselist-7'>" + n + "</div>"
			                  },
			                  targets: 8
						    },
						{
		                  data: "caseId",
		                  orderable: false,
		                  render: function ( data, type, full, meta ) {
		                	 
		                	  if(full.status==0){
		                		  return '<a class="btn btn-primary btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 处理</a> &nbsp;';  
		                	  }
		                	  else {
		                		  var reContent ='<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>';
		                		  if(full.status!=5&&full.status!=4){
		                			  reContent+='&nbsp;<a name="btn-addorder"  class="btn btn-primary btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 分配地接社</a>';
		                		  }
		                		  if("${sessionScope.buttonId1}" != ""){
		                			  reContent+='&nbsp;<a name="btnUpdateUser"  class="btn btn-default btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 修改跟单员</a>';
		                		  }
		                		  if(full.status==1){
		                			  reContent+='&nbsp;<a name="btn-invalid"  class="btn btn-danger btn-xs" id="'+data+'">无效</a>';
		                		  }
		                		  if(full.status!=3&&full.status!=5&&full.status!=4){
		                			  reContent+='&nbsp;<a name="btn-nodeal"  class="btn btn-danger btn-xs" id="'+data+'">未成行</a>';
		                		  }
		                		  return reContent;  
		                	  }
		                  },
		                  targets: 9
					    },
					    {
						    orderable: false,
						    searchable: false,
					        targets: [0]
					    }, 

					],
					columns: [
			            { data: "caseId" },
			            { data:"mobile"},
			            { data: "destination" },
			            { data: "requirement" },
			            { data: "reason"},
			            { data: "comment"},
			            { data: "source" },
			            { data: "operator" },
			            { data: "updateTime"},
			            { data: "caseId"}
			        ]
				});

			$('#searchBtn').on( 'click', function () {
				//通知后台，使用界面的条件来重绘table
				$('#searchCaseFlag').val("restart");
				$('#statusAll').attr('checked',true);
		        t.draw();
		    } );
			
			if($('#searchCaseFlag').val()=="restart"){
				t.ajax.reload();
			}
			//给radioButton设置点击事件
			$('input[name=status]').on('click',function(){
				$('#searchCaseFlag').val("restart");
				t.draw();
			});
			//修改跟单员
			 $('#dataTable tbody').on( 'click', 'a[name=btnUpdateUser]', function () {
				 $(".updateUserModal").modal('show');
				 $("#updateUser-caseId").val($(this).attr('id'));
		     } );
			
			 jQuery("#form-updateUser").validate({
			        rules: {
				        operator: {
				        	required: true,
				        },	              	
					},				
			     	 messages: {
			     		operator: "请选择跟单员",
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
			          	$("#form-updateUser .submit").attr("disabled","disabled");
			              updateUser_submit();
			              return false;
			          } 
		        });
			 
			 $(".updateUserModal .cancel").click(function(){
			    	$(".updateUserModal").modal('hide');
			    });
			/*if($('#searchCaseFlag').val()=="old"){
			    if("${searchCase.status}" == ""){
			    	$("#statusAll").attr("checked",true).click();
			    }else if("${searchCase.status}" == "0"){
			    	$("#status0").attr("checked",true).click();
			    }else if("${searchCase.status}" == "1"){
			    	$("#status1").attr("checked",true).click();
			    }else if("${searchCase.status}" == "2"){
			    	$("#status2").attr("checked",true).click();
			    }else if("${searchCase.status}" == "3"){
			    	$("#status3").attr("checked",true).click();
			    }else if("${searchCase.status}" == "4"){
			    	$("#status4").attr("checked",true).click();
			    }else if("${searchCase.status}" == "5"){
			    	$("#status5").attr("checked",true).click();
			    }else if("${searchCase.status}" == "6"){
			    	$("#status6").attr("checked",true).click();
			    }
			} else{
				//若是从侧边栏进如，则flag默认为‘restart’
				t.ajax.reload();
			} */
			$('#dataTable tbody').on( 'click', 'a.btn-success', function () {
		        var data = t.row($(this).parents('tr')).data();
		        edit($(this).attr('id'));
		    } );
			$('#dataTable tbody').on( 'click', 'a.btn-primary', function () {
		        var data = t.row($(this).parents('tr')).data();
		        handle($(this).attr('id'));
		    } );
			function updateUser_submit(){
				var f = $("#form-updateUser").serialize();
				$.post('${rootPath}case/updateUser.do', f, function(result) {
					var rmsg = result.msg;
					if (result.success) {
						window.parent.location = "${rootPath}case/list.html?flag=old";
					} 
					else {
						$("#msgModal").modal('show');
					}
				}, "JSON");
			}
	    
		// Select2
	    jQuery('select').select2({
	        minimumResultsForSearch: -1
	    });
	    
	    jQuery('select').removeClass('form-control');
		
		function edit(id) {
			window.parent.location = "${rootPath}case/edit.html?id="+id;
		}
		//处理询单
		function handle(id) {
			window.parent.location = "${rootPath}case/handle.html?id="+id;
		}
		
		function del(id) {
			 
			 $(".confirmDelModal .hiddenId").val("");
			 $(".confirmDelModal .hiddenId").val(Number(id));
		 	 $(".confirmDelModal").modal('show');
		}
		
		function doDel(id){
			$.ajax({
				url: "${rootPath}case/del.do?id=" + id, 
				success: function() {
					window.location.reload();
				},
				error: function() {
					alert(2);
				}
			});			
		}
		
  		function order_submit() {
			var order= $("#form-order").serialize();
			$.post('${rootPath}order/add.do', order, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}case/list.html";
				} else {
					$("#nextModal").modal('hide');
					$("#NoEmail").modal('show');
				}
			}, "JSON");
		}
  	  
  	  function delSubmit() {
    	  var f1=$("#form-del").serialize();
     	  try{
     		  $.post("${rootPath}case/del.do", f1, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}case/list.html";
				} 
				else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
     		  }
     	  catch(e) {
     		  alert(e);
     	  }
     	 alert("页面正在加载，请稍后...");
      }
  	//分配地接社按钮
      $("#btn-addorder").click(function(){
      	  var destination = $("#destination").val();
      	  $("#englishDestination").val(destination);
      	  if(destination=="" || destination == null){
      	  	$("#msgDestination").modal('show');
 		  }else{ 
      			var destinationText;
      			for(var i=0; i<$("#destination").select2('data').length; i++){
      				if(destinationText==null){
      					destinationText = $("#destination").select2('data')[i].text + ",";
      				}else{
      					destinationText = destinationText + $("#destination").select2('data')[i].text + ",";
      				}
      			}
      			var destinationText = destinationText.substring(0,destinationText.length-1);
      	  		$("#orderDestinationText").val(destinationText); 
      	  		$("#orderDestination").val(destination);
	      	  	$.ajax({
	              type: "post",
	              url: "${rootPath}case/getSales.do?destination="+destination,
	              data: destination,
	              success: function(sales){
	            	  var json = jQuery.parseJSON(sales);
	                  $("#salesId").select2({	
	                      placeholder: '销售',
	                      data: json
	                  });
	              }  
	            });  
      	  	    $("#nextModal").modal('show');         	         	  
      	    }  
            return false;
        });
  	
    //选择服务类型所属销售显示的联动
	  	$("#serviceID").change(function(){
	  		var serviceID = $("#serviceID").val();
	  		if(serviceID==3 || serviceID==4 || serviceID==5){
	  			$.ajax({
		              type: "post",
		              url: "${rootPath}case/getSalesByServiceId.do?serviceID="+serviceID,
		              data: serviceID,
		              success: function(sales){
		            	  var json = jQuery.parseJSON(sales);
		                  $("#salesId").select2({	
		                      placeholder: '销售',
		                      data: json
		                  });
		              }  
		        }); 
	  		}else{
	  			var destination = $("#destination").val();
	  			$.ajax({
		              type: "post",
		              url: "${rootPath}case/getSales.do?destination="+destination,
		              data: destination,
		              success: function(sales){
		            	  var json = jQuery.parseJSON(sales);
		                  $("#salesId").select2({	
		                      placeholder: '销售',
		                      data: json
		                  });
		              }  
		            });
	  		}
	  	}) 
	  	$("#nextModal .submit").click(function(){
          $(this).attr("disabled","disabled");
      	  order_submit();
        }); 
    
	  	function order_submit() {
			var f = $("#form-order").serialize();
			$.post('${rootPath}order/add.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";
				} else {
					if(result.text=="noCustomerEmail"){
						alert("分配地接社成功，由于客人没有邮箱，无法发送订单邮件");
						$('#nextModal').modal('hide');
						window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";
					}
					else if(result.text=="noSaleEmail"){
						alert("分配地接社成功，由于销售没有邮箱，无法发送订单邮件");
						$('#nextModal').modal('hide');
						window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";

					}
					else if(result.text=="noSendmail"){
						alert("分配地接社成功，由于地接社设置为不发送邮件，所以未发送订单邮件");
						$('#nextModal').modal('hide');
						window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";
					}
					//$("#NoEmail").modal('show');
	         		//$("#nextModal").modal('hide');
	         		else {window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";}
				}
			}, "JSON");
	      }
	</script>
</body>
</html>
