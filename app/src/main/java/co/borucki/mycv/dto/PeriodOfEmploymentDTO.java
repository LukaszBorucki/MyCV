package co.borucki.mycv.dto;


public class PeriodOfEmploymentDTO {
    private String from;
    private String to;
    private String position;
    private String language;

    public PeriodOfEmploymentDTO() {
    }

    public PeriodOfEmploymentDTO(String from, String to, String position, String language) {
        this.from = from;
        this.to = to;
        this.position = position;
        this.language = language;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
