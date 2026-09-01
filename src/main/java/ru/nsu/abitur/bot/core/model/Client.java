package ru.nsu.abitur.bot.core.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Table(name = "clients")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
/**
 * Сущность для хранения клиента бота в БД.
 */
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;
    @Column(unique = true)
    private String telegramId;
    @Column(unique = true)
    private String maxId;
    private Long applicantId;
    @CreatedDate
    @Column(updatable = false)
    private Instant createdAt;

}
