/**
 * Copyright (c) qingjiu.life
 */

import example.IdGenerator;
import example.objects.*;
import example.factory.HumanFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author QingJiu
 * @since 2022/03/04 17:45
 */
public class ExampleTest {
    private static final Logger logger = LoggerFactory.getLogger(ExampleTest.class);

    //单例模式测试
    @Test
    public void idGeneratorTest(){
        int count=1;
        long id;
        while (true){
            logger.info(String.valueOf(IdGenerator.getInstance().getId()));
            if(++count>5){
                logger.debug("Over.");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("Something wrong.");
                e.printStackTrace();
                return;
            }
        }
    }

    //工厂模式测试
    @Test
    public void humanFactoryTest(){
        logger.debug("Test HumanFactory");
        HumanFactory.getHuman(WhiteHuman.class).printColor();
        HumanFactory.getHuman(BlackHuman.class).printColor();
        HumanFactory.getHuman(YellowHuman.class).printColor();
    }

    //建造者模式测试
    @Test
    public void builderResourcePoolTest(){
        // 这段代码会抛出IllegalArgumentException，因为minIdle>maxIdle
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setName("dbConnectionPool")
                .setMaxTotal(16)
                .setMaxIdle(10)
                .setMinIdle(4)
                .build();
        logger.info(String.valueOf(config.getMaxIdle())+", "+String.valueOf(config.getMaxIdle()));
    }

    //原型模式测试
    @Test
    public void hashCloneTest() throws IOException, ClassNotFoundException {
        HashMap<String,Human> hashMap = new HashMap<>();
        hashMap.put("01",HumanFactory.getHuman(WhiteHuman.class));
        hashMap.put("02",HumanFactory.getHuman(YellowHuman.class));
        hashMap.put("03",HumanFactory.getHuman(BlackHuman.class));

        //浅拷贝
        HashMap<String, Human> map1 = (HashMap<String, Human>) hashMap.clone();
        logger.debug("OK!");

        //深拷贝-方法1：递归拷贝直至基本数据类型
        HashMap<String,Human> map2 = new HashMap<>();
        for(Map.Entry<String,Human> entry : hashMap.entrySet()){
            Human human = HumanFactory.getHuman(entry.getValue().getClass());
            map2.put(entry.getKey(),human);
        }
        logger.debug("OK!");

        //深拷贝-方法2：序列化操作方法(必须是可序列化的对象)
        HashMap<String,Human> map3 = new HashMap<>();
        map3= (HashMap<String, Human>) deepCopy(hashMap);
        logger.debug("OK!");

    }

    private Object deepCopy(Object object) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(object);

        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);

        return oi.readObject();
    }
}
