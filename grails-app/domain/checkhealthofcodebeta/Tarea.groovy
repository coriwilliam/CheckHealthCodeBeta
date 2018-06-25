package checkhealthofcodebeta

class Tarea {

	Problema problema
	Resolucion resolucion
	static hasMany = [comentarios: Comentario]

	static constraints = {
	}
}
