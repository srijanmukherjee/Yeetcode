package com.srijanmukherjee.yeetcode.service.impl;

import com.srijanmukherjee.yeetcode.entity.Language;
import com.srijanmukherjee.yeetcode.repository.LanguageRepository;
import com.srijanmukherjee.yeetcode.service.LanguageService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    LanguageRepository languageRepository;

    @Override
    public Language addLanguage(Language language) {
        languageRepository.save(language);
        return language;
    }

    @Override
    public List<Language> getLanguages() {
        List<Language> languages = new ArrayList<>();
        languageRepository.findAll().forEach(languages::add);
        return languages;
    }
}
