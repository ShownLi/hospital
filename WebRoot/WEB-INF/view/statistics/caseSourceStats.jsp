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
					<i class="fa fa-user"></i>统计分析<span>询单来源状态统计</span>
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
						<h3 class="panel-title">询单来源状态统计</h3>
						<div class="row" style="margin-top: 20px">
						<form action="${rootPath }/statistics/savecasesource.do" method="post">
							<div class="form-group col-sm-10">
								<div class="col-sm-2">
									<div class="input-group input-datepicker" style="padding: 0;">
				                        <input readonly="readonly" id="searchStartDateTime" type="text" name="searchStartTime" class="form-control datepicker" value="${searchStartDateTime}" placeholder="请点击输入查询开始日期" autocomplete="on">
				                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                    </div>
				                </div>
			                    <div class="col-sm-2">
				                    <div class="input-group input-datepicker" style="padding: 0;">
				                        <input readonly="readonly" id="searchEndDateTime" type="text" name="searchEndTime" class="form-control datepicker" value="${searchEndDateTime}" placeholder="请点击输入查询截止日期" autocomplete="on">
				                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                    </div>
			                    </div>
							 

								</div>	
									<div class="col-sm-2">					 		                        		
									<input class="btn btn-primary" type="button" id="searchBtn" value="搜索"/>
									<input class="btn btn-primary" type="submit" value="导出"/>
								</div> 	
								</form>
							</div>

							</div>	
						</div>
					</div>
					<div class="panel-body">
						
						<div class="table-responsive">

							<table id="dataTable" class="table">
								<thead>
									<tr>
										<th>询单来源</th>
										<th>询单总数</th>
										<th>待处理订单数</th>									
										<th>沟通中点单数</th>
										<th>地接设计中订单数</th>
										<th>成行订单数</th>
										<th>未成行订单数</th>
										<th>无效订单数</th>
										<th>付款订单数</th>
										<th>成交率</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
				</div>
		<%@ include file="../assets/pages/rightpanel.jsp"%>
	</section>

	<%@ include file="../assets/pages/foot.jsp"%>

	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	<script src="${rootPath}assets/js/datepicker-zh-CN.js"></script>
	<script src="${rootPath}assets/js/datetimepicker-cn.js"></script>

	<script type="text/javascript">
	var searchFlag = false;
	var searchStatusCheck = "";
	
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
			var t = jQuery('#dataTable').DataTable({
				searching:false,
				pageLength: 10,
				processing: true,
				paging: false, // 禁止分页
				language: datatable_local_language, // my.js
				serverSide: true,
				ajax: {
					url: '${rootPath}statistics/caseSourceStats.do',
					data: function(data){
			 			var searchStartDateTime=$("#searchStartDateTime").val();
			 			var searchEndDateTime=$("#searchEndDateTime").val();
			 			var searchStatus = searchStatusCheck;
			 			searchStatusCheck = "";
			 			
			 			if(searchStartDateTime !=null && searchStartDateTime !=""){
			 				data.searchStartTime = searchStartDateTime;
			 			}
			 			if(searchEndDateTime !=null && searchEndDateTime !=""){
			 				data.searchEndTime = searchEndDateTime;
			 			}
					},
					
					dataFilter: function(data){
						var json = jQuery.parseJSON( data );
						json.recordsTotal = json.countTotal;
						json.recordsFiltered = json.countFiltered;
						json.data = json.data;
						
						if(searchFlag==false){
							$('#status0Count').html("待处理"+json.status0);

							$('#status1Count').html("客服沟通中"+json.status1);
					
							$('#status2Count').html("地接设计中"+json.status2);						
							
							$('#status3Count').html("成行"+json.status3);						
							
							$('#status4Count').html("未成行"+json.status4);						
							
							$('#status5Count').html("无效"+json.status5);												
							
							$('#status6Count').html("已付款"+json.status6);
						}
						
						return JSON.stringify( json );
					}
				},
				columnDefs: [		  
 					   {
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                /* 	if(full.sourceName="web_form"){
			                		sourceName = "网站表单"
			                	}
			                	else if(full.sourceName="mobile_form"){
			                		sourceName = "手机表单"
			                	}
			                	else if(full.sourceName="direct_form"){
			                		sourceName = "直发表单"
			                	}
			                	else if(full.sourceName="wechat_form"){
			                		sourceName = "微信表单"
			                	}
			                	else if(full.sourceName="web_service"){
			                		sourceName = "网站在线客服"
			                	}
			                	else if(full.sourceName="mobile_service"){
			                		sourceName = "手机在线客服"
			                	}
			                	else if(full.sourceName="wechat_service"){
			                		sourceName = "微信客服"
			                	}
			                	else if(full.sourceName="offline"){
			                		sourceName = "线下活动"
			                	}
			                	else if(full.sourceName="email"){
			                		sourceName = "邮件咨询"
			                	}
			                	else if(full.sourceName="customer"){
			                		sourceName = "老客人"
			                	}
			                	else if(full.sourceName="friends"){
			                		sourceName = "朋友介绍"
			                	}
			                	else if(full.sourceName="ctrip"){
			                		sourceName = "携程"
			                	}
			                	else if(full.sourceName=""){
			                		sourceName = "空"
			                	} 
			                	else if(full.sourceName=null){
			                		sourceName = "空"
			                	} 
			                */
			                    return "<div class='minw50'>" + full.sourceName + "</div>" 
			                },
			                targets: 0
						},
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.total + "</div>"
			                },
			                targets: 1
						},
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.status0 + "</div>"
			                },
			                targets: 2
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.status1 + "</div>"
			                },
			                targets: 3
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.status2 + "</div>"
			                },
			                targets: 4
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.status3 + "</div>"
			                },
			                targets: 5
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.status4 + "</div>"
			                },
			                targets: 6
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.status5 + "</div>"
			                },
			                targets: 7
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.status6 + "</div>"
			                },
			                targets: 8
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.rate + "</div>"
			                },
			                targets: 9
						},	  
						 
					    {
						    orderable: false,
						    searchable: false,
					        targets: [0]
					    }, 

					],
					columns: [
			            { data: "sourceName" },
			            { data:"total"},
			            { data: "status0" },
			            { data: "status1" },
			            { data: "status2" },
			            { data: "status3" },
			            { data: "status4" },
			            { data: "status5" },
			            { data: "status6" },
			            { data: "rate" }
			        ]
				});

			$('#searchBtn').on( 'click', function () {
				//$("input[name='status']:checked").val(null);
				searchStatusCheck = "";
				searchFlag = false;
		        t.draw();
		        $('input:radio:checked').attr('checked',false);
		    } );
			
			$('#status0').on('click',function(){
				searchStatusCheck = 0+" ";
				searchFlag = true;
				t.draw();
			});
			$('#status1').on('click',function(){
				searchStatusCheck = 1;
				searchFlag = true;
				t.draw();
			});
			$('#status2').on('click',function(){
				searchStatusCheck = 2;
				searchFlag = true;
				t.draw();
			});
			$('#status3').on('click',function(){
				searchStatusCheck = 3;
				searchFlag = true;
				t.draw();
			});
			$('#status4').on('click',function(){
				searchStatusCheck = 4;
				searchFlag = true;
				t.draw();
			});
			$('#status5').on('click',function(){
				searchStatusCheck = 5;
				searchFlag = true;
				t.draw();
			});
			$('#status6').on('click',function(){
				searchStatusCheck = 6;
				searchFlag = true;
				t.draw();
			});
		    
			$('#dataTable tbody').on( 'click', 'a.btn-success', function () {
		        var data = t.row($(this).parents('tr')).data();
		        edit($(this).attr('id'));
		    } );
			$('#dataTable tbody').on( 'click', 'a.btn-primary', function () {
		        var data = t.row($(this).parents('tr')).data();
		        handle($(this).attr('id'));
		    } );

	    
		// Select2
	    jQuery('select').select2({
	        minimumResultsForSearch: -1
	    });
	    
	    jQuery('select').removeClass('form-control');
		
		function edit(id) {
			window.parent.location = "${rootPath}case/edit.html?id="+id;
		}
		//处理询单
		function handle(id) {
			window.parent.location = "${rootPath}case/handle.html?id="+id;
		}
		
		function del(id) {
			 
			 $(".confirmDelModal .hiddenId").val("");
			 $(".confirmDelModal .hiddenId").val(Number(id));
		 	 $(".confirmDelModal").modal('show');
		}
		
		function doDel(id){
			$.ajax({
				url: "${rootPath}case/del.do?id=" + id, 
				success: function() {
					window.location.reload();
				},
				error: function() {
					alert(2);
				}
			});			
		}
		
  		function order_submit() {
			var order= $("#form-order").serialize();
			$.post('${rootPath}order/add.do', order, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}case/list.html";
				} else {
					$("#nextModal").modal('hide');
					$("#NoEmail").modal('show');
				}
			}, "JSON");
		}
  	  
  	  function delSubmit() {
    	  var f1=$("#form-del").serialize();
     	  try{
     		  $.post("${rootPath}case/del.do", f1, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}case/list.html";
				} 
				else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
     		  }
     	  catch(e) {
     		  alert(e);
     	  }
     	 alert("页面正在加载，请稍后...");
      }
	</script>
</body>
</html>
