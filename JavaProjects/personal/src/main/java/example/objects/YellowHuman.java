/**
 * Copyright (c) qingjiu.life
 */
package example.objects;

import example.objects.Human;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 黄人
 *
 * @author David
 * @since 2022/03/07 11:37
 */
public class YellowHuman extends Human {
    private final String color = "yellow";
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getColor() {
        return color;
    }


    @Override
    public void printColor() {
        logger.info(getColor());
    }

    @Override
    public int count() {
        return 100;
    }
}
