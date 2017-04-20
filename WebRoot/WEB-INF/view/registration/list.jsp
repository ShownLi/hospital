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
					<i class="fa fa-user"></i> 患者管理 <span>患者列表</span>
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
						<h3 class="panel-title">患者信息列表</h3>
						<div class="row" style="margin-top: 20px">
							<div class="form-group col-sm-10">
								<div class="col-sm-2">
									<input type="text" id="searchPatientId" class="form-control" placeholder="患者编号"  value="${sessionScope.searchPatient.patientId}" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchPatientName" class="form-control" placeholder="患者姓名"  value="${sessionScope.searchPatient.name}" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchPatientLevel" class="form-control" placeholder="患者联系电话" value="${sessionScope.searchPatient.phone}" />
									<input type="hidden" id="searchPatientFlag"  value="${flag}" />
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
										<th>患者编号</th>
										<th>患者姓名</th>
										<th>年龄</th>
										<th>性别</th>
										<th>联系电话</th>
										<th>地址</th>
										<th>紧急联系人电话</th>
										<th>挂号日期</th>
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
				url: '${rootPath}patient/list.do',
				data:function ( data ) {
					var searchPatientId = $('#searchPatientId').val();
					var searchPatientName = $('#searchPatientName').val();
		 			var searchPatientPhone = $('#searchPatientPhone').val();
		 			var searchPatientFlag = $('#searchPatientFlag').val();
		 			
		 			if(searchPatientId !=null && searchPatientId !="" ){
						data.patientId = searchPatientId;
		 			}
		 			if(searchPatientName !=null && searchPatientName !="" ){
						data.name = searchPatientName;
		 			}
		 			if(searchPatientPhone !=null && searchPatientPhone !="" ){
						data.phone = searchPatientPhone;
		 			} 
		 			data.flag = searchPatientFlag;
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
		          data: "patientId",
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
                  orderable: false,
                  render: function ( data, type, full, meta ) {
                	  	var m = full.date.time;
	                	if(full.date){
	                		m=new Date(m).format("yyyy-MM-dd hh:mm:ss");
	                	}else{
	                		m="";
	                	}
	                	return "<div class='caselist-7'>" + m + "</div>"
                  },
                  targets: 7
			    },
			  {
				  orderable: false,
				  searchable: false,
			      targets: [0,1,2,4,5,6,7]
			  },
			],
			columns: [
	            { data: "patientId" },
	            { data: "name" },
	            { data: "birthday" },
	            { data: "sex" },
	            { data: "phone" },
	            { data: "address" },
	            { data: "urgentPhone" },
	            { data: "date" }
	        ]
		});
		
		$('#dataTable tbody').on( 'click', 'a.btn-success', function () {
	        var data = t.row($(this).parents('tr')).data();
	        edit($(this).attr('id'));
	    } );

		$('#searchBtn').on( 'click', function () {
			//通知后台，使用界面的条件来重绘table
			$('#searchPatientFlag').val("restart");
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
		window.parent.location = "${rootPath}patient/edit.html?id="+id;
	}
	
	function del(id) {
		$("#confirmDelModal .hiddenId").val("");
		$("#confirmDelModal .hiddenId").val(id);
		$("#confirmDelModal").modal('show');
	}
	
	function doDel(id){
		$.ajax({
			url: "${rootPath}patient/del.do?id=" + id, 
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
