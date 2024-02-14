package com.srijanmukherjee.yeetcode.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Entity(name = "code_snippet")
@Table(name = "code_snippet")
public class CodeSnippet {
    @Id
    @GeneratedValue
    Long id;

    String code;

    @ManyToOne(fetch = FetchType.EAGER)
    Language language;
}
