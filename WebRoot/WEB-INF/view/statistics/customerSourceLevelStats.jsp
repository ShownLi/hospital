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
					<i class="fa fa-user"></i>统计分析<span>客人来源级别统计</span>
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
						<div class="row" style="clear: both;">
							<h3 class="panel-title col-sm-11">客人来源级别统计</h3>
							<div class="col-sm-1">
								<form action="${rootPath }/statistics/savecustsourcelevel.do" method="post">
								<input class="btn btn-primary" type="submit" value="导出"/>
								</form>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table id="dataTable" class="table">
								<thead>
									<tr>
										<th>客人来源</th>
										<th>普通客人数量</th>
										<th>注册客人数量</th>									
										<th>下单客人数量</th>
										<th>成行客人数量</th>
										<th>成交比</th>
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
			url: '${rootPath}statistics/customerSourceLevelStats.do',
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
	                    return "<div class='minw50'>" + full.source + "</div>" 
	                },
	                targets: 0
				},
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.level0 + "</div>"
	                },
	                targets: 1
				},
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.level1 + "</div>"
	                },
	                targets: 2
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.level2 + "</div>"
	                },
	                targets: 3
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.level3 + "</div>"
	                },
	                targets: 4
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.rate + "</div>"
	                },
	                targets: 5
				},
			    {
				    orderable: false,
				    searchable: false,
			        targets: [0]
			    }, 

			],
			columns: [
	            { data: "source" },
	            { data:"level0"},
	            { data: "level1" },
	            { data: "level2" },
	            { data: "level3" },
	            { data: "rate" }
	        ]
		});
	
		$('#searchBtn').on( 'click', function () {
			searchStatusCheck = "";
			searchFlag = false;
	        t.draw();
	    } );
	</script>
</body>
</html>
