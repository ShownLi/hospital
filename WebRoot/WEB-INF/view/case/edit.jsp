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
					<i class="fa fa-user"></i> 询单管理 <span>编辑询单</span>
				</h2>
			</div>

			<div class="contentpanel">
				<!-- content goes here... -->
      
         <!-- panel 是否无效 -->
      <div class="panel panel-default">
          <div class="panel-heading">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-btns">
							<a href="" class="minimize">&minus;</a>
						</div>
						<h4 class="panel-title">询单基本信息</h4>
						<p>填写下表，完成询单编辑。</p>
					</div>
					<form class="form-horizontal" id="form-case">
						<div class="panel-body panel-body-nopadding">



							<div class="section-block">
								<h5 class="section-title">客人基本信息</h5>
								<div class="form-group col-sm-4">
									<label class="col-sm-4 control-label">客人ID</label>
									<div class="col-sm-8">
										<input type="text" name="customerId" placeholder="客人ID"
											readonly class="form-control" value="${crmcase.customerId}"
											readonly />
									</div>
								</div>
								<div class="form-group col-sm-4">
									<label class="col-sm-3 control-label">客人姓名<span
										class="asterisk">*</span></label>
									<div class="col-sm-9">
										<input type="text" name="chineseName" placeholder="中文名"
											class="form-control" value="${crmcase.chineseName}" />
									</div>									
								</div>
								<div class="form-group col-sm-4">
								<label class="col-sm-3 control-label">英文名</label>
									<div class="col-sm-9">								
										<input type="text" name="englishName" placeholder="英文名"
											class="form-control" value="${crmcase.englishName}" />
									</div>
								</div>
							</div>
							<div class="section-block">
								<h5 class="section-title">
									客人联系方式 <span class="contact-note">(手机、微信、QQ、邮箱至少填写一个)</span>
								</h5>
								<div class="form-group col-sm-4 contact-field">
									<label class="col-sm-3 control-label">手机</label>
									<div class="col-sm-9">
										<input type="text" name="mobile" placeholder="手机"
											class="form-control" value="${crmcase.mobile}" />
									</div>
								</div>
								<div class="form-group col-sm-4 contact-field">
									<label class="col-sm-3 control-label">微信</label>
									<div class="col-sm-9">
										<input type="text" name="wechat" placeholder="微信"
											class="form-control" value="${crmcase.wechat}" />
									</div>
								</div>
								<div class="form-group col-sm-4 contact-field">
									<label class="col-sm-3 control-label">QQ</label>
									<div class="col-sm-9">
										<input type="text" name="qq" placeholder="QQ"
											class="form-control" value="${crmcase.qq}" />
									</div>
								</div>
								<div class="form-group col-sm-4 contact-field">
									<label class="col-sm-3 control-label">邮箱</label>
									<div class="col-sm-9">
										<input type="text" name="email" placeholder="邮箱"
											class="form-control" value="${crmcase.email}" />
									</div>
								</div>
							</div>

							<div class="section-block">
								<div class="form-group col-sm-4">
									<label class="col-sm-4 control-label">沟通语言</label>
									<div class="col-sm-8">
										<input type="text" name="preferLanguage"
											class="language-select fullwidth"
											value="${crmcase.preferLanguage}" />
									</div>
								</div>
								<div class="form-group col-sm-4">
									<label class="col-sm-4 control-label">希望联系方式</label>
									<div class="col-sm-8">
										<select name="contactType" class="contact-select fullwidth"
											multiple="multiple">

										</select>
									</div>
								</div>
								<div class="form-group col-sm-4">
									<label class="col-sm-4 control-label">询单来源</label>
									<div class="col-sm-8">
										<input type="text" name="source"
											class="source-select fullwidth" value="${crmcase.source}" />
									</div>
								</div>

								<div class="form-group col-sm-4">
									<label class="col-sm-4 control-label">状态</label>
									<div class="col-sm-8">
										<input type="text" name="status"
											class="status-select fullwidth" value="${crmcase.status}" />
									</div>
								</div>
							</div>
						</div>

						<div class="section-block">
							<div class="form-group col-sm-4">
								<label class="col-sm-4 control-label">IP地址</label>
								<div class="col-sm-8">
									<input type="text" name="ipAddress" class="form-control"
										readonly value="${crmcase.ipAddress}" />
								</div>
							</div>

							<div class="form-group col-sm-4">
								<label class="col-sm-4 control-label">推广码</label>
								<div class="col-sm-8">
									<input type="text" name="promoteCode" class="form-control"
										readonly value="${crmcase.promoteCode}" />
								</div>
							</div>

							<div class="form-group col-sm-4">
								<label class="col-sm-4 control-label">表单类型</label>
								<div class="col-sm-8">
									<input type="text" name="submitType" class="form-control"
										readonly value="${crmcase.submitType}" />
								</div>
							</div>

							<div class="form-group col-sm-4">
								<label class="col-sm-4 control-label">目的地</label>
								<div class="col-sm-8">
									 <select id="destination" name="destination" class="contact-select-country fullwidth" multiple="multiple">
									</select>     
								</div>
							</div>

							<div class="form-group col-sm-4">
								<label class="col-sm-4 control-label">跟单员</label>
								<div class="col-sm-8">
									<input type="text" name="operator"
										class="user-select fullwidth" value="${crmcase.operator}" />
								</div>
							</div>
							<div class="form-group col-sm-4">
								<label class="col-sm-4 control-label">沟通方式</label>
								<div class="col-sm-8">
									<input type="text" name="contactReal" id="contactReal" class="contact-real-select fullwidth" />
								</div>
							</div>
						</div>

						<div class="section-block">
							<div class="form-group col-sm-4">
								<label class="col-sm-4 control-label">与谁同行</label>
								<div class="col-sm-8">
									<input type="text" name="withwho"
										class="withwho-select fullwidth" value="${crmcase.withwho}" />
								</div>
							</div>
							<div class="form-group col-sm-4" style="clear: both;">
								<label class="col-sm-4 control-label">成人</label>
								<div class="col-sm-8">
									<input type="text" name="adult" placeholder="成人"
										class="form-control" value="${crmcase.adult}" />
								</div>
							</div>
							<div class="form-group col-sm-4">
								<label class="col-sm-6 control-label">儿童（12岁以下）</label>
								<div class="col-sm-6">
									<input type="text" name="children" placeholder="儿童（12岁以下）"
										class="form-control" value="${crmcase.children}" />
								</div>
							</div>
							<div class="form-group col-sm-4">
								<label class="col-sm-6 control-label">婴儿（0-2岁）</label>
								<div class="col-sm-6">
									<input type="text" name="baby" placeholder="婴儿（0-2岁）"
										class="form-control" value="${crmcase.baby}" />
								</div>
							</div>
						</div>
						<div class="section-block">
							<div class="form-group col-sm-4">
								<label class="col-sm-4 control-label">出发时间 <span
									class="asterisk">&nbsp;</span></label>
								<div class="col-sm-8">
									<div class="rdio rdio-primary rdio-inline">
										<input type="radio" id="yes" value="1" name="startTime" /> <label
											for="yes">已确定</label>
									</div>
									<!-- rdio -->
									<div class="rdio rdio-primary rdio-inline">
										<input type="radio" id="no" value="0" name="startTime" /> <label
											for="no">未确定</label>
									</div>
									<!-- rdio -->
									<label class="error" for="startTime"></label>
								</div>
							</div>
							<div class="form-group col-sm-4 start-time">
								<label class="col-sm-4 control-label">大约时间</label>
								<div class="col-sm-8 input-group input-datepicker">
									<input type="text" id="startMonth" name="startMonth"
										class="form-control datepicker" placeholder="yyyy/mm/dd"
										value="${crmcase.startMonth}" autocomplete="off"> <span
										class="input-group-addon"><i
										class="glyphicon glyphicon-calendar"></i></span>
								</div>
							</div>
							<div class="form-group col-sm-4 start-time">
								<label class="col-sm-4 control-label">大约天数</label>
								<div class="col-sm-8">
									<input type="text" name="during" placeholder="大约天数"
										class="form-control" value="${crmcase.during}" />
								</div>
							</div>
							<div class="form-group col-sm-4 start-date">
								<label class="col-sm-4 control-label">出发日期</label>
								<div class="col-sm-8 input-group input-datepicker">
									<input type="text" id="startDate" name="startDate"
										class="form-control datepicker" placeholder="yyyy/mm/dd"
										value="${crmcase.startDate}" autocomplete="off"> <span
										class="input-group-addon"><i
										class="glyphicon glyphicon-calendar"></i></span>
								</div>
							</div>
							<div class="form-group col-sm-4 start-date">
								<label class="col-sm-4 control-label">返回日期</label>
								<div class="col-sm-8 input-group input-datepicker">
									<input type="text" id="endDate" name="endDate"
										class="form-control datepicker" placeholder="yyyy/mm/dd"
										value="${crmcase.endDate}" autocomplete="off"> <span
										class="input-group-addon"><i
										class="glyphicon glyphicon-calendar"></i></span>
								</div>
							</div>
						</div>
						<div class="section-block">
							<div class="form-group col-sm-4">
								<label class="col-sm-5 control-label">定制偏好</label>
								<div class="col-sm-7">
									<input type="text" name="tailormade" placeholder="定制偏好"
										class="tailormade-select fullwidth"
										value="${crmcase.tailormade}" />
								</div>
							</div>
							<div class="form-group col-sm-4">
								<label class="col-sm-4 control-label">关于住宿</label>
								<div class="col-sm-8">
									<input type="text" name="hotel" class="hotel-select fullwidth"
										value="${crmcase.hotel}" />
								</div>
							</div>
							<div class="form-group col-sm-4">
								<label class="col-sm-4 control-label">关于用餐</label>
								<div class="col-sm-8">
									<input type="text" name="meals" class="meals-select fullwidth"
										value="${crmcase.meals}" />
								</div>
							</div>
							<div class="form-group col-sm-4">
								<label class="col-sm-5 control-label">关于司机和导游</label>
								<div class="col-sm-7">
									<input type="text" name="guide" class="guide-select fullwidth"
										value="${crmcase.guide}" />
								</div>
							</div>
							<div class="form-group col-sm-4">
								<label class="col-sm-4 control-label">客人的预算</label>
								<div class="col-sm-8">
									<input type="text" name="budget" placeholder="客人的预算"
										class="form-control" value="${crmcase.budget}" />
										<span style="position: absolute; right: 15px; top: 10px;">￥/人</span>
								</div>
							</div>
							<div class="form-group col-sm-8" style="clear: both;">
								<label class="col-sm-2 control-label">客人的要求</label>
								<div class="col-sm-9" style="margin-left: 23px;">
									<textarea id="requirement" name="requirement"
										class="form-control" placeholder="客人的要求" rows="5">${crmcase.requirement}</textarea>
								</div>
							</div>
						</div>
						<div class="section-block">
							<div class="form-group col-sm-4">
								<label class="col-sm-4 control-label">护照</label>
								<div class="col-sm-8">
									<input type="text" name="passport" placeholder="护照"
										class="passport-select fullwidth" value="${crmcase.passport}" />
								</div>
							</div>
							<div class="form-group col-sm-4">
								<label class="col-sm-4 control-label">签证</label>
								<div class="col-sm-8">
									<input type="text" name="visa" placeholder="签证"
										class="visa-select fullwidth" value="${crmcase.visa}" />
								</div>
							</div>
							<div class="form-group col-sm-4">
								<label class="col-sm-4 control-label">国际航班</label>
								<div class="col-sm-8">
									<input type="text" name="flight" placeholder="国际航班"
										class="flight-select fullwidth" value="${crmcase.flight}" />
								</div>
							</div>
							<div class="form-group col-sm-4" id="div-delInfo"
								style="display: none">
								<label class="col-sm-4 control-label">无效原因</label>
								<div class="col-sm-8">
									<input type="text" name="reason" placeholder="无效原因"
										class="reason-select fullwidth" value="${crmcase.reason}" />
								</div>
							</div>
							<!--  设置未成行原因下拉选项 -->
							<div class="form-group col-sm-4" id="div-nodealInfo"
								style="display: none">
								<label class="col-sm-4 control-label">未成行原因</label>
								<div class="col-sm-8">
									<input type="text" name="reasonNodeal" placeholder="未成行原因"
										class="reason-nodeal-select fullwidth"
										value="${crmcase.reasonNodeal}" />
								</div>
							</div>

						</div>
						<!-- panel-body -->

						<div class="panel-footer align-center">

							<input class="btn btn-primary" id="btn-addorder" type="button" value="分配地接社" />&nbsp; 
							<input class="btn btn-primary" type="submit" value="保存" />&nbsp;
							<input class="btn btn-danger" id="btn-invalid"   type="button" value="无效"/>&nbsp; 
							<input class="btn btn-danger" id="btn-nodeal" type="button" value="未成行" />&nbsp; 
							<!-- <input class="btn btn-primary" id="btn-confirmpay" type="button" value="收款确认" />&nbsp;  -->
							<input class="btn btn-default" type="button" id="btn-back" value="返回" /> 
							<input type="hidden"name="caseId" value="${crmcase.caseId}" />

						</div>
						<!-- panel-footer -->
					</form>
				</div>
				<!-- panel -->

				<!-- panel 订单列表  -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-btns">
							<a href="" class="minimize">&minus;</a>
						</div>
						<h4 class="panel-title">订单列表</h4>
					</div>
					<div class="panel-body">
						<div class="table-responsive">

							<table id="dataTable-order" class="table">
								<thead>
									<tr>
										<th>客人姓名<br>ID</th>
										<th>地接社<br>销售</th>
										<th>目的地<br>状态</th>
										<th>成团人数</th>
										<th>成团金额</th> 
 										<th>出发日期<br>返回日期</th> 
 										<th>跟单员</th>
										<th>创建时间</th>
										<th>最后回复时间</th>
										<th>编辑</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						<!-- table-responsive -->
					</div>
				</div>
				<!-- end of panel 询单  -->

				<!-- panel 沟通列表 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-btns">
							<a href="" class="minimize">&minus;</a>
						</div>
						<h4 class="panel-title">沟通记录</h4>
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
				</div>
				<!-- end of panel 沟通列表 -->

				<!-- panel 注释 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-btns">
							<a href="" class="minimize">&minus;</a>
						</div>
						<h4 class="panel-title">注释列表</h4>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table id="dataTable-comment" class="table">
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
						<div class="form-group col-sm-12 align-center" id="addNoteDiv">
							<input class="btn btn-primary" type="button" id="addNote" onclick="showNote()" value="添加注释"/>
						</div>
					</div>
				</div>
				<!-- end of panel 注释 -->

			</div>
	
		</div>
		</div>
	</div>
		<!-- mainpanel -->
		<%@ include file="../assets/pages/rightpanel.jsp"%>
	</section>


	<!-- Modal 保存数据时出错-->
	<div class="modal fade" id="msgModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">信息</h4>
				</div>
				<div class="modal-body">保存数据时出错了</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- modal-content -->
		</div>
		<!-- modal-dialog -->
	</div>
	<!-- modal -->

	<!-- Modal 添加订单没有地址 -->
	<div class="modal fade" id="msgDestination" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">信息</h4>
				</div>
				<div class="modal-body">请选择目的地，再添加订单</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- modal-content -->
		</div>
		<!-- modal-dialog -->
	</div>
	<!-- modal -->
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
                      <label class="col-sm-4 control-label">成团人数<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="groupNumber" placeholder="成团人数" class="form-control"/>
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
                      <label class="col-sm-4 control-label">成团成本<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="costBudget" placeholder="成团成本" class="form-control"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团价格<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="groupPrice" placeholder="成团价格" class="form-control" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">成团币种<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="currency" placeholder="成团币种" class="currency-select fullwidth"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">汇率<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="exchangeRate" placeholder="汇率" class="form-control" value="" />
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">人民币成本<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="costBudgetRmb" placeholder="人民币成本" class="form-control"/>
                      </div>
                  </div>
                   <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">人民币价格<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" id="rmbPrice" name="rmbPrice" placeholder="人民币价格" class="form-control"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">签约乙方<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="costReceiver" placeholder="签约乙方" class="costReceiver-select fullwidth"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-6">
                      <label class="col-sm-4 control-label">付款方式<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" id="paymentMethod" name="paymentMethod" placeholder="付款方式" class="paymentMethod-select fullwidth"/>
                      </div>
                  </div>
                         
			       <table id="payTable" class="table">
						<thead>
							<tr>
								<th>期数</th>
								<th>款项</th>
								<th>应收金额</th>
								<th>收款截止日期</th>
								<th>备注</th>
							</tr>
						</thead>
						<tbody>
							<tr id="tr_0">
								 <td>第一期</td>
								 <td><input type="text" name="paymentItem" placeholder="款项" class="financeItem-select fullwidth"/></td>
								 <td><input type="text" id="priceBudget1" name="priceBudget" placeholder="应收金额" class="form-control"/></td>
								 <td> 
								 <input type="text" name="deadline" placeholder="收款截止日期" class="form-control datepicker" autocomplete="off" />
				                  				 <!-- <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> -->
								 </td>
								 <td><input type="text" name="comment" placeholder="备注" class="form-control"/></td>
							</tr>
							<tr id="tr_1">
								 <td>第二期</td>
								 <td><input type="text" name="paymentItem" placeholder="款项" class="financeItem-select fullwidth"/></td>
								 <td><input type="text" id="priceBudget2" name="priceBudget" placeholder="应收金额" class="form-control"/></td>
								 <td> 
								 <input type="text" name="deadline" placeholder="收款截止日期" class="form-control datepicker" autocomplete="off" />
				                  				 <!-- <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> -->
								 </td>
								 <td><input type="text" name="comment" placeholder="备注" class="form-control"/></td>
							</tr>
							<tr id="tr_2">
								 <td>第三期</td>
								 <td><input type="text" name="paymentItem" placeholder="款项" class="financeItem-select fullwidth"/></td>
								 <td><input type="text" id="priceBudget3" name="priceBudget" placeholder="应收金额" class="form-control"/></td>
								 <td> 
								 <input type="text" name="deadline" placeholder="收款截止日期" class="form-control datepicker" autocomplete="off" />
				                  				 <!-- <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> -->
								 </td>
								 <td><input type="text" name="comment" placeholder="备注" class="form-control"/></td>
							</tr>
							<tr id="tr_3">
								 <td>第四期</td>
								<td><input type="text" name="paymentItem" placeholder="款项" class="financeItem-select fullwidth"/></td>
								 <td><input type="text" id="priceBudget4" name="priceBudget" placeholder="应收金额" class="form-control"/></td>
								 <td> 
								 <input type="text" name="deadline" placeholder="收款截止日期" class="form-control datepicker" autocomplete="off" />
				                  				 <!-- <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> -->
								 </td>
								 <td><input type="text" name="comment" placeholder="备注" class="form-control"/></td>
							</tr>
							<tr id="tr_4">
								 <td>第五期</td>
								<td><input type="text" name="paymentItem" placeholder="款项" class="financeItem-select fullwidth"/></td>
								 <td><input type="text" id="priceBudget5" name="priceBudget" placeholder="应收金额" class="form-control"/></td>
								 <td> 
								 <input type="text" name="deadline" placeholder="收款截止日期" class="form-control datepicker" autocomplete="off" />
				                  				 <!-- <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> -->
								 </td>
								 <td><input type="text" name="comment" placeholder="备注" class="form-control"/></td>
							</tr>
						</tbody>
					</table>
                  <input type="hidden" id="dealOrderId" name="orderId" value="${order.orderId}" />
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
                      <input class="orderNoDealReason-select fullwidth" name="reason" placeholder="若未成行，原因是" />
                    </div>
                  </div>
                  <div class="form-group col-sm-12">
                  <label class="col-sm-4 control-label">备注</label>
                    <div class="col-sm-8">
                      <textarea name="content" class="form-control" rows="5"></textarea>
                    </div>
                  </div>
                  <input type="hidden" id="noDeal-orderId" name="orderId"  />	
                  <input type="hidden" name="status" value="3" />
                  <input  type="hidden" name="userId" value="${loginUser.userId}" />
	              <input  type="hidden" name="userName" value="${loginUser.name}" />
	              <input  type="hidden" id="noDeal-objectId" name="objectId"  />
	              <input  type="hidden" name="commentType" value="order" />
              </div><!-- noDealModal-body -->
          </div>
          <div class="modal-footer align-center">
            <button class="submit btn btn-primary" >保存</button> 
            <a class="cancel btn btn-primary" >取消</a>
          </div>
      </form>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- bmodal -->

<!-- Modal -->
<div class="modal fade" id="NoEmail" tabindex="-2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">信息</h4>
      </div>
      <div class="modal-body">
      		该客人没有邮箱，请<a href="#" id="addEmail">添加邮箱</a>后再进行操作
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->
	<!-- Modal 未填写邮件-->
	<div class="modal fade" id="NoEmail" tabindex="-2" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">信息</h4>
				</div>
				<div class="modal-body">
					该客人没有邮箱，请<a href="#" id="addEmail">添加邮箱</a>后再进行操作
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- modal-content -->
		</div>
		<!-- modal-dialog -->
	</div>
	<!-- modal -->


	<div class="nextModal modal fade" id="nextModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body align-center">
					<div class="section-block">
						<form id="form-order">
							<div class="section-title">选择目的地及地接社,添加订单</div>
							<div class="form-group col-sm-8 col-sm-offset-2">
								<label class="col-sm-3 control-label">目的地</label>
								<div class="col-sm-9">

									<input type="text" id="orderDestinationText"
										readonly="readonly" class="form-control" value="" /> <input
										type="hidden" id="orderDestination" name="destination"
										value="" />

								</div>
							</div>
							<div class="form-group col-sm-8 col-sm-offset-2">
								<label class="col-sm-3 control-label">所属销售</label>
								<div class="col-sm-9">
									<input type="text" id="salesId" name="salesId"
										placeholder="选择一个销售" class="sales-select fullwidth" value="" />
								</div>
							</div>
							
							<div class="col-sm-12">
								<a class="submit btn btn-primary" >保存</a> 
								<input type="hidden" name="caseId" value="${crmcase.caseId}" /> 
								<input type="hidden" name="customerId" value="${crmcase.customerId}" />
								<input type="hidden" name="operator" value="${crmcase.operator}" />
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- modal-content -->
		</div>
		<!-- modal-dialog -->
	</div>
	<!-- modal -->
<!-- 询单无效 -->
<div class="confirmDelModal modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">请填写无效原因</div>
      </div>
      <form class="form-horizontal" id="form-del">
          <div class="modal-body">     
              <div class="section-block noline">
                  <div class="form-group col-sm-12">
                    <label class="col-sm-4 control-label">无效原因是</label>
                    <div class="col-sm-8">
                      <input class="reason-select fullwidth" name="reason" placeholder="无效原因是" />
                      <input type="hidden" name="caseId" value="${crmcase.caseId}" />	
                    </div>
                  </div>
              </div><!-- noDealModal-body -->
          </div>
          <div class="modal-footer align-center">
              <input type="submit" class="submit btn btn-primary" value="保存"/>
              <a class="cancel btn btn-primary" >取消</a>
          </div>
      </form>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- bmodal -->

	<!-- 询单未成行 -->
	<div class="confirmNoDealModal modal fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<div class="nextModal-title">请填写未成行原因</div>
				</div>
				<form class="form-horizontal" id="form-nodeal">
					<div class="modal-body">
						<div class="section-block noline">
							<div class="form-group col-sm-12">
								<label class="col-sm-4 control-label">未成行原因是</label>
								<div class="col-sm-8">
									<input class="reason-nodeal-select fullwidth"
										name="reasonNodeal" placeholder="未成行原因是" /> <input
										type="hidden" name="caseId" value="${crmcase.caseId}" />
								</div>
							</div>
						</div>
						<!-- noDealModal-body -->
					</div>
					<div class="modal-footer align-center">
						<input class="submit btn btn-primary" type="submit" value="保存">&nbsp;
						<a class="cancel btn btn-primary">取消</a>
					</div>
				</form>
			</div>
			<!-- modal-content -->
		</div>
		<!-- modal-dialog -->
	</div>
	
	<!-- Modal 保存注释-->
	<div class="modal fade" id="addNote2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加注释信息</h4>
				</div>
				<div class="modal-body">
					<form id="form-comment" class="form row">
					<div class="form-group col-sm-6 col-sm-offset-3">
						<textarea name="content" class="form-control" rows="5"></textarea>
						<input type="hidden" name="userId" value="${loginUser.userId}" />
						<input type="hidden" name="userName" value="${loginUser.name}" />
						<input type="hidden" name="objectId" value="${crmcase.caseId}" />
						<input type="hidden" name="commentType" value="case" />
					</div>
					<div class="form-group col-sm-12 align-center">
						<input class="btn btn-primary" type="submit" value="保存注释"/>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
					</form>
				</div>
			</div>
			<!-- modal-content -->
		</div>
		<!-- modal-dialog -->
	</div>
	<!-- bmodal -->


	<%@ include file="../assets/pages/foot.jsp"%>
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/datepicker-zh-CN.js"></script>
	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>

	<script type="text/javascript">
	
	function showNote() {
		$("#addNote2").modal('show')
	}
	
	$(function(){
		if("${crmcase.status}"==3||"${crmcase.status}"==5||"${crmcase.status}"==4){
			$("#btn-nodeal").css("display","none");
		}
		if("${crmcase.status}"==5||"${crmcase.status}"==4){
			$("#btn-addorder").css("display","none");
		}
		
		/* if("${crmcase.status}"!=3){
			$("#btn-confirmpay").css("display","none");
		}  */
		
	})
	if("${crmcase.status}"==1){
			$("#btn-invalid").css("display","display");
		
	}else{
			$("#btn-invalid").css("display","none");
	}
	var country = ${country};
    var language = ${language};
    var withwho = ${withwho};
    var hotel = ${hotel};
    var meals = ${meals};
    var guide = ${guide};
    var caseStatus = ${status};   
    var source = ${source};
    var tailormade = ${tailormade};
    var passport = ${passport};
    var visa = ${visa};
    var flight = ${flight};
    var customer = ${customer};
    var user = ${user};
    var sales = ${sales};
	var orderStatus = ${orderStatus};
	var level = ${level};
	var agegroup = ${ageGroup}; 
	var genderData = [{ id: 'male', text: '男' }, { id:'female' , text: '女' }];
	var reason = ${reason};
	 var orderNoDealReason=${orderNoDealReason};
	var currency =${currency};
	var contact =${contact};
	var costReceiver = ${costReceiver};
	var paymentMethod = [{ id: 0, text: '一期' }, { id: 1, text: '两期' },{ id: 2, text: '三期' }, { id: 3, text: '四期' },{ id: 4, text: '五期' }]
	var financeItem = ${financeItem};
	var financeAccount = ${financeAccount};

	//接收联系方式
	var contactData=${contact};
	//接收询单未成行原因
	var reasonNodeal=${reasonNodeal};
	
	for(var i=0;i<5;i++){
		$("#tr_"+i).hide();
	}
	
	
	
 	$("#level").select2({
        data: level
    });
	
	//货币种类下拉框
 	$(".currency-select").select2({
 		 placeholder: '货币种类',
        data: currency
    });
	
	$("#gender").select2({
        data: genderData
    });  
    
    $(".destination-select").select2({
        placeholder: '国家',
        data: country
    }); 
	
    $(".costReceiver-select").select2({
    	placeholder:"签约乙方",
    	data:costReceiver,
    	allowClear:true
    });
    
    $(".paymentMethod-select").select2({
    	placeholder:"分几期付款",
    	data:paymentMethod,
    	allowClear:true
    });
    
    $(".financeItem-select").select2({
    	placeholder:"款项",
    	data:financeItem,
    	allowClear:true
    });

    $(".language-select").select2({
    	placeholder: '选择一个沟通语言',
     	data: language
    });
    $(".contact-select").select2({
    	placeholder: '可多选',
    	minimumResultsForSearch: Infinity,
    	data: contact

     });

    $(".contact-select").val('${crmcase.contactType}'.split(",")).trigger("change");
      
    $(".contact-select-country").select2({
    	placeholder: '可多选',
    	minimumResultsForSearch: Infinity,
    	data: country
     });
    $(".contact-select-country").val('${crmcase.destination}'.split(",")).trigger("change");

    //循环去除数组中元素的空格
    var temp='${crmcase.contactType}'.split(",");
    var value=[];
    $.each(temp,function(index,item){
    	value.push(item.trim());
    	
    })
    
    //给select2赋值
    $(".contact-select").val(value).trigger("change");
    
    //选择真实的联系方式
    $(".contact-real-select").select2({
        placeholder: '选择真实联系方式',
        data: contactData
     });
    $(".contact-real-select").val('${crmcase.contactReal}').trigger("change");

    
    $(".withwho-select").select2({
    	placeholder: '与谁同行',
     	data: withwho
    });
    $(".hotel-select").select2({
       placeholder: '选择一个住宿方式',
       data: hotel
    });
    $(".meals-select").select2({
       placeholder: '选择一个',
       data: meals
    });
    $(".guide-select").select2({
       placeholder: '选择一个',
       data: guide
    });
    $(".status-select").select2({
        data: caseStatus
     });
    $(".status-select").prop("disabled", true);  
    $(".source-select").select2({
      placeholder: '选择一个推广渠道',
      data: source
    });
    $(".tailormade-select").select2({
        placeholder: '选择一个',
        data: tailormade
      });
    $(".passport-select").select2({
        placeholder: '选择一个',
        data: passport
      });
    $(".visa-select").select2({
        placeholder: '选择一个',
        data: visa
      });
    $(".flight-select").select2({
        placeholder: '选择一个',
        data: flight
      });
    $(".customer-select").select2({
        placeholder: '客人',
        data: customer
    });
    $(".user-select").select2({
        placeholder: '跟单员',
        data: user
    });
    if("${crmcase.status}">=2){
		$(".user-select").prop("disabled", true);   
	}
    $(".sales-select").select2({
        placeholder: '销售',
        data: sales
    });
	
    $(".reason-select").select2({
    	placeholder:"无效原因",
    	data:reason
    });
    $(".orderNoDealReason-select").select2({
    	placeholder:"未成行原因",
    	data:orderNoDealReason
    });
    

    
	if("${crmcase.status}"==5){
   	  $("#div-delInfo").show();
   	 };
   	/* 	 设置未成行原因下拉框 开始 */
    	$(".reason-nodeal-select").select2({
     	placeholder:"未成行原因",
     	data:reasonNodeal
     });
    	if("${crmcase.status}"==4){
      	  $("#div-nodealInfo").show();
      	 };
      /*  设置未成行原因下拉框 结束*/
	
       $('.paymentMethod-select').change(function(){
   		//var payMethod = $("#paymentMethod").select2('data')[0].id;
   		var payVal = $("#paymentMethod").val();
   		for(var i=0;i<parseInt(payVal)+1;i++){
   			$("#tr_"+i).show();
   		}
   		for(var i=5;i>parseInt(payVal);i--){
   			$("#tr_"+i).hide();
   		}
    });
      
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
	              	  costBudget: {
	                required: true,
	                number: true
	              },
	              	  costBudgetRmb: {
	                required: true,
	                number: true
	              },
	              	  costReceiver: {
	                required: true
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
		          costBudget: "请输入一个数字",
		          costBudgetRmb: "请输入一个数字",
		          costReceiver: "请输入签约乙方"
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
	        	  var rmbPrice =parseInt($.trim($("input[name=rmbPrice]").val())),
	        	  	priceBudget1 =parseInt($.trim($('#priceBudget1').val())),
	        	  	priceBudget2 =parseInt($.trim($('#priceBudget2').val())),
	        	  	priceBudget3 =parseInt($.trim($('#priceBudget3').val())),
	        	  	priceBudget4 =parseInt($.trim($('#priceBudget4').val())),
	        	  	priceBudget5 =parseInt($.trim($('#priceBudget5').val()));
	        	  if(isNaN(priceBudget1)){priceBudget1 = 0}
	        	  if(isNaN(priceBudget2)){priceBudget2 = 0}
	        	  if(isNaN(priceBudget3)){priceBudget3 = 0}
	        	  if(isNaN(priceBudget4)){priceBudget4 = 0}
	        	  if(isNaN(priceBudget5)){priceBudget5 = 0}
	        	  	var sumPriceBudget = priceBudget1+priceBudget2+priceBudget3+priceBudget4+priceBudget5;
	        	 
	        	  	if(sumPriceBudget==rmbPrice){
	        	  	 $("#form-deal .submit").attr("disabled","disabled");
	  	              deal_submit();
	  	              return false;
	        	  	}
	        	  	else{
	        	  		return false;
	        	  	}
	          
	          } 
	        });
    		//订单未成行
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
		          	$("#form-noDeal .submit").attr("disabled","disabled");
		              noDeal_submit();
		              return false;
		          } 
	        });
    		//询单未成行
   		jQuery("#form-nodeal").validate({
			rules:{
				reasonNodeal: "required"
			},
			messages:{
				reasonNodeal:"请输入未成行原因"
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
				$("#form-nodeal .submit").attr("disabled","disabled");
				nodealSubmit();
			    return false;
			}
		});
   	});
    	
    	function getPriceRecord(){  
	        var args = {};  
	        $("#payTable tr:gt(0)").each(function(i){  
	            var data = new Object();  
	            $(this).find("input").each(function(){  
	                var name = $(this).attr("name");  
	                data[name]= $(this).val();  
	            });  
	            args[i]=data;  
	        });  
	        return JSON.stringify(args);  
	    }  
    	
      //订单成行
    	function deal_submit() {
			var f = $("#form-deal").serialize();
			var jsonStr = getPriceRecord();
			$.post('${rootPath}order/orderDeal.do', $.param({'priceRecord':jsonStr})+'&'+f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";
				} 
				else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
			
		}
      //订单未成行
    	function noDeal_submit() {
			var f = $("#form-noDeal").serialize();
			$.post('${rootPath}order/orderNoDeal.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";
				} 
				else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}	
   	
	//订单回显数据
  	var orderTable = jQuery('#dataTable-order').DataTable({
  		searching:false,
  		paging: false,
	 	processing: true,
	 	language: datatable_local_language, // my.js
	 	serverSide: true,
	 	bInfo:false,
	 	ajax: {
	 		url: '${rootPath}order/listByCaseId.do?caseId=${crmcase.caseId}',
	 		dataFilter: function(data){
	             var json = jQuery.parseJSON( data );
	             json.recordsTotal = json.countTotal;
	             json.recordsFiltered = json.countFiltered;  
	             json.data = json.data;
	             return JSON.stringify( json );
	         }
	 	},
	 	columnDefs: [
				 	  {//客人姓名<br>ID
				 		  orderable: false,
				 		  render:function ( data, type, full, meta ){
				 			  return full.customerName+"<br>"+full.orderId;
				 		  },
				 	      targets: 0
				 	  },
				 	  {//地接社<br>销售
				 		  orderable: false,
				 		  render:function ( data, type, full, meta ){
				 			  return full.agencyName+"<br>"+full.salesName;
				 		  },
				 	      targets: 1
				 	  },
						 {//目的地<br>状态
			                orderable: false,
			                render: function ( data, type, full, meta ) {
		                	 if(full){
			                	var des=data.split(",");
			                	var destinations="";
			                	for(var j = 0;j<des.length;j++){
			                	
			                		for(var i=0;i <country.length;i++){
				                		if(des[j]==country[i].id){
				                			destinations+=country[i].text+",";
				                		}				                	
				                	}
			                	}
			                	
			                	destinations=destinations.substring(0,destinations.length-1);
			                	var orderStatusText="";
			                	for(var i=0;i < orderStatus.length;i++){
			                		if(full.status==orderStatus[i].id){
			                			orderStatusText= orderStatus[i].text;
			                		
			                		}
			                	}
		                		return destinations+"<br>"+orderStatusText;
		                	}
		                	else{
		                			return "";
		                		}
		                },
	                    targets: 2
						},
						{//成团人数
							data: "groupNumber",
			                orderable: false,
			                render: function ( data ) {
			                	if(data){
				                	return data;
			                	}
			                	else{return ""}
			                },
			                  targets: 3
						},
						{//成团金额
			                orderable: false,
			                render: function ( data, type, full, meta )  {
			                	
			                	return full.currency+full.groupPrice+"<br>￥"+full.rmbPrice;
			                },
			                  targets: 4
						},
						{//出发日期<br>返回日期
			                orderable: false,
			                render: function ( data, type, full, meta )  {
			                	if(full.startDate&&full.endDate){
			                		return new Date(full.startDate.time).format("yyyy-MM-dd")+"<br>"+new Date(full.startDate.time).format("yyyy-MM-dd");
			                	}
			                	return "";
			                },
			                  targets: 5
						},
						{//跟单员
							data:"operator",
							orderable: false,
			                render: function ( data, type, full, meta  )  {
			                	for(var i=0;i<user.length;i++){
			                		if(data==user[i].id){
			                			return user[i].text;
			                		}
			                	}
			                	return "";
			                },
			                  targets: 6
						}
						,
						{
			                data: "creatTime",
			                orderable: false,
			                render: function ( data ) {
			                	if(data){
			                		return new Date(data.time).format("yyyy-MM-dd hh:mm:ss");
			                	}
			                	else{return ""}
			                },
			                  targets: 7
						},
						{
			                data: "lastResponse",
			                orderable: false,
			                render: function ( data ) {
			                	if(data){
			                		return new Date(data.time).format("yyyy-MM-dd hh:mm:ss");
			                	}
			                	else{return ""}
			                },
			                  targets: 8
						}, 
						{
					          data: "orderId",
					 	      orderable: false,
					 	      render: function ( data, type, full, meta ) {
				              	return '<a name="btnEdit" class="btn btn-default btn-xs" id="'+data+
				              	'"><span class="fa fa-edit"></span> 编辑</a>&nbsp<a name="btnDeal" class="btn btn-success btn-xs" id="'+data+
				              	'"> 成行</a>&nbsp<a name="btnNoDeal" class="btn btn-warning btn-xs" id="'+data+
				              	'">未成行</a>&nbsp<a name="btnSendEmail" class="btn btn-primary btn-sendMaile btn-xs" id="'+data+
				              	'"> 发订单邮件</a>';
					 	  	  },
					 	    	targets: 9
					 	}
				 	  
				 	],
	 	columns: [
            { data: "orderId" },
            { data: "agencyName" },
            { data: "destination" },
            { data: "groupNumber"},
            { data: "groupPrice"},
            { data: "startDate"},
            { data: "operator"},
            { data: "creatTime"}, 
	 		 { data: "lastResponse"}
        ]
	});
	
	//询单效验数据，修改
	jQuery("#form-case").validate({      
          rules: {
            adult: "digits",
            children: "digits",
            baby: "digits",
            budget: "digits",
            startDate: "date",
            endDate: "date",
            startMonth: "date",
            during: "digits",
            destination: "required",
            contactReal: "required",
          },
          messages: {
            adult: "请输入一个整数",
            children: "请输入一个整数",
            baby: "请输入一个整数",
            budget: "请输入一个整数",
            startDate: "请输入正确的日期格式 mm/dd/yyyy",
            endDate: "请输入正确的日期格式 mm/dd/yyyy",
            startMonth: "请输入正确的日期格式 mm/dd/yyyy",
            during: "请输入一个整数",
            destination:"请选择目的地",
            contactReal:"请选择沟通方式",
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
          	$("#form-case .submit").attr("disabled","disabled");
            case_submit();
            return false;
          }
      });
      
  	  function case_submit(){
  			$(".user-select").prop("disabled", false);
  			$(".status-select").prop("disabled", false);
   			var f = $("#form-case").serialize();
   			$.post('${rootPath}case/edit.do', f, function(result) {
   				var rmsg = result.msg;
   				if (result.success) {
   					window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";
   				} else {
   					$("#msgModal").modal('show');
   				}
   			}, "JSON");
  		}
	  
	   //询单返回
  	  $("#btn-back").click( function () {
  		window.location = "${rootPath}case/list.html?flag=old";
  	  });  	  
	   
      //询单无效
      $("#btn-invalid").click(function(){
      	 $(".confirmDelModal").modal('show');
		 return false;
      });
      
     /*  $("#btn-confirmpay").click(function(){
    	  confirmpaySubmit();
      }) */
      
      $(".confirmDelModal .cancel").click(function(){
      	$(".confirmDelModal").modal("hide");
  	  });

      jQuery("#form-del").validate({
			rules:{
				reason: "required"
			},
			messages:{
				reason:"请输入无效原因"
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
				$("#form-del .submit").attr("disabled","disabled");
				delSubmit();
			    return false;
			}
		});
     
 
      //订单为未成行
      $("#btn-nodeal").click(function(){
      	 $(".confirmNoDealModal").modal('show');
		 return false;
      });
      //设置取消键隐藏
      $(".confirmNoDealModal .cancel").click(function(){
        	$(".confirmNoDealModal").modal("hide");
    	  });
 	
	  //添加订单

      $("#btn-addorder").click(function(){
      	  var destination = $("#destination").val();
      	  $("#englishDestination").val(destination);
      	  if(destination=="" || destination == null){
      	  	$("#msgDestination").modal('show');
 		  }else{ 
      			var destinationText;
      			for(var i=0; i<$("#destination").select2('data').length; i++){
      				if(destinationText==null){
      					destinationText = $("#destination").select2('data')[i].text + ",";
      				}else{
      					destinationText = destinationText + $("#destination").select2('data')[i].text + ",";
      				}
      			}
      			var destinationText = destinationText.substring(0,destinationText.length-1);

      	  		$("#orderDestinationText").val(destinationText); 
      	  		$("#orderDestination").val(destination);

	      	  	$.ajax({
	              type: "post",
	              url: "${rootPath}case/getSales.do?destination="+destination,
	              data: destination,
	              success: function(sales){
	            	  var json = jQuery.parseJSON(sales);
	                  $("#salesId").select2({	
	                      placeholder: '销售',
	                      data: json
	                  });
	              }  
	            });  
      	  	    $("#nextModal").modal('show');         	         	  
      	    }  
            return false;
        });
      
        $("#nextModal .submit").click(function(){
          $(this).attr("disabled","disabled");
      	  order_submit();
        });  
      
      function order_submit() {
		var f = $("#form-order").serialize();
		$.post('${rootPath}order/add.do', f, function(result) {
			var rmsg = result.msg;
			if (result.success) {
				window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";
			} else {
				if(result.text=="noCustomerEmail"){
					alert("分配地接社成功，由于客人没有邮箱，无法发送订单邮件");
					$('#nextModal').modal('hide');
					window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";
				}
				else if(result.text=="noSaleEmail"){
					alert("分配地接社成功，由于销售没有邮箱，无法发送订单邮件");
					$('#nextModal').modal('hide');
					window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";

				}
				else if(result.text=="noSendmail"){
					alert("分配地接社成功，由于地接社设置为不发送邮件，所以未发送订单邮件");
					$('#nextModal').modal('hide');
					window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";
				}
				//$("#NoEmail").modal('show');
         		//$("#nextModal").modal('hide');
         		else {window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";}
			}
		}, "JSON");
      }
    //询单无效
      function delSubmit() {
    	  var f1=$("#form-del").serialize();
     	  try{
     		  $.post("${rootPath}case/del.do", f1, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.location = "${rootPath}case/list.html?flag=old";
				} 
				else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
     		  }
     	  catch(e) {
     		  alert(e);
     	  }
      }
      //询单未成行
      function nodealSubmit() {
    	  var f1=$("#form-nodeal").serialize();
     	  try{
     		  $.post("${rootPath}case/nodeal.do", f1, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";
				} 
				else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
     		  }
     	  catch(e) {
     		  alert(e);
     	  }
      }
      
      /* function confirmpaySubmit() {
    	  $(".user-select").prop("disabled", false);
    	  $(".status-select").prop("disabled", false);
 			var f = $("#form-case").serialize();
 			$.post('${rootPath}case/confirmPay.do', f, function(result) {
 				var rmsg = result.msg;
 				if (result.success) {
 					window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";
 				} else {
 					$("#msgModal").modal('show');
 				}
 			}, "JSON");
      } */
      
      
      //进入订单编辑页面
		 $('#dataTable-order tbody').on( 'click', 'a[name=btnEdit]', function () {
	         var data = orderTable.row($(this).parents('tr')).data();
	         edit($(this).attr('id'));
	     } );
		
		 $('#dataTable-order tbody').on( 'click', 'a[name=btnDeal]', function () {
	         var data = orderTable.row($(this).parents('tr')).data();
	         group($(this).attr('id'));
	         $("#dealOrderId").val($(this).attr('id'));
	     } );

		 $('#dataTable-order tbody').on( 'click', 'a[name=btnNoDeal]', function () {
	         var data = orderTable.row($(this).parents('tr')).data();
	         nogroup($(this).attr('id'));
	         $("#noDealOrderid").val($(this).attr('id'));
	     } );
		 
		 $('#dataTable-order tbody').on( 'click', 'a[name=btnSendEmail]', function () {
	         var data = orderTable.row($(this).parents('tr')).data();
	         sendOrderEmail(data);  
	     } );
		 
	     function edit(id) {
			window.parent.location = "${rootPath}order/edit.html?id="+id;
		 }	
	    
	     function group(id) {
			$(".dealModal").modal('show');
		}
		
		function nogroup(id) {
			$("#noDeal-orderId").val(id);
			$("#noDeal-objectId").val(id);
			$(".noDealModal").modal('show');
		}
	    $(".dealModal .cancel").click(function(){
	    	$(".dealModal").modal('hide');
	    });
	    $(".noDealModal .cancel").click(function(){
	    	$(".noDealModal").modal('hide');
	    })
	    //日期控件
	    jQuery(".datepicker").datepicker({
        dateFormat: "yy-mm-dd",
        changeYear: true,
        changeMonth: true,
        minDate: 0
     	});
		//判断客人是否有邮箱  有的话发送邮件 没有的话绑定邮箱
		function sendOrderEmail(data){
			if(data.customerEmailReal!=null&&data.customerEmailReal!=""){
				//alert(data.customerReEmailAlias);
				if(data.customerReEmailAlias!=null){
					var f = data.orderId;
					console.log(f);
					$.post('${rootPath}order/orderSendEmail.do', {"orderId":f}, function(result) {
						var rmsg = result.msg;
						if (result.success) {
							//window.parent.location = "${rootPath}order/list.html";
							alert("邮件发送成功");
						} 
						else {
							alert("邮件发送失败，请检查地接社是否允许发邮件");
						}
					}, "JSON");
				}else{
					var f = data.orderId;
					console.log(f);
					$.post('${rootPath}order/orderSendEmailNoAlias.do', {"orderId":f}, function(result) {
						var rmsg = result.msg;
						if (result.success) {
							//window.parent.location = "${rootPath}order/list.html";
							alert("邮件发送成功了");
						} 
						else {
							alert("邮件发送失败，请检查地接社是否允许发邮件");
						}
					}, "JSON");
				}
			}else{
				$("#NoEmail").modal('show');
				var newHref = "../customer/edit.html?id="+data.customerId
				$('#addEmail').attr("href",newHref)
			}
		}
		  
  		
		//沟通记录   回显
  		var recordTable = jQuery('#dataTable-record').DataTable({
  				searching:false,
    			pageLength: 10,
    			processing: true,
    			language: datatable_local_language, // my.js
    			serverSide: true,
    			ajax: {
      				url: '${rootPath}record/list.case?caseId=${crmcase.caseId}',
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
   		  			    { data: "orderRecordId" },
   		  			    { data: "senderName" },
   		  			    { data: "content" },
   		  			    { data: "creatTime" }
    		    ]
  		});
		
	   //注释 ~ 回显，效验，添加
   		var commentTable= jQuery('#dataTable-comment').DataTable({
   			searching:false,
   			paging:false,
			/* pageLength: 10, */
			processing: true,
			language: datatable_local_language, // my.js
			serverSide: true,
			bInfo:false,
			ajax: {
  				url: '${rootPath}comment/list.do?type=case&id=${crmcase.caseId}',
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
     			    { data: "commentId" },
     			    { data: "userName" },
     			    { data: "content" },
     			    { data: "creatTime" }
     			]
 		});
  		
      jQuery("#form-comment").validate({
          rules: {
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

  		function comment_submit() {
   			var fcomment= $("#form-comment").serialize();
   			$.post('${rootPath}comment/add.do', fcomment, function(result) {
     				var rmsg = result.msg;
     				if (result.success) {
     					window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";
     				} 
     				else {
     					$("#msgModal").modal('show');
     				}
   			}, "JSON");
  		}


  jQuery(document).ready(function() {
      // Select2
      jQuery('select').select2({
          minimumResultsForSearch: -1
      });
      jQuery('select').removeClass('form-control');

      $(".nav-parent").eq(0).addClass("nav-active");
      $(".nav-parent").eq(0).find(".children").show();
        
      // Date Picker
      jQuery("#startMonth").datepicker({
        dateFormat: "yy-mm-dd",
        changeYear: true,
        changeMonth: true,
        minDate: 0
      });
      $("#startDate").datepicker({
        dateFormat: "yy-mm-dd",
        changeYear: true,
        changeMonth: true,
        minDate: 0
      });
      $("#endDate").datepicker({
        dateFormat: "yy-mm-dd",
        changeYear: true,
        changeMonth: true,
        minDate: 0
      });

      //大约时间格式转换
      var date = $("#startMonth").val();  
      if(date !== ""){
        var dateformat = new Date(date).toISOString("yyyy-MM-dd hh:mm:ss.S").substring(0,10);
        $("#startMonth").val(dateformat);
      }
      
      //大约时间格式转换
      var date = $("#startDate").val(); 
      if(date !== ""){
        var dateformat = new Date(date).toISOString("yyyy-MM-dd hh:mm:ss.S").substring(0,10);
        $("#startDate").val(dateformat);
      }
      
      //大约时间格式转换
      var date = $("#endDate").val(); 
      if(date !== ""){
        var dateformat = new Date(date).toISOString("yyyy-MM-dd hh:mm:ss.S").substring(0,10);
        $("#endDate").val(dateformat);
      }
  	  

  	  if("${crmcase.startTime}"==1){
    	   $('#yes').attr('checked','true');
      }
      if("${crmcase.startTime}"==0){
    		$('#no').attr('checked','true');
      }
  	  
      $("input[name='startTime']").change(function() {
          var val = $("input[name='startTime']:checked").val();
          if (val == 1) {
              $(".start-time").hide();
              $(".start-date").show();
          }else{
              $(".start-date").hide();
              $(".start-time").show();
          }
      });
      var start = ${crmcase.startTime};
      if (start == 1) {
          $(".start-time").hide();
          $(".start-date").show();
      }else{
          $(".start-date").hide();
          $(".start-time").show();
      }

  });
	</script>
</body>
</html>
