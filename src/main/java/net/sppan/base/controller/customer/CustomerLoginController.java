package net.sppan.base.controller.customer;


//import net.sppan.base.config.shiro.Token.CustomerToken;
import net.sppan.base.controller.BaseController;
import net.sppan.base.entity.Customer;
import net.sppan.base.service.ICustomerService;
import net.sppan.base.util.LoginType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerLoginController extends BaseController {

    @Autowired
    ICustomerService customerService;
    @RequestMapping(value = { "/customer/login" }, method = RequestMethod.GET)
    public String login() {

        return "/customer/login";
    }
    @RequestMapping(value = { "/customer/login" }, method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, ModelMap model
    ) {
        /*try {
            Customer customer =customerService.findByCustomerName(username);
            if(password.equals(customer.getCustomerpwd()))
                return redirect("/customer/index");
        } catch (AuthenticationException e) {
            model.put("message", e.getMessage());
        }*/
        System.out.println(username+" "+password);
        Customer customer =customerService.findByCustomerName(username);
        if(customer==null)
        {
            System.out.println("用户名不正确");
        }
        if(null!=customer&&password.equals(customer.getCustomerpwd()))
            return redirect("/customer/index");
        //System.out.println("用户名密码错误"+username+" "+password+" "+customer.getCustomerpwd());
        return "/customer/login";
    }

    @RequestMapping(value = { "/customer/logout" }, method = RequestMethod.GET)
    public String logout() {
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
        return redirect("/customer/login");
    }

    @RequestMapping(value ={"/customer/","/customer/index"})
    public String index(){

        return "customer/index";
    }
}
