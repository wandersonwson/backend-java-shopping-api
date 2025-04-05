package dev.wson.shopping_api.servicos;

import dev.wson.shopping_api.modelos.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.wson.shopping_api.modelos.Shop;
import dev.wson.shopping_api.modelos.ShopDTO;
import dev.wson.shopping_api.repositorios.ShopRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopService {
    @Autowired
    public ShopRepository shopRepository;

    public ShopDTO salvar(ShopDTO shopDTO) {
        shopDTO.setTotal(shopDTO.getItens()
            .stream()
            .map(ItemDTO::getPreco)
            .reduce((float) 0, Float::sum)
        );
        Shop shop = Shop.converterParaShop(shopDTO);
        shop.setData(LocalDate.now());
        shop = shopRepository.save(shop);
        return ShopDTO.converterParaShopDTO(shop);
    }
    public List<ShopDTO> buscarTodos() {
        List<Shop> shops = shopRepository.findAll();
        return shops.stream()
            .map(ShopDTO::converterParaShopDTO)
            .collect(Collectors.toList());
    }
    public List<ShopDTO> buscarPorUsuario(String usuarioId) {
        List<Shop> shops = shopRepository.findAllByUsuarioId(usuarioId);
        return shops.stream()
            .map(ShopDTO::converterParaShopDTO)
            .collect(Collectors.toList());
    }
    public List<ShopDTO> buscarPorData(LocalDate data) {
        List<Shop> shops = shopRepository.findAllByDataGreaterThanEqual(data);
        return shops.stream()
            .map(ShopDTO::converterParaShopDTO)
            .collect(Collectors.toList());
    }
    public ShopDTO buscarPorId(long id) {
        Optional<Shop> shop = shopRepository.findById(id);
        if (shop.isEmpty()) {
            return null;
        }
        return ShopDTO.converterParaShopDTO(shop.get());
    }
}