const titulos = [
    "A diversidade cultural é um dos pilares da riqueza da humanidade, contribuindo para o enriquecimento cultural, social e econômico de sociedades ao redor do mundo. No entanto, em um contexto de globalização crescente, essa diversidade muitas vezes é ameaçada. Redija um texto de até 500 palavras cumprindo a norma da língua inglesa. A importância da diversidade cultural no cenário global. ",
    "A evolução da inteligência artificial tem transformado radicalmente diversos setores da sociedade, desde a economia até a saúde. No entanto, esse avanço tecnológico também traz desafios e preocupações em relação ao emprego, privacidade e ética. Redija um texto de até 500 palavras cumprindo a norma da língua inglesa. O impacto da inteligência artificial na sociedade contemporânea. ",
    "A juventude desempenha um papel crucial na promoção da sustentabilidade e na busca por soluções para os desafios ambientais globais. Redija um texto de até 500 palavras cumprindo a norma da língua inglesa. O papel da juventude na construção de um mundo mais sustentável. "
];

const titulo = titulos[Math.floor(Math.random() * titulos.length)];

document.getElementById('title').innerHTML = `<p>${titulo}</p>`;

document.getElementById("answer").oninput = function() {
    var words = this.value.split(/\s+/).filter(function(word) {
        return word.length > 0;
    });
    var count = words.length;
    document.getElementById("accountant").textContent = count + "/500 palavras";
};