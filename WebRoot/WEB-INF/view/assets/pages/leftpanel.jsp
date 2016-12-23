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
            <li class="nav-parent"><a href="javascript:void(0);"><i class="fa fa-paw"></i> <span>询单管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }case/list.html"><i class="fa fa-caret-right"></i> 询单列表</a></li>
                    <li><a href="${rootPath }case/add.html"><i class="fa fa-caret-right"></i> 新增询单</a></li>
                </ul>
            </li> 
            <li class="nav-parent"><a href="javascript:void(0);"><i class="fa fa-envelope"></i> <span>订单管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }order/list.html"><i class="fa fa-caret-right"></i> 订单列表</a></li>
                </ul>
            </li> 
            <li class="nav-parent"><a href="javascript:void(0);"><i class="fa fa-address-book"></i> <span>客人管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }customer/list.html"><i class="fa fa-caret-right"></i> 客人列表</a></li>
                    <li><a href="${rootPath }customer/add.html"><i class="fa fa-caret-right"></i> 新增客人</a></li>
                </ul>
            </li> 
            <li class="nav-parent"><a href=""><i class="glyphicon glyphicon-briefcase"></i> <span>供应商管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }agency/list.html"><i class="fa fa-caret-right"></i> 地接社列表</a></li>
                    <li><a href="${rootPath }agency/add.html"><i class="fa fa-caret-right"></i> 新增地接社</a></li>
                </ul>
            </li> 
            <li class="nav-parent"><a href="javascript:void(0);"><i class="fa fa-user"></i> <span>用户管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }user/list.html"><i class="fa fa-caret-right"></i> 用户列表</a></li>
                    <li><a href="${rootPath }user/add.html"><i class="fa fa-caret-right"></i> 新增用户</a></li>
                    
                </ul>
            </li>  
             <li class="nav-parent"><a href="javascript:void(0);"><i class="fa fa-user"></i> <span>统计分析</span></a>
                <ul class="children">
                    <li><a href="${rootPath }statistics/caseSourceStats.html"><i class="fa fa-caret-right"></i>询单来源状态统计</a></li>
                    <li><a href="${rootPath }statistics/add.html"><i class="fa fa-caret-right"></i>沟通方式统计 </a></li>
                    <li><a href="${rootPath }statistics/caseAllotStats.html"><i class="fa fa-caret-right"></i>询单分配统计</a></li>
                    <li><a href="${rootPath }statistics/add.html"><i class="fa fa-caret-right"></i>流失原因统计 </a></li>
                    <li><a href="${rootPath }statistics/agencyAchievementStats.html"><i class="fa fa-caret-right"></i>地接社绩效统计</a></li>
                    <li><a href="${rootPath }statistics/customerSourceLevelStats.html"><i class="fa fa-caret-right"></i>客人来源级别统计</a></li>
                    <li><a href="${rootPath }statistics/sellerCoverStats.html"><i class="fa fa-caret-right"></i>商家覆盖统计</a></li>
                    <li><a href="${rootPath }statistics/sellerNotAskStats.html"><i class="fa fa-caret-right"></i>商家未询统计</a></li>
                    <li><a href="${rootPath }statistics/agencyOrderStatusStats.html"><i class="fa fa-caret-right"></i>地接社订单状态统计</a></li>
                    <li><a href="${rootPath }statistics/add.html"><i class="fa fa-caret-right"></i>跟单员业绩统计 </a></li>
                </ul>
            </li>  
            <li class="nav-parent"><a href="javascript:void(0);"><i class="glyphicon glyphicon-cog"></i> <span>系统参数管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }parameter/list.html"><i class="fa fa-caret-right"></i> 系统参数列表</a></li>
                    <li><a href="${rootPath }parameter/add.html"><i class="fa fa-caret-right"></i> 新增系统参数</a></li>                   
                </ul>
            </li> 
            <!--
            <li class="nav-parent"><a href="javascript:void(0);"><i class="fa fa-user"></i> <span>邮件管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }email/list.html"><i class="fa fa-caret-right"></i> 邮件队列</a></li>
                </ul>
            </li>
            -->
            <li><a href="${rootPath }signout.html"><i class="glyphicon glyphicon-log-out"></i> 退出登录</a></li>                     
        </ul>

    </div><!-- leftpanelinner -->
</div><!-- leftpanel -->
