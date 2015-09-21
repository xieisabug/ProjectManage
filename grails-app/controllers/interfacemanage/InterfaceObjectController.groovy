package interfacemanage

import system.Project

/**
 * 接口管理类
 * 对每个接口对象进行管理
 */
class InterfaceObjectController {

    /**
     * 直接进入index页面，由于使用ajax加载数据，所以不返回任何数据
     */
    def index() {

    }

    /**
     * 删除某个接口对象
     * @return 删除成功或者失败
     */
    def deleteInterfaceObject(){
        //因为前段使用的是ajax框架，传过来的参数是json，所以需要这样接收
        def p =  request.JSON
        try {
            //获取到需要删除的接口对象
            def interfaceObject = InterfaceObject.get(p['id'] as Serializable)
//            println interfaceObject
            //执行删除操作，并且马上提交
            interfaceObject.delete(flush: true)
        } catch (Exception ignored) {
            //render方法是将数据渲染，这里是渲染成json数据
            render(contentType: "text/json") {
                success=false
            }
        }
        //render方法是将数据渲染，这里是渲染成json数据
        render(contentType: "text/json") {
            success=true
        }
    }

    /**
     * 增加一个接口
     * @return 增加成功或者失败
     */
    def addInterfaceObject(){
        //因为前段使用的是ajax框架，传过来的参数是json，所以需要这样接收
        def p = request.JSON

        //创建一个接口对象
        def newInterfaceObject = new InterfaceObject()
        //获取到接口属于哪个分类（模块）
        def category = Category.get(p.categoryId)
        //下面是复制属性，其实可以更简便的复制
        newInterfaceObject.link = p.link
        newInterfaceObject.method = p.method
        newInterfaceObject.name = p.name
        newInterfaceObject.remark = p.remark
        newInterfaceObject.returnExample = p.returnExample
        //设置类之间的依赖
        newInterfaceObject.setBelongsTo(category)
        category.addToInterfaceObjects(newInterfaceObject)

        //保存，并且马上提交，设置如果报错则停止
        newInterfaceObject.save(flush: true,failOnError: true)

        //循环添加参数对象
        for (param in p.params) {
            Param item = new Param()
            item.name = param.name
            item.remark = param.remark
            //设置依赖
            newInterfaceObject.addToParams(item)
        }
        //保存一次参数对象依赖
        newInterfaceObject.save(flush: true,failOnError: true)
//        print newInterfaceObject
        //render方法是将数据渲染，这里是渲染成json数据
        render(contentType: "text/json") {
            success=true
        }
    }

    def updateInterfaceObject(){
        def p = request.JSON
        def interfaceObject = InterfaceObject.get(p.id)
        interfaceObject.link = p.link
        interfaceObject.method = p.method
        interfaceObject.name = p.name
        interfaceObject.remark = p.remark
        interfaceObject.returnExample = p.returnExample

        //循环添加参数对象
        for (param in p.addList) {
            Param item = new Param()
            item.name = param.name
            item.remark = param.remark
            //设置依赖
            interfaceObject.addToParams(item)
        }
        for (param in p.deleteList) {
            Param item = Param.get(param.id)
            interfaceObject.removeFromParams(item)
            item.delete()
        }
        //保存一次参数对象依赖
        interfaceObject.save(flush: true,failOnError: true)

        render(contentType: "text/json") {
            success=true
        }
    }

    def changeLink(){
        def p = request.JSON;
        def interfaceObject = InterfaceObject.get(p.id)
        interfaceObject.link = p.link
        interfaceObject.save(flush: true, failOnError: true)
        render(contentType: "text/json") {
            success=true
        }
    }
}
