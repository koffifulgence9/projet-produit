package com.produit.produit.Services;

import com.produit.produit.entities.ProduitEntity;
import com.produit.produit.repositories.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitServices {
    private final ProduitRepository produitRepository;

    public List<ProduitEntity> getAllProduits() {
        return produitRepository.findAll();
    }

    public ProduitEntity createProduit(ProduitEntity produit) {
        return produitRepository.save(produit);
    }

    public ProduitEntity getProduitById(Long id) {
        return produitRepository.findById(id).orElse(null);
    }
}
