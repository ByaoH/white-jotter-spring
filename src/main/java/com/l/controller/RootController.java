package com.l.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author l
 */
@RestController
@RequestMapping("/root")
public class RootController {
    @GetMapping
    public String test() {
        return "test";
    }
}
