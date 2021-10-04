$(document).ready(function(){

    $(document).on("click", "table button.ml-2", function(){
            let id_of_button = (event.srcElement.id);
            let pacienteId = id_of_button.split("_")[2];

            $.ajax({
                url: '/pacientes/' + pacienteId,
                type: 'DELETE',
                success: function(response) {
                    alert("El paciente con ID " + pacienteId + " se elimino correctamente")
                       setTimeout(function(){
                               window.location.reload();
                             }, 1000);
                },
                error: function(error){
                    console.log(error);
                    alert("Error -> " + error);
                }
            });
        });



});
