
package com.example.controlador;

import com.example.entidades.Cliente;
import com.example.servicios.ClientesRegistrados;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


        @RestController
        @CrossOrigin(origins = "http://localhost:9999")
        @RequestMapping("/gestion")

        public class ControladorCliente {

          @Autowired
          private ClientesRegistrados clientesRegistrados;


          @GetMapping("/clientes/{id}")
          public Cliente buscarCliente(@PathVariable Integer id) {

              return this.clientesRegistrados.buscarCliente(id);
          }

          @GetMapping("/clientes")
          public List<Cliente> clientesRegistrados() {

             return clientesRegistrados.listaClientesRegistrados();
          }

          @GetMapping("/misclientes")
          @ResponseBody
          public List<Cliente>  misClientesRegistrados() {

             return clientesRegistrados.listaClientesRegistrados();
          }

          @PostMapping("/clientes")
          public  Cliente nuevoCliente(@RequestBody Cliente cliente) {

            this.clientesRegistrados.ingresarCliente(cliente);
            return cliente;
          }

          @PutMapping("/actualizar/{id}")
          public  ResponseEntity<String> actualizarCliente(@RequestBody Cliente cliente,
                                                           @PathVariable Integer id) {

            if (this.clientesRegistrados.actualizarInformacionCliente(cliente, id))
                return ResponseEntity.ok("Cliente actualizado correctamente");
            else
                return ResponseEntity.ok("Cliente no está registrado");

          }
          @DeleteMapping("/remover/{id}")
          public ResponseEntity<String> removerEmpleado(@PathVariable Integer id) {
            if (this.clientesRegistrados.eliminarInformacionCliente(id))
                return ResponseEntity.ok("Cliente eliminado correctamente");
            else
                return ResponseEntity.ok("Cliente no está registrado");
          }

        }
