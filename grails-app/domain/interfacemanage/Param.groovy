package interfacemanage

/**
 * 接口参数
 */
class Param {

    String name //参数名
    String remark //参数备注
    Date dateCreated
    Date lastUpdated

    //属于哪一个接口
    static belongsTo =  [interface:InterfaceObject]

    static constraints = {
        name nullable: false,blank: false
        remark nullable: false,blank: true
    }
}
