package requirementmanage

class RequirementController {

    def index() {}

    def addRequirement(){
        def p = request.JSON
        Requirement requirement = new Requirement(priority : 1,createDate : new Date(), updateDate : new Date(), status : 1)
        requirement.detail = p.detail
        requirement.setProduct(Product.get(p.productId))
        requirement.save(failOnError: true, flush: true)
        render(contentType: "text/json") {
            success = true
        }
    }

    def listRequirement() {
        render(contentType: "text/json") {
            Requirement.findAll()
        }
    }
}
