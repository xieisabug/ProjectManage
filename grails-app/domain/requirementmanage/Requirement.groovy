package requirementmanage

class Requirement {
    int id;
    String detail;
    int priority;
    Date createDate;
    int status;
    String reason;
    Date updateDate;
    static belongsTo = [product: Product]
    static hasMany = [designs : Design]
    static constraints = {
    }
}
