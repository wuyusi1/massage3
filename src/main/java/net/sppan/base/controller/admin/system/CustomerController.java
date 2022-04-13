package net.sppan.base.controller.admin.system;

import net.sppan.base.common.JsonResult;
import net.sppan.base.entity.Customer;
import net.sppan.base.entity.Role;
import net.sppan.base.entity.User;
import net.sppan.base.service.ICustomerService;
import net.sppan.base.service.impl.CustomerServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import net.sppan.base.controller.BaseController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin/customer")
public class CustomerController extends BaseController{
    @Autowired
    ICustomerService customerService;
    @RequestMapping(value = { "/", "/index" })
    public String index() {
        return "admin/customer/index";
    }

    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<Customer> list(
            @RequestParam(value="searchText",required=false) String searchText
    ) {
//		SimpleSpecificationBuilder<User> builder = new SimpleSpecificationBuilder<User>();
//		String searchText = request.getParameter("searchText");
//		if(StringUtils.isNotBlank(searchText)){
//			builder.add("nickName", Operator.likeAll.name(), searchText);
//		}
        System.out.println("列表");
        Page<Customer> page = customerService.findAllByLike(searchText, getPageRequest());
        return page;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "admin/customer/form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id,ModelMap map) {
        Customer customer = customerService.find(id);
        map.put("customer", customer);
        return "admin/customer/form";
    }

    @RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Customer customer,ModelMap map){
        try {
            customerService.saveOrUpdate(customer);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id,ModelMap map) {
        try {
            customerService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value = "/grant/{id}", method = RequestMethod.GET)
    public String grant(@PathVariable Integer id, ModelMap map) {
        Customer customer = customerService.find(id);
        map.put("customer", customer);

        /*
        Set<Role> set = user.getRoles();

        List<Integer> roleIds = new ArrayList<Integer>();
        for (Role role : set) {
            roleIds.add(role.getId());
        }
        map.put("roleIds", roleIds);

        List<Role> roles = roleService.findAll();
        map.put("roles", roles);*/
        return "admin/customer/grant";
    }

    @ResponseBody
    @RequestMapping(value = "/grant/{id}", method = RequestMethod.POST)
    public JsonResult grant(@PathVariable Integer id, String[] roleIds, ModelMap map) {
        try {
            customerService.grant(id,roleIds);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value = "/updatePwd", method = RequestMethod.GET)
    public String updatePwd() {
        return "admin/customer/updatePwd";
    }

    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult updatePwd(String oldPassword, String password1, String password2) {
        try {
            Subject subject = SecurityUtils.getSubject();
            Object principal = subject.getPrincipal();
            if(principal== null){
                return JsonResult.failure("您尚未登录");
            }
            customerService.updatePwd((Customer) principal, oldPassword, password1, password2);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }
}
