package ru.nsu.abitur.bot.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.abitur.bot.core.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
