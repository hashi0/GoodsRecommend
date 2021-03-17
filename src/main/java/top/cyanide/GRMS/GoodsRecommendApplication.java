package top.cyanide.GRMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
@ServletComponentScan
public class GoodsRecommendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsRecommendApplication.class, args);
    }

}
