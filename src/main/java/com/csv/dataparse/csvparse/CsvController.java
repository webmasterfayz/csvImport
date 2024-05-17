package com.csv.dataparse.csvparse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/csv")
public class CsvController {
    @Autowired
    private CsvService csvService;

    @PostMapping("/upload")
    public ResponseEntity<List<Map<String, String>>> uploadCsv(@RequestParam("file") MultipartFile file) throws IOException {
        List<Map<String, String>> records = csvService.parseCsv(file);
        return ResponseEntity.ok(records);
    }
}
