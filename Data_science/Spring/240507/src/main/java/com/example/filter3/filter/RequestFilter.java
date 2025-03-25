package com.example.filter3.filter;

import com.example.filter3.component.JsonUtils;
import com.example.filter3.dto.UserDto;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class RequestFilter implements Filter {
    private final JsonUtils jsonUtils;
    private static final Logger log = LoggerFactory.getLogger(RequestFilter.class);  // import jakarta.suvlet 으로 해야함!!

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("filter start .....");  // test
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;  // 캐스팅 해서 필터링
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;


        // get 방식 QueryParam 확인
        String name = httpServletRequest.getParameter("name");  // getParameter 은 String으로 반환한다.
        String pw = httpServletRequest.getParameter("pw");
        String age = httpServletRequest.getParameter("age");
        try{
            base64Utils.decode(pw);
            httpServletResponse.sendRedirect("/error.html");
            return;
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }

        // parameter를 검증하고 필요에 의해 추가적인 데이터를 보내거나 할 때
        // attribute를 활용하세요.
        httpServletRequest.setAttribute("updateParam", "kim");  // parameter 추가 request에 속성추가

        String bodyStr = readRequestBody(httpServletRequest);
        log.info("Post Body Str = {}", bodyStr);
        UserDto userDto = jsonUtils.strToObj(bodyStr, UserDto.class);


        userDto.setPw("888888");
        httpServletRequest.setAttribute("requestBody", userDto);



        // controller 진입전
        filterChain.doFilter(httpServletRequest,httpServletResponse);

        // 디버깅을 해보면 진입전과 후 사이에 로직을 넣어줄 수 있다.

        // controllelr 진입후
        log.info("filter end .....");
    }

    public String readRequestBody(HttpServletRequest httpServletRequest) throws IOException {

        // getReader() : bufferReader, post 방식은 바디에 담아오기 때문에 파라미터가 아니라 stream 방식을 사용한다. (throws exception)
        // lines() : 한라인한라인을 읽어 stream 으로 변환
        // collect() : 수집
        // Collectors.joining() : 내가 정해준 글자만 join 해서 읽어오겠다.
        // System.lineSeparator() : 개행문자
        return httpServletRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    }
}
