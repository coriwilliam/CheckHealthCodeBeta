package checkhealthofcodebeta

class Resolucion {
    String  codigo
    String nombreEntidad

    static mapping = {
        codigo type: "text"
    }

    static constraints = {
      codigo blank: true, nullable:false
      nombreEntidad blank: false, nullable:false
    }
}
