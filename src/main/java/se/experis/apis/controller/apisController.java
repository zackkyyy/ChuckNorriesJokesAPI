package se.experis.apis.controller;


import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.experis.apis.APIsConnection;

import java.sql.Connection;
import java.util.ArrayList;

@RestController
public class apisController {
    APIsConnection apIsConnection= new APIsConnection();
    @GetMapping ("/random")
    public String getString() throws Exception {
        return apIsConnection.getRandomJoke();
    }

    @GetMapping ("/jokes/random/{category}")
    public String getrandomString(@PathVariable String category ) throws Exception {

        String str ="";
        return  str;
    }

    @GetMapping ("/jokes/categories")
    public ArrayList<String> getrandomString() throws Exception {
        System.out.println("here");
        return apIsConnection.getAllCategories();
    }

}
