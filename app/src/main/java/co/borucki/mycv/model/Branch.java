package co.borucki.mycv.model;



public class Branch {
    private String branchName;
    private String language;

    public Branch() {
    }

    public Branch(String branchName, String language) {
        this.branchName = branchName;
        this.language = language;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
