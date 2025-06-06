package com.eis.apirestconmvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/recursos")
public class RecursoRest {


    @GetMapping("/datos")
    public String consultarDatos(Model model){
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://jsonplaceholder.typicode.com/posts/1";
        String respuesta = restTemplate.getForObject(url, String.class);
        model.addAttribute("dato1", respuesta);

        url = "http://localhost:9090/gestion/clientes";
        respuesta = restTemplate.getForObject(url, String.class);
        model.addAttribute("dato2", respuesta);

        return "pagina1";
    }
}
