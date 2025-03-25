package com.example.naverT.dto.naver.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NaverReqDto {
    private String query;

    @Builder.Default
    private int display = 1;
    @Builder.Default
    private int start = 1;
    @Builder.Default
    private String sort = "random";

    public MultiValueMap localParamsMap() {
        var map = new LinkedMultiValueMap<String, String>();
        map.add("query", query);
        map.add("start", String.valueOf(start));
        map.add("display", String.valueOf(display));
        map.add("sort", sort);

        return map;
    }
}
