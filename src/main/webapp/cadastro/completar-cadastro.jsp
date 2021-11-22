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
    <title>Cadastrar | Health Track</title>
</head>

<body>

    <div class="login-bg">

        <div class="login-bg-modal">

            <div class="login-bg-modal-image">

                <img src="${pageContext.request.contextPath}/assets/images/new/yoga.svg" alt="Ilustração de uma mulher praticando yoga." width="100%" height="100%">

            </div>

            <div class="login-bg-modal-form">

                <div class="header">

                    <div class="title">Cadastre-se</div>

                    <span class="text-light">Já possui uma conta? <a href="${pageContext.request.contextPath}/index.jsp" class="link">Login</a></span>

                </div>

                <form class="form" action="continuar" method="post">

					<input type="hidden" name="nome" value="${nome}">
					<input type="hidden" name="data" value="${data}">
					<input type="hidden" name="email" value="${email}">
					<input type="hidden" name="senha" value="${senha}">

                    <div class="item">
                        <label for="altura">Altura (cm)</label>
                        <input type="text" name="altura" required>
                    </div>

                    <div class="item">
                        <label for="genero">Gênero</label>
                        <select name="genero" id="genero" required>

                            <option value="default" disabled selected>Selecione</option>
                            <option value="f">Feminino</option>
                            <option value="m">Masculino</option>
    
                        </select>
                    </div>

                    <div class="button">

                        <button class="primary">Cadastrar</button>

                    </div>

                </form>

            </div>

        </div>

    </div>

</body>

</html>