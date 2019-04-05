package io.github.jiezhi.wx.miniapp.controller;

import io.github.jiezhi.wx.miniapp.error.StorageException;
import io.github.jiezhi.wx.miniapp.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-04-01 13:41
 * Function:
 * <p>
 * Ref: https://spring.io/guides/gs/uploading-files/
 */
@Controller
public class FileController {
    private final StorageService storageService;

    @Autowired
    public FileController(StorageService service) {
        this.storageService = service;
    }

    @GetMapping("/upload")
    public String listUploadedFiles(Model model) throws IOException {
        model.addAttribute("files", storageService
            .loadAll()
            .map(path ->
                MvcUriComponentsBuilder.fromMethodName(
                    FileController.class, "serveFile", path.getFileName().toString()
                )
                    .build().toString()
            )
            .collect(Collectors.toList()));
        return "uploadForm";
    }

    @GetMapping("/upload/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
            .ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + file.getFilename() + "\"")
            .contentType(MediaType.IMAGE_JPEG)
            .body(file);
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/upload";
    }

    @ExceptionHandler(StorageException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageService exc) {
        return ResponseEntity.notFound().build();
    }
}
