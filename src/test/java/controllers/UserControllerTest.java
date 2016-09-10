package controllers;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import prelude.AbstractTest;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Author is D.Ivanov, created on 10.09.2016.
 */

@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/CreateAndPopulateTestTables.sql")
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "/DropTestTables.sql")
public class UserControllerTest extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerTest.class);

    @Test
    public void findByIdTest() throws Exception {

        LOGGER.info("Executing UserControllerTest#findByIdTest()...");

        getMockMvc().perform(get("/users/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.id", Matchers.greaterThan(0)))
                .andExpect(jsonPath("$.fio", is("Света")))
                .andExpect(jsonPath("$.password", is("1234567890qwertyuiop")))
                .andExpect(jsonPath("$.additionalInfo", is("Тратит деньги на одежду")))
                .andExpect(jsonPath("$.active", is(false)))
                .andReturn();
    }
}
