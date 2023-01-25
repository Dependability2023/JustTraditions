$(document).ready(function () {
    $("#divMotivo").hide();
    $("#nuovoStato").change(function () {
        if ($("#nuovoStato option:selected" ).val() == "RIFIUTATO") {
            $("#divMotivo").show();
        }else{
            $("#divMotivo").hide();
        }
    });
});