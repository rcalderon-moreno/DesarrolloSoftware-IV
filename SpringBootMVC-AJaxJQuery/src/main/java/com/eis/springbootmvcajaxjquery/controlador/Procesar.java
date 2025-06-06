package com.eis.springbootmvcajaxjquery.controlador;


import ch.qos.logback.core.joran.spi.ElementSelector;
import com.eis.springbootmvcajaxjquery.dominio.PersonaDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class Procesar {
    private List<String> datos = Arrays.asList("A1", "A2","A3","A11", "A12","A13");
    private final String RUTA_DESTINO;

    public Procesar(@Value("${directorio.archivos}") String rutaDestino) {
        RUTA_DESTINO = rutaDestino;
    }
    @PostMapping("/ingresar")
    public String ingresarPersona(PersonaDTO persona, Model model) {

        model.addAttribute("persona", persona);

        return "personasregistradas";
    }

    @PostMapping("/ingresar_detalle")
    public String ingresarPersona(@RequestParam(name="nombres",defaultValue="***") String nombres,
                                  @RequestParam(name="apellidos",defaultValue="***") String apellidos,
                                  Model model) {

        PersonaDTO persona = new PersonaDTO(nombres, apellidos);
        model.addAttribute("persona", persona);

        return "personasregistradas";
    }
    @GetMapping("/listado")
    public String listadoElementos(Model model) {
        model.addAttribute("datos", this.datos);

        return "lista"; //view
    }

    @PostMapping("/archivos")
    public ResponseEntity<String> subirArchivo(@RequestParam("archivo") MultipartFile archivo) {

        System.out.println("Nombre: " + archivo.getOriginalFilename());
        System.out.println("Tamaño: " + archivo.getSize() + " bytes");

        if (archivo.isEmpty()) {
            return ResponseEntity.badRequest().body("El archivo está vacío");
        }

        try {

            File carpeta = new File(RUTA_DESTINO);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            String ruta = RUTA_DESTINO + File.separator + archivo.getOriginalFilename();
            archivo.transferTo(new File(ruta));

            return ResponseEntity.ok("Archivo guardado en: " + ruta);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al guardar el archivo");
        }
    }

}
