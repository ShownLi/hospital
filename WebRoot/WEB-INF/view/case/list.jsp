﻿<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../assets/pages/head.jsp"%>
<link href="${rootPath }assets/css/jquery.datatables.css" rel="stylesheet">
</head>

<body>
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
								<!-- <div class="col-sm-2">
									<input type="text" id="searchCustomerId" class="customer-select fullwidth" value="" />
								</div> -->
								<div class="col-sm-2">
									<input type="text" id="searchCustomerName" class="form-control" placeholder="客人" value="" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchCaseId" class="form-control" placeholder="询单id"  value="" />
								</div>
								<!-- <input type="text" id="searchBudget" class="form-control" placeholder="预算" value="" /> -->
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
										<th>ID</th>
										<th>客人</th>
										<th>手机</th>
										<th>邮箱</th>
										<th>预算</th>
										<th>目的地</th>
										<th>询单来源</th>
										<th>跟单员</th>
										<th>状态</th>
										<th>创建时间</th>
										<th>编辑</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						<!-- table-responsive -->
					</div>
					<!-- panel-body -->
				</div>
				<!-- panel -->
			</div>

		</div>
		<!-- mainpanel -->
		<%@ include file="../assets/pages/rightpanel.jsp"%>
	</section>

	<%@ include file="../assets/pages/foot.jsp"%>
	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>

<!-- Modal -->
<div class="modal fade" id="confirmDelModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel"><span class="fa fa-warning"></span> 提示</h4>
      </div>
      <div class="modal-body">
        确定无效么？
      </div>
      <div class="modal-footer">
      	<input type="hidden" class="hiddenId" value="" />
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-danger">无效</button>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->

<!-- Modal -->
<div class="modal fade" id="NoEmail" tabindex="-2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">信息</h4>
      </div>
      <div class="modal-body">
      		该客人没有邮箱，请添加邮箱后再进行操作
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->

<div class="nextModal modal fade" id="nextModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body align-center">
        <div class="section-block">
        <form id="form-order">
            <div class="section-title">选择目的地及地接社,添加订单</div>
      	   <div class="form-group col-sm-8 col-sm-offset-2">
                <label class="col-sm-3 control-label">目的地</label>
                <div class="col-sm-9">
                    <input type="text" id="destination" name="destination" placeholder="目的地" class="destination-select fullwidth" value="" />
                </div>
            </div> 
            <div class="form-group col-sm-8 col-sm-offset-2">
                <label class="col-sm-3 control-label">所属销售</label>
                <div class="col-sm-9">
                    <input type="text" id="salesId" name="salesId" placeholder="选择一个销售" class="sales-select fullwidth" value="" />
                </div>
            </div>
<!--               <div class="form-group col-sm-8 col-sm-offset-2">
                  <label class="col-sm-3 control-label">客人的预算</label>
                  <div class="col-sm-9">
                    <input type="text" name="budget" placeholder="客人的预算" class="form-control" value="" />
                  </div>
                </div> -->
            <div class="col-sm-12">
             <a class="submit btn btn-primary">保存</a>
              <input  type="hidden" id="caseId" name="caseId" value="" />
            </div>
            </form>
        </div>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->

	<script type="text/javascript">
	var source = ${source};
	var caseStatus = ${caseStatus};
	var destination = ${destination};
	var customer = ${customer};
	var user = ${user};
    var sales = ${sales};

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
    })
		 jQuery(document).ready(function() {

			$(".nav-parent").eq(0).addClass("nav-active");
			$(".nav-parent").eq(0).find(".children").show();
			
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
		                  data: "caseId",
		                  orderable: false,
		                  render: function ( data, type, full, meta ) {
		                      return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>&nbsp;<a class="btn btn-danger btn-xs" id="'+data+'"><span class="fa fa-minus-circle"></span> 无效</a>&nbsp<a class="btn btn-primary btn-xs" id="'+data+'"></span> 增加订单</a>&nbsp';
		                  },
		                  targets: 10
					  },
					  
 					  {
			                data: "destination",
			                orderable: false,
			                render: function ( data ) {
			                	if(data){
				                	for(var i=0;i <destination.length;i++){
				                		if(data==destination[i].id){
				                			return destination[i].text
				                		}				                	
				                	}
				                	return "";
			                	}
			                	else{return ""}
			                },
			                  targets: 5
						},	 
					  {
			                data: "source",
			                orderable: false,
			                render: function ( data ) {
			                	if(data){
			                		for(var i=0;i < source.length;i++){
				                		if(data==source[i].id){
				                			return source[i].text
				                		}
				                	
				                	}
			                		return "";
			                		
			                	}
			                	else{return ""}
			                },
			                  targets: 6
						},
						{
							data: "operator",
			                orderable: false,
			                render: function ( data ) {
			                	if(data){
				                	for(var i=0;i <  user.length;i++){
				                		if(data==user[i].id){
				                			return user[i].text
				                		}				                		
				                	}
				                	return "";
			                	}
			                	else{return ""}
			                },
			                  targets: 7
						},
						{
			                data: "status",
			                orderable: false,
			                render: function ( data ) {
			                	if(data){
				                	for(var i=0;i <  caseStatus.length;i++){
				                		if(data==caseStatus[i].id){
				                			return caseStatus[i].text
				                		}
				                	}
			                		return "";
			                	}
			                	else{return ""}
			                },
			                  targets: 8
						},
						{
			                data: "creatTime",
			                orderable: false,
			                render: function ( data ) {
			                	if(data){
			                		return new Date(data.time).format("yyyy-MM-dd hh:mm:ss");
			                	}
			                	else{return ""}
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
			            { data:"chineseName"},
			            { data:"mobile"},
			            { data:"email"},
			            { data: "budget" },
			            { data: "destination" },
			            { data: "source" },
			            { data: "operator" },
			            { data: "status" },
			            { data: "creatTime"}
			        ]
				});
				
			
				$('#searchBtn').on( 'click', function () {
			    	//alert($('#searchText').attr("value"));
			        t.draw();
			    } );
			
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
			        addOrder($(this).attr('id'));
			    } );
				
				$('#confirmDelModal').on( 'click', 'button.btn-danger', function () {
			        var id = $("#confirmDelModal .hiddenId").val();
			        doDel(id);
			    } ); 
		    
			// Select2
		    jQuery('select').select2({
		        minimumResultsForSearch: -1
		    });
		    
		    jQuery('select').removeClass('form-control');
			
			
		});
	    $(".nextModal .submit").click(function(){	    		
	    	  order_submit();
	    });
		function edit(id) {
			window.parent.location = "${rootPath}case/edit.html?id="+id;
		}
		
/* 		function addOrder(id) {
			 var destination = $("#destination").val();
	          $.ajax({
	              type: "post",
	              url: "${rootPath}case/getSales.do?destination="+destination,
	              data: destination,
	              success: function(sales){
	            	  var json = jQuery.parseJSON( sales );
	                  $("#salesId").select2({	
	                      placeholder: '销售',
	                      data: json
	                  });
	              }   
	          }); 
			$("#nextModal").modal('show');			
			$('#caseId').attr("value",id );
		} */
		
		function del(id) {
			$("#confirmDelModal .hiddenId").val("");
			$("#confirmDelModal .hiddenId").val(id);
			$("#confirmDelModal").modal('show');
		}
		
		function doDel(id){
			$.ajax({
				url: "${rootPath}case/del.do?id=" + id, 
				success: function() {
					window.location.reload();
				},
				error: function() {
					alert(2);
				}
			});			
		}
  		function order_submit() {
			var order= $("#form-order").serialize();
			$.post('${rootPath}order/add.do', order, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}case/list.html";
				} else {
					$("#nextModal").modal('hide');
					$("#NoEmail").modal('show');
				}
			}, "JSON");
	}
	      //添加订单弹出框，目的地与销售联动
/* 	      $("#destination").change(function(){
	          var destination = $(this).val();
	          $.ajax({
	              type: "post",
	              url: "${rootPath}case/getSales.do?destination="+destination,
	              data: destination,
	              success: function(sales){
	            	  var json = jQuery.parseJSON( sales );
	                  $("#salesId").select2({
	                      placeholder: '销售',
	                      data: json
	                  });
	              }   
	          }); 
	      }); */
	</script>

</body>
</html>
