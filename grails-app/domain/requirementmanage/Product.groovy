package requirementmanage

class Product {
    int id;
    String name;
    String introduce;
    String logo;
    Date dateCreated
    Date lastUpdated

    static hasMany = [requirements : Requirement]
    static constraints = {
    }
}
