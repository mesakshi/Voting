package election;

import java.time.LocalDate;
import java.util.Objects;

public class Voter {
    private Integer voterId;

    private String firstName;

    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String username;
    private String password;
    private int symbol;


    public Voter() {
    }


    public Voter(Integer voterId, String firstName, String lastName, Gender gender, LocalDate dateOfBirth, String username, String password) {
        this.voterId = voterId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
    }

    public Voter(String firstName, String lastName, Gender gender, LocalDate dateOfBirth, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
    }

    public Integer getVoterId() {
        return voterId;
    }

    public void setVoterId(Integer voterId) {
        this.voterId = voterId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSymbol() {
        return symbol;
    }

    public void setSymbol(int symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "voterId=" + voterId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voter voter = (Voter) o;
        return Objects.equals(getVoterId(), voter.getVoterId()) && Objects.equals(getFirstName(), voter.getFirstName())
                && Objects.equals(getLastName(), voter.getLastName()) && getGender() == voter.getGender() && Objects.equals(getDateOfBirth(),
                voter.getDateOfBirth()) && Objects.equals(getUsername(), voter.getUsername()) && Objects.equals(getPassword(), voter.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVoterId(), getFirstName(), getLastName(), getGender(), getDateOfBirth(), getUsername(), getPassword());
    }


}