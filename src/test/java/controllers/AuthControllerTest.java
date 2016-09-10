package controllers;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import prelude.AbstractTest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Author is D.Ivanov, created on 10.09.2016.
 */
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/CreateAndPopulateTestTables.sql")
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "/DropTestTables.sql")
public class AuthControllerTest extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthControllerTest.class);

    @Test
    public void authorizeTest() throws Exception {

        LOGGER.info("Executing AuthControllerTest#authorizeTest()...");

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        Path platformIndependentPath = Paths.get(classloader.getResource("AuthObject.json").toURI());
        String content = new String(Files.readAllBytes(platformIndependentPath));

        getMockMvc().perform(post("/auth")
                .content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.id", greaterThan(0)))
                .andExpect(jsonPath("$.fio", is("Света")))
                .andExpect(jsonPath("$.createdAt", isA(Long.class)))
                .andExpect(jsonPath("$.createdAt", greaterThan(0L)))
                .andExpect(jsonPath("$.password", isA(String.class)))
                .andExpect(jsonPath("$.password").isNotEmpty())
                .andExpect(jsonPath("$.active", is(true)))
                .andExpect(jsonPath("$.synchronizedAt", isA(Long.class)))
                .andExpect(jsonPath("$.synchronizedAt", lessThan(new Date().getTime())))
                .andExpect(jsonPath("$.payChecks").isArray())
                .andExpect(jsonPath("$.payChecks", hasSize(greaterThanOrEqualTo(0))));
    }
}
