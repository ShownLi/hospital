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
					<i class="fa fa-user"></i>统计分析<span>跟单员询单状态统计</span>
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
						<h3 class="panel-title">跟单员询单状态统计</h3>
						<div class="row" style="margin-top: 20px">
							<div class="form-group col-sm-10">
								<div class="col-sm-2">
									<input type="text" id="searchSource" class="source-select form-control" placeholder="来源"  value="" />
								</div>
								<div class="col-sm-2">
									<div class="input-group input-datepicker" style="padding: 0;">
				                        <input id="searchStartCreateDateTime" type="text" name="searchStartDateTime" class="form-control datepicker" placeholder="请点击输入查询开始日期" autocomplete="on" value="${startTime }">
				                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                    </div>
				                </div>
			                    <div class="col-sm-2">
				                    <div class="input-group input-datepicker" style="padding: 0;">
				                        <input id="searchEndCreateDateTime" type="text" name="searchEndDateTime" class="form-control datepicker" placeholder="请点击输入查询截止日期" autocomplete="on" value="${endTime }">
				                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                    </div>
			                    </div>
							 
								</div>	
									<div class="col-sm-2">					 		                        		
									<input class="btn btn-primary" type="button" id="searchBtn" value="搜索"/>
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
										<th>跟单员</th>
										<th>待处理 </th>									
										<th>沟通中</th>
										<th>地接设计中 </th>
										<th>成行</th>
										<th>未成行</th>
										<th>无效</th>
										<th>已付款</th>
										<!-- <th>成交金额</th>
										<th>收款金额</th> -->
										<th>询单数量</th>
										<th>成交率</th>
									</tr>
								</thead>
							</table>
							<table id="dataTable2" class="table">
								<thead>
									<tr>
										<th></th>
										<th>待处理 </th>									
										<th>沟通中</th>
										<th>地接设计中 </th>
										<th>成行</th>
										<th>未成行</th>
										<th>无效</th>
										<th>已付款</th>
										<th>询单数量</th>
										<th>成交率</th>
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
	var source = ${source}; 
	
	$(".source-select").select2({
        placeholder: '来源',
        data: source
    });
    jQuery("#searchStartCreateDateTime").datepicker({
        dateFormat: "yy-mm-dd",
        changeYear: true,
        changeMonth: true,
     });
    
    jQuery("#searchEndCreateDateTime").datepicker({
        dateFormat: "yy-mm-dd",
        changeYear: true,
        changeMonth: true,
     });
	var t = jQuery('#dataTable').DataTable({
		searching:false,
		paging:false,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		bInfo : false,
		ajax: {
			url: '${rootPath}statistics/usercasestatusstats.do',
			data: function(data){
				var searchSource=$('#searchSource').val();
	 			var searchStartDateTime=$("#searchStartCreateDateTime").val();
	 			var searchEndDateTime=$("#searchEndCreateDateTime").val();
	 			
	 			if(searchSource !=null && searchSource !="" ){
					data.source = searchSource;
	 			}
	 			if(searchStartDateTime !=null && searchStartDateTime !=""){
	 				data.startCreateDateTime = searchStartDateTime;
	 			}
	 			if(searchEndDateTime !=null && searchEndDateTime !=""){
	 				data.endCreateDateTime = searchEndDateTime;
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
					   data:"userName",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + data + "</div>"
	                },
	                targets: 0
				},
					{
					data:"pendingNum",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 1
				},	  
					{
					data:"communicatingNum",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 2
				},	  
					{
					data:"agencyDesigningNum",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 3
				},	  
					{
	                data:"dealNum",
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 4
				},	  
					{
					data:"noDealNum",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 5
				},	  
					{
					data:"invalidNum",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 6
				},	  
					{
					data:"paidNum",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data+ "</div>"
	                },
	                targets: 7
				},
				{
					data:"total",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + data + "</div>"
	                },
	                targets: 8
				},
				{data:"dealPercent",
					orderable: false,
					render: function ( data ) {
					    return  data;
					},
					targets: 9
				}
				
			],
			columns: [
	            		{ data: "userName" },
			            { data: "pendingNum" },
			            { data: "communicatingNum" },
			            { data: "agencyDesigningNum" },
			            { data: "dealNum"},
			            { data: "noDealNum"},
			            { data: "invalidNum"},
			            { data: "paidNum"},
			            /* { data: "totalDealMoney"},
			            { data: "totalPaidMoney"}, */
			            { data:	"total"},
			            { data: "dealPercent"}
	        ]
		});

	var t2 = jQuery('#dataTable2').DataTable({
		searching:false,
		paging:false,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		bInfo : false,
		ajax: {
			url: '${rootPath}statistics/usercasestatusstatstotal.do',
			data: function(data){
				var searchSource=$('#searchSource').val();
	 			var searchStartDateTime=$("#searchStartCreateDateTime").val();
	 			var searchEndDateTime=$("#searchEndCreateDateTime").val();
	 			
	 			if(searchSource !=null && searchSource !="" ){
					data.source = searchSource;
	 			}
	 			if(searchStartDateTime !=null && searchStartDateTime !=""){
	 				data.startCreateDateTime = searchStartDateTime;
	 			}
	 			if(searchEndDateTime !=null && searchEndDateTime !=""){
	 				data.endCreateDateTime = searchEndDateTime;
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
					   data:"",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div class='minw50'>" + "<h3>" + '合计'  + "</h3>" + "</div>"
	                },
	                targets: 0
				},
					{
					data:"pendingNum",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 1
				},	  
					{
					data:"communicatingNum",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 2
				},	  
					{
					data:"agencyDesigningNum",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 3
				},	  
					{
	                data:"dealNum",
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 4
				},	  
					{
					data:"noDealNum",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 5
				},	  
					{
					data:"invalidNum",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 6
				},	  
					{
					data:"paidNum",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data+ "</div>"
	                },
	                targets: 7
				},
				{
					data:"total",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + data + "</div>"
	                },
	                targets: 8
				},
				{data:"dealPercent",
					orderable: false,
					render: function ( data ) {
					    return  data;
					},
					targets: 9
				}
				
			],
			columns: [
	            		{ data: "" },
			            { data: "pendingNum" },
			            { data: "communicatingNum" },
			            { data: "agencyDesigningNum" },
			            { data: "dealNum"},
			            { data: "noDealNum"},
			            { data: "invalidNum"},
			            { data: "paidNum"},
			            { data:	"total"},
			            { data: "dealPercent"}
	        ]
		});
	
		$('#searchBtn').on( 'click', function () {
	        t.draw();
	        t2.draw();
	    } );
		// Select2
	    jQuery('select').select2({
	        minimumResultsForSearch: -1
	    });
	    
	    jQuery('select').removeClass('form-control');
		
	</script>
</body>
</html>
