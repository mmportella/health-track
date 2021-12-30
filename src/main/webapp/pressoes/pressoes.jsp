<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style.css">
    <link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/favicon/favicon-16x16.png">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Press�o Arterial | Health Track</title>
</head>

<body>

    <nav role="navigation" class="menu-mobile">
        <div id="menuToggle">

            <input type="checkbox" />
            <span></span>
            <span></span>
            <span></span>

            <ul id="menu">
                <li><a href="dashboard">Dashboard</a></li>
                <li>
                    <a href="peso">Pesos</a>
                </li>
                <li>
                    <a href="pressao">Press�o arterial</a>
                </li>
                <li>
                    <a href="alimento">Alimenta��o</a>
                </li>
                <li>
                    <a href="atividade">Atividades</a>
                </li>
                <li>
                    <a href="login">Sair</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="menu">

        <ul>
            <li><a href="dashboard">Dashboard</a></li>
            <li>
                <a href="peso">Pesos</a>
            </li>
            <li>
                <a href="pressao" class="selected">Press�o arterial</a>
            </li>
            <li>
                <a href="alimento">Alimenta��o</a>
            </li>
            <li>
                <a href="atividade">Atividades</a>
            </li>
        </ul>

        <button><a href="login">Sair</a></button>
    </div>

    <div class="main pressao">

        <div class="header">

            <div class="text">

                <div class="title">Press�o Arterial</div>

            </div>

            <div class="foto" style="background-image: url('${pageContext.request.contextPath}/assets/images/user/${idUser}.jpeg');" onclick="perfil()">
        <div class="foto" style="background-image: url('${pageContext.request.contextPath}/assets/images/user/1.jpeg');"></div></div>

        </div>

        <div class="btn-area">

            <div class="button">

                <button class="primary"><a href="pressao/adicionar">Nova medi��o</a></button>

            </div>

        </div>

        <div class="lista">

            <table class="table">
                <thead class="background-primary">
                    <tr>
                        <th scope="col">Data</th>
                        <th scope="col">Press�o (mmHg)</th>
                        <th>Situa��o</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${listaPressao}" var="pressao">
                
                    <tr>
                    
                        <th scope="row">${pressao.dataPressao}</th>
                        <td>${pressao.pressaoSistolica}/${pressao.pressaoDiastolica}</td>
                        <c:set var="status" value="${pressao.pressaoSistolica}"/>
                        <td>
                        <%
                        if (Integer.parseInt(pageContext.getAttribute("status").toString()) >= 140) {
                        	out.print("Press�o alta");
                        } else {
                        	out.print("Press�o normal");
                        }
                        %>
                        </td>
                        
                        <form id="btn-editar${pressao.idPressao}" action="pressao/editar" method="post">
                        <input type="hidden" name="idPressao" value="${pressao.idPressao}">
                        <td><i class="fas fa-pen" onclick="editar${pressao.idPressao}()"></i></td>
                        </form>
                        
                        <form id="btn-excluir${pressao.idPressao}" action="pressao/excluir" method="post">
                        <input type="hidden" name="idPressao" value="${pressao.idPressao}">
                        <td><i class="fas fa-trash" onclick="excluir${pressao.idPressao}()"></i></td>
                        </form>
                        
                    </tr>
                    
                    <script>
    
  						function editar${pressao.idPressao}() {
    						document.getElementById("btn-editar${pressao.idPressao}").submit();
    					}
    
    					function excluir${pressao.idPressao}() {
    						var r = confirm("Tem certeza que deseja excluir?");
    						if (r == true) {
    							document.getElementById("btn-excluir${pressao.idPressao}").submit();
    						} else {
    						}
    					}
					</script>
                    
               	</c:forEach>  
                </tbody>
            </table>
        </div>

    </div>

</body>

</html>

<script>
    function perfil() {
        window.location.href = "${pageContext.request.contextPath}/perfil";
    }
</script>