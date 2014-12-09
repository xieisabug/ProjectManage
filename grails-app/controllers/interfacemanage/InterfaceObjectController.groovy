package interfacemanage


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class InterfaceObjectController {

    def index() {

    }

    def getCategory() {
        render(contentType: "text/json") {
            Category.list()
        }
    }
}
