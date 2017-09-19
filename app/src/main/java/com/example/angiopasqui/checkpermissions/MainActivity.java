package com.example.angiopasqui.checkpermissions;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainActivity extends Activity {
    public ListView listView;
    CustomAdapter customAdapter;
    App app;
    String packageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listApp);

        customAdapter = new CustomAdapter(this, R.layout.list_app, new ArrayList<App>());

        listView.setAdapter(customAdapter);

        PackageManager pm = getPackageManager();
        List<ApplicationInfo> apps = pm.getInstalledApplications(0);

        //GET APPS
        for (ApplicationInfo applicationInfo : apps)
        {
            if((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 1) {
                app = new App();
                app.setName((String) pm.getApplicationLabel(applicationInfo));
                Log.d("DEBUG", "NOME APP" + app.getName());
                app.setIcon(pm.getApplicationIcon(applicationInfo));
                app.setPackageName(applicationInfo.packageName);
                customAdapter.add(app);
            }
        }

        /*List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo info : packages) {
            Log.i("Info", "Installed package:" + info.packageName);
        }*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                App a = customAdapter.getItem(position);
                Intent i = new Intent(getApplicationContext(), AppDetail.class);
                i.putExtra("Nome app", a.getName());
                Log.d("DEBUG","COSSSSAA"+a.getName());
                Drawable s = a.getIcon();
                Bitmap bitmap = ((BitmapDrawable)s).getBitmap();
                i.putExtra("Icona app", bitmap);
                Log.d("DEBUG","SDASDS"+bitmap);
                i.putExtra("PACKAGE",a.getPackageName());
                Log.d("DEBUG","Pacchetto"+a.getPackageName());
                startActivity(i);
            }
        });
    }
}
