package com.gjc.mybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MybatisPlusGeneratorTest {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatisplus?serverTimezone=GMT%2B8&characterEncoding=utf-8&&useSSL=true", "root", "123123")
                .globalConfig(builder -> {
                    builder.author("gjc") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:/01_WorkSapce/IDEAWorkspace/mybatisplus/src/main/java/com/gjc/mybatisplus/GeneratorTest"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.gjc.mybatisplus.GeneratorTest") // 设置父包名
                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapper, "D:/01_WorkSapce/IDEAWorkspace/mybatisplus/src/main/java/com/gjc/mybatisplus/GeneratorTest")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
