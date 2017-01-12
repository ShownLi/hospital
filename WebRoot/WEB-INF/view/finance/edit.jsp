<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../assets/pages/head.jsp"%>
<link href="${rootPath }assets/css/jquery.datatables.css"
	rel="stylesheet">
</head>

<body class="leftpanel-collapsed">
	<%@ include file="../assets/pages/preloader.jsp"%>
	<section>
		<%@ include file="../assets/pages/leftpanel.jsp"%>
		<div class="mainpanel">
			<%@ include file="../assets/pages/headerbar.jsp"%>
			<div class="pageheader">
				<h2>
					<i class="fa fa-user"></i> 财务管理 <span>财务管理</span>
				</h2>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-btns">
						<a href="" class="minimize">&minus;</a>
					</div>
					<h4 class="panel-title">订单详情</h4>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<div class="panel-body panel-body-nopadding">
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">订单编号</label> 
								<label class="col-sm-4 control-label">123456</label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">预算成本（外币）</label>
								<label class="col-sm-4 control-label">XXX</label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">预算价格（外币）</label>
								<label class="col-sm-4 control-label">XXX</label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">汇率</label>
								<label class="col-sm-4 control-label">XXX</label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">币种</label>
								<label class="col-sm-4 control-label">XXX</label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">预算成本</label> 
								<label class="col-sm-4 control-label">XXX</label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">预算价格</label> 
								<label class="col-sm-4 control-label">XXX</label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">实付成本</label> 
								<label class="col-sm-4 control-label">XXX</label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">实收价格</label> 
								<label class="col-sm-4 control-label">XXX</label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">成本调整</label> 
								<label class="col-sm-4 control-label">XXX</label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">收入调整</label> 
								<label class="col-sm-4 control-label">XXX</label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">欠付</label> 
								<label class="col-sm-4 control-label">XXX</label>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">欠收</label> 
								<label class="col-sm-4 control-label">XXX</label>
							</div>

						</div>
						<div class="panel-footer align-center">
							<input class="btn btn-primary" type="button" value="结算" /> <input
								type="hidden" name="orderId" value="${order.orderId}" />
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-btns">
						<a href="" class="minimize">&minus;</a>
					</div>
					<h4 class="panel-title">收款记录</h4>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table id="dataTable-payRecord" class="table table-communicate">
							<thead>
								<tr>
									<th>收款编号</th>
									<th>款项</th>
									<th>应收金额</th>
									<th>收款截止日期</th>
									<th>备注</th>
									<th>实收金额</th>
									<th>收款账户</th>
									<th>收款日期</th>
									<th>录入人</th>
									<th>状态</th>
									<th>调整金额</th>
									<th>欠收</th>
									<th>摘要</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-btns">
						<a href="" class="minimize">&minus;</a>
					</div>
					<h4 class="panel-title">付款记录</h4>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table id="dataTable-payRecord" class="table table-communicate">
							<thead>
								<tr>
									<th>付款ID</th>
									<th>收款方</th>
									<th>款项</th>
									<th>应付金额</th>
									<th>备注</th>
									<th>实付金额</th>
									<th>支付日期</th>
									<th>录入人</th>
									<th>调整金额</th>
									<th>欠付</th>
									<th>摘要</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
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
	
	</script>
</body>
</html>
