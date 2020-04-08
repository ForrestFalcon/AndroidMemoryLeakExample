package de.kevin_stieglitz.androidmemoryleakexample.vialongrunningtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;

import de.kevin_stieglitz.androidmemoryleakexample.R;

public class LeakThreadsActivity extends AppCompatActivity {
    private LeakedThread mThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_threads);

        mThread = new LeakedThread();
        mThread.start();
    }

    private static class LeakedThread extends Thread {
        private boolean mRunning = false;

        @Override
        public void run() {
            mRunning = true;
            while (mRunning) {
                SystemClock.sleep(5_000);
            }
        }

        public void close() {
            mRunning = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // uncomment the line to fix the thread leak
        //mThread.close();
    }
}
