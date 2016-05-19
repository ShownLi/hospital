<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
	<%@ include file="./assets/pages/head.jsp" %>
    </head>

    <body>
		<%@ include file="./assets/pages/preloader.jsp" %>
		<section>
			<%@ include file="./assets/pages/leftpanel.jsp" %>
            <div class="mainpanel">
				<%@ include file="./assets/pages/headerbar.jsp" %>
                <div class="pageheader">
                    <h2><i class="fa fa-home"></i> Blank Page <span>Subtitle goes here...</span></h2>
                    <div class="breadcrumb-wrapper">
                        <span class="label">You are here:</span>
                        <ol class="breadcrumb">
                            <li><a href="index.html">Bracket</a></li>
                            <li class="active">Blank</li>
                        </ol>
                    </div>
                </div>

                <div class="contentpanel">
                    <!-- content goes here... -->
                    
                    
                    
                    
                    
                    
                    
                </div>

            </div><!-- mainpanel -->
			<%@ include file="./assets/pages/rightpanel.jsp" %>
        </section>

        <%@ include file="./assets/pages/foot.jsp" %>

    </body>
</html>
