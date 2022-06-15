package com.example.dockerapp.controller;

import com.example.dockerapp.exception.GeneralException;
import com.example.dockerapp.imports.ImportsManager;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private ImportsManager importsManager;

    @GetMapping("/v1/message")
    public String getMessage(){
        return "Hello from Docker";
    }
    @GetMapping("/v1/messages")
    public String getMessages(){
        return "Messages from dockers ....";
    }

    /**
     * importProducts is for getting data from xl
     * @param multipartFile
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "Import Products", tags = "File Import", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Imported product Successfully")
    })
    @PostMapping("/v1/import")
    public String importProducts(@RequestParam(name = "multipartFile") MultipartFile multipartFile) {
        List<String> productIdList = null;
        Gson gson = new Gson();
        String returnText = null;
        try {
            productIdList = importsManager.importProducts(multipartFile);
            returnText = gson.toJson(productIdList);
        }catch (Exception exception){
            throw new GeneralException(" importProducts failed " + exception.getMessage());
        }
        return returnText;
    }

}
