package system

class IndexController {

    def beforeInterceptor = [action: this.&auth, except: ['login', 'loginExecute']]

    def auth() {
        if(!session.user) {
            redirect(action:'login')
            return false
        }
    }

    def index = {
        session.project = Project.findById(params['id'] as Long)
    }

    def login = {}

    def loginExecute = {
        def p = request.JSON

        def user = User.findByUsernameAndPassword(p['username'] as String, (p['password'] as String).encodeAsMD5())
        if (user) {
            session.user = user

            render(contentType: "text/json") {
                success = true
                data = {
                    url = "/InterfaceManage/index/chooseProject"
                }
            }
        } else {
            render(contentType: "text/json") {
                success = false
            }
        }
    }

    def chooseProject = {
        User user = User.get(session.user.id);
        [joinProject: user.getJoinProject(), createProject: user.getCreateProject()]
    }
}
