package de.kevin_stieglitz.androidmemoryleakexample.viastaticreference;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import de.kevin_stieglitz.androidmemoryleakexample.R;

public class LeakActivityToSingletonActivity extends AppCompatActivity {

    SomeSingletonManager someSingletonManager = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_to_singleton);
        // FIXME: fix option 1: instead of passing `this` to getInstance(), pass getApplicationContext()
        someSingletonManager = SomeSingletonManager.getInstance(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("FRANK", "onDestroy: called");
        // FIXME: fix option 2: uncomment the following line to fix the leak
        //someSingletonManager.unregister(this);
    }
}
