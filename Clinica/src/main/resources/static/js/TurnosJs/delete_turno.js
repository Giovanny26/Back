$(document).ready(function(){

    $(document).on("click", "table button.ml-2", function(){
            let id_of_button = (event.srcElement.id);
            let turnoId = id_of_button.split("_")[2];

            $.ajax({
                url: '/turnos/' + turnoId,
                type: 'DELETE',
                success: function(response) {
                    swal("Here's a message!")
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
