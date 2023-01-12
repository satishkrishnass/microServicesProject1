package com.myProjects.movieinfoservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;

@SpringBootTest
@BootstrapWith(value=SpringBootTestContextBootstrapper.class)
class MovieInfoServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
