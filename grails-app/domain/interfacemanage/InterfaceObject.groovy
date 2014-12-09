package interfacemanage

class InterfaceObject {
	
	String name
	String link
	String remark
	String method
	
	static belongsTo = Category
	static hasMany = [params: Param]
	

    static constraints = {
		name blank:false , unique: true
		link blank:false
		method inList:["POST","GET"] 
		remark blank:true , maxSize:5000
    }
	
	@Override
	public String toString() {
		return name + " : " + method
	}
}
