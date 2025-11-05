package com.produit.produit.Services;

import com.produit.produit.entities.ProduitEntity;
import com.produit.produit.repositories.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

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
        Optional<ProduitEntity> optionalProduitEntity = produitRepository.findById(id);

        if(optionalProduitEntity.isEmpty()){
            throw new RuntimeException("Produit non trouvé");
        }
        return optionalProduitEntity.get();
    }

    public String deleteProduitById(Long id) {
        Optional<ProduitEntity> optionalProduitEntity = produitRepository.findById(id);

        if(optionalProduitEntity.isEmpty()){
            throw new RuntimeException("Produit non trouvé");
        }
        produitRepository.delete(optionalProduitEntity.get());
        return "Produit supprimé";
    }

    public ProduitEntity editProduit(Long idProduit, ProduitEntity produit) {
        Optional<ProduitEntity> optionalProduitEntity = produitRepository.findById(idProduit);

        if(optionalProduitEntity.isEmpty()){
            throw new RuntimeException("Modification impossible");
        }
        ProduitEntity produitAModifier = optionalProduitEntity.get();
        produitAModifier.setName(produit.getName());
        produitAModifier.setPrice(produit.getPrice());

        return produitRepository.save(produitAModifier);
    }
}
