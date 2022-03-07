/**
 * Copyright (c) qingjiu.life
 */

import example.IdGenerator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author QingJiu
 * @since 2022/03/04 17:45
 */
public class ExampleTest {
    private static final Logger logger = LoggerFactory.getLogger(ExampleTest.class);

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
}
