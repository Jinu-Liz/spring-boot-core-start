package hello.pay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Configuration
public class PayConfig {

  @Bean
  @Profile("default")   // @Conditional을 사용하여 조건에 따라 profile 설정
  public LocalPayClient localPayClient() {
    log.info("LocalPayClient 빈 등록");

    return new LocalPayClient();
  }

  @Bean
  @Profile("prod")
  public ProdPayClient payClient() {
    log.info("ProdPayClient 빈 등록");

    return new ProdPayClient();
  }
}
