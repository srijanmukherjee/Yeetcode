package com.srijanmukherjee.yeetcode.controller;

import com.srijanmukherjee.yeetcode.entity.Language;
import com.srijanmukherjee.yeetcode.service.LanguageService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class LanguageController {
    LanguageService languageService;

    @GetMapping
    public List<Language> getLanguages() {
        return languageService.getLanguages();
    }

    @PostMapping
    public Language addLanguage(@RequestBody Language language) {
        return languageService.addLanguage(language);
    }
}
