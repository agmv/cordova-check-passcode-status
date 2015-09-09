

使用方法

cordova.plugins.checkPasscode.checkPasscode(function(d){alert(d)})

返回的值为

true [string]  已开启passcode
false [string]  关闭了 passcode
Unknown [string]  无法检测是否开启了 passcode

java source code
https://gist.github.com/doridori/54c32c66ef4f4e34300f

ios source code
https://github.com/liamnichols/UIDevice-PasscodeStatus


```java
package net.qdkf.checkPasscode;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;




/**
 * This class echoes a string called from JavaScript.
 */
public class checkPasscode extends CordovaPlugin {

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
            throws JSONException {
        if (action.equals("checkPasscodeStatus")) {
        	
        	//if( doesDeviceHaveSecuritySetup( this.cordova.getActivity() ) ){
        		//String message = "true";
        	int message = LockType.getCurrent(this.cordova.getActivity().getContentResolver());
                callbackContext.success(message);
//        	}else{
//        		String message = "false";
//                callbackContext.success(message);
//        	}
                       
        	
            return true;
        }
        return false;
    }

    
   
    
}
```