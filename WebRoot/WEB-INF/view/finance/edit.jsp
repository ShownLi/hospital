<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../assets/pages/head.jsp"%>
<link href="${rootPath }assets/css/jquery.datatables.css"
	rel="stylesheet">
</head>

<body class="leftpanel-collapsed">
	<%@ include file="../assets/pages/preloader.jsp"%>
	<section>
		<%@ include file="../assets/pages/leftpanel.jsp"%>
		<div class="mainpanel">
			<%@ include file="../assets/pages/headerbar.jsp"%>
			<div class="pageheader">
				<h2>
					<i class="fa fa-user"></i>财务管理 <span>财务管理</span>
				</h2>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-btns">
						<a href="" class="minimize">&minus;</a>
					</div>
					<h4 class="panel-title">订单详情</h4>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<div class="panel-body panel-body-nopadding">
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">订单编号</label> 
								<label class="col-sm-4 control-label" id="orderCode"></label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">预算成本（外币）</label>
								<label class="col-sm-4 control-label" id="costBudget"></label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">预算价格（外币）</label>
								<label class="col-sm-4 control-label" id="groupPrice"></label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">汇率</label>
								<label class="col-sm-4 control-label" id="exchangeRate"></label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">币种</label>
								<label class="col-sm-4 control-label" id="currency"></label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">预算成本</label> 
								<label class="col-sm-4 control-label" id="costBudgetRmb"></label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">预算价格</label> 
								<label class="col-sm-4 control-label" id="rmbPrice"></label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">实付成本</label> 
								<label class="col-sm-4 control-label" id="costReal"></label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">实收价格</label> 
								<label class="col-sm-4 control-label" id="priceReal"></label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">成本调整</label> 
								<label class="col-sm-4 control-label" id="costAdjust"></label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">收入调整</label> 
								<label class="col-sm-4 control-label" id="priceAdjust"></label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">欠付</label> 
								<label class="col-sm-4 control-label" id="oweCost"></label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">欠收</label> 
								<label class="col-sm-4 control-label" id="owePrice"></label>
							</div>

						</div>
						<div class="panel-footer align-center">
						<form action="${rootPath }finance/orderBalance.do" method="get">
							<input class="btn btn-primary" id="btnBalance" type="submit" value="结算" /> 
							<input type="hidden" id="orderId" name="orderId" value="${orderId}" />
						</form>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-btns">
						<a href="" class="minimize">&minus;</a>
					</div>
					<h4 class="panel-title">收款记录</h4>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table id="dataTable-priceRecord" class="table table-communicate">
							<thead>
								<tr>
									<th>收款编号</th>
									<th>款项</th>
									<th>应收金额</th>
									<th>收款截止日期</th>
									<th>备注</th>
									<th>实收金额</th>
									<th>收款账户</th>
									<th>收款日期</th>
									<th>录入人</th>
									<th>状态</th>
									<th>调整金额</th>
									<th>欠收</th>
									<th>摘要</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-btns">
						<a href="" class="minimize">&minus;</a>
					</div>
					<h4 class="panel-title">付款记录</h4>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table id="dataTable-costRecord" class="table table-communicate">
							<thead>
								<tr>
									<th>付款ID</th>
									<th>供应商</th>
									<th>款项</th>
									<th>应付金额</th>
									<th>备注</th>
									<th>实付金额</th>
									<th>支付日期</th>
									<th>录入人</th>
									<th>调整金额</th>
									<th>欠付</th>
									<th>摘要</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="../assets/pages/rightpanel.jsp"%>
	</section>
	<!-- 弹出框 -->
	<div class="priceRecordModal modal fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<div class="nextModal-title">收款编辑</div>
				</div>
				<form class="form-horizontal" id="form-priceRecordEdit" >
					<div class="modal-body">
						<div class="section-block noline">
							<div class="form-group col-sm-12">
								<label class="col-sm-4 control-label">款项</label>
								<label class="col-sm-8 " id="priceFormPayItem">团款</label>
							</div>
							<div class="form-group col-sm-12">
								<label class="col-sm-4 control-label">应收金额</label>
								<label class="col-sm-8 " id="priceFormPriceBudget"></label>
							</div>
							<div class="form-group col-sm-12">
								<label class="col-sm-4 control-label">实收金额</label>
								<input class="col-sm-8 " id="priceFormPriceReal" name="priceReal" placeholder="实收金额"/>
							</div>
							<div class="form-group col-sm-12">
								<label class="col-sm-4 control-label">收款账户</label>
								<div class="col-sm-8">
			                      <input type="text" id="priceFormAccount" value="1" name="account" class="price-account-select control-label"/>
			                    </div>
							</div>
							<div class="form-group col-sm-12">
								<label class="col-sm-4 control-label">收款日期</label>
								<div class="col-sm-8">
									<div class="input-group input-datepicker" style="padding: 0;">
				                        <input readonly="readonly" id="priceFormReceivedTime" type="text" name="receivedTime" class="form-control datepicker" placeholder="收款日期" autocomplete="on">
				                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                </div>
				            </div>
							</div>
							<div class="form-group col-sm-12">
								<label class="col-sm-4 control-label">摘要</label>
								<textarea class="col-sm-8 " name="summary" id="priceFormSummary">款项</textarea>
							</div>
						</div>
					</div>
					<div class="modal-footer align-center">
						<input type="submit" class="submit btn btn-primary" value="保存"/>
						<input type="hidden" id="priceFormPriceCode" name="priceCode">
						<input type="hidden" name="orderId" value="${orderId}" />
						<a class="cancel btn btn-primary">取消</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 金额调整 -->
	<div class="priceAdjustModal modal fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<div class="nextModal-title">调整金额</div>
				</div>
				<form class="form-horizontal" id="form-priceAdjust" >
					<div class="modal-body">
						<div class="section-block noline">
							
							<div class="form-group col-sm-12">
								<label class="col-sm-4 control-label">应收金额</label>
								<label class="col-sm-8 " id="AdjustFormPriceBudget"></label>
							</div>
							<div class="form-group col-sm-12">
								<label class="col-sm-4 control-label">实收金额</label>
								<label class="col-sm-8 " id="AdjustFormPriceReal"></label>
							</div>
							<div class="form-group col-sm-12">
								<label class="col-sm-4 control-label">调整金额</label>
								<input class="col-sm-8 " id="AdjustFormPriceAdjust" name="priceAdjust" placeholder="调整金额"/>
							</div>
						</div>
					</div>
					<div class="modal-footer align-center">
						<input type="submit" class="submit btn btn-primary" value="保存"/>
						<input type="hidden" id="AdjustFormPriceCode" name="priceCode">
						<input type="hidden" name="orderId" value="${orderId}" />
						<a class="cancel btn btn-primary">取消</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="../assets/pages/foot.jsp"%>

	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	<script src="${rootPath}assets/js/datepicker-zh-CN.js"></script>
	<script src="${rootPath}assets/js/datetimepicker-cn.js"></script>

	<script type="text/javascript">
	//收款账户列表
	var accountData = ${accountList};
	var currencyList = ${currencyList};
	$("#priceFormReceivedTime").datepicker({
		placeholder:"收款日期",	
        dateFormat: "yy-mm-dd",
        changeYear: true,
        changeMonth: true
     });
	
	
	$(document).ready(function(){
		
		loadOrderInfo($("#orderId").val());
	});
	//ajax方式加载order详情
	 function loadOrderInfo(orderId) {
		$.ajax({
			url:"${rootPath}/finance/getOrder.do",
			type:"post",
			data:{"id":orderId},
			dataType:"json",
			async:true,
			success:function(res){
				$("#orderCode").html(res.orderCode);
				$("#costBudget").html(res.costBudget);
				$("#groupPrice").html(res.groupPrice);
				$("#exchangeRate").html(res.exchangeRate);
				$("#currency").html(changeValueToText(res.currency,currencyList));
				$("#costBudgetRmb").html(res.costBudgetRmb);
				$("#rmbPrice").html(res.rmbPrice);
				$("#costReal").html(res.costReal);
				$("#priceReal").html(res.priceReal);
				$("#costAdjust").html(res.costAdjust);
				$("#priceAdjust").html(res.priceAdjust);
				$("#oweCost").html(res.costBudgetRmb-res.costReal-res.costAdjust);
				$("#owePrice").html(res.rmbPrice-res.priceReal-res.priceAdjust);
				judgeBalance();
			},
			error:function(res){
				
			}
		})
	};
	//将value值转换为text文本值
	function changeValueToText(value,array){
		for(var i = 0 ; i< array.length ; i++){
			if(array[i].id==value)
				return array[i].text;
		}
		return "";
	}
	
	//加载收款记录
	var priceTable= $('#dataTable-priceRecord').DataTable({
		searching:false,
		paging: false,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		stateSave: true,
		ajax: {
			url: '${rootPath}finance/getPriceRecordList.do',
			data:{"id":$("#orderId").val()},
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
		            	 targets: 0,
		            	 data: "priceCode",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data
		            		 }
		             },
		             {
		            	 targets: 1,
		            	 data: "paymentItem",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return changeValueToText(data,${payItemList});
		            		 }
		             },
		             {
		            	 targets: 2,
		            	 data: "priceBudget",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data
		            		 }
		             },
		             {
		            	 targets: 3,
		            	 data: "deadline",
		            	 orderable: false,
		            	 render: function(data) {
		            		 if(data)
		            			 return new Date(data).format("yyyy-MM-dd hh:mm:ss");
		            		 else
		            			 return '';
		            		 }
		             },
		             {
		            	 targets: 4,
		            	 data: "comment",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data;
		            		 }
		             },
		             {
		            	 targets: 5,
		            	 data: "priceReal",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data;
		            		 }
		             },
		             {
		            	 targets: 6,
		            	 data: "account",//收款账户
		            	 orderable: false,
		            	 render: function(data) {
		            		 return changeValueToText(data,${accountList})+"<input type='hidden' name='rowAccount' value='"+data+"'/>";
		            		 }
		             },
		             {
		            	 targets: 7,
		            	 data:"receivedTime",
		            	 orderable: false,
		            	 render: function(data) {
		            		 if(data)
			            		 return new Date(data).format("yyyy-MM-dd");
		            		 else
			            		 return '';
		            		 }
		             },
		             {
		            	 data:"recorder",
		            	 targets: 8,
		            	 orderable: false,
		            	 render: function(data) {
		            		 return "xx";
		            		 }
		             },
		             {
		            	 targets: 9,
		            	 data: "status",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data
		            		 }
		             },
		             {
		            	 targets: 10,
		            	 data: "priceAdjust",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data;
		            		 }
		             },
		             {
		            	 //欠收
		            	 targets: 11,
		            	 orderable: false,
		            	 render: function( data, type, full, meta ) {
		            		 return full.priceBudget-full.priceReal-full.priceAdjust;
		            		 }
		             },
		             {
		            	 targets: 12,
		            	 orderable: false,
		            	 render: function( data, type, full, meta ) {
		            		 return full.summary;
		            		 }
		             },
		             {
		            	 targets: 13,
		            	 data: "priceId",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return '<span onclick="priceModelShow(this)" class="btnPriceEdit btn btn-success btn-xs" ><span class="fa fa-edit"></span> 编辑</span>&nbsp;'+
		            		 '<span onclick="priceAdjustModelShow(this)" class="btnPriceAdjust btn btn-success btn-xs" ><span class="fa fa-edit"></span> 金额调整</span>';
		            		 }
		             }
		             ],
		columns: [
          			{ data: "priceCode" },
		            { data: "paymentItem" },
		            { data: "priceBudget" },
		            { data: "deadline" },
		            { data: "comment" },
		            { data: "priceReal" },
		            { data: "account" },
		            { data: "receivedTime" },
		            { data: "recorder"},
		            { data: "status"},
		            { data: "priceAdjust"},
		            { data: "priceId"}
		        ]
		});
	
	 //收款编辑按钮弹出框
   function priceModelShow(element){
		 var ele = $(element).parent().siblings();
		 $("#priceFormPriceCode").val(ele.eq(0).html());
		 $("#priceFormPayItem").html(ele.eq(1).html());
		 $("#priceFormPriceBudget").html(ele.eq(2).html());
		 $("#priceFormPriceReal").val(ele.eq(5).html());
		 $("#priceFormAccount").val(ele.children("input").val());
		 //让账号输入框转变称下拉框，顺序一定要先赋值再使用select2
		 $(".price-account-select").select2({
				placeholder: '选择收款账户',
				data:accountData,
				allowClear:true
			 });
		 $("#priceFormReceivedTime").val(ele.eq(7).html());
		 $("#priceFormSummary").html(ele.eq(12).html());
		 
    	 $(".priceRecordModal").modal('show');
    };
    //收款金额调整
   function priceAdjustModelShow(element){
		 var ele = $(element).parent().siblings();
		 $("#AdjustFormPriceCode").val(ele.eq(0).html());
		 $("#AdjustFormPriceBudget").html(ele.eq(2).html());
		 $("#AdjustFormPriceReal").html(ele.eq(5).html());
		 $("#AdjustFormPriceAdjust").val(ele.eq(10).html());
    	 $(".priceAdjustModal").modal('show');
    };
    //设置取消键隐藏
    $(".priceRecordModal .cancel").click(function(){
      	$(".priceRecordModal").modal("hide");
  	  });
  //设置取消键隐藏
    $(".priceAdjustModal .cancel").click(function(){
      	$(".priceAdjustModal").modal("hide");
  	  });
    
	var costTable= $('#dataTable-costRecord').DataTable({
		searching:false,
		paging: false,
		processing: true,
		language: datatable_local_language, //my.js
		serverSide: true,
		stateSave: true,
		ajax: {
			url: '${rootPath}finance/getCostRecordList.do',
			data:{"id":$("#orderId").val()},
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
		            	 targets: 0,
		            	 data: "costId",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data
		            		 }
		             },
		             {
		            	 targets: 1,
		            	 data: "agencyId",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data
		            		 }
		             },
		             {
		            	 targets: 2,
		            	 data: "paymentItem",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data
		            		 }
		             },
		             {
		            	 targets: 3,
		            	 data: "costBudget",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data
		            		 }
		             },
		             {
		            	 targets: 4,
		            	 data: "comment",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data;
		            		 }
		             },
		             {
		            	 targets: 5,
		            	 data: "costReal",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data;
		            		 }
		             },
		             {
		            	 targets: 6,
		            	 data: "payTime",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data;
		            		 }
		             },
		             {
		            	 targets: 7,
		            	 data: "recorder",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data;
		            		 }
		             },
		             {
		             	 
		            	 targets: 8,
		            	 data:"costAdjust",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data;
		            		 }
		             },
		             {
		            	 //欠付
		            	 targets: 9,
		            	 orderable: false,
		            	 render: function( data, type, full, meta ) {
		            		 return full.costBudget-full.costReal-full.costAdjust;
		            		 }
		             },
		             {
		            	 targets: 10,
		            	 data: "summary",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data
		            		 }
		             },
		             {
		            	 targets: 11,
		            	 data: "costId",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data;
		            		 }
		             }
		             ],
		columns: [
          			{ data: "costId" },
		            { data: "agencyId" },
		            { data: "paymentItem" },
		            { data: "costBudget" },
		            { data: "comment" },
		            { data: "costReal" },
		            { data: "payTime" },
		            { data: "recorder" },
		            { data: "costAdjust"},
		            { data: "summary"}
		        ]
		});
	//收款编辑表单验证
	$("#form-priceRecordEdit").validate({
        rules: {
        	priceReal: {
	        	required: true,
                number: true
	        },	
            account:{
            	required: true
            },
            receivedTime:{
            	required: true
            },
            summary:{
            	required: true
            }
		},				
     	 messages: {
     		priceReal: '请输入正确的实收金额',	
	        account:'请选择收款账户',
            receivedTime:'请选择收款时间',
            summary:'请输入摘要'
      	 },			      
          highlight: function(element) {
        	  $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
          },
          success: function(element) {
        	  $(element).closest('.form-group').removeClass('has-error');
          },
          invalidHandler : function(){
            return false;
          },
          submitHandler : function(){
        	  //编辑表单提交
        	  priceFormSubmit();
              return false;
          } 
    });
	
	function priceFormSubmit(){
		$.ajax({
			url:"${rootPath}/finance/updatePriceRecord.do",
			type:"post",
			data:$("#form-priceRecordEdit").serialize(),
			dataType:"json",
			async:true,
			success:function(res){
				alert("res"+res);
				//重新加载order数据
				loadOrderInfo($("#orderId").val());
				//重新判断结算按钮是否可用
				judgeBalance();
				//重绘priceTable的数据
				priceTable.draw();
				$(".priceRecordModal").modal("hide");
			},
			error:function(res){
				alert("操作失败，请刷新界面");
			}
		})
	}
	
	//收款金额调整表单验证
	$("#form-priceAdjust").validate({
        rules: {
        	priceAdjust: {
	        	required: true,
                number: true
	        }
		},				
     	 messages: {
     		priceAdjust: '请输入调整金额'
      	 },			      
          highlight: function(element) {
        	  $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
          },
          success: function(element) {
        	  $(element).closest('.form-group').removeClass('has-error');
          },
          invalidHandler : function(){
            return false;
          },
          submitHandler : function(){
        	  //编辑表单提交
        	  priceAdjustFormSubmit();
              return false;
          } 
    });
	
	function priceAdjustFormSubmit(){
		$.ajax({
			url:"${rootPath}/finance/priceAdjust.do",
			data:$("#form-priceAdjust").serialize(),
			dataType:"json",
			async:true,
			success:function(res){
				alert("res"+res);
				//重新加载order数据
				loadOrderInfo($("#orderId").val());
				//重新判断结算按钮是否可用
				judgeBalance();
				//重绘priceTable的数据
				priceTable.draw();
				$(".priceAdjustModal").modal("hide");
			},
			error:function(res){
				alert("操作失败，请刷新界面");
			}
		})
	}
	//判断结算按钮是否可用
	function judgeBalance(){
		if($("#oweCost").html()==0&&$("#owePrice").html()==0){
			$("#btnBalance").attr("disabled",true);
		}else{
			$("#btnBalance").removeAttr("disabled");
		}
	}
	</script>
</body>
</html>
