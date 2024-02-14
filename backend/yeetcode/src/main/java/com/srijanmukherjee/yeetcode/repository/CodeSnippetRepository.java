package com.srijanmukherjee.yeetcode.repository;

import com.srijanmukherjee.yeetcode.entity.CodeSnippet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeSnippetRepository extends CrudRepository<CodeSnippet, String> {
}
