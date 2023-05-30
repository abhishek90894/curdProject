package com.boot.Curdproject.curdProject.service.impl;

import com.boot.Curdproject.curdProject.exception.BadApiRequest;
import com.boot.Curdproject.curdProject.service.fileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@Service
public class fileServiceImpl implements fileService {
    @Override
    public String uploadFile(MultipartFile file, String path) throws IOException {

          String originalFilename   = file.getOriginalFilename();
          log.info("original file name {}",originalFilename);
          String fileName = UUID.randomUUID().toString();
          String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
          String fileNameWithExtension = fileName+extension;
          String fullPathWithFileName = path+fileNameWithExtension;

          if(extension.equalsIgnoreCase(".png") || extension.equalsIgnoreCase(".jpg")||extension.equalsIgnoreCase(".jpeg"))
          {
                   // file save
              File folder = new File(path);
              if(!folder.exists())
              {
                  // create folder
                 folder.mkdirs();
              }

              // upload
              Files.copy(file.getInputStream(), Paths.get(fullPathWithFileName));
              return  fileNameWithExtension;
          }
          else {
            throw new BadApiRequest("file with this"+extension+"is not allowed");
          }

    }

    @Override
    public InputStream getResource(String path, String name) throws FileNotFoundException {

        String fullPath = path+File.separator+name;
        InputStream inputStream = new FileInputStream(fullPath);
        return inputStream;
    }
}
