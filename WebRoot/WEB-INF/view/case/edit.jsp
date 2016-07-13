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
					<i class="fa fa-user"></i> 询单管理 <span>编辑询单</span>
				</h2>
				<!-- <div class="breadcrumb-wrapper">
					<span class="label">你在这里:</span>
					<ol class="breadcrumb">
						<li><a href="＃">CRM</a></li>
						<li><a href="${rootPath }user/list.html">询单管理</a></li>
						<li class="active">编辑询单</li>
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
          <h4 class="panel-title">询单基本信息</h4>
          <p>填写下表，完成询单编辑。</p>
        </div>
        <form class="form-horizontal" id="form">
        <div class="panel-body panel-body-nopadding">
            <div class="section-block">
            	<div class="form-group col-sm-4">
            	<label class="col-sm-4 control-label">所属客人</label>
                	<div class="col-sm-8">
                    	<input type="text" name="customerid" placeholder="所属客人" class="customer-select fullwidth" value="${crmcase.customerid}" />
                    </div>
            	</div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">销售姓名</label>
                  <div class="col-sm-8">
                    <input type="text" name="salesname" placeholder="销售姓名" class="sales-select fullwidth" readonly value="${crmcase.salesname}" />
                  </div>
                </div>
               	<div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">状态</label>
                  <div class="col-sm-8">
                    <input type="text" name="status" placeholder="状态" class="status-select fullwidth" readonly value="${crmcase.status}" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">目的地</label>
                  <div class="col-sm-8">
                    <input type="text" name="destination" class="form-control" readonly value="${crmcase.destination}" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">行程</label>
                  <div class="col-sm-8">
                    <input type="text" name="route" placeholder="行程" class="form-control" readonly value="${crmcase.route}" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">表单类型</label>
                  <div class="col-sm-8">
                    <input type="text" name="submit_type" class="form-control" readonly value="${crmcase.submittype}" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">询单来源</label>
                  <div class="col-sm-8">
                    <input type="text" name="source" class="source-select fullwidth" value="${crmcase.source}" />
                  </div>
                </div>

                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">沟通语言</label>
                  <div class="col-sm-8">
                    <input type="text" name="preferlanguage" class="language-select fullwidth" value="${crmcase.preferlanguage}"/>
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">希望联系方式</label>
                  <div class="col-sm-8">
                    <input type="text" name="contacttype" class="contact-select fullwidth" value="${crmcase.contacttype}" />
                  </div>
                </div>                
            </div>
            <div class="section-block">
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">与谁同行</label>
                  <div class="col-sm-8">
                    <input type="text" name="withwho" class="withwho-select fullwidth" value="${crmcase.withwho}" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">成人</label>
                  <div class="col-sm-8">
                    <input type="text" name="adult" placeholder="成人" class="form-control" value="${crmcase.adult}" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-6 control-label">儿童（12岁以下）</label>
                  <div class="col-sm-6">
                    <input type="text" name="children" placeholder="儿童（12岁以下）" class="form-control" value="${crmcase.children}" />
                  </div>
                </div>
            </div>
            <div class="section-block">
                   	<div class="form-group col-sm-4">
        	              <label class="col-sm-4 control-label">出发时间 <span class="asterisk">&nbsp;</span></label>
        	              <div class="col-sm-8">
        	                <div class="rdio rdio-primary rdio-inline">
        	                  <input type="radio" id="yes" value="1" name="starttime"/>
        	                  <label for="yes">已确定</label>
        	                </div><!-- rdio -->
        	                <div class="rdio rdio-primary rdio-inline">
        	                  <input type="radio" id="no" value="0" name="starttime" />
        	                  <label for="no">未确定</label>
        	                </div><!-- rdio -->
        	                <label class="error" for="starttime"></label>
        	              </div>
                    </div>
                <div class="form-group col-sm-4 d1">
                  <label class="col-sm-4 control-label">大约时间</label>
                  <div class="col-sm-8 input-group input-datepicker">
                    <input type="text" id="startmonth" name="startmonth" class="form-control datepicker" placeholder="yyyy/mm/dd" value="${crmcase.startmonth}" autocomplete="off">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                  </div>
                </div>
                <div class="form-group col-sm-4 d1">
                  <label class="col-sm-4 control-label">大约天数</label>
                  <div class="col-sm-8">
                    <input type="text" name="during" placeholder="大约天数" class="form-control" value="${crmcase.during}" />
                  </div>
                </div>
                <div class="form-group col-sm-4 d2">
                  <label class="col-sm-4 control-label">出发日期</label>
                  <div class="col-sm-8 input-group input-datepicker">
                    <input type="text" id="startdate" name="startdate" class="form-control datepicker" placeholder="yyyy/mm/dd" value="${crmcase.startdate}" autocomplete="off">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                  </div>
                </div>
                <div class="form-group col-sm-4 d2">
                  <label class="col-sm-4 control-label">返回日期</label>
                  <div class="col-sm-8 input-group input-datepicker">
                    <input type="text" id="enddate" name="enddate" class="form-control datepicker" placeholder="yyyy/mm/dd" value="${crmcase.enddate}" autocomplete="off">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                  </div>
                </div>
            </div>
            <div class="section-block">
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">客人的要求</label>
                  <div class="col-sm-8">
                    <textarea id="requirement" name="requirement" class="form-control" placeholder="客人的要求" rows="5"></textarea>
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">关于住宿</label>
                  <div class="col-sm-8">
                    <input type="text" name="hotel" class="hotel-select fullwidth" value="${crmcase.hotel}" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">关于用餐</label>
                  <div class="col-sm-8">
                    <input type="text" name="meals" class="meals-select fullwidth" value="${crmcase.meals}" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-5 control-label">关于司机和导游</label>
                  <div class="col-sm-7">
                    <input type="text" name="guide" class="guide-select fullwidth" value="${crmcase.guide}" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">客人的预算</label>
                  <div class="col-sm-8">
                    <input type="text" name="budget" placeholder="客人的预算" class="form-control" value="${crmcase.budget}" />
                  </div>
                </div>
            </div>
        </div><!-- panel-body -->
        
        <div class="panel-footer align-center">
            <button id="addorder" class="btn btn-primary">添加订单</button>&nbsp;
            <button id="submit" class="btn btn-primary">保存</button>&nbsp;
            <button class="btn btn-primary">无效</button>
		    </div><!-- panel-footer -->
     </form>   
      </div><!-- panel -->

      <!-- panel 订单列表  -->
    <div class="panel panel-default">
      <div class="panel-heading">
        <div class="panel-btns">
          <a href="" class="minimize">&minus;</a>
        </div>
        <h4 class="panel-title">订单列表</h4>
      </div>
      <div class="panel-body panel-body-nopadding">
          <div class="table-responsive">

              <table id="dataTable-order" class="table">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>客人姓名</th>
                    <th>地接社</th>
                    <th>销售姓名</th>
                    <th>目的地</th>
                    <th>预算</th>
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
    </div><!-- end of panel 询单  -->

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

    <!-- panel 注释 -->
    <div class="panel panel-default">
        <div class="panel-heading">
        <div class="panel-btns">
            <a href="" class="minimize">&minus;</a>
        </div>
        <h4 class="panel-title">注释列表 </h4>
        </div>
        <div class="panel-body">
            <div class="table-responsive">
              <table id="dataTable-note" class="table">
                <thead>
                  <tr>
                    <th>序号</th>
                    <th>姓名</th>
                    <th>注释内容</th>
                    <th>时间</th>
                  </tr>
                </thead>
                <tbody>
                </tbody>
              </table>
          </div>
          <!-- 添加注释 -->
    	    <form id="comment" class="form">
              <div class="form-group col-sm-6 col-sm-offset-3">
                    <textarea name="content" class="form-control" rows="5"></textarea>
                    <input  type="hidden" name="userid" value="${loginUser.userid}" />
                    <input  type="hidden" name="username" value="${loginUser.name}" />
                    <input  type="hidden" name="objectid" value="${crmcase.caseid}" />
                    <input  type="hidden" name="commenttype" value="case" />
              </div>
              <div class="form-group col-sm-12 align-center">
                <button class="btn btn-primary">添加注释</button>
              </div>
          </form>
        </div>
    </div><!-- end of panel 注释 -->

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

<div class="nextModal modal fade" id="nextModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">您可以继续添加订单，或 <a style="text-decoration:underline;" href="${rootPath}case/list.html">回到询单列表页面</a></div>
      </div>
      <div class="modal-body align-center">
        <div class="section-block">
        <form id="order">
            <div class="section-title">选择目的地及地接社,继续添加订单</div>
            <div class="form-group col-sm-8 col-sm-offset-2">
                <label class="col-sm-3 control-label">目的地</label>
                <div class="col-sm-9">
                    <input type="text" name="destination" placeholder="目的地" class="destination-select fullwidth" value="" />
                </div>
            </div>
            <div class="form-group col-sm-8 col-sm-offset-2">
                <label class="col-sm-3 control-label">所属销售</label>
                <div class="col-sm-9">
                    <input type="text" name="salesid" placeholder="选择一个销售" class="sales-select fullwidth" value="" />
                </div>
            </div>
            <div class="col-sm-12">
             <a class="submit btn btn-primary">保存</a>
             <input  type="hidden" name="caseid" value="${crmcase.caseid}" />
             <input  type="hidden" name="budget" value="${crmcase.budget}" />
             <input  type="hidden" name="customerid" value="${crmcase.customerid}" />
             <input  type="hidden" name="customername" value="${crmcase.customername}" />
            </div>
            </form>
        </div>
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

document.getElementById("requirement").value="${crmcase.requirement}"

var d1 = ${country};
var d2 = ${language};
var d3 = ${contacttype};
var d4 = ${withwho};
var d5 = ${hotel};
var d6 = ${meals};
var d7 = ${guide};
var d8 = ${status};
var d9 = ${source};
var customer = ${customer};
var sales = ${sales};
$(".language-select").select2({
	placeholder: '选择一个沟通语言',
  	data: d2
});
$(".withwho-select").select2({
	placeholder: '与谁同行',
  	data: d4
});
$(".hotel-select").select2({
    placeholder: '选择一个住宿方式',
    data: d5
});
$(".meals-select").select2({
    placeholder: '选择一个',
    data: d6
});
$(".guide-select").select2({
    placeholder: '选择一个',
    data: d7
});
$(".contact-select").select2({
    placeholder: '选择一个希望联系方式',
    data: d3
});
$(".status-select").select2({
    placeholder: '选择一个',
    data: d8
});
$(".source-select").select2({
    placeholder: '选择一个推广渠道',
    data: d9
});
$(".country-select").select2({
    placeholder: '国家',
    data: d1
});
$(".customer-select").select2({
   placeholder: '客人',
   data: customer
});
$(".sales-select").select2({
   placeholder: '销售',
   data: sales
});
	jQuery(document).ready(function() {
		
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

		$(".nav-parent").eq(0).addClass("nav-active");
		$(".nav-parent").eq(0).find(".children").show();
			
		// Date Picker
		jQuery(".datepicker").datepicker({
			dateFormat: "yy-mm-dd",
			changeYear: true,
			changeMonth: true,
			maxDate: 0
		});

      $("input[name='starttime']").change(function() {
          var val = $("input[name='starttime']:checked").val();
          if (val == 1) {
              $(".d1").hide();
              $(".d2").show();
          }else{
              $(".d2").hide();
              $(".d1").show();
          }
      }); 
		 var t = jQuery('#dataTable-order').DataTable({
			 	pageLength: 10,
			 	processing: true,
			 	language: datatable_local_language, // my.js
			 	serverSide: true,
			 	ajax: {
			 		url: '${rootPath}order/list.do',
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
			           data: "orderid",
			           //defaultContent: '<a class="btn btn-success btn-xs"><span class="fa fa-edit"></span> 编辑</a>&nbsp;<a class="btn btn-danger btn-xs"><span class="fa fa-minus-circle"></span> 删除</a>',
			 	      orderable: false,
			 	      render: function ( data, type, full, meta ) {
		               return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>&nbsp;';
			 	  },
			 	              targets: 7
			 				  },				             
			 	  {
			 		  orderable: false,
			 		  searchable: false,
			 	      targets: [0,1,2]
			 	  },
			 	],
			 	columns: [
		             { data: "orderid" },
		             { data: "customername" },
		             { data: "agencyname" },
		             { data: "salesname" },
		             { data: "destination" },
		             { data: "budget" },
		             { data: "status" }
		         ]
			 });
			jQuery("#form").validate({
        
          rules: {
            adult: "digits",
            children: "digits",
            budget: "digits",
            startdate: "date",
            enddate: "date",
            startmonth: "date",
          },
          messages: {
            adult: "请输入一个整数",
            children: "请输入一个整数",
            budget: "请输入一个整数",
            startdate: "请输入正确的日期格式 mm/dd/yyyy",
            enddate: "请输入正确的日期格式 mm/dd/yyyy",
            startmonth: "请输入正确的日期格式 mm/dd/yyyy",
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
  		  }); 

        $("#addorder").click(function(){
          $("#nextModal").modal('show');
          return false;
        });
        
		//大约时间格式转换
		var date = $("#startmonth").val();	
		var dateformat = new Date(date).toISOString("yyyy-MM-dd hh:mm:ss.S").substring(0,10);
		$("#startmonth").val(dateformat)
		
		//大约时间格式转换
		var date = $("#startdate").val();	
		var dateformat = new Date(date).toISOString("yyyy-MM-dd hh:mm:ss.S").substring(0,10);
		$("#startdate").val(dateformat)
		
		//大约时间格式转换
		var date = $("#enddate").val();	
		var dateformat = new Date(date).toISOString("yyyy-MM-dd hh:mm:ss.S").substring(0,10);
		$("#enddate").val(dateformat)
    });
    $(".nextModal .submit").click(function(){
    	order_submit();
      });
		function order_submit() {
  			var f = $("#order").serialize();
  			$.post('${rootPath}order/add.do', f, function(result) {
  				var rmsg = result.msg;
  				if (result.success) {
  					window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseid}";
  					//$("#nextModal").modal('show');
  				} else {
  					//$("#msgModal").modal('show');
  				}
  			}, "JSON");
  		}
	if("${crmcase.starttime}"==1){
		$('#yes').attr('checked','true');
	}
	else{
		$('#no').attr('checked','true');
	}
  		function form_submit() {
  			var f = $("#form").serialize();
  			$.post('${rootPath}case/edit.do', f, function(result) {
  				var rmsg = result.msg;
  				if (result.success) {
  					//window.parent.location = "${rootPath}customer/list.html";
  					$("#nextModal").modal('show');
  				} else {
  					//$("#msgModal").modal('show');
  				}
  			}, "JSON");
  		}
  		var t = jQuery('#dataTable-note').DataTable({
  			pageLength: 10,
  			processing: true,
  			language: datatable_local_language, // my.js
  			serverSide: true,
  			ajax: {
  				url: '${rootPath}comment/list.do?type=case&id=${crmcase.caseid}',
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
							  }
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
  				url: '${rootPath}record/list.case?caseid=${crmcase.caseid}',
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
  			                    return creattime.format("yyyy-MM-dd");
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
  		function comment_submit() {
  			var f = $("#comment").serialize();
  			$.post('${rootPath}comment/add.do', f, function(result) {
  				var rmsg = result.msg;
  				if (result.success) {
  					window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseid}";
  				} 
  				else {
  					$("#msgModal").modal('show');
  				}
  			}, "JSON");
  		}
	</script>


</body>
</html>
