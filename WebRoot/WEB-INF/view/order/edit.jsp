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
					<i class="glyphicon glyphicon-briefcase"></i> 订单管理 <span>编辑订单</span>
				</h2>
				<!-- <div class="breadcrumb-wrapper">
					<span class="label">你在这里:</span>
					<ol class="breadcrumb">
						<li><a href="＃">CRM</a></li>
						<li><a href="${rootPath }order/list.html">订单管理</a></li>
						<li class="active">编辑订单</li>
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
          				<h4 class="panel-title">订单基本信息</h4>
          				<p>填写下表，完成订单信息修改。</p>
        			</div>
       		
         <form class="form-horizontal" id="form">
            <div class="panel-body panel-body-nopadding">
                <div class="section-block">
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">客人姓名</label>
                      <div class="col-sm-8">
                        <input type="text" name="customer_name" placeholder="客人姓名" class="form-control" readonly value="${order.customername}" />
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">地接社名称</label>
                      <div class="col-sm-8">
                        <input type="text" name="agency_name" placeholder="地接社名称" class="form-control" readonly value="${order.agencyname}" />
                      </div>
                    </div>              
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">销售姓名</label>
                      <div class="col-sm-8">
                        <input type="text" name="sales_name" placeholder="销售姓名" class="form-control" readonly value="${order.salesname}" />
                      </div>
                    </div>            
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">目的地</label>
                      <div class="col-sm-8">
                        <input type="text" name="destination" placeholder="目的地" class="form-control" readonly value="${order.destination}" />
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">预算</label>
                      <div class="col-sm-8">
                        <input type="text" name="budget" placeholder="预算" class="form-control" readonly value="${order.budget}" />
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">状态</label>
                      <div class="col-sm-8">
                        <input type="text" name="status" placeholder="状态" class="status-select fullwidth" value="${order.status}" />
                      </div>
                    </div>
                </div> 
                <div class="panel-footer align-center">
                    <button id="btn-chengxing" class="btn btn-primary">成行</button>&nbsp;
                    <button id="btn-weichengxing" class="btn btn-primary">未成行</button>&nbsp;
                    <button class="btn btn-primary">保存</button>&nbsp;
                    <button class="btn btn-default">取消</button>
					<input type="hidden" name="orderid" value="${order.orderid}" />	
        		    </div><!-- panel-footer -->
            </div>
         </form>   
      			</div><!-- panel -->

		      <!-- panel 是否成行 -->
      <div class="panel panel-default">
          <div class="panel-heading">

              <div class="panel-btns">
                  <a href="" class="minimize">&minus;</a>
              </div>
              <h4 class="panel-title">成行信息</h4>
          </div>
          <div class="panel-body panel-body-nopadding">
              <form id="form3" class="form-horizontal form3">
                  <div class="section-block">
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">成团日期</label>
                          <div class="col-sm-8 input-group input-datepicker">
                            <input type="text" name="grouptime" class="form-control datepicker" value="${order.grouptime}" placeholder="mm/dd/yyyy" autocomplete="off" />
                            <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">出发日期</label>
                          <div class="col-sm-8 input-group input-datepicker">
                            <input type="text" name="startdate" value="${order.startdate}" placeholder="出发日期" class="form-control datepicker" autocomplete="off" />
                            <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                        <label class="col-sm-4 control-label">返回日期</label>
                        <div class="col-sm-8 input-group input-datepicker">
                          <input type="text" name="enddate" value="${order.enddate}" placeholder="返回日期" class="form-control datepicker" autocomplete="off"/>
                          <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                        </div>
                      </div>
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">成团人数</label>
                          <div class="col-sm-8">
                            <input type="text" name="groupnumber" value="${order.groupnumber}" placeholder="成团人数" class="form-control" />
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">成团价格</label>
                          <div class="col-sm-8">
                            <input type="text" name="groupprice" value="${order.groupprice}" placeholder="成团价格" class="form-control"/>
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">货币种类</label>
                          <div class="col-sm-8">
                            <input type="text" name="currency" value="${order.currency}" placeholder="货币种类" class="form-control"/>
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">汇率</label>
                          <div class="col-sm-8">
                            <input type="text" name="exchangerate" value="${order.exchangerate}" placeholder="出发日期" class="form-control" />
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">人民币价格</label>
                          <div class="col-sm-8">
                            <input type="text" name="rmbprice" value="${order.rmbprice}" placeholder="人民币价格" class="form-control"/>
                          </div>
                      </div>
                  </div>
              </form> 
              <form id="form4" class="form-horizontal form4">
                  <div class="section-block">
                      <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">若未成行，原因是</label>
                        <div class="col-sm-8">
                          <input class="form-control reason-select" value="${order.reason}" placeholder="若未成行，原因是" />
                        </div>
                      </div>
                  </div><!-- panel-body -->
              </form> 
          </div>
      </div><!-- end of panel 是否成行 -->
      
            <!-- panel 沟通列表 -->
      <div class="panel panel-default">
          <div class="panel-heading">
          <div class="panel-btns">
              <a href="" class="minimize">&minus;</a>
          </div>
          <h4 class="panel-title">沟通记录 </h4>
          </div>
          <div class="panel-body">
              <div class="table-responsive">
                  <table id="dataTable-record" class="table table-communicate">
                    <thead>
                      <tr>
                        <th>序号</th>
                        <th>姓名</th>
                        <th>沟通内容</th>
                        <th>时间</th>
                      </tr>
                    </thead>
                    <tbody>
                    </tbody>
                  </table>
                </div>
                <!-- table-responsive -->
          </div>
      </div><!-- end of panel 沟通列表 -->
      
 		<!-- panel 注释记录 -->
      			<div class="panel panel-default">
          		<div class="panel-heading">
          		<div class="panel-btns">
              		<a href="" class="minimize">&minus;</a>
          		</div>
          			<h4 class="panel-title">注释记录 </h4>
          		</div>
          		<div class="panel-body">
	              	<table id="dataTable-note" class="table">
						<thead>
							<tr>
                    <th>序号</th>
                    <th>姓名</th>
                    <th>注释内容</th>
                    <th>时间</th>
							</tr>
						</thead>
					</table>
				          <!-- 添加注释 -->
	<form id="comment" class="form">
          <div class="form-group col-sm-6 col-sm-offset-3">
                <textarea name="content" class="form-control" rows="5"></textarea>
                <input  type="hidden" name="userid" value="${loginUser.userid}" />
                <input  type="hidden" name="username" value="${loginUser.name}" />
                <input  type="hidden" name="objectid" value="${order.orderid}" />
                <input  type="hidden" name="commenttype" value="order" />
          </div>
          <div class="form-group col-sm-12 align-center">
            <button class="btn btn-primary">添加注释</button>
          </div>
          </form>
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

<!-- cModal -->
<div class="cModal modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">         
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">请填写以下订单信息</div>
      </div>

      <div class="modal-body">
    		  <form class="form-horizontal" id="form1">
              <div class="section-block noline">
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团日期</label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input type="text" name="grouptime" class="form-control datepicker" value="${order.grouptime}" autocomplete="off">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">出发日期</label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input type="text" name="startdate" placeholder="出发日期" class="form-control datepicker" value="${order.startdate}"  autocomplete="off" />
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">返回日期</label>
                    <div class="col-sm-8 input-group input-datepicker">
                      <input type="text" name="enddate" placeholder="返回日期" class="form-control datepicker" value="${order.enddate}" autocomplete="off" />
                      <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                    </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团人数</label>
                      <div class="col-sm-8">
                        <input type="text" name="groupnumber" placeholder="成团人数" class="form-control" value="${order.groupnumber}" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团价格</label>
                      <div class="col-sm-8">
                        <input type="text" name="groupprice" placeholder="成团价格" class="form-control" value="${order.groupprice}" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">货币种类</label>
                      <div class="col-sm-8">
                        <input type="text" name="currency" placeholder="货币种类" class="form-control" value="${order.currency}" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">汇率</label>
                      <div class="col-sm-8">
                        <input type="text" name="exchangerate" placeholder="出发日期" class="form-control" value="${order.exchangerate}" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">人民币价格</label>
                      <div class="col-sm-8">
                        <input type="text" name="rmbprice" placeholder="人民币价格" class="form-control" value="${order.rmbprice}" />
                      </div>
                  </div>
                  <input type="hidden" name="orderid" value="${order.orderid}" />	
              </div>  
          </form>     
      </div>
      <div class="modal-footer align-center">
          <a class="submit btn btn-primary" >保存</a>
          <a class="cancel btn btn-primary" >取消</a>        
      </div>

    </div><!-- modal-content --> 
  </div><!-- modal-dialog -->
</div><!-- cModal -->

<!-- bModal -->
<div class="bModal modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">请填写以下订单信息</div>
      </div>
      <div class="modal-body">
          <form class="form-horizontal" id="form2">
              <div class="section-block noline">
                  <div class="form-group col-sm-12">
                    <label class="col-sm-4 control-label">若未成行，原因是</label>
                    <div class="col-sm-8">
                      <input class="form-control reason-select" name="reason" placeholder="若未成行，原因是" />
                      <input type="hidden" name="orderid" value="${order.orderid}" />	
                    </div>
                  </div>
              </div><!-- bModal-body -->
          </form>
      </div>
      <div class="modal-footer align-center">
          <a class="submit btn btn-primary" >保存</a>
          <a class="cancel btn btn-primary" >取消</a>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- bmodal -->

	<%@ include file="../assets/pages/foot.jsp"%>
  <script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	

<script type="text/javascript">
	var s = ${status};
	
	$(".status-select").select2({
		data: s
	})

	if("${order.status}"==1){$(".form3").show();}
	if("${order.status}"==2){$(".form4").show();}		      
	
	jQuery(document).ready(function() {
		jQuery("#form1").validate({
	        rules: {
		          grouptime: "date",
		          startdate: "date",
		          enddate: "date",
		          groupnumber: "number",
		          groupprice: "number",
		          exchangerate: "number",
		          rmbprice: "number",
		        },
		        messages: {
		          grouptime: "请输入正确的日期格式 mm/dd/yyyy",
		          startdate: "请输入正确的日期格式 mm/dd/yyyy",
		          enddate: "请输入正确的日期格式 mm/dd/yyyy",
		          groupnumber: "请输入一个数字",
		          groupprice: "请输入一个数字",
		          exchangerate: "请输入一个数字",
		          rmbprice: "请输入一个数字",

		        }
		});
		$(".nav-parent").eq(1).addClass("nav-active");
    $(".nav-parent").eq(1).find(".children").show();
      		
		jQuery("#form").validate({
				
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
		
		jQuery("#comment").validate({
			rule:{
				content: "required"
			},
			
			message:{
				content:"请输入注释内容"
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
			
	});
	
	var t = jQuery('#dataTable-note').DataTable({
		pageLength: 10,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		ajax: {
			url: '${rootPath}comment/list.do?type=order&id=${order.orderid}',
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
	    
	var r = jQuery('#dataTable-record').DataTable({
		pageLength: 10,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		ajax: {
			url: '${rootPath}record/list.do?orderid=${order.orderid}',
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
	  			    { data: "orderrecordid" },
	  			    { data: "sendername" },
	  			    { data: "content" },
	  			    { data: "creattime" }
	    ]
		});
	
		// Select2
	jQuery('select').select2({
		minimumResultsForSearch: -1
		});
	    
	jQuery('select').removeClass('form-control');
	
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
	function form_submit() {
		var f = $("#form").serialize();
		$.post('${rootPath}order/edit.do', f, function(result) {
			var rmsg = result.msg;
			if (result.success) {
				window.parent.location = "${rootPath}order/list.html";
			} 
			else {
				$("#msgModal").modal('show');
			}
		}, "JSON");
	}
	$("#btn-chengxing").click(function(){
		$(".cModal").modal('show');
	  return false;
	});
    $(".cModal .submit").click(function(){
    	form1_submit();
      });
    $(".bModal .submit").click(function(){
    	form2_submit();
      });
    $("#btn-weichengxing").click(function(){
        $(".bModal").modal('show');
        return false;
    });
    $(".cModal .cancel").click(function(){
    	$(".cModal").modal("hide");
	});
    $(".bModal .cancel").click(function(){
        $(".bModal").modal("hide");
   	});
	// Date Picker
	jQuery(".datepicker").datepicker({
		  dateFormat: "yy-mm-dd"
  });
		
	function form1_submit() {
		var f = $("#form1").serialize();
		$.post('${rootPath}order/edit.do', f, function(result) {
			var rmsg = result.msg;
			if (result.success) {
				window.parent.location = "${rootPath}order/edit.html?id=${order.orderid}";
			} 
			else {
				$("#msgModal").modal('show');
			}
		}, "JSON");
	}
	function form2_submit() {
		var f = $("#form2").serialize();
		$.post('${rootPath}order/edit.do', f, function(result) {
			var rmsg = result.msg;
			if (result.success) {
				window.parent.location = "${rootPath}order/edit.html?id=${order.orderid}";
			} 
			else {
				$("#msgModal").modal('show');
			}
		}, "JSON");
	}
	function comment_submit() {
		var f = $("#comment").serialize();
		$.post('${rootPath}comment/add.do', f, function(result) {
			var rmsg = result.msg;
			if (result.success) {
				window.parent.location = "${rootPath}order/edit.html?id=${order.orderid}";
			} 
			else {
				$("#msgModal").modal('show');
			}
		}, "JSON");
	}
</script>

</body>
</html>
