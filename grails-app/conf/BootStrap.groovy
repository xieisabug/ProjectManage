import system.User
import system.Project

class BootStrap {

    def init = { servletContext ->
        /*User user1 = new User(username: "admin", password: "123456".encodeAsBase64(), nickName: "admin").save()
        User user2 = new User(username: "admin2", password: "123456".encodeAsBase64(), nickName: "admin2").save()

        Project project1 = new Project(name: "testProject1", createUser: user1).save()
        Project project2 = new Project(name: "testProject2", createUser: user2).save()

        project1.addToMembers(user2)
        project2.addToMembers(user1)*/
    }

    def destroy = {
    }
}
