package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.processing.SupportedSourceVersion;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author vikingar
 * @time 2024/1/11 14:55
 * @description file upload
 */
@RestController
public class FileController {

    /**
     * file upload method, 使用 postman 上传的时候，表单类型要改为 format-data
     *
     * @param nickname name and so on...
     * @param f        file
     * @param request  javaee 中的类-网络请求， 可以获取到请求所属的上下文对象（web服务器）
     * @return success or not
     * @throws IOException
     */
    @PostMapping("/upload")
    public String upload(String nickname, MultipartFile f, HttpServletRequest request) throws IOException {

        System.out.println("nickname: " + nickname);
        System.out.println("file size: " + f.getSize());
        System.out.println("file type: " + f.getContentType());
        System.out.println("file name: " + f.getOriginalFilename());
        String realPath = request.getServletContext().getRealPath("/upload/");
        String path = System.getProperty("user.dir") + "/upload/";
        System.out.println("realPath: " + realPath);
        System.out.println("path: " + path);
        // todo windows 下传入 path, linux下传入 realpath
        saveFile(f, realPath);
        return "upload successfully";
    }

    private void saveFile(MultipartFile f, String path) throws IOException {
        File upDir = new File(path);
        if (!upDir.exists()) {
            upDir.mkdir();
        }
        File file = new File(path + f.getOriginalFilename());
        f.transferTo(file);
    }


}
