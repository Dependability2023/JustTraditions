$(document).ready(function () {
        $("#listavisite").blur(function () {

            var mydata = {dataVisita: $("#dataVisita").val(), idVisita: $("#listavisite").val()};

            $.ajax({
                url: '/numMaxPersone',
                method: 'Post',
                data: mydata,
                success: function (data) {
                    $("#numpersone").val(1);
                    $("#numpersone").attr({
                        "max" : data
                    });
                }
            });
        });
    }




);