package by.exposit.web.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "git-commit-id")
public class GitCommitProperties {

  private String buildVersion;
  private String buildTime;
  private String gitBranch;
  private String gitCommitId;
  private String gitCommitMessage;
}
