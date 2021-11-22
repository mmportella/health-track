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
    <title>Editar Medição | Health Track</title>
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
                <a href="../peso">Pesos</a>
            </li>
            <li>
                <a href="../pressao" class="selected">Pressão arterial</a>
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

    <div class="main pressao">

        <div class="header">

            <div class="text">

                <div class="title">Editar medição</div>

            </div>

            <div class="foto" onclick="perfil()"></div>

        </div>

        <form class="form" action="editar/gravar" method="post">
        
        <input type="hidden" name="idPressao" value="${idPressao}">

            <div class="item">
                <label for="sistolica">Pressão sistólica</label>
                <input class="input" type="text" name="sistolica" maxlength="3" value="${sistolica}" required>
            </div>

            <div class="item">
                <label for="diastolica">Pressão diastólica</label>
                <input class="input" type="text" name="diastolica" maxlength="3" value="${diastolica}" required>
            </div>

            <div class="item">
                <label for="data">Data da medição</label>
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
        window.location.href = "${pageContext.request.contextPath}/perfil/perfil.html";
    }
</script>