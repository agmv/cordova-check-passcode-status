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
        	
        	if( doesDeviceHaveSecuritySetup( this.cordova.getActivity() ) ){
        		String message = "true";
                callbackContext.success(message);
        	}else{
        		String message = "false";
                callbackContext.success(message);
        	}
                        
            return true;
        }
        return false;
    }
    
    /**
     * <p>Checks to see if the lock screen is set up with either a PIN / PASS / PATTERN</p>
     *
     * <p>For Api 16+</p>
     *
     * @return true if PIN, PASS or PATTERN set, false otherwise.
     */
    public static boolean doesDeviceHaveSecuritySetup(Context context)
    {
        return isPatternSet(context) || isPassOrPinSet(context);
    }

    /**
     * @param context
     * @return true if pattern set, false if not (or if an issue when checking)
     */
    private static boolean isPatternSet(Context context)
    {
        ContentResolver cr = context.getContentResolver();
        try
        {
            int lockPatternEnable = Settings.Secure.getInt(cr, Settings.Secure.LOCK_PATTERN_ENABLED);
            return lockPatternEnable == 1;
        }
        catch (Settings.SettingNotFoundException e)
        {
            
            return false;
        }
    }

    /**
     * @param context
     * @return true if pass or pin set
     */
    @SuppressLint("NewApi") private static boolean isPassOrPinSet(Context context)
    {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE); //api 16+
        return keyguardManager.isKeyguardSecure();
    }
}
