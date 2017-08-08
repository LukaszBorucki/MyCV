package co.borucki.mycv.model;


public class Project {
    private String description;
    private String language;

    public Project() {
    }

    public Project(String description, String language) {
        this.description = description;
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
