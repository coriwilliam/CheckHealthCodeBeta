package checkhealthofcodebeta

class Problema {

	String titulo
	String enunciado
	String interfazAtestear
	String testsDeUnidad
	Date fechaDeCreacion
	Date ultimaModificacion
	Static hasMany = [alumnos: Alumno]

    static constraints = {
    }
}
