package net.sppan.base.controller.admin.system;

import net.sppan.base.common.JsonResult;
import net.sppan.base.controller.BaseController;
import net.sppan.base.entity.Massager;
import net.sppan.base.entity.User;
import net.sppan.base.service.IMassagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/massager")
public class MassagerController extends  BaseController {

    @Autowired
    IMassagerService massagerService;

    @RequestMapping(value = { "/", "/index" })
    public String index() {
        return "admin/massager/index";
    }

    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<Massager> list(
            @RequestParam(value="searchText",required=false) String searchText
    ) {
//		SimpleSpecificationBuilder<User> builder = new SimpleSpecificationBuilder<User>();
//		String searchText = request.getParameter("searchText");
//		if(StringUtils.isNotBlank(searchText)){
//			builder.add("nickName", Operator.likeAll.name(), searchText);
//		}

        Page<Massager> page = massagerService.findALlByLike(searchText, getPageRequest());
        return page;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "admin/massager/form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {
        Massager massager = massagerService.find(id);
        map.put("massager", massager);
        return "admin/massager/form";
    }

    @RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Massager massager, ModelMap map){
        try {
            massagerService.SaveOrUpdate(massager);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id,ModelMap map) {
        try {
            massagerService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }
}
