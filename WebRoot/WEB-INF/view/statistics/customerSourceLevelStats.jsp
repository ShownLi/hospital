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
					<i class="fa fa-user"></i>统计分析<span>客人来源级别统计</span>
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
						<h3 class="panel-title">客人来源级别统计</h3>
						<div class="row" style="margin-top: 20px">
						</div>	
						</div>
					</div>
					<div class="panel-body">
						
						<div class="table-responsive">

							<table id="dataTable" class="table">
								<thead>
									<tr>
										<th>客人来源</th>
										<th>普通客人数量</th>
										<th>注册客人数量</th>									
										<th>下单客人数量</th>
										<th>成行客人数量</th>
										<th>成交比</th>
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
			var t = jQuery('#dataTable').DataTable({
				searching:false,
				pageLength: 10,
				processing: true,
				paging: false, // 禁止分页
				language: datatable_local_language, // my.js
				serverSide: true,
				ajax: {
					url: '${rootPath}statistics/customerSourceLevelStats.do',
					data: function(data){
			 			var searchStatus = searchStatusCheck;
			 			searchStatusCheck = "";
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
			                    return "<div class='minw50'>" + full.source + "</div>" 
			                },
			                targets: 0
						},
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.level0 + "</div>"
			                },
			                targets: 1
						},
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.level1 + "</div>"
			                },
			                targets: 2
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.level2 + "</div>"
			                },
			                targets: 3
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.level3 + "</div>"
			                },
			                targets: 4
						},	  
						{
			                orderable: false,
			                render: function ( data, type, full, meta ) {
			                    return "<div>" + full.rate + "</div>"
			                },
			                targets: 5
						},
					    {
						    orderable: false,
						    searchable: false,
					        targets: [0]
					    }, 

					],
					columns: [
			            { data: "source" },
			            { data:"level0"},
			            { data: "level1" },
			            { data: "level2" },
			            { data: "level3" },
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
