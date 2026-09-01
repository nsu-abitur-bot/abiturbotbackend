package ru.nsu.abitur.bot.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.abitur.bot.core.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
