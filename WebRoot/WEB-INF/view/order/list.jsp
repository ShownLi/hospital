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
					<i class="fa fa-user"></i> 订单管理 <span>订单列表</span>
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
						<h3 class="panel-title">订单列表</h3>
						<div class="row" style="margin-top: 20px">
							<div class="form-group col-sm-10">
								<div class="col-sm-2">
									<input type="text" id="searchCustomerName" class="form-control" placeholder="客人姓名" value="${searchOrder.customerName }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchOrderId" class="form-control" placeholder="订单id"  value="${searchOrder.orderId }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchAgencyName" class="form-control" placeholder="地接社" value="${searchOrder.agencyName }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchSalesName" class="form-control" placeholder="销售姓名" value="${searchOrder.salesName }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchOperator" class="operator-select fullwidth" value="${searchOrder.operator }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchStatus" class="status-select fullwidth" value="${searchOrder.status }" />
								</div>
							</div>	
							<div class="col-sm-2">					 		                        		
								<input class="btn btn-primary" type="button" id="searchBtn" value="搜索"/>
								<input type="hidden" id="searchFlag" name="flag" value="${flag}" />
							</div> 	
						</div>
					

					</div>
					<div class="panel-body">
						<br />
						<div class="table-responsive">

							<table id="dataTable" class="table">
								<thead>
									<tr>
										<th>客人姓名<br>ID</th>
										<th>地接社<br>销售</th>
										<th>目的地<br>状态</th>
										<th>成团人数</th>
										<th>成团金额</th> 
 										<th>出发日期<br>返回日期</th> 
 										<th>跟单员</th>
										<th>创建时间</th>
										<th>最后回复时间</th>
										<th>编辑</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						<!-- table-responsive -->
					</div>
					<!-- panel-body -->
				</div>
				<!-- panel -->
			</div>
		</div>
		<!-- mainpanel -->
		<%@ include file="../assets/pages/rightpanel.jsp"%>
	</section>

	<%@ include file="../assets/pages/foot.jsp"%>

    <script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>


<!-- dealModal -->
<div class="dealModal modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">         
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">请填写以下订单信息</div>
      </div>

      <form class="form-horizontal" id="form-deal">
      <div class="modal-body">
              <div class="section-block noline">
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团日期<span class="asterisk">*</span></label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input type="text" name="groupTime" class="form-control datepicker" autocomplete="off" placeholder="成团日期">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                  </div>
                   <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团人数<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="groupNumber" placeholder="成团人数" class="form-control"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">出发日期<span class="asterisk">*</span></label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input type="text" name="startDate" placeholder="出发日期" class="form-control datepicker" autocomplete="off" />
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">返回日期<span class="asterisk">*</span></label>
                    <div class="col-sm-8 input-group input-datepicker">
                      <input type="text" name="endDate" placeholder="返回日期" class="form-control datepicker" autocomplete="off" />
                      <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                    </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团成本<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="costBudget" placeholder="成团成本" class="form-control"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团价格<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="groupPrice" placeholder="成团价格" class="form-control" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团币种<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="currency" placeholder="成团币种" class="currency-select fullwidth"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">汇率<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="exchangeRate" placeholder="汇率" class="form-control" value="" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">人民币成本<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="costBudgetRmb" placeholder="人民币成本" class="form-control"/>
                      </div>
                  </div>
                   <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">人民币价格<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="rmbPrice" placeholder="人民币价格" class="form-control"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">收款方<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="costReceiver" placeholder="收款方" class="beneficiary-select fullwidth"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">付款方式<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" id="paymentMethod" name="paymentMethod" placeholder="付款方式" class="paymentMethod-select fullwidth"/>
                      </div>
                  </div>
                         
			       <table id="payTable" class="table">
						<thead>
							<tr>
								<th>期数</th>
								<th>款项</th>
								<th>应收金额</th>
								<th>收款截止日期</th>
								<th>备注</th>
							</tr>
						</thead>
						<tbody>
							<tr id="tr_0">
								 <td>第一期</td>
								 <td><input type="text" name="paymentItem" placeholder="款项" class="funds-select fullwidth"/></td>
								 <td><input type="text" name="priceBudget " placeholder="应收金额" class="form-control"/></td>
								 <td> 
								 <input type="text" name="deadline" placeholder="收款截止日期" class="form-control datepicker" autocomplete="off" />
				                  				 <!-- <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> -->
								 </td>
								 <td><input type="text" name="comment" placeholder="备注" class="form-control"/></td>
							</tr>
							<tr id="tr_1">
								 <td>第二期</td>
								 <td><input type="text" name="paymentItem" placeholder="款项" class="funds-select fullwidth"/></td>
								 <td><input type="text" name="priceBudget " placeholder="应收金额" class="form-control"/></td>
								 <td> 
								 <input type="text" name="deadline" placeholder="收款截止日期" class="form-control datepicker" autocomplete="off" />
				                  				 <!-- <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> -->
								 </td>
								 <td><input type="text" name="comment" placeholder="备注" class="form-control"/></td>
							</tr>
							<tr id="tr_2">
								 <td>第三期</td>
								 <td><input type="text" name="paymentItem" placeholder="款项" class="funds-select fullwidth"/></td>
								 <td><input type="text" name="priceBudget " placeholder="应收金额" class="form-control"/></td>
								 <td> 
								 <input type="text" name="deadline" placeholder="收款截止日期" class="form-control datepicker" autocomplete="off" />
				                  				 <!-- <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> -->
								 </td>
								 <td><input type="text" name="comment" placeholder="备注" class="form-control"/></td>
							</tr>
							<tr id="tr_3">
								 <td>第四期</td>
								<td><input type="text" name="paymentItem" placeholder="款项" class="funds-select fullwidth"/></td>
								 <td><input type="text" name="priceBudget " placeholder="应收金额" class="form-control"/></td>
								 <td> 
								 <input type="text" name="deadline" placeholder="收款截止日期" class="form-control datepicker" autocomplete="off" />
				                  				 <!-- <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> -->
								 </td>
								 <td><input type="text" name="comment" placeholder="备注" class="form-control"/></td>
							</tr>
							<tr id="tr_4">
								 <td>第五期</td>
								<td><input type="text" name="paymentItem" placeholder="款项" class="funds-select fullwidth"/></td>
								 <td><input type="text" name="priceBudget " placeholder="应收金额" class="form-control"/></td>
								 <td> 
								 <input type="text" name="deadline" placeholder="收款截止日期" class="form-control datepicker" autocomplete="off" />
				                  				 <!-- <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> -->
								 </td>
								 <td><input type="text" name="comment" placeholder="备注" class="form-control"/></td>
							</tr>
						</tbody>
					</table>
                  <input type="hidden" id="dealOrderId" name="orderId" value="${order.orderId}" />
                  <input type="hidden" name="caseId" value="${order.caseId}" />	
                  <input type="hidden" name="customerId" value="${order.customerId}" />	
              </div>           
      </div>
      <div class="modal-footer align-center">
          <button class="submit btn btn-primary">保存</button>
          <a class="cancel btn btn-primary" >取消</a>        
      </div>
      </form>   

    </div><!-- modal-content --> 
  </div><!-- modal-dialog -->
</div><!-- dealModal -->

<!-- noDealModal -->
<!-- noDealModal -->
<div class="noDealModal modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">请填写以下订单信息</div>
      </div>
      <form class="form-horizontal" id="form-noDeal">
          <div class="modal-body">     
              <div class="section-block noline">
                  <div class="form-group col-sm-12">
                    <label class="col-sm-4 control-label">未成行原因</label>
                    <div class="col-sm-8">
                      <input class="reason-select fullwidth" name="reason" placeholder="若未成行，原因是" />
                      <input type="hidden" id="noDeal-orderId" name="orderId" value="${order.orderId}" />	
                      <input type="hidden" name="caseId" value="${order.caseId}" />		                     
                      <input type="hidden" name="status" value="3" />
                    </div>
                  </div>
              </div><!-- noDealModal-body -->
          </div>
          <div class="modal-footer align-center">
            <button class="btn btn-primary" >保存</button> 
            <a class="cancel btn btn-primary" >取消</a>
          </div>
      </form>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- bmodal -->

<!-- Modal -->
<div class="modal fade" id="NoEmail" tabindex="-2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">信息</h4>
      </div>
      <div class="modal-body">
      		该客人没有邮箱，请<a href="#" id="addEmail">添加邮箱</a>后再进行操作
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->

	<script type="text/javascript">
	var orderStatus = ${orderStatus};
	var destination = ${destination};
	var reason = ${reason};
	var currency=${currency};
	var user = ${user};
	
	var beneficiary =  [{ id: 0, text: '特美旅行' }, { id: 1, text: '地接社' }];
	var paymentMethod = [{ id: 0, text: '一期' }, { id: 1, text: '两期' },{ id: 2, text: '三期' }, { id: 3, text: '四期' },{ id: 4, text: '五期' }]
	var funds = [{ id: 0, text: '团款' }, { id: 1, text: '机票' }];
	
	for(var i=0;i<5;i++){
		$("#tr_"+i).hide();
	}
	
 	$(".destination-select").select2({
        placeholder: '国家',
        data: destination,
        allowClear: true
    }); 
	
	$(".currency-select").select2({
        data: currency,
        allowClear: true
    });
	
	$(".status-select").select2({
        placeholder: '状态',
        data: orderStatus,
        allowClear: true
    });
    
    $(".reason-select").select2({
    	placeholder:"未成行原因",
    	data:reason,
        allowClear: true
	 });
    
    $(".operator-select").select2({
    	placeholder:"跟单员",
    	data:user,
        allowClear: true
	 });
    
    $(".beneficiary-select").select2({
    	placeholder:"收款方",
    	data:beneficiary,
    	allowClear:true
    });
    
    $(".paymentMethod-select").select2({
    	placeholder:"分几期付款",
    	data:paymentMethod,
    	allowClear:true
    });
    
    $(".funds-select").select2({
    	placeholder:"款项",
    	data:funds,
    	allowClear:true
    });
    
    
    $('.paymentMethod-select').change(function(){
   		//var payMethod = $("#paymentMethod").select2('data')[0].id;
   		var payVal = $("#paymentMethod").val();
   		for(var i=0;i<parseInt(payVal)+1;i++){
   			$("#tr_"+i).show();
   		}
   		for(var i=5;i>parseInt(payVal);i--){
   			$("#tr_"+i).hide();
   		}
    });
    
	
		jQuery(document).ready(function() {			
			jQuery("#form-deal").validate({
		        /*  rules: {
			        groupTime: {
	                required: true,
	                date: true
	              },
			          startDate: {
	                required: true,
	                date: true
	              },
			          endDate: {
	                required: true,
	                date: true
	              },
			          groupNumber: {
	                required: true,
	                number: true
	              },
			          groupPrice: {
	                required: true,
	                number: true
	              },
	              currency: {
	                required: true,
	              },
			          exchangeRate: {
	                required: true,
	                number: true
	              },
			          rmbPrice: {
	                required: true,
	                number: true
	              },
			   },
			   
		      messages: {
		        groupTime: {
	                required: "请输入成团日期",
	                date: "日期格式 mm/dd/yyyy"
             	 },
		          startDate: {
	                required: "请输入出发日期",
	                date: "日期格式 mm/dd/yyyy"
                 },
		           endDate: {
	                required: "请输入返回日期",
	                date: "日期格式 mm/dd/yyyy"
              	 },
		          groupNumber: "请输入一个数字",
		          groupPrice: "请输入一个数字",
              	  currency: "请选择货币种类",
		          exchangeRate: "请输入一个数字",
		          rmbPrice: "请输入一个数字",
		      },
		      
	          highlight: function(element) {
	            jQuery(element).closest('.form-group').removeClass('has-success').addClass('has-error');
	          },
	          success: function(element) {
	            jQuery(element).closest('.form-group').removeClass('has-error');
	          },
	          invalidHandler : function(){
	            return false;
	          },  */
	          submitHandler : function(){
	          	//$("#form-deal .submit").attr("disabled","disabled");
	              deal_submit();
	              return false;
	          } 
	        });
//	       });  	     	   	    		      		
					
			jQuery("#form-noDeal").validate({
		        rules: {
			        reason: {
			        	required: true,
			        },	              	
				},				
		     	 messages: {
		            reason: "请选择一个原因",
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
		          	$("#form-noDeal .submit").attr("disabled","disabled");
		              noDeal_submit();
		              return false;
		          } 
	        });
          });  
			
			 var t = jQuery('#dataTable').DataTable({
				searching:false,
			 	pageLength: 10,
			 	processing: true,
			 	language: datatable_local_language, // my.js
			 	serverSide: true,
			 	stateSave:true,
			 	ajax: {
			 		url: '${rootPath}order/list.do',
			 		data:function ( data ) {
			 			var searchCustomerName=$('#searchCustomerName').val();
			 			var searchOrderId=$('#searchOrderId').val();
			 			var searchAgencyName=$('#searchAgencyName').val();
			 			var searchSalesName=$('#searchSalesName').val();
			 			var searchDestination=$('#searchDestination').val();
			 			var searchBudget=$('#searchBudget').val();
			 			var searchStatus=$('#searchStatus').val();
			 			var searchOperator=$('#searchOperator').val();
			 			
			 			var searchFlag=$('#searchFlag').val();
			 			data.flag = searchFlag;
			 			if(searchCustomerName !=null && searchCustomerName !="" ){
							data.customerName = searchCustomerName;
			 			}
			 			if(searchOrderId !=null && searchOrderId !="" ){
							data.orderId = searchOrderId;
			 			}
			 			if(searchAgencyName !=null && searchAgencyName !="" ){
							data.agencyName = searchAgencyName;
			 			}
			 			if(searchSalesName !=null && searchSalesName !="" ){
							data.salesName = searchSalesName;
			 			}
			 			if(searchDestination !=null && searchDestination !="" ){
							data.destination = searchDestination;
			 			} 
			 			if(searchBudget !=null && searchBudget !="" ){
							data.budget = searchBudget;
			 			}
			 			if(searchOperator !=null && searchOperator !=""){
			 				data.operator = searchOperator;
			 			}
			 			if(searchStatus !=null && searchStatus !="" ){
							data.status = searchStatus;
			 			} 
			 			
					},

			 		dataFilter: function(data){
			             var json = jQuery.parseJSON( data );
			             json.recordsTotal = json.countTotal;
			             json.recordsFiltered = json.countFiltered;
			             json.data = json.data;
			             return JSON.stringify( json );
			         }
			 	},
			 	columnDefs: [
						 	  {//客人姓名<br>ID
						 		  orderable: false,
						 		  render:function ( data, type, full, meta ){
						 			  return full.customerName+"<br>"+full.orderId;
						 		  },
						 	      targets: 0
						 	  },
						 	  {//地接社<br>销售
						 		  orderable: false,
						 		  render:function ( data, type, full, meta ){
						 			  return full.agencyName+"<br>"+full.salesName;
						 		  },
						 	      targets: 1
						 	  },
								 {//目的地<br>状态
					                orderable: false,
					                render: function ( data, type, full, meta ) {
				                	 if(full){
					                	var des=data.split(",");
					                	var destinations="";
					                	for(var j = 0;j<des.length;j++){
					                	
					                		for(var i=0;i <destination.length;i++){
						                		if(des[j]==destination[i].id){
						                			destinations+=destination[i].text+",";
						                		}				                	
						                	}
					                	}
					                	destinations=destinations.substring(0,destinations.length-1);
					                	var orderStatusText="";
					                	for(var i=0;i < orderStatus.length;i++){
					                		if(full.status==orderStatus[i].id){
					                			orderStatusText= orderStatus[i].text;
					                		
					                		}
					                	}
				                		return destinations+"<br>"+orderStatusText;
				                	}
				                	else{
				                			return "";
				                		}
				                },
			                    targets: 2
								},
								{//成团人数
									data: "groupNumber",
					                orderable: false,
					                render: function ( data ) {
					                	if(data){
						                	return data;
					                	}
					                	else{return ""}
					                },
					                  targets: 3
								},
								{//成团金额
					                orderable: false,
					                render: function ( data, type, full, meta )  {
					                	return full.currency+full.groupPrice+"<br>￥"+full.rmbPrice;
					                },
					                  targets: 4
								},
								{//出发日期<br>返回日期
					                orderable: false,
					                render: function ( data, type, full, meta )  {
					                	if(full.startDate&&full.endDate){
					                		return new Date(full.startDate.time).format("yyyy-MM-dd")+"<br>"+new Date(full.startDate.time).format("yyyy-MM-dd");
					                	}
					                	return "";
					                },
					                  targets: 5
								},
								{//跟单员
									data:"operator",
									orderable: false,
					                render: function ( data, type, full, meta  )  {
					                	for(var i=0;i<user.length;i++){
					                		if(data==user[i].id){
					                			return user[i].text;
					                		}
					                	}
					                	return "";
					                },
					                  targets: 6
								}
								,
								{
					                data: "creatTime",
					                orderable: false,
					                render: function ( data ) {
					                	if(data){
					                		return new Date(data.time).format("yyyy-MM-dd hh:mm:ss");
					                	}
					                	else{return ""}
					                },
					                  targets: 7
								},
								{
					                data: "lastResponse",
					                orderable: false,
					                render: function ( data ) {
					                	if(data){
					                		return new Date(data.time).format("yyyy-MM-dd hh:mm:ss");
					                	}
					                	else{return ""}
					                },
					                  targets: 8
								}, 
								{
							          data: "orderId",
							 	      orderable: false,
							 	      render: function ( data, type, full, meta ) {
						              	return '<a name="btnEdit" class="btn btn-default btn-xs" id="'+data+
						              	'"><span class="fa fa-edit"></span> 编辑</a>&nbsp<a name="btnDeal" class="btn btn-success btn-xs" id="'+data+
						              	'"> 成行</a>&nbsp<a name="btnNoDeal" class="btn btn-warning btn-xs" id="'+data+
						              	'">未成行</a>&nbsp<a name="btnSendEmail" class="btn btn-primary btn-sendMaile btn-xs" id="'+data+
						              	'"> 发订单邮件</a>';
							 	  	  },
							 	    	targets: 9
							 	}
						 	  
						 	],
			 	columns: [
		             { data: "orderId" },
		             { data: "agencyName" },
		             { data: "destination" },
		             { data: "groupNumber"},
		             { data: "groupPrice"},
		             { data: "startDate"},
		             { data: "operator"},
		             { data: "creatTime"}, 
			 		 { data: "lastResponse"}
		         ]
			 });
			 if($('#searchFlag').val()=="restart"){
					t.ajax.reload();
				}
			  $('#searchBtn').on( 'click', function () {
					//通知后台，使用界面的条件来重绘table
					$('#searchFlag').val("restart");
			        t.draw();
			    } );
			  jQuery(document).ready(function() {
			   $('#dataTable .btn-success').css("display","none")
			  });
			 $('#dataTable tbody').on( 'click', 'a[name=btnEdit]', function () {
		         var data = t.row($(this).parents('tr')).data();
		         edit($(this).attr('id'));
		     } );
			
			 $('#dataTable tbody').on( 'click', 'a[name=btnDeal]', function () {
		         var data = t.row($(this).parents('tr')).data();
		         group($(this).attr('id'));
		         $("#dealOrderId").val($(this).attr('id'));
		     } );

			 $('#dataTable tbody').on( 'click', 'a[name=btnNoDeal]', function () {
		         var data = t.row($(this).parents('tr')).data();
		         nogroup($(this).attr('id'));
		         $("#noDealOrderid").val($(this).attr('id'));
		     } );
			 
			 $('#dataTable tbody').on( 'click', 'a[name=btnSendEmail]', function () {
		         var data = t.row($(this).parents('tr')).data();
		         sendOrderEmail(data);  
		     } );
			 
			 /*  $('#confirmDelModal').on( 'click', 'button.btn-danger', function () {
		         var id = $("#confirmDelModal .hiddenId").val();
		         doDel(id);
		     } );  */ 
		    
			// Select2
		    jQuery('select').select2({
		        minimumResultsForSearch: -1
		    });
		    
		    jQuery('select').removeClass('form-control');		
		
		function edit(id) {
			window.parent.location = "${rootPath}order/edit.html?id="+id;
		}
		
		function group(id) {
			$(".dealModal").modal('show');
		}
		
		function nogroup(id) {
			$("#noDeal-orderId").val(id);
			$(".noDealModal").modal('show');
		}
		
		//判断客人是否有邮箱  有的话发送邮件 没有的话绑定邮箱
		function sendOrderEmail(data){
			if(data.customerEmailReal!=null&&data.customerEmailReal!=""){
				if(data.agencyEmailReal==null||data.agencyEmailReal==""){
					alert(data.agencyEmailReal);
					alert("销售没有邮箱地址，不能发送邮件");
					return ;
				}			
				//alert(data.customerReEmailAlias);
				if(data.customerReEmailAlias!=null && data.customerReEmailAlias!=""){
					var f = data.orderId;
					$.post('${rootPath}order/orderSendEmail.do', {"orderId":f}, function(result) {
						var rmsg = result.msg;
						if (result.success) {
							//window.parent.location = "${rootPath}order/list.html";
							alert("邮件发送成功");
						} 
						else {
							alert("邮件发送失败，请检查地接社是否允许发邮件");
						}
					}, "JSON");
				}else{
					var f = data.orderId;
					$.post('${rootPath}order/orderSendEmailNoAlias.do', {"orderId":f}, function(result) {
						var rmsg = result.msg;
						if (result.success) {
							//window.parent.location = "${rootPath}order/list.html";
							alert("邮件发送成功了");
						} 
						else {
							alert("邮件发送失败，请检查地接社是否允许发邮件");
						}
					}, "JSON");
				}
			}
			else{
				$("#NoEmail").modal('show');
				var newHref = "../customer/edit.html?id="+data.customerId
				$('#addEmail').attr("href",newHref);
			}
		}
		  
		// Date Picker
		jQuery(".datepicker").datepicker({
			  dateFormat: "yy-mm-dd"
	  	});
/*  	    $(".dealModal .submit").click(function(){
	    	deal_submit();
	      });  */
 	    /* $(".noDealModal .submit").click(function(){
	    	noDeal_submit();
	      }); 
	     */
	    $(".dealModal .cancel").click(function(){
	    	$(".dealModal").modal('hide');
	    });
	    $(".noDealModal .cancel").click(function(){
	    	$(".noDealModal").modal('hide');
	    });
	    
	    
	    
		function deal_submit() {
			var f = $("#form-deal").serialize();
			$.post('${rootPath}order/orderDeal.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}order/list.html";
				} 
				else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
			
		}
		
		function noDeal_submit() {
			var f = $("#form-noDeal").serialize();
			$.post('${rootPath}order/orderNoDeal.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}order/list.html";
				} 
				else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}		
		 function doDel(id){
			$.ajax({
				url: "${rootPath}user/del.do?id=" + id, 
				async: true,
				success: function(o) {
					window.location.reload();
				},
				error: function(o) {
					alert(2);
				}
			});		
		} 
	</script>

</body>
</html>
