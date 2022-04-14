package com.silentsunshine.blueprintsystem.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhouqichun
 **/
public class EntityGenerator {
    private static final String URL = "jdbc:mysql://localhost:3306/blueprint-system?characterEncoding=UTF8&userSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String AUTHOR = "zhouqichun";
    private static final String OUTPUT_DIR = "D://Project/blueprintsystem/src/main/java";
    private static final String PACKAGE_PARENT = "com.silentsunshine.blueprintsystem";
    private static List<String> tables = Arrays.asList("flow_template");

    public static void main(String[] args) {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig(builder -> {
                    builder.author(AUTHOR) // 设置作者
                            .outputDir(OUTPUT_DIR); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(PACKAGE_PARENT); // 设置父包名
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables)
                            .entityBuilder()
                            .enableLombok(); // 设置需要生成的表名
                })
                .execute();
    }
}
