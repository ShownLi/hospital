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
					<i class="fa fa-order"></i> 订单管理 <span>编辑订单</span>
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
                    <input type="hidden" name="orderid" value="${order.orderid }" />
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
              <form class="form-horizontal form3">
                  <div class="section-block">
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">成团日期</label>
                          <div class="col-sm-8 input-group input-datepicker">
                            <input type="text" class="form-control datepicker" placeholder="mm/dd/yyyy">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">出发日期</label>
                          <div class="col-sm-8 input-group input-datepicker">
                            <input type="text" name="start_date" placeholder="出发日期" class="form-control datepicker" value="" />
                            <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                        <label class="col-sm-4 control-label">返回日期</label>
                        <div class="col-sm-8 input-group input-datepicker">
                          <input type="text" name="end_time" placeholder="返回日期" class="form-control datepicker" value="" />
                          <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                        </div>
                      </div>
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">成团人数</label>
                          <div class="col-sm-8">
                            <input type="text" name="group_number" placeholder="成团人数" class="form-control" value="" />
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">成团价格</label>
                          <div class="col-sm-8">
                            <input type="text" name="group_price" placeholder="成团价格" class="form-control" value="" />
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">货币种类</label>
                          <div class="col-sm-8">
                            <input type="text" name="currency" placeholder="货币种类" class="form-control" value="" />
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">汇率</label>
                          <div class="col-sm-8">
                            <input type="text" name="exchange_rate" placeholder="出发日期" class="form-control" value="" />
                          </div>
                      </div>
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">人民币价格</label>
                          <div class="col-sm-8">
                            <input type="text" name="rmb_price" placeholder="人民币价格" class="form-control" value="" />
                          </div>
                      </div>
                  </div>
              </form> 
              <form class="form-horizontal form4">
                  <div class="section-block">
                      <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">若未成行，原因是</label>
                        <div class="col-sm-8">
                          <input class="form-control reason-select" placeholder="若未成行，原因是" />
                        </div>
                      </div>
                  </div><!-- panel-body -->
              </form> 
          </div>
      </div><!-- end of panel 是否成行 -->




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

<!-- cModal -->
<div class="cModal modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">请填写以下订单信息</div>
      </div>
      <div class="modal-body">
          <form class="form-horizontal form1">
              <div class="section-block noline">
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团日期</label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input type="text" class="form-control datepicker" placeholder="mm/dd/yyyy">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">出发日期</label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input type="text" name="start_date" placeholder="出发日期" class="form-control datepicker" value="" />
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">返回日期</label>
                    <div class="col-sm-8 input-group input-datepicker">
                      <input type="text" name="end_time" placeholder="返回日期" class="form-control datepicker" value="" />
                      <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                    </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团人数</label>
                      <div class="col-sm-8">
                        <input type="text" name="group_number" placeholder="成团人数" class="form-control" value="" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团价格</label>
                      <div class="col-sm-8">
                        <input type="text" name="group_price" placeholder="成团价格" class="form-control" value="" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">货币种类</label>
                      <div class="col-sm-8">
                        <input type="text" name="currency" placeholder="货币种类" class="form-control" value="" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">汇率</label>
                      <div class="col-sm-8">
                        <input type="text" name="exchange_rate" placeholder="出发日期" class="form-control" value="" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">人民币价格</label>
                      <div class="col-sm-8">
                        <input type="text" name="rmb_price" placeholder="人民币价格" class="form-control" value="" />
                      </div>
                  </div>
              </div>
          </form>  
      </div>
      <div class="modal-footer align-center">
          <a class="submit btn btn-primary" href="#">保存</a>
          <a class="cancel btn btn-primary" href="#">取消</a>
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
          <form class="form-horizontal form2">
              <div class="section-block noline">
                  <div class="form-group col-sm-12">
                    <label class="col-sm-4 control-label">若未成行，原因是</label>
                    <div class="col-sm-8">
                      <input class="form-control reason-select" placeholder="若未成行，原因是" />
                    </div>
                  </div>
              </div><!-- panel-body -->
          </form>
      </div>
      <div class="modal-footer align-center">
          <a class="submit btn btn-primary" href="#">保存</a>
          <a class="cancel btn btn-primary" href="#">取消</a>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- bmodal -->

	<%@ include file="../assets/pages/foot.jsp"%>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	
	<script type="text/javascript">
	var s = ${status};
	
	$(".status-select").select2({
    	data: s
	})
	

	jQuery(document).ready(function() {

			
			jQuery("#form").validate({
		
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
			$.post('${rootPath}order/edit.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}order/list.html";
				} else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
	</script>


</body>
</html>
