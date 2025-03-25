package com.example.naverT.dto.naver.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NaverResDto {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;

    @Builder.Default
    private List<Item> items = new ArrayList<>();

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Item {
        private String title;
        private String link;
        private String category;
        private String description;
        private String telephone;
        private String address;
        private String roadAddress;
        private int mapx;
        private int mapy;
    }
}
