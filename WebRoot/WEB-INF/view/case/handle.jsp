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
					<i class="fa fa-user"></i> 询单管理 <span>编辑询单</span>
				</h2>
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
        <form class="form-horizontal" id="form-case">
        <div class="panel-body panel-body-nopadding">
        
        	<div class="section-block">
        		<h5 class="section-title">客人基本信息</h5>
        		<div class="form-group col-sm-4" >
              	   <label class="col-sm-4 control-label">客人ID</label>
                  	<div class="col-sm-8">
                      	<input type="text" name="customerId" placeholder="客人ID" readonly class="form-control" value="${crmcase.customerId}" readonly />
                    </div>
              	</div> 
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">客人名<span class="asterisk">*</span></label>
	              <div class="col-sm-9">
	                <input type="text" name="chineseName" placeholder="中文名" class="form-control" value="${crmcase.chineseName}" />
	              </div>
	            </div>
 	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">英文名</label>
	              <div class="col-sm-9">
	                <input type="text" name="englishName" placeholder="英文名" class="form-control" value="${crmcase.englishName}"/>
	              </div>
	            </div> 	
	            <input type="text" style="display: none" name="portalId" placeholder="portalId" class="form-control" value="${crmcase.portalId}"/>
	             	
	        </div>
	        
	        <div class="section-block">
	        	<h5 class="section-title">客人联系方式  <span class="contact-note">(手机、微信、QQ、邮箱至少填写一个)</span></h5>
	           <%--  <div class="form-group col-sm-4 contact-field">
	              <label class="col-sm-3 control-label">固定电话</label>
	              <div class="col-sm-9">
	                <input type="text" name="telephone" placeholder="固定电话" class="form-control" value="${crmcase.telephone}" />
	              </div>
	            </div> --%>
	            <div class="form-group col-sm-4 contact-field">
	              <label class="col-sm-3 control-label">手机</label>
	              <div class="col-sm-9">
	                <input type="text" name="mobile" placeholder="手机" class="form-control" value="${crmcase.mobile}" />
	              </div>
	            </div>    
	            <div class="form-group col-sm-4 contact-field">
	              <label class="col-sm-3 control-label">微信</label>
	              <div class="col-sm-9">
	                <input type="text" name="wechat" placeholder="微信" class="form-control" value="${crmcase.wechat}"/>
	              </div>
	            </div>       
	            <div class="form-group col-sm-4 contact-field">
	              <label class="col-sm-3 control-label">QQ</label>
	              <div class="col-sm-9">
	                <input type="text" name="qq" placeholder="QQ" class="form-control" value="${crmcase.qq}"/>
	              </div>
	            </div>            
	            <div class="form-group col-sm-4 contact-field">
	              <label class="col-sm-3 control-label">邮箱</label>
	              <div class="col-sm-9">
	                <input type="text" name="email" placeholder="邮箱" class="form-control" value="${crmcase.email}"/>
	              </div>
	            </div>  
	        </div>
        
        
            <div class="section-block">

                <div class="form-group col-sm-4">
                    <label class="col-sm-4 control-label">沟通语言</label>
                    <div class="col-sm-8">
                      <input type="text" name="preferLanguage" class="language-select fullwidth" value="${crmcase.preferLanguage}"/>
                    </div>
                </div>
                <div class="form-group col-sm-4">
                    <label class="col-sm-4 control-label">希望联系方式</label>
                    <div class="col-sm-8">
                      <select name="contactType" class="contact-select fullwidth" multiple="multiple">
					  
					</select>
                    </div>
                </div>   
                <div class="form-group col-sm-4">
                    <label class="col-sm-4 control-label">询单来源</label>
                    <div class="col-sm-8">
                      <input type="text" name="source" class="source-select fullwidth" value="${crmcase.source}" />
                    </div>
                </div>
                
                <div class="form-group col-sm-4">
                <label class="col-sm-4 control-label">状态</label>
                <div class="col-sm-8">
                   <input type="text" name="status" class="status-select fullwidth" value="${crmcase.status}" />
                </div>
                </div>
            </div>
            
            </div> 
            
            <div class="section-block">           
            	<div class="form-group col-sm-4">
                <label class="col-sm-4 control-label">IP地址</label>
                 <div class="col-sm-8">
                     <input type="text" name="ipAddress" class="form-control" readonly value="${crmcase.ipAddress}" />
                </div>
                </div>               
                
                <div class="form-group col-sm-4">
                <label class="col-sm-4 control-label">推广码</label>
                <div class="col-sm-8">
                   <input type="text" name="promoteCode" class="form-control" readonly value="${crmcase.promoteCode}" />
                </div>
                </div> 
                
               	<div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">表单类型</label>
                <div class="col-sm-8">
                   <input type="text" name="submitType" class="form-control" readonly value="${crmcase.submitType}" />
                </div>
                </div>       
                
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">目的地</label>
                <div class="col-sm-8">
                    <select name="destination" class="contact-select-country fullwidth" multiple="multiple">
					</select>
                </div>
                </div>
                     
                <div class="form-group col-sm-4">
                <label class="col-sm-4 control-label">跟单员</label>
                <div class="col-sm-8">
                     <input type="text" name="operator" class="user-select fullwidth" value="${crmcase.operator}" />
                </div>
                </div> 
                <div class="form-group col-sm-4">
                    <label class="col-sm-4 control-label">沟通方式</label>
                    <div class="col-sm-8">
                      <input type="text"  name="contactReal" class="contact-real-select fullwidth" value="0" />
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
                <div class="form-group col-sm-4" style="clear: both;">
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
                <div class="form-group col-sm-4">
                  <label class="col-sm-6 control-label">婴儿（0-2岁）</label>
                  <div class="col-sm-6">
                    <input type="text" name="baby" placeholder="婴儿（0-2岁）" class="form-control" value="${crmcase.baby}" />
                  </div>
                </div>
            </div>
            <div class="section-block">
                   	<div class="form-group col-sm-4">
        	              <label class="col-sm-4 control-label">出发时间 <span class="asterisk">&nbsp;</span></label>
        	              <div class="col-sm-8">
        	                <div class="rdio rdio-primary rdio-inline">
        	                  <input type="radio" id="yes" value="1" name="startTime"/>
        	                  <label for="yes">已确定</label>
        	                </div><!-- rdio -->
        	                <div class="rdio rdio-primary rdio-inline">
        	                  <input type="radio" id="no" value="0" name="startTime" />
        	                  <label for="no">未确定</label>
        	                </div><!-- rdio -->
        	                <label class="error" for="startTime"></label>
        	              </div>
                    </div>
               <div class="form-group col-sm-4 start-time">
                  <label class="col-sm-4 control-label">大约时间</label>
                  <div class="col-sm-8 input-group input-datepicker">
                    <input type="text" id="startMonth" name="startMonth" class="form-control datepicker" placeholder="yyyy/mm/dd" value="${crmcase.startMonth}" autocomplete="off">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                  </div>
                </div> 
                <div class="form-group col-sm-4 start-time">
                  <label class="col-sm-4 control-label">大约天数</label>
                  <div class="col-sm-8">
                    <input type="text" name="during" placeholder="大约天数" class="form-control" value="${crmcase.during}" />
                  </div>
                </div> 
                <div class="form-group col-sm-4 start-date">
                  <label class="col-sm-4 control-label">出发日期</label>
                  <div class="col-sm-8 input-group input-datepicker">
                    <input type="text" id="startDate" name="startDate" class="form-control datepicker" placeholder="yyyy/mm/dd" value="${crmcase.startDate}" autocomplete="off">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                  </div>
                </div> 
                <div class="form-group col-sm-4 start-date">
                  <label class="col-sm-4 control-label">返回日期</label>
                  <div class="col-sm-8 input-group input-datepicker">
                    <input type="text" id="endDate" name="endDate" class="form-control datepicker" placeholder="yyyy/mm/dd" value="${crmcase.endDate}" autocomplete="off">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                  </div>
                </div>
            </div>
            <div class="section-block">
                <div class="form-group col-sm-4">
                    <label class="col-sm-5 control-label">定制偏好</label>
                    <div class="col-sm-7">
                      <input type="text" name="tailormade" placeholder="定制偏好" class="tailormade-select fullwidth" value="${crmcase.tailormade}" />
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
                    <span style="position: absolute; right: 15px; top: 10px;">￥/人</span>
                  </div>
                </div>
                <div class="form-group col-sm-8">
                  <label class="col-sm-2 control-label">客人的要求</label>
                  <div class="col-sm-9" style="margin-left: 23px;">
              		<textarea id="requirement" name="requirement" class="form-control" placeholder="客人的要求" rows="5">${crmcase.requirement}</textarea>
                  </div>
                </div>
            </div>
            <div class="section-block">
                    <div class="form-group col-sm-4">
                        <label class="col-sm-4 control-label">护照</label>
                        <div class="col-sm-8">
                          <input type="text" name="passport" placeholder="护照" class="passport-select fullwidth" value="${crmcase.passport}" />
                        </div>
                    </div>
                    <div class="form-group col-sm-4">
                        <label class="col-sm-4 control-label">签证</label>
                        <div class="col-sm-8">
                          <input type="text" name="visa" placeholder="签证" class="visa-select fullwidth" value="${crmcase.visa}" />
                        </div>
                    </div>
                    <div class="form-group col-sm-4">
                        <label class="col-sm-4 control-label">国际航班</label>
                        <div class="col-sm-8">
                          <input type="text" name="flight" placeholder="国际航班" class="flight-select fullwidth" value="${crmcase.flight}" />
                        </div>
                    </div>
                     <div class="form-group col-sm-4" id="div-delInfo" style="display:none">
                        <label class="col-sm-4 control-label">无效原因</label>
                        <div class="col-sm-8">
                          <input type="text" name="reason" placeholder="无效原因" class="reason-select fullwidth"  value="${crmcase.reason}" />
                        </div>
                    </div>              
        </div><!-- panel-body -->
        
        <div class="panel-footer align-center">
           <!--  <button id="btn-addorder" class="btn btn-primary">添加订单</button>&nbsp; -->
            <button class="btn btn-primary">处理</button>&nbsp;
            <input  type="hidden" name="caseId" value="${crmcase.caseId}" />
            <button id="btn-invalid"  class="btn btn-danger" >无效</button>&nbsp;
            <button id="btn-back" class="btn btn-default">返回</button>
		</div><!-- panel-footer -->
     </form>   
      </div><!-- panel -->
      
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
    	    <form id="form-comment" class="form">
              <div class="form-group col-sm-6 col-sm-offset-3">
                    <textarea name="content" class="form-control" rows="5"></textarea>
                    <input  type="hidden" name="userId" value="${loginUser.userId}" />
                    <input  type="hidden" name="userName" value="${loginUser.name}" />
                    <input  type="hidden" name="objectId" value="${crmcase.caseId}" />
                    <input  type="hidden" name="commentType" value="case" />
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

<!-- Modal 添加订单没有地址 -->
<div class="modal fade" id="msgDestination" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">信息</h4>
      </div>
      <div class="modal-body">
       	 请选择目的地，再添加订单
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
      		该客人没有邮箱，请<a href="#" id="addEmail">添加邮箱</a>后再进行操作
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
      <div class="modal-body align-center">
        <div class="section-block">
        <form id="form-order">
            <div class="section-title">选择目的地及地接社,添加订单</div>
             <div class="form-group col-sm-8 col-sm-offset-2">
                <label class="col-sm-3 control-label">目的地</label>
                <div class="col-sm-9">

                    <input type="text" id="orderDestinationText"  readonly="readonly" class="form-control" value="" />
                    <input type="hidden" id="orderDestination" name="destination"  value="" />

                </div>
            </div>
            <div class="form-group col-sm-8 col-sm-offset-2">
				<label class="col-sm-3 control-label">服务类型</label>
				<div class="col-sm-9">
					<input type="text" id="serviceID" name="service"
						placeholder="选择服务类型" class="service-select fullwidth" value="" />
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
             <a class="submit btn btn-primary">保存</a>
             <input  type="hidden" name="caseId" value="${crmcase.caseId}" />
             <input  type="hidden" name="customerId" value="${crmcase.customerId}" />
             <input  type="hidden" name="operator" value="${crmcase.operator}" />
            </div>
            </form>
        </div>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->
	
	
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
            <button class="submit btn btn-primary">保存</button> 
              <a class="cancel btn btn-primary" >取消</a>
          </div>
      </form>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- bmodal -->

<div id="bindCustomer" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	<div class="modal-dialog">
    <div class="modal-content">
     <div class="modal-header">
     <h4 class="modal-title">联系方式已存在</h4>
     </div>
     <div class="modal-body">
      <form id="form-judgeBind" action="${rootPath}/case/bindCustomer.do">
          <table id="showCustomer" border="1" width="100%">
          	<thead>
          		<tr>
          		  <td align="center">客人ID</td>        
	              <td align="center">客人名</td>
	              <td align="center">电话</td>
	              <td align="center">邮件</td>
	              <td align="center">QQ</td>
	              <td align="center">微信</td>
          		</tr>
          	</thead>
          	<tbody>    		
          	</tbody>
          </table>
          <input id="ccaseId" style="display: none" type="text" name="caseId" />
          <div style="margin: 10px 0;">
            <div class="rdio rdio-primary rdio-inline">
              <input id="bingding" type="radio" name="isJudge" value="1" checked/>
              <label for="bingding">绑定客人</label>
            </div>
            <div class="rdio rdio-primary rdio-inline">
              <input id="cratenew" type="radio" name="isJudge" value="0" />
              <label for="cratenew">新建客人</label>
            </div>
          </div>
          <div style="text-align: right;">
            <input class="btn btn-primary" type="submit" name="submit" value="提交"/> 
            <button class="btn btn-default" type="button" data-dismiss="modal">取消</button>
          </div> 
      </form>
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
	var contactData=${contact};
	
	function getBirthday(){
		var date = $("#birthday").val();	
		var dateformat = null;
		if(!date.length==0){
			dateformat = new Date(date).toISOString("yyyy-MM-dd hh:mm:ss.S").substring(0,10);
		}
		return dateformat;
	}
	
 	$("#level").select2({
        data: level
    });
	
 	
	$("#gender").select2({
        data: genderData
    });  
    
    $(".destination-select").select2({
        placeholder: '国家',
        data: country
    }); 
	

    $(".language-select").select2({
    	placeholder: '选择一个沟通语言',
     	data: language
    });
    $(".contact-select-country").select2({
    	placeholder: '可多选',
    	minimumResultsForSearch: Infinity,
    	data: country
     });
    $(".contact-select-country").val('${crmcase.destination}'.split(",")).trigger("change");
    $(".contact-select").select2({
    	placeholder: '可多选',
    	minimumResultsForSearch: Infinity,
    	data: contactData
     });
    
  //循环去除数组中元素的空格
    var temp='${crmcase.contactType}'.split(",");
    var value=[];
    $.each(temp,function(index,item){
    	value.push(item.trim());
    	
    })
    
    //给contact-select赋值
    $(".contact-select").val(value).trigger("change");
    
    //选择真实的联系方式
    $(".contact-real-select").select2({
        placeholder: '选择真实联系方式',
        data: contactData
     });
    
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
    $(".sales-select").select2({
        placeholder: '销售',
        data: sales
    });
	
    $(".reason-select").select2({
    	placeholder:"无效原因",
    	data:reason
    });
	if("${crmcase.reason}"!=null&&"${crmcase.reason}"!=""){
   	  $("#div-delInfo").show();
   	 };
    
   	 
   	jQuery(document).ready(function() {
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
		
   	});
   	
	//订单回显数据
  	var orderTable = jQuery('#dataTable-order').DataTable({
  		searching:false,
	 	pageLength: 10,
	 	processing: true,
	 	language: datatable_local_language, // my.js
	 	serverSide: true,
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
	       {
	           data: "orderId",
	 	       orderable: false,
	 	       render: function ( data, type, full, meta ) {
               		return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>&nbsp;';
	 	       },
	 	       targets: 6
	 		},
	 		{
               data: "status",
               orderable: false,
               render: function ( data ) {
		           if(data){
			           for(var i=0;i <  orderStatus.length;i++){
			               if(data==orderStatus[i].id){
			             		return orderStatus[i].text
			               }
			           }
			        }
              	    else{return ""}
              	},
                targets: 5
			},
    		{
              data: "destination",
              orderable: false,
              render: function ( data ) {
	              if(data){
	               	 for(var i=0;i <country.length;i++){
	               		if(data==country[i].id){
	               			return country[i].text
	               		}
	               	 }
	               	 return ""
	              }
	              else{return ""}
              },
                targets: 4
			},  		  
	 	    {
			    orderable: false,
			    searchable: false,
			 	targets: [0,1,2]
	 	    },
	 	],
	 	columns: [
             { data: "orderId" },
             { data: "customerId" },
             { data: "agencyName" },
             { data: "salesName" },
           	 { data: "destination" },
             { data: "status" }
       ]		 	
	});
	
	//询单效验数据，修改
	jQuery("#form-case").validate({      
          rules: {
          	operator:"required",
            adult: "digits",
            children: "digits",
            baby: "digits",
            budget: "digits",
            startDate: "date",
            endDate: "date",
            startMonth: "date",
            during: "digits",
            destination: "required",
          },
          messages: {
            operator:"请录入跟单员",
            adult: "请输入一个整数",
            children: "请输入一个整数",
            baby: "请输入一个整数",
            budget: "请输入一个整数",
            startDate: "请输入正确的日期格式 mm/dd/yyyy",
            endDate: "请输入正确的日期格式 mm/dd/yyyy",
            startMonth: "请输入正确的日期格式 mm/dd/yyyy",
            during: "请输入一个整数",
            destination:"请选择目的地",
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
            //$("#form-case .btn-primary").attr("disabled","disabled");
            case_submit();
            return false;
          }
      });
      
  		
  		 function case_submit() {
  			$(".status-select").prop("disabled", false);
			var f = $("#form-case").serialize();			
			$.post('${rootPath}case/handle.do', f, function(result) {		
				if (result.ok=="ok") {
					window.parent.location = "${rootPath}case/list.html";					
				} else if(result.error=="error"){
					$("#msgModal").modal('show');
					$("#nextModal").modal('hide');
				}else{
					$("#ccaseId").val(result.cid);
					var custumerList=result.cust;
					for(var i=0;i<custumerList.length;i++){
						$("#showCustomer tbody").empty();
						$("#showCustomer tbody").append("<tr><td align='center'>"+custumerList[i].customerId+"</td>"+
								"<td align='center' name='chineseName'>"+custumerList[i].chineseName+"</td>"+
								"<td align='center' name='mobilephone'>"+custumerList[i].mobilephone+"</td>"+
								"<td align='center' name='email'>"+custumerList[i].email+"</td>"+
								"<td align='center' name='qq'>"+custumerList[i].qq+"</td>"+
								"<td align='center' name='wechat'>"+custumerList[i].wechat+"</td>"+
								"<td align='center' style='display:none'><input type='checkbox' name='customerId' checked='true' value="+custumerList[i].customerId+"></td></tr>" 																				
							);
					}
					$("#bindCustomer").modal('show'); 										
				}
			}, "JSON");
		}
		
		
	   //询单返回
  	  $("#btn-back").click( function () {
  		  history.go(-1);
  	  });  	  
	   
      //询单无效
      $("#btn-invalid").click(function(){
      	 $(".confirmDelModal").modal('show');
		 return false;
      });
     
      
      //更改无效原因
      
      $(".confirmDelModal .cancel").click(function(){
      	$(".confirmDelModal").modal("hide");
  	  });
     
	   
	  //添加订单
      $("#btn-addorder").click(function(){
      	  var destination = $("#destination").val(); 
      	  $("#englishDestination").val(destination);
      	      	  
      	  if(destination==""){
      	  	$("#msgDestination").modal('show');
 		  }else{ 
      		var destinationText = $("#destination").select2('data').text;
      	  		$("#orderDestinationText").val(destinationText); 
      	  		$("#orderDestination").val(destination);
	      	  	$.ajax({
	              type: "post",
	              url: "${rootPath}case/getSales.do?destination="+destination,
	              data: destination,
	              success: function(sales){
	            	  var json = jQuery.parseJSON( sales );
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
      
    //选择服务类型所属销售显示的联动
	  	$("#serviceID").change(function(){
	  		var serviceID = $("#serviceID").val();
	  		if(serviceID==3 || serviceID==4 || serviceID==5){
	  			$.ajax({
		              type: "post",
		              url: "${rootPath}case/getSalesByServiceId.do?serviceID="+serviceID,
		              data: serviceID,
		              success: function(sales){
		            	  var json = jQuery.parseJSON(sales);
		                  $("#salesId").select2({	
		                      placeholder: '销售',
		                      data: json
		                  });
		              }  
		        }); 
	  		}else{
	  			var destination = $("#destination").val();
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
	  		}
	  	}) 
	  
       $(".nextModal .submit").click(function(){
      	  order_submit();
      });  
      
      function order_submit() {
		var f = $("#form-order").serialize();
		$.post('${rootPath}order/add.do', f, function(result) {
			var rmsg = result.msg;
			if (result.success) {
				window.parent.location = "${rootPath}case/edit.html?id=${crmcase.caseId}";
			} else {
				$("#NoEmail").modal('show');
         		$("#nextModal").modal('hide');
			}
		}, "JSON");
      }
      
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
      
      //进入订单编辑页面
      $('#dataTable-order tbody').on( 'click', 'a.btn-success', function () {
         var data = orderTable.row($(this).parents('tr')).data();
         edit($(this).attr('id'));
      });     
     function edit(id) {
		window.parent.location = "${rootPath}order/edit.html?id="+id;
	 }	
  		
		//沟通记录   回显
  		var recordTable = jQuery('#dataTable-record').DataTable({
  				searching:false,
    			pageLength: 10,
    			processing: true,
    			language:  datatable_local_language, // my.js
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
			pageLength: 10,
			processing: true,
			language: datatable_local_language, // my.js
			serverSide: true,
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
