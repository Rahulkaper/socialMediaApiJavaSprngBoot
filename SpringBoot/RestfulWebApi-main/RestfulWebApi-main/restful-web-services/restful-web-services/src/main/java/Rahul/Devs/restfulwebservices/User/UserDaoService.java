package Rahul.Devs.restfulwebservices.User;

import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.*;
@Component
public class UserDaoService {

    private static int count = 0 ;

    private static List<user> users = new ArrayList<>();
    static{

        users.add(new user(++count,"Rahul",LocalDate.now().minusYears(25)));
        users.add(new user(++count,"abhi",LocalDate.now().minusYears(27)));
        users.add(new user(++count,"shilpa",LocalDate.now().minusYears(29)));

    }
    
    public List<user> findAll(){
        return users;
    }


    public user findone(int n) {
       
        return users.stream().filter(usr -> usr.getID()==n).findFirst().orElse(null);
    }

    public void DeleteOne(int n) {
       users.remove(users.stream().filter(usr -> usr.getID()==n).findFirst().orElse(null));
    }
     
     

    public user postUser( user usr){
        usr.setID(++count);
        users.add(usr);
        return usr;


    }
}
