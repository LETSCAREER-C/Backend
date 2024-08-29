package com.letscareer_c.docs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

//외부에 공개하고자하는 테스트 케이스만 명세서로 만들기 위해 따로 테스트코드 작성
@ExtendWith(RestDocumentationExtension.class)
public abstract class RestDocsSupport {
    protected MockMvc mockMvc;

    //REST Docs Document에 대한 설정을 가지고 있는 MockMVC 생성
    @BeforeEach
    void setUp(RestDocumentationContextProvider provider){
        //initController에서 넘어온 Controller를 대상으로 한 mockMvc가 생성
        this.mockMvc = MockMvcBuilders.standaloneSetup(initController())
                .apply(documentationConfiguration(provider))
                .build();
    }

    //mock(가짜) Service 객체를 의존하는 Controller 객체 반환
    protected abstract Object initController();

}
