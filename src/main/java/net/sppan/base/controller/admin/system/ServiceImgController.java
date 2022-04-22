package net.sppan.base.controller.admin.system;

import net.sppan.base.controller.BaseController;
import net.sppan.base.service.IServiceImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/serviceimg")
public class ServiceImgController extends BaseController {
    @Autowired
    IServiceImgService serviceImgService;

    @RequestMapping("/imgedit")
    public String imgEdit(){
        return "/admin/serviceimg/imgindex";
    }

}
