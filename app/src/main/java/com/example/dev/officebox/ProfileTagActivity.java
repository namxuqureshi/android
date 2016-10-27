package com.example.dev.officebox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ProfileTagActivity extends NavigationActivity {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return super.onNavigationItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nav_profile);
        super.nav();
        Button friends, groups, tags;
        friends = (Button) findViewById(R.id.friends);
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(ProfileTagActivity.this, FriendListActivity.class);
                startActivity(n);

            }
        });
        groups = (Button) findViewById(R.id.groups);
        groups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(ProfileTagActivity.this, GroupsActivity.class);
                startActivity(n);

            }
        });
        tags = (Button) findViewById(R.id.tags);
        tags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(ProfileTagActivity.this, TagActivity.class);
                startActivity(n);

            }
        });
        TextView title=(TextView )findViewById(R.id.titleInBar);
        title.setText("Profile");
//        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
//        RoundedBitmapDrawable img = RoundedBitmapDrawableFactory.create(getResources(), String.valueOf(bitmap));
//        img.setCircular(true);
//
//        imageView.setImageDrawable(img);
//        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.asd);
//        Bitmap circularBitmap = ImageConverter.getRoundedCornerBitmap(bitmap, 100);

//        ImageView circularImageView = (ImageView) findViewById(R.id.imageView2);
//        circularImageView.setImageBitmap(circularBitmap);
    }


    @Override
    public void onBackPressed() {


        super.onBackPressed();
    }

//    public static class ImageConverter {
//
//        public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
//            Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
//            Canvas canvas = new Canvas(output);
//
//            final int color = 0xff424242;
//            final Paint paint = new Paint();
//            final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
//            final RectF rectF = new RectF(rect);
//            final float roundPx = pixels;
//
//            paint.setAntiAlias(true);
//            canvas.drawARGB(0, 0, 0, 0);
//            paint.setColor(color);
//            canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
//
//            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//            canvas.drawBitmap(bitmap, rect, rect, paint);
//
//            return output;
//        }
//    }
}
