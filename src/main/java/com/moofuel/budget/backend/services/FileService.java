package com.moofuel.budget.backend.services;

import com.moofuel.budget.backend.domain.entities.File;
import com.moofuel.budget.backend.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by MoOFueL on 09.07.2016.
 */
@Service
public class FileService {


    @Autowired
    private FileRepository fileRepository;

    @Transactional
    public Collection<File> createNewFiles(Collection<File> files) {
        return fileRepository.save(files);
    }
}
