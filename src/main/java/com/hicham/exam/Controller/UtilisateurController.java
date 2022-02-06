package com.hicham.exam.Controller;

import com.hicham.exam.DAO.UtilisateurRepository;
import com.hicham.exam.Model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtilisateurController {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @PostMapping("/creerutilisateur")
    public Utilisateur creerUtilisateur(@RequestBody Utilisateur utilisateur){
        System.out.println(utilisateur);
        return utilisateurRepository.save(utilisateur);
    }

    @GetMapping("/listerutilisateur")
    public List<Utilisateur> listerUtilisateurs(@RequestParam int index, @RequestParam int size){

        Pageable pageable = PageRequest.of(index, size);
        Page<Utilisateur> page = utilisateurRepository.findAll(pageable);
        return page.getContent();
    }
}
