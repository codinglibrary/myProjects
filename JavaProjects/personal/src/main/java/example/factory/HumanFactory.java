/**
 * Copyright (c) qingjiu.life
 */
package example.factory;

import example.objects.Human;

/**
 * @author David
 * @since 2022/03/07 11:50
 */
public class HumanFactory {
    public static <T extends Human> T getHuman(Class<T> tClass){
        Human human = null;
        try {
            human = (Human)Class.forName(tClass.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)human;
    }
}
