package se.experis.apis.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.experis.apis.ChuckConnection;

import java.util.ArrayList;

@RestController
public class apisController {
    ChuckConnection chuckConnection = new ChuckConnection();
    @GetMapping ("/jokes/random")
    public String getString() throws Exception {
        return chuckConnection.getRandomJoke();
    }

    @GetMapping ("/jokes/random/{category}")
    public String getrandomString(@PathVariable String category ) throws Exception {
        String str = "<!DOCTYPE html> \n"+
                "<html lang='en'>\n "+
                " <head>\n "+
                " <meta charset=\"UTF-8\">\n "+
                "      <title>Title</title>\n "+
                "  <link rel='stylesheet' href='../../static/master.css'>\n "+
                " </head>\n "+
                "  <body>\n "+
                " <h>The joke </h>\n "+
                "  <p> "+chuckConnection.getRandomFromCategory(category)+" </p>\n "+
                "  <button> <a href=" + "/" + ">return</a></button>\n " +
                " </body>\n "+
                "</html>";
        return  str;
    }

    @GetMapping ("/jokes/categories")
    public ArrayList<String> getrandomString() throws Exception {
        System.out.println("here");
        return chuckConnection.getAllCategories();
    }

}
