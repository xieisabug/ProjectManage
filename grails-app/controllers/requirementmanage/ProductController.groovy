package requirementmanage

import org.springframework.security.access.annotation.Secured
import system.Project

@Secured('isAuthenticated()')
class ProductController {

    def index(){

    }

    def addProduct() {
        def p = request.JSON
        Product product = new Product()
        product.setProperties(p)
        product.setProject(session["project"] as Project)
        product.save(flush: true, failOnError: true)
        render(contentType: "text/json") {
            success = true
        }
    }

    def listProduct(){
        render(contentType: "text/json") {
            Product.findAll()
        }
    }
}
