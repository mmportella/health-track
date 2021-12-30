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
    <title>Perfil | Health Track</title>
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
                    <a href="pressao">Pressão arterial</a>
                </li>
                <li>
                    <a href="alimento">Alimentação</a>
                </li>
                <li>
                    <a href="atividade">Atividades</a>
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
                <a href="pressao">Pressão arterial</a>
            </li>
            <li>
                <a href="alimento">Alimentação</a>
            </li>
            <li>
                <a href="atividade">Atividades</a>
            </li>
        </ul>

        <button><a href="login">Sair</a></button>
    </div>

    <div class="perfil">

        <div class="header">

        <div class="foto" style="background-image: url('${pageContext.request.contextPath}/assets/images/user/user.jpeg');">
        	<div class="foto" style="background-image: url('https://healthtrackstorageacc.blob.core.windows.net/perfil/${idUser}.jpeg');" onclick="perfil()">
        	</div>
        </div>
        
        <div style="margin:20px; padding:5px; font-family: WorkSans; font-weight: bolder; font-size: 1em;">
        	
        	<form action="perfil/foto" method="post" enctype="multipart/form-data">
        	Mudar Foto de Perfil: <input type="file" name="imagem">
        	<input type="submit" value="Salvar">
        	</form>
        	
        </div>

        </div>

        <div class="infos">

            <div>
            
            <form class="form" id="formulario" action="${pageContext.request.contextPath}/perfil" method="post">

                <div class="item">
                    <label for="nome" required>Nome completo</label>
                    <input class="input" type="text" name="nome" disabled value="${nome}">
                </div>

                <div class="item">
                    <label for="dataNasc" required>Data de nascimento</label>
                    <input class="input" type="date" id="dataNasc" name="data" disabled value="${data}">
                </div>

                <div class="item">
                    <label for="email" required>Email</label>
                    <input class="input" id="emails" type="email" disabled value="${email}">
                    <input type="hidden" name="email" value="${email}">
                </div>

                <div class="item">
                    <label for="altura" required>Altura</label>
                    <input class="input" type="text" name="altura" disabled value="${altura}">
                </div>
                
                <div class="item">
                        <label for="genero">Gênero</label>
                        <select name="genero" id="genero" disabled required>

                            <option value="${genero}" id="genero2" disabled selected>${genero}</option>
                            <option value="Feminino">Feminino</option>
                            <option value="Masculino">Masculino</option>
    
                        </select>
                    </div>

                <div class="item">
                    <label for="senha" required>Senha Atual</label>
                    <input class="input" type="password" name="senha" disabled>
                </div>

                <div class="item">
                    <label for="senha" required>Nova senha</label>
                    <input class="input" type="password" name="novasenha" disabled>
                </div>
                
                <div class="item">
                    <label for="senha" required>Confirme a nova senha</label>
                    <input class="input" type="password" name="novasenha2" disabled>
                </div>
                
                </form>

				<div class="button" style="padding:3%;text-align:center;">
                    <button class="primary" id="editarPerfil" onclick="editar()">Editar</button>
                    <button class="none" id="salvarPerfil" onclick="salvar()">Salvar</button>
                </div>

            </div>

        </div>


    </div>

<script>
    function editar() {
        let inputs = document.getElementsByClassName("input");
        let btnEditar = document.getElementById("editarPerfil");
        let btnSalvar = document.getElementById("salvarPerfil");

        console.log(inputs)
        
        genero.disabled = false;
        genero2.disabled = false;
        genero2.selected = false;

        for (let i = 0; i < inputs.length; i++) {
            const el = inputs[i];
            el.disabled = false;
        }
        
        emails.disabled = true;
        
        dataNasc.nextSibling = "date"

        btnEditar.classList.add("none");
        btnSalvar.classList.remove("none");
        btnSalvar.classList.add("primary");

    }

    function salvar() {

    	document.getElementById("formulario").submit();
    }
</script>

</body>

</html>