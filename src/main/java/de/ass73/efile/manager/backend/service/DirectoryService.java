package de.ass73.efile.manager.backend.service;

import de.ass73.efile.manager.backend.model.DirectoryModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryService {
    public List<DirectoryModel> getAllDirectories() {
        return List.of(new DirectoryModel());
    }

    public DirectoryModel getDirectoryById(Long id) {
        return new DirectoryModel();
    }

    public DirectoryModel createDirectory(DirectoryModel directoryModel) {
        return new DirectoryModel();
    }

    public void deleteDirectory() {
        return;
    }
}
