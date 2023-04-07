package com.boot.Curdproject.curdProject.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class projectConfig {
    @Bean
    public ModelMapper mapper()
    {
<<<<<<< HEAD

=======
>>>>>>> 55008cc44612a6bde33ed6d61464ce120bf0bb0a
        return new ModelMapper();
    }
}
