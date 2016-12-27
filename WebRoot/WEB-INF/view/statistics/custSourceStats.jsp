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
					<i class="fa fa-user"></i>统计分析<span>客人来源统计</span>
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
						<h3 class="panel-title">客人来源统计</h3>
						<div class="row" style="margin-top: 20px">
						<form action="${rootPath }/statistics/savecustsource.do" method="post">
							<div class="form-group col-sm-10">
								<div class="col-sm-2">
									<div class="input-group input-datepicker" style="padding: 0;">
				                        <input readonly="readonly" id="searchYear" type="text" name="searchYear" class="form-control datepicker" placeholder="请选择查询年份" readonly="readonly" autocomplete="on" value="${searchYear }" >
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

							<table id="dataTable" class="table">
								<thead>
									<tr>
										<th>客人来源</th>
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
							<table id="dataTable2" class="table">
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
  
	var table = jQuery('#dataTable').DataTable({
		searching:false,
		paging:false,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		bInfo : false,
		ajax: {
			url: '${rootPath}statistics/custsourcestats.do',
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
	
	var table2 = jQuery('#dataTable2').DataTable({
		searching:false,
		paging:false,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		bInfo : false,
		ajax: {
			url: '${rootPath}statistics/custsourcestatstotal.do',
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
	            		{ data: "" },
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
	
		$('#searchBtn').on( 'click', function () {
			table.draw();
			table2.draw();
	    } );
	
		// Select2
	    jQuery('select').select2({
	        minimumResultsForSearch: -1
	    });
	    
	    jQuery('select').removeClass('form-control');
		
	</script>
</body>
</html>
