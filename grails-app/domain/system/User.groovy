package system

class User {

    String username //用户名
    String password //密码
    String nickName //显示姓名
    Date dateCreated
    Date lastUpdated

    static hasMany = [joinProject: Project, createProject: Project]

    static mappedBy = [joinProject: 'members', createProject: 'createUser']

    static constraints = {
    }
}
