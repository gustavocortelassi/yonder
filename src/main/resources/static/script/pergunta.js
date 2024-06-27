document.addEventListener('DOMContentLoaded', function () {
    var audioFileInput = document.getElementById('audioFileInput');
    var tipoProvaRadios = document.querySelectorAll('input[name="tipoProvaId"]');
    tipoProvaRadios.forEach(function (radio) {
        radio.addEventListener('change', function () {
            if (this.value === 'Listening') {
                audioFileInput.style.display = 'block';
            } else {
                audioFileInput.style.display = 'none';
            }
        });
    });
    $('input[name="tipoProvaId"]').change(function() {
        var selectedValue = $(this).val();
        if (selectedValue === 'Listening' || selectedValue === 'Reading') {
            $('#respostasSection').show();
        } else {
            $('#respostasSection').hide();
        }
    });

    var filterSelect = document.getElementById('filterSelect');
    var questionRows = document.querySelectorAll('.question-row');
    filterSelect.addEventListener('change', function () {
        var selectedOption = this.value;
        questionRows.forEach(function (row) {
            if (selectedOption === '1') {
                if (row.querySelector('td:nth-child(2)').textContent !== 'Reading') {
                    row.style.display = 'none';
                } else {
                    row.style.display = '';
                }
            } else if (selectedOption === '3') {
                if (row.querySelector('td:nth-child(2)').textContent !== 'Listening') {
                    row.style.display = 'none';
                } else {
                    row.style.display = '';
                }
            } else if (selectedOption === '4') {
                if (row.querySelector('td:nth-child(2)').textContent !== 'Writing') {
                    row.style.display = 'none';
                } else {
                    row.style.display = '';
                }
            } else {
                row.style.display = '';
            }
        });
    });

});

$(".vizualizarPergunta").click(function (){
    var perguntaId = $(this).closest('tr').find('td:nth-child(1)').text();
    var tipoProvaId = $(this).closest('tr').find('td:nth-child(2)').text();
    var cabecalho = $(this).closest('tr').find('td:nth-child(3)').text();
    var dificuldade = $(this).closest('tr').find('td:nth-child(4)').text();
    var niveisId = $(this).closest('tr').find('td:nth-child(5)').text();
    console .log(niveisId)
    var audio = $(this).closest('tr').find('td:nth-child(6)').text();

    if (tipoProvaId === 'Listening') {
        tipoProvaId === 1;
    } else if (tipoProvaId === 'Reading Preenchimento') {
        tipoProvaId === 2;
    } else if (tipoProvaId === 'Writing') {
        tipoProvaId === 3;
    }
    if (tipoProvaId === 'Listening') {
        $('#viewAudio').show();
    } else {
        $('#viewAudio').hide();
    }

    if (niveisId === '1') {
        niveisId = 'A1';
    } else if (niveisId === '2') {
        niveisId = 'A2';
    } else if (niveisId === '3') {
        niveisId = 'B1';
    } else if (niveisId === '4') {
        niveisId = 'B2';
    } else if (niveisId === '5') {
        niveisId = 'C1';
    }  else if (niveisId === '6') {
        niveisId = 'C2';
    } else {
        niveisId = 'Nível não informado';
    }

    $("#viewId").val(perguntaId);
    $("#viewCabecalho").val(cabecalho);
    $("#viewDificuldade").val(dificuldade);
    $("#viewTipoProva").val(tipoProvaId);
    $("#viewNiveisId").val(niveisId);
    $("#viewAudioInput").val(audio);



    $('#viewModal').modal('show');
});

$(document).ready(function() {
    $('input[name="tipoProvaId"]').on('change', function() {
        if ($(this).val() === 'Listening') {
            $('#audioFileInput').show();
        } else {
            $('#audioFileInput').hide();
            $('#audioFile').val('');
        }
    });

    $('#addForm').on('submit', function(event) {
        event.preventDefault();

        var formData = {
            tipoProvaId: $('input[name="tipoProvaId"]:checked').val(),
            cabecalho: $('#cabecalhoInput').val(),
            dificuldade: $('#dificuldadeInput').val(),
            niveisId: $('select[name="niveisId"]').val(),
            audio: $('#audioFile').val(),
            resposta: []
        };

        $('.resposta').each(function(index) {
            var respostaInput = $(this).find('input[type="text"]');
            var respostaCorreta = $(this).find('input[type="radio"]').is(':checked');

            formData.resposta.push({
                titulo: respostaInput.val(),
                correto: respostaCorreta,
                ordem: index + 1
            });
        });

        console.log('Form Data:', formData);

        $.ajax({
            type: 'POST',
            url: '/savePergunta',
            data: JSON.stringify(formData),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function(response) {
                console.log('Success:', response);
                Swal.fire(
                    'Adicionado!',
                    'A pergunta foi adicionada com sucesso.',
                    'success'
                ).then((result) => {
                    location.reload();
                });
            },
            error: function(xhr, status, error) {
                console.log('Error:', xhr, status, error);
                Swal.fire(
                    'Erro!',
                    'Ocorreu um erro ao adicionar a pergunta. Por favor, tente novamente mais tarde.',
                    'error'
                );
            }
        });
    });

    $("#editTipoProva").change(function() {
        var tipoProva = $(this).val();
        if (tipoProva === 'Listening') {
            $('#editAudio').show();
        } else {
            $('#editAudio').hide();
        }
    });

    $(".editar-pergunta").click(function() {
        var perguntaId = $(this).attr('data');
        var tipoProvaId = $(this).closest('tr').find('td:nth-child(2)').text().trim();
        var cabecalho = $(this).closest('tr').find('td:nth-child(3)').text().trim();
        var dificuldade = $(this).closest('tr').find('td:nth-child(4)').text().trim();
        var niveisId = $(this).closest('tr').find('td:nth-child(5)').text().trim();
        var audio = $(this).closest('tr').find('td:nth-child(6)').text().trim();

        switch (niveisId) {
            case 'A1':
                niveisId = '1';
                break;
            case 'A2':
                niveisId = '2';
                break;
            case 'B1':
                niveisId = '3';
                break;
            case 'B2':
                niveisId = '4';
                break;
            case 'C1':
                niveisId = '5';
                break;
            case 'C2':
                niveisId = '6';
                break;
            default:
                niveisId = '';
                break;
        }

        $("#editId").val(perguntaId);
        $("#editCabecalho").val(cabecalho);
        $("#editDificuldade").val(dificuldade);
        $("#editTipoProva").val(tipoProvaId);
        $("#editNiveisId").val(niveisId);
        $("#editAudioInput").val(audio);

        if (tipoProvaId === 'Listening') {
            $('#editAudio').show();
        } else {
            $('#editAudio').hide();
        }

        $("#editRespostasSection").empty();

        $.ajax({
            url: '/pergunta/' + perguntaId + '/respostas',
            type: 'GET',
            success: function(response) {
                var respostas = response.respostas;
                if (respostas && respostas.length > 0) {
                    respostas.forEach(function(resposta, index) {
                        var respostaHtml = `
                        <div class="mb-3 resposta">
                            <label for="editResposta${index + 1}" class="form-label">Resposta ${index + 1}:</label>
                            <div class="d-flex align-items-center">
                                <input type="text" class="form-control" id="editResposta${index + 1}" name="respostas[${index}].titulo" value="${resposta.titulo}">
                                <div class="form-check ms-2">
                                    <input class="form-check-input" type="radio" name="respostaCorreta" id="editRespostaCorreta${index + 1}" value="${index}" ${resposta.correta ? 'checked' : ''}>
                                    <label class="form-check-label" for="editRespostaCorreta${index + 1}">Correta</label>
                                </div>
                            </div>
                        </div>
                    `;
                        $("#editRespostasSection").append(respostaHtml);
                    });
                }
            },
            error: function(response) {
                console.error("Erro ao buscar respostas da pergunta:", response);
            }
        });
        $('#editModal').modal('show');
    });


    $(document).ready(function() {
        $(".editSave").click(function(e) {
            e.preventDefault();
            var perguntaId = $("#editId").val();
            salvarEdicao(perguntaId);
        });
    });

    function salvarEdicao(perguntaId) {
        var cabecalho = $("#editCabecalho").val();
        var dificuldade = $("#editDificuldade").val();
        var tipoProvaId = $("#editTipoProva").val();
        var niveisId = $("#editNiveisId").val();
        var audio = $("#editAudioInput").val();
        var respostas = [];

        $(".resposta").each(function(index) {
            var titulo = $(this).find('input[type="text"]').val();
            var correto = $(this).find('input[type="radio"]').is(':checked');
            respostas.push({
                titulo: titulo,
                correto: correto
            });
        });

        $.ajax({
            url: '/pergunta/editar/' + perguntaId,
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                cabecalho: cabecalho,
                dificuldade: dificuldade,
                tipoProvaId: tipoProvaId,
                niveisId: niveisId,
                audio: audio,
                respostas: respostas
            }),
            success: function(response) {
                Swal.fire(
                    'Salvo!',
                    'A pergunta foi salva com sucesso.',
                    'success'
                ).then((result) => {
                    location.reload();
                });
            },
            error: function(response) {
                Swal.fire(
                    'Erro!',
                    'Houve um erro ao salvar a pergunta.',
                    'error'
                );
            }
        });

        $('#editModal').modal('hide');
    }



    $(document).ready(function(){
    $(".excluir-pergunta").click(function(e){
        e.preventDefault();
        var perguntaId = $(this).attr('data');
        console.log(perguntaId);
        excluirPergunta(perguntaId);
    });
});

function excluirPergunta(perguntaId) {
    var perguntaId = perguntaId || perguntaId.val();
    console.log(perguntaId);
    event.preventDefault();
    Swal.fire({
        title: 'Você tem certeza?',
        text: "Você não poderá reverter isso!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sim, exclua!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: '/pergunta/delete/' + perguntaId,
                type: 'DELETE',
                success: function (response) {
                    Swal.fire(
                        'Excluído!',
                        'A pergunta foi excluída com sucesso.',
                        'success'
                    ).then((result) => {
                        location.reload();
                    });
                },
                error: function (response) {
                    Swal.fire(
                        'Erro!',
                        'Houve um erro ao excluir a pergunta.',
                        'error'
                    );
                }
            });
        }
    });
}});
