package interfacemanage

import system.Project

/**
 * 接口类别
 */
class Category {

	String name //类别名称
    Date dateCreated
    Date lastUpdated

	//类别下包含多个接口
	static hasMany = [interfaceObjects : InterfaceObject], belongsTo = [project: Project]
	
    static constraints = {
		name blank:false , unique: true
    }

    static mapping = {
        interfaceObjects sort :'id', order:'desc'
    }
}
