$(document).ready(function() {
    $("#add_new_turno").submit(function(evt) {
        evt.preventDefault();
        
        let formData = {
            date : $("#date").val(),
            paciente: {
                id: $("#idPaciente").val()
            },
            odontologo: {
                id: $("#idOdontologo").val()
            }
        }

        $.ajax({
            url: '/turnos',
            type: 'POST',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false,
            success: function (response) {
                let turno = response
                console.log(response)
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong></strong> turno agregado </div>'
                $("#response").append(successAlert);
                $("#response").css({"display": "block"});
                console.log(formData)
                resetUploadForm();
            },
            error: function (response) {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error intente nuevamente</strong> </div>'
                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});

                resetUploadForm();
            }
        });
    });

    function resetUploadForm(){
        $("#date").val("");
        $("#idPaciente").val("");
        $("#idOdontologo").val("");

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            $(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/turno.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});