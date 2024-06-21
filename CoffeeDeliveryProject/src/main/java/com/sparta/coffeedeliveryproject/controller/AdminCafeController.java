package com.sparta.coffeedeliveryproject.controller;

import com.sparta.coffeedeliveryproject.dto.CafeRequestDto;
import com.sparta.coffeedeliveryproject.dto.CafeResponseDto;
import com.sparta.coffeedeliveryproject.service.AdminCafeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminCafeController {

    private final AdminCafeService adminCafeService;

    public AdminCafeController(AdminCafeService adminCafeService) {
        this.adminCafeService = adminCafeService;
    }

    @PostMapping("/cafes")
    public ResponseEntity<CafeResponseDto> createCafe(@RequestBody CafeRequestDto requestDto) {

        CafeResponseDto responseDto = adminCafeService.createCafe(requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping("/cafes")
    public ResponseEntity<List<CafeResponseDto>> getAllCafe(@RequestParam(value = "page", defaultValue = "1") int page) {

        List<CafeResponseDto> responseDtoList = adminCafeService.getAllCafe(page - 1);

        return ResponseEntity.status(HttpStatus.OK).body(responseDtoList);
    }

}