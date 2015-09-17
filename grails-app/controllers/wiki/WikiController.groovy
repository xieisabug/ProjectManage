package wiki

import system.Project

class WikiController {

    def index() {
        redirect(action: 'go', params: [name: 'index'])
    }

    def write() {
        def name = params.name;
        def wiki = Wiki.findOrCreateWhere(name: name)
        return [wiki: wiki];
    }

    def go() {
        def name = params.name;
        def wiki = Wiki.findOrCreateWhere(name: name, project: session['project'] as Project)
        return [wiki: wiki];
    }

    def save() {
        def wiki = Wiki.findByName(params.name)
        if (wiki == null) {
            wiki = new Wiki(params)
        } else {
            wiki.content = params.content
        }
        wiki.project = session.project
        if (!wiki.hasErrors() && wiki.save(flush: true, failOnError: true)) {
            redirect(action: 'go', params: [name: wiki.name])
        } else {
            print "发生错误"
        }
    }

}
