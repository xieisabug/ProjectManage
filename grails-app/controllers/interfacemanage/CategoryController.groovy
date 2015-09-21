package interfacemanage

import grails.converters.JSON
import system.Project

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

/**
 * 接口类别管理
 * 接口分类，可以将接口放到某个分类中，以便于查看，也就是软件开发的模块的概念。
 */
class CategoryController {

    /**
     * 获取所有接口的列表，返回json数据
     * @return 所有接口列表的json
     */
    def getCategory() {
        //render方法是将数据渲染，这里是渲染成json数据
        render(contentType: "application/json") {
            Category.findAllByProject(session['project'] as Project)
        }
    }

    def addCategory = {
        def p = request.JSON;
        Category category = new Category(p)
        category.setProject(session['project'])
        category.save(failOnError: true)
        render(contentType: "text/json") {
            success=true
        }
    }
}
