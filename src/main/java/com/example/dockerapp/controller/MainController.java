package com.example.dockerapp.controller;

import com.example.dockerapp.imports.ImportsManager;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/")
public class MainController {
    @Autowired
    private ImportsManager importsManager;

    @GetMapping("v1/message")
    public String getMessage(){
        return "Hello from Docker";
    }
    @GetMapping("v1/messages")
    public String getMessages(){
        return "Messages from dockers ....";
    }

    /**
     * importProducts is for getting data from xl
     * @param multipartFile
     * @return
     * @throws Exception
     */
    @PostMapping("v1/import")
    public String importProducts(@RequestParam(name = "multipartFile") MultipartFile multipartFile) throws Exception {
        List<String> productIdList = null;
        Gson gson = new Gson();
        String returnText = null;

        productIdList = importsManager.importProducts(multipartFile);
        returnText = gson.toJson(productIdList);

        return returnText;
    }

}
