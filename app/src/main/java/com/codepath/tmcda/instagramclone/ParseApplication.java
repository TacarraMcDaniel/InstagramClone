package com.codepath.tmcda.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;


public class ParseApplication extends Application {
     @Override
     public void onCreate() {
         super.onCreate();
         ParseObject.registerSubclass(Post.class);
         Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);



         Parse.initialize(new Parse.Configuration.Builder(this)
                 .applicationId("B0anQfOLkRJk38Q0bAjnRtaYWxek0RwsDkAw6vpG")
                 .clientKey("LaOBJnG0agM0Dxz76gsLXCjTxGwIzjI8AGzhF6BM")
                 .server("https://parseapi.back4app.com")
                 .build()
         );
     }
 }
