﻿<%@ page language="java" pageEncoding="utf-8"%>
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
					<i class="fa fa-user"></i> 科室管理 <span>科室列表</span>
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
						<h3 class="panel-title">科室信息列表</h3>
						<div class="row" style="margin-top: 20px">
							<div class="form-group col-sm-10">
								<div class="col-sm-2">
									<input type="text" id="searchDeptName" class="form-control" placeholder="科室名称"  value="${sessionScope.searchDept.name }" />
									</div>
								<div class="col-sm-2">
									<input type="text" id="searchDeptArea" class="area-select fullwidth" value="${sessionScope.searchDept.area }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchDeptClassify" class="classify-select fullwidth" value="${sessionScope.searchDept.classify }" />
									<input type="hidden" id="searchDeptFlag"  value="${flag}" />
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
										<th>科室名称</th>
										<th>所属区域</th>
										<th>联系电话</th>
										<th>科室类别</th>
										<th>编辑</th>
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
        <button class="btn btn-default" data-dismiss="modal">取消</button>
        <button class="btn btn-danger">删除</button>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->


<script type="text/javascript">
	
	var area = ${area};
	var classify = ${classify};
	
	$(".area-select").select2({
        placeholder: '所属区域',
        data: area,
        allowClear: true
    });
	$(".classify-select").select2({
        placeholder: '科室类别',
        data: classify,
        allowClear: true
    });
	
	jQuery(document).ready(function() {

		$(".nav-parent").eq(4).addClass("nav-active");
     		$(".nav-parent").eq(4).find(".children").show();
     		     				
		var t = jQuery('#dataTable').DataTable({
			searching:false,
			pageLength: 10,
			processing: true,
			language: datatable_local_language, // my.js
			serverSide: true,
			stateSave:true,
			ajax: {
				url: '${rootPath}dept/list.do',
				data:function ( data ) {
					var searchDeptName=$('#searchDeptName').val();
		 			var searchDeptArea=$('#searchDeptArea').val();
		 			var searchDeptClassify=$('#searchDeptClassify').val();
		 			var searchDeptFlag=$('#searchDeptFlag').val();
		 			
		 			if(searchDeptName !=null && searchDeptName !="" ){
						data.name = searchDeptName;
		 			}
		 			if(searchDeptArea !=null && searchDeptArea !="" ){
						data.area = searchDeptArea;
		 			}
		 			if(searchDeptClassify !=null && searchDeptClassify !="" ){
						data.classify = searchDeptClassify;
		 			} 
		 			data.flag = searchDeptFlag;
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
		          data: "deptId",
			      orderable: false,
			      render: function ( data, type, full, meta ) {
	              	return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>&nbsp; <a class="btn btn-danger btn-xs" id="'+data+'"><span class="fa fa-minus-circle"></span> 删除</a>';
			  	  },
			      targets: 4
			  },
			  {
	                data: "area",
	                orderable: false,
	                render: function ( data ) {
	                	if(data){
		                	for(var i=0;i <area.length;i++){
		                		if(data==area[i].id){
		                			return area[i].text	                			
		                		}
		                	}
		                	return "";
		                }else{return ""}
	                },
	                  targets: 1
				  },
				  {
		                data: "classify",
		                orderable: false,
		                render: function ( data ) {
		                	if(data){
			                	for(var i=0;i <classify.length;i++){		                	
			                		if(data==classify[i].id){
			                			return classify[i].text
			                		}
			                	}
			                	return "";
			                 }else{
			                	 return ""
			                 }
		                },
		                  targets: 3
				  },
			  {
				  orderable: false,
				  searchable: false,
			      targets: [0,2]
			  },
			],
			columns: [
	            { data: "name" },
	            { data: "area" },
	            { data: "phone" },
	            { data: "classify" }
	        ]
		});
		
		$('#dataTable tbody').on( 'click', 'a.btn-success', function () {
	        var data = t.row($(this).parents('tr')).data();
	        edit($(this).attr('id'));
	    } );

		$('#searchBtn').on( 'click', function () {
			//通知后台，使用界面的条件来重绘table
			$('#searchDeptFlag').val("restart");
			t.draw();
	    } );
		
		$('#dataTable tbody').on( 'click', 'a.btn-danger', function () {
	        var data = t.row($(this).parents('tr')).data();
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
		window.parent.location = "${rootPath}dept/edit.html?id="+id;
	}
	
	function del(id) {
		$("#confirmDelModal .hiddenId").val("");
		$("#confirmDelModal .hiddenId").val(id);
		$("#confirmDelModal").modal('show');
	}
	
	function doDel(id){
		$.ajax({
			url: "${rootPath}dept/del.do?id=" + id, 
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
