package checkhealthofcodebeta

import authenticacion.User

class Profesor extends User {
    static hasMany = [problemas: Problema]
    static constraints = {
    }
}
