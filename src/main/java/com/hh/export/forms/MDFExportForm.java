package com.hh.export.forms;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * Created by Mohamed Riyas
 */
public class MDFExportForm implements Serializable {

    private MultipartFile exportFile;

    public MultipartFile getExportFile() {
        return exportFile;
    }

    public void setExportFile(MultipartFile exportFile) {
        this.exportFile = exportFile;
    }
}
