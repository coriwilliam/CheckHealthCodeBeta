package checkhealthofcodebeta

class Alumno extends Usuario {

	static hasMany = [tareas: Tarea]

    static constraints = {
    }
}
