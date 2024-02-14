package com.srijanmukherjee.yeetcode.service;

import com.srijanmukherjee.yeetcode.entity.Language;

import java.util.List;

public interface LanguageService {
    Language addLanguage(Language language);
    List<Language> getLanguages();
}
