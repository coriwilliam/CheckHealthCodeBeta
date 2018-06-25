

//Eventos

$("#btnProblema").on("click", function () {
    var contenidoInterfaz = $("pre.interfaz").text();
    var stringFinalInterfaz = CleanText.limpiarCodigo(contenidoInterfaz);
    $("#interfazAtestear").text(stringFinalInterfaz);


    var contenidoTestUnidad  = $("pre.testsUnidad").text();
    var stringFinalTests = CleanText.limpiarCodigo(contenidoTestUnidad)
    $("#testsDeUnidad").text(stringFinalTests)
});

var CleanText = (function () {
    function _limpiarInicio(text) {
        var i = 0;
        while( $.isNumeric(text[i]) ){
            i += 1;
        }
        return text.substr(i, text.length);
    }

    function _limpiarFinal(text){
        var i = 0;
        while( text[i] !== "X" && text[i+1] !== "X" ){
            i += 1;
        }
        return text.substr(0, i);
    }

    return {
        limpiarCodigo: function (text) {
            var textLimpiadoInicio = _limpiarInicio(text);
            return _limpiarFinal(textLimpiadoInicio);
        }
    }

})();


//Hacemos una especie de objeto estatico el cual tiene metodos estaticos que tienen que ser utiles para validar el contenido de los campos
//Habria que en el caso de que se puedan usar objetos corroborar que existe una entidad con ese nombre por medio de la definicion del Objeto

var UtilityValidator = (function () {

    this.matchResult = false;

    return {
        encontrarEntidad: function () {

            var contenidoTextArea = $("#nombreDeEntidad").val();
            var result = contenidoTextArea.length === 0 ? "no content" : contenidoTextArea;
            console.log(result);
        }
    }

})();