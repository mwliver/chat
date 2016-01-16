package pl.edu.us.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.us.persistance.message.dao.Message;
import pl.edu.us.persistance.message.dao.MessageDao;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageDao messageDao;

    @RequestMapping(value = "/message/save", method = RequestMethod.POST)
    public ResponseEntity<String> saveMessage(@RequestBody Message message) {
        messageDao.save(message);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/message/list", method = RequestMethod.GET)
    public List<Message> findMessage() {
        return (List<Message>) messageDao.findAll();
    }
}
