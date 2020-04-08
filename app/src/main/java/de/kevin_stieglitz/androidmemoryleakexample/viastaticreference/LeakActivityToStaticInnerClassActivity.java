package de.kevin_stieglitz.androidmemoryleakexample.viastaticreference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import de.kevin_stieglitz.androidmemoryleakexample.R;

public class LeakActivityToStaticInnerClassActivity extends AppCompatActivity {

    private static SomeInnerClass someInnerClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_to_static_inner_class);

        if (someInnerClass == null) {
            someInnerClass = new SomeInnerClass();
        }
    }

    class SomeInnerClass {
    }
}
