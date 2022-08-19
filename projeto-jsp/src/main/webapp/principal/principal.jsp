<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt_BR">

<jsp:include page="head.jsp"/><!-- Aqui est� incluindo nesta p�gina o nosso head -->

  <body>
  <!-- Pre-loader start -->
 <jsp:include page="theme-loader.jsp"/>
  <!-- Pre-loader end -->
  <div id="pcoded" class="pcoded">
      <div class="pcoded-overlay-box"></div>
      <div class="pcoded-container navbar-wrapper">
          
          <!-- Aqui chama a p�gina de inclus�o navbar -->
          <jsp:include page="navbar.jsp"/>

          <div class="pcoded-main-container">
              <div class="pcoded-wrapper">
               
               <jsp:include page="navbar-main-menu.jsp"/>
               
                  <div class="pcoded-content">
                      <!-- Page-header start -->
                      
                      <!-- Aqui chama a p�gina page-header -->
                      <jsp:include page="page-header.jsp"/>
                      
                      <!-- Page-header end -->
                        <div class="pcoded-inner-content">
                            <!-- Main-body start -->
                            <div class="main-body">
                                <div class="page-wrapper">
                                    <!-- Page-body start -->
                                    <div class="page-body">
                                        <div class="row">
                                        <!-- In�cio Aqui dentro, fica todo o conte�do --> 
                                        
                                        	<h1>Conte�do das p�ginas do sistema</h1>
                                           
                                        <!-- Fim Aqui dentro, fica todo o conte�do -->    
                                        </div>
                                    </div>
                                    <!-- Page-body end -->
                                </div>
                                <div id="styleSelector"> </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
   
   <!-- Aqui chama a p�gina javascriptfile -->
    <jsp:include page="javascriptfile.jsp"/>
    
</body>

</html>
