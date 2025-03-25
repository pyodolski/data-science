package com.example.naverT.controller;

import com.example.naverT.dto.naver.search.NaverReqDto;
import com.example.naverT.service.naver.search.LocalSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/naver/apis")
@RestController
public class NaverController {

    private final LocalSearchService localSearchService;

    @GetMapping(path = "/local/search")
    public ResponseEntity localSearch(NaverReqDto dto) {
        log.info("Naver Controller local Search Data = {}", dto);
        return ResponseEntity.ok(localSearchService.process(dto));
    }
}
