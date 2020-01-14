package com.fangda.mojo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * @ProjectName: java-demo
 * @Package: com.fangda.mojo
 * @ClassName: MyTest2Mojo
 * @Author: ccq
 * @Description: 测试01maven插件，跟生命周期结合
 * @Date: 2020/1/13 16:24
 * @eg mvn groupId:artifactId:version:goal
 * mvn com.fangda:maven-plugin-demo:1.0-SNAPSHOT:myTest
 */
@Mojo(name = "myTest2" , defaultPhase = LifecyclePhase.INSTALL)
public class MyTest2Mojo extends AbstractMojo {
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("hello world maven-plugin....");
        getLog().info("跟生命周期结合了....");
    }
}
