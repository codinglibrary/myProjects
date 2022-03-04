/**
 * Copyright (c) qingjiu.life
 */
package life.personal.example;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

/**
 * This is a main test class ,which is used to examine the function of orther class
 * @author David
 * @since 2022/03/04 15:07
 */
public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        idGeneratorTest();
    }

    /**
     * @since 2022/03/04 15:20
     */
    private static boolean idGeneratorTest(){
        logger.debug("Run idGeneratorTest==========");
        int count=1;
        while(true){
            try {
                Thread.sleep(1000);

                System.out.printf("count:%s,id:%s \n",count,IdGenerator.getInstance().getId());
                if(count++ >100 ) {
                    return true;
                }
            } catch (InterruptedException e) {
                logger.debug("Something happened.");
                e.printStackTrace();
                return false;
            }
        }
    }
}
