package checkhealthofcodebeta
import autenticacion.Usuario;


class Alumno extends Usuario {

		static hasMany = [tareas: Tarea]

    static constraints = {
    }
}
