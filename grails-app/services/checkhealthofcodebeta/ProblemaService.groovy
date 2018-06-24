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
}
