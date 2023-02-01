$(document).ready(function () {

    $("#dataVisita").blur(function () {
        var data = $("#dataVisita").val();
        var today = new Date();
        var day = today.getDate();
        var month = today.getMonth() + 1;
        var year = today.getFullYear();
        if(day> 0 && day<= 9){
            day="0"+day;
        }
        if(month> 0 && month<= 9){
            month="0"+month;
        }
        var dataodierna = year+'-'+month+'-'+day;

        $("#listavisite").empty();


        if(data == ""){
            return;
        }

        if(dataodierna >= data){
            $("#listavisite").append('<option>Data nel passato</option>');
            return
        }

        var mydata = {dataVisita: data, idAnnuncio: $("#idAnnuncio").val()};
        $("#listavisite").empty();
        $.ajax({
            url: '/ricercaVisita',
            method: 'Post',
            data: mydata,
            success: function (data) {


                if(data.length == 0){
                    $("#listavisite").append('<option>Nessuna visita</option>');
                }else{
                    $("#listavisite").append('<option>Seleziona una visita</option>');
                    data.map(visita =>{
                        $("#listavisite").append('<option value="'+visita.id+'">'+visita.orarioInizio+'-'+visita.orarioFine+'</option>');

                    })
                }
            }
        });
    });
}




);