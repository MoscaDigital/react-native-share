package cl.json.social;

import android.content.ActivityNotFoundException;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

/**
 * Created by disenodosbbcl on 23-07-16.
 */
public class TwitterShare extends SingleShareIntent {

    private static final String PACKAGE = "com.twitter.android";
    private static final String DEFAULT_WEB_LINK = "https://twitter.com/intent/tweet?text={message}&url={url}";

    public TwitterShare(ReactApplicationContext reactContext) {
        super(reactContext);
    }
    @Override
    public void open(ReadableMap options) throws ActivityNotFoundException {
        super.open(options);
        if(super.options !=null){
            //  extra params here
            this.openIntentChooser();
        }else {
            Toast.makeText(reactContext, "App não instalada", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected String getPackage() {
        return PACKAGE;
    }

    @Override
    protected String getDefaultWebLink() {
        return DEFAULT_WEB_LINK;
    }

    @Override
    protected String getPlayStoreLink() {
        return null;
    }
}
