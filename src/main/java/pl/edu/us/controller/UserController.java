package pl.edu.us.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.us.persistance.client.dao.User;
import pl.edu.us.persistance.client.dao.UserDao;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/find/user", method = RequestMethod.GET)
    public List<User> getUsers() {
        return (List<User>) userDao.findAll();
    }

    @RequestMapping(value = "/save/user", method = RequestMethod.POST)
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        userDao.save(user);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }
}
