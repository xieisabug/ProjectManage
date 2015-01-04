package requirementmanage

class Requirement {
    int id;
    int productId;
    int detail;
    int priority;
    Date createDate;
    int status;
    int reason;
    Date updateDate;
    static belongsTo = [product: Product]
    static hasMany = [designs : Design]
    static constraints = {
    }
}
