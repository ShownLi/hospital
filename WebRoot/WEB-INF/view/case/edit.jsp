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
					<i class="fa fa-user"></i> 询单管理 <span>编辑询单</span>
				</h2>
				<div class="breadcrumb-wrapper">
					<span class="label">你在这里:</span>
					<ol class="breadcrumb">
						<li><a href="＃">CRM</a></li>
						<li><a href="${rootPath }user/list.html">询单管理</a></li>
						<li class="active">编辑询单</li>
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
          <h4 class="panel-title">询单基本信息</h4>
          <p>填写下表，完成询单编辑。</p>
        </div>
        <form class="form-horizontal" id="form">
        <div class="panel-body panel-body-nopadding">
            <div class="section-block">
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">称呼</label>
                  <div class="col-sm-8">
                    <input type="text" name="customer_name" placeholder="称呼" class="form-control" readonly value="" />
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
                    <input type="text" name="sales_name" placeholder="销售姓名" class="form-control" readonly value="" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">目的地</label>
                  <div class="col-sm-8">
                    <input type="text" name="destination" class="destination-select form-control" readonly value="" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">行程</label>
                  <div class="col-sm-8">
                    <input type="text" name="budget" placeholder="行程" class="form-control" readonly value="" />
                  </div>
                </div>
                <div class="form-group col-sm-4">
                  <label class="col-sm-4 control-label">表单类型</label>
                  <div class="col-sm-8">
                    <input type="text" name="submit_type" class="submittype-select form-control" readonly value="" />
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
                    <input type="text" name="status" placeholder="状态" class="form-control" readonly value="" />
                  </div>
                </div>
            </div>
        </div><!-- panel-body -->
        
        <div class="panel-footer align-center">
            <button id="submit" class="btn btn-primary">保存</button>&nbsp;
            <button class="btn btn-default">无效</button>
		    </div><!-- panel-footer -->
     </form>   
      </div><!-- panel -->

      <!-- panel 订单列表  -->
    <div class="panel panel-default">
      <div class="panel-heading">
        <div class="panel-btns">
          <a href="" class="panel-close">&times;</a>
          <a href="" class="minimize">&minus;</a>
        </div>
        <h4 class="panel-title">订单列表</h4>
      </div>
      <div class="panel-body panel-body-nopadding">
          <div class="table-responsive">

              <table id="dataTable" class="table">
                <thead>
                  <tr>
                    <th>序号</th>
                    <th>客人姓名</th>
                    <th>地接社</th>
                    <th>销售姓名</th>
                    <th>目的地</th>
                    <th>预算</th>
                    <th>状态</th>
                    <th>成团人数</th>
                    <th>成团价格</th>
                    <th>编辑</th>
                    <th>删除</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>1</td>
                    <td>张三</td>
                    <td>龙润国际旅行</td>
                    <td>李四</td>
                    <td>埃及</td>
                    <td>40,000</td>
                    <td>成交</td>
                    <td>6人</td>
                    <td>45,000</td>
                    <td><a href="edit.html" class="btn btn-success btn-xs"><span class="fa fa-edit"></span> 编辑</a>
                    <td><a class="btn btn-danger btn-xs"><span class="fa fa-minus-circle"></span> 删除</a></td>
                  </tr>
                  <tr>
                    <td>2</td>
                    <td>张三</td>
                    <td>龙润国际旅行</td>
                    <td>李四</td>
                    <td>埃及</td>
                    <td>40,000</td>
                    <td>成交</td>
                    <td>6人</td>
                    <td>45,000</td>
                    <td><a href="edit.html" class="btn btn-success btn-xs"><span class="fa fa-edit"></span> 编辑</a>
                    <td><a class="btn btn-danger btn-xs"><span class="fa fa-minus-circle"></span> 删除</a></td>
                  </tr>
                  <tr>
                    <td>3</td>
                    <td>张三</td>
                    <td>龙润国际旅行</td>
                    <td>李四</td>
                    <td>埃及</td>
                    <td>40,000</td>
                    <td>成交</td>
                    <td>6人</td>
                    <td>45,000</td>
                    <td><a href="edit.html" class="btn btn-success btn-xs"><span class="fa fa-edit"></span> 编辑</a>
                    <td><a class="btn btn-danger btn-xs"><span class="fa fa-minus-circle"></span> 删除</a></td>
                  </tr>
                </tbody>
              </table>
            </div>
            <!-- table-responsive -->
      </div>
    </div><!-- end of panel 询单  -->

      <!-- panel 沟通列表  -->
    <div class="panel panel-default">
      <div class="panel-heading">
        <div class="panel-btns">
          <a href="" class="panel-close">&times;</a>
          <a href="" class="minimize">&minus;</a>
        </div>
        <h4 class="panel-title">沟通列表</h4>
      </div>
      <div class="panel-body">
        <div class="form-group col-sm-4">
          <label class="col-sm-4 control-label">按订单筛选</label>
          <div class="col-sm-8">
            <input type="text" name="submit_type" class="order-select form-control" value="" />
          </div>
        </div>
        <div class="col-sm-12">
             <div class="conversation-list">
                  <div class="conversation-title"><span class="sender-name">Lucy</span> <span class="send-time">2016-06-24 11:08</span><a class="attachment" href="javascript:void(0)"></a></div>
                  <div class="content">请问埃及几月份最好玩？</div>
              </div>
              <div class="conversation-list">
                  <div class="conversation-title"><span class="sender-name">Gavin</span> <span class="send-time">2016-05-12 22:08</span><a class="attachment" href="javascript:void(0)"></a></div>
                  <div class="content">请问埃及几月份最好玩？</div>
              </div>
              <div class="conversation-list">
                  <div class="conversation-title"><span class="sender-name">李念儿</span> <span class="send-time">2016-03-24 9:08</span><a class="attachment" href="javascript:void(0)"></a></div>
                  <div class="content">请问埃及几月份最好玩？</div>
              </div>
        </div>
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

<div class="nextModal modal fade" id="nextModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <div class="nextModal-title">您可以继续添加订单，或 <a style="text-decoration:underline;" href="${rootPath}case/list.html">回到询单列表页面</a></div>
      </div>
      <div class="modal-body align-center">
        <div class="section-block">
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
		// $(".order-select").select2({
		// 	placeholder: '订单筛选',
		//   	data: p
		// });


		
		jQuery(document).ready(function() {
			
			 // Date Picker
			  jQuery(".datepicker").datepicker();
			 
			
  			$("#btn-back").click( function () {
  				history.go(-1);
  		  }); 

        $("#submit").click(function(){
          $("#nextModal").modal('show');
          return false;
        });

    });

      
			      
  		function form_submit() {
  			var f = $("#form").serialize();
  			$.post('${rootPath}case/edit.do', f, function(result) {
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
