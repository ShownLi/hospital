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
					<i class="fa fa-user"></i>统计分析<span>地接社业绩统计</span>
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
						<h3 class="panel-title">地接社业绩统计</h3>
						<div class="row" style="margin-top: 20px">
							<div class="form-group col-sm-10">
								<div class="col-sm-2">
									<div class="input-group input-datepicker" style="padding: 0;">
				                        <input id="searchYear" type="text" name="searchYear" class="form-control datepicker" value="${searchYear}" readonly="readonly" placeholder="请点击输入查询年份" autocomplete="on">
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
										<th>地接社名称</th>
										<th>一月成交率</th>
										<th>二月成交率</th>									
										<th>三月成交率</th>
										<th>四月成交率</th>
										<th>五月成交率</th>
										<th>六月成交率</th>
										<th>七月成交率</th>
										<th>八月成交率</th>
										<th>九月成交率</th>
										<th>十月成交率</th>
										<th>十一月成交率</th>
										<th>十二月成交率</th>
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
						<h4 class="panel-title">成交率统计（按咨询时间）</h4>
						<form action="${rootPath }/statistics/saveagencyachirate.do" method="post">
						<input type="hidden" class="searchYearInput" name="searchYear" value="${searchYear }">
							<input class="btn btn-primary" type="submit" 
									value="导出" />
						</form>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table id="dataTable" class="table table-communicate">
								<thead>
									<tr>
										<th>地接社名称</th>
										<th>一月成交率</th>
										<th>二月成交率</th>									
										<th>三月成交率</th>
										<th>四月成交率</th>
										<th>五月成交率</th>
										<th>六月成交率</th>
										<th>七月成交率</th>
										<th>八月成交率</th>
										<th>九月成交率</th>
										<th>十月成交率</th>
										<th>十一月成交率</th>
										<th>十二月成交率</th>	
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
										<th>地接社名称</th>
										<th>一月成交金额</th>
										<th>二月成交金额</th>									
										<th>三月成交金额</th>
										<th>四月成交金额</th>
										<th>五月成交金额</th>
										<th>六月成交金额</th>
										<th>七月成交金额</th>
										<th>八月成交金额</th>
										<th>九月成交金额</th>
										<th>十月成交金额</th>
										<th>十一月成交金额</th>
										<th>十二月成交金额</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
					 -->
					<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-btns">
							<a href="" class="minimize">&minus;</a>
						</div>
						<h4 class="panel-title">成交率统计（按咨询时间）</h4>
						<form action="${rootPath }/statistics/saveagencyachimoney.do" method="post">
						<input type="hidden" class="searchYearInput" name="searchYear" value="${searchYear }">
							<input class="btn btn-primary" type="submit" 
									value="导出" />
						</form>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table id="dataTable2" class="table table-communicate">
								<thead>
									<tr>
										<th>地接社名称</th>
										<th>一月成交金额</th>
										<th>二月成交金额</th>									
										<th>三月成交金额</th>
										<th>四月成交金额</th>
										<th>五月成交金额</th>
										<th>六月成交金额</th>
										<th>七月成交金额</th>
										<th>八月成交金额</th>
										<th>九月成交金额</th>
										<th>十月成交金额</th>
										<th>十一月成交金额</th>
										<th>十二月成交金额</th>
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
	var searchFlag = false;
	var searchStatusCheck = "";
	
    jQuery("#searchYear").datepicker({
        dateFormat: "yy",
        changeYear: true,
        changeMonth: false,
        changeDay:false
     }).change(function(){
    	 $(".searchYearInput").val($(this).val());
     });
    
	var t = jQuery('#dataTable').DataTable({
		searching:false,
		pageLength: 10,
		processing: true,
		paging: false, // 禁止分页
		language: datatable_local_language, // my.js
		serverSide: true,
		ajax: {
			url: '${rootPath}statistics/agencyAchievementStats.do',
			data: function(data){
	 			var searchYear=$("#searchYear").val();
	 			var searchStatus = searchStatusCheck;
	 			searchStatusCheck = "";
	 			
	 			if(searchYear !=null && searchYear !=""){
	 				data.searchStartTime = searchYear + "-01-01";
	 				data.searchEndTime = searchYear + "-12-31";
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
	                    return "<div class='minw50'>" + full.agencyName + "</div>" 
	                },
	                targets: 0
				},
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.percentjan + "</div>"
	                },
	                targets: 1
				},
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.percentfeb + "</div>"
	                },
	                targets: 2
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.percentmar + "</div>"
	                },
	                targets: 3
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.percentapr + "</div>"
	                },
	                targets: 4
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.percentmay + "</div>"
	                },
	                targets: 5
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.percentjun + "</div>"
	                },
	                targets: 6
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.percentjul + "</div>"
	                },
	                targets: 7
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.percentaug + "</div>"
	                },
	                targets: 8
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.percentsep + "</div>"
	                },
	                targets: 9
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.percentoct + "</div>"
	                },
	                targets: 10
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.percentnov + "</div>"
	                },
	                targets: 11
				},	  
				{
	                orderable: false,
	                render: function ( data, type, full, meta ) {
	                    return "<div>" + full.percentdece + "</div>"
	                },
	                targets: 12
				},	  
				 
			    {
				    orderable: false,
				    searchable: false,
			        targets: [0]
			    }, 

			],
			columns: [
	            { data: "agencyName" },
	            { data: "percentjan" },
	            { data: "percentfeb" },
	            { data: "percentmar" },
	            { data: "percentapr" },
	            { data: "percentmay" },
	            { data: "percentjun" },
	            { data: "percentjul" },
	            { data: "percentaug" },
	            { data: "percentsep" },
	            { data: "percentoct" },
	            { data: "percentnov" },
	            { data: "percentdece" }
	        ]
		});

			$('#searchBtn').on( 'click', function () {
				//$("input[name='status']:checked").val(null);
				searchStatusCheck = "";
				searchFlag = false;
		        t.draw();
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
		    
			var t2 = jQuery('#dataTable2').DataTable({
				searching:false,
				pageLength: 10,
				processing: true,
				paging: false, // 禁止分页
				language: datatable_local_language, // my.js
				serverSide: true,
				ajax: {
					url: '${rootPath}statistics/agencyAchievementStats2.do',
					data: function(data){
			 			var searchYear = $("#searchYear").val();
			 			var searchStatus = searchStatusCheck;
			 			searchStatusCheck = "";
			 			
			 			if(searchYear !=null && searchYear !=""){
			 				data.searchStartTime = searchYear + "-01-01";
			 				data.searchEndTime = searchYear + "-12-31";
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
			                    return "<div class='minw50'>" + full.agencyName + "</div>" 
			                },
			                targets: 0
						},
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.percentjan + "</div>"
			                },
			                targets: 1
						},
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.percentfeb + "</div>"
			                },
			                targets: 2
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.percentmar + "</div>"
			                },
			                targets: 3
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.percentapr + "</div>"
			                },
			                targets: 4
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.percentmay + "</div>"
			                },
			                targets: 5
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.percentjun + "</div>"
			                },
			                targets: 6
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.percentjul + "</div>"
			                },
			                targets: 7
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.percentaug + "</div>"
			                },
			                targets: 8
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.percentsep + "</div>"
			                },
			                targets: 9
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.percentoct + "</div>"
			                },
			                targets: 10
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.percentnov + "</div>"
			                },
			                targets: 11
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.percentdece + "</div>"
			                },
			                targets: 12
						},	  
						 
					    {
						    orderable: false,
						    searchable: false,
					        targets: [0]
					    }, 

					],
					columns: [
			            { data: "agencyName" },
			            { data: "percentjan" },
			            { data: "percentfeb" },
			            { data: "percentmar" },
			            { data: "percentapr" },
			            { data: "percentmay" },
			            { data: "percentjun" },
			            { data: "percentjul" },
			            { data: "percentaug" },
			            { data: "percentsep" },
			            { data: "percentoct" },
			            { data: "percentnov" },
			            { data: "percentdece" }
			        ]
				});
			
			$('#searchBtn').on( 'click', function () {
				//$("input[name='status']:checked").val(null);
				searchStatusCheck = "";
				searchFlag = false;
		        t2.draw();
		        $('input:radio:checked').attr('checked',false);
		    } );
			
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
