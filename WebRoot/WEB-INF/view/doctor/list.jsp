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
					<i class="fa fa-user"></i> 医生管理 <span>医生列表</span>
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
						<h3 class="panel-title">医生信息列表</h3>
						<div class="row" style="margin-top: 20px">
							<div class="form-group col-sm-10">
								<div class="col-sm-2">
									<input type="text" id="searchDoctorId" class="form-control" placeholder="医生编号"  value="${sessionScope.searchDoctor.doctorId}" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchDoctorName" class="form-control" placeholder="医生名称"  value="${sessionScope.searchDoctor.name}" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchDoctorDept" class="dept-select fullwidth" value="${sessionScope.searchDoctor.dept}" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchDoctorLevel" class="level-select fullwidth" value="${sessionScope.searchDoctor.level}" />
									<input type="hidden" id="searchDoctorFlag"  value="${flag}" />
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
										<th>工号</th>
										<th>医生姓名</th>
										<th>年龄</th>
										<th>性别</th>
										<th>电话</th>
										<th>所属科室</th>
										<th>医生级别</th>
										<th>日最大接待患者数</th>
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
	
	var level = ${level};
	var dept = ${dept};
	
	$(".level-select").select2({
        placeholder: '医生级别',
        data: level,
        allowClear: true
    });
	$(".dept-select").select2({
        placeholder: '科室类别',
        data: dept,
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
				url: '${rootPath}doctor/list.do',
				data:function ( data ) {
					var searchDoctorId = $('#searchDoctorId').val();
					var searchDoctorName = $('#searchDoctorName').val();
		 			var searchDoctorDept = $('#searchDoctorDept').val();
		 			var searchDoctorLevel = $('#searchDoctorLevel').val();
		 			var searchDoctorFlag = $('#searchDoctorFlag').val();
		 			
		 			if(searchDoctorId !=null && searchDoctorId !="" ){
						data.doctorId = searchDoctorId;
		 			}
		 			if(searchDoctorName !=null && searchDoctorName !="" ){
						data.name = searchDoctorName;
		 			}
		 			if(searchDoctorDept !=null && searchDoctorDept !="" ){
						data.dept = searchDoctorDept;
		 			} 
		 			if(searchDoctorLevel !=null && searchDoctorLevel !="" ){
						data.level = searchDoctorLevel;
		 			} 
		 			data.flag = searchDoctorFlag;
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
		          data: "doctorId",
			      orderable: false,
			      render: function ( data, type, full, meta ) {
	              	return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>&nbsp; <a class="btn btn-danger btn-xs" id="'+data+'"><span class="fa fa-minus-circle"></span> 删除</a>';
			  	  },
			      targets: 8
			  },
			  {
				  data:"sex",
				  orderable:false,
				  render:function(data){
					  if(data==0){
						  return "男";
					  }else{
						  return "女";
					  }
				  },
			  	targets: 3
			  },
			  {
	                data: "level",
	                orderable: false,
	                render: function ( data ) {
	                	if(data){
		                	for(var i=0;i <level.length;i++){
		                		if(data==level[i].id){
		                			return level[i].text	                			
		                		}
		                	}
		                	return "";
		                }else{return ""}
	                },
	                  targets: 6
				  },
				  {
		                data: "dept",
		                orderable: false,
		                render: function ( data ) {
		                	if(data){
			                	for(var i=0;i <dept.length;i++){		                	
			                		if(data==dept[i]){
			                			return dept[i]                			
			                		}
			                	}
			                	return "";
			                 }else{
			                	 return ""
			                 }
		                },
		                  targets: 5
				  },
			  {
				  orderable: false,
				  searchable: false,
			      targets: [0,1,2,4,7]
			  },
			],
			columns: [
	            { data: "doctorId" },
	            { data: "name" },
	            { data: "age" },
	            { data: "sex" },
	            { data: "phone" },
	            { data: "dept" },
	            { data: "level" },
	            { data: "number" }
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
		window.parent.location = "${rootPath}doctor/edit.html?id="+id;
	}
	
	function del(id) {
		$("#confirmDelModal .hiddenId").val("");
		$("#confirmDelModal .hiddenId").val(id);
		$("#confirmDelModal").modal('show');
	}
	
	function doDel(id){
		$.ajax({
			url: "${rootPath}doctor/del.do?id=" + id, 
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
