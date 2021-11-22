<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
    <link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/favicon/favicon-16x16.png">
    <title>Dashboard | Health Track</title>
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
            <li><a href="dashboard" class="selected">Dashboard</a></li>
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

    <div class="dashboard-header">

        <div class="text">

            <div class="title">Olá, ${nomeUsuario}</div>
            <div class="subtitle">${idade} anos</div>

        </div>

        <div class="foto" onclick="perfil()"></div>

    </div>

    <div class="main dashboard">


        <div class="dashboard-charts">

            <div class="card-chart" id="weight">
                <h2 class="chart-title">
                
                <c:set var="status" value="${peso0}"/>
                <%
                        if (Float.parseFloat(pageContext.getAttribute("status").toString()) == 0.0f) {
                        	out.print("Peso (Dados insuficientes - cadastre seu peso por 7 dias)");
                        } else {
                        	out.print("Peso");
                        }
                 %>
                
                </h2>
                <canvas id="chLine"> </canvas>
            </div>

            

        </div>

        <div class="dashboard-list">

            <div class="card">

                <div class="date">${hoje}</div>

                <div class="info">

                    <div class="icon weight"></div>
                    <div class="data">${imc}</div>

                </div>

                <div class="description">${imcStatus}</div>

            </div>

            <div class="card">

                <div class="date">${hoje}</div>

                <div class="info">

                    <div class="icon pressure"></div>
                    <div class="data">${sistolica}/${diastolica}</div>

                </div>

                <div class="description">${pressaoStatus}</div>

            </div>

            <div class="card">

                <div class="date">${hoje}</div>

                <div class="info">

                    <div class="icon height"></div>
                    <div class="data">${altura}m</div>

                </div>

                <div class="description">Altura</div>

            </div>

        </div>

    </div>

</body>

</html>

<script type="text/javascript">
const chLine = document.getElementById("chLine");
const chartDataWeight = {
    labels: ["${data0}", "${data1}", "${data2}", "${data3}", "${data4}", "${data5}", "${data6}"],
    datasets: [{
        data: [${peso0}, ${peso1}, ${peso2}, ${peso3}, ${peso4}, ${peso5}, ${peso6}],
        backgroundColor: '#a8caff',
        borderColor: '#007bff',
        borderWidth: 4,
        pointBackgroundColor: '#007bff'
    }]
};

if (chLine) {
    new Chart(chLine, {
        type: 'line',
        data: chartDataWeight,
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: false
                    }
                }]
            },
            legend: {
                display: false
            }
        }
    });
}
</script>


<script type="text/javascript">
function perfil() {
    window.location.href = "../perfil/perfil.html";
}
</script>


