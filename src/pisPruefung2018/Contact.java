package pisPruefung2018;

public class Contact {
    String name;
    String surname;
    String phoneNumber;
    String emailAdress;

    //constructor of Conact
    public Contact(String name, String surname, String phoneNumber, String emailAdress) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;
    }

    //returns Name
    String getName() {
        return name;
    }

    //returns Surname
    String getSurname() {
        return surname;
    }

    //returns Phone Number
    String getPhoneNumber() {
        return phoneNumber;
    }

    //returns E-Mail Adress
    String getEmailAdress() {
        return emailAdress;
    }

    //returns String of Name, Surname,Phone Number and Email
    @Override
    public String toString() {
        return "Name: " + getName() + ", " + "Surname: " + getSurname() + ", " + "Phone Number: " + getPhoneNumber()
                + ", " + "E-Mail: " + getEmailAdress();
    }
}