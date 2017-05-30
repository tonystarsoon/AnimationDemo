package it.com.drawableanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * 帧动画的例子
 * 1.在drawable文件夹下面定义一个xml；根节点为：animation-list
 * 2.里面的子节点分别定义drawable和duration
 * 3.将R.drawable.arawable_animation_demo设置为背景
 * 4.获取背景转为AnimationDrawable，调用start()方法
 *
 */
public class MainActivity extends AppCompatActivity {
    private AnimationDrawable mAnimationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView ivDemo = (ImageView) findViewById(R.id.ivDemo);
        ivDemo.setBackgroundResource(R.drawable.arawable_animation_demo);
        mAnimationDrawable = (AnimationDrawable) ivDemo.getBackground();
    }

    public void start(View view){
        mAnimationDrawable.start();
    }
}

