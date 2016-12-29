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
					<i class="fa fa-user"></i>统计分析<span>询单来源状态统计</span>
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
						<h3 class="panel-title">询单来源状态统计</h3>
						<div class="row" style="margin-top: 20px">
						<form action="${rootPath }/statistics/savecasesource.do" method="post">
							<div class="form-group col-sm-10">
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
										<th>询单来源</th>
										<th>待处理</th>									
										<th>沟通中</th>
										<th>地接设计中</th>
										<th>成行</th>
										<th>未成行</th>
										<th>无效</th>
										<th>付款</th>
										<th>询单总数</th>
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
	var searchFlag = false;
	var searchStatusCheck = "";
	
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
		processing: true,
		paging: false, // 禁止分页
		language: datatable_local_language, // my.js
		serverSide: true,
		bInfo : false,
		ajax: {
			url: '${rootPath}statistics/caseSourceStats.do',
			data: function(data){
	 			var searchStartDateTime=$("#searchStartDateTime").val();
	 			var searchEndDateTime=$("#searchEndDateTime").val();
	 			var searchStatus = searchStatusCheck;
	 			searchStatusCheck = "";
	 			
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
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div class='minw50'>" + full.sourceName + "</div>" 
	                },
	                targets: 0
				},
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.status0 + "</div>"
	                },
	                targets: 1
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.status1 + "</div>"
	                },
	                targets: 2
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.status2 + "</div>"
	                },
	                targets: 3
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.status3 + "</div>"
	                },
	                targets: 4
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.status4 + "</div>"
	                },
	                targets: 5
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.status5 + "</div>"
	                },
	                targets: 6
				},
				{
					orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.status6 + "</div>"
	                },
	                targets: 7
				},
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.total + "</div>"
	                },
	                targets: 8
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.rate + "</div>"
	                },
	                targets: 9
				},	  
				 
			    {
				    orderable: false,
				    searchable: false,
			        targets: [0]
			    }, 

			],
			columns: [
	            { data: "sourceName" },
	            { data: "status0" },
	            { data: "status1" },
	            { data: "status2" },
	            { data: "status3" },
	            { data: "status4" },
	            { data: "status5" },
	            { data: "status6" },
	            { data:"total"},
	            { data: "rate" }
	        ]
		});
	
		$('#searchBtn').on( 'click', function () {
			searchStatusCheck = "";
			searchFlag = false;
	        t.draw();
	        $('input:radio:checked').attr('checked',false);
	    } );
	</script>
</body>
</html>
