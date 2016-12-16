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
       		
         <form class="form-horizontal" id="baseForm">
            <div class="panel-body panel-body-nopadding">
                <div class="section-block">
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">客人姓名</label>
                      <div class="col-sm-8">
                        <input type="text" name="customerName" placeholder="客人姓名" class="form-control" readonly value="${order.customerName}" />
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">地接社名称</label>
                      <div class="col-sm-8">
                        <input type="text" name="agencyName" placeholder="地接社名称" class="form-control" readonly value="${order.agencyName}" />
                      </div>
                    </div>              
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">销售姓名</label>
                      <div class="col-sm-8">
                        <input type="text" name="salesName" placeholder="销售姓名" class="form-control" readonly value="${order.salesName}" />
                      </div>
                    </div>            
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">目的地</label>
                      <div class="col-sm-8">
                        <select id="destination" name="destination" class="contact-select-country fullwidth" multiple="multiple"></select>
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">预算(元/人)</label>
                      <div class="col-sm-8">
                        <input type="text" name="budget" placeholder="预算" class="form-control" readonly value="${order.budget}" />
                        <span style="position: absolute; right: 15px; top: 10px;">￥/人</span>
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">状态</label>
                      <div class="col-sm-8">
                        <input type="text" name="status" placeholder="状态" class="status-select fullwidth" readonly value="${order.status}" />
                      </div>
                    </div>
                </div> 
                <div class="panel-footer align-center">
	                <input class="btn btn-primary" id="btn-baseDeal" type="submit" value="成行"/>&nbsp;
					<input class="btn btn-primary" id="btn-baseNoDeal" type="button" value="未成行"/>&nbsp;
					<input class="btn btn-default" id="btn-back" type="button" value="返回"/>
					<input type="hidden" name="orderId" value="${order.orderId}" />	
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
              <form id="form-updateDeal" class="form-horizontal form-updateDeal" style="display:none">
                  <div class="section-block">
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">成团日期</label>
                          <div class="col-sm-8 input-group input-datepicker">
                            <input type="text" id="groupTime" name="groupTime" class="form-control datepicker" value="${order.groupTime}" placeholder="mm/dd/yyyy" autocomplete="off" />
                            <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">出发日期</label>
                          <div class="col-sm-8 input-group input-datepicker">
                            <input type="text" id="startDate" name="startDate" value="${order.startDate}" placeholder="出发日期" class="form-control datepicker" autocomplete="off" />
                            <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                        <label class="col-sm-4 control-label">返回日期</label>
                        <div class="col-sm-8 input-group input-datepicker">
                          <input type="text" id="endDate" name="endDate" value="${order.endDate}" placeholder="返回日期" class="form-control datepicker" autocomplete="off"/>
                          <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                        </div>
                      </div>
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">成团人数</label>
                          <div class="col-sm-8">
                            <input type="text" name="groupNumber" value="${order.groupNumber}" placeholder="成团人数" class="form-control" />
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">成团价格</label>
                          <div class="col-sm-8">
                            <input type="text" name="groupPrice" value="${order.groupPrice}" placeholder="成团价格" class="form-control"/>
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
                            <input type="text" name="exchangeRate" value="${order.exchangeRate}" placeholder="汇率" class="form-control" />
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">人民币价格</label>
                          <div class="col-sm-8">
                            <input type="text" name="rmbPrice" value="${order.rmbPrice}" placeholder="人民币价格" class="form-control"/>
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                      <div class="col-sm-6"></div>
                      		&nbsp;<input id="btn-updateDealModify" class="btn btn-primary" type="button" value="更改"/>&nbsp;
                      	</div>
                  </div>
                  <input type="hidden" name="orderId" value="${order.orderId}" />
                  <input type="hidden" name="caseId" value="${order.caseId}" />	
                  <input type="hidden" name="customerId" value="${order.customerId}" />	
              </form> 
              <form id="form-updateNoDeal" class="form-horizontal" style="display:none">
                  <div class="section-block">
                      <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">未成行原因</label>
                        <div class="col-sm-6">
                          <input class="reason-select fullwidth" name="reason" value="${order.reason}" placeholder="若未成行，原因是" />
                        </div>
                    	<input id="btn-updateNoDealModify" class="btn btn-primary" type="button" value="更改">&nbsp;
                      </div>
                  </div><!-- panel-body -->
                      <input type="hidden" name="orderId" value="${order.orderId}" />	
                      <input type="hidden" name="caseId" value="${order.caseId}" />
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
	<form id="form-comment" class="form">
          <div class="form-group col-sm-6 col-sm-offset-3">
                <textarea name="content" class="form-control" rows="5"></textarea>
                <input  type="hidden" name="userId" value="${loginUser.userId}" />
                <input  type="hidden" name="userName" value="${loginUser.name}" />
                <input  type="hidden" name="objectId" value="${order.orderId}" />
                <input  type="hidden" name="commentType" value="order" />
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

<!-- dealModal -->
<div class="dealModal modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">         
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">请填写以下订单信息</div>
      </div>

          <form class="form-horizontal" id="form-deal">
      <div class="modal-body">
              <div class="section-block noline">
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团日期<span class="asterisk">*</span></label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input type="text" name="groupTime" class="form-control datepicker" autocomplete="off" placeholder="成团日期">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">出发日期<span class="asterisk">*</span></label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input type="text" name="startDate" placeholder="出发日期" class="form-control datepicker" autocomplete="off" />
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">返回日期<span class="asterisk">*</span></label>
                    <div class="col-sm-8 input-group input-datepicker">
                      <input type="text" name="endDate" placeholder="返回日期" class="form-control datepicker" autocomplete="off" />
                      <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                    </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团人数<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="groupNumber" placeholder="成团人数" class="form-control"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团价格<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="groupPrice" placeholder="成团价格" class="form-control" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">货币种类<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="currency" placeholder="货币种类" class="currency-select fullwidth"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">汇率<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="exchangeRate" placeholder="汇率" class="form-control" value="" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">人民币价格<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="rmbPrice" placeholder="人民币价格" class="form-control"/>
                      </div>
                  </div>
                  <input type="hidden" name="orderId" value="${order.orderId}" />
                  <input type="hidden" name="caseId" value="${order.caseId}" />	
                  <input type="hidden" name="customerId" value="${order.customerId}" />	
              </div>  
          
      </div>
      <div class="modal-footer align-center">
          <button class="submit btn btn-primary">保存</button>
          <a class="cancel btn btn-primary" >取消</a>        
      </div>
      </form>     

    </div><!-- modal-content --> 
  </div><!-- modal-dialog -->
</div><!-- dealModal -->

<!-- noDealModal -->
<div class="noDealModal modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">请填写以下订单信息</div>
      </div>
      <form class="form-horizontal" id="form-noDeal">
          <div class="modal-body">     
              <div class="section-block noline">
                  <div class="form-group col-sm-12">
                    <label class="col-sm-4 control-label">未成行原因</label>
                    <div class="col-sm-8">
                      <input class="reason-select fullwidth" name="reason" placeholder="若未成行，原因是" />
                      <input type="hidden" name="orderId" value="${order.orderId}" />	
                      <input type="hidden" name="caseId" value="${order.caseId}" />		                     
                      <input type="hidden" name="status" value="3" />

                    </div>
                  </div>
              </div><!-- noDealModal-body -->
          </div>
          <div class="modal-footer align-center">
               <!-- <button class="submit btn btn-primary">保存</button>-->
            <button class="btn btn-primary" >保存</button> 

            <!--   <button class="btn btn-primary" onclick="form2_submit()">保存</button> -->
              <a class="cancel btn btn-primary" >取消</a>
          </div>
      </form>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- bmodal -->

	<%@ include file="../assets/pages/foot.jsp"%>
  <script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	

<script type="text/javascript">
	var orderStatus = ${orderStatus};
	var country = ${country};
	var reason = ${reason};
	var currency=${currency};

 	$(".currency-select").select2({
		data: currency
	})  
	
	 $(".contact-select-country").select2({
    	placeholder: '可多选',
    	minimumResultsForSearch: Infinity,
    	data: country
     });
    $(".contact-select-country").val('${order.destination}'.split(",")).trigger("change");
	
 	$(".status-select").select2({
		data: orderStatus
	}) 

	$(".destination-select").select2({
        placeholder: '国家',
        data: country
    });
    
    $(".reason-select").select2({
    	placeholder:"未成行原因",
    	data:reason
    })
    
	if("${order.status}"==2){
 	  $("#form-updateDeal").show();
      $("#btn-baseDeal").attr("disabled",true);
      $("#btn-baseNoDeal").attr("disabled",true);
 	 }
    
	if("${order.status}"==3){
      $("#form-updateNoDeal").show();
      $("#btn-baseDeal").attr("disabled",true);
      $("#btn-baseNoDeal").attr("disabled",true);
  	}		
	
	jQuery(document).ready(function() {
		jQuery("#form-deal").validate({
	        rules: {
		        groupTime: {
                required: true,
                date: true
              },
		        startDate: {
                required: true,
                date: true
              },
		        endDate: {
                required: true,
                date: true
              },
		        groupNumber: {
                required: true,
                number: true
              },
		        groupPrice: {
                required: true,
                number: true
              },
                currency: {
                required: true,
              },
		        exchangeRate: {
                required: true,
                number: true
              },
		        rmbPrice: {
                required: true,
                number: true
              },
		      },
		        messages: {
		        groupTime: {
                required: "请输入成团日期",
                date: "日期格式 mm/dd/yyyy"
              },
		          startDate: {
                required: "请输入出发日期",
                date: "日期格式 mm/dd/yyyy"
              },
		        endDate: {
                required: "请输入返回日期",
                date: "日期格式 mm/dd/yyyy"
              },
		          groupNumber: "请输入一个数字",
		          groupPrice: "请输入一个数字",
              	  currency: "请选择货币种类",
		          exchangeRate: "请输入一个数字",
		          rmbPrice: "请输入一个数字",

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
              deal_submit();
              return false;
          }
		});
		
		jQuery("#form-noDeal").validate({
		        rules: {
			        reason: {
			        	required: true,
			        },	              	
				},				
		     	 messages: {
		            reason: "请选择一个原因",
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
		              noDeal_submit();
		              return false;
		          } 
	        });
		
		$(".nav-parent").eq(1).addClass("nav-active");
   	    $(".nav-parent").eq(1).find(".children").show();
      		
		/* jQuery("#baseForm").validate({
				
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
				baseForm_submit();
			    return false;
			}
		}); */
		
		/* function baseForm_submit() {
			var f = $("#baseForm").serialize();
			$.post('${rootPath}order/edit.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}order/list.html";
				} 
				else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
        } */
		
		jQuery("#form-comment").validate({
			rules:{
				content: "required"
			},
			messages:{
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
	//注释分页
	var t = jQuery('#dataTable-note').DataTable({
		searching:false,
		paging:false,
		/* pageLength: 10, */
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		ajax: {
			url: '${rootPath}comment/list.do?type=order&id=${order.orderId}',
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
	    
	var r = jQuery('#dataTable-record').DataTable({
		searching:false,
		pageLength: 10,
		processing: true,
		language: datatable_local_language, // my.js
		serverSide: true,
		ajax: {
			url: '${rootPath}record/list.do?orderId=${order.orderId}',
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
	  			    { data: "orderRecordId" },
	  			    { data: "senderName" },
	  			    { data: "content" },
	  			    { data: "creatTime" }
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

	$("#btn-baseDeal").click(function(){
		$(".dealModal").modal('show');
	  return false;
	});
	$("#btn-updateDealModify").click(function(){
		updateDeal_submit();
	});
/*      $(".dealModal .submit").click(function(){
     		deal_submit();
       }); */
     $(".noDealModal .submit").click(function(){ 	
    		noDeal_submit();
       }); 
    $("#btn-baseNoDeal").click(function(){
        $(".noDealModal").modal('show');
        return false;
    });
    $("#btn-updateNoDealModify").click(function(){
    	updateNoDeal_submit();
    });
    $(".dealModal .cancel").click(function(){
    	$(".dealModal").modal("hide");
	});
    $(".noDealModal .cancel").click(function(){
        $(".noDealModal").modal("hide");
   	});

    
    //订单返回
    $("#btn-back").click( function () {
    	 history.go(-1);
    	/* alert("正在返回，请稍后..."); */
	}); 
	
    // Date Picker
	jQuery(".datepicker").datepicker({
		  dateFormat: "yy-mm-dd"
  });
		
	function deal_submit() {
		var f = $("#form-deal").serialize();
		$.post('${rootPath}order/orderDeal.do', f, function(result) {
			var rmsg = result.msg;
			if (result.success) {
				window.parent.location = "${rootPath}order/edit.html?id=${order.orderId}";
			} 
			else {
				$("#msgModal").modal('show');
			}
		}, "JSON");
	}

	function noDeal_submit() {
		var f1 = $("#form-noDeal").serialize();
		try{
 			$.post('${rootPath}order/orderNoDeal.do?rand='+Math.random(), f1, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					//alert("${rootPath}order/edit.html?id=${order.orderId}");
					window.location.href = "${rootPath}order/edit.html?id=${order.orderId}";
					
					//window.location.assign("${rootPath}order/edit.html?id=${order.orderId}");
				} 
				else {
					$("#msgModal").modal('show');
				}
			}, "JSON"); 

			
		} catch(e){
			alert(e);
		};
	/* 	alert("页面正在加载，请稍后..."); */
	}
	
	function updateDeal_submit() {
		var f = $("#form-updateDeal").serialize();
		$.post('${rootPath}order/updateDeal.do', f, function(result) {;
			if (result.success) {
				window.location.href = "${rootPath}order/edit.html?id=${order.orderId}";
			} 
			else {
				$("#msgModal").modal('show');
			}
		}, "JSON");
	/* 	alert(""); */
	}
	function updateNoDeal_submit() {
		var f = $("#form-updateNoDeal").serialize();
		$.post('${rootPath}order/orderNoDeal.do', f, function(result) {
			if (result.success) {
				window.location.href = "${rootPath}order/edit.html?id=${order.orderId}";
			} 
			else {
				$("#msgModal").modal('show');
			}
		}, "JSON");		
		 /* alert(""); */
	}
	function comment_submit() {
		var f = $("#form-comment").serialize();
		$.post('${rootPath}comment/add.do', f, function(result) {
			var rmsg = result.msg;
			if (result.success) {
				window.parent.location = "${rootPath}order/edit.html?id=${order.orderId}";
			} 
			else {
				$("#msgModal").modal('show');
			}
		}, "JSON");
 
	}
	//成团日期格式转换
	var groupTime = $("#groupTime").val();	
	//alert(groupTime)
  if(groupTime !== ""){
      var dateformat = new Date(groupTime).toISOString("yyyy-MM-dd hh:mm:ss.S").substring(0,10);
      $("#groupTime").val(dateformat)
  }

	//出发日期格式转换
	var startDate = $("#startDate").val();	
  if(startDate !== ""){
    	var dateformat = new Date(startDate).toISOString("yyyy-MM-dd hh:mm:ss.S").substring(0,10);
    	$("#startDate").val(dateformat)
  }
	
	//返回日期格式转换
	var endDate = $("#endDate").val();	
  if(endDate !== ""){
      var dateformat = new Date(endDate).toISOString("yyyy-MM-dd hh:mm:ss.S").substring(0,10);
      $("#endDate").val(dateformat)
  }
	
</script>

</body>
</html>
