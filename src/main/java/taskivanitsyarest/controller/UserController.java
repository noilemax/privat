package taskivanitsyarest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import taskivanitsyarest.web.Response;
import taskivanitsyarest.web.ViewHelper;

@RestController
@Controller
public class UserController {

    @Autowired
    protected ViewHelper viewHelper;

    @RequestMapping(value = {"/getusers"}, method = RequestMethod.GET)
    public ModelAndView getUsers() {
        Response response = viewHelper.getUsers();
        return viewHelper.generateView(response);
    }
}