package net.sppan.base.controller.admin.system;

import com.alibaba.fastjson.JSON;
import net.sppan.base.common.JsonResult;
import net.sppan.base.controller.BaseController;
import net.sppan.base.entity.Role;
import net.sppan.base.entity.Serviceimg;
import net.sppan.base.entity.Sservice;
import net.sppan.base.entity.User;
import net.sppan.base.service.IRoleService;
import net.sppan.base.service.IServiceImgService;
import net.sppan.base.service.ISserviceService;
import net.sppan.base.service.IUserService;
import net.sppan.base.util.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

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
            serviceImgService.deleteAllByServiceid(id);//??????????????????????????????????????????????????????????????????????????????
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value = "/imgedit/{id}", method = RequestMethod.GET)
    public String imgedit(@PathVariable Integer id,ModelMap map) {
        List<Serviceimg> imgs=serviceImgService.findAllByServiceid(id);
        map.put("imgs",imgs);
        map.put("serviceid", id);
        return "admin/serviceimg/imgform";
    }


    @RequestMapping("/multipleImageUpload")
    public List multipleImageUpload(@RequestParam(value="serviceid",required=false) Integer serviceid,@RequestParam("uploadFiles") MultipartFile[] files,ModelMap map){
        System.out.println("?????????????????????"+files.length);

        List<Map<String,Object>> root=new ArrayList<Map<String,Object>>();

        for (MultipartFile file : files) {    //??????????????????

            Map<String,Object> result=new HashMap<String, Object>();//???????????????????????????
            String result_msg="";//??????????????????

            if (file.getSize() / 1000 > 100){
                result_msg="????????????????????????100KB";
            }
            else{
                //????????????????????????
                String fileType = file.getContentType();
                if (fileType.equals("image/jpeg") || fileType.equals("image/png") || fileType.equals("image/jpeg")) {
                    // ?????????????????????????????????????????????
                    final String localPath="F:\\SPPanAdmin\\SPPanAdmin\\src\\main\\resources\\templates\\img";
                    //???????????????????????????(?????????????????????????????????????????????)
                    //???????????????
                    String fileName = file.getOriginalFilename();
                    //?????????????????????
                    String suffixName = fileName.substring(fileName.lastIndexOf("."));
                    //?????????????????????
                    fileName = UUID.randomUUID()+suffixName;
                    if (FileUtils.upload(file, localPath, fileName)) {
                        //???????????????????????????(??????????????????????????????img?????????src)
                        String relativePath="img/"+fileName;
                        result.put("relativePath",relativePath);//????????????????????????????????????????????????????????????
                        result_msg="??????????????????";
                        Serviceimg tmpimg = new Serviceimg();
                        tmpimg.setImgdate(new Date());
                        tmpimg.setImgname(fileName);
                        tmpimg.setImgpath(relativePath);
                        tmpimg.setServiceid(serviceid);
                        serviceImgService.saveOrUpdate(tmpimg);
                    }
                    else{
                        result_msg="??????????????????";
                    }
                }
                else{
                    result_msg="?????????????????????";
                }
            }
            result.put("result_msg",result_msg);
            root.add(result);
        }
        String root_json= JSON.toJSONString(root);
        System.out.println(root_json);
        List<Serviceimg> imgs=serviceImgService.findAllByServiceid(serviceid);
        map.put("imgs",imgs);
        return root;
    }



}
