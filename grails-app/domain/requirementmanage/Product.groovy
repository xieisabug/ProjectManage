package requirementmanage

class Product {
    int id;
    String name;
    String introduce;
    Date createDate;

    static hasMany = [requirements : Requirement]
    static constraints = {
    }
}
