package vlad110kg.core.service;

import vlad110kg.core.entity.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {

    Client create(Client client);

    Optional<Client> get(Long id);

    List<Client> getAll();

    Client update(Long id, Client updatedClient);

    void deleteClient(Long id);

}
