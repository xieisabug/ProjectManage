package requirementmanage

class Product {
    int id;
    String name;
    String introduce;
    String logo;
    Date createDate;

    static hasMany = [requirements : Requirement]
    static constraints = {
    }
}
