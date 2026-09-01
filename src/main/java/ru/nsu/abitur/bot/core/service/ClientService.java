package ru.nsu.abitur.bot.core.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import ru.nsu.abitur.bot.core.exception.EntityAlreadyExistsException;
import ru.nsu.abitur.bot.core.exception.ResourseNotFoundException;
import ru.nsu.abitur.bot.core.model.Client;
import ru.nsu.abitur.bot.core.model.MessengerType;
import ru.nsu.abitur.bot.core.repository.ClientRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class ClientService {

    private final ClientRepository clientRepository;

    /**
     * Добавляет клиента в БД.
     * @param messengerType
     * Из какого мессенджера клиент тг/макс.
     */
    public void addClient(String clientId, MessengerType messengerType) {
        Client client = switch (messengerType) {
            case TG -> {
                if (clientRepository.existsByTelegramId(clientId)) {
                    throw new EntityAlreadyExistsException("Client with telegramId " + clientId + " already exists");
                }
                yield Client.builder().telegramId(clientId).build();
            }
            case MAX -> {
                if (clientRepository.existsByMaxId(clientId)) {
                    throw new EntityAlreadyExistsException("Client with maxId " + clientId + " already exists");
                }
                yield Client.builder().maxId(clientId).build();
            }
        };
        clientRepository.save(client);
    }

    /**
     * Ищет клиента в БД.
     * @param id
     * @param messengerType
     * Из какого мессенджера клиент tg/max.
     * @return клиента.
     */
    public Client findByMessengerId(String id, MessengerType messengerType) {
        Optional<Client> clientOpt = switch (messengerType) {
            case TG -> clientRepository.findByTelegramId(id);
            case MAX -> clientRepository.findByMaxId(id);
        };
        return clientOpt.orElseThrow(() ->
                new ResourseNotFoundException(messengerType + "client with id:" + id + " not found"));
    }

}

