package hello;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EnviromentCheck {

  private final Environment env;

  public EnviromentCheck(Environment env) {
    this.env = env;
  }

  /**
   * VM option과 Program arguments 어느 것을 사용해도 설정값을 가져온다.
   * Program arguments가 우선. (1. 더 유연하고  2. 접근 범위가 더 좁기 때문)
   */
  @PostConstruct
  public void init() {
    String url = env.getProperty("url");
    String username = env.getProperty("user");
    String password = env.getProperty("password");
    log.info("env url={}", url);
    log.info("user={}", username);
    log.info("password={}", password);
  }
}
