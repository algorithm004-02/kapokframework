package com.kapokframework.springmvc;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * @author Will WM. Zhang
 * @since 2017-01-04 15:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(name = "app", locations = "classpath:spring.xml"),
        @ContextConfiguration(name = "mvc", locations = "classpath:spring-mvc.xml")
})
public class RequestJsonStringTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void setPersonTest() throws Exception {
        String person = getData("classpath:datas/person.json");
        mockMvc.perform(
                post("/jsonstring/setPerson")
                        .param("person", person)
                        .param("name", "lisi")
                        .param("gender", "female")
                        .param("dateOfBirth", "1986-10-10")
                        .param("createTime", "2017-02-09 18:03:30")
        ).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void setPersonWithCarsTest() throws Exception {
        String personWithCars = getData("classpath:datas/personWithCars.json");
        mockMvc.perform(
                post("/jsonstring/setPersonWithCars")
                        .param("personWithCars", personWithCars)
                        .param("name", "lisi")
                        .param("gender", "female")
                        .param("dateOfBirth", "2017-01-27")
        ).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void setPersonsTest() throws Exception {
        String persons = getData("classpath:datas/persons.json");
        mockMvc.perform(
                post("/jsonstring/setPersons")
                        .param("persons", persons)
        ).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void setPersonsWithCarsTest() throws Exception {
        String persons = getData("classpath:datas/personsWithCars.json");
        mockMvc.perform(
                post("/jsonstring/setPersonsWithCars")
                        .param("persons", persons)
        ).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void setPersonsMapTest() throws Exception {
        String personsMap = getData("classpath:datas/personsMap.json");
        mockMvc.perform(
                post("/jsonstring/setPersonsMap")
                        .param("personsMap", personsMap)
        ).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void setPersonsWapperMapTest() throws Exception {
        String personsMap = getData("classpath:datas/personsMap.json");
        mockMvc.perform(
                post("/jsonstring/setPersonsWapperMap")
                        .param("personsMap", personsMap)
        ).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void getPersonTest() throws Exception {
        mockMvc.perform(
                get("/jsonstring/getPerson")
        ).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void getPersonsTest() throws Exception {
        mockMvc.perform(
                get("/jsonstring/getPersons")
        ).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void getPersonResponseBody() throws Exception {
        mockMvc.perform(
                get("/jsonstring/getPersonResponseBody")
        ).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void exceptionTest() throws Exception {
        String person = getData("classpath:datas/person.json");
        mockMvc.perform(
                post("/jsonstring/setPerson")
                        .param("person", person)
                        .param("person", person)
        ).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void setPersonValidatorTest() throws Exception {
        String personNullName = getData("classpath:datas/personValidator.json");
        mockMvc.perform(
                post("/jsonstring/setPersonValidator")
                        .param("person", personNullName)
        ).andExpect(status().isOk()).andDo(print());
    }

    private String getData(String path) throws Exception {
        return FileUtils.readFileToString(ResourceUtils.getFile(path), Charset.defaultCharset());
    }

}
