package jason.springframework.jasonblog.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisGenerator {
    public static void main(String[] args)throws Exception{
        String today = "2022-12-7";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = sdf.parse(today);
        Date d = new Date();

        if(d.getTime() > now.getTime() + 1000 * 60 * 60 *24){
            System.err.println("----fail to run----");
            System.err.println("----fail to run----");
            System.err.println("This programme can destroy the world, it should be used once only, " +
                    "if it has to be run again, you need to change the date to today");
            return;
        }
        if(false) return;
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        InputStream is = MybatisGenerator.class.getClassLoader().getResource("generatorConfig.xml").openStream();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,callback,warnings);
        myBatisGenerator.generate(null);
        System.out.println("run successfully, it can only run once, otherwise it will change mapper,pojo,xml,etc");
    }
}
