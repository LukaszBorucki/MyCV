package co.borucki.mycv.model;




public class Hobbies {
    private String logo;
    private String description;
    private String language;

    public Hobbies() {
    }

    public Hobbies(String logo, String description, String language) {
        this.logo = logo;
        this.description = description;
        this.language = language;
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
