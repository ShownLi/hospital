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
										<!-- <th>ID <br>客人</th>
										<th>手机 <br>邮箱</th>
										<th>目的地<br>预算 </th>
										<th>询单来源 <br>跟单员</th>
										<th>状态 <br>创建时间</th>
										<th>客人要求</th>
										<th>无效原因<br>未成行原因 </th>
										<th>注释</th>
										<th>编辑</th> -->
										
										<th>客人<br>ID</th>
										<th>手机 <br>邮箱<br>QQ</th>
										<th>目的地<br>出发时间 </th>									
										<th>客人要求</th>
										<th>无效原因<br>未成行原因 </th>
										<th>备注</th>
										<th>询单来源 <br>状态</th>
										<th>跟单员 <br>沟通方式</th>
										<th>创建时间</th>
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
	var contactReal =${contactReal};
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
	
    $(".sales-select").select2({
        placeholder: '销售',
        data: sales
    });
    
    $(".reason-select").select2({
    	placeholder:"无效原因",
    	data:reason
    });
    
  
    
   
		 

			var t = jQuery('#dataTable').DataTable({
				searching:false,
				pageLength: 10,
				processing: true,
				language: datatable_local_language, // my.js
				serverSide: true,
				ajax: {
					url: '${rootPath}case/list.do',
					data: function(data){
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
			 				data.mobile = searchMobile;
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
			                    return "<div class='minw50'>" + full.chineseName + "</div>" + "<div class='minw50'>" + full.caseId + "</div>"
			                },
			                targets: 0
						},
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.mobile + "</div>" + "<div>" + full.email + "</div>"+ "<div>" + full.qq + "</div>"
			                },
			                targets: 1
						},
	 					{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                	var destinations="";
			                	
			                	if(full.destination){
			                	var des=full.destination.split(",");
			                	for(var j = 0;j<des.length;j++){
			                		for(var i=0;i <destination.length;i++){
				                		if(des[j]==destination[i].id){
				                			destinations+=destination[i].text+",";
				                		}				                	
				                	}
			                	}
			                }
			                	
			                destinations=destinations.substring(0,destinations.length-1);
			              	//出发日期
		                	var start_date = full.startDate;
		                	//大约出发日期
		                	var start_month =full.startMonth;
		                	
			                if(start_date!=null){
			                	var time=new Date(start_date.time).format("yyyy-MM-dd");
			                	return "<div class='caselist-7'>" + destinations + "</div>" + "<div class='caselist-7'>" + time + "</div>";
		                		
		                	}
		                	if(start_month!=null){
		                		var time=new Date(start_month.time).format("yyyy-MM-dd");
		                		 return "<div class='caselist-7'>" + destinations + "</div>" + "<div class='caselist-7'>" + time + "</div>";
		                	}
		                	
			                return "<div class='width85'>" + destinations + "</div>" ;
			                },
			                targets: 2
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
							targets: 3
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
			                  targets: 4
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
							  targets: 5
						},
						{
			                  orderable: false,
				                render:  function ( data, type, full, meta ) {
				                	var dataSource = full.source;
				                	var dataCaseStatus = full.status;
				                	
				                	var m = "";
				                	var n = "";
					                	for(var i=0;i < source.length;i++){
					                		
					                		if(dataSource==source[i].id){
					                			m = source[i].text;
					                			break;
					                		}	
					                	}
					                	
					                	for(var i=0;i<caseStatus.length;i++){
					                		if(dataCaseStatus==caseStatus[i].id){
					                			n=caseStatus[i].text;
					                			break;
					                		}
					                	}
					                	
					                	return "<div class='width85'>" + m + "</div>" + "<div class='width85'>" + n + "</div>";
				                },
				                  targets: 6
			                  
			                 
						},
						{
							orderable: false,
							render:function ( data, type, full, meta ) {
								var oper = full.operator;
								var contReal = full.contactReal;
								var operator = "";
								var contRealText = "";
								for(var i=0;i < user.length;i++){
			                		if(oper==user[i].id){
			                			operator=user[i].text;
			                			break;
			                		}
			                	}
								
								for(var i=0;i < contactReal.length;i++){
			                		if(full.contactReal==contactReal[i].id){
			                			
			                			contRealText=contactReal[i].text;
			                			break;
			                		}
			                	}
								return "<div class='width85'>" + operator + "</div>" + "<div class='width85'>" +contRealText+ "</div>";
							},
							  targets: 7
						
						},
						{
			                  data: "creatTime",
			                  orderable: false,
			                  render: function ( data ) {
			                	  
			                	  var time = data.time;
				                	if(data.time){
				                		time=new Date(time).format("yyyy-MM-dd hh:mm:ss");
				                	}else{
				                		time="";
				                	}
				                	return "<div class='caselist-7'>" + time + "</div>"
			                  },
			                  targets: 8
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
		                  targets: 9
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
			            { data: "requirement" },
			            { data: "operator" },
			            { data: "comment"},
			            { data: "creatTime"},
			            { data: "reason"}
			           
			        ]
				});

					 
			$('#searchBtn').on( 'click', function () {
		        t.draw();
		    } );
		    
		  
		
			$('#dataTable tbody').on( 'click', 'a.btn-success', function () {
		        var data = t.row($(this).parents('tr')).data();
		        edit($(this).attr('id'));
		    } );

	    
		// Select2
	    jQuery('select').select2({
	        minimumResultsForSearch: -1
	    });
	    
	    jQuery('select').removeClass('form-control');
		
		function edit(id) {
			window.parent.location = "${rootPath}case/edit.html?id="+id;
		}
		
	</script>
</body>
</html>
