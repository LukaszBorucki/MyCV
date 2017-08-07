package co.borucki.mycv.model;


public class MyEducation {
    private String startDate;
    private String endDate;
    private String academy;
    private String faculty;
    private String course;
    private String levelOfEducation;
    private String thesisTopic;
    private String appliedTechnologies;
    private String language;
    private String logotype;

    public MyEducation() {
    }

    public MyEducation(String startDate, String endDate, String academy, String faculty, String course, String levelOfEducation, String thesisTopic, String appliedTechnologies, String language, String logotype) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.academy = academy;
        this.faculty = faculty;
        this.course = course;
        this.levelOfEducation = levelOfEducation;
        this.thesisTopic = thesisTopic;
        this.appliedTechnologies = appliedTechnologies;
        this.language = language;
        this.logotype = logotype;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    public void setLevelOfEducation(String levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }

    public String getThesisTopic() {
        return thesisTopic;
    }

    public void setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic;
    }

    public String getAppliedTechnologies() {
        return appliedTechnologies;
    }

    public void setAppliedTechnologies(String appliedTechnologies) {
        this.appliedTechnologies = appliedTechnologies;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLogotype() {
        return logotype;
    }

    public void setLogotype(String logotype) {
        this.logotype = logotype;
    }
}
