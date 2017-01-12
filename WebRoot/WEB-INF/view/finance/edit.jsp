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
					<i class="fa fa-user"></i> 财务管理 <span>财务管理</span>
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
								<label class="col-sm-4 control-label" id="oweCost">XXX</label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">欠收</label> 
								<label class="col-sm-4 control-label" id="owePrice">XXX</label>
							</div>

						</div>
						<div class="panel-footer align-center">
							<input class="btn btn-primary" type="button" value="结算" /> 
							<input type="hidden" name="orderId" value="${order.orderId}" />
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
									<th>收款方</th>
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
	<%@ include file="../assets/pages/foot.jsp"%>

	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	<script src="${rootPath}assets/js/datepicker-zh-CN.js"></script>
	<script src="${rootPath}assets/js/datetimepicker-cn.js"></script>

	<script type="text/javascript">
	/* $("#").html(); */
	/* $("#orderCode").html();
	$("#costBudget").html();
	$("#groupPrice").html();
	$("#exchangeRate").html();
	$("#currency").html();
	$("#costBudgetRmb").html();
	$("#rmbPrice").html();
	$("#costReal").html();
	$("#priceReal").html();
	$("#costAdjust").html();
	$("#priceAdjust").html();
	$("#oweCost").html("abc");
	$("#owePrice").html(); */
	$(document).ready(function(){
		loadOrderInfo(${orderId});
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
				$("#exchangeRate").html(res.exchangeRate)
				$("#currency").html(res.currency);
				$("#costBudgetRmb").html(res.costBudgetRmb);
				$("#rmbPrice").html(res.rmbPrice);
				$("#costReal").html(res.costReal);
				$("#priceReal").html(res.priceReal);
				$("#costAdjust").html(res.costAdjust);
				$("#priceAdjust").html(res.priceAdjust);
				$("#oweCost").html("abc");
				$("#owePrice").html();
			},
			error:function(res){
				
			}
		})
	};
	
	//加载收款记录
	var pricetable= $('#dataTable-priceRecord').DataTable({
		searching:false,
		paging: false,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		stateSave: true,
		ajax: {
			url: '${rootPath}finance/getPriceRecordList.do',
			data:{"id":${orderId}},
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
		            		 return data
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
		            		 return data;
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
		            		 return data;
		            		 }
		             },
		             {
		             	 
		            	 targets: 7,
		            	 data:"receivedTime",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return "xxx";
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
		            	 targets: 11,
		            	 //欠收
		            	 orderable: false,
		            	 render: function(data) {
		            		 return "xxx";
		            		 }
		             },
		             {
		            	 targets: 12,
		            	 data: "summary",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data;
		            		 }
		             }
		             ,
		             {
		            	 targets: 13,
		            	 data: "priceId",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return '<a class="btn btn-success btn-xs" href="${rootPath}finance/edit.html?id='+data+'"><span class="fa fa-edit"></span> 编辑</a>';
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
		            { data: "summary"},
		            { data: "priceId"}
		        ]
		});
	
	var costtable= $('#dataTable-costRecord').DataTable({
		searching:false,
		paging: false,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		stateSave: true,
		ajax: {
			url: '${rootPath}finance/getCostRecordList.do',
			data:{"id":${orderId}},
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
		            		 return "xxx";
		            		 }
		             },
		             {
		            	 //欠付
		            	 targets: 9,
		            	 orderable: false,
		            	 render: function(data) {
		            		 return "xx";
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
	</script>
</body>
</html>
