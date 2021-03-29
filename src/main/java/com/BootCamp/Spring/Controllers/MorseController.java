package com.BootCamp.Spring.Controllers;

import com.BootCamp.Spring.Entities.MorseDiccionary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseController {

    @GetMapping(value = "/translate")
    public String translate (@RequestParam String codigoMorse) {

        return "";
    }

    private String translateChar (String morse) {
        MorseDiccionary diccionary = new MorseDiccionary();
        StringBuilder translatedChar = new StringBuilder();
        for (int i = 0; i < diccionary.codigos.length; i++){
            if (diccionary.codigos[i].equals(morse)){
                translatedChar.append(diccionary.caracteres[i]);
            }
        }
        return translatedChar.toString();
    }

}
