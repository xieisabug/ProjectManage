package interfacemanage



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

/**
 * 接口类别管理
 * 接口分类，可以将接口放到某个分类中，以便于查看，也就是软件开发的模块的概念。
 */
@Transactional(readOnly = true)
class CategoryController {
    //自动生成增删改查界面，不过很丑
    static scaffold = Category
}
