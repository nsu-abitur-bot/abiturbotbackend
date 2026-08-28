package ru.nsu.abitur.bot.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Entity
@NoArgsConstructor
@Getter
@Setter
/**
 * Сущность для хранения пользователя в БД.
 */
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private Long telegramId;
    @Column(unique = true)
    private Long maxId;
    private Long applicantId;
    @CreatedDate
    @Column(updatable = false)
    private Instant createdAt;

}
