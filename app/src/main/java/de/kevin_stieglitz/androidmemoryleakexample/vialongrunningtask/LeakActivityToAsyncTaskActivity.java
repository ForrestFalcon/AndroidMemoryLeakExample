package de.kevin_stieglitz.androidmemoryleakexample.vialongrunningtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;

import de.kevin_stieglitz.androidmemoryleakexample.R;

public class LeakActivityToAsyncTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_to_async_task);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                while (true) {
                    SystemClock.sleep(5_000);
                }
            }
        }.execute();
    }
}
