package Rahul.Devs.restfulwebservices;




import org.springframework.context.annotation.Description;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Rahul.Devs.restfulwebservices.User.user;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class posts {
    @Id
    @GeneratedValue
    private int iD;

    private String Description;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private user usr;

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public user getUsr() {
        return usr;
    }

    public void setUsr(user usr) {
        this.usr = usr;
    }



    

}
