package system

import interfacemanage.Category
import requirementmanage.Product
import wiki.Wiki

class Project {

    String name //项目名
    User createUser //创建者
    Date dateCreated
    Date lastUpdated

    static belongsTo = [User]
    static hasMany = [members: User, wikis: Wiki, categorys: Category, products: Product]

    static constraints = {
    }
}
