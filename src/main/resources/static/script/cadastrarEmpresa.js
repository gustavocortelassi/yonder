function validateCNPJ(event) {
    const input = event.target;
    if (input.value.length > 14) {
        input.value = input.value.slice(0, 14);
    }
}

function validateCEP(event) {
    const input = event.target;
    if (input.value.length > 8) {
        input.value = input.value.slice(0, 8);
    }
}