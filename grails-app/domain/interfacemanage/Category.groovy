package interfacemanage

class Category {

	String name
	
	static hasMany = [interfaceObjects : InterfaceObject]
	
    static constraints = {
		name blank:false , unique: true
    }
}
