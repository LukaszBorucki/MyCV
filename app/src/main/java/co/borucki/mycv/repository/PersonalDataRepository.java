package co.borucki.mycv.repository;


public interface PersonalDataRepository {
    String getName();

    String getSurname();

    String getPhone();

    void setName(String name);

    void setSurname(String surname);

    void setPhone(String phone);

}
