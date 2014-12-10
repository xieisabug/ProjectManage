package interfacemanage

class InterfaceObjectController {

    def index() {

    }

    def getCategory() {
        render(contentType: "text/json") {
            Category.list()
        }
    }

    def deleteInterfaceObject(){
        def p =  request.JSON
        try {
            InterfaceObject.get(p['id'] as Serializable).delete()
        } catch (Exception ignored) {
            render(contentType: "text/json") {
                success=false
            }
        }
        render(contentType: "text/json") {
            success=true
        }
    }

    def addInterfaceObject(){
        def p = request.JSON
        println p
        def newInterfaceObject = new InterfaceObject()
        def category = Category.get(p.categoryId)
        newInterfaceObject.link = p.link
        newInterfaceObject.method = p.method
        newInterfaceObject.name = p.name
        newInterfaceObject.remark = p.remark
        newInterfaceObject.setBelongsTo(category)

        category.interfaceObjects.add(newInterfaceObject)

        newInterfaceObject.save(flush: true,failOnError: true)

        println newInterfaceObject.id

//        Set<Param> params = new HashSet<>();
        for (param in p.params) {
            Param item = new Param()
            item.name = param.name
            item.remark = param.remark
            newInterfaceObject.addToParams(item)
//            item.save(flush: true, failOnError: true)
//            params.add(item)
        }
//        newInterfaceObject.params = params
        newInterfaceObject.save(flush: true,failOnError: true)
        print newInterfaceObject
        render(contentType: "text/json") {
            success=true
        }
    }
}
