package Rahul.Devs.restfulwebservices.User;

import java.time.LocalDate;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import Rahul.Devs.restfulwebservices.posts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

@Entity(name = "user_details")
public class user {

    @Id
    @GeneratedValue
    private int ID;
    private String Name;
   private LocalDate BirthDate;

   @OneToMany(mappedBy="usr")
   @JsonIgnore
   private List<posts> post;


 protected user(){

 }

public user(int iD, String name, LocalDate birthDate) {
    ID = iD;
    Name = name;
    BirthDate = birthDate;
  

}

public void setID(int iD) {
    ID = iD;
}

public void setName(String name) {
    Name = name;
}

public void setBirthDate(LocalDate birthDate) {
    BirthDate = birthDate;
}

public int getID() {
    return ID;
}

public String getName() {
    return Name;
}

public LocalDate getBirthDate() {
    return BirthDate;
}

@Override
public String toString() {
    return "user [ID=" + ID + ", Name=" + Name + ", BirthDate=" + BirthDate + "]";
}    
   
}
