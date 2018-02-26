package lyd.github.livro.base.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StatusBarUtil {
    @TargetApi(19)
    public static void setStatusBarColor(Context context, int resourceId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ((Activity) context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarManager tintManager = new SystemBarManager(((Activity) context));
            setTranslucentStatus(context, true);
            tintManager.setStatusBarTintResource(resourceId);
            tintManager.setStatusBarTintEnabled(true);
            StatusBarUtil.setMiuiStatusBarDarkMode(((Activity) context), false);
            StatusBarUtil.setMeizuStatusBarDarkMode(((Activity) context), false);
        }
    }

    @TargetApi(19)
    public static void setStatusBarColorDrawable(Context context, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ((Activity) context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarManager tintManager = new SystemBarManager(((Activity) context));
            setTranslucentStatus(context, true);
            tintManager.setTintDrawable(drawable);
            tintManager.setStatusBarTintEnabled(true);
            StatusBarUtil.setMiuiStatusBarDarkMode(((Activity) context), false);
            StatusBarUtil.setMeizuStatusBarDarkMode(((Activity) context), false);
            StatusBarUtil.setMarshmallowStatusBarDarkMode(((Activity) context), false);
        }
    }

    private static boolean setMiuiStatusBarDarkMode(Activity activity, boolean dark) {
        Class<? extends Window> clazz = activity.getWindow().getClass();
        try {
            int darkModeFlag = 0;
            Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            extraFlagField.invoke(activity.getWindow(), dark ? darkModeFlag : 0, darkModeFlag);
            return true;
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return false;
    }

    private static boolean setMeizuStatusBarDarkMode(Activity activity, boolean dark) {
        boolean result = false;
        if (activity != null) {
            try {
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                activity.getWindow().setAttributes(lp);
                result = true;
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
        return result;
    }

    private static boolean setMarshmallowStatusBarDarkMode(Activity activity, boolean dark) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (activity != null) {
                try {
                    View decor = activity.getWindow().getDecorView();
                    int ui = decor.getSystemUiVisibility();
                    if (dark) {
                        ui |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                    } else {
                        ui &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                    }
                    decor.setSystemUiVisibility(ui);
                } catch (Exception e) {
//                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public static void setTranslucentStatus(Context context, boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = ((Activity) context).getWindow();
            WindowManager.LayoutParams winParams = window.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            window.setAttributes(winParams);
        }
    }

    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        Resources res = context.getResources();
        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = res.getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }
}
