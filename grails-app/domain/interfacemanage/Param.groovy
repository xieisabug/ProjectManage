package interfacemanage

/**
 * 接口参数
 */
class Param {
    String name
    String remark

    static belongsTo =  [interface:InterfaceObject]

    static constraints = {
        name nullable: false,blank: false
        remark nullable: false,blank: true
    }
}
