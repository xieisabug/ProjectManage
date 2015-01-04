package requirementmanage

class DetailDesign {
    int id;
    int designId;
    String details;
    Date createDate;
    int status;
    String reason;
    Date updateDate;

    static hasMany = [designs : Design,tasks : Task]
    static constraints = {
    }
}
