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
    <title>Editar Peso | Health Track</title>
</head>

<body>

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
                    <a href="../pressao">Pressão arterial</a>
                </li>
                <li>
                    <a href="../alimento">Alimentação</a>
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
                <a href="../peso" class="selected">Pesos</a>
            </li>
            <li>
                <a href="../pressao">Pressão arterial</a>
            </li>
            <li>
                <a href="../alimento">Alimentação</a>
            </li>
            <li>
                <a href="../atividade">Atividades</a>
            </li>
        </ul>

        <button><a href="../login">Sair</a></button>
    </div>

    <div class="main pesos">

        <div class="header">

            <div class="text">

                <div class="title">Editar peso</div>

            </div>

        <div class="foto" style="background-image: url('${pageContext.request.contextPath}/assets/images/user/user.jpeg');">
        	<div class="foto" style="background-image: url('https://healthtrackstorageacc.blob.core.windows.net/perfil/${idUser}.jpeg');" onclick="perfil()">
        	</div>
        </div>

        </div>

        <form class="form" action="editar/gravar" method="post">
        
        <input type="hidden" name="idPeso" value="${idPeso}">

            <div class="item">
                <label for="peso">Peso</label>
                <input class="input" type="text" name="peso" value="${peso}" maxlength="5" required>
            </div>

            <div class="item">
                <label for="data">Data da pesagem</label>
                <input class="input" type="date" name="data" value="${data}" required>
            </div>

            <div class="button">

                <button class="primary">Salvar</button>

            </div>

        </form>

    </div>

</body>

</html>


<script>
    function perfil() {
        window.location.href = "${pageContext.request.contextPath}/perfil";
    }
</script>