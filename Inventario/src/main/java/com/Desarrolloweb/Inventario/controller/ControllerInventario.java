package com.Desarrolloweb.Inventario.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Desarrolloweb.Inventario.model.Producto;

@Controller
public class ControllerInventario {
    @GetMapping("/productos")
    public String productos(Model model){
        model.addAttribute("mensaje","PRODUCTO NUEVO");
        Producto producto = new Producto(null, null, 0, 0, null,false,null);
        List<String> listaOpciones = Arrays.asList("procesadores", "video", "telefonia","almacenamiento", "perifericos","portatiles", "sonido","comunicaciones","video juegos","accesorios");
        model.addAttribute("opciones", listaOpciones);
        model.addAttribute("producto", producto);
        return "vistas/producto_nuevo";
    }

    @PostMapping("/consulta")
    public String consulta(@ModelAttribute Producto producto, Model model){
        model.addAttribute("producto", producto);
        model.addAttribute("mensaje", "Consulta del producto: "+producto.getDescripcion());
        model.addAttribute("disponible", producto.getDisponible());
        return "vistas/consulta";
    }

    
}
