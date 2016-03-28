import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.se7entina.xueshengshuo.util.AppUtil;
import com.se7entina.xueshengshuo.widgets.LogCat;

import java.util.LinkedList;
import java.util.List;

/**
 * Class:
 * Created by se7enTina on 2016/3/26.
 * Description: APP声明周期管理类
 */
public class App extends Application {

    private static final String TAG = "APP";
    public static String BASE_SETTING_KEY = TAG;
    private static Boolean isFirstStart = false;
    private static Context sContext;
    public static final String KEY_VERSION = "version";
    private List<Activity> activityList = new LinkedList<>();
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        initImageLoader(getApplicationContext());
    }

    public static App getInstance() {
        if (null == instance) {
            instance = new App();
        }
        return instance;
    }

    // 初始化ImageLoader
    public static void initImageLoader(Context context) {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024)).discCacheSize(10 * 1024 * 1024)
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .build();
        ImageLoader.getInstance().init(config);
    }

    /**
     * 判断此版本是否第一次登录
     */
    public boolean initFirstSetting() {
        SharedPreferences sharedPreferences = getSharedPreferences(BASE_SETTING_KEY, Context.MODE_PRIVATE);
        int oldVersion = sharedPreferences.getInt(KEY_VERSION, -1);
        int version = AppUtil.getMyVersionCode(sContext);
        LogCat.i("version :" + version);
        if (version != oldVersion) {
            isFirstStart = false;
            sharedPreferences.edit().putInt(KEY_VERSION, version).apply();
        } else {
            isFirstStart = true;
        }
        return isFirstStart;
    }

    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        System.exit(0);
    }

    public boolean isFirstStart() {
        return isFirstStart;
    }

    public void setFirstStart(boolean isFirstStart) {
        this.isFirstStart = isFirstStart;
    }

}
