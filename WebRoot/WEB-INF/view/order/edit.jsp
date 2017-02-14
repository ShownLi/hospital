<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../assets/pages/head.jsp"%>
<link href="${rootPath }assets/css/jquery.datatables.css" rel="stylesheet">
</head>

<body onload="load()">
	<%@ include file="../assets/pages/preloader.jsp"%>
	<section>
		<%@ include file="../assets/pages/leftpanel.jsp"%>
		<div class="mainpanel">
			<%@ include file="../assets/pages/headerbar.jsp"%>
			<div class="pageheader">
				<h2>
					<i class="glyphicon glyphicon-briefcase"></i> 订单管理 <span>编辑订单</span>
				</h2>
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
                      <label class="col-sm-4 control-label">状态</label>
                      <div class="col-sm-8">
                        <input type="text" name="status" placeholder="状态" disabled="disabled" class="status-select fullwidth" readonly value="${order.status}" />
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
      <div class="panel panel-default" id="dealInfo" style="display:none">
          <div class="panel-heading">

              <div class="panel-btns">
                  <a href="" class="minimize">&minus;</a>
              </div>
              <h4 class="panel-title">成行信息</h4>
          </div>
          <div class="panel-body panel-body-nopadding">
              <form id="form-updateDeal" class="form-horizontal form-updateDeal"  style="display: none">
                  <div class="section-block">
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">成团日期</label>
                          <div class="col-sm-8 input-group input-datepicker">
                            <input type="text" id="groupTime" name="groupTime" class="form-control datepicker" value="${order.groupTime}" placeholder="mm/dd/yyyy" autocomplete="off" />
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
                      
		                      <div class="form-group col-sm-6">
		                      <label class="col-sm-4 control-label">成团成本<span class="asterisk">*</span></label>
		                      <div class="col-sm-8">
		                        <input type="text" name="costBudget" value="${order.costBudget}" placeholder="成团成本" class="form-control"/>
		                      </div>
		                 	 </div>
                 	 
                      <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">成团价格</label>
                          <div class="col-sm-8">
                            <input type="text" name="groupPrice" value="${order.groupPrice}" placeholder="成团价格" class="form-control"/>
                          </div>
                      </div>
		              <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">成团币种</label>
                          <div class="col-sm-8">
                            <input type="text" name="currency" value="${order.currency}" placeholder="货币种类" class="currency-select fullwidth"/>
                          </div>
                      </div>    	  
                  	  <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">汇率</label>
                          <div class="col-sm-8">
                            <input type="text" name="exchangeRate" value="${order.exchangeRate}" placeholder="汇率" class="form-control" />
                          </div>
                      </div>
                      
		                      <div class="form-group col-sm-6">
		                      <label class="col-sm-4 control-label">人民币成本<span class="asterisk">*</span></label>
		                      <div class="col-sm-8">
		                        <input type="text" name="costBudgetRmb" value="${order.costBudgetRmb}" placeholder="人民币成本" class="form-control"/>
		                      </div>
		                 	  </div>
		                 	  
                  	  <div class="form-group col-sm-4">
                          <label class="col-sm-4 control-label">人民币价格</label>
                          <div class="col-sm-8">
                            <input type="text" name="rmbPrice" value="${order.rmbPrice}" placeholder="人民币价格" class="form-control"/>
                          </div>
                      </div>
                      
		                      <div class="form-group col-sm-6">
		                      <label class="col-sm-4 control-label">签约乙方<span class="asterisk">*</span></label>
		                      <div class="col-sm-8">
		                        <input type="text" name="costReceiver" value="${order.costReceiver}" placeholder="签约乙方" class="costReceiver-select fullwidth"/>
		                      </div>
		                 	  </div>
                      <div class="form-group col-sm-4">
                      <div class="col-sm-6"></div>
                   		<input type="submit" class="submit btn btn-primary" value="更改"/>
                      	</div>
                  </div>
                  <input type="hidden" name="orderId" value="${order.orderId}" />
                  <input type="hidden" name="caseId" value="${order.caseId}" />	
                  <input type="hidden" name="customerId" value="${order.customerId}" />	
              </form> 

              <form id="form-updateNoDeal" class="form-horizontal">

                  <div class="section-block">
                      <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">未成行原因</label>
                        <div class="col-sm-6">
                          <input class="reason-select fullwidth" name="reason" value="${order.reason}" placeholder="若未成行，原因是" />
                        </div>
                    	<button class="btn btn-primary">更改</button>
                      </div>
                  </div><!-- panel-body -->
                      <input type="hidden" name="orderId" value="${order.orderId}" />	
                      <input type="hidden" name="caseId" value="${order.caseId}" />
              </form> 
          </div>
      </div><!-- end of panel 是否成行 -->
      
       <div class="panel panel-default">
          <div class="panel-heading">
          <div class="panel-btns">
              <a href="" class="minimize">&minus;</a>
          </div>
          <h4 class="panel-title">收款记录</h4>
          </div>
          <div class="panel-body">
              <div class="table-responsive">
                  <table id="dataTable-priceRecord" class="table table-communicate">
                    <thead>
                      <tr>
                        <th>收款编号</th>
                        <th>款项</th>
                        <th>应收金额</th>
                        <th>收款截止日期</th>
                        <th>实收金额</th>
                        <th>收款账户</th>
                        <th>收款日期</th>
                      	<th>状态</th>
                      	<th>备注</th>
                        <th>操作</th>
                      </tr>
                    </thead>
                    <tbody>
                    </tbody>
                  </table>
                  <button id="addPriceRecord" class="btn btn-primary" >添加应收</button>
                </div>
                <!-- table-responsive -->
                
          </div>
          
      </div><!-- end of panel 收款记录 -->
      
      
       <div class="panel panel-default">
          <div class="panel-heading">
          <div class="panel-btns">
              <a href="" class="minimize">&minus;</a>
          </div>
          <h4 class="panel-title">付款记录</h4>
          </div>
          <div class="panel-body">
              <div class="table-responsive">
                  <table id="dataTable-costRecord" class="table table-communicate">
                    <thead>
                      <tr>
                        <th>付款ID</th>
                        <th>供应商</th>
                        <th>款项</th>
                        <th>应付金额</th>
                        <th>实付金额</th>
                        <th>付款日期</th>
                      	<th>状态</th>
                      	<th>备注</th>
                        <th>操作</th>
                      </tr>
                    </thead>
                    <tbody>
                    </tbody>
                  </table>
                  <button id="addCostRecord" class="btn btn-primary" >添加付款</button>
                </div>
                <!-- table-responsive -->
          </div>
      </div><!-- end of panel 收款记录 -->
      
      
      
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
                  <table id="dataTable-record" class="table">
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
			          <div class="form-group col-sm-12 align-center" id="addNoteDiv">
						<input class="btn btn-primary" type="button" id="addNote" onclick="showNote()" value="添加注释"/>
					</div>
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
  <div class="modal-dialog" style="width:880px;">
    <div class="modal-content">         
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">请填写以下订单信息</div>
      </div>

      <form class="form-horizontal" id="form-deal">
      <div class="modal-body">
              <div class="section-block noline">
                  <div class="form-group col-sm-4" style="margin-left: 0; margin-right: 0;">
                      <label class="col-sm-4 control-label">成团日期<span class="asterisk">*</span></label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input type="text" name="groupTime" class="form-control datepicker" autocomplete="off" placeholder="成团日期">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                  </div>
                   <div class="form-group col-sm-4" style="margin-left: 0; margin-right: 0;">
                      <label class="col-sm-4 control-label">成团人数<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="groupNumber" placeholder="成团人数" class="form-control"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-4" style="margin-left: 0; margin-right: 0;">
                      <label class="col-sm-4 control-label">出发日期<span class="asterisk">*</span></label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input type="text" name="startDate" placeholder="出发日期" class="form-control datepicker" autocomplete="off" />
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                  </div>
                  <div class="form-group col-sm-4" style="margin-left: 0; margin-right: 0;">
                    <label class="col-sm-4 control-label">返回日期<span class="asterisk">*</span></label>
                    <div class="col-sm-8 input-group input-datepicker">
                      <input type="text" name="endDate" placeholder="返回日期" class="form-control datepicker" autocomplete="off" />
                      <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                    </div>
                  </div>
                  <div class="form-group col-sm-4" style="margin-left: 0; margin-right: 0;">
                      <label class="col-sm-4 control-label">成团成本<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="costBudget" placeholder="成团成本" class="form-control"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-4" style="margin-left: 0; margin-right: 0;">
                      <label class="col-sm-4 control-label">成团价格<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="groupPrice" placeholder="成团价格" class="form-control" />
                      </div>
                  </div>
                  <div class="form-group col-sm-4" style="margin-left: 0; margin-right: 0;">
                      <label class="col-sm-4 control-label">成团币种<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="currency" placeholder="成团币种" class="currency-select fullwidth"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-4" style="margin-left: 0; margin-right: 0;">
                      <label class="col-sm-4 control-label">汇率<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="exchangeRate" placeholder="汇率" class="form-control" value="" />
                      </div>
                  </div>
                  <div class="form-group col-sm-4" style="margin-left: 0; margin-right: 0;">
                      <label class="col-sm-4 control-label">人民币成本<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="costBudgetRmb" placeholder="人民币成本" class="form-control"/>
                      </div>
                  </div>
                   <div class="form-group col-sm-4" style="margin-left: 0; margin-right: 0;">
                      <label class="col-sm-4 control-label">人民币价格<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" id="rmbPrice" name="rmbPrice" placeholder="人民币价格" class="form-control"/>
                        <span class="rmbpriceErrorMsg" style="color: #b94a48; display: none; font-size: 14px;">人民币价格与应收金额之和应该相同</span>
                      </div>
                  </div>
                  <div class="form-group col-sm-4" style="margin-left: 0; margin-right: 0;">
                      <label class="col-sm-4 control-label">签约乙方<span class="asterisk">*</span></label>
                      <div class="col-sm-8">
                        <input type="text" name="costReceiver" placeholder="签约乙方" class="costReceiver-select fullwidth"/>
                      </div>
                  </div>
                  <div class="form-group col-sm-4" style="margin-left: 0; margin-right: 0;">
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
                  <input type="hidden" name="agencyId" value="${order.agencyId}" />	
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
                    </div>
                  </div>
                  <div class="form-group col-sm-12">
                  <label class="col-sm-4 control-label">备注</label>
                    <div class="col-sm-8">
                      <textarea name="content" class="form-control" rows="5"></textarea>
                    </div>
                  </div>
                  <input type="hidden" name="orderId" value="${order.orderId}" />	
                  <input type="hidden" name="caseId" value="${order.caseId}" />		                     
                  <input type="hidden" name="status" value="3" />
                  <input  type="hidden" name="userId" value="${loginUser.userId}" />
	              <input  type="hidden" name="userName" value="${loginUser.name}" />
	              <input  type="hidden" name="objectId" value="${order.orderId}" />
	              <input  type="hidden" name="commentType" value="order" />
              </div>
          </div>
          <div class="modal-footer align-center">
            <button class="btn btn-primary" >保存</button> 
            <a class="cancel btn btn-primary" >取消</a>
          </div>
      </form>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- bmodal -->


<!-- 新增应收 -->
<div class="addPriceRecordModal modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">添加应收</div>
      </div>
      <form class="form-horizontal" id="form-addPriceRecord">
          <div class="modal-body">     
              <div class="section-block noline">
                  <div class="form-group col-sm-12">
                    <label class="col-sm-4 control-label">收款账户</label>
                    <div class="col-sm-8">
                      <input class="financeAccount-select fullwidth" name="account" placeholder="收款账户" />
                    </div>
                    <label class="col-sm-4 control-label">款项</label>
                    <div class="col-sm-8">
                      <input class="financeItem-select fullwidth" name="paymentItem" placeholder="款项" />
                    </div>
                    <label class="col-sm-4 control-label">应收金额</label>
                    <div class="col-sm-8">
                      <input class="form-control" name="priceBudget" placeholder="应收金额" />
                    </div>
                    <label class="col-sm-4 control-label">收款截止日期</label>
                    <div class="col-sm-8">
                      <input type="text" name="deadline" placeholder="收款截止日期" class="form-control datepicker" autocomplete="off" />
                    </div>
                    <label class="col-sm-4 control-label">备注</label>
                    <div class="col-sm-8">
                      <input type="text" name="comment" placeholder="备注" class="form-control"/>
                    </div>
                    
                      <input type="hidden" name="orderId" value="${order.orderId}" />	
                     
                  </div>
              </div><!-- noDealModal-body -->
          </div>
          <div class="modal-footer align-center">
            <input class="submit btn btn-primary" type="submit" value="保存"/>
            <a class="cancel btn btn-primary" >取消</a>
          </div>
      </form>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- bmodal -->

<!-- 新增付款 -->
<div class="addCostRecordModal modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">添加应付</div>
      </div>
      <form class="form-horizontal" id="form-addCostRecord">
          <div class="modal-body">     
              <div class="section-block noline">
                  <div class="form-group col-sm-12">
                    <label class="col-sm-4 control-label">供应商</label>
                    <div class="col-sm-8">
                      <input class="agency-select fullwidth" name="agencyId" placeholder="供应商" />
                    </div>
                    <label class="col-sm-4 control-label">款项</label>
                    <div class="col-sm-8">
                      <input class="financeItem-select fullwidth" name="paymentItem" placeholder="款项" />
                    </div>
                    <label class="col-sm-4 control-label">应付金额</label>
                    <div class="col-sm-8">
                      <input class="form-control" name="costBudget" placeholder="应付金额" />
                    </div>
                    <label class="col-sm-4 control-label">备注</label>
                    <div class="col-sm-8">
                      <input type="text" name="comment" placeholder="备注" class="form-control"/>
                    </div>
                      <input type="hidden" name="orderId" value="${order.orderId}" />	
                     
                  </div>
              </div><!-- noDealModal-body -->
          </div>
          <div class="modal-footer align-center">
            <input class="submit btn btn-primary" type="submit" value="保存"/>
              <a class="cancel btn btn-primary" >取消</a>
          </div>
      </form>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- bmodal -->

<!-- 更新应收 -->
<div class="updatePriceRecordModal modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">编辑应收</div>
      </div>
      <form class="form-horizontal" id="form-updatePriceRecord">
          <div class="modal-body">     
              <div class="section-block noline">
                  <div class="form-group col-sm-12">
                    <label class="col-sm-4 control-label">收款账户</label>
                    <div class="col-sm-8">
                      <input class="financeAccount-select fullwidth" id="prAccount" name="account" placeholder="收款账户" />
                    </div>
                    <label class="col-sm-4 control-label">款项</label>
                    <div class="col-sm-8">
                      <input class="financeItem-select fullwidth" id="prPaymentItem" name="paymentItem" placeholder="款项" />
                    </div>
                    <label class="col-sm-4 control-label">应收金额</label>
                    <div class="col-sm-8">
                      <input class="form-control" id="prPriceBudget" name="priceBudget" placeholder="应收金额" />
                    </div>
                    <label class="col-sm-4 control-label">收款截止日期</label>
                    <div class="col-sm-8">
                      <input type="text" id="prDeadline" name="deadline" placeholder="收款截止日期" class="form-control datepicker" autocomplete="off" />
                    </div>
                    <label class="col-sm-4 control-label">备注</label>
                    <div class="col-sm-8">
                      <input type="text" id="prComment" name="comment" placeholder="备注" class="form-control"/>
                    </div>
                    
                      <input type="hidden" name="orderId" value="${order.orderId}" />	
                      <input type="hidden" id="prPriceCode" name="priceCode" value="" />	
                      <input type="hidden" id="prPriceId" name="priceId" value="" />	
                  </div>
              </div><!-- noDealModal-body -->
          </div>
          <div class="modal-footer align-center">
               <!-- <button class="submit btn btn-primary">保存</button>-->
            <input class="submit btn btn-primary" type="submit" value="保存"/>

            <!--   <button class="btn btn-primary" onclick="form2_submit()">保存</button> -->
              <a class="cancel btn btn-primary" >取消</a>
          </div>
      </form>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- bmodal -->

<!-- 更新应付 -->
<div class="updateCostRecordModal modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">编辑应付</div>
      </div>
      <form class="form-horizontal" id="form-updateCostRecord">
          <div class="modal-body">     
              <div class="section-block noline">
                  <div class="form-group col-sm-12">
                    <label class="col-sm-4 control-label">供应商</label>
                    <div class="col-sm-8">
                      <input class="agency-select fullwidth" id="crAgencyId" name="agencyId" placeholder="供应商" />
                    </div>
                    <label class="col-sm-4 control-label">款项</label>
                    <div class="col-sm-8">
                      <input class="financeItem-select fullwidth" id="crPaymentItem" name="paymentItem" placeholder="款项" />
                    </div>
                    <label class="col-sm-4 control-label">应付金额</label>
                    <div class="col-sm-8">
                      <input class="form-control" id="crCostBudget" name="costBudget" placeholder="应收金额" />
                    </div>
                    <label class="col-sm-4 control-label">备注</label>
                    <div class="col-sm-8">
                      <input type="text" id="crComment" name="comment" placeholder="备注" class="form-control"/>
                    </div>
                     
                      <input type="hidden" name="orderId" value="${order.orderId}" />	
                      <input type="hidden" id="crCostId" name="costId" value="" />		
                  </div>
              </div>
          </div>
          <div class="modal-footer align-center">
               <!-- <button class="submit btn btn-primary">保存</button>-->
            <input class="submit btn btn-primary" type="submit" value="保存"/>

            <!--   <button class="btn btn-primary" onclick="form2_submit()">保存</button> -->
              <a class="cancel btn btn-primary" >取消</a>
          </div>
      </form>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- bmodal -->

<!-- PRDelModal -->
<div class="modal fade" id="confirmPRDelModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel"><span class="fa fa-warning"></span> 提示</h4>
      </div>
      <div class="modal-body">
        确定删除么？
      </div>
      <div class="modal-footer">
      	<input type="hidden" id="delPriceId" class="hiddenId" value="" />
        <button class="btn btn-default" data-dismiss="modal">取消</button>
        <input type="button" id="delPriceRecord" class="btn btn-danger" value="删除"/>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->

<!-- CRDelModal -->
<div class="modal fade" id="confirmCRDelModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel"><span class="fa fa-warning"></span> 提示</h4>
      </div>
      <div class="modal-body">
        确定删除么？
      </div>
      <div class="modal-footer">
      	<input type="hidden" id="delCostId" class="hiddenId" value="" />
        <button class="btn btn-default" data-dismiss="modal">取消</button>
        <input type="button" id="delCostRecord" class="btn btn-danger" value="删除"/>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->



<div class="modal fade" id="addNote2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">添加注释信息</div>
      </div>
      <div class="modal-body">
	      <form id="form-comment" class="form row">
	        <div class="form-group col-sm-6 col-sm-offset-3">
	              <textarea name="content" class="addNote form-control" rows="5"></textarea>
	              <input  type="hidden" name="userId" class="addNote" value="${loginUser.userId}" />
	              <input  type="hidden" name="userName" class="addNote" value="${loginUser.name}" />
	              <input  type="hidden" name="objectId" class="addNote" value="${order.orderId}" />
	              <input  type="hidden" name="commentType" class="addNote" value="order" />
	        </div>
	        <div class="form-group col-sm-12 align-center">
	          <input class="addNote btn btn-primary" type="submit" value="保存注释"/>
	          <button type="button" class="addNote btn btn-default" data-dismiss="modal">关闭</button>
	        </div>
        </form>
        </div>
    </div>
  </div>
</div>

	<%-- <!-- Modal 保存注释信息-->
	<div class="modal fade" id="addNote2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">保存注释信息</h4>
				</div>
				<div class="modal-body">
				<form id="form-comment" class="form">
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
	</div> --%>
	<%@ include file="../assets/pages/foot.jsp"%>
  <script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	

<script type="text/javascript">
	function showNote() {
		$("#addNote2").modal('show');
	}

	var orderStatus = ${orderStatus};
	var country = ${country};
	var reason = ${reason};
	var currency = ${currency};
	var costReceiver =  ${costReceiver};
	var paymentMethod = [{ id: 0, text: '一期' }, { id: 1, text: '两期' },{ id: 2, text: '三期' }, { id: 3, text: '四期' },{ id: 4, text: '五期' }]
	var financeItem = ${financeItem};
	var financeAccount = ${financeAccount};
	var priceStatus = ${priceStatus};
	var costStatus = ${costStatus};
	var allAgency = ${allAgency};
	var financeStatus = ${order.financeStatus};

	for(var i=0;i<5;i++){
		$("#tr_"+i).hide();
	}
	
	if('${order.status}'=='2'){
		$("#dealInfo").css("display","block");
		$("#form-updateDeal").css("display","block");
	}
	if('${order.status}'=='3'){
		$("#dealInfo").css("display","block");
		$("#form-updateNoDeal").css("display","block");
	}
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
    
    $(".financeAccount-select").select2({
    	placeholder:"收款账户",
    	data:financeAccount,
    	allowClear:true
    });
    
    $(".financeAccount-select").select2({
    	placeholder:"收款账户",
    	data:financeAccount,
    	allowClear:true
    });
    
    $(".agency-select").select2({
    	placeholder:"供应商",
    	data:allAgency,
    	allowClear:true
    });
     
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
     
	if("${order.status}"==2){
 	  $("#form-updateDeal").show();
 	 $("#form-updateNoDeal").hide();
      $("#btn-baseDeal").attr("disabled",true);
      $("#btn-baseNoDeal").attr("disabled",true);
 	 }
	if("${order.status}"==3){
      $("#form-updateNoDeal").show();
      $("#form-updateDeal").hide();
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
     	  var rmbPrice =parseInt($.trim($("#rmbPrice").val())),
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
     	  	//alert("sumPriceBudget:"+sumPriceBudget+"  "+"rmbPrice"+rmbPrice);
     	  	if(sumPriceBudget==rmbPrice){
     	  	 $("#form-deal .submit").attr("disabled","disabled");
     	  	 $(".rmbpriceErrorMsg").hide();
	              deal_submit();
	              return false;
     	  	}
     	  	else{
     	  		$(".rmbpriceErrorMsg").show();
     	  		return false;
     	  	}
       
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
                $("#form-noDeal button").attr("disabled","disabled");
		              noDeal_submit();
		              return false;
		          } 
	        });
		
		jQuery("#form-updateNoDeal").validate({
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
		        	  updateNoDeal_submit();
		              return false;
		          } 
	        });

		$("#form-addPriceRecord").validate({
	        rules: {
	        	account:{
	            	required: true,
	            	number: true
	            },
	        	paymentItem: {
		        	required: true,
	                number: true
		        },	
		        priceBudget: {
		        	required: true,
	                number: true
		        },
		        deadline:{
	            	required: true
	            },
	            comment:{
	            	required: true
	            }
			},				
	     	 messages: {
	     		priceBudget: '请输入正确的应收金额',	
		        account:'请选择收款账户',
		        deadline:'请选择收款截止日期',
		        comment:'请输入备注'
	      	 },			      
	          highlight: function(element) {
	        	  $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
	          },
	          success: function(element) {
	        	  $(element).closest('.form-group').removeClass('has-error');
	          },
	          invalidHandler : function(){
	            return false;
	          },
	          submitHandler : function(){
	        	  //表单提交
	        	  addPriceRecord_submit();
	              return false;
	          } 
	    });
		
		$("#form-addCostRecord").validate({
	        rules: {
	        	agencyId:{
	            	required: true,
	            	number: true
	            },
	        	paymentItem: {
		        	required: true,
	                number: true
		        },	
		        costBudget: {
		        	required: true,
	                number: true
		        },
	            comment:{
	            	required: true
	            }
			},				
	     	 messages: {
	     		agencyId: '请输入正确的供应商',	
	     		paymentItem: '请输入正确的款项',	
	     		costBudget:'请选择应付金额',
		        comment:'请输入备注'
	      	 },			      
	          highlight: function(element) {
	        	  $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
	          },
	          success: function(element) {
	        	  $(element).closest('.form-group').removeClass('has-error');
	          },
	          invalidHandler : function(){
	            return false;
	          },
	          submitHandler : function(){
	        	  //表单提交
	        	  addCostRecord_submit();
	              return false;
	          } 
	    });
		
		$("#form-updatePriceRecord").validate({
	        rules: {
	        	account:{
	            	required: true,
	            	number: true
	            },
	        	paymentItem: {
		        	required: true,
	                number: true
		        },	
		        priceBudget: {
		        	required: true,
	                number: true
		        },
		        deadline:{
	            	required: true
	            },
	            comment:{
	            	required: true
	            }
			},				
	     	 messages: {
	     		priceBudget: '请输入正确的应收金额',	
		        account:'请选择收款账户',
		        deadline:'请选择收款截止日期',
		        comment:'请输入备注'
	      	 },			      
	          highlight: function(element) {
	        	  $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
	          },
	          success: function(element) {
	        	  $(element).closest('.form-group').removeClass('has-error');
	          },
	          invalidHandler : function(){
	            return false;
	          },
	          submitHandler : function(){
	        	  //表单提交
	        	  updatePriceRecord_submit();
	              return false;
	          } 
	    });
		$("#form-updateCostRecord").validate({
			rules: {
	        	agencyId:{
	            	required: true,
	            	number: true
	            },
	        	paymentItem: {
		        	required: true,
	                number: true
		        },	
		        costBudget: {
		        	required: true,
	                number: true
		        },
	            comment:{
	            	required: true
	            }
			},				
	     	 messages: {
	     		agencyId: '请输入正确的供应商',	
	     		paymentItem: '请输入正确的款项',	
	     		costBudget:'请选择应付金额',
		        comment:'请输入备注'
	      	 },			      
	          highlight: function(element) {
	        	  $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
	          },
	          success: function(element) {
	        	  $(element).closest('.form-group').removeClass('has-error');
	          },
	          invalidHandler : function(){
	            return false;
	          },
	          submitHandler : function(){
	        	  //表单提交
	        	  updateCostRecord_submit();
	              return false;
	          } 
	    });
		$(".nav-parent").eq(1).addClass("nav-active");
   	    $(".nav-parent").eq(1).find(".children").show();
      		
		
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
		bInfo:false,
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
	
	var p = jQuery('#dataTable-priceRecord').DataTable({
		searching:false,
		paging:false,
		processing:true,
		language: datatable_local_language, // my.js
		serverSide:true,
		bInfo : false,
		ajax: {
			url:'${rootPath}finance/getPriceRecordList.do?id=${order.orderId}',
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
						  data: "paymentItem",
						  render: function ( data, type, full, meta ) {
							if(data){
								for(var i=0;i<financeItem.length;i++){
									if(data==financeItem[i].id){
										return financeItem[i].text;
									}
								}
							}
							else return null;
		                },
		                targets: 1
					  },		 
					  {
						  data: "account",
						  render: function ( data, type, full, meta ) {
							if(data){
								for(var i=0;i<financeAccount.length;i++){
									if(data==financeAccount[i].id){
										return financeAccount[i].text;
									}
								}
							}
							else return null;
		                },
		                targets: 5
					  },		 
					  {
						  data: "receivedTime",
						  render: function ( data, type, full, meta ) {
							if(data){
								var receivedTime = new Date(data);
			                    return receivedTime.format("yyyy-MM-dd");
							}
							else return null;
		                },
		                targets: 6
					  },		 
					  {
						  data: "status",
						  render: function ( data, type, full, meta ) {
								if(data){
									for(var i=0;i<priceStatus.length;i++){
										if(data==priceStatus[i].id){
											return priceStatus[i].text;
										}
									}
								}
								else return null;
		                },
		                targets: 7
					  },		 
					  {
						  data: "deadline",
						  render: function ( data, type, full, meta ) {
							  if(data){
								  var deadline = new Date(data);
				                  return deadline.format("yyyy-MM-dd");
							  }
							  else return null;
		                },
		                targets: 3
					  },
					  {
				          data: "orderId",
				 	      orderable: false,
				 	      render: function ( data, type, full, meta ) {
			              	return '<a name="btnEdit" class="btn btn-default btn-xs" id="'+data+
			              	'"><span class="fa fa-edit"></span> 编辑</a>&nbsp<a name="btnDel" class="btn btn-warning btn-xs" id="'+data+
			              	'">删除</a';
				 	  	  },
				 	    	targets: 9
						}
			],
		columns: [
	  			    { data: "priceCode" },
	  			    { data: "paymentItem" },	  			    
	  			    { data: "priceBudget" },
	  			    { data: "deadline" },
	  			    { data: "priceReal" },
	  			    { data: "account" },
	  			    { data: "receivedTime" },
	  			    { data: "status" },
	  			    { data: "comment" }
	    ]
	});
	
	
	    var c = jQuery('#dataTable-costRecord').DataTable({
		searching:false,
		paging:false,
		processing:true,
		language: datatable_local_language, // my.js
		serverSide:true,
		bInfo : false,
		ajax: {
			url:'${rootPath}finance/getCostRecordList.do?id=${order.orderId}',
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
						  data: "agencyId",
						  render: function ( data, type, full, meta ) {
							if(data){
								for(var i=0;i<allAgency.length;i++){
									if(data==allAgency[i].id){
										return allAgency[i].text;
									}
								}
							}
							else return null;
		                },
		                targets: 1
					  },		 
					  {
						  data: "paymentItem",
						  render: function ( data, type, full, meta ) {
							if(data){
								for(var i=0;i<financeItem.length;i++){
									if(data==financeItem[i].id){
										return financeItem[i].text;
									}
								}
							}
							else return null;
		                },
		                targets: 2
					  },		 
					  {
						  data: "payTime",
						  render: function ( data, type, full, meta ) {
							if(data){
								var creatTime = new Date(data.time);
			                    return creatTime.format("yyyy/MM/dd");
							}
							else return null;
		                },
		                targets: 5
					  },		 
					  {
						  data: "status",
						  render: function ( data, type, full, meta ) {
							if(data){
								for(var i=0;i<costStatus.length;i++){
									if(data==costStatus[i].id){
										return costStatus[i].text;
									}
								}
							}
							else return null;
		                },
		                targets: 6
					  },		 
					  {
				          data: "orderId",
				 	      orderable: false,
				 	      render: function ( data, type, full, meta ) {
			              	return '<a name="btnEdit" class="btn btn-default btn-xs" id="'+data+
			              	'"><span class="fa fa-edit"></span> 编辑</a>&nbsp<a name="btnDel" class="btn btn-warning btn-xs" id="'+data+
			              	'">删除</a';
				 	  	  },
				 	    	targets: 8
						}
			],
		columns: [
	  			    { data: "costId" },
	  			    { data: "agencyId" },	  
	  			    { data: "paymentItem" },
	  			    { data: "costBudget" },
	  			    { data: "costReal" },
	  			    { data: "payTime" },
	  			    { data: "status" },
	  			    { data: "comment" }
	    ]
	});  
	  
	
	    $('#dataTable-priceRecord tbody').on( 'click', 'a[name=btnEdit]', function () {
	         var data = p.row($(this).parents('tr')).data();
	         priceRecordEdit(data);
	     } );
		 $('#dataTable-priceRecord tbody').on( 'click', 'a[name=btnDel]', function () {
	         var data = p.row($(this).parents('tr')).data();
	         priceRecordDel(data);
	     } );
	 
	    $('#dataTable-costRecord tbody').on( 'click', 'a[name=btnEdit]', function () {
	         var data = c.row($(this).parents('tr')).data();
	         costRecordEdit(data);
	     } );
		 $('#dataTable-costRecord tbody').on( 'click', 'a[name=btnDel]', function () {
	         var data = c.row($(this).parents('tr')).data();
	         costRecordDel(data);
	     } );
	 
		// Select2
	jQuery('select').select2({
		minimumResultsForSearch: -1
		});
	    
	jQuery('select').removeClass('form-control');
	
	function priceRecordEdit(data){
		 /*   text = "Object ";  
		jQuery.each(data, function(i, val) {  
		    text = text + "Key:" + i + ", Value:" + val;  
		});   
		console.log(text);   */
		$('#prAccount').val(data.account);
		 $(".financeAccount-select").select2({
		    	placeholder:"收款账户",
		    	data:financeAccount,
		    	allowClear:true
		    });
		//$('#prPaymentItem').val(data.paymentItem);
		$("#prPaymentItem").val(new String(data.paymentItem)).trigger("change");
		$(".financeItem-select").select2({
	    	placeholder:"款项",
	    	data:financeItem,
	    	allowClear:true
	    });
		$('#prPriceBudget').val(data.priceBudget);
		$('#prDeadline').val(new Date(data.deadline).format("yyyy-MM-dd hh:mm:ss"));
		$('#prComment').val(data.comment);
		$('#prPriceCode').val(data.priceCode);
		$('#prPriceId').val(data.priceId);
		
		$('.updatePriceRecordModal').modal("show");
	}
	function priceRecordDel(data){
		$('#delPriceId').val(data.priceId);
		$('#confirmPRDelModal').modal("show");
	}
	
	function costRecordEdit(data){
		$('#crAgencyId').val(data.agencyId);
		 $(".agency-select").select2({
		    	placeholder:"供应商",
		    	data:allAgency,
		    	allowClear:true
		    });
		//$('#prPaymentItem').val(data.paymentItem);
		$("#crPaymentItem").val(new String(data.paymentItem)).trigger("change");
		$(".financeItem-select").select2({
	    	placeholder:"款项",
	    	data:financeItem,
	    	allowClear:true
	    });
		$('#crCostBudget').val(data.costBudget);
		$('#crComment').val(data.comment);
		$('#crCostId').val(data.costId);
		
		$('.updateCostRecordModal').modal("show");
	}
	function costRecordDel(data){
		$('#delCostId').val(data.costId);
		$('#confirmCRDelModal').modal("show");
	}
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
	/* $("#btn-updateDealModify").click(function(){
		updateDeal_submit();
	}); */
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
    $(".dealModal .cancel").click(function(){
    	$(".dealModal").modal("hide");
	});
    $(".noDealModal .cancel").click(function(){
        $(".noDealModal").modal("hide");
   	});
	$("#addPriceRecord").click(function(){
		$(".addPriceRecordModal").modal("show");	
	});
	$("#addCostRecord").click(function(){
		$(".addCostRecordModal").modal("show");	
	});
	
	$(".addPriceRecordModal .cancel").click(function(){
	    $(".addPriceRecordModal").modal("hide");
	});
	$(".addCostRecordModal .cancel").click(function(){
	    $(".addCostRecordModal").modal("hide");
	});
	$(".updatePriceRecordModal .cancel").click(function(){
	    $(".updatePriceRecordModal").modal("hide");
	});
	$(".updateCostRecordModal .cancel").click(function(){
	    $(".updateCostRecordModal").modal("hide");
	});
	
	
    //订单返回
    $("#btn-back").click( function () {
    	 window.location = "${rootPath}order/list.html?flag=old";
	}); 
    
    //删除收款记录
    $("#delPriceRecord").click( function(){
    	var id = $("#delPriceId").val();
    	delPriceRecord(id);
    });
	
    //删除付款记录
    $("#delCostRecord").click( function(){
    	var id = $("#delCostId").val();
    	delCostRecord(id);
    });
	
    // Date Picker
	jQuery(".datepicker").datepicker({
		  dateFormat: "yy-mm-dd"
  });
		
	function delPriceRecord(id) {
		$.ajax({
			url: "${rootPath}finance/delPriceRecord.do?id=" + id+"&orderId=${order.orderId}", 
			async: true,
			success: function(o) {
				window.location.reload();
			},
			error: function(o) {
				alert(2);
			}
		});		
	}
	function delCostRecord(id) {
		$.ajax({
			url: "${rootPath}finance/delCostRecord.do?id=" + id+"&orderId=${order.orderId}", 
			async: true,
			success: function(o) {
				window.location.reload();
			},
			error: function(o) {
				alert(2);
			}
		});		
	}
	function updatePriceRecord_submit() {
		var f = $("#form-updatePriceRecord").serialize();
		$.post('${rootPath}finance/updatePriceRecordOrder.do', f, function(result) {
			var rmsg = result.msg;
			if (result.success) {
				window.parent.location = "${rootPath}order/edit.html?id=${order.orderId}";
			} 
			else {
				$("#msgModal").modal('show');
			}
		}, "JSON");
	}
	function updateCostRecord_submit() {
		var f = $("#form-updateCostRecord").serialize();
		$.post('${rootPath}finance/updateCostRecordOrder.do', f, function(result) {
			var rmsg = result.msg;
			if (result.success) {
				window.parent.location = "${rootPath}order/edit.html?id=${order.orderId}";
			} 
			else {
				$("#msgModal").modal('show');
			}
		}, "JSON");
	}
	function addPriceRecord_submit() {
		var f = $("#form-addPriceRecord").serialize();
		$.post('${rootPath}finance/savePriceRecord.do', f, function(result) {
			var rmsg = result.msg;
			if (result.success) {
				window.parent.location = "${rootPath}order/edit.html?id=${order.orderId}";
			} 
			else {
				$("#msgModal").modal('show');
			}
		}, "JSON");
	}
	
	function addCostRecord_submit() {
		var f = $("#form-addCostRecord").serialize();
		$.post('${rootPath}finance/saveCostRecord.do', f, function(result) {
			var rmsg = result.msg;
			if (result.success) {
				window.parent.location = "${rootPath}order/edit.html?id=${order.orderId}";
			} 
			else {
				$("#msgModal").modal('show');
			}
		}, "JSON");
	}
	
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
	        //alert("data;"+JSON.stringify(args));  
	        return JSON.stringify(args);  
	    }  
	 
	function deal_submit() {
		var f = $("#form-deal").serialize();
		var jsonStr = getPriceRecord();
		$.post('${rootPath}order/orderDeal.do', $.param({'priceRecord':jsonStr})+'&'+f, function(result) {
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
					window.location.href = "${rootPath}order/edit.html?id=${order.orderId}";
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
	
  function load(){
	  if(financeStatus==3){
		  $("input").attr("disabled",true);
		  $("button").attr("disabled",true);
		  $('a').attr("disabled",true);
		  $('#addNote').attr("disabled",false);
		  //$("#addNote3").children().attr("disabled",false);
		  $('.addNote').attr("disabled",false);
	  } 
  }
</script>
</body>
</html>
