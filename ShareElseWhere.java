import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.util.Log;

import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;

public class ShareElseWhere extends Plugin {

	@Override
	public PluginResult execute(String action, JSONArray args, String callbackId) {
		try {

			JSONObject jo = args.getJSONObject(0);
			final String subject = jo.getString("subject");
			final String text = jo.getString("text");

			final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
			intent.putExtra(android.content.Intent.EXTRA_TEXT, text);

			this.ctx.runOnUiThread(new Runnable()
			{
				public void run()
				{
					final ResolveInfo[] eligibleActivities = getEligibleActivities(intent);
					final CharSequence[] names = getEligibleNames(eligibleActivities);

					AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                    builder.setTitle("Share page using:");

					builder.setItems(names, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int name) {
							shareWithResolveInfo(eligibleActivities[name], intent);
						}
					});

					AlertDialog alert = builder.create();
					alert.show();
				}
			}); // close runOnUiThread anonymous class

			return new PluginResult(PluginResult.Status.OK);

		} //  close try
		catch (JSONException e) {
			return new PluginResult(PluginResult.Status.JSON_EXCEPTION);
		}
	} // execute()



	/*
	 * Initiates the share intent by creating a new one with the resInfo's activity as the 
	 * target activity.
	 */
	private void shareWithResolveInfo(ResolveInfo resInfo, Intent oldIntent)  {

		Intent newIntent = new Intent(android.content.Intent.ACTION_SEND);
		newIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		newIntent.setComponent(new ComponentName(resInfo.activityInfo.packageName, resInfo.activityInfo.name));
		newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		newIntent.setType("text/plain");
		newIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, oldIntent.getStringExtra(android.content.Intent.EXTRA_SUBJECT));
		newIntent.putExtra(android.content.Intent.EXTRA_TEXT, oldIntent.getStringExtra(android.content.Intent.EXTRA_TEXT));
		ctx.startActivity(newIntent);

	} // shareWithResolveInfo()



	/*
	 * For grabbing only ResovleInfos whose activities don't have the same
	 * package name as this one.
	 */
	private ResolveInfo[] getEligibleActivities(Intent intent) {
		List<ResolveInfo> candidates = ctx.getPackageManager().queryIntentActivities(intent, 0);
		ArrayList<ResolveInfo> eligibles = new ArrayList<ResolveInfo>();	

		for (ResolveInfo candidate : candidates) {
			if (!candidate.activityInfo.applicationInfo.className.equals(ctx.getApplicationInfo().className))
				eligibles.add(candidate);
		}

		return eligibles.toArray(new ResolveInfo[eligibles.size()]);
	} // getEligibleActivities



	/*
	 * Since we have to assign an array to a final variable in the thread above,
	 * if we want to do it all in one line, it has to be done inside a method.
	 * This is that method.
	 */
	private CharSequence[] getEligibleNames(ResolveInfo[] eligibles) {
		CharSequence[] names = new CharSequence[eligibles.length];
		for (int i = 0; i < names.length; i++) {
			names[i] = eligibles[i].activityInfo.loadLabel(ctx.getPackageManager());
		}
		return names;
	} // getEligivelNames()
}
