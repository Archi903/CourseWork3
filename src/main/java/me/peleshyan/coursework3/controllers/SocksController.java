package me.peleshyan.coursework3.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.peleshyan.coursework3.controllers.dto.ResponseDto;
import me.peleshyan.coursework3.model.Color;
import me.peleshyan.coursework3.model.Quantity;
import me.peleshyan.coursework3.model.Size;
import me.peleshyan.coursework3.services.SocksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Работа с учетом носков")
@RequestMapping("/api/socks")
@RestController
@RequiredArgsConstructor
public class SocksController {

    private final SocksService socksService;

    @PostMapping
    @Operation(summary = "Регистрация прихода товара на склад")
    @ApiResponse(responseCode = "200", description = "удалось добавить приход")
    @ApiResponse(responseCode = "200", description = "параметры запроса отсутствуют или имеют некорректный формат")
    @ApiResponse(responseCode = "200", description = "произошла ошибка, не зависящая от вызывающей стороны")
    public ResponseEntity<ResponseDto> save(@RequestBody Quantity socks) {
        socksService.addSocks(socks);
        return ResponseEntity.ok(new ResponseDto("Носки добавлены"));
    }

    @PutMapping
    @Operation(summary = "Регистрация отпуска носков со склада")
    @ApiResponse(responseCode = "200", description = "удалось произвести отпуск носков со склада")
    @ApiResponse(responseCode = "200", description = "товара нет на складе в нужном количестве или параметры запроса имеют некорректный формат")
    @ApiResponse(responseCode = "200", description = "произошла ошибка, не зависящая от вызывающей стороны")
    public ResponseEntity<ResponseDto> remove(@RequestBody Quantity socks) {
        int count = socksService.deleteSocks(socks);
        return ResponseEntity.ok(new ResponseDto(count + " носков выданы из склада"));
    }

    @GetMapping
    @Operation(summary = "Показать общее количество носков на складе, соответствующих переданным в параметрах критериям запроса")
    @ApiResponse(responseCode = "200", description = "запрос выполнен, результат в теле ответа в виде строкового представления целого числа")
    @ApiResponse(responseCode = "200", description = "параметры запроса отсутствуют или имеют некорректный формат")
    @ApiResponse(responseCode = "200", description = "произошла ошибка, не зависящая от вызывающей стороны")
    public ResponseEntity<ResponseDto> getAllSocks(@RequestParam Color color, @RequestParam Size size, @RequestParam int cottonMin, @RequestParam int cottonMax) {
        int count = socksService.getSocks(color, size, cottonMin, cottonMax);
        return ResponseEntity.ok(new ResponseDto(count + " носков на складе"));
    }

    @DeleteMapping
    @Operation(summary = "Списание испорченных (бракованных) носков")
    @ApiResponse(responseCode = "200", description = "запрос выполнен, товар списан со склада")
    @ApiResponse(responseCode = "200", description = "параметры запроса отсутствуют или имеют некорректный формат")
    @ApiResponse(responseCode = "200", description = "произошла ошибка, не зависящая от вызывающей стороны")
    public ResponseEntity<ResponseDto> delete(@RequestBody Quantity socks) {
        int count = socksService.rejectSocks(socks);
        return ResponseEntity.ok(new ResponseDto(count + "носков списано со склада"));
    }


}
