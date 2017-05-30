package it.com.animationdemo;

import android.animation.TimeInterpolator;

/**
 * Created by tony on 2017/4/28.
 */
public class MyInterploator implements TimeInterpolator {
    /**
     * @param input  系统计算后传进来的是一个目标值距离的比例.比例
     *               我们可以通过对input进行计算后返回一个我们想要的值,这要就可以控制fraction的值,
     *               从而达到控制运动轨迹或者或者运动速率的目的
     * @return       返回值就是TypeEvaluator中的fraction
     */
    @Override
    public float getInterpolation(float input) {
//        return 4 * input * (input - 1) + 1;
        System.out.println("------------input:" + input);
        return -4 * input * (input - 1);
    }
}
