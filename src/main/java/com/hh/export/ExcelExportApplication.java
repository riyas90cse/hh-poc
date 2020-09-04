package com.hh.export;

import com.hh.export.service.writer.HHExportPDFBuilder;
import com.hh.export.service.writer.HHExportPDFBuilderService;
import com.hh.export.service.writer.HHExportPdfCreatorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExcelExportApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExcelExportApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ExcelExportApplication.class, args);
    }

    @Bean
    public HHExportPdfCreatorService pdfCreator() {
        return new HHExportPdfCreatorService();
    }

    @Bean
    public HHExportPDFBuilder pdfBuilder() {
        return new HHExportPDFBuilderService(pdfCreator());
    }
}
