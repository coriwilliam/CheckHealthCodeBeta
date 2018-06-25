package checkhealthofcodebeta

import grails.gorm.transactions.Transactional

@Transactional
class ProblemaService {

    List<Problema> list(Map args) {
      Problema.list(args)
    }

    Long count(){
      Problema.count()
    }

    Problema get(Serializable id){
        Problema.findById(id)
    }

    Problema save(Problema problema){
        problema.save()
    }

    def delete(long id){
        Problema.findById(id).delete()
    }
}
