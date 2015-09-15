package interfacemanage

/**
 * 接口类别
 */
class Category {

	String name //类别名称

	//类别下包含多个接口
	static hasMany = [interfaceObjects : InterfaceObject]
	
    static constraints = {
		name blank:false , unique: true
    }
}
