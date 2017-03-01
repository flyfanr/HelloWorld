package com.flyfanr.helloworld;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by liuziyu on 16/8/1.
 */
public class Hello {

    public static String PERMISSION_SAY_HELLO = "com.flyfanr.helloworld.permission.SAY_HELLO";

    public static void sayHello(Context context) {

        int checkResult = context.checkCallingOrSelfPermission(PERMISSION_SAY_HELLO);

        if (checkResult != PackageManager.PERMISSION_GRANTED) {
            throw new SecurityException("执行sayHello方法需要有com.flyfanr.helloworld.permission.SAY_HELLO权限");
        }

        System.out.println("Hello flyfanr");

    }
}
