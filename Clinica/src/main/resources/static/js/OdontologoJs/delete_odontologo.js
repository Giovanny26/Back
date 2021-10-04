$(document).ready(function(){

    $(document).on("click", "table button.ml-2", function(){
            let id_of_button = (event.srcElement.id);
            let odontologoId = id_of_button.split("_")[2];

            $.ajax({
                url: '/odontologos/' + odontologoId,
                type: 'DELETE',
                success: function(response) {
                    alert("El Odontologo con ID " + odontologoId + " se elimino correctamente")
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
