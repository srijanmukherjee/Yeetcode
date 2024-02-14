package com.srijanmukherjee.yeetcode.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Entity(name = "tags")
@Table(name = "tags", indexes = @Index(columnList = "slug"))
public class Tag {
    @Id
    @GeneratedValue
    Long id;

    @Column(unique = true)
    String name;

    @Column(unique = true)
    String slug;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    List<Question> questions;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;
}
