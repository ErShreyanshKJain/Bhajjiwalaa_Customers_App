package com.shreyanshjain.bhajjiwalaa_customers_app.cart;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.LayerDrawable;
import android.view.MenuItem;

public class CartCountSetClass extends Activity {
    private static LayerDrawable icon;

    public CartCountSetClass(){}

    public static void setAddToCart(Context context, MenuItem item, int numMessages)
    {
        icon=(LayerDrawable)item.getIcon();
        SetCartCount.setBadgeCount(context,icon, CartCountSetClass.setNotifyCount(numMessages));
    }

    public static int setNotifyCount(int numMessages) {
        int count=numMessages;
        return count;
    }

}
