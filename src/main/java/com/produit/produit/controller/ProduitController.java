package com.produit.produit.controller;

import com.produit.produit.Services.ProduitServices;
import com.produit.produit.entities.ProduitEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController(value = "produitController")
@RequestMapping("/api/v1/produit")
@CrossOrigin
@RequiredArgsConstructor
public class ProduitController {
    private final ProduitServices produitServices;

    @GetMapping("/all")
    public List<ProduitEntity> getAllProduit(){
        return produitServices.getAllProduits();
    }

    @GetMapping("/{id}")
    public ProduitEntity getProduitById(@PathVariable Long id){
        return produitServices.getProduitById(id);
    }


    @PostMapping
    public ProduitEntity createProduit(@RequestBody ProduitEntity produit){
        return produitServices.createProduit(produit);
    }
    @DeleteMapping("/{id}")
    public String deleteProduitById(@PathVariable("id") Long idProduit){
        return produitServices.deleteProduitById(idProduit);
    }
    @PutMapping("/{id}")
    public ProduitEntity editProduit(@PathVariable("id") Long idProduit, @RequestBody ProduitEntity produit){
        return produitServices.editProduit(idProduit, produit);
    }
}
