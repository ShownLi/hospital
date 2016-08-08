<%@ page language="java" pageEncoding="utf-8"%>
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
					<i class="fa fa-user"></i> 订单管理 <span>订单列表</span>
				</h2>
				<!-- <div class="breadcrumb-wrapper">
					<span class="label">你在这里:</span>
					<ol class="breadcrumb">
						<li><a href="#">CRM</a></li>
						<li class="active">订单管理</li>
					</ol>
				</div> -->
			</div>

			<div class="contentpanel">
				<!-- content goes here... -->

				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-btns">
							<a href="" class="minimize">&minus;</a>
						</div>
						<!-- panel-btns -->
						<h3 class="panel-title">订单列表</h3>
					</div>
					<div class="panel-body">
						<br />
						<div class="table-responsive">

							<table id="dataTable" class="table">
								<thead>
									<tr>
										<th>ID</th>
										<th>客人姓名</th>
										<th>地接社</th>
										<th>销售姓名</th>
										<th>目的地</th>
										<th>预算</th>
										<th>状态</th>
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
        确定删除么？
      </div>
      <div class="modal-footer">
      	<input type="hidden" class="hiddenId" value="" />
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-danger">删除</button>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->

<!-- cModal -->
<div class="cModal modal fade" id="group" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">         
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">请填写以下订单信息</div>
      </div>

      <div class="modal-body">
    		  <form class="form-horizontal" id="form1">
              <div class="section-block noline">
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团日期</label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input type="text" name="grouptime" class="form-control datepicker" autocomplete="off">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">出发日期</label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input type="text" name="startdate" placeholder="出发日期" class="form-control datepicker" autocomplete="off" />
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">返回日期</label>
                    <div class="col-sm-8 input-group input-datepicker">
                      <input type="text" name="enddate" placeholder="返回日期" class="form-control datepicker" autocomplete="off" />
                      <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                    </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团人数</label>
                      <div class="col-sm-8">
                        <input type="text" name="groupnumber" placeholder="成团人数" class="form-control"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团价格</label>
                      <div class="col-sm-8">
                        <input type="text" name="groupprice" placeholder="成团价格" class="form-control" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">货币种类</label>
                      <div class="col-sm-8">
                        <input type="text" name="currency" placeholder="货币种类" class="form-control"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">汇率</label>
                      <div class="col-sm-8">
                        <input type="text" name="exchangerate" placeholder="汇率" class="form-control" value="0" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">人民币价格</label>
                      <div class="col-sm-8">
                        <input type="text" name="rmbprice" placeholder="人民币价格" class="form-control"/>
                      </div>
                  </div>
                  <input type="hidden" name="orderid" value="${order.orderid}" />
                  <input type="hidden" name="caseid" value="${order.caseid}" />	
                  <input type="hidden" name="customerid" value="${order.customerid}" />	
              </div>  
          </form>     
      </div>
      <div class="modal-footer align-center">
          <a class="submit btn btn-primary" >保存</a>
          <a class="cancel btn btn-primary" >取消</a>        
      </div>

    </div><!-- modal-content --> 
  </div><!-- modal-dialog -->
</div><!-- cModal -->

<!-- bModal -->
<div class="bModal modal fade" id="nogroup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">请填写以下订单信息</div>
      </div>
      <div class="modal-body">
          <form class="form-horizontal" id="form2">
              <div class="section-block noline">
                  <div class="form-group col-sm-12">
                    <label class="col-sm-4 control-label">若未成行，原因是</label>
                    <div class="col-sm-8">
                      <input class="form-control reason-select" name="reason" placeholder="若未成行，原因是" />
                      <input type="hidden" name="orderid" value="${order.orderid}" />	
                      <input type="hidden" name="caseid" value="${order.caseid}" />
                    </div>
                  </div>
              </div><!-- bModal-body -->
          </form>
      </div>
      <div class="modal-footer align-center">
          <a class="submit btn btn-primary" >保存</a>
          <a class="cancel btn btn-primary" >取消</a>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- bmodal -->


	<script type="text/javascript">
	var os = ${orderstatus};
	var d = ${destination};
	
		jQuery(document).ready(function() {

			$(".nav-parent").eq(1).addClass("nav-active");
      		$(".nav-parent").eq(1).find(".children").show();
			
			 var t = jQuery('#dataTable').DataTable({
			 	pageLength: 10,
			 	processing: true,
			 	language: datatable_local_language, // my.js
			 	serverSide: true,
			 	ajax: {
			 		url: '${rootPath}order/list.do',
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
			           data: "orderid",
			           //defaultContent: '<a class="btn btn-success btn-xs"><span class="fa fa-edit"></span> 编辑</a>&nbsp;<a class="btn btn-danger btn-xs"><span class="fa fa-minus-circle"></span> 删除</a>',
			 	      orderable: false,
			 	      render: function ( data, type, full, meta ) {
		              	return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>&nbsp<a class="btn btn-primary btn-xs" id="'+data+'"></span> 成行</a>&nbsp<a class="btn btn-default btn-xs" id="'+data+'"></span> 未成行</a>&nbsp;';
			 	  	  },
			 	    	targets: 7
			 		},
					{
		                data: "status",
		                orderable: false,
		                render: function ( data ) {
		                	if(data){
			                	for(var i=0;i <  os.length;i++){
			                		if(data==os[i].id){
			                			return os[i].text
			                		}
			                	}
		                	}
		                	else{return ""}
		                },
		                  targets: 6
					},
					{
		                data: "destination",
		                orderable: false,
		                render: function ( data ) {
		                	if(data){
			                	for(var i=0;i <  d.length;i++){
			                		if(data==d[i].id){
			                			return d[i].text
			                		}
			                	}
		                	}
		                	else{return ""}
		                },
		                  targets: 4
					},					
			 	  {
			 		  orderable: false,
			 		  searchable: false,
			 	      targets: [0,1,2]
			 	  },
			 	],
			 	columns: [
		             { data: "orderid" },
		             { data: "customername" },
		             { data: "agencyname" },
		             { data: "salesname" },
		             { data: "destination" },
		             { data: "budget" },
		             { data: "status" }
		         ]
			 });
			
			 $('#dataTable tbody').on( 'click', 'a.btn-success', function () {
		         var data = t.row($(this).parents('tr')).data();
		         //alert($(this).attr('id'));
		         edit($(this).attr('id'));
		     } );

			 $('#dataTable tbody').on( 'click', 'a.btn-primary', function () {
		         var data = t.row($(this).parents('tr')).data();
		         //alert($(this).attr('id'));
		         group($(this).attr('id'));
		     } );

			 $('#dataTable tbody').on( 'click', 'a.btn-default', function () {
		         var data = t.row($(this).parents('tr')).data();
		         //alert($(this).attr('id'));
		         nogroup($(this).attr('id'));
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
		function edit(id) {
			window.parent.location = "${rootPath}order/edit.html?id="+id;
		}
		
		function group(id) {
			$(".cModal").modal('show');
		}
		
		function nogroup(id) {
			$("#nogroup").modal('show');
		}
		// Date Picker
		jQuery(".datepicker").datepicker({
			  dateFormat: "yy-mm-dd"
	  	});
	    $(".cModal .submit").click(function(){
	    	form1_submit();
	      });
	    $(".bModal .submit").click(function(){
	    	form2_submit();
	      });
		function form1_submit() {
			var f = $("#form1").serialize();
			alert(f);
			$.post('${rootPath}order/edit1.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}order/edit.html?orderid=";
				} 
				else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
		function form2_submit() {
			var f = $("#form2").serialize();
			$.post('${rootPath}order/edit1.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}order/edit.html?orderid=";
				} 
				else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
		function doDel(id){
			$.ajax({
				url: "${rootPath}user/del.do?id=" + id, 
				async: true,
				success: function(o) {
					window.location.reload();
				},
				error: function(o) {
					alert(2);
				}
			});
			
		}

	</script>

</body>
</html>
