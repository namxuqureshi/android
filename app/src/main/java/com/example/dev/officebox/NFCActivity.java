package com.example.dev.officebox;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class NFCActivity extends Activity {


    final protected static char[] hexArray = {
            '0', '1', '2',
            '3', '4', '5',
            '6', '7', '8',
            '9', 'A', 'B',
            'C', 'D', 'E', 'F'
    };
    private NfcAdapter mNfcAdapter;

    @Override
    protected void onStart() {
        super.onStart();
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (!mNfcAdapter.isEnabled()) {
            Toast.makeText(getApplicationContext(), "Please activate NFC For Application to Read the TAG", Toast.LENGTH_LONG).show();
//            startActivity(new Intent(android.provider.Settings.ACTION_NFC_SETTINGS));
        }

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc);


        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (mNfcAdapter == null) {
            // Stop here, we definitely need NFC
            Toast.makeText(this, "This device doesn't support NFC.", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        if (!mNfcAdapter.isEnabled()) {
            Toast.makeText(getApplicationContext(), "Please activate NFC and press Back to return to the application!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(android.provider.Settings.ACTION_NFC_SETTINGS));
        }
        final TextView title = (TextView) findViewById(R.id.titleInBar);
        title.setText("NFC");

        handleIntent(getIntent());
    }


    @Override
    protected void onNewIntent(final Intent intent) {
        handleIntent(intent);
    }

    public static String bytesToHex(final byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        int v;
        final int bytes_length = bytes.length;// Moved  bytes.length call out of the loop to local variable bytes_length
        for (int j = 0; j < bytes_length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    private void handleIntent(final Intent intent) {
        String action = intent.getAction();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)) {
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            byte[] a = tag.getId();
            String ab = bytesToHex(a);

            final Intent i = new Intent(this, AddNewTagActivity.class);
            i.putExtra("TAG_ID", ab);
            startActivity(i);
            finish();
        }

    }

    /**
     * @param activity The corresponding {@link Activity} requesting the foreground dispatch.
     * @param adapter  The {@link NfcAdapter} used for the foreground dispatch.
     */
    public static void setupForegroundDispatch(final Activity activity, final NfcAdapter adapter) {
        final Intent intent = new Intent(activity.getApplicationContext(), activity.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        final PendingIntent pendingIntent = PendingIntent.getActivity(activity.getApplicationContext(), 0, intent, 0);

        IntentFilter[] filters = new IntentFilter[3];
        String[][] techList = new String[][]{};

//         Notice that this is the same filter as in our manifest.
        filters[0] = new IntentFilter();
        filters[0].addAction(NfcAdapter.ACTION_NDEF_DISCOVERED);
        filters[0].addCategory(Intent.CATEGORY_SELECTED_ALTERNATIVE);
//        filters[0].addDataType("");

        filters[1] = new IntentFilter();
        filters[1].addAction(NfcAdapter.ACTION_TAG_DISCOVERED);
        filters[1].addCategory(Intent.CATEGORY_SELECTED_ALTERNATIVE);
        filters[2] = new IntentFilter();
        filters[2].addAction(NfcAdapter.ACTION_TECH_DISCOVERED);
        filters[2].addCategory(Intent.CATEGORY_SELECTED_ALTERNATIVE);

        adapter.enableForegroundDispatch(activity, pendingIntent, filters, techList);
    }


    /**
     * @param activity The corresponding {@link Activity} requesting to stop the foreground dispatch.
     * @param adapter  The {@link NfcAdapter} used for the foreground dispatch.
     */
    public static void stopForegroundDispatch(final Activity activity, final NfcAdapter adapter) {
        adapter.disableForegroundDispatch(activity);
    }

    @Override
    protected void onResume() {

        setupForegroundDispatch(this, mNfcAdapter);
        super.onResume();


    }

    @Override
    protected void onPause() {

        stopForegroundDispatch(this, mNfcAdapter);

        super.onPause();
    }


    public void goBack(final View view) {
        super.onBackPressed();
    }
}
