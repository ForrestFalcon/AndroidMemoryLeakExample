package de.kevin_stieglitz.androidmemoryleakexample.vialongrunningtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;

import de.kevin_stieglitz.androidmemoryleakexample.R;

public class LeakActivityToThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_to_thread);

        new MyThread().start();
    }

    // FIXME: non-static anonymous classes hold an implicit reference to their enclosing class.
    // Fix is to make it static. Also, close thread in activity onDestroy() to avoid thread leak. See `LeakThreadsActivity`
    private class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                SystemClock.sleep(5_000);
            }
        }
    }
}
