package com.sparta.coffeedeliveryproject.controller;

import com.sparta.coffeedeliveryproject.dto.ReviewRequestDto;
import com.sparta.coffeedeliveryproject.dto.ReviewResponseDto;
import com.sparta.coffeedeliveryproject.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cafes")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{cafeId}/orders/{orderId}/reviews")
    public ReviewResponseDto createReview(@PathVariable Long cafeId,
                                          @PathVariable Long orderId,
                                          @Valid @RequestBody ReviewRequestDto requestDto/*,
                                          @AuthenticationPrincipal UserDetailsImpl userDetails*/){
        return reviewService.createReview(cafeId, orderId, requestDto/*, userDetails.getUser()*/);
    }

//    @GetMapping("/{cafeId}/reviews")
//    public ReviewResponseDto getReview(@PathVariable Long cafeId,
//                                        @RequestBody ReviewRequestDto requestDto){
//
//        return reviewService.getReview(cafeId);
//
//    }

//    @GetMapping("/reviews")
//    public List<ReviewResponseDto> getReview(){
//        return reviewService.getReview();
//    }

    @PutMapping("/reviews/{reviewId}")
    public ReviewResponseDto updateReview(@PathVariable Long reviewId,
                                          @Valid @RequestBody ReviewRequestDto requestDto/*,
                                          @AuthenticationPrincipal UserDetailsImpl userDetails*/){
        return reviewService.updateReview(reviewId, requestDto/*, userDetails.getUser()*/);
    }

}
