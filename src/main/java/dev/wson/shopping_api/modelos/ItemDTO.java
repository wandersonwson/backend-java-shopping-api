package dev.wson.shopping_api.modelos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ItemDTO {
    @NotBlank
    private String produtoId;
    @NotNull
    private float preco;

    public static ItemDTO converterParaItemDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProdutoId(item.getProdutoId());
        itemDTO.setPreco(item.getPreco());
        return itemDTO;
    }
}