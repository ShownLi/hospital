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
					<i class="fa fa-user"></i> 客人管理 <span>客人列表</span>
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
						<h3 class="panel-title">客人列表</h3>
						<div class="row" style="margin-top: 20px">
							<div class="form-group col-sm-10">
								<div class="col-sm-2">
									<input type="text" id="searchChineseName" class="form-control" placeholder="客人姓名" value="${searchCustomer.chineseName }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchCustomerId" class="form-control" placeholder="客人id"  value="${searchCustomer.customerId }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchEnglishName" class="form-control" placeholder="英文名" value="${searchCustomer.englishName }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchMobilephone" class="form-control" placeholder="手机" value="${searchCustomer.mobilephone }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchEmail" class="form-control" placeholder="邮箱" value="${searchCustomer.email }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchLocation" class="form-control" placeholder="所在地" value="${searchCustomer.location }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchLevel" class="level-select fullwidth" value="${searchCustomer.level }" />
								</div>
								<div class="col-sm-2">
									<input type="text" id="searchSource" class="source-select fullwidth" value="${searchCustomer.source }" />
								</div>
				                <div class="col-sm-2">
									<div class="input-group input-datepicker" style="padding: 0;">
				                        <input readonly="readonly" id="searchStartDateTime" type="text" name="searchStartDateTime" class="form-control datepicker" placeholder="请点击输入查询开始日期" value="${searchCustomer.searchStartTime}" autocomplete="on">
				                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                    </div>
				                </div>
			                    <div class="col-sm-2">
				                    <div class="input-group input-datepicker" style="padding: 0;">
				                        <input readonly="readonly" id="searchEndDateTime" type="text" name="searchEndDateTime" class="form-control datepicker" placeholder="请点击输入查询截止日期" value="${searchCustomer.searchEndTime}" autocomplete="on">
				                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                    </div>
			                    </div>
							</div>	
							<div class="col-sm-2">					 		                        		
								<input class="btn btn-primary" type="button" id="searchBtn" value="搜索"/>
								<input type="hidden" id="searchFlag" value="${flag}" />
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
										<th>中文名</th>
										<th>英文名</th>
										<th>年龄段</th>
										<th>性别</th>
										<th>手机</th>
										<th>邮箱</th>
										<th>所在地</th>
										<th>客人级别</th>
										<th>客人来源</th>
										<th>创建时间</th>
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
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	<script src="${rootPath}assets/js/datepicker-zh-CN.js"></script>
	<script src="${rootPath}assets/js/datetimepicker-cn.js"></script>
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
	var ageGroup = ${ageGroup};
	var leval = ${level};
	var source = ${source};
	
	$(".level-select").select2({
        placeholder: '客人级别',
        data: leval,
        allowClear: true
    });
	$(".source-select").select2({
        placeholder: '客人来源',
        data: source,
        allowClear: true
    });
	jQuery("#searchStartDateTime").datepicker({
        dateFormat: "yy-mm-dd",
        changeYear: true,
        changeMonth: true,
     });
    
    jQuery("#searchEndDateTime").datepicker({
        dateFormat: "yy-mm-dd",
        changeYear: true,
        changeMonth: true,
     });
	
		jQuery(document).ready(function() {
			$(".nav-parent").eq(2).addClass("nav-active");
      		$(".nav-parent").eq(2).find(".children").show();
			
			var t = jQuery('#dataTable').DataTable({
				searching:false,
				pageLength: 10,
				processing: true,
				language: datatable_local_language, // my.js
				serverSide: true,
				stateSave:true,
				ajax: {
					url: '${rootPath}customer/list.do',
					data:function ( data ) {
						var searchChineseName=$('#searchChineseName').val();
			 			var searchCustomerId=$('#searchCustomerId').val();
			 			var searchEnglishName=$('#searchEnglishName').val();
			 			var searchMobilephone=$('#searchMobilephone').val();
			 			var searchEmail=$('#searchEmail').val();
			 			var searchLocation=$('#searchLocation').val();
			 			var searchLevel=$('#searchLevel').val();
			 			var searchSource=$('#searchSource').val();
			 			var searchStartDateTime=$("#searchStartDateTime").val();
			 			var searchEndDateTime=$("#searchEndDateTime").val();
			 			var searchFlag=$('#searchFlag').val();
			 			data.flag = searchFlag;
			 			if(searchChineseName !=null && searchChineseName !="" ){
							data.chineseName = searchChineseName;
			 			}
			 			if(searchCustomerId !=null && searchCustomerId !="" ){
							data.customerId = searchCustomerId;
			 			}
			 			if(searchEnglishName !=null && searchEnglishName !="" ){
							data.englishName = searchEnglishName;
			 			}
			 			if(searchMobilephone !=null && searchMobilephone !="" ){
							data.mobilephone = searchMobilephone;
			 			}
			 			if(searchEmail !=null && searchEmail !="" ){
							data.email = searchEmail;
			 			}
			 			if(searchLocation !=null && searchLocation !="" ){
							data.location = searchLocation;
			 			}
			 			if(searchSource !=null && searchSource !="" ){
							data.source = searchSource;
			 			}
			 			if(searchStartDateTime !=null && searchStartDateTime !=""){
			 				data.searchStartTime = searchStartDateTime;
			 			}
			 			if(searchEndDateTime !=null && searchEndDateTime !=""){
			 				data.searchEndTime = searchEndDateTime;
			 			}
			 			if(searchLevel !=null && searchLevel !="" ){
							data.level = searchLevel;
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
						data: "customerId",
						orderable: false,
						render: function ( data, type, full, meta ) {
							return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a> &nbsp; <a class="btn btn-primary btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 增加询单</a> &nbsp;';
						},
						targets: 11
					},

					  {
		                data: "ageGroup",
		                orderable: false,
		                render: function ( data ) {
		                	for(var i=0;i <  ageGroup.length;i++){
		                		if(data==ageGroup[i].id){
		                			return ageGroup[i].text
		                		}
		                		else{return '无';}
		                	}
		                },
		                  targets: 3
					  },
					  {
			                data: "level",
			                orderable: false,
			                render: function ( data ) {
			                	for(var i=0;i <  leval.length;i++){
			                		if(data==leval[i].id){
			                			return leval[i].text
			                		}
			                		if(data==''){return '无';}
			                	}
			                },
			                  targets: 8
						  },
					  {
		                  data: "gender",
		                  orderable: false,
		                  render: function ( data ) {
		                      if(data=='male'){return '男';};
		                      if(data=='female'){return '女';}
		                      else{return '无';}
		                  },
		                  targets: 4
					  },
					  {
			                data: "source",
			                orderable: false,
			                render: function ( data ) {
			                	for(var i=0;i<source.length;i++){
			                		if(data==source[i].id){
			                			return source[i].text
			                		}
			                		if(data==''){return '无';}
			                	}
			                },
			                targets: 9
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
			                  targets: 10
						},
				    {
					  orderable: false,
					  searchable: false,
				      targets: [0,1,2,3,4,5]
				    },
				],
				columns: [
		            { data: "customerId" },
		            { data: "chineseName" },
		            { data: "englishName" },
		            { data: "ageGroup" },
		            { data: "gender" },
		            { data: "mobilephone" },
		            { data: "email" },
		            { data: "location" },
		            { data: "level" },
		            { data: "source" },
		            { data: "creatTime" }
		        ]
			});
			
			if($('#searchFlag').val()=="restart"){
				t.ajax.reload();
			}
		  	$('#searchBtn').on( 'click', function () {
		  		//通知后台，使用界面的条件来重绘table
				$('#searchFlag').val("restart");
		        t.draw();
		    } );
		  
			$('#dataTable tbody').on( 'click', 'a.btn-success', function () {
		        var data = t.row($(this).parents('tr')).data();
		        edit($(this).attr('id'));
		    } );
			
			$('#dataTable tbody').on( 'click', 'a.btn-primary', function () {
		        var data = t.row($(this).parents('tr')).data();
		        addCase($(this).attr('id'));
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
			window.parent.location = "${rootPath}customer/edit.html?id="+id;
		}
		
		function addCase(id){
			window.parent.location = "${rootPath}case/addCase.html?customerId="+id;
		}
		
		function del(id) {
			$("#confirmDelModal .hiddenId").val("");
			$("#confirmDelModal .hiddenId").val(id);
			$("#confirmDelModal").modal('show');
		}
		
		function doDel(id){
			$.ajax({
				url: "${rootPath}customer/del.do?id=" + id, 
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
