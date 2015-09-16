package requirementmanage

class Requirement {
    int id
    String detail
    int priority
    int status
    String reason
    Date dateCreated
    Date lastUpdated

    static belongsTo = [product: Product]
    static hasMany = [designs : Design]
    static constraints = {
    }
}
