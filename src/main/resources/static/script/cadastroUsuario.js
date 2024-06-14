function validateCPF(event) {
    const input = event.target;
    if (input.value.length > 11) {
        input.value = input.value.slice(0, 11);
    }
}