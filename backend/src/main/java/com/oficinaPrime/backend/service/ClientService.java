package com.oficinaPrime.backend.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficinaPrime.backend.dto.ClientDTO;
import com.oficinaPrime.backend.model.Client;
import com.oficinaPrime.backend.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setNome(clientDTO.getNome());
        client.setCpf(clientDTO.getCpf());
        client.setEmail(clientDTO.getEmail());
        client.setTelefone(clientDTO.getTelefone());
        client.setEndereco(clientDTO.getEndereco());
        client.setCidade(clientDTO.getCidade());
        client.setUf(clientDTO.getUf());
        client.setCep(clientDTO.getCep());
        client.setVeiculo(clientDTO.getVeiculo());
        client.setPlaca(clientDTO.getPlaca());
        client.setModelo(clientDTO.getModelo());
        client.setMarca(clientDTO.getMarca());
        client.setBairro(clientDTO.getBairro());
        client.setTipo(clientDTO.getTipo());

        Client savedClient = clientRepository.save(client);
        return convertToDTO(savedClient);
    }

    public ClientDTO updateClient(Integer id, ClientDTO clientDTO) {
        Optional<Client> existingClient = clientRepository.findById(id);
        if (existingClient.isPresent()) {
            Client client = existingClient.get();
            // Atualize os campos do cliente existente
            client.setNome(clientDTO.getNome());
            client.setCpf(clientDTO.getCpf());
            client.setEmail(clientDTO.getEmail());
            client.setTelefone(clientDTO.getTelefone());
            client.setEndereco(clientDTO.getEndereco());
            client.setCidade(clientDTO.getCidade());
            client.setUf(clientDTO.getUf());
            client.setCep(clientDTO.getCep());
            client.setVeiculo(clientDTO.getVeiculo());
            client.setPlaca(clientDTO.getPlaca());
            client.setModelo(clientDTO.getModelo());
            client.setMarca(clientDTO.getMarca());
            client.setBairro(clientDTO.getBairro());
            client.setTipo(clientDTO.getTipo());

            Client updatedClient = clientRepository.save(client);
            return convertToDTO(updatedClient);
        }
        return null; 
    }

    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }

    public ClientDTO getClientById(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.map(this::convertToDTO).orElse(null);
    }

    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private ClientDTO convertToDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setNome(client.getNome());
        dto.setCpf(client.getCpf());
        dto.setEmail(client.getEmail());
        dto.setTelefone(client.getTelefone());
        dto.setEndereco(client.getEndereco());
        dto.setCidade(client.getCidade());
        dto.setUf(client.getUf()); 
        dto.setCep(client.getCep());
        dto.setVeiculo(client.getVeiculo());
        dto.setPlaca(client.getPlaca());
        dto.setModelo(client.getModelo());
        dto.setMarca(client.getMarca());
        dto.setBairro(client.getBairro());
        dto.setTipo(client.getTipo());
        return dto;
    }
}