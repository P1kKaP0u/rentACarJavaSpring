package kodlama.io.rentACar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Tüm endpoint'ler için geçerli
                .allowedOrigins("http://localhost:63342") // İzin verilen origin (frontend URL'si)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // İzin verilen HTTP metodları
                .allowedHeaders("*") // İzin verilen header'lar
                .allowCredentials(true); // Çerez veya oturum bilgilerine izin
    }
}
