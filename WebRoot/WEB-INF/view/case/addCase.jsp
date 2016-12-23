<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../assets/pages/head.jsp"%>
</head>

<body class="leftpanel-collapsed">
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
                    <div class="form-group col-sm-4">
                      <label class="col-sm-4 control-label">所属客人</label>
                      <div class="col-sm-8">

                        <input type="text" name="customerId" placeholder="所属客人" class="customer-select fullwidth" value="${customerId}" />

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
						</select>
	              
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
	                      <input type="text"  name="operator" class="user-select fullwidth" value="${sessionScope.loginUser.userId}" />
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
                      <label class="col-sm-4 control-label">目的地</label>
                      <div class="col-sm-8">
                      <select name="destination" class="contact-select-country fullwidth" multiple="multiple">
					</select>         
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
                        <span style="position: absolute; right: 15px; top: 10px;">￥/人</span>
                      </div>
                    </div>
                    <div class="form-group col-sm-8" style="clear: both;">
                      <label class="col-sm-2 control-label">客人的要求</label>
                      <div class="col-sm-9" style="margin-left: 23px;">
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
                    <input type="hidden" name="chineseName" value="${customerInfo.chineseName}"/>
                    <input type="hidden" name="englishName" value="${customerInfo.englishName}"/>
                    <input type="hidden" name="portalId" value="${customerInfo.portalId}"/>
                    <input type="hidden" name="mobile" value="${customerInfo.mobilephone}"/>
                    <input type="hidden" name="email" value="${customerInfo.email}"/>
                    <input type="hidden" name="wechat" value="${customerInfo.wechat}"/>
                    <input type="hidden" name="qq" value="${customerInfo.qq}"/>
                </div>
            
            </div>
            <div class="panel-footer align-center">

             <input id="addCase2" class="btn btn-primary" type="submit" value="保存"/>&nbsp;
	     <input class="btn btn-default" type="button" id="btn-back" value="取消"/>

    		    </div><!-- panel-footer -->
			
		</form>   
		</div><!-- panel-body -->
      </div><!-- panel -->
		

		</div>		<!-- mainpanel -->
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

<div class="nextModal modal fade" id="nextModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
<!--             <div class="form-group col-sm-8 col-sm-offset-2">
                <label class="col-sm-3 control-label">预算</label>
                <div class="col-sm-9">
                    <input type="text" name="budget" id="budget"  class="form-control" value="" />
                </div>
            </div> -->
            <div class="col-sm-12">
        	   <a class="submit btn btn-primary">保存</a>
        	 <input type="hidden"  name="caseId" id="caseId" value="" />
             <input type="hidden"  name="customerId" id="customerId" value="${customerId}" />
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

    //var level = ${level};
	//var ageGroup = ${ageGroup};
	
	/* $(".agegroup-select").select2({
		placeholder: '选择一个年龄段',
	  	data: ageGroup
	});
	$(".level-select").select2({
	  	data: level
	});	 */
	$(".contact-select-country").select2({
	    	placeholder: '可多选',
	    	minimumResultsForSearch: Infinity,
	    	data: country
	     });
	    $(".contact-select-country").val('${crmcase.destination}'.split(",")).trigger("change");


	var contactData=${contact};

    $(".country-select").select2({
        placeholder: '国家',
        data: country,
    });
    $(".language-select").select2({
    	placeholder: '选择一个沟通语言',
     	data: language
    });
    //选择希望的联系方式下拉框
    $(".contact-select").select2({
        placeholder: '选择希望联系方式',
        data:contactData
     });
    //选择真实的联系方式下拉框
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
        placeholder: '跟单员',
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
			 
  			jQuery("#form-case").validate({				
    		rules: {
 		      customerId: "required",
 			  source: "required",
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
   				customerId: "必须选择所属客人",
   				source:"请选择询单来源",
   				adult: "请输入一个整数",
             	children: "请输入一个整数",
             	baby: "请输入一个整数",
            	budget: "请输入一个整数",
            	startDate: "请输入正确的日期格式 mm/dd/yyyy",
            	endDate: "请输入正确的日期格式 mm/dd/yyyy",
             	startMonth: "请输入正确的日期格式 mm/dd/yyyy",
            	during: "请输入一个整数",
            	destination: "请选择目的地",
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
              $("#addCase2").attr("disabled","disabled");
  			      case_submit();
  			      return false;
  			    }
  			});
			
			  $("#btn-back").click( function () {
				    history.go(-1);
		   	  }); 
		});			  		
		/* 保存新建的询单 */  
		function case_submit() {
			var f = $("#form-case").serialize();			
			$.post('${rootPath}case/add.do', f, function(result) {

				var caseId = result.cid;
				$("#caseId").val(caseId);
				var rmsg = result.msg;
				
				//保存完询单弹出modal直接保存订单
				/* if (result.success) {
					//window.parent.location = "${rootPath}case/list.html";
					var destination = $("#destination").val();
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
					
			} else {
				$("#msgModal").modal('show');
				$("#nextModal").modal('hide'); */
				
				if (result.cid) {
					//window.parent.location = "${rootPath}case/edit.html?id="+caseId;
					window.parent.location = "${rootPath}case/list.html";
				}
					
			
				/* 结果响应成功 */
			/* 	if (result.success) {
					window.parent.location = "${rootPath}case/edit.html?id="+caseId;

				} else {
					$("#msgModal").modal('show');
					$("#nextModal").modal('hide');
				} */
			}, "JSON");
		}
		
	  		
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
        
	var newHref = "../customer/edit.html?id="+$("#customerId").val();
        $('#aAddEmail').attr("href",newHref)
	</script>


</body>
</html>
