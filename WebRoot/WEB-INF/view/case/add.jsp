<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <form class="form-horizontal" id="form-case">
            <div class="panel-body panel-body-nopadding">
            	<div class="section-block">
        		<h5 class="section-title">客人基本信息</h5>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">中文名<span class="asterisk">*</span></label>
	              <div class="col-sm-9">
	                <input type="text" name="chineseName" placeholder="中文名" class="form-control" />
	              </div>
	            </div>
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">英文名</label>
	              <div class="col-sm-9">
	                <input type="text" name="englishName" placeholder="英文名" class="form-control" />
	              </div>
	            </div> 
	            <!-- <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label" >性别 <span class="asterisk">&nbsp;</span></label>
	              <div class="col-sm-9">
	                <div class="rdio rdio-primary rdio-inline">
	                  <input type="radio" id="male" value="male" name="gender">
	                  <label for="male">男</label>
	                </div>rdio
	                <div class="rdio rdio-primary rdio-inline">
	                  <input type="radio" id="female" value="female" name="gender" >
	                  <label for="female">女</label>
	                </div>rdio
	              </div>
	            </div>
	            <div class="form-group col-sm-4">
	            	<label class="col-sm-3 control-label">生日</label>
	            	<div class="col-sm-9 input-group input-datepicker">
		                <input type="text" name="birthday" class="datepicker form-control" placeholder="yyyy/mm/dd" id="birthday" autocomplete="off">
		                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
	                </div>
	            </div> 
	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label" >年龄段</label>
	              <div class="col-sm-9">
	                <input type="text" name="ageGroup" placeholder="请选择一个年龄段" class="agegroup-select fullwidth" />
	              </div>
	            </div> -->
<!-- 	            <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">客人级别</label>
	              <div class="col-sm-9">
	                <input type="text" name="level" placeholder="客人级别" class="level-select fullwidth" value="0" />
	              </div>
	            </div>  -->
	        </div>
	        
	        <div class="section-block">
	        	<h5 class="section-title">客人联系方式  <span class="contact-note">(手机、微信、QQ、邮箱至少填写一个)</span></h5>
	            <!-- <div class="form-group col-sm-4 contact-field">
	              <label class="col-sm-3 control-label">固定电话</label>
	              <div class="col-sm-9">
	                <input type="text" name="telephone" placeholder="固定电话" class="form-control" />
	              </div>
	            </div> -->
	            <div class="form-group col-sm-4 contact-field">
	              <label class="col-sm-3 control-label">手机</label>
	              <div class="col-sm-9">
	                <input type="text" name="mobile" placeholder="手机" class="form-control" />
	              </div>
	            </div>    
	            <div class="form-group col-sm-4 contact-field">
	              <label class="col-sm-3 control-label">微信</label>
	              <div class="col-sm-9">
	                <input type="text" name="wechat" placeholder="微信" class="form-control" />
	              </div>
	            </div>       
	            <div class="form-group col-sm-4 contact-field">
	              <label class="col-sm-3 control-label">QQ</label>
	              <div class="col-sm-9">
	                <input type="text" name="qq" placeholder="QQ" class="form-control" />
	              </div>
	            </div>            
	            <div class="form-group col-sm-4 contact-field">
	              <label class="col-sm-3 control-label">邮箱</label>
	              <div class="col-sm-9">
	                <input type="text" name="email" placeholder="邮箱" class="form-control"  />
	              </div>
	            </div>  
	            <!-- <div class="form-group col-sm-4">
	              <label class="col-sm-3 control-label">所在地</label>
	              <div class="col-sm-9">
	                <input type="text" name="location" placeholder="所在地" class="form-control" />
	              </div>
	            </div>  -->
	        </div>
	        
                <div class="section-block">
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">目的地</label>
                      <div class="col-sm-8">
                        <input type="text" id="destination" name="destination" class="country-select fullwidth" value="" />              
                      </div>
                    </div>  
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">沟通语言</label>
                      <div class="col-sm-8">
                        <input type="text" name="preferLanguage" class="language-select fullwidth" value=""/>
                      </div>
                    </div>
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">希望联系方式</label>
                      <div class="col-sm-8">
	                      <select name="contactType" class="contact-select fullwidth" multiple="multiple">
							  <option value="wechat">微信</option>
							  <option value="mobile">手机</option>							  
							  <option value="qq">qq</option>
					  		  <option value="mail">邮箱</option>
						</select>
                      </div>
                    </div> 
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">询单来源</label>
                      <div class="col-sm-8">
                        <input type="text" name="source" class="source-select fullwidth" value="" />
                      </div>
                    </div>

<!-- 	                <div class="form-group col-sm-4">
	                    <label class="col-sm-4 control-label">跟单员</label>
	                    <div class="col-sm-8">
	                      <input type="text"  name="operator" class="user-select fullwidth" value="0" />
	                    </div>
	                </div>   -->                      
  
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
        	                  <input type="radio" id="yes" value="1" name="startTime"/>
        	                  <label for="yes">已确定</label>
        	                </div><!-- rdio -->
        	                <div class="rdio rdio-primary rdio-inline">
        	                  <input type="radio" id="no" value="0" name="startTime" checked/>
        	                  <label for="no">未确定</label>
        	                </div><!-- rdio -->
        	                <label class="error" for="startTime"></label>
        	              </div>
                    </div>
                    <div class="form-group col-sm-4 start-time">
                      <label class="col-sm-4 control-label">大约时间</label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input id="startmonth" type="text" name="startMonth" class="form-control datepicker" placeholder="mm/dd/yyyy" autocomplete="off">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                    </div>
                    <div class="form-group col-sm-4 start-time">
                      <label class="col-sm-4 control-label">大约天数</label>
                      <div class="col-sm-8">
                        <input type="text" name="during" placeholder="大约天数" class="form-control" value="" />
                      </div>
                    </div>
                    <div class="form-group col-sm-4 start-date">
                      <label class="col-sm-4 control-label">出发日期</label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input id="startdate" type="text" name="startDate" class="form-control datepicker" placeholder="yyyy/mm/dd" autocomplete="off">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                      </div>
                    </div>
                    <div class="form-group col-sm-4 start-date">
                      <label class="col-sm-4 control-label">返回日期</label>
                      <div class="col-sm-8 input-group input-datepicker">
                        <input id="enddate" type="text" name="endDate" class="form-control datepicker" placeholder="yyyy/mm/dd" autocomplete="off">
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
<%--                     <input type="hidden" name="chineseName" value="${customerInfo.chineseName}"/>
                    <input type="hidden" name="englishName" value="${customerInfo.englishName}"/> --%>
<%--                     <input type="hidden" name="portalId" value="${customerInfo.portalId}"/> --%>
<%--                     <input type="hidden" name="mobile" value="${customerInfo.mobilephone}"/>
                    <input type="hidden" name="email" value="${customerInfo.email}"/>
                    <input type="hidden" name="wechat" value="${customerInfo.wechat}"/>
                    <input type="hidden" name="qq" value="${customerInfo.qq}"/> --%>
                </div>
            </div><!-- panel-body -->
            
            <div class="panel-footer align-center">
                <button class="btn btn-primary">保存</button>&nbsp;
                <button class="btn btn-default">取消</button>
                <input type="hidden" name="operator" value="${sessionScope.loginUser.userId}"/>
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
      		该客人没有邮箱，请<a href="#" id="addEmail">添加邮箱</a>后再进行操作
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal -->

<%-- <div class="nextModal modal fade" id="nextModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">您可以继续添加订单，或 <a style="text-decoration:underline;" href="${rootPath}case/list.html">回到询单列表页面</a></div>
      </div>
      <div class="modal-body align-center">
        <div class="section-block">
         <form id="form-order">
            <div class="section-title">选择目的地及地接社,继续添加订单</div>
             <div class="form-group col-sm-8 col-sm-offset-2">
                <label class="col-sm-3 control-label">目的地</label>
                <div class="col-sm-9">
                    <input type="text" name="destination" id="orderDestination" placeholder="国家" class="country-select fullwidth" value="" />
                </div>
            </div> 
            <div class="form-group col-sm-8 col-sm-offset-2">
                <label class="col-sm-3 control-label">销售</label>
                <div class="col-sm-9">
                    <input type="text" name="salesId" id="salesId" placeholder="选择一个销售" class="sales-select fullwidth" value="" />
                </div>
            </div>
            <div class="col-sm-12">
        	   <a class="submit btn btn-primary">保存</a>
        	 <input type="hidden"  name="caseId" id="caseId" value="" />
             <input type="hidden"  name="customerId" id="customerId" value="${customerId}"/>
            
            </div>
          </form>
        </div>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
</div><!-- modal --> --%>

 
 <div id="bindCustomer" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	<div class="modal-dialog">
    <div class="modal-content">
     <div class="modal-header">
        <h4 class="modal-title">联系方式已存在</h4>
     </div>
     <div class="modal-body">
     	<form id="form-judgeBind" action="${rootPath}/case/bindCustomer.do">

          <table id="showCustomer" border="1" width="100%">
            <tr>  
              <td align="center">客人ID</td>        
              <td align="center">客人名</td>
              <td align="center">电话</td>
              <td align="center">邮件</td>
              <td align="center">QQ</td>
              <td align="center">微信</td>
            </tr>
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
   
 
 
<%--  <div id="bindCustomer" class="nextModal modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	<div class="modal-dialog">
    <div class="modal-content">
     <div class="modal-header">
     	<form id=" " action="${rootPath}/case/bindCustomer.do">
			<table id="showCustomer" border="1">
			  <tr>	
			  	<td>客人ID</td>		  	
			  	<td>客人名</td>
			  	<td>电话</td>
			  	<td>邮件</td>
			  	<td>QQ</td>
			  	<td>微信</td>
			  </tr>
			</table>
			<input name="caseId" value="${sessionScope.caseId}"/>
			<input id="ccaseId" style="display: none" type="text" name="caseId" />
			<label  class="col-sm-4 control-label">是否绑定老客人</label>

	              <input type="radio" name="isJudge" value="1" checked/>是
      			  <input type="radio" name="isJudge" value="0" />否
			<input type="submit" name="submit" value="提交"/> 
		</form>
=======
  			<table id="showCustomer" border="1" width="100%">
  			  <tr>	
  			  	<td align="center">客人ID</td>		  	
  			  	<td align="center">客人名</td>
  			  	<td align="center">电话</td>
  			  	<td align="center">邮件</td>
  			  	<td align="center">QQ</td>
  			  	<td align="center">微信</td>
  			  </tr>
  			</table>
  			<input id="ccaseId" style="display: none" type="text" name="caseId" />
        <div style="margin: 10px 0;">
          <input type="radio" name="isJudge" value="1" checked/>绑定客人
    	    <input type="radio" name="isJudge" value="0" />新建客人
        </div>
        <div style="text-align: right;">
          <input class="btn btn-primary" type="submit" name="submit" value="提交"/> 
          <button class="btn btn-default" type="button" data-dismiss="modal">取消</button>
        </div>
			        
		  </form>
>>>>>>> 528190f5545b69654509c155ebf338638c139f7d
	    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
 </div><!-- modal -->	
</div>    
 
  --%>
<%-- <div id="bindCustomer" class="nextModal modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	<div class="modal-dialog">
    <div class="modal-content">
     <div class="modal-header">
     	<form id=" " action="${rootPath}/case/bindCustomer.do">
			<table id="dataTable" class="table">
				<thead>
					<tr>
				<th>客人ID</th>		  	
			  	<th>客人名</th>
			  	<th>电话</th>
			  	<th>邮件</th>
			  	<th>QQ</th>
			  	<th>微信</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<input name="caseId" value="${sessionScope.caseId}"/>
			<input id="ccaseId" style="display: none" type="text" name="caseId" />
			<label  class="col-sm-4 control-label">是否绑定老客人</label>

	              <input type="radio" name="isJudge" value="1" checked/>是
      			  <input type="radio" name="isJudge" value="0" />否
			<input type="submit" name="submit" value="提交"/> 
		</form>
	    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
 </div><!-- modal -->	
</div>  --%> 





	<%@ include file="../assets/pages/foot.jsp"%>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	<script src="${rootPath}assets/js/jquery.datatables.min.js"></script>
	
	<script type="text/javascript">
    var country = ${country};
    var language = ${language};
    var withwho = ${withwho};
    var hotel = ${hotel};
    var meals = ${meals};
    var guide = ${guide};
    var status = ${status};
    var source = ${source};
    var tailormade = ${tailormade};
    var passport = ${passport};
    var visa = ${visa};
    var flight = ${flight};
    var customer = ${customer};
    var user = ${user};
    var sales = ${sales};
    var level = ${level};
	var ageGroup = ${ageGroup};
	
	$(".agegroup-select").select2({
		placeholder: '选择一个年龄段',
	  	data: ageGroup
	});
	$(".level-select").select2({
	  	data: level
	});	

    $(".country-select").select2({
        placeholder: '国家',
        data: country,
    });
    $(".language-select").select2({
    	placeholder: '选择一个沟通语言',
     	data: language
    });
    $(".contact-select").select2({
        placeholder: '选择希望联系方式',
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
        data: status
     });
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
        // Date Picker
		jQuery(".datepicker").datepicker({
			dateFormat: "yy-mm-dd",
			changeYear: true,
			changeMonth: true,
			maxDate: 0,
		});
			 
  			jQuery("#form-case").validate({				
    		rules: {
 //		      customerId: "required",
 			  chineseName: "required",
			  qq: "number",
			  email: "email",
			  birthday: "date",
			  source: "required",
			  mobile:{
					isMobile:true,
			  },		
 			  source: "required",
 			  adult: "digits",
 			  children: "digits",
              baby: "digits",
              budget: "digits",
              startDate: "date",
              endDate: "date",
              startMonth: "date",
              during: "digits",
    		},
    		messages: {
 //  				customerId: "必须选择所属客人",
   				source:"请选择询单来源",
   				adult: "请输入一个整数",
             	children: "请输入一个整数",
             	baby: "请输入一个整数",
            	budget: "请输入一个整数",
            	startDate: "请输入正确的日期格式 mm/dd/yyyy",
            	endDate: "请输入正确的日期格式 mm/dd/yyyy",
             	startMonth: "请输入正确的日期格式 mm/dd/yyyy",
            	during: "请输入一个整数",
            	chineseName: "请输入中文名",
				qq: "请输入有效的QQ账号",
				email: "请输入有效的邮箱",
				birthday: "请输入正确的日期",
				source: "请选择一个客人来源"
   			},
  				
  			    highlight: function(element) {
  			      jQuery(element).closest('.form-group').removeClass('has-success').addClass('has-error');
  			    },
  			    success: function(element) {
  			      jQuery(element).closest('.form-group').removeClass('has-error');
  			    },
  			    invalidHandler : function(){
  			      var qq = $.trim($("input[name=qq]").val()),
			    		wechat = $.trim($("input[name=wechat]").val()),
			    		mobile = $.trim($("input[name=mobile]").val()),
			    		email = $.trim($("input[name=email]").val()),
			    		telephone = $.trim($("input[name=telephone]").val());

			    	// 手机，邮箱，微信，QQ，至少输入一个
			      	if(qq==""&&wechat==""&&mobile==""&&email==""&&telephone==""){
			      		$(".contact-note").addClass("noted");
			      		$(".contact-field").addClass("has-error");
			      	}else{
			      		$(".contact-note").removeClass("noted");
			      		$(".contact-field").removeClass("has-error");
				    }
  			      return false;
  			    },
  			    submitHandler : function(){
  			      var qq = $.trim($("input[name=qq]").val()),
		    			wechat = $.trim($("input[name=wechat]").val()),
		    			mobile = $.trim($("input[name=mobile]").val()),
		    			email = $.trim($("input[name=email]").val()),
		    			telephone = $.trim($("input[name=telephone]").val());
			    	// 手机，邮箱，微信，QQ，至少输入一个
			      	if(qq==""&&wechat==""&&mobile==""&&email==""&&telephone==""){
			      		$(".contact-note").addClass("noted");
			      		$(".contact-field").addClass("has-error");
			      		return false;
			      	}else{
			      		$(".contact-note").removeClass("noted");
			      		$(".contact-field").removeClass("has-error");
  			      		case_submit();
  			      		return false;
				    }
  			    }
  			});
  			
  			//验证手机号码
			jQuery.validator.addMethod("isMobile", function(value, element) {  
    			var length = value.length;  
    			var regPhone = /^1([3578]\d|4[57])\d{8}$/;  
    			return this.optional(element) || ( length == 11 && regPhone.test( value ) );    
			}, "请正确填写您的手机号码");

			// 手机，邮箱，微信，QQ，输入一个以后移除错误提示
			$(".contact-field").find("input").blur(function(){
				if($.trim($(this).val()) !== ""){
					$(".contact-field").removeClass("has-error");
				}
			});
			
	    $(".start-date").hide();
        $(".start-time").show();
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
        $(".customer-select").change(function() {
             var val= $(".customer-select").select2("val");
        	document.getElementById("customerId").value=val;
        });
        

			$("#btn-back").click( function () {
				history.go(-1);
		    }); 
		});
		
/* 		function sociation(){
   		 	var f = $("#form-case").serialize();
   		 	var h=$("#form-judgeBind").serialize();
   		 	alert("crmcase="+f+"&"+h);
	   		$.ajax({
				type:"POST",
				url:"${rootPath}/case/bindCustomer.do?crmcase="+f+"&"+h,		
				success:function (result){
					if (result=="ok") {
						alert("&&&&&")
						window.parent.location ="${rootPath}case/list.html";					
					} else{
						$("#msgModal").modal('show');
						$("#nextModal").modal('hide');
					}
				}
			}, "JSON"); 	
		} */
			      
		 function case_submit() {
			var f = $("#form-case").serialize();			
			$.post('${rootPath}case/add.do', f, function(result) {			
				if (result.ok=="ok") {
					window.parent.location = "${rootPath}case/list.html";					
				} else if(result.error=="error"){
					$("#msgModal").modal('show');
					$("#nextModal").modal('hide');
				}else{
					$("#ccaseId").val(result.cid);
					var custumerList=result.cust;
					for(var i=0;i<custumerList.length;i++){
						$("#showCustomer").append("<tr><td align='center'>"+custumerList[i].customerId+"</td>"+
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
		
		
		//datatables形式
		/* function case_submit() {
			var f = $("#form-case").serialize();			
			$.post('${rootPath}case/add.do', f, function(result) {	
				alert(result);
				var data = result;
				var t = jQuery('#dataTable').DataTable({
				 	searching:false,
					pageLength: 10,
					processing: true,
					language: datatable_local_language, // my.js
					serverSide: true, 
					 ajax: {
						url: result,
						dataFilter: function(data){
							var json = jQuery.parseJSON( data );
							json.recordsTotal = json.countTotal;
							json.recordsFiltered = json.countFiltered;
							json.data = json.data;
							return JSON.stringify( json );
						}
					}, 
					data: data,
					 columnDefs: [		  
	 					   {
				                orderable: false,
				                render: function ( data, type, full, meta ) {
				                    return "<div class='minw50'>" + full.caseId + "</div>" + "<div class='minw50'>" + full.chineseName + "</div>"
				                },
				                targets: 0
							},
							{
				                orderable: false,
				                render: function ( data, type, full, meta ) {
				                    return "<div>" + full.mobile + "</div>" + "<div>" + full.email + "</div>"
				                },
				                targets: 1
							},
		 					{
				                orderable: false,
				                render: function ( data, type, full, meta ) {
				                	if(full.destination){
					                	for(var i=0;i <destination.length;i++){
					                		if(full.destination==destination[i].id){
					                			return "<div class='width85'>" + destination[i].text + "</div>" + "<div class='width85'>" + full.budget + "</div>"
					                		}				                	
					                	}
					                	return "";
				                	}
				                	else{return ""}
				                },
				                targets: 2
							},	  
							{
				                orderable: false,
				                render: function ( data, type, full, meta ) {
				                	var dataSource = full.source;
				                	var dataOperator = full.operator;
				                	var m = "";
				                	var n = "";
					                	for(var i=0;i < source.length;i++){
					                		if(dataSource==source[i].id){
					                			// return "<div class='caselist-5'>" + user[i].text + "</div>"
					                			m = source[i].text;
					                		}	
					                	}
					                	for(var i=0;i < user.length;i++){
					                		if(dataOperator==user[i].id){
					                			n=user[i].text;
					                		}
					                	}
					                	return "<div class='width85'>" + m + "</div>" + "<div class='width85'>" + n + "</div>";
				                },
				                  targets: 3
							},
							 {
				                orderable: false,
				                render: function ( data, type, full, meta ) {
				                	if(full){
				                		for(var i=0;i <  caseStatus.length;i++){
					                		if(full.status==caseStatus[i].id){
					                			return "<div class='caselist-6'>" + caseStatus[i].text + "</div>" + "<div class='caselist-7'>" + new Date(data.time).format("yyyy-MM-dd hh:mm:ss"); + "</div>"
					                		}
					                	}
				                	}
				                	else{return ""}
				                },
				                  targets: 4
							},
							{
								data:"requirement",
								orderable: false,
								render:function(data) {
									if(data.length > 24){
										return "<div class='width150' data-toggle='tooltip' data-placement='bottom' title='" + data + "'>" + data.substring(0,28) + "...</div>"
									}else{
										return "<div class='width150'>" + data + "</div>"
									}	
								},
								targets: 5
							},
							{
				                data: "reason",
				                orderable: false,
				                render: function ( data ) {
				                	if(data){
				                		for(var i=0;i <  reason.length;i++){
					                		if(data==reason[i].id){
					                			return  "<div class='caselist-10'>" + reason[i].text + "</div>"
					                		}
					                	}
				                		return "";
				                	}
				                	else{return ""}
				                },
				                  targets: 6
							},
							{
								data:"comment",
								orderable: false,
								render:function ( data ) {
									if(data.length > 24){
										return "<div class='width150' data-toggle='tooltip' data-placement='bottom' title='" + data + "'>" + data.substring(0,28) + "...</div>"
									}else{
										return "<div class='width150'>" + data + "</div>"
									}
								},
								  targets: 7
							
							},
							{
			                  data: "caseId",
			                  orderable: false,
			                  render: function ( data, type, full, meta ) {
			                      return '<a class="btn btn-success btn-xs" id="'+data+'"><span class="fa fa-edit"></span> 编辑</a>&nbsp;';
			                  },
			                  targets: 8
						    },
						    {
							    orderable: false,
							    searchable: false,
						        targets: [0]
						    }, 

						], 
						columns: [
				            { data: "customerId" },
				            { data:"ChineseName"},
				            { data: "mobilephone" },
				            { data: "email" },
				            { data: "qq"},
				            { data: "wechat" }
				        ] 
					});
			}, "JSON");
			$("#bindCustomer").modal('show'); 		
		}
		 */
		
		

/* 	      $(".nextModal .submit").click(function(){
	      	  order_submit();
	      });
	      
	  		function order_submit() {
	    			var f = $("#form-order").serialize();
	    			$.post('${rootPath}/case/add.do', f, function(result) {
	    				var rmsg = result.msg;
	    				if (result.success) {
	    					window.parent.location = "${rootPath}case/list.html";
	    				} else {
	    					$("#nextModal").modal('hide');
	    					$("#NoEmail").modal('show');
	    				}
	    			}, "JSON");
	    	}
	  		 */
 
/* 	var newHref = "../customer/edit.html?id="+$("#customerId").val();
        $('#aAddEmail').attr("href",newHref) */
	</script>


</body>
</html>
