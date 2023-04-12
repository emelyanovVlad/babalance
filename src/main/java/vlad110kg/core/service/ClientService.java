package vlad110kg.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vlad110kg.core.entity.Client;
import vlad110kg.core.repo.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> get(Long id) {
        return clientRepository.findById(id);
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client update(Long id, Client updatedClient) {
        return clientRepository.findById(id)
            .map(client -> {
                client.setChatId(updatedClient.getChatId());
                return clientRepository.save(client);
            })
            .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}

