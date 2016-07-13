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
				<!-- <div class="breadcrumb-wrapper">
					<span class="label">你在这里:</span>
					<ol class="breadcrumb">
						<li><a href="＃">CRM</a></li>
						<li><a href="${rootPath }customer/list.html">客人管理</a></li>
						<li class="active">编辑客人</li>
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
          <h4 class="panel-title">客人基本信息</h4>
          <p>填写下表，完成客人信息修改。</p>
        </div>
        <form class="form-horizontal form-bordered" id="form">
        <div class="panel-body panel-body-nopadding">
          
					<div class="section-block">
		        		<h5 class="section-title">客人基本信息</h5>
			            <div class="form-group col-sm-4">
							<label class="col-sm-3 control-label">中文名<span class="asterisk">*</span></label>
							<div class="col-sm-9">
							    <input type="text" name="zname" placeholder="中文名" class="form-control" value="${customer.zname}"/>
							</div>
			            </div>
			            <div class="form-group col-sm-4">
							<label class="col-sm-3 control-label">英文名</label>
							<div class="col-sm-9">
							    <input type="text" name="ename" placeholder="英文名" class="form-control" value="${customer.ename}"/>
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
							    <input type="text" name="agegroup" placeholder="年龄段" class="agegroup-select fullwidth" value="${customer.agegroup}"/>
							</div>
			            </div>
			            <div class="form-group col-sm-4">
							<label class="col-sm-3 control-label">客人级别</label>
							<div class="col-sm-9">
							    <input type="text" name="level" placeholder="客人级别" class="level-select fullwidth" value="${customer.level}" disabled />
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
			                <label class="col-sm-3 control-label" >推广渠道 </label>
			                <div class="col-sm-9">
			               	 	<input type="text" name="promote" placeholder="推广渠道" class="promote-select fullwidth" value="${customer.promote}"/>
			                </div>
			            </div>
			        </div>  
         
        </div><!-- panel-body -->
        
        <div class="panel-footer align-center">
			<button class="btn btn-primary">保存</button>&nbsp;
			<button class="btn btn-default" id="btn-back">取消</button>
			<input type="hidden" name="customerid" value="${customer.customerid }" />
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
								<th>序号</th>
								<th>称呼</th>
								<th>预算</th>
								<th>目的地</th>
								<th>询单来源</th>
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
			    <a class="btn btn-primary" href="${rootPath}case/addfromcustomer.html?customerid=${customer.customerid}">添加询单</a>
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
		              	<table id="dataTable-note" class="table">
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
					<form id="comment" class="form">
						<div class="form-group col-sm-6 col-sm-offset-3">
						    <textarea name="content" class="form-control" rows="5"></textarea>
						    <input  type="hidden" name="userid" value="${loginUser.userid}" />
						    <input  type="hidden" name="username" value="${loginUser.name}" />
						    <input  type="hidden" name="objectid" value="${customer.customerid}" />
						    <input  type="hidden" name="commenttype" value="customer" />
						</div>
						<div class="form-group col-sm-12 align-center">
							<button class="btn btn-primary">添加注释</button>
						</div>
		            </form>
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



	<%@ include file="../assets/pages/foot.jsp"%>
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/datepicker-zh-CN.js"></script>
	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript">
	var l = ${level};
	var p = ${promote};
	var a = ${agegroup};
	$(".promote-select").select2({
		placeholder: '选择一个推广渠道',
	  	data: p
	});
	$(".agegroup-select").select2({
		placeholder: '选择一个年龄段',
	  	data: a
	});
	$(".level-select").select2({
	  	data: l
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
      	
			var t = jQuery('#dataTable-case').DataTable({
				pageLength: 10,
				processing: true,
				language: datatable_local_language, // my.js
				serverSide: true,
				ajax: {
					url: '${rootPath}case/listfromcustomer.do?customerid=${customer.customerid}',
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
						data: "caseid",
						//defaultContent: '<a class="btn btn-success btn-xs"><span class="fa fa-edit"></span> 编辑</a>&nbsp;<a class="btn btn-danger btn-xs"><span class="fa fa-minus-circle"></span> 删除</a>',
						orderable: false,
						render: function ( data, type, full, meta ) {
						  return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>&nbsp;<a class="btn btn-danger btn-xs" id="'+data+'"><span class="fa fa-minus-circle"></span> 删除</a>&nbsp;&nbsp;&nbsp;<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-minus-circle"></span> 生成订单</a>';
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
		            { data: "caseid" },
		            { data: "customername" },
		            { data: "budget" },
		            { data: "destination" },
		            { data: "source" },
		            { data: "status" }
		        ]
			});
			
			// Select2
		    jQuery('select').select2({
		        minimumResultsForSearch: -1
		    });
		    jQuery('select').removeClass('form-control');

			$('#dataTable-case tbody').on( 'click', 'a.btn-success', function () {
		        var data = t.row($(this).parents('tr')).data();
		        //alert($(this).attr('id'));
		        edit($(this).attr('id'));
		    });

			$('#dataTable-case tbody').on( 'click', 'a.btn-danger', function () {
		        var data = t.row($(this).parents('tr')).data();
		        //alert($(this).attr('id'));
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

		jQuery("#form").validate({
			rules: {
				zname: "required",
				qq: "number",
				email: "email",
				birthday: "date"
			},
			messages: {
				zname: "请输入中文名",
				qq: "请输入有效的QQ账号",
				email: "请输入有效的邮箱",
				birthday: "请输入正确的日期"
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

			      	form_submit();
			      	return false;
			    }
		    }
			 
		});
		
		$("#btn-back").click( function () {
			history.go(-1);
	    } ); 
		
		//生日格式转换
		var date = $("#birthday").val();	
		var dateformat = new Date(date).toISOString("yyyy-MM-dd hh:mm:ss.S").substring(0,10);
		//console.log(dateformat);
		$("#birthday").val(dateformat)
		
		// 手机，邮箱，微信，QQ，输入一个以后移除错误提示
		$(".contact-field").find("input").blur(function(){
			if($(this).val() !== ""){
				$(".contact-field").removeClass("has-error");
			}
		});
		
	});
//			      
		function form_submit() {
			var f = $("#form").serialize();
			$.post('${rootPath}customer/edit.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}customer/list.html";
				} else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
		
		var t = jQuery('#dataTable-note').DataTable({
			pageLength: 10,
			processing: true,
			language: datatable_local_language, // my.js
			serverSide: true,
			ajax: {
				url: '${rootPath}comment/list.do?type=customer&id=${customer.customerid}',
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
							  data: "creattime",
							  render: function ( data, type, full, meta ) {
								  var creattime = new Date(data.time);
			                    return creattime.format("yyyy/MM/dd");
			                },
			                targets: 3
						  },		 

				],
			columns: [
		  			    { data: "commentid" },
		  			    { data: "username" },
		  			    { data: "content" },
		  			    { data: "creattime" }
		    ]
			});
		jQuery("#comment").validate({

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
			var f = $("#comment").serialize();
			$.post('${rootPath}comment/add.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}customer/edit.html?id=${customer.customerid}";
				} 
				else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
	</script>


</body>
</html>
