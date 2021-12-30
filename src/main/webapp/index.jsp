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
    <title>Login | Health Track</title>

</head>

<body>

    <div class="login-bg">

        <div class="login-bg-modal">

            <div class="login-bg-modal-image">

                <img src="assets/images/login/art.svg" alt="Ilustração de um homem correndo ao lado de um smartphone com um coração na tela." width="100%" height="100%">

            </div>

            <div class="login-bg-modal-form">

                <div class="header">

                    <div class="title">Login</div>

                    <span class="text-light">Não possui uma conta? <a href="${pageContext.request.contextPath}/cadastro" class="link">Cadastre-se!</a></span>

                </div>

                <form class="form" action="login" method="post">

                    <div class="item">
                        <label for="email">Email</label>
                        <input type="email" name="email" required>
                    </div>

                    <div class="item">
                        <label for="senha">Senha</label>
                        <input type="password" name="senha" required>
                    </div>

                    <a href="esqueci-minha-senha.html" class="link-secondary">Esqueci minha senha</a>

                    <div class="button">

                        <button class="primary" type="submit">Entrar</button>

                        <div class="remember">

                            <input type="checkbox" name="password" class="checkbox">

                            <span class="text-light">Lembrar dados de acesso</span>

                        </div>

                    </div>

                </form>

            </div>

        </div>

    </div>

</body>

</html>