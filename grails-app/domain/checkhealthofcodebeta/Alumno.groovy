package checkhealthofcodebeta
import authenticacion.User


class Alumno extends User {

    static hasMany = [tareas: Tarea]

    static constraints = {
    }
}
