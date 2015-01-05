package requirementmanage


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class ProductController {

    def index(){

    }

    def listProduct(){
        render(contentType: "text/json") {
            Product.findAll()
        }
    }
}
