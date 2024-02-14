package com.srijanmukherjee.yeetcode.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "confirmation_code")
@Table(name = "confirmation_code")
public class ConfirmationCode {
    @Id
    @GeneratedValue
    Integer id;
    @OneToOne
    User user;
    String code;
    LocalDateTime expiresAt;
    @CreationTimestamp
    LocalDateTime createdAt;
}
