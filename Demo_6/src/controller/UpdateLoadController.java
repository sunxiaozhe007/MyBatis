package controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import util.Commons;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
public class UpdateLoadController {

    @RequestMapping("uploadPic")
    public void uploadPic(HttpServletRequest request, String fileName, PrintWriter out){
        //把request强转成多部件请求对象
        MultipartHttpServletRequest mh = (MultipartHttpServletRequest) request;
        //根据文件名称获取文件对象
        CommonsMultipartFile cm = (CommonsMultipartFile) mh.getFile(fileName);
        //获取文件上传流
        byte[] bytes = cm.getBytes();

        //文件名称重复问题
        String newFileName ="";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        newFileName = dateFormat.format(new Date());
        Random random = new Random();
        for (int i = 0; i < 3; i++){
            newFileName = newFileName+random.nextInt(10);
        }
        //获取文件扩展名
        String originalFilename = cm.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        //创建jesy服务器，进行跨服务器上传
        Client client = Client.create();
        //把文件关联到服务器
        WebResource resource = client.resource(Commons.PIC_HOST+"/upload"+newFileName+suffix);
        //上传
        resource.put(String.class,bytes);

        //图片需要回显，需要图片完整路径
        //数据库保存图片相对路径
        String fullPath = Commons.PIC_HOST+"/upload"+newFileName+suffix;
        String relativePath = "/upload"+newFileName+suffix;
        String result = "(\"fullPath\":\""+fullPath+"\",\"relativePath\":\""+relativePath+"\")";

    }
}
