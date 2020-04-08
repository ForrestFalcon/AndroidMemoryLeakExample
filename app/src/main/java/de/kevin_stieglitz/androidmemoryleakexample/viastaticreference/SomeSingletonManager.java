package de.kevin_stieglitz.androidmemoryleakexample.viastaticreference;

import android.content.Context;

public class SomeSingletonManager {

    private static SomeSingletonManager someSingletonManagerSingleton;
    private Context context;

    private SomeSingletonManager(Context context) {
        this.context = context;
    }

    public static synchronized SomeSingletonManager getInstance(Context context) {
        if (someSingletonManagerSingleton == null) {
            someSingletonManagerSingleton = new SomeSingletonManager(context);
        }
        return someSingletonManagerSingleton;
    }

    public void unregister(Context context) {
        if (this.context == context) {
            this.context = null;
        }
    }
}
