package system

class IndexController {

    def index() {
        if (session.user == null) {
            redirect(action: "login")
        }
    }

    def login() {}

    def loginExecute() {
        def p =  request.JSON

        def user = User.findByUsernameAndPassword(p['username'] as String, (p['password'] as String).encodeAsBase64())
        if (user) {
            session.user = user

            render(contentType: "text/json") {
                success = true
                data = {
                    create = array {
                        for (project in user.createProject) {
                            element {
                                id = project.id
                                name = project.name
                            }
                        }
                    }
                    join = array {
                        for (project in user.joinProject) {
                            element {
                                id = project.id
                                name = project.name
                            }
                        }
                    }
                }
            }
        } else {
            render(contentType: "text/json") {
                success = false
            }
        }
    }
}
