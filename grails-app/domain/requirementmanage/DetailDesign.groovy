package requirementmanage

class DetailDesign {
    int id;
    String details;
    int status;
    String reason;
    Date dateCreated
    Date lastUpdated

    static hasMany = [designs : Design,tasks : Task]
    static constraints = {
    }
}
