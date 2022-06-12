package ironyang.security1.web;

import ironyang.security1.config.WebSecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;



@WebMvcTest
@Import(WebSecurityConfig.class)
class HomeControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void home() throws Exception {
        //given
        mvc.perform(get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}