//package com.hz;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//
///**
// * @author saber
// */
//public class CodeGenerator {
//    /**
//     * 反向生成工具
//     *
//     * @param args
//     */
//    public static void main(String[] args) {
//        test_mysql();
////        test_ora();
//    }
//
//    public static void test_mysql() {
//        //创建AutoGenerator对象
//        AutoGenerator mpg = new AutoGenerator();
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        //设置输出的路径 项目的绝对路径地址
//        gc.setOutputDir("我的mysql项目");
//        //设置作者
//        gc.setAuthor("saber");
//        gc.setOpen(false);
//        //生成列
//        gc.setBaseColumnList(true);
//        //生成result map集合
//        gc.setBaseResultMap(true);
//        // gc.setSwagger2(true); 实体属性 Swagger2 注解
//        mpg.setGlobalConfig(gc);
//
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        //连接的url地址
//        dsc.setUrl("jdbc:mysql://192.168.101.152:3306/testabc?useUnicode=true&characterEncoding=utf-8&useSSL=false");
//        // dsc.setSchemaName("public");
//        //设置驱动的名称
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        //设置mysql的用户名
//        dsc.setUsername("root");
//        //设置mysql的密码
//        dsc.setPassword("swsk@swsk123456");
//        //设置自动生成器的数据源
//        mpg.setDataSource(dsc);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        // pc.setModuleName(scanner("模块名"));
//        //设置包名
//        //        pc.setParent("");
//        //设置自动生成器的包
//        mpg.setPackageInfo(pc);
//
//        //生成策略的配置
//        StrategyConfig strategyConfig = new StrategyConfig();
////        strategyConfig.setTablePrefix("dict_", "hotel_");
//
//        //生成指定表
////        strategyConfig.setInclude("equipment", "equipment_accident", "equipment_check", "equipment_danger", "equipment_rectificat", "m_task", "s_users", "company");
////        strategyConfig.setInclude("t_user", "t_dep");
//        //可变参数用数组，最好再模板里把它注释掉
//        //        strategyConfig.setTablePrefix(new String[]{""});
//
//        //驼峰命名
//        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
//        //字段驼峰命名
//        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
//        //设置实体Bean的lombok
//        strategyConfig.setEntityLombokModel(true);
//        //设置生成策略
//        mpg.setStrategy(strategyConfig);
//
//        //执行自动生成器
//        mpg.execute();
//    }
//
//    public static void test_myTest() {
//        //创建AutoGenerator对象
//        AutoGenerator mpg = new AutoGenerator();
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        //设置输出的路径 项目的绝对路径地址
//        gc.setOutputDir("D:\\project\\java\\company\\swsk\\hotelManageService\\src\\main\\java");
//        //设置作者
//        gc.setAuthor("saber");
//        gc.setOpen(false);
//        //生成列
//        gc.setBaseColumnList(true);
//        //生成result map集合
//        gc.setBaseResultMap(true);
//        // gc.setSwagger2(true); 实体属性 Swagger2 注解
//        mpg.setGlobalConfig(gc);
//
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        //连接的url地址
//        dsc.setUrl("jdbc:mysql://192.168.79.150:3306/rgyj?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");
//        // dsc.setSchemaName("public");
//        //设置驱动的名称
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        //设置mysql的用户名
//        dsc.setUsername("root");
//        //设置mysql的密码
//        dsc.setPassword("root");
//        //设置自动生成器的数据源
//        mpg.setDataSource(dsc);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        // pc.setModuleName(scanner("模块名"));
//        //设置包名
//        //        pc.setParent("");
//        //设置自动生成器的包
//        mpg.setPackageInfo(pc);
//
//
//        //生成策略的配置
//        StrategyConfig strategyConfig = new StrategyConfig();
//        //生成指定表
//        strategyConfig.setInclude("equipment", "equipment_accident", "equipment_check", "equipment_danger", "equipment_rectificat", "m_task", "s_users", "company");
//        //可变参数用数组，最好再模板里把它注释掉
//        //        strategyConfig.setTablePrefix(new String[]{""});
//        //驼峰命名
//        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
//        //字段驼峰命名
//        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
//        //设置实体Bean的lombok
//        strategyConfig.setEntityLombokModel(true);
//        //设置生成策略
//        mpg.setStrategy(strategyConfig);
//
//        //执行自动生成器
//        mpg.execute();
//    }
//
//
//    public static void test_ora() {
//        // 1.创建代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 2.全局配置
//        GlobalConfig gc = new GlobalConfig();
//        gc.setOutputDir("我的oracle项目");
//        gc.setAuthor("saber");
//        gc.setOpen(false); //生成后是否打开资源管理器
//        gc.setFileOverride(false); //重新生成时文件是否覆盖
//        /**
//         * mp生成service层代码，默认接口名称第一个字母有 I
//         *
//         */
//        gc.setServiceName("%sService");//去掉Service接口的首字母I
//        gc.setIdType(IdType.AUTO);//主键策略,IdType.AUTO对应的策略为主键自增
//        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
////        gc.setSwagger2(true); // 实体属性 Swagger2 注解
//        mpg.setGlobalConfig(gc);
//
//        //3. 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setDbType(DbType.ORACLE);
//        //连接的url地址
//        dsc.setUrl("jdbc:oracle:thin:@58.215.228.138:10035:orcl");
//        // dsc.setSchemaName("public");
//        //设置驱动的名称
//        dsc.setDriverName("oracle.jdbc.OracleDriver");
//        //设置mysql的用户名
//        dsc.setUsername("jygisdata1");
//        //设置mysql的密码
//        dsc.setPassword("jygisdata1");
//        mpg.setDataSource(dsc);
//
//        // 4.包配置
//        PackageConfig pc = new PackageConfig();
////        pc.setModuleName("XXXX");
////        pc.setParent("com.XXXX");
////        pc.setController("controller");
////        pc.setEntity("entity");
////        pc.setService("service");
////        pc.setMapper("mapper");
//        mpg.setPackageInfo(pc);
//
//        // 5.策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setInclude("DEPINFO", "USERDEP", "USERINFO"); // 表名字，注意一定要大写！大写！否则识别不出来！
//        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
//        strategy.setTablePrefix(pc.getModuleName() + "_"); //生成实体时去掉表前缀
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        ;//数据库表字段映射到实体的命名策略
//        strategy.setEntityLombokModel(true);// lombok 模型 @Accessors(chain true) setter链式操作
//        strategy.setRestControllerStyle(true); //restful api风格控制器
//        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符
//
//        mpg.setStrategy(strategy);
//        mpg.execute();
//    }
//}