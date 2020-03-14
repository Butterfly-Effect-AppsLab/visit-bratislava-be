package com.visitbratislavabe.controllers;

import com.visitbratislavabe.models.Place;
import org.springframework.web.bind.annotation.GetMapping;

public interface IPlaceRestController {
    @GetMapping("/random")
    Place getRandomPlace();
}
