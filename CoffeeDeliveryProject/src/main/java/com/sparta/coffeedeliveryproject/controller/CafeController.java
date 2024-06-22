package com.sparta.coffeedeliveryproject.controller;

import com.sparta.coffeedeliveryproject.dto.CafeMenuListResponseDto;
import com.sparta.coffeedeliveryproject.dto.CafeResponseDto;
import com.sparta.coffeedeliveryproject.service.CafeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cafes")
public class CafeController {

    private final CafeService cafeService;

    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @GetMapping
    public ResponseEntity<List<CafeResponseDto>> getAllCafe(@RequestParam(value = "page", defaultValue = "1") int page,
                                                            @RequestParam(value = "sortBy", defaultValue = "cafeId") String sortBy) {

        List<CafeResponseDto> responseDtoList = cafeService.getAllCafe(page - 1, sortBy);

        return ResponseEntity.status(HttpStatus.OK).body(responseDtoList);
    }

    @GetMapping("/{cafeId}")
    public ResponseEntity<CafeMenuListResponseDto> getCafeWithMenuList(@PathVariable(value = "cafeId") Long cafeId) {

        CafeMenuListResponseDto responseDto = cafeService.getCafeWithMenuList(cafeId);

        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

}
