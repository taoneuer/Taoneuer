package com.sly.c2cpay.controller.admin;

import com.sly.c2cpay.pojo.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {



    @PostMapping("/uploadImg")
    @ResponseBody
    public ResultInfo test(@RequestParam(value = "head_img")MultipartFile multipartFile,
                           HttpServletRequest request){
        //获取原文件名字
        String filename = multipartFile.getOriginalFilename();
        //获取后缀
        String suffix=null;
        if (filename!=null) {
             suffix= filename.substring(filename.lastIndexOf('.'));
        }

        //文件名
         filename = UUID.randomUUID().toString().concat(suffix).replaceAll("-", "");

        File file=new File("static/img/");
        String src="img/"+filename;
        try {
            multipartFile.transferTo(new File(file.toString()+"/"+filename));
            return new ResultInfo(0, src, "上传成功", request.getRequestURI());
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultInfo(-1, null, "上传失败", request.getRequestURI());
        }


    }


}
