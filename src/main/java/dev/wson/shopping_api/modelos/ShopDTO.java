package dev.wson.shopping_api.modelos;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ShopDTO {
    @NotBlank
    private String usuarioId;
    @NotNull
    private float total;
    @NotNull
    private LocalDate data;
    @NotNull
    private List<ItemDTO> itens;

    public static ShopDTO converterParaShopDTO(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUsuarioId(shop.getUsuarioId());
        shopDTO.setTotal(shop.getTotal());
        return shopDTO;
    }
}