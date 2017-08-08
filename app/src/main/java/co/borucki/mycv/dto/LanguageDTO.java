package co.borucki.mycv.dto;



public class LanguageDTO {
    private Long id;
    private String languageName;
    private String level;
    private String language;
    private String flag;

    public LanguageDTO() {
    }

    public LanguageDTO(Long id, String languageName, String level, String language, String flag) {
        this.id = id;
        this.languageName = languageName;
        this.level = level;
        this.language = language;
        this.flag = flag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
