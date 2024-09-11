package com.dk.mallchat.common;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class MPGenerator {
    public static void main(String[] args) {
        //����������
        AutoGenerator autoGenerator = new AutoGenerator();

        //����Դ����
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);//ָ�����ݿ�����
        //---------------------------����Դ-----------------------------------
        assembleDev(dataSourceConfig);//��������Դ
        autoGenerator.setDataSource(dataSourceConfig);

        //ȫ������
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOpen(false);
        //todo Ҫ�����·��
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/mallchat-chat-server/src/main/java");
        //������������
        globalConfig.setAuthor("<a href=\"https://github.com/zongzibinbin\">abin</a>");
        //ȥ��service��Iǰ׺,һ��ֻ��Ҫ����service����
        globalConfig.setServiceImplName("%sDao");
        autoGenerator.setGlobalConfig(globalConfig);

        //������
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.dk.mallchat.common.user");//�Զ������·��
        packageConfig.setEntity("domain.entity");
        packageConfig.setMapper("mapper");
        packageConfig.setController("controller");
        packageConfig.setServiceImpl("dao");
        autoGenerator.setPackageInfo(packageConfig);

        //��������
        StrategyConfig strategyConfig = new StrategyConfig();
        //�Ƿ�ʹ��Lombok
        strategyConfig.setEntityLombokModel(true);
        //�����е���������ʹ���շ����
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
//        strategyConfig.setTablePrefix("t_");
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //�ֶκͱ�ע��
        strategyConfig.setEntityTableFieldAnnotationEnable(true);
        //todo �����޸���Ҫ�Զ����ɵı�ṹ
        strategyConfig.setInclude(
                "user"
        );
        //�Զ�����ֶ�,����Ŀ����������,���紴��ʱ�䣬�޸�ʱ��,ÿ�Σ�����Ҫ������ָ����̫�鷳��,����Ϊ�Զ������򣬾Ͳ���Ҫ���Ǹ�ֵ��
        List<TableFill> list = new ArrayList<TableFill>();
        TableFill tableFill1 = new TableFill("create_time", FieldFill.INSERT);
        TableFill tableFill2 = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        list.add(tableFill1);
        list.add(tableFill2);

//        strategyConfig.setTableFillList(list);
        autoGenerator.setStrategy(strategyConfig);

        //ִ��
        autoGenerator.execute();

    }
    //todo �����޸��������Դ
    public static void assembleDev(DataSourceConfig dataSourceConfig) {
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("Xinmimaqwe123");
        dataSourceConfig.setUrl("jdbc:mysql://1.92.158.246:3306/mallchat?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC");
    }
}