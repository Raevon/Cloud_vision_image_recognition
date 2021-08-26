package Google_cloud_vision.API.Controllers;
import Models.Labels;
import Parser.Parser;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.Feature;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3001", "http://localhost:4200", "http://localhost:8081" })
@RestController
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
@RequestMapping(value = "/api")
public class APIController {
private   AnnotateImageResponse response;
    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private CloudVisionTemplate cloudVisionTemplate;

    public APIController(){
    }
    @GetMapping("/getLabelDetection")
    @ResponseBody
    public List<Labels> getresponse(@RequestParam(required = false) String imageURL) throws ParseException, IOException {
        String imageUrl = imageURL;
        Resource imageResource = this.resourceLoader.getResource(imageUrl);
         response = this.cloudVisionTemplate.analyzeImage(imageResource,
                 Feature.Type.LABEL_DETECTION);
        List<Labels> labels = Parser.parseLabelss(Parser.getArray("filename.txt",response.getLabelAnnotationsList().toString()));
        return labels;
    }
    }


