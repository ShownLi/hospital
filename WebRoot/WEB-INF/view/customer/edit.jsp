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
					<i class="glyphicon glyphicon-briefcase"></i> 客人管理 <span>编辑客人</span>
				</h2>
			</div>
			<div class="contentpanel">
				<!-- content goes here... -->

		<div class="panel panel-default">
        <div class="panel-heading">
          <div class="panel-btns">
            <a href="" class="minimize">&minus;</a>
          </div>
          <h4 class="panel-title">客人基本信息</h4>
          <p>填写下表，完成客人信息修改。</p>
        </div>
        <form class="form-horizontal form-bordered" id="form-base">
        <div class="panel-body panel-body-nopadding">        
					<div class="section-block">
		        		<h5 class="section-title">客人基本信息</h5>
			            <div class="form-group col-sm-4">
							<label class="col-sm-3 control-label">中文名<span class="asterisk">*</span></label>
							<div class="col-sm-9">
							    <input type="text" name="chineseName" placeholder="中文名" class="form-control" value="${customer.chineseName}"/>
							</div>
			            </div>
			            <div class="form-group col-sm-4">
							<label class="col-sm-3 control-label">英文名</label>
							<div class="col-sm-9">
							    <input type="text" name="englishName" placeholder="英文名" class="form-control" value="${customer.englishName}"/>
							</div>
			            </div> 
			            <div class="form-group col-sm-4">
							<label class="col-sm-3 control-label" >性别 <span class="asterisk">&nbsp;</span></label>
							<div class="col-sm-9">
								<div class="rdio rdio-primary rdio-inline">
								    <input type="radio" id="male" value="male" name="gender">
								    <label for="male">男</label>
								</div><!-- rdio -->
								<div class="rdio rdio-primary rdio-inline">
								    <input type="radio" id="female" value="female" name="gender" >
								    <label for="female">女</label>
								</div><!-- rdio -->
							</div>
			            </div>
			            <div class="form-group col-sm-4">
			            	<label class="col-sm-3 control-label">生日</label>
			            	<div class="col-sm-9 input-group input-datepicker">
				                <input type="text" name="birthday" class="form-control datepicker" placeholder="yyyy-mm-dd" id="birthday" value="${customer.birthday}" autocomplete="off" >
				                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
			                </div>
			            </div> 
			            <div class="form-group col-sm-4">
							<label class="col-sm-3 control-label" >年龄段</label>
							<div class="col-sm-9">
							    <input type="text" name="ageGroup" placeholder="年龄段" class="agegroup-select fullwidth" value="${customer.ageGroup}"/>
							</div>
			            </div>
			            <div class="form-group col-sm-4">
							<label class="col-sm-3 control-label">客人级别</label>
							<div class="col-sm-9">
							    <input type="text" name="level" placeholder="客人级别" class="level-select fullwidth" value="${customer.level}" disabled="disabled" />
							</div>
			            </div> 
			        </div>
			        <div class="section-block">
			        	<h5 class="section-title">客人联系方式  <span style="font-size:12px;">(手机、微信、QQ、邮箱至少填写一个)</span></h5>
			            <div class="form-group col-sm-4">
			                <label class="col-sm-3 control-label">固定电话</label>
			                <div class="col-sm-9">
			                    <input type="text" name="telephone" placeholder="固定电话" class="form-control" value="${customer.telephone}"/>
			                </div>
			            </div>
			            <div class="form-group col-sm-4 contact-field">
			                <label class="col-sm-3 control-label">手机</label>
			                <div class="col-sm-9">
			                	<input type="text" name="mobilephone" placeholder="手机" class="form-control" value="${customer.mobilephone}"/>
			                </div>
			            </div>    
			            <div class="form-group col-sm-4 contact-field">
			                <label class="col-sm-3 control-label">微信</label>
			                <div class="col-sm-9">
			                	<input type="text" name="wechat" placeholder="微信" class="form-control" value="${customer.wechat}"/>
			                </div>
			            </div>       
			            <div class="form-group col-sm-4 contact-field">
			                <label class="col-sm-3 control-label">QQ</label>
			                <div class="col-sm-9">
			                	<input type="text" name="qq" placeholder="QQ" class="form-control" value="${customer.qq}"/>
			                </div>
			            </div>            
			            <div class="form-group col-sm-4 contact-field">
			                <label class="col-sm-3 control-label">邮箱</label>
			                <div class="col-sm-9">
			                	<input type="text" name="email" placeholder="邮箱" class="form-control"  value="${customer.email}"/>
			                </div>
			            </div>  
			            <div class="form-group col-sm-4">
			                <label class="col-sm-3 control-label">所在地</label>
			                <div class="col-sm-9">
			                	<input type="text" name="location" placeholder="所在地" class="form-control" value="${customer.location}"/>
			                </div>
			            </div> 
			        </div>
			        <div class="section-block"> 
			        	<h5 class="section-title">其他</h5>   
			            <div class="form-group col-sm-4">
			                <label class="col-sm-3 control-label" >客人来源 </label>
			                <div class="col-sm-9">
			               	 	<input type="text" name="source" class="promote-select fullwidth" value="${customer.source}"/>
			                </div>
			            </div>
			        </div>  
         
        </div><!-- panel-body -->
        
        <div class="panel-footer align-center">
			<button id="editCustomer" class="btn btn-primary">保存</button>&nbsp;
			<button class="btn btn-default" id="btn-back">返回</button>
			<input type="hidden" name="customerId" value="${customer.customerId }" />
		</div><!-- panel-footer -->
     </form>   
      </div><!-- panel -->
      
      
		<!-- panel 询单  -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-btns">
				  <a href="" class="minimize">&minus;</a>
				</div>
				<h4 class="panel-title">询单列表</h4>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table id="dataTable-case" class="table">
						<thead>
							<tr>
								<th>ID</th>
								<th>客人</th>
								<th>预算</th>
								<th>目的地</th>
								<th>询单来源</th>
								<th>跟单员</th>
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
		    <div class="panel-footer align-center">
			    <a class="btn btn-primary" href="${rootPath}case/addCase.html?customerId=${customer.customerId}">添加询单</a>
			</div>
		</div><!-- end of panel 询单  -->
		
 		<!-- panel 注释记录 -->
      			<div class="panel panel-default">
          		<div class="panel-heading">
          		<div class="panel-btns">
              		<a href="" class="minimize">&minus;</a>
          		</div>
          			<h4 class="panel-title">注释记录 </h4>
          		</div>
          		<div class="panel-body">
	          		<div class="table-responsive">
		              	<table id="dataTable-comment" class="table">
							<thead>
								<tr>
			                    <th>ID</th>
			                    <th>姓名</th>
			                    <th>注释内容</th>
			                    <th>时间</th>
								</tr>
							</thead>
						</table>
					</div>
					<!-- 添加注释 -->
					<div class="form-group col-sm-12 align-center" id="addNoteDiv">
						<input class="btn btn-primary" type="button" id="addNote" onclick="showNote()" value="添加注释"/>
					</div>
          		</div>
				</div>
				<!-- end of panel 注释列表 -->


			</div>

		</div>
		<!-- mainpanel -->
		<%@ include file="../assets/pages/rightpanel.jsp"%>
	</section>


<!-- Modal -->
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

<!-- 保存注释信息 -->
<div class="modal fade" id="addNote2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加注释信息</h4>
				</div>
				<div class="modal-body">
					<form id="form-comment" class="form" >
						<div class="form-group col-sm-6 col-sm-offset-3">
						    <textarea name="content" class="form-control" rows="5"></textarea>
						    <input  type="hidden" name="userId" value="${loginUser.userId}" />
						    <input  type="hidden" name="userName" value="${loginUser.name}" />
						    <input  type="hidden" name="objectId" value="${customer.customerId}" />
						    <input  type="hidden" name="commentType" value="customer" />
						</div>
						<div class="form-group col-sm-12 align-center">
							<button class="btn btn-primary">添加注释</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
		            </form>
				</div>
			</div>
			<!-- modal-content -->
		</div>
		<!-- modal-dialog -->
	</div>
	<%@ include file="../assets/pages/foot.jsp"%>
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/datepicker-zh-CN.js"></script>
	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript">
	
	function showNote() {
		$("#addNote2").modal('show');
	}
	
	var leval = ${level};
//	var source = ${source};
	var promote = ${promote};
	var ageGroup = ${ageGroup};
	var source = ${source};
	var caseStatus = ${status};
	var customerList = ${customerList};
	var user = ${user};
	var destination = ${destination};
	$(".promote-select").select2({
		placeholder: '选择一个客人来源',
	  	data: promote
	});
	$(".agegroup-select").select2({
		placeholder: '选择一个年龄段',
	  	data: ageGroup
	});
	$(".level-select").select2({
	  	data: leval
	});	
	
	if("${customer.gender}"=='male'){
		$('#male').attr('checked','true');
	};
	if("${customer.gender}"=='female'){
		$('#female').attr('checked','true');
	};
	jQuery(document).ready(function() {

		$(".nav-parent").eq(2).addClass("nav-active");
      	$(".nav-parent").eq(2).find(".children").show();
      	
			var caseTable= jQuery('#dataTable-case').DataTable({
				searching:false,
				paging: false,
				processing: true,
				language: datatable_local_language, // my.js
				serverSide: true,
				bInfo:false,
				ajax: {
					url: '${rootPath}case/listByCustomerId.do?customerId=${customer.customerId}',
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
						  return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>&nbsp;<a class="btn btn-danger btn-xs" id="'+data+'"><span class="fa fa-minus-circle"></span> 无效</a>&nbsp;&nbsp;&nbsp;';
						},
						targets: 7
					},
					  {
		                data: "customerId",
		                orderable: false,
		                render: function ( data ) {
		                	if(data){
			                	for(var i=0;i <  customerList.length;i++){
			                		if(data==customerList[i].id){
			                			return customerList[i].text
			                		}
			                	}
			                	return ""
		                	}
		                	else{return ""}
		                },
		                  targets: 1
					},
					  {
		                data: "destination",
		                orderable: false,
		                render: function ( data ) {
		                	
	                	var destinations="";
	                	
	                	if(data){
		                	var des=data.split(",");
		                	for(var j = 0;j<des.length;j++){
		                		for(var i=0;i <destination.length;i++){
			                		if(des[j]==destination[i].id){
			                			destinations+=destination[i].text+",";
			                		}				                	
			                	}
			                	return ""
		                	}
	                	}
		                destinations=destinations.substring(0,destinations.length-1);
		                return destinations;
		                },
		                  targets: 3
					},	
				  {
		                data: "source",
		                orderable: false,
		                render: function ( data ) {
		                	if(data){
			                	for(var i=0;i <  source.length;i++){
			                		if(data==source[i].id){
			                			return source[i].text
			                		}
			                	}
			                	return ""
		                	}
		                	else{return ""}
		                },
		                  targets: 4
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
			                	return ""
		                	}
		                	else{return ""}
		                },
		                  targets: 5
					},
					{
		                data: "status",
		                orderable: false,
		                render: function ( data ) {
		                	if(data){
			                	for(var i=0;i <caseStatus.length;i++){
			                		if(data==caseStatus[i].id){
			                			return caseStatus[i].text
			                		}
			                	}
			                	return ""
		                	}
		                	else{return ""}
		                },
		                  targets: 6
					},
					{
						  orderable: false,
						  searchable: false,
					      targets: [0]
					},

				],
				columns: [
				            { data: "caseId" },
				            { data: "customerId" },
				            { data: "budget" },
				            { data: "destination" },
				            { data: "source" },
				            { data: "operator" },
				            { data: "status" }
		        ]
			});
			
			// Select2
		    jQuery('select').select2({
		        minimumResultsForSearch: -1
		    });
		    jQuery('select').removeClass('form-control');

			$('#dataTable-case tbody').on( 'click', 'a.btn-success', function () {
		        var data = caseTable.row($(this).parents('tr')).data();
		        edit($(this).attr('id'));
		    });

			$('#dataTable-case tbody').on( 'click', 'a.btn-danger', function () {
		        var data = caseTable.row($(this).parents('tr')).data();
		        del($(this).attr('id'));
		    });
			
			$('#confirmDelModal').on( 'click', 'button.btn-danger', function () {
		        var id = $("#confirmDelModal .hiddenId").val();
		        doDel(id);
		    }); 
			
			function edit(id) {
				window.parent.location = "${rootPath}case/edit.html?id="+id;
			}
			
			function del(id) {
				$("#confirmDelModal .hiddenId").val("");
				$("#confirmDelModal .hiddenId").val(id);
				$("#confirmDelModal").modal('show');
			}
			
			function doDel(id){
				$.ajax({
					url: "${rootPath}case/del.do?id=" + id, 
					async: true,
					success: function(o) {
						window.location.reload();
					},
					error: function(o) {
						alert(2);
					}
				});
				
			}
		// Date Picker
		jQuery(".datepicker").datepicker({
			dateFormat: "yy-mm-dd",
			changeYear: true,
			changeMonth: true,
			maxDate: 0
		});

		jQuery("#form-base").validate({
			rules: {
				chineseName: "required",
				qq: "number",
				email: "email",
				birthday: "date",
				source: "required"
			},
			messages: {
				chineseName: "请输入中文名",
				qq: "请输入有效的QQ账号",
				email: "请输入有效的邮箱",
				birthday: "请输入正确的日期",
				source: "请选择一个客人来源"
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
		        var qq = $("input[name=qq]").val(),
		    		wechat = $("input[name=wechat]").val(),
		    		mobilephone = $("input[name=mobilephone]").val(),
		    		email = $("input[name=email]").val();

		    	// 手机，邮箱，微信，QQ，至少输入一个
		      	if(qq==""&&wechat==""&&mobilephone==""&&email==""){
		      		$(".contact-note").addClass("noted");
		      		$(".contact-field").addClass("has-error");
		      		
		      		return false;
		      	}else{
		      		$(".contact-note").removeClass("noted");
		      		$(".contact-field").removeClass("has-error");
		      		$("#editCustomer").attr("disabled","disabled");
			      	base_submit();
			      	return false;
			    }
		    }
			 
		}); 
		
		$("#btn-back").click( function () {
			history.go(-1);
	    } ); 
		
		//生日格式转换
		var date = $("#birthday").val();
		if(date!=null&&date!=""){
			var dateformat = new Date(date).toISOString("yyyy-MM-dd hh:mm:ss.S").substring(0,10);
			$("#birthday").val(dateformat);
		}
		
		// 手机，邮箱，微信，QQ，输入一个以后移除错误提示
		$(".contact-field").find("input").blur(function(){
			if($(this).val() !== ""){
				$(".contact-field").removeClass("has-error");
			}
		});
		
	});
	      
		function base_submit() {
			$(".level-select").attr("disabled",false); 
			var customerInfo = $("#form-base").serialize();
			$.post('${rootPath}customer/edit.do', customerInfo, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}customer/list.html";
				} else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
		
		var commentTable = jQuery('#dataTable-comment').DataTable({
			searching:false,
			paging:false,
			/* pageLength: 10, */
			processing: true,
			language: datatable_local_language, // my.js
			serverSide: true,
			bInfo:false,
			ajax: {
				url: '${rootPath}comment/list.do?type=customer&id=${customer.customerId}',
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
							  data: "creatTime",
							  render: function ( data, type, full, meta ) {
								  var creatTime = new Date(data.time);
			                    return creatTime.format("yyyy/MM/dd");
			                },
			                targets: 3
						  },		 

				],
			columns: [
		  			    { data: "commentId" },
		  			    { data: "userName" },
		  			    { data: "content" },
		  			    { data: "creatTime" }
		    ]
			});
			
		jQuery("#form-comment").validate({
			rules: {
				content: "required"
			},
			messages: {
				content: "请输入注释内容"
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
				comment_submit();
			    return false;
			}
		});
		function comment_submit() {
			var commentInfo= $("#form-comment").serialize();
			$.post('${rootPath}comment/add.do', commentInfo, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}customer/edit.html?id=${customer.customerId}";
				} 
				else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
	</script>
</body>
</html>
