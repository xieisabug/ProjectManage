package requirementmanage

import system.Project

class Product {
    int id;
    String name;
    String introduce;
    String logo;
    Date dateCreated
    Date lastUpdated

    static belongsTo = [project: Project]
    static hasMany = [requirements : Requirement]
    static constraints = {
    }
}
