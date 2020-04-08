package de.kevin_stieglitz.androidmemoryleakexample.viastaticreference;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import de.kevin_stieglitz.androidmemoryleakexample.R;

public class LeakActivityToStaticVariableActivity extends AppCompatActivity {

    // To fix it, set it null onDestroy or use weak reference
    static Activity activity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_to_static_variable);

        if (activity == null) {
            activity = this;
        }
    }
}
