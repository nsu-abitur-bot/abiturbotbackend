package ru.nsu.abitur.bot.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
/**
 * Сущность для хранения сообщений пользователя в БД.
 */
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    private String text;

    @CreatedDate
    @Column(updatable = false)
    private Instant createdAt;

}
