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
            <a href="" class="panel-close">&times;</a>
            <a href="" class="minimize">&minus;</a>
          </div>
          <h4 class="panel-title">询单基本信息</h4>
          <p>填写下表，完成询单创建。</p>
        </div>
        <form class="form-horizontal" id="form">
        <div class="panel-body panel-body-nopadding">
            <div class="section-block">
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">称呼</label>
                  <div class="col-sm-8">
                    <input type="text" name="customer_name" placeholder="称呼" class="form-control" value="" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">沟通语言</label>
                  <div class="col-sm-8">
                    <input type="text" name="prefer_language" class="language-select form-control" value=""/>
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">希望联系方式</label>
                  <div class="col-sm-8">
                    <input type="text" name="contact_type" class="contact-select form-control" value="" />
                  </div>
                </div>                
            </div>
            <div class="section-block">
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">与谁同行</label>
                  <div class="col-sm-8">
                    <input type="text" name="with_who" class="withwho-select form-control" value="" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">成人</label>
                  <div class="col-sm-8">
                    <input type="text" name="adult" placeholder="成人" class="form-control" value="" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-6 control-label">儿童（12岁以下）</label>
                  <div class="col-sm-6">
                    <input type="text" name="children" placeholder="儿童（12岁以下）" class="form-control" value="" />
                  </div>
                </div>
            </div>
            <div class="section-block">
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">出发时间</label>
                  <div class="col-sm-8">
                    <input type="text" name="start_time" class="time-select form-control" value="" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">大约时间</label>
                  <div class="col-sm-8 input-group input-datepicker">
                    <input type="text" class="form-control datepicker" placeholder="mm/dd/yyyy">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">大约天数</label>
                  <div class="col-sm-8">
                    <input type="text" name="during" placeholder="大约天数" class="form-control" value="" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">出发日期</label>
                  <div class="col-sm-8 input-group input-datepicker">
                    <input type="text" class="form-control datepicker" placeholder="mm/dd/yyyy">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">返回日期</label>
                  <div class="col-sm-8 input-group input-datepicker">
                    <input type="text" class="form-control datepicker" placeholder="mm/dd/yyyy">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                  </div>
                </div>
            </div>
            <div class="section-block">
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">关于住宿</label>
                  <div class="col-sm-8">
                    <input type="text" name="hotel" class="hotel-select form-control" value="" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">关于用餐</label>
                  <div class="col-sm-8">
                    <input type="text" name="meals" class="meals-select form-control" value="" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-5 control-label">关于司机和导游</label>
                  <div class="col-sm-7">
                    <input type="text" name="guide" class="guide-select form-control" value="" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">客人的要求</label>
                  <div class="col-sm-8">
                    <textarea class="form-control" placeholder="客人的要求" rows="3"></textarea>
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">客人的预算</label>
                  <div class="col-sm-8">
                    <input type="text" name="budget" placeholder="客人的预算" class="form-control" value="" />
                  </div>
                </div>
            </div>
            <div class="section-block">
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">销售姓名</label>
                  <div class="col-sm-8">
                    <input type="text" name="sales_name" placeholder="销售姓名" class="form-control" value="" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">目的地</label>
                  <div class="col-sm-8">
                    <input type="text" name="destination" class="destination-select form-control" value="" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">行程</label>
                  <div class="col-sm-8">
                    <input type="text" name="budget" placeholder="行程" class="form-control" value="" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">表单类型</label>
                  <div class="col-sm-8">
                    <input type="text" name="submit_type" class="submittype-select form-control" value="" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">询单来源</label>
                  <div class="col-sm-8">
                    <input type="text" name="source" class="source-select form-control" value="" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">状态</label>
                  <div class="col-sm-8">
                    <input type="text" name="status" placeholder="状态" class="form-control" value="" />
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

<div class="nextModal modal fade" id="nextModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">您可以继续添加订单，或 <a style="text-decoration:underline;" href="${rootPath}case/list.html">回到询单列表页面</a></div>
      </div>
      <div class="modal-body align-center">
        <div class="section-block">
            <div class="section-title">选择国家及目的地,继续添加订单</div>
            <div class="form-group col-sm-8 col-sm-offset-2">
                <label class="col-sm-3 control-label">国家</label>
                <div class="col-sm-9">
                    <input type="text" name="country" placeholder="国家" class="country-select form-control" value="" />
                </div>
            </div>
            <div class="form-group col-sm-8 col-sm-offset-2">
                <label class="col-sm-3 control-label">地接社</label>
                <div class="col-sm-9">
                    <input type="text" name="rmb_price" placeholder="人民币价格" class="form-control" value="" />
                </div>
            </div>
            <div class="col-sm-12">
        	   <a class="btn btn-primary" href="#">保存</a>
            </div>
        </div>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->


	<%@ include file="../assets/pages/foot.jsp"%>
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript">
		// var p = ${promote};
		// var a = ${agegroup};
		// $(".language-select").select2({
		// 	placeholder: '选择一个推广渠道',
		//   	data: p
		// });
		// $(".withwho-select").select2({
		// 	placeholder: '选择一个推广渠道',
		//   	data: a
		// });
  //       $(".time-select").select2({
  //           placeholder: '选择一个推广渠道',
  //           data: a
  //       });
  //       $(".hotel-select").select2({
  //           placeholder: '选择一个推广渠道',
  //           data: a
  //       });
  //       $(".meals-select").select2({
  //           placeholder: '选择一个推广渠道',
  //           data: a
  //       });
  //       $(".guide-select").select2({
  //           placeholder: '选择一个推广渠道',
  //           data: a
  //       });
  //       $(".contact-select").select2({
  //           placeholder: '选择一个推广渠道',
  //           data: a
  //       });
  //       $(".destination-select").select2({
  //           placeholder: '选择一个推广渠道',
  //           data: a
  //       });
  //       $(".submittype-select").select2({
  //           placeholder: '选择一个推广渠道',
  //           data: a
  //       });
	 //    $(".source-select").select2({
  //           placeholder: '选择一个推广渠道',
  //           data: a
  //       });
		   // $(".country-select").select2({
     //           placeholder: '国家',
     //           data: a
     //       })
		jQuery(document).ready(function() {
			
			 // Date Picker
			  jQuery(".datepicker").datepicker();
			 
			jQuery("#form").validate({
				
				rules: {
					loginname: "required",
					name: "required",
					pwd: {
						required: true,
					},
					repwd: {
						required: true,
						equalTo: "[name='pwd']"
					}
				},
				messages: {
					loginname: "请输入登录名",
					name: "请输入姓名",
					pwd: {
						required: "请输入密码"
					},
					repwd: {
						required: "请输入密码确认",
						equalTo: "两次输入的密码不一致"
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
			      
		function form_submit() {
			var f = $("#form").serialize();
			$.post('${rootPath}user/add.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					//window.parent.location = "${rootPath}customer/list.html";
					$("#nextModal").modal('show');
				} else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
	</script>


</body>
</html>
