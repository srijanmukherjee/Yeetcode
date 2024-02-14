package com.srijanmukherjee.yeetcode.repository;

import com.srijanmukherjee.yeetcode.entity.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends CrudRepository<Language, String> {
}
