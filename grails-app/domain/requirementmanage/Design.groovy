package requirementmanage

class Design {
    int id;
    int requirementId;
    String detail;
    Date createDate;
    int status;
    String reason;
    Date updateDate;
    static belongsTo = [requirement: Requirement];
    static constraints = {
    }
}
