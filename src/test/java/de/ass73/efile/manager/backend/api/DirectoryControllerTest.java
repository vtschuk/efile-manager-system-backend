package de.ass73.efile.manager.backend.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ass73.efile.manager.backend.model.DirectoryModel;
import de.ass73.efile.manager.backend.service.DirectoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DirectoryController.class)
public class DirectoryControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private DirectoryService directoryService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getAllDirectories() throws Exception {
        DirectoryModel directoryModel = DirectoryModel.builder()
                .id(new Random().nextLong())
                .name("")
                .build();

        Mockito.when(directoryService.getAllDirectories()).thenReturn(List.of(directoryModel));

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/directory/all")
                .header(HttpHeaders.AUTHORIZATION, "Bearer Test")
        ).andExpect(status().isOk()).andReturn();

        var returnValue = result.getResponse().getContentAsString();
        var expectedValue = objectMapper.writeValueAsString(List.of(directoryModel));

        Assertions.assertEquals(returnValue, expectedValue);
    }

    @Test
    public void getDirectoryById() throws Exception {
        DirectoryModel directoryModel = DirectoryModel.builder()
                .id(new Random().nextLong())
                .name("")
                .build();
        Mockito.when(directoryService.getDirectoryById(anyLong())).thenReturn(directoryModel);
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/directory/1")
                .header(HttpHeaders.AUTHORIZATION, "Bearer Test")
        ).andExpect(status().isFound()).andReturn();

        var returnValue = result.getResponse().getContentAsString();
        var expectedValue = objectMapper.writeValueAsString(directoryModel);

        Assertions.assertEquals(returnValue, expectedValue);
    }

    @Test
    public void createDirectory() throws Exception {
        DirectoryModel directoryModel = DirectoryModel.builder()
                .id(new Random().nextLong())
                .name("")
                .build();
        Mockito.when(directoryService.createDirectory(directoryModel)).thenReturn(directoryModel);
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/directory")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(directoryModel))
                ).andExpect(status().isCreated()).andReturn();
        var returnValue = result.getResponse().getContentAsString();
        var expectedValue = objectMapper.writeValueAsString(directoryModel);

        Assertions.assertEquals(returnValue, expectedValue);
    }

    @Test
    public void deleteDirectory() {

    }
}
