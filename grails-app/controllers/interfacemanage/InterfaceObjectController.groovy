package interfacemanage



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class InterfaceObjectController {
    static scaffold = InterfaceObject
}
