package ap.controller;

import ap.model.User;
import ap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping({"/api/user"})
public class UserController {

    @Autowired
    UserService userService;

    /**
     * @return all users in BD in json format
     */
    @RequestMapping(method = RequestMethod.GET, headers = {"Accept=application/json"})
    public
    @ResponseBody
    ResponseEntity getUsers() {
        ResponseEntity responseEntity;
        List<User> list = userService.getAllUsers();
        if (list != null) {
            responseEntity = new ResponseEntity(list, HttpStatus.OK);
        } else responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);
        return responseEntity;

    }

    /**
     * @param user with name
     * @return new user  with id and name in json format
     */
    @RequestMapping(method = RequestMethod.POST, headers = {"Content-Type=application/json"})
    public
    @ResponseBody
    ResponseEntity createUser(@RequestBody User user) {
        ResponseEntity responseEntity;
        if (userService.createUser(user) > 0) {
            responseEntity = new ResponseEntity(user, HttpStatus.CREATED);
        } else responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    /**
     * @param id id user in BD
     * @param user user json format with name
     * @return user with id and NEW name in json format
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = {"Content-Type=application/json"})
    public
    @ResponseBody
    ResponseEntity updateUser(@RequestBody User user, @PathVariable int id) {
        ResponseEntity responseEntity;
        user.setUserId(id);
        if (userService.updateUser(user) > 0) {
            responseEntity = new ResponseEntity(user, HttpStatus.CREATED);
        } else responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        return responseEntity;
    }


    /**
     * @param id id user in BD
     * @return  HttpStatus depends on result
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    ResponseEntity deleteUser(@PathVariable int id) {
        ResponseEntity responseEntity;
        User user = new User();
        user.setUserId(id);
        if (userService.deleteUser(user) > 0) {
            responseEntity = new ResponseEntity(HttpStatus.OK);
        } else responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    /**
     * @param id id user in DB
     * @return  user with id and name in json format
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = {"Accept=application/json"})
    public
    @ResponseBody
    ResponseEntity getUserById(@PathVariable int id) {
        ResponseEntity responseEntity;
        User user = userService.getUserById(id);
        if (user !=null){
            responseEntity = new ResponseEntity(user,HttpStatus.OK);
        } else responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

}
