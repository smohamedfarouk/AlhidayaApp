package vandy.mooc.service;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by Admin on 06/12/2015.
 */
public class BroadcastService extends IntentService{
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public BroadcastService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
