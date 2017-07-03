package ap.controller;

import ap.model.User;
import ap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {
    public static final int countItem=15;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String getIndexPAge(Model model) {
        userService.createTable();
     int countRows = userService.getCount();
     if(countRows<countItem){
         imitationAddItems(countItem-countRows);
     }

        return "index";
    }

    private void imitationAddItems(int countRows) {
        for (int i = 0; i<countRows;i++ ){
            User user = new User();
            user.setName("Pol"+i);
            userService.createUser(user);
        }
    }
}
