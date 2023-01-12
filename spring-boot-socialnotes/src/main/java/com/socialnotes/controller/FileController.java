package com.socialnotes.controller;

import com.socialnotes.model.FilePost;
import com.socialnotes.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/file")
@CrossOrigin //annotazione per il cross domain tra client e server
public class FileController {
    private final FileService fileService;
    @Autowired
    public FileController(FileService fileService) { this.fileService = fileService; }
    @PostMapping
    boolean setFile (@RequestBody FilePost file) { return fileService.setFile(file); }

    @DeleteMapping("deleteFile/{idFile}")
    boolean deleteFile (@PathVariable String idFile) { return fileService.deleteFile(idFile); }

    }
