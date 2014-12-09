package interfacemanage

class Param {
    String name
    String remark

    static belongsTo =  InterfaceObject

    static constraints = {
        name nullable: false,blank: false
        remark nullable: false,blank: true
    }
}
