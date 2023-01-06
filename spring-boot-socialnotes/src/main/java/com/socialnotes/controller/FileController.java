package com.socialnotes.controller;

import com.socialnotes.model.File;
import com.socialnotes.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/file")
public class FileController {
    private final FileService fileService;
    @Autowired
    public FileController(FileService fileService) { this.fileService = fileService; }
    @PostMapping
    boolean setFile (@RequestBody File file) { return fileService.setFile(file); }

    @DeleteMapping("deleteFile/{idFile}")
    boolean deleteFile (@PathVariable String idFile) { return fileService.deleteFile(idFile); }

    }