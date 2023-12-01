package hello.datasource;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.util.List;

@Getter
@ConfigurationProperties("my.datasource")
@Validated
public class MyDataSourcePropertiesV3 {

  private String url;

  private String username;

  private String password;

  private Etc etc;

  public MyDataSourcePropertiesV3(String url, String username, String password, Etc etc) {
    this.url = url;
    this.username = username;
    this.password = password;
    this.etc = etc;
  }

  @Getter
  public static class Etc {

    @Min(1)
    @Max(999)
    private int maxConnection;

    @DurationMin(seconds = 1)
    @DurationMax(seconds = 60)
    private Duration timeout;

    private List<String> options;

    // 값이 없을 경우, @DefaultValue의 값 사용
    public Etc(int maxConnection, Duration timeout, @DefaultValue("DEFAULT") List<String> options) {
      this.maxConnection = maxConnection;
      this.timeout = timeout;
      this.options = options;
    }
  }

}
