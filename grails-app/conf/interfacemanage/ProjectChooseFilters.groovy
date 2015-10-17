
class ProjectChooseFilters {

    def springSecurityService

    def filters = {
        all(controller:'*', action:'*', uriExclude:'/assets/**') {
            before = {
                if (!(controllerName == "index" && (actionName == "chooseProject" || actionName == "auth" || actionName == "ajaxSuccess" || actionName == "index"))
                        && session['project'] == null) {
                    redirect(controller: "index", action: "chooseProject")
                }
            }
            after = { Map model ->
                if (controllerName == "index" && actionName == "index" && session['project'] == null && springSecurityService.getCurrentUser() != null) {
                    redirect(controller: "index", action: "chooseProject")
                }
            }
            afterView = { Exception e ->

            }
        }
    }
}
