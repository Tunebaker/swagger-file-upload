package ru.tnbkr.swaggerfileupload.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class FileController {

    @RequestMapping(value = "/file",
            method = RequestMethod.POST,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(
            summary = "Upload a file",
            description = "This endpoint allows you to upload a single file.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "multipart/form-data",
//                            mediaType = "application/octet-stream",
                            schema = @Schema(type = "string", format = "binary", name = "file", description= "file" )
                    )
            )
    )
    public List<String> addToProduct(
//            @RequestPart("file") MultipartFile file
//            @RequestParam("file") MultipartFile file
            @Parameter(description = "file", name = "file") final MultipartFile file
    ) {

        String originalFilename = file.getOriginalFilename();
        String string = file.getContentType().toString();
        String size = String.valueOf(file.getSize());
        return List.of(originalFilename, string, size);
    }
}
