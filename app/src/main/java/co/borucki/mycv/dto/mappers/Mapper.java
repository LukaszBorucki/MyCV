package co.borucki.mycv.dto.mappers;

import co.borucki.mycv.dto.PersonalDataDTO;
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
}
