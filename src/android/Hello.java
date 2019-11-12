package com.example.hello;

// The native Toast API
import android.widget.Toast;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class Hello extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }else
        if (action.equals("show")) {
            // https://www.outsystems.com/blog/posts/how-to-create-a-cordova-plugin-from-scratch/
            String message;
            String duration;
            try {
                JSONObject options = args.getJSONObject(0);
                message = options.getString("message");
                duration = options.getString("duration");
            } catch (JSONException e) {
                callbackContext.error("Error encountered: " + e.getMessage());
                return false;
            }
            // Create the toast
            Toast toast = Toast.makeText(cordova.getActivity(), message, Toast.LENGTH_LONG);
            // Display toast
            toast.show();
            // Send a positive result to the callbackContext
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
            callbackContext.sendPluginResult(pluginResult);
            return true;
        }
        
        callbackContext.error("\"" + action + "\" is not a recognized action.");
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
