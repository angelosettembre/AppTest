package com.example.angiopasqui.checkpermissions;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    public ListView listView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PackageManager pm = getPackageManager();
        List<ApplicationInfo> apps = pm.getInstalledApplications(0);

        listView = (ListView) findViewById(R.id.listApp);

        customAdapter = new CustomAdapter(this, R.layout.list_app, new ArrayList<App>());

        listView.setAdapter(customAdapter);

        for (ApplicationInfo applicationInfo : apps)
        {
            if((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 1){
                App a = new App();
                a.setName(applicationInfo.name);
                a.setIcon(pm.getApplicationIcon(applicationInfo));
                customAdapter.add(a);
            }
        }
    }
}
