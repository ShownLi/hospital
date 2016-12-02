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
					<i class="fa fa-user"></i> 询单管理 <span>询单列表</span>
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
						<h3 class="panel-title">询单列表</h3>
						<div class="row" style="margin-top: 20px">
							<div class="form-group col-sm-10">
								<div class="col-sm-2">
									<input type="text" id="searchCaseId" class="form-control" placeholder="询单id"  value="" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchCustomerName" class="form-control" placeholder="客人" value="" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchMobile" class="form-control" placeholder="手机" value="" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchMail" class="form-control" placeholder="邮箱" value="" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchDestination" class="destination-select fullwidth" value="" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchSource" class="source-select fullwidth" value="" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchOperator" class="operator-select fullwidth" value="" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchStatus" class="status-select fullwidth" value="" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchRequirment" class="form-control" placeholder="客人要求" value="" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchComment" class="form-control" placeholder="注释" value="" />
								</div>
							 
							</div>	
							<div class="col-sm-2">					 		                        		
								<input class="btn btn-primary" type="button" id="searchBtn" value="搜索"/>
							</div> 	
						</div>
					</div>
					<div class="panel-body">
						<br />
						<div class="table-responsive">

							<table id="dataTable" class="table">
								<thead>
									<tr>
										<th>ID <br>客人</th>
										<th>手机 <br>邮箱</th>
										<th>目的地<br>预算 </th>
										<th>询单来源 <br>跟单员</th>
										<th>状态 <br>创建时间</th>
										<th>客人要求</th>
										<th>无效原因<br>未成行原因 </th>
										<th>注释</th>
										<th>编辑</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

		</div>
		<%@ include file="../assets/pages/rightpanel.jsp"%>
	</section>

	<%@ include file="../assets/pages/foot.jsp"%>

	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script type="text/javascript">
 	var source = ${source}; 
	var caseStatus = ${caseStatus};
	var destination = ${destination};
	var customer = ${customer};
	var user = ${user};
    var sales = ${sales};
	var reason = ${reason};
	var reasonNodeal =${reasonNodeal};
	
	$(".destination-select").select2({
        placeholder: '国家',
        data: destination
    });
	
   	$(".customer-select").select2({
        placeholder: '客人',
        data: customer
    }); 
   	
	$(".source-select").select2({
        placeholder: '来源',
        data: source
    });
	
	$(".operator-select").select2({
        placeholder: '跟单员',
        data: user
    });
	
	$(".status-select").select2({
        placeholder: '状态',
        data: caseStatus
    });
			var t = jQuery('#dataTable').DataTable({
				searching:false,
				pageLength: 10,
				processing: true,
				language: datatable_local_language, // my.js
				serverSide: true,
				ajax: {
					url: '${rootPath}case/list.do',
					data: function( data){
			 			var searchCustomerId=$('#searchCustomerId').val();
			 			var searchCustomerName=$('#searchCustomerName').val();
			 			var searchCaseId=$('#searchCaseId').val();
			 			var searchBudget=$('#searchBudget').val();
			 			var searchDestination=$('#searchDestination').val();
			 			var searchSource=$('#searchSource').val();
			 			var searchOperator=$('#searchOperator').val();
			 			var searchStatus=$('#searchStatus').val();
			 			var searchComment=$('#searchComment').val();
			 			var searchRequirment=$('#searchRequirment').val();
			 			var searchMail=$('#searchMail').val();
			 			var searchMobile=$('#searchMobile').val();
			 			
			 			if(searchCustomerId !=null && searchCustomerId !="" ){
							data.customerId = searchCustomerId;
			 			}
			 			if(searchCustomerName !=null && searchCustomerName !="" ){
							data.chineseName = searchCustomerName;
			 			}
			 			if(searchCaseId !=null && searchCaseId !="" ){
							data.caseId = searchCaseId;
			 			}
			 			if(searchBudget !=null && searchBudget !="" ){
							data.budget = searchBudget;
			 			}
			 			if(searchDestination !=null && searchDestination !="" ){
							data.destination = searchDestination;
			 			}
			 			if(searchSource !=null && searchSource !="" ){
							data.source = searchSource;
			 			}
			 			if(searchOperator !=null && searchOperator !="" ){
							data.operator = searchOperator;
			 			}
			 			if(searchStatus !=null && searchStatus !="" ){
							data.status = searchStatus;
			 			}
			 			if(searchComment !=null && searchComment !=""){
			 				data.comment = searchComment;
			 			}
			 			if(searchRequirment !=null && searchRequirment !=""){
			 				data.requirement = searchRequirment;
			 			}
			 			if(searchMail !=null && searchMail !=""){
			 				data.email = searchMail;
			 			}
			 			if(searchMobile !=null && searchMobile !=""){
			 				data.mobilePhone = searchMobile;
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
			                    return "<div class='minw50'>" + full.caseId + "</div>" + "<div class='minw50'>" + full.chineseName + "</div>"
			                },
			                targets: 0
						},
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.mobile + "</div>" + "<div>" + full.email + "</div>"
			                },
			                targets: 1
						},
	 					{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	if(full.destination){
				                	for(var i=0;i <destination.length;i++){
				                		if(full.destination==destination[i].id){
				                			return "<div class='width85'>" + destination[i].text + "</div>" + "<div class='width85'>" + full.budget + "</div>"
				                		}				                	
				                	}
				                	return "";
			                	}
			                	else{return ""}
			                },
			                targets: 2
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	var dataSource = full.source;
			                	var dataOperator = full.operator;
			                	var m = "";
			                	var n = "";
				                	for(var i=0;i < source.length;i++){
				                		
				                		if(dataSource==source[i].id){
				                			// return "<div class='caselist-5'>" + user[i].text + "</div>"
				                			m = source[i].text;
				                		}	
				                	}
				                	for(var i=0;i < user.length;i++){
				                		if(dataOperator==user[i].id){
				                			n=user[i].text;
				                		}
				                	}
				                	return "<div class='width85'>" + m + "</div>" + "<div class='width85'>" + n + "</div>";
			                },
			                  targets: 3
						},
						 {	
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	if(full){
			                		for(var i=0;i <  caseStatus.length;i++){
				                		if(full.status==caseStatus[i].id){
				                			return "<div class='caselist-6'>" + caseStatus[i].text + "</div>" + "<div class='caselist-7'>" + new Date(data.time).format("yyyy-MM-dd hh:mm:ss"); + "</div>"
				                		}
				                	}
			                	}
			                	else{return ""}
			                },
			                  targets: 4
						},
						{
							data:"requirement",
							orderable: false,
							render:function(data) {
								if(data.length > 24){
									return "<div class='width150' data-toggle='tooltip' data-placement='bottom' title='" + data + "'>" + data.substring(0,28) + "...</div>"
								}else{
									return "<div class='width150'>" + data + "</div>"
								}	
							},
							targets: 5
						},
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	var dataReason = full.reason;
			                	var dataReasonNodeal= full.reasonNodeal;
			                	var m = "";
			                	var n = "";
				                	for(var i=0;i < reason.length;i++){
				                		
				                		if(dataReason==reason[i].id){
				                			// return "<div class='caselist-5'>" + user[i].text + "</div>"
				                			m = reason[i].text;
				                		}	
				                	}
				                	for(var i=0;i < reasonNodeal.length;i++){
				                		if(dataReasonNodeal==reasonNodeal[i].id){
				                			n=reasonNodeal[i].text;
				                		}
				                	}
				                	return "<div class='width85'>" + m + "</div>" + "<div class='width85'>" + n + "</div>";
			                },
			                  targets: 6
						},
						{
							data:"comment",
							orderable: false,
							render:function ( data ) {
								if(data.length > 24){
									return "<div class='width150' data-toggle='tooltip' data-placement='bottom' title='" + data + "'>" + data.substring(0,28) + "...</div>"
								}else{
									return "<div class='width150'>" + data + "</div>"
								}
							},
							  targets: 7
						
						},
						{
		                  data: "caseId",
		                  orderable: false,
		                  render: function ( data, type, full, meta ) {
		                	  
		                	  if(full.status==0){
		                		  return '<a class="btn btn-primary btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 处理</a> &nbsp;';  
		                	  }
		                	  else {
		                		  return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>&nbsp;';    
		                	  }
		                      
		                  },
		                  targets: 8
					    },
					    {
						    orderable: false,
						    searchable: false,
					        targets: [0]
					    }, 

					],
					columns: [
			            { data: "caseId" },
			            { data:"mobile"},
			            { data: "destination" },
			            { data: "operator" },
			            { data: "creatTime"},
			            { data: "requirement" },
			            { data: "reason"},
			            { data: "comment"},
			        ]
				});

					 
			$('#searchBtn').on( 'click', function () {
		        t.draw();
		    } );
		    
		    //处理询单
		   /*  $('#dataTable tbody').on( 'click', 'a.btn-handle', function () {
		        var data = t.row($(this).parents('tr')).data();
		        handle($(this).attr('id'));
		    } ); */
		
			$('#dataTable tbody').on( 'click', 'a.btn-success', function () {
		        var data = t.row($(this).parents('tr')).data();
		        edit($(this).attr('id'));
		    } );

			$('#dataTable tbody').on( 'click', 'a.btn-danger', function () {
		        var data = t.row($(this).parents('tr')).data();
		        del($(this).attr('id'));
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
		
		
	   
	    
		function edit(id) {
			window.parent.location = "${rootPath}case/edit.html?id="+id;
		}
		
		function handle(id) {
			window.parent.location = "${rootPath}case/handle.html?id="+id;
		}
		

	</script>

</body>
</html>
