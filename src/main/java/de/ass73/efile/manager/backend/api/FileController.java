package de.ass73.efile.manager.backend.api;

import de.ass73.efile.manager.backend.model.DirectoryModel;
import de.ass73.efile.manager.backend.model.FileModel;
import de.ass73.efile.manager.backend.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/dir/{id}", produces = "application/json")
    public ResponseEntity<List<FileModel>> getAllFilesFromDirectory(@PathVariable Long id) {
        return new ResponseEntity<>(fileService.getAllFilesFromDirectory(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<FileModel> getFileById(@PathVariable Long id) {
        return new ResponseEntity<>(fileService.getFileById(id), HttpStatus.FOUND);
    }

    public ResponseEntity<DirectoryModel> createFileInDirectory(@PathVariable Long dirId, @RequestBody FileModel fileModel) {
        return new ResponseEntity<>(fileService.createFile(dirId, fileModel), HttpStatus.CREATED);
    }

    public ResponseEntity<DirectoryModel> deleteFile(@PathVariable Long id) {
        return new ResponseEntity<>(fileService.deleteFile(id), HttpStatus.ACCEPTED);
    }
}
