package tr.com.altyapi.staj.DemoService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import tr.com.altyapi.staj.DemoService.controller.DemoController;
import tr.com.altyapi.staj.DemoService.service.HelloService;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DemoController.class)
public class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private HelloService helloService;

    @Test
    public void testGetHello() throws Exception {
        String testString = "Unit test response";
        // tell the mock library to return 'unit test response' when called
        when(helloService.getHelloResponse()).thenReturn(testString);
        // perform the test.
        ResultActions performResult = mockMvc.perform(get("/hello"));
        // HTTP 200 OK is expected as status
        performResult.andExpect(status().isOk());
        // text/plain UTF-8 is expected as content type
        performResult.andExpect(content().contentType(new MediaType("text", "plain", StandardCharsets.UTF_8)));
        // 'unit test response' is expected as content
        performResult.andExpect(content().string("Unit test response"));
    }

}
