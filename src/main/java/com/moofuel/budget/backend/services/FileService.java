package com.moofuel.budget.backend.services;

import com.moofuel.budget.backend.domain.entities.File;
import com.moofuel.budget.backend.exceptions.CantCreateEntityException;
import com.moofuel.budget.backend.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Author is D.Ivanov, created on 09.07.2016.
 */
@Service
public class FileService {


    @Autowired
    private FileRepository fileRepository;

    @Transactional
    public Collection<File> createNewFiles(Collection<File> files) {
        if (!files.isEmpty()) {
            for (File file : files) {
                if (file.getId() != null || file.getImage() == null || file.getImage().length == 0) {
                    throw new CantCreateEntityException("File ID must not be specified and given image must not be null or empty!");
                }
            }
        }
        return fileRepository.save(files);
    }
}
