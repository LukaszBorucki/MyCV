package co.borucki.mycv.dto;


public class MySkillsDTO {
    private Long id;
    private String type;
    private String name;
    private int level;
    private String language;

    public MySkillsDTO() {
    }

    public MySkillsDTO(Long id, String type, String name, int level, String language) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.level = level;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
