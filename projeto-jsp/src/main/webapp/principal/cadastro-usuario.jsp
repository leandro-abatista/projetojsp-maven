<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"/><!-- Aqui está incluindo nesta página o nosso head -->

  <body>
  <!-- Pre-loader start -->
 <jsp:include page="theme-loader.jsp"/>
  <!-- Pre-loader end -->
  <div id="pcoded" class="pcoded">
      <div class="pcoded-overlay-box"></div>
      <div class="pcoded-container navbar-wrapper">
          
          <!-- Aqui chama a página de inclusão navbar -->
          <jsp:include page="navbar.jsp"/>

          <div class="pcoded-main-container">
              <div class="pcoded-wrapper">
               
               <jsp:include page="navbar-main-menu.jsp"/>
               
                  <div class="pcoded-content">
                      <!-- Page-header start -->
                      
                      <!-- Aqui chama a página page-header -->
                      <jsp:include page="page-header.jsp"/>
                      
                      <!-- Page-header end -->
                        <div class="pcoded-inner-content">
                            <!-- Main-body start -->
                            <div class="main-body">
                                <div class="page-wrapper">
                                    <!-- Page-body start -->
                                    <div class="page-body">
                                        <div class="row">
                                        <!-- Início Aqui dentro, fica todo o conteúdo --> 
                                        
                                        	<h1>Cadastro de usuário</h1>
                                           
                                        <!-- Fim Aqui dentro, fica todo o conteúdo -->    
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
   
   <!-- Aqui chama a página javascriptfile -->
    <jsp:include page="javascriptfile.jsp"/>
    
</body>

</html>
