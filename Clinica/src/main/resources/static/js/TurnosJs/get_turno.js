$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/turnos",
            success: function(response){
              $.each(response, (i, turno) => {
                console.log(turno)
                 let delete_Btn = '<button' +
                                                            ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                                            ' type="button" class="btn  btn-danger ml-2">' +
                                                            "Eliminar" +
                                                            '</button>';
                let tr_id = 'tr_' + turno.id;
                let turnoRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td>' + turno.id + '</td>' +
                          '<td class=\"td_first_name\">' + turno.date + '</td>' +
                          '<td class=\"td_paciente_nombre\">' + turno.paciente.nombre + '</td>' +
                          '<td class=\"td_paciente_apellido\">' + turno.paciente.apellido + '</td>' +
                          '<td class=\"td_odontologo_nombre\">' + turno.odontologo.nombre + '</td>' +
                          '<td class=\"td_odontologo_apellido\">' + turno.odontologo.apellido + '</td>' +
                          '<td>' + delete_Btn + '</td>' +
                          '</tr>';
                $('#turnoTable tbody').append(turnoRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();        
    
    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/turno.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});