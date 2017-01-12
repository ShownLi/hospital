<%@ page language="java" pageEncoding="utf-8"%>
<div class="leftpanel">

    <div class="logopanel">
        <h1><span></span> 特美旅行 <span></span></h1>
    </div><!-- logopanel -->

    <div class="leftpanelinner">

        <!-- This is only visible to small devices -->
        <div class="visible-xs hidden-sm hidden-md hidden-lg">   
            <div class="media userlogged">
                <img alt="" src="${rootPath}assets/images/photos/loggeduser.png" class="media-object">
                <div class="media-body">
                    <h4>John Doe</h4>
                    <span>"Life is so."</span>
                </div>
            </div>

            <h5 class="sidebartitle actitle">Account</h5>
            <ul class="nav nav-pills nav-stacked nav-bracket mb30">
                <li><a href="profile.html"><i class="fa fa-user"></i> <span>Profile</span></a></li>
                <li><a href=""><i class="fa fa-cog"></i> <span>Account Settings</span></a></li>
                <li><a href=""><i class="fa fa-question-circle"></i> <span>Help</span></a></li>
                <li><a href="signout.html"><i class="fa fa-sign-out"></i> <span>Sign Out</span></a></li>
            </ul>
        </div>

        <h5 class="sidebartitle"></h5>
        <ul class="nav nav-pills nav-stacked nav-bracket">  
            <li class="nav-parent" id="case"><a href="javascript:void(0);"><i class="fa fa-paw"></i> <span>询单管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }case/list.html"><i class="fa fa-caret-right"></i> 询单列表</a></li>
                    <li><a href="${rootPath }case/add.html"><i class="fa fa-caret-right"></i> 新增询单</a></li>
                </ul>
            </li> 
            <li class="nav-parent" id="order"><a href="javascript:void(0);"><i class="fa fa-envelope"></i> <span>订单管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }order/list.html"><i class="fa fa-caret-right"></i> 订单列表</a></li>
                </ul>
            </li> 
            <li class="nav-parent" id="customer"><a href="javascript:void(0);"><i class="fa fa-address-book"></i> <span>客人管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }customer/list.html"><i class="fa fa-caret-right"></i> 客人列表</a></li>
                    <li><a href="${rootPath }customer/add.html"><i class="fa fa-caret-right"></i> 新增客人</a></li>
                </ul>
            </li> 
            <li class="nav-parent" id="agency"><a href=""><i class="glyphicon glyphicon-briefcase"></i> <span>供应商管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }agency/list.html"><i class="fa fa-caret-right"></i> 地接社列表</a></li>
                   <%--  <li><a href="${rootPath }agency/add.html"><i class="fa fa-caret-right"></i> 新增地接社</a></li> --%>
                </ul>
            </li> 
            <li class="nav-parent" id="user"><a href="javascript:void(0);"><i class="fa fa-user"></i> <span>用户管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }user/list.html"><i class="fa fa-caret-right"></i> 用户列表</a></li>
                    <li><a href="${rootPath }user/add.html"><i class="fa fa-caret-right"></i> 新增用户</a></li>
                    
                </ul>
            </li>
            <li class="nav-parent"><a href="javascript:void(0);"><i class="fa fa-user"></i> <span>财务管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath}finance/list.html"><i class="fa fa-caret-right"></i>财务管理列表</a></li>
                </ul> 
            </li> 
             <li class="nav-parent" id="stats"><a href="javascript:void(0);"><i class="fa fa-pie-chart"></i> <span>统计分析</span></a>
                <ul class="children">
                   	<li><a href="${rootPath }statistics/caseSourceStats.html"><i class="fa fa-caret-right"></i>询单来源状态统计</a></li>
                    <li><a href="${rootPath }statistics/contactrealstats.html"><i class="fa fa-caret-right"></i>沟通方式统计 </a></li>
                    <li><a href="${rootPath }statistics/caseAllotStats.html"><i class="fa fa-caret-right"></i>询单分配统计</a></li>
                    <li><a href="${rootPath }statistics/reasonofdrainingstats.html"><i class="fa fa-caret-right"></i>流失原因统计 </a></li>
                    <li><a href="${rootPath }statistics/agencyAchievementStats.html"><i class="fa fa-caret-right"></i>地接社绩效统计</a></li>
                    <li><a href="${rootPath }statistics/usercasestatusstats.html"><i class="fa fa-caret-right"></i>跟单员询单状态统计 </a></li>
                    <li><a href="${rootPath }statistics/userachievementstats.html"><i class="fa fa-caret-right"></i>跟单员绩效统计 </a></li>
                    <li><a href="${rootPath }statistics/descasestatusstats.html"><i class="fa fa-caret-right"></i>目的地询单状态统计 </a></li>
                    <li><a href="${rootPath }statistics/desachievementstats.html"><i class="fa fa-caret-right"></i>目的地咨询、成交统计 </a></li>
                    <li><a href="${rootPath }statistics/custsourcestats.html"><i class="fa fa-caret-right"></i>客人来源统计 </a></li>
                    <li><a href="${rootPath }statistics/customerSourceLevelStats.html"><i class="fa fa-caret-right"></i>客人来源级别统计</a></li>
                    <li><a href="${rootPath }statistics/sellerCoverStats.html"><i class="fa fa-caret-right"></i>商家覆盖统计</a></li>
                    <li><a href="${rootPath }statistics/sellerNotAskStats.html"><i class="fa fa-caret-right"></i>商家未询统计</a></li>
                    <li><a href="${rootPath }statistics/agencyOrderStatusStats.html"><i class="fa fa-caret-right"></i>地接社订单状态统计</a></li>
                </ul>
            </li>  
            <li class="nav-parent" id="menu"><a href="javascript:void(0);"><i class="glyphicon glyphicon-cog"></i> <span>权限管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }menu/list.html"><i class="fa fa-caret-right"></i> 权限列表</a></li>
                    <li><a href="${rootPath }menu/add.html"><i class="fa fa-caret-right"></i> 新增权限</a></li>                   
                    <li><a href="${rootPath }menu/rolelist.html"><i class="fa fa-caret-right"></i> 角色列表</a></li>                   
                    <li><a href="${rootPath }menu/addrole.html"><i class="fa fa-caret-right"></i> 新增角色</a></li>                   
                </ul>
            </li>
            <li class="nav-parent" id="parameter"><a href="javascript:void(0);"><i class="glyphicon glyphicon-cog"></i> <span>系统参数管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }parameter/list.html"><i class="fa fa-caret-right"></i> 系统参数列表</a></li>
                    <li><a href="${rootPath }parameter/add.html"><i class="fa fa-caret-right"></i> 新增系统参数</a></li>                   
                </ul>
            </li> 
            <li><a href="${rootPath }signout.html" id="signout"><i class="glyphicon glyphicon-log-out"></i> 退出登录</a></li>                     
        </ul>
        
        <script type="text/javascript">
        	//获取session中的roleID，根据ID判断左侧导航栏的显隐
			var roleID = <%=session.getAttribute("roleID")%>
			if(roleID==1){
				document.getElementById("case").style.display = "block"
				document.getElementById("order").style.display = "block"
				document.getElementById("customer").style.display = "block"
				document.getElementById("agency").style.display = "block"
				document.getElementById("stats").style.display = "block"
				document.getElementById("user").style.display = "block"
				document.getElementById("parameter").style.display = "block"
				document.getElementById("signout").style.display = "block"
				document.getElementById("menu").style.display = "block"
			}
			if(roleID==2){
				document.getElementById("case").style.display = "block"
				document.getElementById("order").style.display = "block"
				document.getElementById("customer").style.display = "block"
				document.getElementById("agency").style.display = "block"
				document.getElementById("stats").style.display = "block"
				document.getElementById("user").style.display = "none"
				document.getElementById("parameter").style.display = "none"
				document.getElementById("signout").style.display = "block"
				document.getElementById("menu").style.display = "none"
			}
			if(roleID==3){
				document.getElementById("case").style.display = "block"
				document.getElementById("order").style.display = "block"
				document.getElementById("customer").style.display = "block"
				document.getElementById("agency").style.display = "none"
				document.getElementById("stats").style.display = "none"
				document.getElementById("user").style.display = "none"
				document.getElementById("parameter").style.display = "none"
				document.getElementById("signout").style.display = "block"
				document.getElementById("menu").style.display = "none"
			}
			if(roleID==4){
				document.getElementById("case").style.display = "block"
				document.getElementById("order").style.display = "block"
				document.getElementById("customer").style.display = "block"
				document.getElementById("agency").style.display = "none"
				document.getElementById("stats").style.display = "none"
				document.getElementById("user").style.display = "none"
				document.getElementById("parameter").style.display = "none"
				document.getElementById("signout").style.display = "block"
				document.getElementById("menu").style.display = "none"
			}
			if(roleID==5){
				document.getElementById("case").style.display = "none"
				document.getElementById("order").style.display = "none"
				document.getElementById("customer").style.display = "none"
				document.getElementById("agency").style.display = "block"
				document.getElementById("stats").style.display = "none"
				document.getElementById("user").style.display = "none"
				document.getElementById("parameter").style.display = "none"
				document.getElementById("signout").style.display = "block"
				document.getElementById("menu").style.display = "none"
			}
		</script>

    </div><!-- leftpanelinner -->
</div><!-- leftpanel -->
