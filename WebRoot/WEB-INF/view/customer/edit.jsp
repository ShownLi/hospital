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
					<i class="glyphicon glyphicon-briefcase"></i> 客人管理 <span>编辑客人</span>
				</h2>
				<div class="breadcrumb-wrapper">
					<span class="label">你在这里:</span>
					<ol class="breadcrumb">
						<li><a href="＃">CRM</a></li>
						<li><a href="${rootPath }customer/list.html">客人管理</a></li>
						<li class="active">编辑客人</li>
					</ol>
				</div>
			</div>

			<div class="contentpanel">
				<!-- content goes here... -->

		<div class="panel panel-default">
        <div class="panel-heading">
          <div class="panel-btns">
            <a href="" class="panel-close">&times;</a>
            <a href="" class="minimize">&minus;</a>
          </div>
          <h4 class="panel-title">客人基本信息</h4>
          <p>填写下表，完成客人信息修改。</p>
        </div>
        <form class="form-horizontal form-bordered" id="form">
        <div class="panel-body panel-body-nopadding">
          
					<div class="section-block">
		        		<h5 class="section-title">客人基本信息</h5>
			            <div class="form-group col-sm-4">
							<label class="col-sm-3 control-label">中文名<span class="asterisk">*</span></label>
							<div class="col-sm-9">
							    <input type="text" name="zname" placeholder="中文名" class="form-control" value="${customer.zname}"/>
							</div>
			            </div>
			            <div class="form-group col-sm-4">
							<label class="col-sm-3 control-label">英文名</label>
							<div class="col-sm-9">
							    <input type="text" name="ename" placeholder="英文名" class="form-control" value="${customer.ename}"/>
							</div>
			            </div> 
			            <div class="form-group col-sm-4">
							<label class="col-sm-3 control-label" >性别 <span class="asterisk">&nbsp;</span></label>
							<div class="col-sm-9">
								<div class="rdio rdio-primary rdio-inline">
								    <input type="radio" id="male" value="male" name="gender">
								    <label for="male">男</label>
								</div><!-- rdio -->
								<div class="rdio rdio-primary rdio-inline">
								    <input type="radio" id="female" value="female" name="gender" >
								    <label for="female">女</label>
								</div><!-- rdio -->
							</div>
			            </div>
			            <div class="form-group col-sm-4">
			            	<label class="col-sm-3 control-label">生日</label>
			            	<div class="col-sm-9 input-group input-datepicker">
				                <input type="text" class="form-control datepicker" placeholder="mm/dd/yyyy" id="birthday" value="${customer.birthday}">
				                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
			                </div>
			            </div> 
			            <div class="form-group col-sm-4">
							<label class="col-sm-3 control-label" >年龄段</label>
							<div class="col-sm-9">
							    <input type="text" name="agegroup" placeholder="年龄段" class="agegroup-select fullwidth" value="${customer.agegroup}"/>
							</div>
			            </div>
			            <div class="form-group col-sm-4">
							<label class="col-sm-3 control-label">客人级别</label>
							<div class="col-sm-9">
							    <input type="text" name="level" placeholder="客人级别" class="level-select fullwidth" value="${customer.level}" disabled />
							</div>
			            </div> 
			        </div>
			        <div class="section-block">
			        	<h5 class="section-title">客人联系方式  <span style="font-size:12px;">(手机、微信、QQ、邮箱至少填写一个)</span></h5>
			            <div class="form-group col-sm-4">
			                <label class="col-sm-3 control-label">固定电话</label>
			                <div class="col-sm-9">
			                    <input type="text" name="telephone" placeholder="固定电话" class="form-control" value="${customer.telephone}"/>
			                </div>
			            </div>
			            <div class="form-group col-sm-4">
			                <label class="col-sm-3 control-label">手机</label>
			                <div class="col-sm-9">
			                	<input type="text" name="mobilephone" placeholder="手机" class="form-control" value="${customer.mobilephone}"/>
			                </div>
			            </div>    
			            <div class="form-group col-sm-4">
			                <label class="col-sm-3 control-label">微信</label>
			                <div class="col-sm-9">
			                	<input type="text" name="wechat" placeholder="微信" class="form-control" value="${customer.wechat}"/>
			                </div>
			            </div>       
			            <div class="form-group col-sm-4">
			                <label class="col-sm-3 control-label">QQ</label>
			                <div class="col-sm-9">
			                	<input type="text" name="qq" placeholder="QQ" class="form-control" value="${customer.qq}"/>
			                </div>
			            </div>            
			            <div class="form-group col-sm-4">
			                <label class="col-sm-3 control-label">邮箱</label>
			                <div class="col-sm-9">
			                	<input type="text" name="email" placeholder="邮箱" class="form-control"  value="${customer.email}"/>
			                </div>
			            </div>  
			            <div class="form-group col-sm-4">
			                <label class="col-sm-3 control-label">所在地</label>
			                <div class="col-sm-9">
			                	<input type="text" name="location" placeholder="所在地" class="form-control" value="${customer.location}"/>
			                </div>
			            </div> 
			        </div>
			        <div class="section-block"> 
			        	<h5 class="section-title">其他</h5>   
			            <div class="form-group col-sm-4">
			                <label class="col-sm-3 control-label" >推广渠道 </label>
			                <div class="col-sm-9">
			               	 	<input type="text" name="promote" placeholder="推广渠道" class="promote-select fullwidth" value="${customer.promote}"/>
			                </div>
			            </div>
			        </div>  
         
        </div><!-- panel-body -->
        
        <div class="panel-footer align-center">
			<button class="btn btn-primary">保存</button>&nbsp;
			<button class="btn btn-default" id="btn-back">取消</button>
			<input type="hidden" name="customerid" value="${customer.customerid }" />
		</div><!-- panel-footer -->
     </form>   
      </div><!-- panel -->
		<!-- panel 询单  -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-btns">
				  <a href="" class="panel-close">&times;</a>
				  <a href="" class="minimize">&minus;</a>
				</div>
				<h4 class="panel-title">询单列表</h4>
			</div>
			<div class="panel-body panel-body-nopadding">
				<div class="table-responsive">
					<table id="dataTable" class="table">
						<thead>
							<tr>
								<th>序号</th>
								<th>称呼</th>
								<th>预算</th>
								<th>目的地</th>
								<th>询单来源</th>
								<th>状态</th>
								<th>邮箱</th>
								<th>编辑</th>
								<th>删除</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>张三</td>
								<td>30,000</td>
								<td>瑞士</td>
								<td>官网表单</td>
								<td>成交</td>
								<td>balbala@tourmade.com</td>
								<td><a href="edit.html" class="btn btn-success btn-xs"><span class="fa fa-edit"></span> 编辑</a>
								<td><a class="btn btn-danger btn-xs"><span class="fa fa-minus-circle"></span> 删除</a></td>
							</tr>
							<tr>
								<td>2</td>
								<td>李四</td>
								<td>35,000</td>
								<td>埃及</td>
								<td>在线客服</td>
								<td>下单</td>
								<td>balbala@tourmade.com</td>
								<td><a href="edit.html" class="btn btn-success btn-xs"><span class="fa fa-edit"></span> 编辑</a>
								<td><a class="btn btn-danger btn-xs"><span class="fa fa-minus-circle"></span> 删除</a></td>
							</tr>
							<tr>
								<td>3</td>
								<td>张三</td>
								<td>2,000</td>
								<td>澳大利亚</td>
								<td>微信咨询</td>
								<td>待处理</td>
								<td>balbala@tourmade.com</td>
								<td><a href="edit.html" class="btn btn-success btn-xs"><span class="fa fa-edit"></span> 编辑</a>
								<td><a class="btn btn-danger btn-xs"><span class="fa fa-minus-circle"></span> 删除</a></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- table-responsive -->
			</div>
		    <div class="panel-footer align-center">
			    <a class="btn btn-primary" href="#">添加询单</a>
			</div>
		</div><!-- end of panel 询单  -->
		
		<!-- panel 注释 -->
	    <div class="panel panel-default">
	        <div class="panel-heading">
	        <div class="panel-btns">
	            <a href="" class="panel-close">&times;</a>
	            <a href="" class="minimize">&minus;</a>
	        </div>
	        <h4 class="panel-title">注释列表 </h4>
	        </div>
	        <div class="panel-body">
	            <div class="conversation-list">
	                <div class="conversation-title"><span class="sender-name">Lucy</span> <span class="send-time">2016-06-20 11:08</span><a class="attachment" href="javascript:void(0)"></a></div>
	                <div class="content">继续跟进中</div>
	            </div>
	            <div class="conversation-list">
	                <div class="conversation-title"><span class="sender-name">Lucy</span> <span class="send-time">2016-06-24 11:08</span><a class="attachment" href="javascript:void(0)"></a></div>
	                <div class="content">已经成单</div>
	            </div>
	          <!-- 添加注释 -->
	          <div class="form-group col-sm-6 col-sm-offset-3">
	                <textarea class="form-control" rows="5"></textarea>
	          </div>
	          <div class="form-group col-sm-12 align-center">
	            <a class="btn btn-primary" href="#">添加注释</a>
	          </div>
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



	<%@ include file="../assets/pages/foot.jsp"%>
	<script src="${rootPath}assets/js/select2.min.js"></script>
	<script src="${rootPath}assets/js/jquery-ui-1.10.3.min.js"></script>
	<script src="${rootPath}assets/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript">
	var l = ${level};
	var p = ${promote};
	var a = ${agegroup};
	$(".promote-select").select2({
		placeholder: '选择一个推广渠道',
	  	data: p
	});
	$(".agegroup-select").select2({
		placeholder: '选择一个年龄段',
	  	data: a
	});
	$(".level-select").select2({
	  	data: l
	});	
	
	if("${customer.gender}"=='male'){
		$('#male').attr('checked','true');
	}
	else{
		$('#female').attr('checked','true');
	}
	jQuery(document).ready(function() {

		 // Date Picker
			  jQuery(".datepicker").datepicker();

		jQuery("#form").validate({
			rules: {
				name: "required",
			},
			messages: {
				name: "请输入客人名",
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
//			      
		function form_submit() {
			var f = $("#form").serialize();
			$.post('${rootPath}customer/edit.do', f, function(result) {
				var rmsg = result.msg;
				if (result.success) {
					window.parent.location = "${rootPath}customer/list.html";
				} else {
					$("#msgModal").modal('show');
				}
			}, "JSON");
		}
	</script>


</body>
</html>
