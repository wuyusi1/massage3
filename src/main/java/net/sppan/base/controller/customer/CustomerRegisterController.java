package net.sppan.base.controller.customer;

import net.sppan.base.entity.Customer;
import net.sppan.base.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerRegisterController {
    @Autowired
    ICustomerService customerService;

    @RequestMapping(value={"/customer/register"}, method = RequestMethod.GET)
    public String getRegister(){
        return "/customer/register";
    }

    @RequestMapping(value = { "/customer/register" }, method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("repassword") String repassword,ModelMap model
    ) {
        if(customerService.findByCustomerName(username)!=null)
        {
            model.put("error","用户名已存在");
            return "/customer/register";
        }
        Customer customer = new Customer();
        customer.setCustomername(username);
        customer.setCustomerpwd(password);
        customerService.saveOrUpdate(customer);
        return "/customer/login";
    }


}
