package de.ass73.efile.manager.backend.api;

import de.ass73.efile.manager.backend.model.DirectoryModel;
import de.ass73.efile.manager.backend.model.FileModel;
import de.ass73.efile.manager.backend.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    public ResponseEntity<List<FileModel>> getAllFilesFromDirectory(@PathVariable Long id) {
        return new ResponseEntity<>(fileService.getAllFilesFromDirectory(id), HttpStatus.OK);
    }

    public ResponseEntity<FileModel> getFileById(@PathVariable Long id) {
        return new ResponseEntity<>(fileService.getFileById(id), HttpStatus.FOUND);
    }

    public ResponseEntity<DirectoryModel> createFileinDirectory(@PathVariable Long dirId, @RequestBody FileModel fileModel) {
        return new ResponseEntity<>(fileService.createFile(dirId, fileModel), HttpStatus.CREATED);
    }

    public ResponseEntity<DirectoryModel> deleteFile(@PathVariable Long id) {
        return new ResponseEntity<>(fileService.deleteFile(id), HttpStatus.ACCEPTED);
    }
}
