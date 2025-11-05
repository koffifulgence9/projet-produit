package com.produit.produit.repositories;

import com.produit.produit.entities.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<ProduitEntity, Long> {
    ProduitEntity findByName(String name);
}
