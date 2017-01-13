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
					<i class="fa fa-user"></i> 财务管理 <span>财务管理列表</span>
				</h2>				 
			</div>
			
			<div class="contentpanel">
				<!-- content goes here... -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-btns">
							<a href="" class="minimize">&minus;</a>
						</div>
						<h3 class="panel-title">财务管理列表</h3>
						<div class="row" style="margin-top: 20px">
							<div class="form-group col-sm-10">
								<div class="col-sm-2">
									<input type="text" name="orderCode" id="searchOrderCode" class="form-control" placeholder="订单编号"  value="" />
								</div>
								<div class="col-sm-2">
									<div class="input-group input-datepicker" style="padding: 0;">
				                        <input readonly="readonly" id="searchStartTime" type="text" name="searchStartTime" class="form-control datepicker" placeholder="请点击输入查询开始日期" value="" autocomplete="on">
				                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                    </div>
				                </div>
			                    <div class="col-sm-2">
				                    <div class="input-group input-datepicker" style="padding: 0;">
				                        <input readonly="readonly" id="searchEndTime" type="text" name="searchEndTime" class="form-control datepicker" placeholder="请点击输入查询截止日期" value="" autocomplete="on">
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
						<div class="table-responsive">

							<table id="dataTable" class="table">
								<thead>
									<tr>
										<th>订单编号</th>
										<th>预算成本</th>
										<th>预算价格</th>									
										<th>实付成本</th>
										<th>实收价格 </th>
										<th>成本调整</th>
										<th>收入调整</th>
										<th>欠付</th>
										<th>欠收</th>
										<th>财务状态</th>
										<th>操作</th>
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

	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	<script src="${rootPath}assets/js/datepicker-zh-CN.js"></script>
	<script src="${rootPath}assets/js/datetimepicker-cn.js"></script>

	<script type="text/javascript">
	//设置日历控件
	 $("#searchStartTime").datepicker({
	        dateFormat: "yy-mm-dd",
	        changeYear: true,
	        changeMonth: true
	     });
	    
   	$("#searchEndTime").datepicker({
        dateFormat: "yy-mm-dd",
        changeYear: true,
        changeMonth: true
     });
	var table= $('#dataTable').DataTable({
		searching:false,
		pageLength: 10,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		stateSave: true,
		ajax: {
			url: '${rootPath}finance/list.do',
			data:function(data){
				data.status='2';//设置订单状态成行
				data.orderCode =$("#searchOrderCode").val();
				data.startTime =$("#searchStartTime").val();
				data.endTime =$("#searchEndTime").val();
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
		            	 targets: 0,
		            	 data: "orderCode",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data
		            		 }
		             },
		             {
		            	 targets: 1,
		            	 data: "costBudgetRmb",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data
		            		 }
		             },
		             {
		            	 targets: 2,
		            	 data: "rmbPrice",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data
		            		 }
		             },
		             {
		            	 targets: 3,
		            	 data: "costReal",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data;
		            		 }
		             },
		             {
		            	 targets: 4,
		            	 data: "priceReal",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data;
		            		 }
		             },
		             {
		            	 targets: 5,
		            	 data: "costAdjust",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data;
		            		 }
		             },
		             {
		            	 targets: 6,
		            	 data: "priceAdjust",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data;
		            		 }
		             },
		             {
		             	 //欠付
		            	 targets: 7,
		            	 orderable: false,
		            	 render: function(data) {
		            		 return "xxx";
		            		 }
		             },
		             {
		            	 //欠收
		            	 targets: 8,
		            	 orderable: false,
		            	 render: function(data) {
		            		 return "xx";
		            		 }
		             },
		             {
		            	 targets: 9,
		            	 data: "financeStatus",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return data
		            		 }
		             },
		             {
		            	 targets: 10,
		            	 data: "orderId",
		            	 orderable: false,
		            	 render: function(data) {
		            		 return '<a class="btn btn-success btn-xs" href="${rootPath}finance/edit.html?id='+data+'"><span class="fa fa-edit"></span> 编辑</a>';
		            		 }
		             }
		             ],
		columns: [
		            { data: "orderCode" },
		            { data: "costBudgetRmb" },
		            { data: "rmbPrice" },
		            { data: "costReal" },
		            { data: "priceReal" },
		            { data: "costAdjust" },
		            { data: "priceAdjust" },
		            { data: "financeStatus"},
		            { data: "orderId"}
		        ]
		});
	//设置搜索的点击事件
	 $('#searchBtn').on( 'click', function () {
	        table.draw();
	    } );
	</script>
</body>
</html>
