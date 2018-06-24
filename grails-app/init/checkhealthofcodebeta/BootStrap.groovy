package checkhealthofcodebeta

class BootStrap {

    def init = { servletContext ->

      def profesor = new Profesor(nombre:"Alexander").save()
      //A fines practicos, se va a harcodear el nombre de la clase a implementar
      def nombreClase = "Pila"
      def problema = new Problema(
        titulo: "Pila en Groovy",
        enunciado:
"""
Se debera implementar un pila con una lista de Groovy, la cual debera contar con los metodos apilar, desapilar, ver_tope y esta_vacia
""",
      interfazAtestear: """
public interface IPila {
  abstract def apilar(def elemento)
  abstract def desapilar()
  abstract def ver_tope()
  abstract def esta_vacia()
}
""",
      testsDeUnidad:
"""
  def alCrearUnaPilaEstaVacia(){
    def pila = ${nombreClase}()
    assert pila.esta_vacia() == true
  }

  def alAPilarAlgunosElementosLaPilaDejaDeEstarVacia(){alumnos: []
      def pila = ${nombreClase}()
      pila.apilar(1)
      assert pila_esta_vacia() == false
  }

  def alDesapilarLaPilaConUnElementoQuedaVacia(){
    def pila = ${nombreClase}()
    pila.apilar(1)
    pila.desapilar()
    assert pila.esta_vacia() == true
  }

  def alApilarNumerosHastaEl5EnElTopeDeLaPilaDeberiaEstarEl5(){
      def pila = ${nombreClase}()
      (0..5).each { pila.apilar(it) }
      assert pila.ver_tope() == 5
  }
""",
      fechaDeCreacion: new Date(),
      ultimaModificacion: new Date(),
      profesorCreador: profesor)

      problema.save()

    }
    def destroy = {
    }
}
