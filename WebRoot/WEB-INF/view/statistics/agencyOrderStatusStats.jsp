﻿<%@ page language="java" pageEncoding="utf-8"%>
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
					<i class="fa fa-user"></i>统计分析<span>地接社订单状态统计</span>
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
						<h3 class="panel-title">地接社订单状态统计</h3>
						<div class="row" style="margin-top: 20px">
						<form action="${rootPath }/statistics/saveagencyorderstatus.do" method="post">
							<div class="form-group col-sm-10">
								<div class="col-sm-2">
									<input type="text" id="searchDestination" class="searchDestination-select fullwidth" name="destination"/>
								</div>
								<div class="col-sm-2">
									<div class="input-group input-datepicker" style="padding: 0;">
				                        <input readonly="readonly" id="searchStartDateTime" type="text" name="searchStartTime" class="form-control datepicker" value="${searchStartDateTime}" placeholder="请点击输入查询开始日期" autocomplete="on">
				                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                    </div>
				                </div>
			                    <div class="col-sm-2">
				                    <div class="input-group input-datepicker" style="padding: 0;">
				                        <input readonly="readonly" id="searchEndDateTime" type="text" name="searchEndTime" class="form-control datepicker" value="${searchEndDateTime}" placeholder="请点击输入查询截止日期" autocomplete="on">
				                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                    </div>
			                    </div>
							 
								</div>	
									<div class="col-sm-2">					 		                        		
									<input class="btn btn-primary" type="button" id="searchBtn" value="搜索"/>
									<input class="btn btn-primary" type="submit" value="导出"/>
								</div> 	
								</form>
							</div>

							</div>	
						</div>
					</div>
					<div class="panel-body">
						
						<div class="table-responsive">

							<table id="dataTable" class="table table-statistics">
								<thead>
									<tr>
										<th>地接社名称</th>
										<th>等待客人回复</th>									
										<th>等待地接社回复</th>
										<th>成行</th>
										<th>未成行</th>
										<th>付款</th>
										<th>订单数量</th>
										<th>成交金额</th>
										<th>成交比例</th>
									</tr>
								</thead>
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
	var destination = ${destination};
	
	$(".searchDestination-select").select2({
		placeholder: '目的地',
        data: destination
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
	var t = jQuery('#dataTable').DataTable({
		searching:false,
		pageLength: 10,
		processing: false,
		paging: false, // 禁止分页
		language: datatable_local_language, // my.js
		serverSide: true,
		bInfo : false,
		ajax: {
			url: '${rootPath}statistics/agencyOrderStatusStats.do',
			data: function(data){
	 			var searchDestination=$('#searchDestination').val();
	 			var searchStartDateTime=$("#searchStartDateTime").val();
	 			var searchEndDateTime=$("#searchEndDateTime").val();
	 			
	 			if(searchDestination !=null && searchDestination !="" ){
					data.destination = searchDestination;
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
				
				return JSON.stringify( json );
			}
		},
		columnDefs: [		  
				   {
					//地接社名称
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.agencyName + "</div>"
	                },
	                targets: 0
				},
				{
					//状态0的订单总数
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	
	                	return "<div>" + full.status0 + "</div>"
	                	 
	                	var destinations="";
	                },
	                targets: 1
				},	  
					{
					//状态1的订单总数
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	
	                	return "<div>" + full.status1 + "</div>"
	                },
	                targets: 2
				},	  
					{
					//状态2的订单总数
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	
	                	return "<div>" + full.status2 + "</div>"
	                },
	                targets: 3
				},	  
					{
					//状态3的订单总数
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	
	                	return "<div>" + full.status3 + "</div>"
	                },
	                targets: 4
				},	  
					{
					//状态4的订单总数
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	
	                	return "<div>" + full.status4 + "</div>"
	                },
	                targets: 5
				},	
				{
					//订单总数
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.total + "</div>"
	                },
	                targets: 6
				},
				{
					//成交金额
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	
	                	return "<div>" + full.dealMoney + "</div>"
	                },
	                targets: 7
				},	  
					{
					//成交比率
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	
	                	return "<div>" + full.rate + "</div>"
	                },
	                targets: 8
				},	  
			],
			columns: [
	            { data: "agencyName" },
	            { data: "status0" },
	            { data: "status1" },
	            { data: "status2" },
	            { data: "status3"},
	            { data: "status4"},
	            { data:"total"},
	            { data: "dealMoney"},
	            { data: "rate"}
	           
	        ]
		});
	
		$('#searchBtn').on( 'click', function () {
	        t.draw();
	    } );
		
		// Select2
	   jQuery('select').select2({
	       minimumResultsForSearch: -1
	   });
	   
	   jQuery('select').removeClass('form-control');
	</script>
</body>
</html>
