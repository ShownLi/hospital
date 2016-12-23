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
					<i class="fa fa-user"></i>统计分析<span>沟通方式统计</span>
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
						<h3 class="panel-title">沟通方式统计</h3>
						<div class="row" style="margin-top: 20px">
							<div class="form-group col-sm-10">
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
					<!-- panel 无效统计 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-btns">
							<a href="" class="minimize">&minus;</a>
						</div>
						<h4 class="panel-title">无效原因统计</h4>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table id="dataTable-invalid" class="table table-communicate">
								<thead>
									<tr>
										<th>无效原因</th>
										<th>询单数量</th>
										<th>比例</th>		
									</tr>
								</thead>
								<tbody>
								</tbody>
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
						<h4 class="panel-title">未成行原因统计</h4>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table id="dataTable-nodeal" class="table table-communicate">
								<thead>
									<tr>
										<th>未成行原因</th>
										<th>询单数量</th>
										<th>比例</th>		
									</tr>
								</thead>
								<tbody>
								</tbody>
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
			var invalidTable = jQuery('#dataTable-invalid').DataTable({
				searching:false,
				paging:false,
				processing: true,
				language: datatable_local_language, // my.js
				serverSide: true,
				ajax: {
					url: '${rootPath}statistics/reasonofdrainingstats1.do',
					type:"post",
					data: function(data){
			 			var searchStartDateTime=$("#searchStartCreateDateTime").val();
			 			var searchEndDateTime=$("#searchEndCreateDateTime").val();
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
 						   data:"reasonOfDrainingName",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + data + "</div>"
			                },
			                targets: 0
						},
						{
							data:"num",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + data + "</div>"
			                },
			                targets: 1
						},
	 					{
							data:"percent",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 2
						}
						
					],
					columns: [
			            		{ data: "reasonOfDrainingName" },
					            { data:	"num"},
					            { data: "percent" }
			        ]
				});
			
			var noDealTable = jQuery('#dataTable-nodeal').DataTable({
				searching:false,
				paging:false,
				processing: true,
				language: datatable_local_language, // my.js
				serverSide: true,
				ajax: {
					url: '${rootPath}statistics/reasonofdrainingstats2.do',
					type:"post",
					data: function(data){
			 			var searchStartDateTime=$("#searchStartCreateDateTime").val();
			 			var searchEndDateTime=$("#searchEndCreateDateTime").val();
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
 						   data:"reasonOfDrainingName",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + data + "</div>"
			                },
			                targets: 0
						},
						{
							data:"num",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + data + "</div>"
			                },
			                targets: 1
						},
	 					{
							data:"percent",
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	return "<div>" + data + "</div>"
			                },
			                targets: 2
						}
						
					],
					columns: [
			            		{ data: "reasonOfDrainingName" },
					            { data:	"num"},
					            { data: "percent" }
			        ]
				});

			$('#searchBtn').on( 'click', function () {
				invalidTable.draw();
				noDealTable.draw();
		    } );
			

		// Select2
	    jQuery('select').select2({
	        minimumResultsForSearch: -1
	    });
	    
	    jQuery('select').removeClass('form-control');
		
	</script>
</body>
</html>
