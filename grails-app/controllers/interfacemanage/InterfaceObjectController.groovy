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
            def interfaceObject = InterfaceObject.get(p['id'] as Serializable)
            println interfaceObject
            interfaceObject.delete(flush: true)
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

        def newInterfaceObject = new InterfaceObject()
        def category = Category.get(p.categoryId)
        newInterfaceObject.link = p.link
        newInterfaceObject.method = p.method
        newInterfaceObject.name = p.name
        newInterfaceObject.remark = p.remark
        newInterfaceObject.returnExample = p.returnExample
        newInterfaceObject.setBelongsTo(category)
        category.addToInterfaceObjects(newInterfaceObject)

        newInterfaceObject.save(flush: true,failOnError: true)

        for (param in p.params) {
            Param item = new Param()
            item.name = param.name
            item.remark = param.remark
            newInterfaceObject.addToParams(item)
        }

        newInterfaceObject.save(flush: true,failOnError: true)
        print newInterfaceObject
        render(contentType: "text/json") {
            success=true
        }
    }
}
