package capstone.agora;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AgoraApplication.class)
class AgoraApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		if (applicationContext != null) {
			String[] beans = applicationContext.getBeanDefinitionNames();
			for (String bean : beans) {
				System.out.println("bean : " + bean);
			}
		}
	}

}
