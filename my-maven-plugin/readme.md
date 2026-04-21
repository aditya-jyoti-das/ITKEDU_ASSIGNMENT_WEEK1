How to create a custom Maven plugin
Creating a custom Maven plugin is a process that consists of several steps. Let’s go through them in detail.

Step 1: Create a Maven project

Create a new Maven project.

You can generate a Maven project using the following command:

mvn archetype:generate \
-DgroupId=com.example \
-DartifactId=my-maven-plugin \
-DarchetypeArtifactId=maven-archetype-mojo \
-DinteractiveMode=false
This command creates a basic project structure for a Maven plugin.

Open the project in your IDE: Open the generated project in your preferred IDE (for example, IntelliJ IDEA or Eclipse).

Step 2: Create a Mojo class

A Mojo (Maven plain Old Java Object) is a class that implements the logic of your plugin.

Create a new class in the package com.example.my.maven.plugin.

For example, create HelloMojo.java:

package com.example.my.maven.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "hello")
public class HelloMojo extends AbstractMojo {

    @Parameter(property = "hello.name", defaultValue = "World")
    private String name;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Hello, " + name + "!");
    }
}
In this example:

The @Mojo(name = "hello") annotation indicates that this Mojo can be executed using the mvn hello command.

The @Parameter annotation is used to define plugin parameters.

The execute() method contains the plugin logic.

Step 3: Configure pom.xml

Update the pom.xml file for your plugin.

Make sure your pom.xml includes the following configuration and dependencies:

<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>my-maven-plugin</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>maven-plugin</packaging>

    <name>My Maven Plugin</name>

    <dependencies>
        <dependency>
            <groupId>org.apache.maven</groupId>
            <artifactId>maven-plugin-api</artifactId>
            <version>3.6.3</version>
        </dependency>
        <dependency>
            <groupId>org.apache.maven.plugin-tools</groupId>
            <artifactId>maven-plugin-annotations</artifactId>
            <version>3.6.0</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-plugin-plugin</artifactId>
                <version>3.6.0</version>
                <configuration>
                    <goalPrefix>myplugin</goalPrefix>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

In this example:

packaging is set to maven-plugin.

Dependencies for maven-plugin-api and maven-plugin-annotations are added.

maven-plugin-plugin is configured to generate plugin metadata and documentation.

Step 4: Build and use the plugin

Build the plugin:

mvn clean install
This command builds the plugin and installs it into the local Maven repository.

Use the plugin in another project:

Add the plugin to the pom.xml of another project:

<build>
    <plugins>
        <plugin>
            <groupId>com.example</groupId>
            <artifactId>my-maven-plugin</artifactId>
            <version>1.0-SNAPSHOT</version>
            <executions>
                <execution>
                    <goals>
                        <goal>hello</goal>
                    </goals>
                    <configuration>
                        <name>Maven</name>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>

Then run:

mvn com.example:my-maven-plugin:hello
Or, if you are using a goalPrefix:

mvn myplugin:hello
You will see the output:

[INFO] Hello, Maven!

Now you have your own Maven plugin that can be used in other projects. You can extend it by adding new Mojo classes and parameters to create more complex and useful plugins.