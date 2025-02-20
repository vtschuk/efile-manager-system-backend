package de.ass73.efile.manager.backend.api;

import de.ass73.efile.manager.backend.model.DirectoryModel;
import de.ass73.efile.manager.backend.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DirectoryController {

    @Autowired
    private DirectoryService directoryService;

    public ResponseEntity<List<DirectoryModel>> getAllDirectories() {
        return new ResponseEntity<>(directoryService.getAllDirectories(), HttpStatus.OK);
    }

    public ResponseEntity<DirectoryModel> getDirectoryById(@PathVariable Long id) {
        return new ResponseEntity<>(directoryService.getDirectoryById(id), HttpStatus.FOUND);
    }

    public ResponseEntity<DirectoryModel> createDirectory(@RequestBody DirectoryModel directoryModel) {
        return new ResponseEntity<>(directoryService.createDirectory(directoryModel), HttpStatus.CREATED);
    }

    public void deleteDirectory() {

    }
}
