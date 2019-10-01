package se.experis.apis.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.experis.apis.ChuckConnection;

import java.util.ArrayList;

@RestController
public class apisController {
    ChuckConnection chuckConnection = new ChuckConnection();
    @GetMapping ("/random")
    public String getString() throws Exception {
        return chuckConnection.getRandomJoke();
    }

    @GetMapping ("/jokes/random/{category}")
    public String getrandomString(@PathVariable String category ) throws Exception {
        String str = chuckConnection.getRandomFromCategory(category);
        return  str;
    }

    @GetMapping ("/jokes/categories")
    public ArrayList<String> getrandomString() throws Exception {
        System.out.println("here");
        return chuckConnection.getAllCategories();
    }

}
