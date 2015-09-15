package interfacemanage

/**
 * 接口对象
 */
class InterfaceObject {

    String name //接口名
    String link //接口地址
    String returnExample //返回示例
    String remark //备注
    String method //使用的方法类型

    static belongsTo = [category: Category] //接口属于哪一个类别
    static hasMany = [params: Param] //接口包含的参数


    static constraints = {
        name blank: false, unique: true
        link blank: true, nullable: true
        method inList: ["POST", "GET"] //目前方法只支持get和post
        returnExample blank: true, nullable: true
        remark nullable: true, blank: true
    }

    @Override
    public String toString() {
        return name + " : " + method
    }
}
