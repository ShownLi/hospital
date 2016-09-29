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
					<i class="glyphicon glyphicon-briefcase"></i> 地接社管理 <span>编辑地接社</span>
				</h2>
				<!-- <div class="breadcrumb-wrapper">
					<span class="label">你在这里:</span>
					<ol class="breadcrumb">
						<li><a href="＃">CRM</a></li>
						<li><a href="${rootPath }agency/list.html">地接社管理</a></li>
						<li class="active">编辑地接社</li>
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
          				<h4 class="panel-title">地接社基本信息</h4>
          				<p>填写下表，完成地接社信息修改。</p>
        			</div>
       		
		       	 	<form class="form-horizontal" id="form">
		       	 	
		       			<div class="panel-body panel-body-nopadding">
		          			<div class="section-block">
			            		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">地接社名称 <span class="asterisk">*</span></label>
			              			<div class="col-sm-8">
			              				<input type="text" id="agencyname" name="name" placeholder="地接社名称" class="form-control" value="${agency.name }" />
			              			</div>
			              		</div>         
			            		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">语言</label>
			               			<div class="col-sm-8">
			               				<input type="text" id="language" name="language" class="language-select fullwidth" value="${agency.language }"/>
			               			</div>
			            		</div>              
			            		<div class="form-group col-sm-4">
			              			<label class="col-sm-4 control-label">国家</label>
			              			<div class="col-sm-8">
			              				<input type="text" id="country" name="country" class="country-select fullwidth" value="${agency.country }"/>
			              			</div>
			            		</div>            
			        		</div>
		        		</div><!-- panel-body -->
		        
		        		<div class="panel-footer align-center">
							<button class="btn btn-primary">保存</button>&nbsp;
							<button class="btn btn-default" id="btn-back">返回</button>&nbsp;
							<input type="hidden" name="agency_id" value="${agency.agency_id }" />
						</div><!-- panel-footer -->
		     		</form>   
      			</div><!-- panel -->

 		<!-- panel 销售列表 -->
      			<div class="panel panel-default">
          		<div class="panel-heading">
          		<div class="panel-btns">
              		<a href="" class="minimize">&minus;</a>
          		</div>
          			<h4 class="panel-title">销售列表 </h4>
          		</div>
          		<div class="panel-body">
	              	<table id="dataTable" class="table">
						<thead>
							<tr>
								<th>ID</th>
								<th>Portal  ID</th>
								<th>姓名</th>
								<th>邮箱</th>
								<th>编辑</th>
							</tr>
						</thead>
					</table>
          		</div>
          		<div class="panel-footer align-center">
					<a class="btn btn-primary" href="${rootPath}sale/add.html?agencyid=${agency.agency_id}">新增销售</a>
      			</div>
				</div>
				<!-- end of panel 沟通列表 -->
			</div>
		</div>
		<!-- mainpanel -->
		<%@ include file="../assets/pages/rightpanel.jsp"%>
	</section>


		<!-- Modal 保存数据出错-->
		<div class="modal fade" id="msgModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title" id="myModalLabel">信息</h4>
		      </div>
		      <div class="modal-body">
		        保存数据时出错了
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		      </div>
		    </div><!-- modal-content -->
		  </div><!-- modal-dialog -->
		</div><!-- modal -->

		<!-- Modal 删除确认-->
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

	<%@ include file="../assets/pages/foot.jsp"%>
	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	

<script type="text/javascript">
	var c = ${country};
	var l = ${language};
	$(".country-select").select2({
	  	data: c
	})
	$(".language-select").select2({
	  	data: l
	})

	jQuery(document).ready(function() {
		
		$(".nav-parent").eq(3).addClass("nav-active");
      	$(".nav-parent").eq(3).find(".children").show();
      	
		jQuery("#form").validate({
			rules: {
				name: {  
		         	required:true,  
		            remote:{                           
		            	url:"${rootPath}validate.do",
		            	type:"post",
		            	data: {
	                         table: function () { return "tm_agency"},
	                         field: function () { return "agency_name"},
	                         name: function () {
	                        	 
	                        	  if($("#agencyname").val()=="${agency.name}"){
		                        	 	return "";
		                        	 }
		                        	 else{return $("#agencyname").val();} 
	                        	
	                         	}
		            		}
		        		}
					}
				},
			messages: {
				name: {
					required:"请输入地接社名",
					remote:"地接社已存在，请重新输入"
				}
			},
		    highlight: function(element) {
		      jQuery(element).closest('.form-group').removeClass('has-success').addClass('has-error');
		    },
		    success: function(element) {
		      jQuery(element).closest('.form-group').removeClass('has-error');
		    },
		    invalidHandler : function(){
		      return false;
		    },
		    submitHandler : function(){
		      form_submit();
		      return false;
		    }
		  });
		
		
		$("#btn-back").click( function () {
			history.go(-1);
	    } ); 
		
	});
//			      
	function form_submit() {
		var f = $("#form").serialize();
		$.post('${rootPath}agency/edit.do', f, function(result) {
			var rmsg = result.msg;
			if (result.success) {
				window.parent.location = "${rootPath}agency/list.html";
				} 
			else {
				$("#msgModal").modal('show');
				}
			}, "JSON");
		}
		
	var t = jQuery('#dataTable').DataTable({
		pageLength: 10,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		ajax: {
			url: '${rootPath}sale/list.do?agencyid=${agency.agency_id}',
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
	            data: "salesid",
	            //defaultContent: '<a class="btn btn-success btn-xs"><span class="fa fa-edit"></span> 编辑</a>&nbsp;<a class="btn btn-danger btn-xs"><span class="fa fa-minus-circle"></span> 删除</a>',
	            orderable: false,
	            render: function ( data, type, full, meta ) {
	            	return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>&nbsp;<a class="btn btn-danger btn-xs" id="'+data+'"><span class="fa fa-minus-circle"></span> 删除</a>';
	            	},
	            targets: 4
			},
			],
		columns: [
			{ data: "salesid" },
		    { data: "salesportalid" },
		    { data: "salesname" },
		    { data: "salesemail" }
	    ]
		});
	$('#dataTable tbody').on( 'click', 'a.btn-success', function () {
		var data = t.row($(this).parents('tr')).data();
	    //alert($(this).attr('id'));
	    edit($(this).attr('id'));
	    });

	$('#dataTable tbody').on( 'click', 'a.btn-danger', function () {
	    var data = t.row($(this).parents('tr')).data();
	    //alert($(this).attr('id'));
	    del($(this).attr('id'));
	    });
		
	$('#confirmDelModal').on( 'click', 'button.btn-danger', function () {
	    var id = $("#confirmDelModal .hiddenId").val();
	    doDel(id);
	    }); 
	    
		// Select2
	jQuery('select').select2({
		minimumResultsForSearch: -1
		});
	    
	jQuery('select').removeClass('form-control');
		
	
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
