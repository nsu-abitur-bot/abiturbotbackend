package ru.nsu.abitur.bot.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.abitur.bot.core.model.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    public boolean existsByTelegramId(String telegramId);
    public boolean existsByMaxId(String maxId);

    public Optional<Client> findByTelegramId(String telegramId);
    public Optional<Client> findByMaxId(String maxId);
}
