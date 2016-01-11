/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package recyclerview.androidcolormaster.util;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.lang.reflect.Field;

/**
 * Created by liuchen on 2016/1/11.
 */
public class ColorUtils {

    public enum ColorFilter{
        TRANSLATE,WHITE
    }

    /**
     * this is created by java ,deal with your bitmap pix
     * */
    public static Bitmap convertBitmapColor(Bitmap bitmap,int color,ColorFilter filter){

        /**
         * access to deal with point
         * */
        try {
            Field mIsMutable = Bitmap.class.getDeclaredField("mIsMutable");
            mIsMutable.setAccessible(true);
            mIsMutable.setBoolean(bitmap,true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        for (int i = 0; i < bitmapHeight; i++) {
            for (int j = 0; j < bitmapWidth; j++) {
                int singleColor = bitmap.getPixel(j,i);
                if(addFilter(singleColor,filter)){
                    continue;
                }else{
                    bitmap.setPixel(j, i, color);
                }
            }
        }
        return bitmap;
    }

    private static boolean addFilter(int singleColor,ColorFilter filter) {

        int a = Color.alpha(singleColor);
//        int r = Color.red(singleColor);
//        int g = Color.green(singleColor);
//        int b = Color.blue(singleColor);

        switch(filter){
            case TRANSLATE:
                if(a==0){
                    return true;
                }else{
                    break;
                }
            case WHITE:
                if(singleColor == 0xffffffff){
                    return true;
                }else{
                    break;
                }
        }
        return false;
    }


}
