package checkhealthofcodebeta

import grails.validation.ValidationException
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK


@Secured(['ROLE_USER'])
class ProblemaController {

    static scaffold = Problema
    ProblemaService problemaService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max){
      params.max = Math.min(max ?: 10, 15)
      respond problemaService.list(params), model: [problemaCount: problemaService.count()]
    }

    def create() {
        respond new Problema(params)
    }

    def show(Long id){
        respond problemaService.get(id)
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
                flash.message = message(
                        code:'default.created.message',
                        args: [message(
                                code: 'problema.label',
                                default: 'Problema'), problema.id])
                redirect problema
            }
            '*' { respond problema, [status: CREATED] }
        }
    }

    def edit(Long id){
        respond problemaService.get(id)
    }

    def update(Problema problema){
        if (problema == null) {
            notFound()
            return
        }

        try {
            problemaService.save(problema)
        } catch (ValidationException ex) {
            respond problema.errors, view: 'edit'
            return
        }
        request.withFormat {
            form multipartform {
                flash.message = message(
                        code: 'default.updated.message',
                        args: [message(code: 'problema.label', default: 'CodigoEvaluable'), problema.id])
                redirect problema
            }
            '*' {render problema, [status: OK]}
        }
    }

    def delete(Long id){
        if (id == null){
            notFound()
            return
        }

        problemaService.delete(id)

        request.withFormat {
            form multipartform {
                flash.message = message(
                        code: 'default.updated.message',
                        args: [message(code: 'problema.label', default: 'CodigoEvaluable'), id])
                redirect action: 'index', method: 'GET'
            }
            '*'{ render status: NO_CONTENT }
        }
    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(
                        code: 'default.not.found.message',
                        args: [message(
                                code: 'problema.label',
                                default: 'Problema'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
