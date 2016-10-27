<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../assets/pages/head.jsp"%>
<link href="${rootPath }assets/css/jquery.datatables.css" rel="stylesheet">
</head>

<body>
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
									<input type="text" id="searchCustomerName" class="form-control" placeholder="客人姓名" value="" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchOrderId" class="form-control" placeholder="订单id"  value="" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchAgencyName" class="form-control" placeholder="地接社" value="" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchSalesName" class="form-control" placeholder="销售姓名" value="" />
								</div>
								<!-- <div class="col-sm-2">
									<input type="text" id="searchDestination" class="destination-select fullwidth" value="" />
								</div> -->
								<div class="col-sm-2">
									<input type="text" id="searchStatus" class="status-select fullwidth" value="" />
								</div>
							</div>	
							<div class="col-sm-2">					 		                        		
								<input class="btn btn-primary" type="button" id="searchBtn" value="搜索"/>
							</div> 	
						</div>
					

					</div>
					<div class="panel-body">
						<br />
						<div class="table-responsive">

							<table id="dataTable" class="table">
								<thead>
									<tr>
										<th>ID</th>
										<th>客人姓名</th>
										<th>地接社</th>
										<th>销售姓名</th>
										<th>目的地</th> 
 <!-- 									<th>预算</th> -->
										<th>状态</th>
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

<!-- Modal -->
<!-- <div class="modal fade" id="confirmDelModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
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
    </div>modal-content
  </div>modal-dialog
</div>modal
 -->
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
                      <label class="col-sm-4 control-label">成团人数<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="groupNumber" placeholder="成团人数" class="form-control"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团价格<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="groupPrice" placeholder="成团价格" class="form-control" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">货币种类<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="currency" placeholder="货币种类" class="currency-select fullwidth"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">汇率<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="exchangeRate" placeholder="汇率" class="form-control" value="" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">人民币价格<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="rmbPrice" placeholder="人民币价格" class="form-control"/>
                      </div>
                  </div>
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
<div class="noDealModal modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">请填写以下订单信息</div>
      </div>
      <div class="modal-body">
          <form class="form-horizontal" id="form-noDeal">
              <div class="section-block noline">
                  <div class="form-group col-sm-12">
                    <label class="col-sm-4 control-label">若未成行，原因是</label>
                    <div class="col-sm-8">
                      <input class="reason-select fullwidth" name="reason" placeholder="若未成行，原因是" />
                      <input  type="hidden" id="noDealOrderid" name="orderId" />
                      <%--
                      <input  type="hidden" name="caseid" value="0"/>
                      <input  type="hidden" name="customerid" value="0"/>
                      --%>
                    </div>
                  </div>
              </div><!-- noDealModal-body -->
          </form>
      </div>
      <div class="modal-footer align-center">
          <a class="submit btn btn-primary" >保存</a>
          <a class="cancel btn btn-primary" >取消</a>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- bmodal -->

	<script type="text/javascript">
	var orderStatus = ${orderStatus};
	var destination = ${destination};
	var reason = ${reason};
	var currency=${currency};
	
 	$(".destination-select").select2({
        placeholder: '国家',
        data: destination
    }); 
	
	$(".currency-select").select2({
        data: currency,
    });
	
	$(".status-select").select2({
        placeholder: '状态',
        data: orderStatus
    });
	
		jQuery(document).ready(function() {			
			jQuery("#form-deal").validate({
		        rules: {
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
//	                number: true
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
	          },
	          submitHandler : function(){
	              deal_submit();
	              return false;
	          } 
	        });
	       });  	     	   	    		      		
			
			 var t = jQuery('#dataTable').DataTable({
			 	pageLength: 10,
			 	processing: true,
			 	language: datatable_local_language, // my.js
			 	serverSide: true,
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
						       {
						          data: "orderId",
						 	      orderable: false,
						 	      render: function ( data, type, full, meta ) {
					              	return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>&nbsp<a class="btn btn-primary btn-xs" id="'+data+'"></span> 成行</a>&nbsp<a class="btn btn-default btn-xs" id="'+data+'"></span> 未成行</a>&nbsp;';
						 	  	  },
						 	    	targets: 6
						 		},
								{
					                data: "status",
					                orderable: false,
					                render: function ( data ) {
					                	if(data){
						                	for(var i=0;i < orderStatus.length;i++){
						                		if(data==orderStatus[i].id){
						                			return orderStatus[i].text
						                		}
						                	}
						                	return ""
					                	}
					                	else{return ""}
					                },
					                  targets: 5
								},
								 {
					                data: "destination",
					                orderable: false,
					                render: function ( data ) {
					                	if(data){

						                	for(var i=0;i <destination.length;i++){
						                		if(data==destination[i].id){
						                			return destination[i].text
						                		}
						                	}
						                	return "";
					                	}
					                	else{return ""}
					                },

					                  targets: 4
								}, 					

						 	  {
						 		  orderable: false,
						 		  searchable: false,
						 	      targets: [0,1,2]
						 	  },
						 	],
			 	columns: [
		             { data: "orderId" },
		             { data: "customerName" },
		             { data: "agencyName" },
		             { data: "salesName" },
		             { data: "destination" },
//		             { data: "budget" },
		             { data: "status" }
		         ]
			 });
			
			  $('#searchBtn').on( 'click', function () {
			    	//alert($('#customerName').attr("value"));
			        t.draw();
			    } );
		    
		    
			    
			 $('#dataTable tbody').on( 'click', 'a.btn-success', function () {
		         var data = t.row($(this).parents('tr')).data();
		         edit($(this).attr('id'));
		     } );
			
			 $('#dataTable tbody').on( 'click', 'a.btn-primary', function () {
		         var data = t.row($(this).parents('tr')).data();
		         group($(this).attr('id'));
		         $("#dealOrderId").val($(this).attr('id'));
		     } );

			 $('#dataTable tbody').on( 'click', 'a.btn-default', function () {
		         var data = t.row($(this).parents('tr')).data();
		         nogroup($(this).attr('id'));
		         $("#noDealOrderid").val($(this).attr('id'));
		     } );
			 
			  $('#confirmDelModal').on( 'click', 'button.btn-danger', function () {
		         var id = $("#confirmDelModal .hiddenId").val();
		         doDel(id);
		     } );  
		    
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
			$(".noDealModal").modal('show');
		}
		// Date Picker
		jQuery(".datepicker").datepicker({
			  dateFormat: "yy-mm-dd"
	  	});
 	    $(".dealModal .submit").click(function(){
	    	deal_submit();
	      }); 
	    $(".noDealModal .submit").click(function(){
	    	noDeal_submit();
	      });
	    
	    $(".dealModal .cancel").click(function(){
	    	$(".dealModal").modal('hide');
	    });
	    $(".noDealModal .cancel").click(function(){
	    	$(".noDealModal").modal('hide');
	    })
	    
	    $(".reason-select").select2({
	    	placeholder:"未成行原因",
	    	data:reason
	    }) 
	    
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
