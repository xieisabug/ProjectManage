package interfacemanage

/**
 * 接口参数
 */
class Param {
    //参数名
    String name
    //参数备注
    String remark

    //属于哪一个接口
    static belongsTo =  [interface:InterfaceObject]

    static constraints = {
        name nullable: false,blank: false
        remark nullable: false,blank: true
    }
}
