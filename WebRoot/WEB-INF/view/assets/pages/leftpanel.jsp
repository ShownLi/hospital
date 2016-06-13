<%@ page language="java" pageEncoding="utf-8"%>
<div class="leftpanel">

    <div class="logopanel">
        <h1><span>[</span> bracket <span>]</span></h1>
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

        <h5 class="sidebartitle">Navigation</h5>
        <ul class="nav nav-pills nav-stacked nav-bracket">
            <li><a href="index.html"><i class="fa fa-home"></i> <span>Dashboard</span></a></li>
            <li class="nav-parent"><a href=""><i class="fa fa-user"></i> <span>用户管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }user/list.html"><i class="fa fa-caret-right"></i> 用户列表</a></li>
                    <li><a href="${rootPath }user/add.html"><i class="fa fa-caret-right"></i> 新增用户</a></li>
                    
                </ul>
            </li>
            <li class="nav-parent"><a href=""><i class="fa fa-user"></i> <span>地接社管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }agency/list.html"><i class="fa fa-caret-right"></i> 地接社列表</a></li>
                    <li><a href="${rootPath }agency/add.html"><i class="fa fa-caret-right"></i> 新增地接社</a></li>
                    
                </ul>
            </li>            
            <li class="nav-parent"><a href=""><i class="fa fa-user"></i> <span>销售管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }sale/list.html"><i class="fa fa-caret-right"></i> 销售列表</a></li>
                    <li><a href="${rootPath }sale/add.html"><i class="fa fa-caret-right"></i> 新增销售</a></li>
                    
                </ul>
            </li> 
            <li class="nav-parent"><a href=""><i class="fa fa-user"></i> <span>系统参数管理</span></a>
                <ul class="children">
                    <li><a href="${rootPath }parameter/list.html"><i class="fa fa-caret-right"></i> 系统参数列表</a></li>
                    <li><a href="${rootPath }parameter/add.html"><i class="fa fa-caret-right"></i> 新增系统参数</a></li>
                    
                </ul>
            </li>             
        </ul>

    </div><!-- leftpanelinner -->
</div><!-- leftpanel -->
