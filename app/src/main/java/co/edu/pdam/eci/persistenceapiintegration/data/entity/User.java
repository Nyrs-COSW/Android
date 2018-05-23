package co.edu.pdam.eci.persistenceapiintegration.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

/**
 * Created by 2090540 on 5/18/18.
 */

@DatabaseTable
public class User extends BaseEntity{



    @DatabaseField(columnName = "age")
    private int age;
    @DatabaseField(columnName = "experience")
    private List<Experience> experience;
    @DatabaseField(columnName = "role")
    private String role = "";
    @DatabaseField(columnName = "email")
    private String email;
    @DatabaseField(columnName = "password")
    private String password;
    @DatabaseField(columnName = "firstname")
    private String firstname;
    @DatabaseField(columnName = "lastname")
    private String lastname;
    @DatabaseField(columnName = "username")
    private String username;
    @DatabaseField(columnName = "services")
    private List<NursingServices> services;
    public User()
    {
    }
    public User( int age, String email, String password, String firstname, String lastname, String username) {

        this.age = age;
        this.role = "patient";
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
    }
    public User(int age, List<Experience> experience, String email, String password, String firstname, String lastname, String username) {

        this.age = age;
        this.experience = experience;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.role = "nurse";
    }





    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname( String firstname )
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname( String lastname )
    {
        this.lastname = lastname;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public List<Experience> getExperience() {
        return experience;
    }

    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }


    public List<NursingServices> getServices() {
        return services;
    }

    public void setServices(List<NursingServices> services) {
        this.services = services;
    }

}
