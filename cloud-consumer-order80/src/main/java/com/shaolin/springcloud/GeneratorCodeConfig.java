package com.shaolin.springcloud;

/**
 * @Author: leisl
 * @Date: 2020/10/22 21:13
 */
import java.io.File;

import org.junit.jupiter.api.Test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class GeneratorCodeConfig {
    /**
     * 数据库地址
     */
    String dbUrl = "jdbc:mysql://localhost:3306/world";
    String userName = "root";
    String pw = "root";

    /**
     * 是否强制带上注解
     */
    boolean enableTableFieldAnnotation = true;
    /**
     * 是否去掉生成实体的属性名前缀
     */
    String[] fieldPrefix = new String[]{""};

    private void generateByTablesWithInjectConfig(String authorName, String... tableNames) {
        File file = new File("");
        String path = file.getAbsolutePath();
        // 全局配置
        GlobalConfig config = new GlobalConfig();
        // 开启 activeRecord 模式
        config.setActiveRecord(true)
                // 为true时，生成的实体类@ApiModel的description 属性换行，导致报错，暂为false
                .setSwagger2(false)
                //生成目录
                .setOutputDir(path + "/src/main/java")
                //生成人
                .setAuthor(authorName)
                // 是否覆盖文件
                .setFileOverride(true)
                // XML ResultMap
                .setBaseResultMap(true)
                // XML columList
                .setBaseColumnList(true)
                .setOpen(false)
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                .setMapperName("%sBizMapper")
                .setXmlName("%sBizMapper")
                .setServiceName("%sServiceBiz")
                .setServiceImplName("%sServiceBizImpl");

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername(userName)
                .setPassword(pw)
                .setDriverName("com.mysql.jdbc.Driver")
                .setTypeConvert(new CustomMySqlTypeConvert());

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setLogicDeleteFieldName("active")
                .setCapitalMode(true)
                .setEntityLombokModel(true)
                .setEntityColumnConstant(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .entityTableFieldAnnotationEnable(enableTableFieldAnnotation)
                .setTablePrefix(fieldPrefix)
                //修改替换成你需要的表名，多个表名传数组
                .setInclude(tableNames);

        // 包配置
        //todo 修改包目录
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.shaolin.springcloud")
                .setEntity("dal.entity")
                .setMapper("dal.mapper")
                .setService("dal.biz")
                .setServiceImpl("dal.biz.impl")
                .setXml("dal.mapper");
        //.setController("controller");

        //模板配置
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController(null);
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplate(templateConfig)
                .execute();
    }

    static class CustomMySqlTypeConvert extends MySqlTypeConvert {
        @Override
        public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
            String t = fieldType.toLowerCase();
            if (t.contains("char")) {
                return DbColumnType.STRING;
            } else if (t.contains("bigint")) {
                return DbColumnType.LONG;
            } else if (t.contains("tinyint(1)")) {
                return DbColumnType.INTEGER;
            } else if (t.contains("int")) {
                return DbColumnType.INTEGER;
            } else if (t.contains("text")) {
                return DbColumnType.STRING;
            } else if (t.contains("bit")) {
                return DbColumnType.INTEGER;
            } else if (t.contains("decimal")) {
                return DbColumnType.BIG_DECIMAL;
            } else if (t.contains("clob")) {
                return DbColumnType.CLOB;
            } else if (t.contains("blob")) {
                return DbColumnType.BLOB;
            } else if (t.contains("binary")) {
                return DbColumnType.BYTE_ARRAY;
            } else if (t.contains("float")) {
                return DbColumnType.FLOAT;
            } else if (t.contains("double")) {
                return DbColumnType.DOUBLE;
            } else if (t.contains("json") || t.contains("enum")) {
                return DbColumnType.STRING;
            } else if (t.contains("date") || t.contains("time") || t.contains("year")) {
                switch (globalConfig.getDateType()) {
                    case ONLY_DATE:
                        return DbColumnType.DATE;
                    case SQL_PACK:
                        switch (t) {
                            case "date":
                                return DbColumnType.DATE_SQL;
                            case "time":
                                return DbColumnType.TIME;
                            case "year":
                                return DbColumnType.DATE_SQL;
                            default:
                                return DbColumnType.TIMESTAMP;
                        }
                    case TIME_PACK:
                        switch (t) {
                            case "date":
                                return DbColumnType.DATE;
                            case "time":
                                return DbColumnType.DATE;
                            case "year":
                                return DbColumnType.YEAR;
                            default:
                                return DbColumnType.DATE;
                        }
                    default:
                        return null;
                }
            }
            return DbColumnType.STRING;
        }
    }

    @Test
    public void generateCodeWithInjectConfig() {
        generateByTablesWithInjectConfig("leisl",
                "user");
    }
}
