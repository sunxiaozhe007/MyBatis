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
        //��requestǿת�ɶಿ���������
        MultipartHttpServletRequest mh = (MultipartHttpServletRequest) request;
        //�����ļ����ƻ�ȡ�ļ�����
        CommonsMultipartFile cm = (CommonsMultipartFile) mh.getFile(fileName);
        //��ȡ�ļ��ϴ���
        byte[] bytes = cm.getBytes();

        //�ļ������ظ�����
        String newFileName ="";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        newFileName = dateFormat.format(new Date());
        Random random = new Random();
        for (int i = 0; i < 3; i++){
            newFileName = newFileName+random.nextInt(10);
        }
        //��ȡ�ļ���չ��
        String originalFilename = cm.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        //����jesy�����������п�������ϴ�
        Client client = Client.create();
        //���ļ�������������
        WebResource resource = client.resource(Commons.PIC_HOST+"/upload"+newFileName+suffix);
        //�ϴ�
        resource.put(String.class,bytes);

        //ͼƬ��Ҫ���ԣ���ҪͼƬ����·��
        //���ݿⱣ��ͼƬ���·��
        String fullPath = Commons.PIC_HOST+"/upload"+newFileName+suffix;
        String relativePath = "/upload"+newFileName+suffix;
        String result = "(\"fullPath\":\""+fullPath+"\",\"relativePath\":\""+relativePath+"\")";

    }
}
