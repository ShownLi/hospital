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
					<i class="fa fa-user"></i>统计分析<span>商家覆盖统计</span>
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
						<h3 class="panel-title">商家覆盖统计</h3>
						<div class="row" style="margin-top: 20px">
						</div>
					</div>	
				</div>
			</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table id="dataTable" class="table">
								<thead>
									<tr>
										<th>目的地国家名称</th>
										<th>地接社数量</th>
									</tr>
								</thead>
							</table>
							<table id="dataTable2" class="table">
								<thead>
									<tr>
										<th></th>
										<th>目的地国家数量</th>
										<th>地接社数量</th>
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
	var searchFlag = false;
	var searchStatusCheck = "";
	
	var t = jQuery('#dataTable').DataTable({
		searching:false,
		pageLength: 10,
		processing: true,
		paging: false, // 禁止分页
		language: datatable_local_language, // my.js
		serverSide: true,
		bInfo : false,
		ajax: {
			url: '${rootPath}statistics/sellerCoverStats.do',
			data: function(data){
	 			var searchStatus = searchStatusCheck;
	 			searchStatusCheck = "";
	 			
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
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div class='minw50'>" + full.country + "</div>" 
	                },
	                targets: 0
				},
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.number + "</div>"
	                },
	                targets: 1
				}
			],
			columns: [
	            { data: "country" },
	            { data: "number" }
	        ]
		});
	
	var t2 = jQuery('#dataTable2').DataTable({
		searching:false,
		pageLength: 10,
		processing: true,
		paging: false, // 禁止分页
		language: datatable_local_language, // my.js
		serverSide: true,
		bInfo : false,
		ajax: {
			url: '${rootPath}statistics/sellerCoverStatsTotal.do',
			data: function(data){
	 			var searchStatus = searchStatusCheck;
	 			searchStatusCheck = "";
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
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div class='minw50'>" + "<h3>" + '合计'  + "</h3>" + "</div>" 
	                },
	                targets: 0
				},
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.countryTotal + "</div>"
	                },
	                targets: 1
				},
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.numberTotal + "</div>"
	                },
	                targets: 2
				}
			],
			columns: [
	            { data: "" },
	            { data: "countryTotal" },
	            { data: "numberTotal" }
	        ]
		});

	$('#searchBtn').on( 'click', function () {
		searchStatusCheck = "";
		searchFlag = false;
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
