package de.ass73.efile.manager.backend.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ass73.efile.manager.backend.model.DirectoryModel;
import de.ass73.efile.manager.backend.model.FileModel;
import de.ass73.efile.manager.backend.service.FileService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FileController.class)
public class FileControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private FileService fileService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getAllFilesFromDirectory() throws Exception {
        FileModel fileModel = FileModel.builder()
                .id(new Random().nextLong())
                .name("")
                .build();

        Mockito.when(fileService.getAllFilesFromDirectory(anyLong())).thenReturn(List.of(fileModel));

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/file/1")
                .header(HttpHeaders.AUTHORIZATION, "Bearer Test")
        ).andExpect(status().isOk()).andReturn();

        var returnValue = result.getResponse().getContentAsString();
        var expectedValue = objectMapper.writeValueAsString(List.of(fileModel));

        Assertions.assertEquals(returnValue, expectedValue);
    }

    @Test
    public void getFileById() {

    }

    @Test
    public void createFileInDirectory() {

    }

    @Test
    public void deleteFile() {

    }
}
