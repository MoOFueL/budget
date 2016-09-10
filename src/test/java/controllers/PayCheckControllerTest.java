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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Author is D.Ivanov, created on 10.09.2016.
 */
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/CreateAndPopulateTestTables.sql")
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "/DropTestTables.sql")
public class PayCheckControllerTest extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerTest.class);

    @Test
    public void findAllChecksByUserIdTest() throws Exception {

        LOGGER.info("Executing PayCheckControllerTest#findAllChecksByUserIdTest()...");

        getMockMvc().perform(get("/paychecks/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id", greaterThan(0)))
                .andExpect(jsonPath("$[0].createdAt", isA(Long.class)))
                .andExpect(jsonPath("$[0].createdAt", lessThan(new Date().getTime())))
                .andExpect(jsonPath("$[0].name", isA(String.class)))
                .andExpect(jsonPath("$[0].sum", greaterThan(0)))
                .andExpect(jsonPath("$[0].images").isArray())
                .andExpect(jsonPath("$[0].images", hasSize(greaterThan(0))))
                .andExpect(jsonPath("$[0].images[0].id", greaterThan(0)))
                .andExpect(jsonPath("$[0].images[0].createdAt", isA(Long.class)))
                .andExpect(jsonPath("$[0].images[0].name", isA(String.class)))
                .andExpect(jsonPath("$[0].images[0].image", isA(String.class)));
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    public void createPayCheckTest() throws Exception {

        LOGGER.info("Executing PayCheckControllerTest#createPayCheckTest()...");

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        Path platformIndependentPath = Paths.get(classloader.getResource("PayCheck.json").toURI());
        String content = new String(Files.readAllBytes(platformIndependentPath));

        getMockMvc().perform(post("/paychecks/users/2").content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.id", is(4)))
                .andExpect(jsonPath("$.userId", is(2)))
                .andExpect(jsonPath("$.createdAt", isA(Long.class)))
                .andExpect(jsonPath("$.createdAt", lessThan(new Date().getTime())))
                .andExpect(jsonPath("$.name", isA(String.class)))
                .andExpect(jsonPath("$.name").isNotEmpty())
                .andExpect(jsonPath("$.name", equalToIgnoringCase("aliexpress")))
                .andExpect(jsonPath("$.additionalInfo", isA(String.class)))
                .andExpect(jsonPath("$.additionalInfo", equalToIgnoringCase("Платье2")))
                .andExpect(jsonPath("$.sum").exists())
                .andExpect(jsonPath("$.sum", isA(Integer.class)))
                .andExpect(jsonPath("$.sum", greaterThan(0)))
                .andExpect(jsonPath("$.images").isArray())
                .andExpect(jsonPath("$.images", hasSize(1)))
                .andExpect(jsonPath("$.images[0].id", isA(Integer.class)))
                .andExpect(jsonPath("$.images[0].id", equalTo(4)))
                .andExpect(jsonPath("$.images[0].createdAt", isA(Long.class)))
                .andExpect(jsonPath("$.images[0].createdAt", lessThan(new Date().getTime())))
                .andExpect(jsonPath("$.images[0].image").exists())
                .andExpect(jsonPath("$.images[0].image", isA(String.class)))
                .andExpect(jsonPath("$.images[0].image").isNotEmpty());

        getMockMvc().perform(get("/paychecks/users/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)));

        getMockMvc().perform(get("/users/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.fio", is("Света")))
                .andExpect(jsonPath("$.payChecks").isArray())
                .andExpect(jsonPath("$.payChecks", hasSize(2)));
    }
}
