package interfacemanage

class InterfaceObject {

    String name
    String link
    String returnExample
    String remark
    String method

    static belongsTo = [category: Category]
    static hasMany = [params: Param]


    static constraints = {
        name blank: false, unique: true
        link blank: true, nullable: true
        method inList: ["POST", "GET"]
        returnExample blank: true, nullable: true
        remark nullable: true, blank: true
    }

    @Override
    public String toString() {
        return name + " : " + method
    }
}
