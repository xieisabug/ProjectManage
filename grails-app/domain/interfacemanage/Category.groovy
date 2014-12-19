package interfacemanage

/**
 * 接口类别
 */
class Category {

	String name
	
	static hasMany = [interfaceObjects : InterfaceObject]
	
    static constraints = {
		name blank:false , unique: true
    }
}
