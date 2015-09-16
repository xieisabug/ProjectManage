package system

class Project {

    String name //项目名
    User createUser //创建者
    Date dateCreated
    Date lastUpdated

    static belongsTo = [User]
    static hasMany = [members: User]

    static constraints = {
    }
}
