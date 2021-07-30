package by.exposit.web.controllers;

import by.exposit.web.properties.GitCommitProperties;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("project")
public class GitCommitController {

  @Autowired
  private GitCommitProperties properties;

  @GetMapping("/info")
  public ResponseEntity<Map<String, String>> getInfo() {
    return new ResponseEntity<>(
        getPropertiesMap(),
        HttpStatus.OK
    );
  }

  private Map<String, String> getPropertiesMap() {
    Map<String, String> map = new HashMap<>();
    map.put("build-version", properties.getBuildVersion());
    map.put("build-time", properties.getBuildTime());
    map.put("branch", properties.getGitBranch());
    map.put("commit-id", properties.getGitCommitId());
    map.put("commit-message", properties.getGitCommitMessage());

    return map;
  }
}
