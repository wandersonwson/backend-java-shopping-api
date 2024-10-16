package dev.wson.shopping_api.modelos;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Item {
    private String produtoId;
    private float preco;

    public static Item converterParaItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setProdutoId(itemDTO.getProdutoId());
        item.setPreco(itemDTO.getPreco());
        return item;
    };
}