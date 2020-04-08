package de.kevin_stieglitz.androidmemoryleakexample.viastaticreference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import de.kevin_stieglitz.androidmemoryleakexample.R;

public class LeakActivityToStaticViewActivity extends AppCompatActivity {

    // static view will leak the activity. To fix it, make it non-static
    static TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        label = new TextView(this);
        label.setText(getString(R.string.leak_explanation_static_view, getString(R.string.instruction_check_for_leaks)));

        setContentView(label);
    }
}
