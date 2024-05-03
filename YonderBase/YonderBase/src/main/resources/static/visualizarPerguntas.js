document.addEventListener('DOMContentLoaded', function () {
    var audioFileInput = document.getElementById('audioFileInput');
    var editAudioInput = document.getElementById('editAudioInput');
    var selectElement = document.getElementById("tipoProvaSelect");

    // Function to control the visibility of input fields
    function toggleAudioInputsVisibility() {
        if (selectElement.value === 'Listening') {
            audioFileInput.style.display = 'block';
            editAudioInput.style.display = 'block';
        } else {
            audioFileInput.style.display = 'none';
            editAudioInput.style.display = 'none';
        }
    }
    selectElement.addEventListener("change", toggleAudioInputsVisibility);

    toggleAudioInputsVisibility();
});

var filterSelect = document.getElementById('filterSelect');
var questionRows = document.querySelectorAll('.question-row');
filterSelect.addEventListener('change', function () {
    var selectedOption = this.value;
    questionRows.forEach(function (row) {
        if (selectedOption === '1') {
            if (row.querySelector('td:nth-child(4)').textContent !== 'Reading Normal') {
                row.style.display = 'none';
            } else {
                row.style.display = '';
            }
        } else if (selectedOption === '2') {
            if (row.querySelector('td:nth-child(4)').textContent !== 'Reading Preenchimento') {
                row.style.display = 'none';
            } else {
                row.style.display = '';
            }
        } else if (selectedOption === '3') {
            if (row.querySelector('td:nth-child(4)').textContent !== 'Listening') {
                row.style.display = 'none';
            } else {
                row.style.display = '';
            }
        } else if (selectedOption === '4') {
            if (row.querySelector('td:nth-child(4)').textContent !== 'Writing') {
                row.style.display = 'none';
            } else {
                row.style.display = '';
            }
        } else {
            row.style.display = '';
        }
    });
});
