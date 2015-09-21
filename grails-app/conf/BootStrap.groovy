import grails.converters.JSON
import interfacemanage.Category
import interfacemanage.InterfaceObject
import interfacemanage.Param
import system.User
import system.Project

class BootStrap {

    def init = { servletContext ->
        /*User user1 = new User(username: "admin", password: "123456".encodeAsMD5(), nickName: "admin").save()
        User user2 = new User(username: "admin2", password: "123456".encodeAsMD5(), nickName: "admin2").save()

        Project project1 = new Project(name: "testProject1", createUser: user1).save()
        Project project2 = new Project(name: "testProject2", createUser: user2).save()

        project1.addToMembers(user2)
        project2.addToMembers(user1)*/
        JSON.registerObjectMarshaller(Category) { Category category ->
            return [
                    id : category.id,
                    name : category.name,
                    interfaceObjects : category.interfaceObjects
            ]
        }
        JSON.registerObjectMarshaller(InterfaceObject) { InterfaceObject interfaceObject ->
            return [
                    id : interfaceObject.id,
                    name : interfaceObject.name,
                    link : interfaceObject.link,
                    returnExample : interfaceObject.returnExample,
                    remark : interfaceObject.remark,
                    method : interfaceObject.method,
                    dateCreated : interfaceObject.dateCreated,
                    params : interfaceObject.params
            ]
        }
        JSON.registerObjectMarshaller(Param) { Param param ->
            return [
                    id : param.id,
                    name : param.name,
                    remark : param.remark
            ]
        }
    }

    def destroy = {
    }
}
