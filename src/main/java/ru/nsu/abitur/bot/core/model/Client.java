package ru.nsu.abitur.bot.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
/**
 * Сущность для хранения клиента бота в БД.
 */
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long telegramId;
    @Column(unique = true)
    private Long maxId;
    private Long applicantId;
    @CreatedDate
    @Column(updatable = false)
    private Instant createdAt;

}
