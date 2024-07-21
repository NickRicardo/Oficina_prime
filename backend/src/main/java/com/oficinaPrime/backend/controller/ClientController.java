package com.oficinaPrime.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficinaPrime.backend.dto.ClientDTO;
import com.oficinaPrime.backend.service.ClientService;




@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO){
        ClientDTO createdClient = clientService.createClient(clientDTO);
        return ResponseEntity.ok(createdClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Integer id, @RequestBody ClientDTO clientDTO){
        ClientDTO updatedClient = clientService.updateClient(id, clientDTO);
        if (updatedClient != null){
            return ResponseEntity.ok(updatedClient);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteClient(@PathVariable Integer id){
            clientService.deleteClient(id);
            return ResponseEntity.noContent().build();
        }
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable Integer id){
        ClientDTO clientDTO = clientService.getClientById(id);
        if (clientDTO != null){
            return ResponseEntity.ok(clientDTO);
            }
            return ResponseEntity.notFound().build();
            }   

}
