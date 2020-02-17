package id.test.convert.changepixelimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.images);

        Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.testphoto);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int newWidth = (height > width) ? width : height;
        int newHeight = (height > width)? height - ( height - width) : height;
        int cropWidth = (width - height) / 2;
        cropWidth = (cropWidth < 0)? 0: cropWidth;
        int cropHeight = (height - width) / 2;
        cropHeight = (cropHeight < 0)? 0: cropHeight;
        Bitmap cropImg = Bitmap.createBitmap(bitmap, cropWidth, cropHeight, newWidth, newHeight);

        imageView.setImageBitmap(cropImg);
    }
}
