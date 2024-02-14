package com.srijanmukherjee.yeetcode.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "test_case")
@Table(name = "test_case")
public class TestCase {
    @Id
    @GeneratedValue
    Long id;
    String input;
    String output;
    Boolean example = false;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    Question question;
}
