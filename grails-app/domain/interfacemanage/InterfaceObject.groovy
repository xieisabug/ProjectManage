package interfacemanage

class InterfaceObject {
	
	String name
	String link
	String remark
	String param
	String method
	
	static belongsTo = Category
	

    static constraints = {
		name blank:false , unique: true
		param blank:false 
		link blank:false 
		method inList:["POST","GET"] 
		remark blank:true , maxSize:5000
    }
	
	@Override
	public String toString() {
		return name + " : " + method
	}
}
