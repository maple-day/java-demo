package com.fangda.mojo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.UnsupportedEncodingException;

/**
 * @ProjectName: java-demo
 * @Package: com.fangda.mojo
 * @ClassName: ParamsMojo
 * @Author: ccq
 * @Description: 与参数绑定的插件
 * @Date: 2020/1/14 9:34
 */
@Mojo(name = "paramTest", defaultPhase = LifecyclePhase.CLEAN)
public class ParamsMojo extends AbstractMojo {

    /**
     * property通过引用用户通过-D选项设置的系统属性，该参数可用于允许从命令行配置mojo参数
     */
    @Parameter(name = "name", defaultValue = "李四")
    private String name;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        getLog().info(String.format("参数name：%s", name));


    }
}
