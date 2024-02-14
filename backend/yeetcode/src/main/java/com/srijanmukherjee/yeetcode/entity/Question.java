package com.srijanmukherjee.yeetcode.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.*;


@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "question")
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue
    UUID id;

    @Column(nullable = false)
    String title;

    @Column(unique = true, nullable = false)
    String slug;

    String content;

    String metadata;

    @Enumerated(EnumType.STRING)
    QuestionDifficulty difficulty;

    @ManyToMany
    @JoinTable(name = "question_tags", joinColumns = {@JoinColumn(name = "question_id")}, inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    Set<Tag> tags = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    List<CodeSnippet> codeSnippets = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    @JsonIgnore
    List<TestCase> testCases = new ArrayList<>();

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    public void addTestCase(TestCase testCase) {
        testCase.setQuestion(this);
        this.testCases.add(testCase);
    }
}
