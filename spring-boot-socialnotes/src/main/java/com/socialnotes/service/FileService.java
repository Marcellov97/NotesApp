package com.socialnotes.service;

import com.socialnotes.dao.FileDao;
import com.socialnotes.model.FilePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    private final FileDao fileDao;
    @Autowired
    public FileService(@Qualifier("FileDao") FileDao fileDao) { this.fileDao = fileDao; }

    public boolean setFile (FilePost file) { return fileDao.setFile(file);}
    public boolean deleteFile (String idFile) { return fileDao.deleteFile(idFile);}

}
