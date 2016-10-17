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
					<i class="glyphicon glyphicon-briefcase"></i> 地接社管理 <span>地接社列表</span>
				</h2>
			</div>
			<div class="contentpanel">
				<!-- content goes here... -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-btns">
						 	<a href="javascript:void(0)" class="minimize">&minus;</a>
						</div>
						<!-- panel-btns -->
						<h3 class="panel-title">地接社列表</h3>
					</div>
					<div class="panel-body">
						<br />
						<div class="table-responsive">

							<table id="dataTable" class="table">
								<thead>
									<tr>
										<th>地接社名</th>
										<th>国家</th>
										<th>语言</th>
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
	var country= ${country};
//	console.log(country)
	var language = ${language};
	
	jQuery(document).ready(function() {

		$(".nav-parent").eq(3).addClass("nav-active");
    	$(".nav-parent").eq(3).find(".children").show();

		var agencyTable= jQuery('#dataTable').DataTable({
			pageLength: 10,
			processing: true,
			language: datatable_local_language, // my.js
			serverSide: true,
			ajax: {
			url: '${rootPath}agency/list.do',
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
	                  data: "agencyId",
	                  orderable: false,
	                  render: function ( data, type, full, meta ) {
	                      return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>&nbsp;<a class="btn btn-danger btn-xs" id="'+data+'"><span class="fa fa-minus-circle"></span> 删除</a>';
	                  },
	                  targets: 3
				  },
				  {
	                data: "country",
	                orderable: false,
	                render: function ( data ) {
	                	if(data){
		                	for(var i=0;i <country.length;i++){
		                		if(data==country[i].id){
		                			return country[i].text	                			
		                		}
		                	}
		                }else{return ""}
	                },
	                  targets: 1
				  },
				  {
		                data: "language",
		                orderable: false,
		                render: function ( data ) {
		                	if(data){
			                	for(var i=0;i <language.length;i++){		                	
			                		if(data==language[i].id){
			                			return language[i].text
			                		}
			                	}
			                 }else{return ""}
		                },
		                  targets: 2
					  },
				  {
					  orderable: false,
					  searchable: false,
				      targets: [0]
				  },

				],
				columns: [
		            { data: "name" },
		            { data: "country" },
					{ data: "language" }
		        ]
			});
			
			$('#dataTable tbody').on( 'click', 'a.btn-success', function () {
		        var data = agencyTable.row($(this).parents('tr')).data();
		        edit($(this).attr('id'));
		    } );

			$('#dataTable tbody').on( 'click', 'a.btn-danger', function () {
		        var data = agencyTable.row($(this).parents('tr')).data();
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
			window.parent.location = "${rootPath}agency/edit.html?id="+id;
		}
		
		function del(id) {
			$("#confirmDelModal .hiddenId").val("");
			$("#confirmDelModal .hiddenId").val(id);
			$("#confirmDelModal").modal('show');
		}
		
		function doDel(id){
			$.ajax({
				url: "${rootPath}agency/del.do?id=" + id, 
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
