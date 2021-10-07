package com.example.issue638;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Issue638ApplicationTests {

    @LocalServerPort
    private int serverPort;

    @Autowired
    private SpringDataMediumFileRepository repo;

    @Autowired
    private SpringContentMediumFileStore store;

	@Test
	void contextLoads() throws IOException, InterruptedException {
        String content = "this is some content";

        MediumFileContentJpaEntity entity = repo.save(new MediumFileContentJpaEntity());
        entity = store.setContent(entity, new ByteArrayInputStream(content.getBytes()));
        entity = repo.save(entity);

        System.out.println("curl -H 'Accept: text/plain' http://localhost:" + serverPort + "/media-file-contents/" + entity.getId().toString());
        String command = "curl -H 'Accept: text/plain' http://localhost:" + serverPort + "/media-file-contents/" + entity.getId().toString();
        Process process = Runtime.getRuntime().exec(command);
        while (process.isAlive() == true) {
            Thread.sleep(1000);
        }
        assertThat(process.exitValue(), is(0));
        assertThat(IOUtils.toString(process.getInputStream()), is(content));
	}

}
