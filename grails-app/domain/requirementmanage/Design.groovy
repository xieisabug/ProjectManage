package requirementmanage

class Design {
    int id
    String detail
    int status
    String reason
    Date dateCreated
    Date lastUpdated

    static belongsTo = [requirement: Requirement];
    static constraints = {
    }
}
