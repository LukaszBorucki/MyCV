package co.borucki.mycv.dto;


public class ProjectDTO {
    private Long id;
    private String description;
    private String language;

    public ProjectDTO() {
    }

    public ProjectDTO(Long id, String description, String language) {
        this.id = id;
        this.description = description;
        this.language = language;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

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
