document.getElementById("answer").oninput = function() {
    var words = this.value.split(/\s+/).filter(function(word) {
        return word.length > 0;
    });
    var count = words.length;
    document.getElementById("accountant").textContent = count + "/500 palavras";
};