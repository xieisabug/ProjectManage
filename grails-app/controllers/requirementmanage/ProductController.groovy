package requirementmanage


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class ProductController {

    def index(){

    }

    def addProduct() {
        def p = request.JSON
        Product product = new Product()
        product.setProperties(p)
        product.setCreateDate(new Date())
        product.save(flush: true, failOnError: true)
    }

    def listProduct(){
        render(contentType: "text/json") {
            Product.findAll()
        }
    }
}
