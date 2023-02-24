package me.peleshyan.coursework3.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Склад носков", description = "Стартовая траница")
@RestController
public class FirstController {

    @GetMapping
    @Operation(
            summary = "Start",
            description = "Проверка работоспособности сайта"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Сайт работает",
                            content = {
                                    @Content(
                                            mediaType = "application/json"
                                    )
                            }
                    )
            }
    )
    public String start() {
        return "Приложение запущено!";
    }

    @Operation(
            summary = "WEB",
            description = "Описание сайта"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Информация о сайте выведена",
                            content = {
                                    @Content(
                                            mediaType = "application/json"
                                    )
                            }
                    )
            }
    )
    @GetMapping("/info")
    public String name() {
        String title = "Склад носков <br>";
        String nameProject = "Найди свою пару <br>";
        String creatTime = "20.02.2022 <br>";
        String description = "Склад носков для любого существа <br>";
        return title + nameProject + creatTime  + description;
    }
}
