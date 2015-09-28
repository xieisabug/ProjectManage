
class ProjectChooseFilters {

    def filters = {
        all(controller:'*', action:'*', uriExclude:'/assets/**') {
            before = {
                if (!(controllerName == "index" && (actionName == "chooseProject" || actionName == "auth") || actionName == "index")
                        && session['project'] == null) {
                    redirect(controller: "index", action: "chooseProject")
                }
            }
            after = { Map model ->
                if (controllerName == "index" && actionName == "index" && session['project'] == null) {
                    redirect(controller: "index", action: "chooseProject")
                }
            }
            afterView = { Exception e ->

            }
        }
    }
}
