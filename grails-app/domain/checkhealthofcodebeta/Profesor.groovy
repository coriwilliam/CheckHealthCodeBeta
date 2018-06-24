package checkhealthofcodebeta

class Profesor {
    String nombre
    static hasMany = [problemas: Problema]
    static constraints = {
    }
}
