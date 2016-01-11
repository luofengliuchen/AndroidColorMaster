package recyclerview.androidcolormaster;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import recyclerview.androidcolormaster.util.ColorUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView demo = (ImageView) findViewById(R.id.iv_demo);
        ImageView demo2 = (ImageView) findViewById(R.id.iv_demo2);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.demo);
        Bitmap bitmap2 = bitmap.copy(bitmap.getConfig(), true);
        demo2.setImageBitmap(bitmap2);
        ColorUtils.convertBitmapColor(bitmap, 0xFFFF0000, ColorUtils.ColorFilter.TRANSLATE);
        demo.setImageBitmap(Bitmap.createBitmap(bitmap));
    }
}
