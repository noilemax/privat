package taskivanitsyarest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import taskivanitsyarest.service.UserService;
//import taskivanitsyarest.service.UserService;

/**
 * Created by Администратор on 23.06.2016.
 */
@Component
public class ViewHelper {
    @Autowired
    protected UserService userService;

    public ViewHelper() {
    }

    public ModelAndView generateView(Response response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(response);
        return modelAndView;
    }

    public Response getUsers() {
        Response response = new Response();
        response.setUsers(userService.getAllUsers());
        return response;
    }

    public Response createUser(RequestSettings settings) {
        Response response = new Response();
        userService.createUser(settings.getUserName(),settings.getPassword(),settings.getIsActive());
        String message;
        response.setMessage("User created successfully");
        return response;
    }

    public Response deleteUser(RequestSettings settings){
        Response response = new Response();
        userService.deleteUser(settings.getUserName());
        String message;
        response.setMessage("User has been deleted");
        return response;
    }
    //todo по аналогии с созданием юзера, сделать удаление

}
