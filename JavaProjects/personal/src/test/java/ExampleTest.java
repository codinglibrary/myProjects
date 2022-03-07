/**
 * Copyright (c) qingjiu.life
 */

import example.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @author QingJiu
 * @since 2022/03/04 17:45
 */
public class ExampleTest {
    private static final Logger logger = LogManager.getLogger(ExampleTest.class);

    @Test
    public void idGeneratorTest(){
        int count=1;
        long id;
        while (true){
            logger.info(IdGenerator.getInstance().getId());
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
