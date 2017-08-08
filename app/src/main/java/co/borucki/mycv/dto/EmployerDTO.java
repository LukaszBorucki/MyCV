package co.borucki.mycv.dto;


import java.util.List;

public class EmployerDTO {
    private Long id;
    private String companyName;
    private List<BranchDTO> branch;
    private List<PeriodOfEmploymentDTO> periodOfEmployment;
    private List<ProjectDTO> projects;

    public EmployerDTO() {
    }

    public EmployerDTO(Long id, String companyName, List<BranchDTO> branch, List<PeriodOfEmploymentDTO> periodOfEmployment, List<ProjectDTO> projects) {
        this.id = id;
        this.companyName = companyName;
        this.branch = branch;
        this.periodOfEmployment = periodOfEmployment;
        this.projects = projects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<BranchDTO> getBranch() {
        return branch;
    }

    public void setBranch(List<BranchDTO> branch) {
        this.branch = branch;
    }

    public List<PeriodOfEmploymentDTO> getPeriodOfEmployment() {
        return periodOfEmployment;
    }

    public void setPeriodOfEmployment(List<PeriodOfEmploymentDTO> periodOfEmployment) {
        this.periodOfEmployment = periodOfEmployment;
    }

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }
}
