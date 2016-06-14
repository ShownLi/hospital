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
					<i class="fa fa-user"></i> 销售管理 <span>销售列表</span>
				</h2>
				<div class="breadcrumb-wrapper">
					<span class="label">你在这里:</span>
					<ol class="breadcrumb">
						<li><a href="#">CRM</a></li>
						<li class="active">销售管理</li>
					</ol>
				</div>
			</div>

			<div class="contentpanel">
				<!-- content goes here... -->

				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-btns">
							<a href="" class="panel-close">&times;</a> <a href=""
								class="minimize">&minus;</a>
						</div>
						<!-- panel-btns -->
						<h3 class="panel-title">数据表</h3>
					</div>
					<div class="panel-body">
						<br />
						<div class="table-responsive">

							<table id="dataTable" class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>销售名</th>
										<th>所属地接社</th>
										<th>电子邮件</th>
										<th>操作</th>
									</tr>
								</thead>
								
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


	<script type="text/javascript">
	
		jQuery(document).ready(function() {
			
			var t = jQuery('#dataTable').DataTable({
				pageLength: 10,
				processing: true,
				language: datatable_local_language, // my.js
				serverSide: true,
				ajax: {
					url: '${rootPath}sale/list.do',
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
	                  data: "sale_id",
	                  //defaultContent: '<a class="btn btn-success btn-xs"><span class="fa fa-edit"></span> 编辑</a>&nbsp;<a class="btn btn-danger btn-xs"><span class="fa fa-minus-circle"></span> 删除</a>',
	                  orderable: false,
	                  render: function ( data, type, full, meta ) {
	                      return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>&nbsp;<a class="btn btn-danger btn-xs" id="'+data+'"><span class="fa fa-minus-circle"></span> 删除</a>';
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
		            { data: "sale_id" },
		            { data: "name" },
		            { data: "agency_id" },
					{ data: "email" }
		        ]
			});
			
			$('#dataTable tbody').on( 'click', 'a.btn-success', function () {
		        var data = t.row($(this).parents('tr')).data();
		        //alert($(this).attr('id'));
		        edit($(this).attr('id'));
		    } );

			$('#dataTable tbody').on( 'click', 'a.btn-danger', function () {
		        var data = t.row($(this).parents('tr')).data();
		        //alert($(this).attr('id'));
		        del($(this).attr('id'));
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
			window.parent.location = "${rootPath}sale/edit.html?id="+id;
		}
		
		function del(id) {
			$("#confirmDelModal .hiddenId").val("");
			$("#confirmDelModal .hiddenId").val(id);
			$("#confirmDelModal").modal('show');
		}
		
		function doDel(id){
			$.ajax({
				url: "${rootPath}sale/del.do?id=" + id, 
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
