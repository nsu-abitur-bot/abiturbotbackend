package ru.nsu.abitur.bot.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.abitur.bot.core.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
