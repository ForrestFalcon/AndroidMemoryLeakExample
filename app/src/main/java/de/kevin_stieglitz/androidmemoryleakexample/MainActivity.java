package de.kevin_stieglitz.androidmemoryleakexample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import de.kevin_stieglitz.androidmemoryleakexample.databinding.ActivityMainBinding;
import de.kevin_stieglitz.androidmemoryleakexample.vialongrunningtask.LeakActivityToAsyncTaskActivity;
import de.kevin_stieglitz.androidmemoryleakexample.vialongrunningtask.LeakActivityToHandlerActivity;
import de.kevin_stieglitz.androidmemoryleakexample.vialongrunningtask.LeakActivityToThreadActivity;
import de.kevin_stieglitz.androidmemoryleakexample.vialongrunningtask.LeakThreadsActivity;
import de.kevin_stieglitz.androidmemoryleakexample.viastaticreference.LeakActivityToSingletonActivity;
import de.kevin_stieglitz.androidmemoryleakexample.viastaticreference.LeakActivityToStaticInnerClassActivity;
import de.kevin_stieglitz.androidmemoryleakexample.viastaticreference.LeakActivityToStaticVariableActivity;
import de.kevin_stieglitz.androidmemoryleakexample.viastaticreference.LeakActivityToStaticViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
        }

        binding.buttonLeakActivityToSingleton.setOnClickListener(new StartIntentClickListener(LeakActivityToSingletonActivity.class));
        binding.buttonLeakActivityToStaticVariableToInnerClass.setOnClickListener(new StartIntentClickListener(LeakActivityToStaticInnerClassActivity.class));
        binding.buttonLeakActivityStaticVariable.setOnClickListener(new StartIntentClickListener(LeakActivityToStaticVariableActivity.class));
        binding.buttonLeakActivityStaticView.setOnClickListener(new StartIntentClickListener(LeakActivityToStaticViewActivity.class));

        binding.buttonLeakActivityToAsyncTask.setOnClickListener(new StartIntentClickListener(LeakActivityToAsyncTaskActivity.class));
        binding.buttonLeakActivityToHandler.setOnClickListener(new StartIntentClickListener(LeakActivityToHandlerActivity.class));
        binding.buttonLeakActivityToThread.setOnClickListener(new StartIntentClickListener(LeakActivityToThreadActivity.class));
        binding.buttonLeakThread.setOnClickListener(new StartIntentClickListener(LeakThreadsActivity.class));

        setContentView(binding.getRoot());
    }

    class StartIntentClickListener implements View.OnClickListener {

        private Class<?> cls;

        StartIntentClickListener(Class<?> cls) {
            this.cls = cls;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), cls);
            startActivity(intent);
        }
    }
}
