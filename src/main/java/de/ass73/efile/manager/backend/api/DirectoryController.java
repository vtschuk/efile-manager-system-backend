package de.ass73.efile.manager.backend.api;

import de.ass73.efile.manager.backend.model.DirectoryModel;
import de.ass73.efile.manager.backend.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directory")
public class DirectoryController {

    @Autowired
    private DirectoryService directoryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<DirectoryModel>> getAllDirectories() {
        return new ResponseEntity<>(directoryService.getAllDirectories(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<DirectoryModel> getDirectoryById(@PathVariable Long id) {
        return new ResponseEntity<>(directoryService.getDirectoryById(id), HttpStatus.FOUND);
    }

    public ResponseEntity<DirectoryModel> createDirectory(@RequestBody DirectoryModel directoryModel) {
        return new ResponseEntity<>(directoryService.createDirectory(directoryModel), HttpStatus.CREATED);
    }

    public void deleteDirectory() {
         directoryService.deleteDirectory();
    }
}
