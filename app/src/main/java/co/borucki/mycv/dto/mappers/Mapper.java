package co.borucki.mycv.dto.mappers;

import java.util.ArrayList;
import java.util.List;

import co.borucki.mycv.dto.BranchDTO;
import co.borucki.mycv.dto.EmployerDTO;
import co.borucki.mycv.dto.LanguageDTO;
import co.borucki.mycv.dto.MyEducationDTO;
import co.borucki.mycv.dto.MySkillsDTO;
import co.borucki.mycv.dto.PeriodOfEmploymentDTO;
import co.borucki.mycv.dto.PersonalDataDTO;
import co.borucki.mycv.dto.ProjectDTO;
import co.borucki.mycv.model.Branch;
import co.borucki.mycv.model.Employer;
import co.borucki.mycv.model.Language;
import co.borucki.mycv.model.MyEducation;
import co.borucki.mycv.model.MySkills;
import co.borucki.mycv.model.PeriodOfEmployment;
import co.borucki.mycv.model.PersonalData;
import co.borucki.mycv.model.Project;


public class Mapper {
    public static PersonalData fromPersonalDataDTOToPersonalData(PersonalDataDTO personalDataDTO) {
        return new PersonalData(personalDataDTO.getName()
                , personalDataDTO.getSurname()
                , personalDataDTO.getPhoneNo()
                , personalDataDTO.getEmail()
                , personalDataDTO.getCity()
                , personalDataDTO.getStreet()
                , personalDataDTO.getHouseNo()
                , personalDataDTO.getPostCode()
                , personalDataDTO.getGitHub()
                , personalDataDTO.getWebService()
                , personalDataDTO.getSkype()
                , personalDataDTO.getLinkedIn()
                , personalDataDTO.getGoogleLocation()
                , personalDataDTO.getPhoto());
    }

    public static MyEducation fromMyEducationDTOToMyEducation(MyEducationDTO myEducationDTO) {
        return new MyEducation(myEducationDTO.getStartDate()
                , myEducationDTO.getEndDate()
                , myEducationDTO.getAcademy()
                , myEducationDTO.getFaculty()
                , myEducationDTO.getCourse()
                , myEducationDTO.getLevelOfEducation()
                , myEducationDTO.getThesisTopic()
                , myEducationDTO.getAppliedTechnologies()
                , myEducationDTO.getLanguage()
                , myEducationDTO.getLogotype());

    }

    public static List<MyEducation> fromMyEducationDTOToMyEducation(List<MyEducationDTO> myEducationDTOList) {
        List<MyEducation> resultList = new ArrayList<>();
        for (MyEducationDTO myEducationDTO : myEducationDTOList) {
            resultList.add(new MyEducation(myEducationDTO.getStartDate()
                    , myEducationDTO.getEndDate()
                    , myEducationDTO.getAcademy()
                    , myEducationDTO.getFaculty()
                    , myEducationDTO.getCourse()
                    , myEducationDTO.getLevelOfEducation()
                    , myEducationDTO.getThesisTopic()
                    , myEducationDTO.getAppliedTechnologies()
                    , myEducationDTO.getLanguage()
                    , myEducationDTO.getLogotype()));
        }

        return resultList;
    }

    public static List<MySkills> fromMySkillsDTOToMySkills(List<MySkillsDTO> mySkillsDTOs) {
        List<MySkills> resultList = new ArrayList<>();
        for (MySkillsDTO mySkillsDTO : mySkillsDTOs) {
            resultList.add(new MySkills(mySkillsDTO.getType()
                    , mySkillsDTO.getName()
                    , mySkillsDTO.getLevel()
                    , mySkillsDTO.getLanguage()));
        }

        return resultList;
    }

    public static MySkills fromMySkillsDTOToMySkills(MySkillsDTO mySkillsDTO) {
        return new MySkills(mySkillsDTO.getType()
                , mySkillsDTO.getName()
                , mySkillsDTO.getLevel()
                , mySkillsDTO.getLanguage());
    }

    public static List<Branch> fromBranchDToToBranch(List<BranchDTO> branchDTOs) {
        List<Branch> branches = new ArrayList<>();
        for (BranchDTO branchDTO : branchDTOs) {
            branches.add(new Branch(branchDTO.getBranchName(), branchDTO.getLanguage()));
        }
        return branches;
    }

    public static List<PeriodOfEmployment> fromPeriodOfEmploymentDTOToPeriodOfEmployment(List<PeriodOfEmploymentDTO> periodOfEmploymentDTOs) {
        List<PeriodOfEmployment> periodOfEmployments = new ArrayList<>();
        for (PeriodOfEmploymentDTO periodOfEmploymentDTO : periodOfEmploymentDTOs) {
            periodOfEmployments.add(new PeriodOfEmployment(periodOfEmploymentDTO.getFrom()
                    , periodOfEmploymentDTO.getTo()
                    , periodOfEmploymentDTO.getPosition()
                    , periodOfEmploymentDTO.getLanguage()));
        }
        return periodOfEmployments;
    }

    public static List<Project> fromProjectDTOToProject(List<ProjectDTO> projectDTOs) {
        List<Project> projects = new ArrayList<>();
        for (ProjectDTO projectDTO : projectDTOs) {
            projects.add(new Project(projectDTO.getDescription(), projectDTO.getLanguage()));
        }

        return projects;
    }

    public static Employer fromEmployerDTOToEmployer(EmployerDTO employerDTO) {

        return new Employer(employerDTO.getCompanyName()
                , fromBranchDToToBranch(employerDTO.getBranch())
                , fromPeriodOfEmploymentDTOToPeriodOfEmployment(employerDTO.getPeriodOfEmployment())
                , fromProjectDTOToProject(employerDTO.getProjects())
                , employerDTO.getLogotype());
    }

    public static List<Employer> fromEmployerDTOToEmployer(List<EmployerDTO> employerDTOs) {
        List<Employer> employers = new ArrayList<>();
        for (EmployerDTO employerDTO : employerDTOs) {
            employers.add(new Employer(employerDTO.getCompanyName()
                    , fromBranchDToToBranch(employerDTO.getBranch())
                    , fromPeriodOfEmploymentDTOToPeriodOfEmployment(employerDTO.getPeriodOfEmployment())
                    , fromProjectDTOToProject(employerDTO.getProjects())
                    , employerDTO.getLogotype()));
        }

        return employers;
    }

    public static List<Language> fromLanguageDTOToLanguage(List<LanguageDTO> languageDTOs) {
        List<Language> languages = new ArrayList<>();
        for (LanguageDTO languageDTO : languageDTOs) {
            languages.add(new Language(languageDTO.getLanguageName()
                    , languageDTO.getLevel()
                    , languageDTO.getLanguage()
                    , languageDTO.getFlag()));
        }

        return languages;
    }
}
