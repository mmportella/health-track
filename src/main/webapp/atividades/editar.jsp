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
    <title>Editar Atividade | Health Track</title>
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
                    <a href="../pressao">Press�o arterial</a>
                </li>
                <li>
                    <a href="../alimento">Alimenta��o</a>
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
                <a href="../pressao">Press�o arterial</a>
            </li>
            <li>
                <a href="../alimento">Alimenta��o</a>
            </li>
            <li>
                <a href="../atividade" class="selected">Atividades</a>
            </li>
        </ul>

        <button><a href="../login">Sair</a></button>
    </div>

    <div class="main atividades">

        <div class="header">

            <div class="text">

                <div class="title">Editar atividade</div>

            </div>

            <div class="foto" style="background-image: url('${pageContext.request.contextPath}/assets/images/user/${idUser}.jpeg');" onclick="perfil()">
        <div class="foto" style="background-image: url('${pageContext.request.contextPath}/assets/images/user/1.jpeg');"></div></div>

        </div>

        <form class="form" action="editar/gravar" method="post">

			<input type="hidden" name="idAtividade" value="${idAtividade}">

            <div class="item">
                <label for="categoria">Categoria</label>
                <select name="categoria" required>

                    <option value="" disabled selected>Selecione</option>
                    <option value="Caminhada">Caminhada</option>
                    <option value="Corrida">Corrida</option>
                    <option value="Bicicleta">Bicicleta</option>
                    <option value="Muscula��o">Muscula��o</option>
                    <option value="Nata��o">Nata��o</option>
                    <option value="Futebol">Futebol</option>
                    <option value="T�nis">T�nis</option>

                </select>
            </div>

            <div class="item">
                <label for="calorias">Qtd. de calorias queimadas</label>
                <input class="input" type="text" name="kcal" value="${kcal}" maxlength="4" required>
            </div>

            <div class="item">
                <label for="descricao">Descri��o (opcional)</label>
                <input class="input" type="text" name="descricao" maxlength="20" value="${descricao}">
            </div>

            <div class="item">
                <label for="data">Data da atividade</label>
                <input class="input" type="datetime-local" name="data" value="${data}" required>
            </div>

            <div class="button">

                <button class="primary">Salvar</button>

            </div>

    </div>

    </form>

</body>

</html>

<script>
    function perfil() {
        window.location.href = "${pageContext.request.contextPath}/perfil";
    }
</script>