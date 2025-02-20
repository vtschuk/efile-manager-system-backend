package de.ass73.efile.manager.backend.service;


import de.ass73.efile.manager.backend.model.DirectoryModel;
import de.ass73.efile.manager.backend.model.FileModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {
    public List<FileModel> getAllFilesFromDirectory(Long id) {
        return List.of(new FileModel());
    }

    public FileModel getFileById(Long id) {
        return new FileModel();
    }

    public DirectoryModel createFile(Long dirId, FileModel fileModel) {
        return new DirectoryModel();
    }

    public DirectoryModel deleteFile(Long id) {
        return new DirectoryModel();
    }
}
