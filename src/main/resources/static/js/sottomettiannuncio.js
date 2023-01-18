$(document).ready(function () {

    var wrapper0 = $(".container0");
    var wrapper1 = $(".container1");
    var wrapper2 = $(".container2");
    var wrapper3 = $(".container3");
    var wrapper4 = $(".container4");
    var wrapper5 = $(".container5");
    var wrapper6 = $(".container6");
    var wrapper7 = $(".container7");

    var lunedi = $(".add_form_field0");
    var martedi = $(".add_form_field1");
    var mercoledi = $(".add_form_field2");
    var giovedi = $(".add_form_field3");
    var venerdi = $(".add_form_field4");
    var sabato = $(".add_form_field5");
    var domenica = $(".add_form_field6");
    var addFoto = $(".add_form_field7");


    $(addFoto).click(function (e) {
        e.preventDefault();
        $(wrapper7).append('<div><input type="file"><a href="#" class="delete"> x</a></div>'); //add input box

    });

    $(lunedi).click(function (e) {
        e.preventDefault();
        $(wrapper0).append('<div><input type="hidden" name="giorno" value="MONDAY"><input type="time"name="orarioInizio" ><input type="time"name="orarioFine" ><a href="#" class="delete"> x</a></div>'); //add input box

    });

    $(martedi).click(function (e) {
        e.preventDefault();
        $(wrapper1).append('<div><input type="hidden" name="giorno" value="TUESDAY"><input type="time"name="orarioInizio" ><input type="time"name="orarioFine" ><a href="#" class="delete"> x</a></div>'); //add input box

    });

    $(mercoledi).click(function (e) {
        e.preventDefault();
        $(wrapper2).append('<div><input type="hidden" name="giorno" value="WEDNESDAY"><input type="time"name="orarioInizio" ><input type="time"name="orarioFine" ><a href="#" class="delete"> x</a></div>'); //add input box

    });

    $(giovedi).click(function (e) {
        e.preventDefault();
        $(wrapper3).append('<div><input type="hidden" name="giorno" value="THURSDAY"><input type="time"name="orarioInizio" ><input type="time"name="orarioFine" ><a href="#" class="delete"> x</a></div>'); //add input box

    });

    $(venerdi).click(function (e) {
        e.preventDefault();
        $(wrapper4).append('<div><input type="hidden" name="giorno" value="FRIDAY"><input type="time"name="orarioInizio" ><input type="time"name="orarioFine" ><a href="#" class="delete"> x</a></div>'); //add input box

    });

    $(sabato).click(function (e) {
        e.preventDefault();
        $(wrapper5).append('<div><input type="hidden" name="giorno" value="SATURDAY"><input type="time"name="orarioInizio" ><input type="time"name="orarioFine" ><a href="#" class="delete"> x</a></div>'); //add input box

    });

    $(domenica).click(function (e) {
        e.preventDefault();
        $(wrapper6).append('<div><input type="hidden" name="giorno" value="SUNDAY"><input type="time"name="orarioInizio" ><input type="time"name="orarioFine" ><a href="#" class="delete"> x</a></div>'); //add input box

    });

    $(wrapper0).on("click", ".delete", function (e) {
        e.preventDefault();
        $(this).parent('div').remove();
    })
    $(wrapper1).on("click", ".delete", function (e) {
        e.preventDefault();
        $(this).parent('div').remove();
    })
    $(wrapper2).on("click", ".delete", function (e) {
        e.preventDefault();
        $(this).parent('div').remove();
    })
    $(wrapper3).on("click", ".delete", function (e) {
        e.preventDefault();
        $(this).parent('div').remove();
    })
    $(wrapper4).on("click", ".delete", function (e) {
        e.preventDefault();
        $(this).parent('div').remove();
    })
    $(wrapper5).on("click", ".delete", function (e) {
        e.preventDefault();
        $(this).parent('div').remove();
    })
    $(wrapper6).on("click", ".delete", function (e) {
        e.preventDefault();
        $(this).parent('div').remove();
    })
    $(wrapper7).on("click", ".delete", function (e) {
        e.preventDefault();
        $(this).parent('div').remove();
    })
});