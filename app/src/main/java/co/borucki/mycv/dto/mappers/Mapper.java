package co.borucki.mycv.dto.mappers;

import java.util.ArrayList;
import java.util.List;

import co.borucki.mycv.dto.MyEducationDTO;
import co.borucki.mycv.dto.PersonalDataDTO;
import co.borucki.mycv.model.MyEducation;
import co.borucki.mycv.model.PersonalData;


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
}
