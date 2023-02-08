package scheper.mateus.springgpt.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import scheper.mateus.springgpt.dto.ClientDTO;
import scheper.mateus.springgpt.entity.Client;
import scheper.mateus.springgpt.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = clientDTO.toClient();
        client = clientRepository.save(client);
        return ClientDTO.fromClient(client);
    }

    public ClientDTO updateClient(ClientDTO clientDTO) {
        if (clientDTO.getIdClient() == null) {
            throw new IllegalArgumentException("Client ID must not be null");
        }
        Client existingClient = clientRepository.findById(clientDTO.getIdClient()).orElse(null);
        if (existingClient == null) {
            throw new EntityNotFoundException("Client not found");
        }
        existingClient.updateClient(clientDTO.toClient());
        return ClientDTO.fromClient(existingClient);
    }

    public void deleteClient(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Client ID must not be null");
        }
        clientRepository.deleteById(id);
    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(ClientDTO::fromClient)
                .collect(Collectors.toList());
    }

    public ClientDTO getClientById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Client ID must not be null");
        }
        return clientRepository.findById(id)
                .map(ClientDTO::fromClient)
                .orElse(null);
    }

}