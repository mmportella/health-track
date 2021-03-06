<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
    <title>Nova Medi??o | Health Track</title>
</head>

<body>

	<script type="text/javascript">
		var Msg ='<%=request.getAttribute("erro")%>';
    	if (Msg != "null") {
    		function alertName(){
 			alert("Erro. Digite apenas n?meros nas press?es.");}
 		}
 	</script>

    <nav role="navigation" class="menu-mobile">
        <div id="menuToggle">

            <input type="checkbox" />
            <span></span>
            <span></span>
            <span></span>

            <ul id="menu">
                <li><a href="../dashboard">Dashboard</a></li>
                <li>
                    <a href="../peso">Pesos</a>
                </li>
                <li>
                    <a href="../pressao">Press?o arterial</a>
                </li>
                <li>
                    <a href="../alimento">Alimenta??o</a>
                </li>
                <li>
                    <a href="../atividade">Atividades</a>
                </li>
                <li>
                    <a href="../login">Sair</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="menu">

        <ul>
            <li><a href="../dashboard">Dashboard</a></li>
            <li>
                <a href="../peso">Pesos</a>
            </li>
            <li>
                <a href="../pressao" class="selected">Press?o arterial</a>
            </li>
            <li>
                <a href="../alimento">Alimenta??o</a>
            </li>
            <li>
                <a href="../atividade">Atividades</a>
            </li>
        </ul>

        <button><a href="../login">Sair</a></button>
    </div>

    <div class="main pressao">

        <div class="header">

            <div class="text">

                <div class="title">Nova medi??o</div>

            </div>

        <div class="foto" style="background-image: url('${pageContext.request.contextPath}/assets/images/user/user.jpeg');">
        	<div class="foto" style="background-image: url('https://healthtrackstorageacc.blob.core.windows.net/perfil/${idUser}.jpeg');" onclick="perfil()">
        	</div>
        </div>

        </div>

        <form class="form" action="adicionar" method="post">

            <div class="item">
                <label for="sistolica">Press?o sist?lica (mmHg)</label>
                <input class="input" type="text" name="sistolica" maxlength="3" required>
            </div>

            <div class="item">
                <label for="diastolica">Press?o diast?lica (mmHg)</label>
                <input class="input" type="text" name="diastolica" maxlength="3" required>
            </div>

            <div class="item">
                <label for="data">Data da medi??o</label>
                <input class="input" type="date" name="data" required>
            </div>

            <div class="button">

                <button class="primary">Salvar</button>

            </div>

        </form>

    </div>

</body>

</html>

<script type="text/javascript"> window.onload = alertName; </script>
<script>
    function perfil() {
        window.location.href = "${pageContext.request.contextPath}/perfil";
    }
</script>