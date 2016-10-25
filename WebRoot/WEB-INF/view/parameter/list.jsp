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
					<i class="glyphicon glyphicon-cog"></i> 系统参数管理 <span>系统参数列表</span>
				</h2>
			</div>

			<div class="contentpanel">
				<!-- content goes here... -->
				
			<div class="section-block">    
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label"><span class="asterisk">*</span></label>
	              <div class="col-sm-8">
	                <input type="text" id="domain" name="domain" placeholder="作用域" class="form-control" />
	              </div>
	            </div>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">值 <span class="asterisk">*</span></label>
	              <div class="col-sm-8">
	                <input type="text" id="value" name="value" placeholder="值" class="form-control" />
	              </div>
	            </div> 			
	            <div class="form-group col-sm-4">
	              <label class="col-sm-4 control-label">描述 <span class="asterisk">&nbsp;</span></label>
	              <div class="col-sm-8">
	                <input type="text" name="depict" placeholder="描述" class="form-control" />
	              </div>
	            </div> 	
	        </div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-btns">
							<a href="" class="minimize">&minus;</a>
						</div>
						<!-- panel-btns -->
	<!-- 					<h3 class="panel-title">系统参数列表</h3>
						 <input type="text" id="searchText" value="" /> 
						 <select  id="searchMenu">
						 <option value="domain">作用域</option>
						 <option value="value">存值</option>
						 <option value="chinese">中文</option>						 
						 <option value="english">英文</option>			
					 </select>
						 <input type="button" id="searchBtn" value="搜索"/> 	  -->
					</div>
					<div class="panel-body">
						<br />
						<div class="table-responsive">

							<table id="dataTable" class="table">
								<thead>
									<tr>
										<th>作用域</th>
										<th>存值</th>
										<th>中文</th>
										<th>英文</th>
										<th>排序标记</th>
										<th>是否显示</th>
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

			$(".nav-parent").eq(5).addClass("nav-active");
      		$(".nav-parent").eq(5).find(".children").show();
			
			var t = jQuery('#dataTable').DataTable({
				pageLength: 10,
				processing: true,
				language: datatable_local_language, // my.js
				serverSide: true,
				ajax: {
					url: '${rootPath}parameter/list.do',
					data:function ( data ) {
			 			var menu=$('#searchMenu').val();
			 			var text=$('#searchText').val();
			 			if(text !=null && text !="" ){	
			 				
			 			if(menu=="domain"){
			 				data.domain = text;	
			 			}
			 			
			 			if(menu=="value"){
			 				data.value = text;
			 			}
			 			
			 			if(menu=="chinese"){
			 				data.chinese = text;
			 			}
			 			
			 			if(menu=="english"){
			 				data.english = text;
			 			}
			 			
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
	                  data: "parameterId",
	                  orderable: false,
	                  render: function ( data ) {
	                      return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>&nbsp;<a class="btn btn-danger btn-xs" id="'+data+'"><span class="fa fa-minus-circle"></span> 删除</a>';
	                  },
	                  targets: 6
				  },
				  {
	                  data: "isdisplay",
	                  orderable: false,
	                  render: function ( data ) {
	                      if(data==1){return '是';}
	                      else{return '否';}
	                  },
	                  targets: 5
				  },
				  {
					  orderable: false,
					  searchable: false,
				      targets: [0,1,2,3,4,5,6]
				  },

				],
				columns: [
		            { data: "domain" },
		            { data: "value" },
		            { data: "chinese" },
		            { data: "english" },
		            { data: "sort" },
		            { data: "isdisplay" }
		        ]
			});
			
/* 			$('#searchBtn').on( 'click', function () {
		    	alert($('#customerName').attr("value"));
		        t.draw();
		    } ); */
			
			$('#dataTable tbody').on( 'click', 'a.btn-success', function () {
		        var data = t.row($(this).parents('tr')).data();
		        edit($(this).attr('id'));
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
			window.parent.location = "${rootPath}parameter/edit.html?id="+id;
		}
		
		function del(id) {
			$("#confirmDelModal .hiddenId").val("");
			$("#confirmDelModal .hiddenId").val(id);
			$("#confirmDelModal").modal('show');
		}
		
		function doDel(id){
			$.ajax({
				url: "${rootPath}parameter/del.do?id=" + id, 
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
