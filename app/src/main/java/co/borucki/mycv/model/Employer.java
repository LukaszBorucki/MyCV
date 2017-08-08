package co.borucki.mycv.model;


import java.util.List;

public class Employer {
    private String companyName;
    private List<Branch> branch;
    private List<PeriodOfEmployment> periodOfEmployment;
    private List<Project> projects;

    public Employer() {
    }

    public Employer(String companyName, List<Branch> branch, List<PeriodOfEmployment> periodOfEmployment, List<Project> projects) {
        this.companyName = companyName;
        this.branch = branch;
        this.periodOfEmployment = periodOfEmployment;
        this.projects = projects;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Branch> getBranch() {
        return branch;
    }

    public void setBranch(List<Branch> branch) {
        this.branch = branch;
    }

    public List<PeriodOfEmployment> getPeriodOfEmployment() {
        return periodOfEmployment;
    }

    public void setPeriodOfEmployment(List<PeriodOfEmployment> periodOfEmployment) {
        this.periodOfEmployment = periodOfEmployment;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
