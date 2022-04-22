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
            serviceImgService.deleteAllByServiceid(id);//删除该服务信息的时候也需要将图片表中该服务的图片删掉
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
        System.out.println("上传的图片数："+files.length);

        List<Map<String,Object>> root=new ArrayList<Map<String,Object>>();

        for (MultipartFile file : files) {    //循环保存文件

            Map<String,Object> result=new HashMap<String, Object>();//一个文件上传的结果
            String result_msg="";//上传结果信息

            if (file.getSize() / 1000 > 100){
                result_msg="图片大小不能超过100KB";
            }
            else{
                //判断上传文件格式
                String fileType = file.getContentType();
                if (fileType.equals("image/jpeg") || fileType.equals("image/png") || fileType.equals("image/jpeg")) {
                    // 要上传的目标文件存放的绝对路径
                    final String localPath="F:\\SPPanAdmin\\SPPanAdmin\\src\\main\\resources\\templates\\img";
                    //上传后保存的文件名(需要防止图片重名导致的文件覆盖)
                    //获取文件名
                    String fileName = file.getOriginalFilename();
                    //获取文件后缀名
                    String suffixName = fileName.substring(fileName.lastIndexOf("."));
                    //重新生成文件名
                    fileName = UUID.randomUUID()+suffixName;
                    if (FileUtils.upload(file, localPath, fileName)) {
                        //文件存放的相对路径(一般存放在数据库用于img标签的src)
                        String relativePath="img/"+fileName;
                        result.put("relativePath",relativePath);//前端根据是否存在该字段来判断上传是否成功
                        result_msg="图片上传成功";
                        Serviceimg tmpimg = new Serviceimg();
                        tmpimg.setImgdate(new Date());
                        tmpimg.setImgname(fileName);
                        tmpimg.setImgpath(relativePath);
                        tmpimg.setServiceid(serviceid);
                        serviceImgService.saveOrUpdate(tmpimg);
                    }
                    else{
                        result_msg="图片上传失败";
                    }
                }
                else{
                    result_msg="图片格式不正确";
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
