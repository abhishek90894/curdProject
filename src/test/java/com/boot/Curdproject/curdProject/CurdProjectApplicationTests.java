package com.boot.Curdproject.curdProject;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootTest
class CurdProjectApplicationTests {

	@Test
	void contextLoads() {


		log.info("testing out project");
	}

	@Bean
	public ModelMapper mapper()
	{

		return new ModelMapper();
	}

}
