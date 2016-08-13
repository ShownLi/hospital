<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../assets/pages/head.jsp"%>
</head>

<body>
	<%@ include file="../assets/pages/preloader.jsp"%>
	<section>
		<%@ include file="../assets/pages/leftpanel.jsp"%>
		<div class="mainpanel">
			<%@ include file="../assets/pages/headerbar.jsp"%>
			<div class="pageheader">
				<h2>
					<i class="fa fa-user"></i> 询单管理 <span>新增询单</span>
				</h2>
				<!-- <div class="breadcrumb-wrapper">
					<span class="label">你在这里:</span>
					<ol class="breadcrumb">
						<li><a href="＃">CRM</a></li>
						<li><a href="${rootPath }user/list.html">询单管理</a></li>
						<li class="active">新增询单</li>
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
          <p>填写下表，完成询单创建。</p>
        </div>
        <form class="form-horizontal" id="form">
            <div class="panel-body panel-body-nopadding">
                <div class="section-block">
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">所属客人</label>
                      <div class="col-sm-8">
                        <input type="text" name="customerid" placeholder="所属客人" class="customer-select fullwidth" value="${customerid}" />
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">沟通语言</label>
                      <div class="col-sm-8">
                        <input type="text" name="preferlanguage" class="language-select fullwidth" value=""/>
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">希望联系方式</label>
                      <div class="col-sm-8">
	                      <select name="contacttype" class="contact-select fullwidth" multiple="multiple">
							  <option value="wechat">微信</option>
							  <option value="mobilephone">手机</option>
					</select>
                      </div>
                    </div> 
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">所属销售</label>
                      <div class="col-sm-8">
                        <input type="text" name="salesid" placeholder="所属销售" class="sales-select fullwidth" value="0"/>
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">询单来源</label>
                      <div class="col-sm-8">
                        <input type="text" name="source" class="source-select fullwidth" value="" />
                      </div>
                    </div>
	                <div class="form-group col-sm-4">
	                    <label class="col-sm-4 control-label">跟单员</label>
	                    <div class="col-sm-8">
	                      <input type="text" name="operator" class="user-select fullwidth" value="0" />
	                    </div>
	                </div>                        
                </div>
                    <div class="section-block">
                   	<div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">目的地</label>
                      <div class="col-sm-8">
                        <input type="text" name="destination" class="country-select fullwidth" value="" />
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">行程</label>
                      <div class="col-sm-8">
                        <input type="text" name="route" placeholder="行程" class="form-control" value="" />
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">状态</label>
                      <div class="col-sm-8">
                        <input type="text" name="status" class="status-select fullwidth" value="0" readonly/>
                      </div>
                    </div>             
                </div>
                <div class="section-block">
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">与谁同行</label>
                      <div class="col-sm-8">
                        <input type="text" name="withwho" class="withwho-select fullwidth" value="" />
                      </div>
                    </div>
                    <div class="form-group col-sm-4" style="clear: both;">
                      <label class="col-sm-4 control-label">成人</label>
                      <div class="col-sm-8">
                        <input type="text" name="adult" placeholder="成人" class="form-control" value="0" />
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-6 control-label">儿童（12岁以下）</label>
                      <div class="col-sm-6">
                        <input type="text" name="children" placeholder="儿童（12岁以下）" class="form-control" value="0" />
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-6 control-label">婴儿（0-2岁）</label>
                      <div class="col-sm-6">
                        <input type="text" name="baby" placeholder="婴儿（0-2岁）" class="form-control" value="0" />
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
        	                  <input type="radio" id="no" value="0" name="starttime" checked/>
        	                  <label for="no">未确定</label>
        	                </div><!-- rdio -->
        	                <label class="error" for="starttime"></label>
        	              </div>
                    </div>
                    <div class="form-group col-sm-4 d1">
                      <label class="col-sm-4 control-label">大约时间</label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input id="startmonth" type="text" name="startmonth" class="form-control datepicker" placeholder="mm/dd/yyyy" autocomplete="off">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                    </div>
                    <div class="form-group col-sm-4 d1">
                      <label class="col-sm-4 control-label">大约天数</label>
                      <div class="col-sm-8">
                        <input type="text" name="during" placeholder="大约天数" class="form-control" value="" />
                      </div>
                    </div>
                    <div class="form-group col-sm-4 d2">
                      <label class="col-sm-4 control-label">出发日期</label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input id="startdate" type="text" name="startdate" class="form-control datepicker" placeholder="yyyy/mm/dd" autocomplete="off">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                    </div>
                    <div class="form-group col-sm-4 d2">
                      <label class="col-sm-4 control-label">返回日期</label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input id="enddate" type="text" name="enddate" class="form-control datepicker" placeholder="yyyy/mm/dd" autocomplete="off">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                    </div>
                </div>
                <div class="section-block">
                    <div class="form-group col-sm-4">
                        <label class="col-sm-5 control-label">定制偏好</label>
                        <div class="col-sm-7">
                          <input type="text" name="tailormade" placeholder="定制偏好" class="tailormade-select fullwidth" />
                        </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">关于住宿</label>
                      <div class="col-sm-8">
                        <input type="text" name="hotel" class="hotel-select fullwidth" value="" />
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">关于用餐</label>
                      <div class="col-sm-8">
                        <input type="text" name="meals" class="meals-select fullwidth" value="" />
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-5 control-label">关于司机和导游</label>
                      <div class="col-sm-7">
                        <input type="text" name="guide" class="guide-select fullwidth" value="" />
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">客人的预算</label>
                      <div class="col-sm-8">
                        <input type="text" name="budget" placeholder="客人的预算" class="form-control" value="0" />
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">客人的要求</label>
                      <div class="col-sm-8">
                        <textarea name="requirement" class="form-control" placeholder="客人的要求" rows="5"></textarea>
                      </div>
                    </div>
                </div>
                <div class="section-block">
                    <div class="form-group col-sm-4">
                        <label class="col-sm-4 control-label">护照</label>
                        <div class="col-sm-8">
                          <input type="text" name="passport" placeholder="护照" class="passport-select fullwidth" />
                        </div>
                    </div>
                    <div class="form-group col-sm-4">
                        <label class="col-sm-4 control-label">签证</label>
                        <div class="col-sm-8">
                          <input type="text" name="visa" placeholder="签证" class="visa-select fullwidth" />
                        </div>
                    </div>
                    <div class="form-group col-sm-4">
                        <label class="col-sm-4 control-label">国际航班</label>
                        <div class="col-sm-8">
                          <input type="text" name="flight" placeholder="国际航班" class="flight-select fullwidth" />
                        </div>
                    </div>
                </div>
            </div><!-- panel-body -->
            
            <div class="panel-footer align-center">
                <button class="btn btn-primary">保存</button>&nbsp;
                <button class="btn btn-default">取消</button>
    		    </div><!-- panel-footer -->
        </form>   
      </div><!-- panel -->
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
<div class="modal fade" id="NoEmail" tabindex="-2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">信息</h4>
      </div>
      <div class="modal-body">
      		该客人没有邮箱，请<a href="../customer/edit.html">添加邮箱</a>后再进行操作
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
                    <input type="text" name="destination" id="destination" placeholder="国家" class="country-select fullwidth" value="" />
                </div>
            </div>
            <div class="form-group col-sm-8 col-sm-offset-2">
                <label class="col-sm-3 control-label">销售</label>
                <div class="col-sm-9">
                    <input type="text" name="salesid" id="salesid" placeholder="选择一个销售" class="sales-select fullwidth" value="" />
                </div>
            </div>
            <div class="form-group col-sm-8 col-sm-offset-2">
                <label class="col-sm-3 control-label">预算</label>
                <div class="col-sm-9">
                    <input type="text" name="budget" id="budget"  class="form-control" value="" />
                </div>
            </div>
            <div class="col-sm-12">
        	   <a class="submit btn btn-primary">保存</a>
        	 <input type="hidden"  name="caseid" id="caseid" value="" />
             <input type="hidden"  name="customerid" id="customerid" value="${customerid}" />
            </div>
          </form>
        </div>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->


	<%@ include file="../assets/pages/foot.jsp"%>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript">
    var d1 = ${country};
    var d2 = ${language};
    var d4 = ${withwho};
    var d5 = ${hotel};
    var d6 = ${meals};
    var d7 = ${guide};
    var d8 = ${status};
    var d9 = ${source};
    var d10 = ${tailormade};
    var d11 = ${passport};
    var d12 = ${visa};
    var d13 = ${flight};
    var customer = ${customer};
    var user = ${user};
    var sales = ${sales};
    
    $(".country-select").select2({
        placeholder: '国家',
        data: d1
    });
    $(".language-select").select2({
    	placeholder: '选择一个沟通语言',
     	data: d2
    });
    $(".contact-select").select2({
        placeholder: '选择希望联系方式',
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
    $(".status-select").select2({
        data: d8
     });
    $(".source-select").select2({
      placeholder: '选择一个推广渠道',
      data: d9
    });
    $(".tailormade-select").select2({
        placeholder: '选择一个',
        data: d10
      });
    $(".passport-select").select2({
        placeholder: '选择一个',
        data: d11
      });
    $(".visa-select").select2({
        placeholder: '选择一个',
        data: d12
      });
    $(".flight-select").select2({
        placeholder: '选择一个',
        data: d13
      });
    $(".customer-select").select2({
        placeholder: '客人',
        data: customer
    });
    $(".user-select").select2({
        placeholder: '客人',
        data: user
    });
    $(".sales-select").select2({
        placeholder: '销售',
        data: sales
    });
		jQuery(document).ready(function() {
			
        $(".nav-parent").eq(0).addClass("nav-active");
        $(".nav-parent").eq(0).find(".children").show();

        // Date Picker
        jQuery("#startmonth").datepicker({
          dateFormat: "yy-mm-dd",
          changeYear: true,
          changeMonth: true,
          minDate: 0
        });
        $("#startdate").datepicker({
          dateFormat: "yy-mm-dd",
          changeYear: true,
          changeMonth: true,
          minDate: 0
        });
        $("#enddate").datepicker({
          dateFormat: "yy-mm-dd",
          changeYear: true,
          changeMonth: true,
          minDate: 0
        });
			 
  			jQuery("#form").validate({
  				
    				rules: {
    					adult: "digits",
    					children: "digits",
              baby: "digits",
              budget: "digits",
              startdate: "date",
              enddate: "date",
              startmonth: "date",
              during: "digits",
    				},
    				messages: {
    					adult: "请输入一个整数",
              children: "请输入一个整数",
              baby: "请输入一个整数",
              budget: "请输入一个整数",
              startdate: "请输入正确的日期格式 mm/dd/yyyy",
              enddate: "请输入正确的日期格式 mm/dd/yyyy",
              startmonth: "请输入正确的日期格式 mm/dd/yyyy",
              during: "请输入一个整数",
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
			  
		      //添加订单弹出框，目的地与销售联动
		      $("#destination").change(function(){
		          var destination = $(this).val();
		          $.ajax({
		              type: "post",
		              url: "${rootPath}case/getsales.do?destination="+destination,
		              data: destination,
		              success: function(sales){
		            	  var json = jQuery.parseJSON( sales );
		                  $("#salesid").select2({
		                      placeholder: '销售',
		                      data: json
		                  });
		              }   
		          }); 
		      });
		});
			      
		function form_submit() {
			var f = $("#form").serialize();
			
			$.post('${rootPath}case/add.do', f, function(result) {
				var caseid = result.obj.caseid;
				document.getElementById("caseid").value=caseid;
				var rmsg = result.msg;
				if (result.success) {
					//window.parent.location = "${rootPath}case/list.html";
					$("#nextModal").modal('show');
					
				} else {
					$("#msgModal").modal('show');
					$("#nextModal").modal('hide');
				}
			}, "JSON");
		}
		
	      $(".nextModal .submit").click(function(){
	      	  order_submit();
	      });
	  		function order_submit() {
	    			var f = $("#order").serialize();
	    			$.post('${rootPath}order/add.do', f, function(result) {
	    				var rmsg = result.msg;
	    				if (result.success) {
	    					window.parent.location = "${rootPath}order/list.html";
	    					//$("#nextModal").modal('show');
	    				} else {
	    					$("#NoEmail").modal('show');
	    				}
	    			}, "JSON");
	    	}
	  		
        $(".d2").hide();
        $(".d1").show();
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
        $(".customer-select").change(function() {
            var val = $(".customer-select").select2("val");
        	document.getElementById("customerid").value=val;
        });
	</script>


</body>
</html>
