package mobile.app.handlerexample2;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;


//In java we cannot start the thread multiple times.
public class LooperThread extends Thread{
    private static final String TAG = "Looper thread.";

    //By default, a handler is associated with a thread that is instantiate on.
    //public Handler handler;
    public Handler handler;
    public Looper mLooper;

    @Override
    public void run() {
        //Prepare the looper of the handler.
        Looper.prepare();

        //This returns the looper of the current thread.
        mLooper = Looper.myLooper();

        //Instantiate the handler object.
        handler = new ExampleHandler();

        //Start the looper which an infinite loop.
        Looper.loop();
        Log.d(TAG, "End of the Run().");

    }
}
