package checkhealthofcodebeta


class ProblemaController {

    static scaffold = Problema
    ProblemaService problemaService

    def index(Integer max){
      params.max = Math.min(max ?: 10, 15)
      respond problemaService.list(params), model: [problemaCount: problemaService.count()]
    }

    def creacion() {
      render "hola mundo"
    }
}
