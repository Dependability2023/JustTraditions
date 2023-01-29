$(document).ready(function () {
    $("#dateStandard").blur(function () {
        var data = $("#dateStandard").val();
        var mydata = {dataVisita: data, idAnnuncio: 86};
        $.ajax({
            url: '/ricercaVisita',
            method: 'Post',
            data: mydata,
            success: function (data) {
                console.log(JSON.stringify(data));
            }
        });
    });
});

