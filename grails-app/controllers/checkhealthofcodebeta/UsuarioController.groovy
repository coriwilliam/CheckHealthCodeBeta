package checkhealthofcodebeta

import authenticacion.Role
import authenticacion.User
import authenticacion.UserRole
import grails.plugin.springsecurity.annotation.Secured

class UsuarioController {

    static defaultAction = "create"

    @Secured("permitAll")
    def create() {
        return params
    }

    @Secured("permitAll")
    def save() {
        def user_role
        if ( !User.findByUsername(params.username) ) {
            def new_profesor = new Profesor(
                    username: params.username,
                    password: params.password,
                    name: params.name
            )
            new_profesor.save(flush: true)
            user_role = new UserRole(user: new_profesor, role:  Role.findByAuthority('ROLE_USER'), flush: true)
            user_role.save()
        }

        render "Save Ok" + params.username + "  asd" + params.name + "   " + params.password + "   " + params.role + "<br>" + user_role.toString()
    }
}
