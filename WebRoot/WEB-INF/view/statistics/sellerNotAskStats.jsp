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
					<i class="fa fa-user"></i>统计分析<span>商家未询统计</span>
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
						<h3 class="panel-title">商家未询统计</h3>
						<div class="row" style="margin-top: 20px">
							<div class="form-group col-sm-10">
								<div class="col-sm-2">
									<div class="input-group input-datepicker" style="padding: 0;">
				                        <input id="searchStartDateTime" type="text" name="searchStartTime" class="form-control datepicker" value="${searchStartDateTime}" placeholder="请点击输入查询开始日期" autocomplete="on">
				                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                    </div>
				                </div>
			                    <div class="col-sm-2">
				                    <div class="input-group input-datepicker" style="padding: 0;">
				                        <input id="searchEndDateTime" type="text" name="searchEndTime" class="form-control datepicker" value="${searchEndDateTime}" placeholder="请点击输入查询截止日期" autocomplete="on">
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
				<!-- <div class="panel-body">
				<div class="table-responsive">
					<table id="dataTable" class="table">
						<thead>
							<tr>
								<th>目的地国家名称</th>
								<th>包含地接社数量</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div> -->
			<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-btns">
							<a href="" class="minimize">&minus;</a>
						</div>
						<h4 class="panel-title">无询单目的地统计</h4>
						<form action="${rootPath }/statistics/savenocasedes.do" method="post">
						<input type="hidden" class="startTimeInput" name="searchStartTime" value="${searchStartDateTime}">
						<input type="hidden" class="endTimeInput" name="searchEndTime" value="${searchEndDateTime}">
							<input class="btn btn-primary" type="submit" 
									value="导出" />
						</form>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table id="dataTable" class="table table-communicate">
								<thead>
									<tr>
										<th>目的地国家名称</th>
										<th>包含地接社数量</th>	
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						<!-- table-responsive -->
					</div>
				</div>
			
			<!-- <div class="panel-body">
				<div class="table-responsive">
					<table id="dataTable2" class="table">
						<thead>
							<tr>
								<th>地接社国家名称</th>
								<th>服务国家</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div> -->
			<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-btns">
							<a href="" class="minimize">&minus;</a>
						</div>
						<h4 class="panel-title">无订单地接社统计</h4>
						<form action="${rootPath }/statistics/savenoorderagency.do" method="post">
						<input type="hidden" class="startTimeInput" name="searchStartTime" value="${searchStartDateTime}">
						<input type="hidden" class="endTimeInput" name="searchEndTime" value="${searchEndDateTime}">
							<input class="btn btn-primary" type="submit" 
									value="导出" />
						</form>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table id="dataTable2" class="table table-communicate">
								<thead>
									<tr>
										<th>地接社国家名称</th>
								<th>服务国家</th>
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
	$("#searchStartDateTime").change(function(){
		$(".startTimeInput").val($(this).val());
	});
	$("#searchEndDateTime").change(function(){
		$(".endTimeInput").val($(this).val());
	});
			var t = jQuery('#dataTable').DataTable({
				searching:false,
				pageLength: 10,
				processing: true,
				paging: false, // 禁止分页
				language: datatable_local_language, // my.js
				serverSide: true,
				ajax: {
					url: '${rootPath}statistics/sellerNotAskStats.do',
					data: function(data){
			 			var searchStatus = searchStatusCheck;
			 			searchStatusCheck = "";
			 			var searchStartDateTime=$("#searchStartDateTime").val();
			 			var searchEndDateTime=$("#searchEndDateTime").val();
			 			
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
						
						if(searchFlag==false){
							$('#status0Count').html("待处理"+json.status0);

							$('#status1Count').html("客服沟通中"+json.status1);
					
							$('#status2Count').html("地接设计中"+json.status2);						
							
							$('#status3Count').html("成行"+json.status3);						
							
							$('#status4Count').html("未成行"+json.status4);						
							
							$('#status5Count').html("无效"+json.status5);												
							
							$('#status6Count').html("已付款"+json.status6);
						}
						
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
			            { data: "destination" },
			            { data: "country" }
			        ]
				});
			
			var t2 = jQuery('#dataTable2').DataTable({
				searching:false,
				pageLength: 10,
				processing: true,
				paging: false, // 禁止分页
				language: datatable_local_language, // my.js
				serverSide: true,
				ajax: {
					url: '${rootPath}statistics/sellerNotAskStatsD.do',
					data: function(data){
			 			var searchStatus = searchStatusCheck;
			 			searchStatusCheck = "";
			 			var searchStartDateTime=$("#searchStartDateTime").val();
			 			var searchEndDateTime=$("#searchEndDateTime").val();
			 			
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
						
						if(searchFlag==false){
							$('#status0Count').html("待处理"+json.status0);

							$('#status1Count').html("客服沟通中"+json.status1);
					
							$('#status2Count').html("地接设计中"+json.status2);						
							
							$('#status3Count').html("成行"+json.status3);						
							
							$('#status4Count').html("未成行"+json.status4);						
							
							$('#status5Count').html("无效"+json.status5);												
							
							$('#status6Count').html("已付款"+json.status6);
						}
						
						return JSON.stringify( json );
					}
				},
				columnDefs: [		  
 					   {
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div class='minw50'>" + full.destination + "</div>" 
			                }, 
			                targets: 0
						},
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.country + "</div>"
			                },
			                targets: 1
						}
					],
					columns: [
			            { data: "destination" },
			            { data: "country" }
			        ]
				});

			$('#searchBtn').on( 'click', function () {
				//$("input[name='status']:checked").val(null);
				searchStatusCheck = "";
				searchFlag = false;
		        t.draw();
		        t2.draw();
		        $('input:radio:checked').attr('checked',false);
		    } );
			
			$('#status0').on('click',function(){
				searchStatusCheck = 0+" ";
				searchFlag = true;
				t.draw();
			});
			$('#status1').on('click',function(){
				searchStatusCheck = 1;
				searchFlag = true;
				t.draw();
			});
			$('#status2').on('click',function(){
				searchStatusCheck = 2;
				searchFlag = true;
				t.draw();
			});
			$('#status3').on('click',function(){
				searchStatusCheck = 3;
				searchFlag = true;
				t.draw();
			});
			$('#status4').on('click',function(){
				searchStatusCheck = 4;
				searchFlag = true;
				t.draw();
			});
			$('#status5').on('click',function(){
				searchStatusCheck = 5;
				searchFlag = true;
				t.draw();
			});
			$('#status6').on('click',function(){
				searchStatusCheck = 6;
				searchFlag = true;
				t.draw();
			});
		    
			$('#dataTable tbody').on( 'click', 'a.btn-success', function () {
		        var data = t.row($(this).parents('tr')).data();
		        edit($(this).attr('id'));
		    } );
			$('#dataTable tbody').on( 'click', 'a.btn-primary', function () {
		        var data = t.row($(this).parents('tr')).data();
		        handle($(this).attr('id'));
		    } );

	    
		// Select2
	    jQuery('select').select2({
	        minimumResultsForSearch: -1
	    });
	    
	    jQuery('select').removeClass('form-control');
	</script>
</body>
</html>
