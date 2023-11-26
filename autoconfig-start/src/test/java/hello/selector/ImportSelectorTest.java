package hello.selector;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

public class ImportSelectorTest {

  // 정적 방식
  @Test
  void staticConfig() {
    AnnotationConfigApplicationContext appConfig = new AnnotationConfigApplicationContext(StaticConfig.class);
    HelloBean bean = appConfig.getBean(HelloBean.class);
    assertThat(bean).isNotNull();
  }

  // 동적 방식
  @Test
  void selectorConfig() {
    AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SelectorConfig.class);
    HelloBean bean = appContext.getBean(HelloBean.class);
    assertThat(bean).isNotNull();
  }

  @Configuration
  @Import(HelloConfig.class)
  public static class StaticConfig {
  }

  @Configuration
  @Import(HelloImportSelector.class)
  public static class SelectorConfig {

  }
}
