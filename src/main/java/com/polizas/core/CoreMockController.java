package com.polizas.core;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/core-mock")
public class CoreMockController {

    @PostMapping("/evento")
    public void evento(@RequestBody Map<String,Object> body) {
        System.out.println("Evento enviado al CORE: " + body);
    }
}
