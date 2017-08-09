package co.borucki.mycv.dto;


public class HobbiesDTO {
    private Long id;
    private String logo;
    private String description;
    private String language;

    public HobbiesDTO() {
    }

    public HobbiesDTO(Long id, String logo, String description, String language) {
        this.id = id;
        this.logo = logo;
        this.description = description;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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
