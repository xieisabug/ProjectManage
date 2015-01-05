package requirementmanage

class DetailDesign {
    int id;
    String details;
    Date createDate;
    int status;
    String reason;
    Date updateDate;

    static hasMany = [designs : Design,tasks : Task]
    static constraints = {
    }
}
