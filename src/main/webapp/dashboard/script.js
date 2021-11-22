//gráfico de peso
const chLine = document.getElementById("chLine");
const chartDataWeight = {
    // puxar últimos 7 dias de registro de peso
    labels: ["22/06", "05/07", "13/07", "24/07", "05/08", "12/08", "20/08"],
    datasets: [{
        data: [62.1, 63.2, 62.0, 63.4, 61.0, 61.5, 60.2],
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

//gráfico de alimentação
const chBar = document.getElementById("chBar");
let chartDataFood = {
    //puxar quantidade de calorias inseridas por dia da semana atual
    labels: ["D", "S", "T", "Q", "Q", "S", "S"],
    datasets: [{
        data: [1560, 1431, 1345, 1190, 1231, 1688, 1710],
        backgroundColor: [
            'rgba(5, 25, 55, 0.8)', 'rgba(0, 77, 122, 0.8)', 'rgba(0, 135, 147, 0.8)', 'rgba(35, 210, 226, 0.8)', 'rgba(0, 191, 114, 0.8)', 'rgba(168, 235, 18, 0.8)', 'rgba(208, 255, 107, 0.8)'
        ],
        borderColor: [
            '#051937', '#004d7a', '#008793', '#23d2e2', '#00bf72', '#a8eb12', '#d0ff6b'
        ],
        backgroundOpacity: 0.2,
        borderWidth: 4,
        pointBackgroundColor: '#051937'

    }]

};



if (chBar) {

    new Chart(chBar, {

        type: 'bar',

        data: chartDataFood,

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

function perfil() {
    window.location.href = "../perfil/perfil.html";
}