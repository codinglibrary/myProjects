/**
 * Copyright (c) qingjiu.life
 */

import example.IdGenerator;
import org.apache.log4j.Logger;

/**
 * @author QingJiu
 * @since 2022/03/04 17:45
 */
public class ExampleTest {
    private static final Logger logger = Logger.getLogger(ExampleTest.class);
    public void idGeneratorTest(){
        int count=1;
        long id;
        while (true){
            logger.debug(IdGenerator.getInstance().getId());
            if(++count>100){
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
