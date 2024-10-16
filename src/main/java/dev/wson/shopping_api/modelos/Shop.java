package dev.wson.shopping_api.modelos;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

@Data
@Entity(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String usuarioId;
    private float total;
    private LocalDate data;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "shop_item", joinColumns = @JoinColumn(name = "shop_id"))
    private List<Item> itens;

    public static Shop converterParaShop(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setUsuarioId(shopDTO.getUsuarioId());
        shop.setData(shopDTO.getData());
        shop.setTotal(shopDTO.getTotal());
        shop.setItens(
            shopDTO.getItens()
            .stream()
            .map(Item::converterParaItem)
            .collect(Collectors.toList())
        );
        return shop;
    }
}