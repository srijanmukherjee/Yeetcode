package com.srijanmukherjee.yeetcode.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "language")
@Table(name = "language")
public class Language {
    @Id
    String id;

    String name;
    // TODO: add rest of the parameters
}
