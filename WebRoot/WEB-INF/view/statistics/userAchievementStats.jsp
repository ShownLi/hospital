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
					<i class="fa fa-user"></i>统计分析<span>跟单员绩效统计</span>
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
						<h3 class="panel-title">跟单员绩效统计</h3>
						<div class="row" style="margin-top: 20px">
							<div class="form-group col-sm-10">
								<div class="col-sm-2">
									<div class="input-group input-datepicker" style="padding: 0;">
				                        <input id="searchYear" type="text" name="searchYear" class="form-control datepicker" placeholder="请选择查询年份" autocomplete="on" value="${searchYear }">
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
					<!-- panel 无效统计 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-btns">
							<a href="" class="minimize">&minus;</a>
						</div>
						<h4 class="panel-title">成交率统计（按咨询时间）</h4>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table id="dataTable-rate" class="table table-communicate">
								<thead>
									<tr>
										<th>跟单员</th>
										<th>一月</th>		
										<th>二月</th>		
										<th>三月</th>		
										<th>四月</th>		
										<th>五月</th>		
										<th>六月</th>		
										<th>七月</th>		
										<th>八月</th>		
										<th>九月</th>		
										<th>十月</th>		
										<th>十一月</th>		
										<th>十二月</th>		
									</tr>
								</thead>
							</table>
							<table id="dataTable-rate2" class="table table-communicate">
								<thead>
									<tr>
										<th></th>
										<th>一月</th>		
										<th>二月</th>		
										<th>三月</th>		
										<th>四月</th>		
										<th>五月</th>		
										<th>六月</th>		
										<th>七月</th>		
										<th>八月</th>		
										<th>九月</th>		
										<th>十月</th>		
										<th>十一月</th>		
										<th>十二月</th>		
									</tr>
								</thead>
							</table>
						</div>
						<!-- table-responsive -->
					</div>
				</div>
				
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-btns">
							<a href="" class="minimize">&minus;</a>
						</div>
						<h4 class="panel-title">成交金额统计（按成交时间）</h4>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table id="dataTable-money" class="table table-communicate">
								<thead>
									<tr>
										<th>跟单员</th>
										<th>一月</th>		
										<th>二月</th>		
										<th>三月</th>		
										<th>四月</th>		
										<th>五月</th>		
										<th>六月</th>		
										<th>七月</th>		
										<th>八月</th>		
										<th>九月</th>		
										<th>十月</th>		
										<th>十一月</th>		
										<th>十二月</th>	
									</tr>
								</thead>
							</table>
							
							<table id="dataTable-money2" class="table table-communicate">
								<thead>
									<tr>
										<th></th>
										<th>一月</th>		
										<th>二月</th>		
										<th>三月</th>		
										<th>四月</th>		
										<th>五月</th>		
										<th>六月</th>		
										<th>七月</th>		
										<th>八月</th>		
										<th>九月</th>		
										<th>十月</th>		
										<th>十一月</th>		
										<th>十二月</th>	
									</tr>
								</thead>
							</table>
						</div>
						<!-- table-responsive -->
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
    jQuery("#searchYear").datepicker({
        dateFormat: "yy",
        changeYear: true,
        changeMonth: false,
        changDate:false
        
     });
    
	var rateTable = jQuery('#dataTable-rate').DataTable({
		searching:false,
		paging:false,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		bInfo : false,
		ajax: {
			url: '${rootPath}statistics/userachievementratestats.do',
			type:"post",
			data: function(data){
	 			var searchYear=$("#searchYear").val();
	 			if(searchYear !=null && searchYear !=""){
	 				data.searchYear = searchYear;
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
					data:"percentJan",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + data + "</div>"
	                },
	                targets: 1
				},
					{
					data:"percentFeb",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 2
				},
					{
					data:"percentMar",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 3
				},
					{
					data:"percentApr",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 4
				},
					{
					data:"percentMay",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 5
				},
					{
					data:"percentJun",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 6
				},
					{
					data:"percentJul",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 7
				},
					{
					data:"percentAug",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 8
				},
					{
					data:"percentSep",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 9
				},
					{
					data:"percentOct",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 10
				},
					{
					data:"percentNov",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 11
				},
					{
					data:"percentDec",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 12
				}
				
			],
			columns: [
	            		{ data: "userName" },
			            { data:	"percentJan"},
			            { data: "percentFeb" },
			            { data: "percentMar" },
			            { data: "percentApr" },
			            { data: "percentMay" },
			            { data: "percentJun" },
			            { data: "percentJul" },
			            { data: "percentAug" },
			            { data: "percentSep" },
			            { data: "percentOct" },
			            { data: "percentNov" },
			            { data: "percentDec" }
	        ]
		});
	var rateTable2 = jQuery('#dataTable-rate2').DataTable({
		searching:false,
		paging:false,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		bInfo : false,
		ajax: {
			url: '${rootPath}statistics/userachievementratestatstotal.do',
			type:"post",
			data: function(data){
	 			var searchYear=$("#searchYear").val();
	 			if(searchYear !=null && searchYear !=""){
	 				data.searchYear = searchYear;
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
					data:"percentJan_TR",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + data + "</div>"
	                },
	                targets: 1
				},
					{
					data:"percentFeb_TR",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 2
				},
					{
					data:"percentMar_TR",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 3
				},
					{
					data:"percentApr_TR",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 4
				},
					{
					data:"percentMay_TR",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 5
				},
					{
					data:"percentJun_TR",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 6
				},
					{
					data:"percentJul_TR",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 7
				},
					{
					data:"percentAug_TR",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 8
				},
					{
					data:"percentSep_TR",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 9
				},
					{
					data:"percentOct_TR",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 10
				},
					{
					data:"percentNov_TR",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 11
				},
					{
					data:"percentDec_TR",
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                	return "<div>" + data + "</div>"
	                },
	                targets: 12
				}
				
			],
			columns: [
	            		{ data: "" },
			            { data:	"percentJan_TR"},
			            { data: "percentFeb_TR" },
			            { data: "percentMar_TR" },
			            { data: "percentApr_TR" },
			            { data: "percentMay_TR" },
			            { data: "percentJun_TR" },
			            { data: "percentJul_TR" },
			            { data: "percentAug_TR" },
			            { data: "percentSep_TR" },
			            { data: "percentOct_TR" },
			            { data: "percentNov_TR" },
			            { data: "percentDec_TR" }
	        ]
		});
	
	var moneyTable = jQuery('#dataTable-money').DataTable({
		searching:false,
		paging:false,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		bInfo : false,
		ajax: {
			url: '${rootPath}statistics/userachievementmoneystats.do',
			type:"post",
			data: function(data){
				var searchYear=$("#searchYear").val();
	 			if(searchYear !=null && searchYear !=""){
	 				data.searchYear = searchYear;
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
							data:"percentJan",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + data + "</div>"
			                },
			                targets: 1
						},
	 					{
							data:"percentFeb",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 2
						},
	 					{
							data:"percentMar",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 3
						},
	 					{
							data:"percentApr",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 4
						},
	 					{
							data:"percentMay",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 5
						},
	 					{
							data:"percentJun",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 6
						},
	 					{
							data:"percentJul",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 7
						},
	 					{
							data:"percentAug",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 8
						},
	 					{
							data:"percentSep",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 9
						},
	 					{
							data:"percentOct",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 10
						},
	 					{
							data:"percentNov",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 11
						},
	 					{
							data:"percentDec",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 12
						}
						
					],
					columns: [
			            		{ data: "userName" },
					            { data:	"percentJan"},
					            { data: "percentFeb" },
					            { data: "percentMar" },
					            { data: "percentApr" },
					            { data: "percentMay" },
					            { data: "percentJun" },
					            { data: "percentJul" },
					            { data: "percentAug" },
					            { data: "percentSep" },
					            { data: "percentOct" },
					            { data: "percentNov" },
					            { data: "percentDec" }
			        ]
		});
	
	var moneyTable2 = jQuery('#dataTable-money2').DataTable({
		searching:false,
		paging:false,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		bInfo : false,
		ajax: {
			url: '${rootPath}statistics/userachievementmoneystatstotal.do',
			type:"post",
			data: function(data){
				var searchYear=$("#searchYear").val();
	 			if(searchYear !=null && searchYear !=""){
	 				data.searchYear = searchYear;
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
							data:"percentJan_TM",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + data + "</div>"
			                },
			                targets: 1
						},
	 					{
							data:"percentFeb_TM",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 2
						},
	 					{
							data:"percentMar_TM",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 3
						},
	 					{
							data:"percentApr_TM",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 4
						},
	 					{
							data:"percentMay_TM",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 5
						},
	 					{
							data:"percentJun_TM",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 6
						},
	 					{
							data:"percentJul_TM",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 7
						},
	 					{
							data:"percentAug_TM",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 8
						},
	 					{
							data:"percentSep_TM",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 9
						},
	 					{
							data:"percentOct_TM",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 10
						},
	 					{
							data:"percentNov_TM",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 11
						},
	 					{
							data:"percentDec_TM",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 12
						}
						
					],
					columns: [
			            		{ data: "" },
					            { data:	"percentJan_TM"},
					            { data: "percentFeb_TM" },
					            { data: "percentMar_TM" },
					            { data: "percentApr_TM" },
					            { data: "percentMay_TM" },
					            { data: "percentJun_TM" },
					            { data: "percentJul_TM" },
					            { data: "percentAug_TM" },
					            { data: "percentSep_TM" },
					            { data: "percentOct_TM" },
					            { data: "percentNov_TM" },
					            { data: "percentDec_TM" }
			        ]
		});

		$('#searchBtn').on( 'click', function () {
			rateTable.draw();
			rateTable2.draw();
			moneyTable.draw();
			moneyTable2.draw();
	    } );
			
		// Select2
	    jQuery('select').select2({
	        minimumResultsForSearch: -1
	    });
	    
	    jQuery('select').removeClass('form-control');
		
	</script>
</body>
</html>
