 document.getElementById("resposta").oninput = function() {
    var words = this.value.split(/\s+/).filter(function(word) {
    return word.length > 0;
});
    var count = words.length;
    document.getElementById("wordCount").textContent = count + "/500 palavras";
};