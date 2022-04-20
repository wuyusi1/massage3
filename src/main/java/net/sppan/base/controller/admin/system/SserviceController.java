package net.sppan.base.controller.admin.system;

import net.sppan.base.common.JsonResult;
import net.sppan.base.controller.BaseController;
import net.sppan.base.entity.Role;
import net.sppan.base.entity.Sservice;
import net.sppan.base.entity.User;
import net.sppan.base.service.IRoleService;
import net.sppan.base.service.IServiceImgService;
import net.sppan.base.service.ISserviceService;
import net.sppan.base.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin/service")
public class SserviceController extends BaseController {

    @Autowired
    private ISserviceService sserviceService;
    @Autowired
    private IServiceImgService serviceImgService;

    @RequestMapping(value = { "/", "/index" })
    public String index() {
        return "admin/service/index";
    }

    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<Sservice> list(
            @RequestParam(value="searchText",required=false) String searchText
    ) {
//		SimpleSpecificationBuilder<User> builder = new SimpleSpecificationBuilder<User>();
//		String searchText = request.getParameter("searchText");
//		if(StringUtils.isNotBlank(searchText)){
//			builder.add("nickName", Operator.likeAll.name(), searchText);
//		}

        Page<Sservice> page = sserviceService.findAllByLike(searchText, getPageRequest());
        return page;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "admin/service/form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id,ModelMap map) {
        Sservice sservice = sserviceService.find(id);
        map.put("sservice", sservice);
        return "admin/service/form";
    }

    @RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Sservice sservice,ModelMap map){
        try {
            sserviceService.saveOrUpdate(sservice);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id,ModelMap map) {
        try {
            sserviceService.delete(id);
            serviceImgService.deleteAllByServiceid(id);//删除该服务信息的时候也需要将图片表中该服务的图片删掉
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }
}
