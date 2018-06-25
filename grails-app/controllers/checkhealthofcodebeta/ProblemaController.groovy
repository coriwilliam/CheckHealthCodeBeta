package checkhealthofcodebeta

import grails.validation.ValidationException
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK

//@Secured("permitAll")
@Secured(['ROLE_USER'])
class ProblemaController {

    static scaffold = Problema
    ProblemaService problemaService

    def index(Integer max){
      params.max = Math.min(max ?: 10, 15)
      respond problemaService.list(params), model: [problemaCount: problemaService.count()]
    }

    def create() {
        respond new Problema(params)
    }

    def save(Problema problema) {
        if (problema == null) {
            notFound()
            return
        }
        try {
            problemaService.save(problema)
        } catch (ValidationException e) {
            respond problema.errors, view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code:"default.created.message", args: [message(code: "problema.label", default: "Problema"), problema.id]) as Object
                redirect Problema
            } as Map
            '*' { respond Problema, [status: CREATED] }
        }
    }


    protected void notFound() {
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(
//                        code: 'default.not.found.message',
//                        args: [message(code: 'problema.label', default: 'Problema'), params.id])
//                redirect action: "index", method: "GET"
//            }
//            '*' { render status: NOT_FOUND }
//        }
    }
}
