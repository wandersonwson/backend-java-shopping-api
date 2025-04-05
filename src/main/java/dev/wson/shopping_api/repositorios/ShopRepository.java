package dev.wson.shopping_api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.wson.shopping_api.modelos.Shop;
import java.util.List;
import java.time.LocalDate;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findAllByUsuarioId(String usuarioId);
    List<Shop> findAllByTotalGreaterThan(float total);
    List<Shop> findAllByDataGreaterThanEqual(LocalDate data);
}