package checkhealthofcodebeta

class Problema {

	String titulo
	String enunciado
	String interfazAtestear
	String testsDeUnidad
	Date fechaDeCreacion
	Date ultimaModificacion
	Profesor profesorCreador


	static mapping = {
		enunciado type: "text"
		interfazAtestear type: "text"
		testsDeUnidad type: "text"
	}

  static constraints = {
		titulo nullable:false, blank: false
		enunciado nullable:false, blank: false
		interfazAtestear nullable:false, blank: false
		fechaDeCreacion nullable:false, blank: false
		ultimaModificacion nullable:false, blank: false
		profesorCreador nullable:false, blank: false
  }
}
