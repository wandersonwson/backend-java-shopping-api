package dev.wson.shopping_api.controladores;

import dev.wson.shopping_api.modelos.ShopDTO;
import dev.wson.shopping_api.servicos.ShopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/shopping")
public class ShopController {
    @Autowired
    public ShopService shopService;

    @PostMapping
    public ShopDTO salvar(@Valid @RequestBody ShopDTO shopDTO) {
        return shopService.salvar(shopDTO);
    }
    @GetMapping
    public List<ShopDTO> buscarCompras() {
        List<ShopDTO> compras = shopService.buscarTodos();
        return compras;
    }
    @GetMapping("/usuario/{usuarioId}")
    public List<ShopDTO> buscarComprasPorUsuario(@PathVariable String usuarioId) {
        List<ShopDTO> compras = shopService.buscarPorUsuario(usuarioId);
        return compras;
    }
    @GetMapping("/data")
    public List<ShopDTO> buscarComprasPorData(ShopDTO shopDTO) {
        List<ShopDTO> compras = shopService.buscarPorData(shopDTO);
        return compras;
    }
    @GetMapping("/{id}")
    public ShopDTO buscarPorId(@PathVariable long id) {
        return shopService.buscarPorId(id);
    }
}