package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        
            //On jo k�yt�ss�
        if (userDao.findByName(username.toLowerCase()) != null) {
          //  System.out.println("On jo k�yt�ss�");
            return true;
            
            //K�ytt�j�tunnuksen pituus alle 3
        } else if (username.length() < 3) {
            //System.out.println("Pituus ei hyv�");
            return true;
            
            //K�ytt�j�tunnus sis�lt�� muita kuin kirjaimia a-z
        } else if (!validateString(username)) {
            //System.out.println("Muita kuin kirjaimia");
            
            return true;

        } else if (password.length() < 8) {

            return true;

        } else if (validateString(password)) {

            return true;

        } else {

            return false;
        }
            
    }  
                

    public boolean validateString(String str) {
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (!(ch >= 'a' && ch <= 'z')) {
                return false;
            }
        }
        return true;
    }
}
