package account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * = Application
 *
 * Project version: {projectVersion}.
 *
 * Sample Java application in project *{projectName}* 
 * to show Asciidoclet as replacement for the
 * default Javadoclet.
 *
 * include::README.adoc[]
 *
 * We can apply Asciidoc syntax in our Javadoclet comments, like:
 *
 *  - `code`
 *  - **bold**
 *  - _italics_
 *
 * @author eruiz
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}
