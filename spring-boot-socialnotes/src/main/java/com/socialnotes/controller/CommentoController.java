package com.socialnotes.controller;

import com.socialnotes.dao.CommentoDao;
import com.socialnotes.model.Commento;
import com.socialnotes.service.CommentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/commento")
public class CommentoController {
    private final CommentoService commentoService;
    @Autowired
    public CommentoController(CommentoService commentoService) { this.commentoService = commentoService; }

    @GetMapping("/getCommentiPost/{idPost}")
    public List<Commento> getCommentiPost (@PathVariable String idPost) { return commentoService.getCommentiPost(idPost); }

    @PostMapping
    public boolean setCommento (@RequestBody Commento commento) { return commentoService.setCommento(commento); }

    @DeleteMapping("deleteCommento/{idCommento}")
    public boolean deleteCommento (@PathVariable String idCommento) { return commentoService.deleteCommento(idCommento); }

    @DeleteMapping("deleteCommentiPost/{idPost}")
    public boolean deleteCommentiPost (@PathVariable String idPost) { return commentoService.deleteCommentiPost(idPost); }

    }