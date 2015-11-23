package com.github.kongeor.vxml;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.Collections;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {

        port(Integer.parseInt(System.getProperty("PORT", "4567")));
        staticFileLocation("/public");

        get("/echo", (req, res) -> {
            String prompt = req.queryParams("prompt");
            Map<String, String> attrs = Collections.singletonMap("prompt", prompt);
            return new ModelAndView(attrs, "vxml.ftl");
        }, new FreeMarkerEngine());
    }
}
