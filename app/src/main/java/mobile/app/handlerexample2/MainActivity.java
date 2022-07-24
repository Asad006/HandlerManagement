package mobile.app.handlerexample2;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Task B: ";
    private static final int TASK_A = 1;
    private static final int TASK_B = 2;
    private LooperThread looperThread = new LooperThread();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startThread(View view) {

        // the app crashes because we tried to start the same thread again.
        looperThread.start();
    }

    public void stopThread(View view) {
        looperThread.mLooper.quit();
    }

    public void taskA(View view) {
        /*looperThread.handler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    Log.d(TAG, "run:"+i);
                }
            }
        });*/

        Message message = Message.obtain();
        message.what =TASK_A;
        looperThread.handler.sendMessage(message);
    }

    public void taskB(View view) {
        Message message = Message.obtain();
        message.what =TASK_B;
        looperThread.handler.sendMessage(message);
    }
}